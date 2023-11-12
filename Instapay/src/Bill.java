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

   private boolean verifyBillDetails(){
        return true;
   }

    private Double calculateBillAmount() {
        return 0.0;
    }

    public void payBill(){}

    public void printBill(){}


}
