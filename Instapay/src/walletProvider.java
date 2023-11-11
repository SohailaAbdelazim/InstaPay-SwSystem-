public interface walletProvider {
    public boolean verifyWallet( String mobileNumber);
    public void transerMoney(String userNumber, Double amount);
    public void payBill(Bill bill);
}
