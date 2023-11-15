package Instapay;

public abstract class Bill {
    private int id;
    private Double amount;
    private String date;
    private String status;
    private Double consumption;

    public Bill(int id, String date, String status, Double consumption) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.consumption = consumption;
    }

    public Bill() {
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
}
