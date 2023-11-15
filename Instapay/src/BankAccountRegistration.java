public class BankAccountRegistration extends RegistrationSystem {
    private final BankAPI bankAPI;

    public BankAccountRegistration(BankAPI type) {
        bankAPI = type;
    }

    public boolean verifyAccount(User user) {
        return bankAPI.verifyAccount(user.getMobileNumber(), user.getBankAccountNumber());
    }

}
