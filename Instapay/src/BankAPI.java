public interface BankAPI {
    public boolean verifyAccount(String mobileNumber, String bankAccountNumber);

    public boolean transferMoney(String transferredAccount, Double amount);

    public void payBill(Bill bill);
}
