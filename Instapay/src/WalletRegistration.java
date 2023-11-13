public class WalletRegistration extends RegisterationSystem{

    private walletProvider walletProvider;
    public  boolean verifyAccount(User user){
        return walletProvider.verifyWallet(user.getMobileNumber());
    }
}
