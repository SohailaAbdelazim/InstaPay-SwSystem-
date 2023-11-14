public interface WalletProvider {
    public boolean verifyWallet(String mobileNumber);

    public boolean transferMoney(String transferredAccount, Double amount);

    public void payBill(Bill bill);
}
