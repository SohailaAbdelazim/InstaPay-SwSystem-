public class VodafoneCash implements WalletProvider {
    User user;
    public boolean verifyWallet( String mobileNumber){
        //fake verification.
        if (mobileNumber != null && !mobileNumber.isEmpty()) {
            //System.out.println("Account verified successfully !\n");
            return true;
        } else {
            //System.out.println("Unverified account!\n");
            return false;
        }
    }
    public boolean transerMoney(String userNumber, Double amount){
        // fake transfer :
       return true;
        //System.out.println("Transferring money with Bank Al Ahly:\n" + " Wallet Number - " + userNumber + ", Amount - " + amount);
    }
    public void payBill(Bill bill) {
        System.out.println("Paying bill with Vodafone Cash:\n" + " Bill ID - " + bill.getId() + ", Amount - " + bill.getAmount());
        System.out.println("Bill paid successfully !\n");
    }
}
