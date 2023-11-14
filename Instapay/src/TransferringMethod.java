public abstract class TransferringMethod {
    public boolean transfer(User user, Double amount, String transferredAccount) {
        if (!user.compareBalance(amount)) return false;
        boolean isSuccess = callTransferringMethod(transferredAccount, amount);
        if (!isSuccess) return false;
        user.deductAmount(amount);
        DatabaseFactory.getDatabase().updateUserBalance(user);
        return true;
    }

    protected abstract boolean callTransferringMethod(String transferredAccount, Double amount);
}
