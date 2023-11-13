public class ElectricityBill extends Bill{
    private String accountNumber;

    public ElectricityBill(int id, Double amount, String date, String type, String status, Double consumption, String accountNumber) {
        super(id, amount, date, type, status, consumption);
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    protected Double calculateBillAmount() {
        double electricityRate = 0.15;
        return consumption * electricityRate;
    }
}
