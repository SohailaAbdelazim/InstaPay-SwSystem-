public class WalletRegistration extends RegisterationSystem{

    private WalletProvider walletProvider;

    public WalletRegistration(WalletProvider type){
        walletProvider = type ;
    }
    public  boolean verifyAccount(User user){
        return walletProvider.verifyWallet(user.getMobileNumber());
    }
}
