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
        DatabaseFactory.getDatabase().incrementWalletBalance(userNumber, amount);
        return true;
    }

    public boolean payBill(User user) {
        // Fake payment
        DatabaseFactory.getDatabase().updateUserBalance(user);
        return true;
    }
}