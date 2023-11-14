import javax.xml.crypto.Data;

public class VodafoneCash implements WalletProvider {
    User user;
    public boolean verifyWallet( String mobileNumber){
        //fake verification.
        if(DatabaseFactory.getDatabase().verifyWalletNumber(mobileNumber)){
            return true;
        }
        else{
            return false ;
        }
    }
    public boolean transerMoney(String userNumber, Double amount){
        // fake transfer :
<<<<<<< Updated upstream
       return true;
        //System.out.println("Transferring money with Bank Al Ahly:\n" + " Wallet Number - " + userNumber + ", Amount - " + amount);
=======
        DatabaseFactory.getDatabase().incrementWalletBalance(userNumber,amount);
        return true;
>>>>>>> Stashed changes
    }
    public void payBill(Bill bill){
        bill.payBill(user);
    }
}
