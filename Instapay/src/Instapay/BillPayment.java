package Instapay;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public abstract class BillPayment {
    private boolean verifyBillDetails(Bill bill) {
        try {
            LocalDate billDate = LocalDate.parse(bill.getDate());
            if (billDate.isBefore(LocalDate.now())) {
                // Date has passed
                return false;
            }
        } catch (DateTimeParseException e) {
            // Invalid date format
            return false;
        }
        // Check if the status is not paid
        if ("Paid".equalsIgnoreCase(bill.getStatus())) {
            return false;
        }
        // If all conditions pass, the bill details are considered valid
        return true;
    }

    protected abstract Double calculateBillAmount(Bill bill);


    public Bill payBill(User user) {
        Bill bill = createBill();
        if (verifyBillDetails(bill)) {
            // Calculate the bill amount
            Double newAmount = calculateBillAmount(bill);
            bill.setAmount(newAmount);
            // Check if the user has enough balance to pay the bill
            if (!user.compareBalance(bill.getAmount())) {
                return null;
            }
            // Deduct the bill amount from the user balance
            user.deductAmount(bill.getAmount());
            // Update the bill status to "Paid"
            bill.setStatus("Paid");
            return bill;
        } else {
            return null;
        }

    }

    protected abstract Bill createBill();
}
