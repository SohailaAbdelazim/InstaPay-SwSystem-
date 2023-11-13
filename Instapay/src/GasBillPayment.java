public class GasBillPayment extends BillPayment {
    @Override
    protected Bill createBill() {
        return new GasBill();
    }
    @Override
    protected Double calculateBillAmount(Bill bill) {
        double electricityRate = 0.15;
        return bill.getConsumption() * electricityRate;
    }
}
