public class GasBillPayment extends BillPayment {
    @Override
    protected Bill createBill() {
        return new GasBill(
                5,
                "2023-12-20",
                "Unpaid",
                120.5,
                "50"
        );
    }
    @Override
    protected Double calculateBillAmount(Bill bill) {
        double electricityRate = 9.4;
        return bill.getConsumption() * electricityRate;
    }
}
