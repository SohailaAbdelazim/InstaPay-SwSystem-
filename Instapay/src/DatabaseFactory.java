public class DatabaseFactory {
    private static Database database = new MongoDB();
    public static Database getDatabase() {
        return database;
    }
}