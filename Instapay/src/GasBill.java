public class GasBill extends Bill {
    private String meterNumber;

    public GasBill(int id, Double amount, String date, String type, String status, Double consumption, String meterNumber) {
        super(id, amount, date, type, status, consumption);
        this.meterNumber = meterNumber;
    }

    public GasBill() {}

    public String getMeterNumber() {
        return meterNumber;
    }
}
