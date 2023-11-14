public abstract class TransferringMethod {
    public boolean transfer(User user, Double amount, String transferrerAccount) {
        if (!user.compareBalance(amount)) return false;
        boolean isSuccess = callTransferringMethod(transferrerAccount, amount);
        if (!isSuccess) return false;
        user.deductAmount(amount);
        DatabaseFactory.getDatabase().updateUserBalance(user);
        return true;
    }

    protected abstract boolean callTransferringMethod(String transferrerAccount, Double amount);
}
