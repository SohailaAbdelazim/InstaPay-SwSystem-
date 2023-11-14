public interface BankAPI {
    public boolean verifyAccount(String mobileNumber, String bankAccountNumber);

    public boolean transferMoney(String transferredAccount, Double amount);

    public boolean payBill(Bill bill);
}
