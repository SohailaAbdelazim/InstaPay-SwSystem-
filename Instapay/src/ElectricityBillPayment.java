public class ElectricityBillPayment extends BillPayment {
        @Override
        protected Bill createBill() {
            return new ElectricityBill();
        }
        @Override
        protected Double calculateBillAmount(Bill bill) {
            double electricityRate = 0.15;
            return bill.getConsumption() * electricityRate;
        }
}
