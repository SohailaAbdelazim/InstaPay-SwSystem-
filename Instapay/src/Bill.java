public abstract class Bill {
    private int id;
    private Double amount;
    private String date;
    private String type;
    private String status;
    private Double consumption;

    public Bill(int id, Double amount, String date, String type, String status, Double consumption) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.type = type;
        this.status = status;
        this.consumption = consumption;
    }

    public Bill() {}

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

    public void setAmount(Double amount) {
        this.amount = amount;
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
