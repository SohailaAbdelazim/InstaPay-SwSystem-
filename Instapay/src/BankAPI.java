public interface BankAPI {
    public boolean verifyAccount( String mobileNumber , String bankAccountNumber );
    public void transerMoney(String bankNumber, Double amount);
    public void payBill(Bill bill);
}
