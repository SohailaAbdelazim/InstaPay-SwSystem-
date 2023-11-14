public class BankTransferring extends TransferringMethod{
    @Override
    protected boolean callTransferringMethod(String transferrerAccount, Double amount) {
        return false;
    }
}
