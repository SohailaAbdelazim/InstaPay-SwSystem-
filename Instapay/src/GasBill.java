public class GasBill extends Bill {
    private String meterNumber;

    public GasBill(int id, Double amount, String date, String type, String status, Double consumption, String meterNumber) {
        super(id, amount, date, type, status, consumption);
        this.meterNumber = meterNumber;
    }

    public String getMeterNumber() {
        return meterNumber;
    }
    @Override
    protected Double calculateBillAmount() {
        double gasRate = 1.2;
        return consumption * gasRate;
    }
}
