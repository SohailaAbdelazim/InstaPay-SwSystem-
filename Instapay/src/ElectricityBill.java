public class ElectricityBill extends Bill{
    private String accountNumber;
    public ElectricityBill(int id, Double amount, String date, String type, String status, Double consumption) {
        super(id, amount, date, type, status, consumption);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    private Double calculateBillAmount() {
        return 0.0;
    }
}
