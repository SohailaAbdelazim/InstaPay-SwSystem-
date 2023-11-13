public interface WalletProvider {
    public boolean verifyWallet( String mobileNumber);
    public boolean transerMoney(String userNumber, Double amount);
    public void payBill(Bill bill);
}
