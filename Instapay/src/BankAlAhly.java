public class BankAlAhly implements BankAPI {
    private User user;

    public boolean verifyAccount(String mobileNumber, String bankAccountNumber) {
        //fake verification.
        if (DatabaseFactory.getDatabase().verifyBankAccountNumber(bankAccountNumber, mobileNumber)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean transferMoney(String bankNumber, Double amount) {
        // fake transfer :
        DatabaseFactory.getDatabase().incrementBankAccountBalance(bankNumber, amount);
        return true;
    }

    public boolean payBill(User user) {
        // Fake payment
        DatabaseFactory.getDatabase().updateUserBalance(user);
        return true;
    }

}
