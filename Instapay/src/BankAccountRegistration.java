public class BankAccountRegistration extends RegisterationSystem{
    private BankAPI bankAPI;

    public BankAccountRegistration( BankAPI type){
        bankAPI = type;
    }

    public  boolean verifyAccount(User user){
        return bankAPI.verifyAccount(user.getBankAccountNumber(), user.getMobileNumber());
    }

}
