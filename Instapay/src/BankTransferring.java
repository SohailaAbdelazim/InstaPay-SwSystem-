public class BankTransferring extends TransferringMethod{
    BankAPI bankAPI;

    public BankTransferring(BankAPI bankAPI) {
        this.bankAPI = bankAPI;
    }
    @Override
    protected boolean callTransferringMethod(String transferredAccount, Double amount) {
        return bankAPI.transferMoney(transferredAccount, amount);
    }
}
