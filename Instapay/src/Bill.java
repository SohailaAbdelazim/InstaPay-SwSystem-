import java.time.LocalDate;
import java.time.format.DateTimeParseException;
public abstract class Bill {
    int id;
    Double amount;
    String date;
    String type;
    String status;
    Double consumption;

    public Bill(int id, Double amount, String date, String type, String status, Double consumption) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.type = type;
        this.status = status;
        this.consumption = consumption;
    }

    public int getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public Double getConsumption() {
        return consumption;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   private boolean verifyBillDetails(){
       try {
           LocalDate billDate = LocalDate.parse(date);
           if (billDate.isBefore(LocalDate.now())) {
               // Date has passed
               return false;
           }
       } catch (DateTimeParseException e) {
           // Invalid date format
           return false;
       }

       // Check if the status is not paid
       if ("Paid".equalsIgnoreCase(status)) {
           return false;
       }

       // If all conditions pass, the bill details are considered valid
       return true;

   }

    protected abstract Double calculateBillAmount();


    public void payBill(User user){
        if (verifyBillDetails()) {
            // Calculate the bill amount
            amount = calculateBillAmount();
            // Print the bill
            printBill();
            // Check if the user has enough balance to pay the bill
            if(!user.compareBalance(amount)){
                System.out.println("You don't have enough balance to pay this bill");
                return;
            }
            // Deduct the bill amount from the user balance
            user.deductAmount(amount);
            // Update the bill status to "Paid"
            status = "Paid";
            // Print the updated bill details
            printBill();

        } else {
            System.out.println("Bill cannot be paid due to invalid details");
        }

    }

    public void printBill(){
        System.out.println("Bill ID: " + id);
        System.out.println("Bill Amount: " + amount);
        System.out.println("Bill Date: " + date);
        System.out.println("Bill Type: " + type);
        System.out.println("Bill Status: " + status);
        System.out.println("Bill Consumption: " + consumption);
    }
}
