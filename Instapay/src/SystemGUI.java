import java.sql.SQLOutput;
import java.util.Scanner;

public class SystemGUI {
    User user ;
    RegisterationSystem registerSystem ;
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
    private void bankRegister(){
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

        String walletNumber = null;
        Double balance = null ;
        user = new User( username,  mobileNumber, balance, address, name,  bankAcc, walletNumber);
        registerSystem.register(user,password);
        System.out.println("Registration successful! Welcome, " + username + "!");
        loggedMenu();
    }
    private void walletRegister(){
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
        String walletNumber = input.nextLine();

        String bankAcc = null;
        Double balance = null ;
        user = new User( username,  mobileNumber, balance, address, name,  bankAcc, walletNumber);
        registerSystem.register(user,password);

        System.out.println("Registration successful! Welcome, " + username + "!");
        loggedMenu();
    }

    private void payBillMethod(){
    }

    private void login(){}

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

            } else if (choice == 2) {

            } else if (choice == 3) {

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
        }
    }
}
