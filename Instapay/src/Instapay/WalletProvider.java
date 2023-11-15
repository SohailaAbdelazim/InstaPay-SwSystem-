package Instapay;

public interface WalletProvider {
    public boolean verifyWallet(String mobileNumber);

    public boolean transferMoney(String transferredAccount, Double amount);

    public boolean payBill(User user);
}
