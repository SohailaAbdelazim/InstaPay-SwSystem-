public class BankAlAhly implements BankAPI{
    private User user;
    public boolean verifyAccount( String mobileNumber , String bankAccountNumber ){
        //fake verification.
        if(DatabaseFactory.getDatabase().verifyBankAccountNumber(bankAccountNumber)){ // should take mobile also!!
            return true;
        }
        else{
            return false ;
        }
    }
    public boolean transferMoney(String bankNumber, Double amount){
        // fake transfer :
        DatabaseFactory.getDatabase().incrementBankAccountBalance(bankNumber,amount);
        return true;
    }
    public boolean payBill(){
        return true;
    }

}
