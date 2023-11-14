public class InstapayTransferring extends TransferringMethod{
    @Override
    protected boolean callTransferringMethod(String transferrerAccount, Double amount) {
        Database database = DatabaseFactory.getDatabase();
        boolean isTransferrerExists = !database.checkUniqueUser(transferrerAccount);
        if(!isTransferrerExists) return false;
        database.incrementUserBalance(transferrerAccount, amount);
        // call api
        return false;
    }
}
