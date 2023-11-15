package Instapay;

public class VodafoneCash implements WalletProvider {
    User user;

    public boolean verifyWallet(String mobileNumber) {
        //fake verification.
        if (DatabaseFactory.getDatabase().verifyWalletNumber(mobileNumber)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean transferMoney(String userNumber, Double amount) {
        // fake transfer :
        return DatabaseFactory.getDatabase().incrementWalletBalance(userNumber, amount);
    }

    public boolean payBill(User user) {
        // Fake payment
        DatabaseFactory.getDatabase().updateUserBalance(user);
        return true;
    }
}
