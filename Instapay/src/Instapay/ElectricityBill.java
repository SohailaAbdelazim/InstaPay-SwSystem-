package Instapay;

public class ElectricityBill extends Bill {
    private String accountNumber;

    public ElectricityBill(int id, String date, String status, Double consumption, String accountNumber) {
        super(id, date, status, consumption);
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
