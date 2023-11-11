import com.mongodb.MongoException;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import org.bson.conversions.Bson;
import org.mindrot.jbcrypt.BCrypt;

public class MongoDB implements Database{
    private MongoDatabase database;
    MongoDB() {
        String connectionString = "mongodb+srv://shawkyebrahim2514:shawkyebrahim2514@cluster0.utaifal.mongodb.net/?retryWrites=true&w=majority";
        try {
            MongoClient mongoClient = MongoClients.create(connectionString);
            database = mongoClient.getDatabase("Instapay");
        } catch (MongoException e) {
            System.out.println("Error occurred during creating the database");
        }
    }
    @Override
    public void createUser(User user, String password) {
        MongoCollection<Document> collection = database.getCollection("users");
        String hashedPassword = hashPassword(password);
        Document userDocument = new Document("username", user.getUsername())
                .append("mobileNumber", user.getMobileNumber())
                .append("balance", 0)
                .append("address", user.getAddress())
                .append("name", user.getName())
                .append("bankAccountNumber", user.getBankAccountNumber())
                .append("walletNumber", user.getWalletNumber())
                .append("password", hashedPassword);
        collection.insertOne(userDocument);
    }
    private String hashPassword(String password) {
        String salt = BCrypt.gensalt();
        return BCrypt.hashpw(password, salt);
    }

    @Override
    public User validateUser(String username, String password) {
        MongoCollection<Document> collection = database.getCollection("users");
        Document result = collection.find(new Document("username", username)).first();
        if(result == null || !checkMatchedPasswords(password, result.getString("password"))) {
            return null;
        }
        return new User(
                result.getString("username"),
                result.getString("mobileNumber"),
                result.getDouble("balance"),
                result.getString("address"),
                result.getString("name"),
                result.getString("bankAccountNumber"),
                result.getString("walletNumber")
        );
    }

    private boolean checkMatchedPasswords(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }

    @Override
    public boolean checkUniqueUser(String username) {
        MongoCollection<Document> collection = database.getCollection("users");
        long count = collection.countDocuments(new Document("username", username));
        return count == 0;
    }

    @Override
    public void updateUserBalance(User user) {
        MongoCollection<Document> collection = database.getCollection("users");
        Bson filter = Filters.eq("username", user.getUsername());
        Bson update = Updates.set("balance", user.getBalance());
        collection.updateOne(filter, update);
    }
}
