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
    public void payBill(Bill bill){
        System.out.println("Paying bill with Bank Al Ahly:\n" + " Bill ID - " + bill.getId() + ", Amount - " + bill.getAmount());
        System.out.println("Bill paid successfully !\n");
    }

}
