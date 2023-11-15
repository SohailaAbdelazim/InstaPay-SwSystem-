public class GasBill extends Bill {
    private String meterNumber;

    public GasBill(int id, String date, String status, Double consumption, String meterNumber) {
        super(id, date, status, consumption);
        this.meterNumber = meterNumber;
    }

    public String getMeterNumber() {
        return meterNumber;
    }
}
