public class VodafoneCash implements walletProvider{
    User user;
    public boolean verifyWallet( String mobileNumber){
        //fake verification.
        if (mobileNumber != null && !mobileNumber.isEmpty()) {
            System.out.println("Account verified successfully !\n");
            return true;
        } else {
            System.out.println("Unverified account!\n");
            return false;
        }
        return false;
    }
    public void transerMoney(String userNumber, Double amount){
        // fake transfer :
        System.out.println("Transferring money with Bank Al Ahly:\n" +
                " Wallet Number - " + userNumber + ", Amount - " + amount);
    }
    public void payBill(Bill bill){
        bill.payBill(user);
    }
}
