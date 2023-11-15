public class BankAccountRegistration extends RegisterationSystem {
    private final BankAPI bankAPI;

    public BankAccountRegistration(BankAPI type) {
        bankAPI = type;
    }

    public boolean verifyAccount(User user) {
        return bankAPI.verifyAccount(user.getBankAccountNumber(), user.getMobileNumber());
    }

}
