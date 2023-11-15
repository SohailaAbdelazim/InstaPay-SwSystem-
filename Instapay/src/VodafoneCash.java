import javax.xml.crypto.Data;

public class VodafoneCash implements WalletProvider {
    User user;

    public boolean verifyWallet(String mobileNumber) {
        //fake verification.
        if (DatabaseFactory.getDatabase().verifyWalletNumber(mobileNumber)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean transferMoney(String userNumber, Double amount) {
        // fake transfer :
        DatabaseFactory.getDatabase().incrementWalletBalance(userNumber, amount);
        return true;
    }

    public boolean payBill(Bill bill) {
        // Check if the user has enough balance to pay the bill
        if (!user.compareBalance(bill.getAmount())) {
            System.out.println("You don't have enough balance to pay this bill");
            return false;
        }
        // Deduct the bill amount from the user balance
        user.deductAmount(bill.getAmount());
        // Update the bill status to paid
        bill.setStatus("Paid");
        // Print the bill
        bill.printBill();

        return true;
    }


}
