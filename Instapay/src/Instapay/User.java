package Instapay;

public class User {
    private String username;
    private String mobileNumber;
    private Double balance;
    private String address;
    private String name;
    private String bankAccountNumber;
    private String walletNumber;

    public void deductAmount(Double amount) {
        balance -= amount;
    }

    public Boolean compareBalance(Double amount) {
        return balance >= amount;
    }

    public User(String username, String mobileNumber, Double balance, String address, String name, String bankAccountNumber, String walletNumber) {
        this.username = username;
        this.mobileNumber = mobileNumber;
        this.balance = balance;
        this.address = address;
        this.name = name;
        this.bankAccountNumber = bankAccountNumber;
        this.walletNumber = walletNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public String getWalletNumber() {
        return walletNumber;
    }
}
