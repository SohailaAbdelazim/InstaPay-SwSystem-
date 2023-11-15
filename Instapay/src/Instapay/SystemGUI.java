package Instapay;

import java.util.*;

public class SystemGUI {
    private User user;
    private final Scanner input;

    public SystemGUI() {
        user = null;
        input = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("-".repeat(40));
            if (user == null) {
                unLoggedMenu();
            } else {
                loggedMenu();
            }
        }
    }

    private void unLoggedMenu() {
        System.out.println("""
                Welcome to InstaPay Application!
                Please Register or Login to use our Application
                1- Register
                2- Login
                3- Exit""");
        int choice = input.nextInt();
        neglectNewLineInScanner();

        if (choice == 1) {
            registerMethod();
        } else if (choice == 2) {
            login();
        } else if (choice == 3) {
            System.exit(0);
        } else {
            System.out.println("Wrong Choice");
        }
    }

    private void registerMethod() {
        while (true) {
            System.out.println("""
                    Welcome to InstaPay Application!
                    Please Choose the Registration Method
                    1- Register with Bank Account
                    2- Register with Wallet""");
            int choice = input.nextInt();
            neglectNewLineInScanner();

            if (choice == 1) {
                bankRegister();
                break;
            } else if (choice == 2) {
                walletRegister();
                break;
            } else {
                System.out.println("Wrong Choice");
            }
        }
    }

    private void bankRegister() {
        RegistrationSystem registerSystem;
        System.out.println("Enter your Name: ");
        String name = input.nextLine();

        System.out.println("Enter your username: ");
        String username = input.nextLine();

        System.out.println("Enter your password: ");
        String password = input.nextLine();
        while (!FormattingValidation.checkPassword(password)) {
            System.out.println("Enter strong password (at least: 1 uppercase, 1 lowercase, 1 digit, and all at least 6 characters");
            password = input.nextLine();
        }

        System.out.println("Enter your mobile number: ");
        String mobileNumber = input.nextLine();
        while (!FormattingValidation.checkMobileNumber(mobileNumber)) {
            System.out.println("Enter correct mobile number (It must start with eiter 011,012,015,010 and should be 11 digits in total)");
            mobileNumber = input.nextLine();
        }

        System.out.println("Enter your address: ");
        String address = input.nextLine();

        System.out.println("Enter your Bank Account Number: ");
        String bankAcc = input.nextLine();

        User registeredUser = new User(username, mobileNumber, null, address, name, bankAcc, null);

        // faking different wallets in coming phases.
        System.out.println("Choose your Bank Name: \n" +
                "1- AlAhly Bank");
        int bankType = input.nextInt();
        neglectNewLineInScanner();
        if (bankType == 1) {
            registerSystem = new BankAccountRegistration(new BankAlAhly());
        } else {
            registerSystem = new BankAccountRegistration(new BankAlAhly());
        }

        int correctOTP = registerSystem.sendOTP(mobileNumber);

        // OTP is 1234
        System.out.println("OTP send to " + mobileNumber + ": ");
        int userOTP = input.nextInt();
        neglectNewLineInScanner();

        if (userOTP != correctOTP) {
            System.out.println("Invalid mobile number to send OTP");
            return;
        }

        if (registerSystem.register(registeredUser, password)) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Registration Failed!");
        }
    }

    private void walletRegister() {
        RegistrationSystem registerSystem;

        System.out.println("Enter your Name: ");
        String name = input.nextLine();

        System.out.println("Enter your username: ");
        String username = input.nextLine();

        System.out.println("Enter your password: ");
        String password = input.nextLine();

        System.out.println("Enter your mobile number: ");
        String mobileNumber = input.nextLine();

        System.out.println("Enter your address: ");
        String address = input.nextLine();

        System.out.println("Enter your wallet Number: ");
        String walletNumber = input.nextLine();
        String bankAcc = null;
        Double balance = null;
        User registeredUser = new User(username, mobileNumber, balance, address, name, bankAcc, walletNumber);

        // faking different wallets in coming phases.
        System.out.println("Choose your wallet Name: \n" +
                "1- Vodafone Cash");
        int walletType = input.nextInt();
        neglectNewLineInScanner();

        if (walletType == 1) {
            registerSystem = new WalletRegistration(new VodafoneCash());
        } else {
            registerSystem = new WalletRegistration(new VodafoneCash());
        }

        int correctOTP = registerSystem.sendOTP(mobileNumber);

        // OTP is 1234
        System.out.println("OTP send to " + mobileNumber + ": ");
        int userOTP = input.nextInt();
        neglectNewLineInScanner();

        if (userOTP != correctOTP) {
            System.out.println("Invalid mobile number to send OTP");
            return;
        }

        if (registerSystem.register(registeredUser, password)) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Registration Failed!");
        }
    }

    private void login() {
        System.out.println("Pleas Enter Your Username: ");
        String username = input.nextLine();
        System.out.println("Pleas Enter Your Password: ");
        String password = input.nextLine();
        SignIn signIn = new SignIn();
        User user = signIn.signIn(username, password);

        if (user == null) {
            System.out.println("Instapay.User doesn't exist!");
        } else {
            System.out.println("Successfully login!");
            this.user = user;
        }
    }

    private void loggedMenu() {
        System.out.println("Welcome " + user.getName());
        System.out.println("""
                What would you like to do today?
                1- Transfer to Wallet using the mobile number
                2- Transfer to Another Instapay account""");
        if (user.getWalletNumber() != null) {
            showUserWalletAccountOptions();
        } else {
            showUserBankAccountOption();
        }
    }

    private void showUserWalletAccountOptions() {
        System.out.println("""
                3- Inquire about your balance
                4- Pay bills
                5- Exit""");
        int choice = input.nextInt();
        neglectNewLineInScanner();
        if (choice == 1) {
            walletTransfer();
        } else if (choice == 2) {
            instaTransfer();
        } else if (choice == 3) {
            printUserBalance();
        } else if (choice == 4) {
            payBillMethod();
        } else if (choice == 5) {
            System.exit(0);
        } else {
            System.out.println("Wrong Choice");
        }
    }

    private void showUserBankAccountOption() {
        System.out.println("""
                3- Transfer to Bank Account using the account number
                4- Inquire about your balance
                5- Pay bills
                6- Exit""");
        int choice = input.nextInt();
        neglectNewLineInScanner();
        if (choice == 1) {
            walletTransfer();
        } else if (choice == 2) {
            instaTransfer();
        } else if (choice == 3) {
            bankTransfer();
        } else if (choice == 4) {
            printUserBalance();
        } else if (choice == 5) {
            payBillMethod();
        } else if (choice == 6) {
            System.exit(0);
        } else {
            System.out.println("Wrong Choice");
        }
    }

    private void walletTransfer() {
        TransferringMethod transferringMethod = getWalletTransferringType();
        transferMoney(transferringMethod);
    }

    private TransferringMethod getWalletTransferringType() {
        System.out.println("Which wallet name you want to use?\n" +
                "1- Vodafone Cash");
        String walletType = input.nextLine();
        while (walletType.compareTo("1") > 0) {
            System.out.println("Enter the correct choice");
            walletType = input.nextLine();
        }
        if (walletType.equals("1")) {
            return new WalletTransferring(new VodafoneCash());
        } else {
            return new WalletTransferring(new VodafoneCash());
        }
    }

    private void instaTransfer() {
        TransferringMethod transferringMethod = new InstapayTransferring();
        transferMoney(transferringMethod);
    }

    private void bankTransfer() {
        TransferringMethod transferringMethod = getBankTransferringType();
        transferMoney(transferringMethod);
    }

    private TransferringMethod getBankTransferringType() {
        System.out.println("Which bank name you want to use?\n" +
                "1- Al-Ahly Bank");
        String bankName = input.nextLine();
        while (bankName.compareTo("1") > 0) {
            System.out.println("Enter the correct choice");
            bankName = input.nextLine();
        }
        if (bankName.equals("1")) {
            return new BankTransferring(new BankAlAhly());
        } else {
            return new BankTransferring(new BankAlAhly());
        }
    }

    private void transferMoney(TransferringMethod transferringMethod) {
        System.out.println("Enter the (username/transferred number) of the receiver:");
        String username = input.nextLine();

        System.out.println("Enter the amount to transfer:\n");
        Double amount = input.nextDouble();
        neglectNewLineInScanner();

        if (transferringMethod.transfer(this.user, amount, username)) {
            System.out.println(amount + ".EG" + "  is Transferred to " + username + " successfully!");
            printUserBalance();
        } else {
            System.out.println("Transferring failed");
        }
    }

    private void printUserBalance() {
        double userBalance = Math.round(user.getBalance() * 100) / 100.0;
        System.out.println("Your current balance is : " + userBalance + "EG");
    }

    private void payBillMethod() {
        while (true) {
            System.out.println("""
                    Welcome to InstaPay Application!
                    Please Choose the Instapay.Bill Type you want to pay
                    1- Electricity Instapay.Bill\s
                    2- Water Instapay.Bill
                    3- Gas Instapay.Bill""");
            int choice = input.nextInt();
            neglectNewLineInScanner();

            if (user.getBankAccountNumber() != null) {
                BankAPI bankAPI = new BankAlAhly(); // Must be modified in the future
                if (choice == 1) {
                    payBillThroughBank(bankAPI, new ElectricityBillPayment());
                    break;
                } else if (choice == 2) {
                    payBillThroughBank(bankAPI, new WaterBillPayment());
                    break;
                } else if (choice == 3) {
                    payBillThroughBank(bankAPI, new GasBillPayment());
                    break;
                } else {
                    System.out.println("Wrong Choice");
                }
            } else {
                WalletProvider walletProvider = new VodafoneCash(); // Must be modified in the future
                if (choice == 1) {
                    payBillThroughWallet(walletProvider, new ElectricityBillPayment());
                    break;
                } else if (choice == 2) {
                    payBillThroughWallet(walletProvider, new WaterBillPayment());
                    break;
                } else if (choice == 3) {
                    payBillThroughWallet(walletProvider, new GasBillPayment());
                    break;
                } else {
                    System.out.println("Wrong Choice");
                }
            }
        }
    }

    private void payBillThroughBank(BankAPI bankAPI, BillPayment billPaymentType) {
        Bill bill = billPaymentType.payBill(user);
        if (bill != null) {
            bankAPI.payBill(user);
            printBill(bill);
        } else {
            System.out.println("Failed to pay the bill");
        }
    }

    private void payBillThroughWallet(WalletProvider walletProvider, BillPayment billPaymentType) {
        Bill bill = billPaymentType.payBill(user);
        if (bill != null) {
            walletProvider.payBill(user);
            printBill(bill);
        } else {
            System.out.println("Failed to pay the bill");
        }
    }

    private void printBill(Bill bill) {
        System.out.println("Successfully payment!");
        System.out.println("Instapay.Bill ID: " + bill.getId());
        System.out.println("Instapay.Bill Amount: " + bill.getAmount());
        System.out.println("Instapay.Bill Date: " + bill.getDate());
        System.out.println("Instapay.Bill Status: " + bill.getStatus());
        System.out.println("Instapay.Bill Consumption: " + bill.getConsumption());
        printUserBalance();
    }

    private void neglectNewLineInScanner() {
        input.nextLine();
    }

}
