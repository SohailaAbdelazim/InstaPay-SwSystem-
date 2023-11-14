public class WaterBillPayment extends BillPayment{
        @Override
        protected Bill createBill() {
            return new WaterBill();
        }

        @Override
        protected Double calculateBillAmount(Bill bill) {
            double waterRate = 0.15;
            return bill.getConsumption() * waterRate;
        }
}
