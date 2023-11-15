package Instapay;

public class WaterBill extends Bill {
    private String accountNumber;

    public WaterBill(int id, String date, String status, Double consumption, String accountNumber) {
        super(id, date, status, consumption);
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
