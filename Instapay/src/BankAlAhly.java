public class BankAlAhly implements BankAPI{
    private User user;
    public boolean verifyAccount( String mobileNumber , String bankAccountNumber ){
        //fake verification.
        if (mobileNumber != null && !mobileNumber.isEmpty() && bankAccountNumber != null && !bankAccountNumber.isEmpty()) {
            System.out.println("Account verified successfully !\n");
            return true;
        } else {
            System.out.println("Unverified account!\n");
            return false;
        }
    }
    public void transerMoney(String bankNumber, Double amount){
        // fake transfer :
        System.out.println("Transferring money with Bank Al Ahly:\n" +
                " Bank Number - " + bankNumber + ", Amount - " + amount);
    }
    public void payBill(Bill bill){
        bill.payBill(user);
    }
}
