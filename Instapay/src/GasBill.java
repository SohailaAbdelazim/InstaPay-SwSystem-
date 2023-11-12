public class GasBill extends Bill {
    private String meterNumber;

    public GasBill(int id, Double amount, String date, String type, String status, Double consumption) {
        super(id, amount, date, type, status, consumption);
    }

    public String getMeterNumber() {
        return meterNumber;
    }

    private Double calculateBillAmount() {
        return 0.0;
    }
}
