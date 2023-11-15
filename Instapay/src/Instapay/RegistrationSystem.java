package Instapay;

public abstract class RegistrationSystem {

    public boolean register(User user, String password) {
        if(DatabaseFactory.getDatabase().checkUniqueUser(user.getUsername())){
            if (verifyAccount(user)) {
                uploadUserToDB(user, password);
            } else {
                return false;
            }
            return true;
        }
        else{
            return false ;
        }
    }

    private void uploadUserToDB(User user, String password) {
        DatabaseFactory.getDatabase().createUser(user, password);
    }

    public int sendOTP(String mobileNumber) {
        // faking sending otp!
        if (mobileNumber != null && !mobileNumber.isEmpty()) {
            int otp = 1234;
            return otp;
        } else {
            return -1;
        }
    }

    public abstract boolean verifyAccount(User user);
}
