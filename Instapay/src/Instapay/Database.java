package Instapay;

public interface Database {
    public void createUser(User user, String password);

    public User validateUser(String username, String password);

    public boolean checkUniqueUser(String username);

    public void updateUserBalance(User user);

    public void incrementUserBalance(String username, Double additionalAmount);

    public void incrementWalletBalance(String walletNumber, Double additionalAmount);

    public void incrementBankAccountBalance(String bankNumber, Double additionalAmount);

    public boolean verifyWalletNumber(String walletNumber);

    public boolean verifyBankAccountNumber(String bankAccountNumber, String mobileNumber);
}
