public class InstapayTransferring extends TransferringMethod{
    @Override
    protected boolean callTransferringMethod(String transferredAccount, Double amount) {
        Database database = DatabaseFactory.getDatabase();
        boolean isTransferrerExists = !database.checkUniqueUser(transferredAccount);
        if(!isTransferrerExists) return false;
        database.incrementUserBalance(transferredAccount, amount);
        // call api
        return false;
    }
}
