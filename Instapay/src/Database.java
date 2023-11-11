public interface Database {
    public void createUser(User user, String password);
    public User validateUser(String username, String password);
    public boolean checkUniqueUser(String username);
    public void updateUserBalance(User user);
}
