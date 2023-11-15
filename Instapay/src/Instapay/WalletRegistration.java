package Instapay;

public class WalletRegistration extends RegistrationSystem {

    private final WalletProvider walletProvider;

    public WalletRegistration(WalletProvider type) {
        walletProvider = type;
    }

    public boolean verifyAccount(User user) {
        return walletProvider.verifyWallet(user.getMobileNumber());
    }
}
