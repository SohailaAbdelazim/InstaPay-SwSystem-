public class ElectricityBillPayment extends BillPayment {
    @Override
    protected Bill createBill() {
        return new ElectricityBill(
                2,
                "2023-12-15",
                "Unpaid",
                100.5,
                "125"
        );
    }

    @Override
    protected Double calculateBillAmount(Bill bill) {
        double electricityRate = 6.3;
        return bill.getConsumption() * electricityRate;
    }
}
