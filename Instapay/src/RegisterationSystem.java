public abstract class RegisterationSystem {

    public boolean register(User user , String password){
        sendOTP(user.getMobileNumber());
        if(verifyAccount(user)){
            uploadUserToDB(user,password);
        }
        else{
            return false ;
        }
        return true;
    }

    private void uploadUserToDB(User user, String password ){
        Database database = DatabaseFactory.getDatabase();
        database.createUser(user,password);
    }

    private int sendOTP( String mobileNumber) {
        // faking sending otp!
        if (mobileNumber != null && !mobileNumber.isEmpty()) {
            int otp = 1234;
            //System.out.println("OTP send to " + mobileNumber + ": " + otp);
            return otp;
        } else {
            //System.out.println("Invalid mobile number to send OTP\n");
            return -1;
        }
    }

    public abstract boolean verifyAccount(User user);
}
