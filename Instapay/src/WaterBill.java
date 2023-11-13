public class WaterBill extends Bill{
    private String accountNumber;

    public WaterBill(int id, Double amount, String date, String type, String status, Double consumption, String accountNumber) {
        super(id, amount, date, type, status, consumption);
        this.accountNumber = accountNumber;
    }

    public WaterBill() {}

    public String getAccountNumber() {
        return accountNumber;
    }
}
