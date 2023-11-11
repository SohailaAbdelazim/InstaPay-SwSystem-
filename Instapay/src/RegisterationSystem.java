public abstract class RegisterationSystem {
    public boolean register(User user){
    return true ;
    }

    private void uploadUserToDB(User user){

    }

    private boolean sendOTP( String mobilenumber){
        return false;
    }


    public abstract boolean verifyAccount(User user);
}
