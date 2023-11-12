public class VodafoneCash implements walletProvider{
    User user;
    public boolean verifyWallet( String mobileNumber){
        return false;
    }
    public void transerMoney(String userNumber, Double amount){

    }
    public void payBill(Bill bill){
        bill.payBill(user);
    }
}
