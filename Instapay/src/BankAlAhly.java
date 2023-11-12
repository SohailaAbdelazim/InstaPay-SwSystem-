public class BankAlAhly implements BankAPI{
    private User user;
    public boolean verifyAccount( String mobileNumber , String bankAccountNumber ){
        return true ;
    }
    public void transerMoney(String bankNumber, Double amount){

    }
    public void payBill(Bill bill){
        bill.payBill(user);
    }
}
