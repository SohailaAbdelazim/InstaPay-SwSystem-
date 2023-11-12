public class SignIn {
    public User signIn(String username, String password){
        MongoDB signInChecker = new MongoDB();
        User signInUser = signInChecker.validateUser(username,password);
        return signInUser;
    }
}
