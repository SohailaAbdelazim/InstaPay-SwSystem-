public abstract class RegisterationSystem {
    public boolean register(User user){
        return true ; // needs revision logic : abs/not ?
    }

    private void uploadUserToDB(User user){
        Database database = new MongoDB();
        //database.createUser(user); // how to send password ?
    }

    private boolean sendOTP( String mobileNumber) {
        // faking sending otp!
        if (mobileNumber != null && !mobileNumber.isEmpty()) {
            int otp = 123;
            System.out.println("OTP send to " + mobileNumber + ": " + otp);
            return true;
        } else {
            System.out.println("Invalid mobile number to send OTP\n");
            return false;
        }
    }

    public abstract boolean verifyAccount(User user);
}
