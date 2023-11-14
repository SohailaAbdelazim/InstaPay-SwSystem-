public class BankAlAhly implements BankAPI{
    private User user;
    public boolean verifyAccount( String mobileNumber , String bankAccountNumber ){
        //fake verification.
        if (mobileNumber != null && !mobileNumber.isEmpty() && bankAccountNumber != null && !bankAccountNumber.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    public boolean transferMoney(String bankNumber, Double amount){
        // fake transfer :
        //System.out.println("Transferring money with Bank Al Ahly:\n" +n" Bank Number - " + bankNumber + ", Amount - " + amount);
        return true;
    }
    public void payBill(Bill bill){
        bill.payBill(user);
    }
}
