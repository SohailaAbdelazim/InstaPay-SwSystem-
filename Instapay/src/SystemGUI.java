import java.sql.SQLOutput;
import java.util.*;

public class SystemGUI {
    User user ;
    public SystemGUI(){
        user = null;
    }
    private void registerMethod(){
        while(true) {
            System.out.println("Welcome to InstaPay Application!\n" +
                    "Please Choose the Registration Method" +
                    "1- Register with Bank Account \n" +
                    "2- Register with Wallet\n");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
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
        RegisterationSystem registerSystem;
        Scanner input = new Scanner(System.in);
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

        System.out.println("Enter your Bank Account Number: ");
        String bankAcc = input.nextLine();

        // faking different wallets in coming phases.
        System.out.println("Choose your Bank Name: \n" +
                "1- AlAhly Bank\n");
        String type = input.nextLine();

        String walletNumber = null;
        Double balance = null;
        user = new User(username, mobileNumber, balance, address, name, bankAcc, walletNumber);
        registerSystem = new BankAccountRegistration(new BankAlAhly());
        if (registerSystem.register(user, password)) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Registration Failed!");
        }
    }
    private void walletRegister(){
        RegisterationSystem registerSystem;

        Scanner input = new Scanner(System.in);
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

        // faking different wallets in coming phases.
        System.out.println("Choose your wallet Name: \n" +
                "1- Vodafone Cash\n");
        String type = input.nextLine();

        String bankAcc = null;
        Double balance = null ;
        user = new User( username,  mobileNumber, balance, address, name,  bankAcc, walletNumber);
        registerSystem= new WalletRegistration(new VodafoneCash());
        if(registerSystem.register(user,password)) {
            System.out.println("Registration successful!");
        }
        else{
            System.out.println("Registration Failed!");

        }
    }

    private void payBillMethod(){
    }

    private void login(){
        System.out.println("Pleas Enter Your Username");
        Scanner input = new Scanner(System.in);
        String username = input.nextLine();
        System.out.println("Pleas Enter Your Password");
        String password = input.nextLine();
        SignIn user = new SignIn();
        user.signIn(username,password);
    }

    private void instaTransfer(){
        InstapayTransferring transfer = new InstapayTransferring();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the username of the receiver:\n");
        String username = input.nextLine();
        System.out.println("Enter the amount to transfer:\n");
        Double amount = input.nextDouble();
        if(transfer.callTransferringMethod(username,amount)){
            System.out.println(amount+".EG" + "  is Transferred to" + username + "successfully!");
        }
        else{
            System.out.println("Transferring failed");

        }
    }
    private void bankTransfer(){
        BankTransferring transfer = new BankTransferring();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Bank account of the receiver:\n");
        String username = input.nextLine();
        System.out.println("Enter the amount to transfer:\n");
        Double amount = input.nextDouble();
        if(transfer.callTransferringMethod(username,amount)){
            System.out.println(amount+".EG" + "  is Transferred to" + username + "successfully!");
        }
        else{
            System.out.println("Transferring failed");
        }
    }
    private void walletTransfer(){
        WalletTransferring transfer = new WalletTransferring();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the wallet number of the receiver:\n");
        String username = input.nextLine();
        System.out.println("Enter the amount to transfer:\n");
        Double amount = input.nextDouble();
        if(transfer.callTransferringMethod(username,amount)){
            System.out.println(amount+".EG" + "  is Transferred to" + username + "successfully!");
        }
        else{
            System.out.println("Transferring failed");

        }
    }

    private void loggedMenu() {
        while(true){
            System.out.println("Welcome to InstaPay Application!\n" +
                    "What would you like to do today?\n " +
                    "1- Transfer to Wallet using the mobile number\n" +
                    "2- Transfer to Another instapay account\n" +
                    "3- Transfer to Bank Account using the account number\n" +
                    "4- Inquire about your balance\n" +
                    "5- Pay bills\n");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            if (choice == 1) {
                walletTransfer();
            } else if (choice == 2) {
                instaTransfer();
            } else if (choice == 3) {
                bankTransfer();
            } else if (choice == 4) {
                System.out.println("Your current balance is : " + user.getBalance() + "EG");
            } else if (choice == 5) {

            } else {
                System.out.println("Wrong Choice");
            }
        }
    }
    private void unLoggedMenu(){
        while(true) {
            System.out.println("Welcome to InstaPay Application!\n" +
                    "Please Register or Login to use our Application\n " +
                    "1- Register \n" +
                    "2- Login\n");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            if (choice == 1) {
                registerMethod();
                break;
            } else if (choice == 2) {
                login();
                break;
            } else {
                System.out.println("Wrong Choice");
            }
        }
    }

    public void displayMenu(){
        while (true){
            if(user == null){
                unLoggedMenu();
            }
            else{
                loggedMenu();
            }
        }
    }
}
