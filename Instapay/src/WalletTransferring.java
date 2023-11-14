public class WalletTransferring extends TransferringMethod{

    WalletProvider walletProvider;

    public WalletTransferring(WalletProvider walletProvider) {
        this.walletProvider = walletProvider;
    }
    @Override
    protected boolean callTransferringMethod(String transferredAccount, Double amount) {
        return walletProvider.transferMoney(transferredAccount, amount);
    }
}
