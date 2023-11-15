package Instapay;

public class DatabaseFactory {
    private static final Database database = new MongoDB();

    public static Database getDatabase() {
        return database;
    }
}