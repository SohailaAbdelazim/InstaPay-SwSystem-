package Instapay;

public class InstapayTransferring extends TransferringMethod {
    @Override
    protected boolean callTransferringMethod(String transferredAccount, Double amount) {
        Database database = DatabaseFactory.getDatabase();
        boolean isTransferredAccountExists = !database.checkUniqueUser(transferredAccount);
        if (!isTransferredAccountExists) return false;
        database.incrementUserBalance(transferredAccount, amount);
        return true;
    }
}
