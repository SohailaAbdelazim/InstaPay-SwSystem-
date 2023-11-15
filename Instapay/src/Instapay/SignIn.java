package Instapay;

public class SignIn {
    public User signIn(String username, String password) {
        User signInUser = DatabaseFactory.getDatabase().validateUser(username, password);
        return signInUser;
    }
}
