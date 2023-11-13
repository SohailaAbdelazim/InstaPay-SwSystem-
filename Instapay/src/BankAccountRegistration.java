public class BankAccountRegistration extends RegisterationSystem{
    private BankAPI bankAPI;

    public  boolean verifyAccount(User user){
        return bankAPI.verifyAccount(user.getBankAccountNumber(), user.getMobileNumber());
    }

}
