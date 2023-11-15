public class WaterBillPayment extends BillPayment{
        @Override
        protected Bill createBill() {
            return new WaterBill(
                    2,
                    "2023-12-25",
                    "Unpaid",
                    170.5,
                    "30"
            );
        }

        @Override
        protected Double calculateBillAmount(Bill bill) {
            double waterRate = 5.4;
            return bill.getConsumption() * waterRate;
        }
}
