public class WalletTransferring extends TransferringMethod{
    @Override
    protected boolean callTransferringMethod(String transferrerAccount, Double amount) {
        return false;
    }
}
