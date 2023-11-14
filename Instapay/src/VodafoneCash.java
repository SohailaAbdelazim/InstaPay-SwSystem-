import javax.xml.crypto.Data;

public class VodafoneCash implements WalletProvider {
    User user;

    public boolean verifyWallet(String mobileNumber) {
        //fake verification.
        if(DatabaseFactory.getDatabase().verifyWalletNumber(mobileNumber)){
            return true;
        }
        else{
            return false ;
        }
    }

    public boolean transferMoney(String userNumber, Double amount) {
        // fake transfer :
        DatabaseFactory.getDatabase().incrementWalletBalance(userNumber,amount);
        return true;
    }

    public void payBill(Bill bill) {
        bill.payBill(user);
    }
}
