package Instapay;

import com.mongodb.MongoException;
import com.mongodb.client.*;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import org.bson.conversions.Bson;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Arrays;

public class MongoDB implements Database {
    private MongoDatabase database;

    protected MongoDB() {
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
        Document result = collection.aggregate(Arrays.asList(
                Aggregates.match(Filters.eq("username", username)),
                Aggregates.lookup("wallets", "walletNumber", "walletNumber", "wallets"),
                Aggregates.lookup("banks", "bankAccountNumber", "bankAccountNumber", "banks"),
                // project the fields and calculate the balance
                Aggregates.project(Projections.fields(
                        Projections.include("username", "password", "mobileNumber", "address", "name", "bankAccountNumber", "walletNumber"),
                        Projections.computed("balance", new Document(
                                "$cond", Arrays.asList(
                                // check if the walletAccount field is null
                                new Document("$eq", Arrays.asList("$walletNumber", null)),
                                // if true, get the balance from the banks document
                                new Document("$arrayElemAt", Arrays.asList("$banks.balance", 0)),
                                // if false, get the balance from the wallets document
                                new Document("$arrayElemAt", Arrays.asList("$wallets.balance", 0))
                        )
                        ))
                ))
        )).first();
        if (result == null || !checkMatchedPasswords(password, result.getString("password"))) {
            return null;
        }
        double balance = result.getDouble("balance");
        return new User(
                result.getString("username"),
                result.getString("mobileNumber"),
                balance,
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
        if (user.getWalletNumber() != null) {
            updateWalletAccountBalance(user.getWalletNumber(), user.getBalance());
        } else {
            updateBankAccountBalance(user.getBankAccountNumber(), user.getBalance());
        }
    }

    private void updateWalletAccountBalance(String walletNumber, Double balance) {
        MongoCollection<Document> collection = database.getCollection("wallets");
        Bson filter = Filters.eq("walletNumber", walletNumber);
        Bson update = Updates.set("balance", balance);
        collection.updateOne(filter, update);
    }

    private void updateBankAccountBalance(String bankAccountNumber, Double balance) {
        MongoCollection<Document> collection = database.getCollection("banks");
        Bson filter = Filters.eq("bankAccountNumber", bankAccountNumber);
        Bson update = Updates.set("balance", balance);
        collection.updateOne(filter, update);
    }

    @Override
    public void incrementUserBalance(String username, Double additionalAmount) {
        MongoCollection<Document> collection = database.getCollection("users");
        Document userDocument = collection.find(new Document("username", username)).first();
        if (userDocument.getString("walletNumber") != null) {
            incrementWalletBalance(userDocument.getString("walletNumber"), additionalAmount);
        } else {
            incrementBankAccountBalance(userDocument.getString("bankAccountNumber"), additionalAmount);
        }
    }

    @Override
    public boolean incrementWalletBalance(String walletNumber, Double additionalAmount) {
        MongoCollection<Document> collection = database.getCollection("wallets");
        Bson filter = Filters.eq("walletNumber", walletNumber);
        Bson update = Updates.inc("balance", additionalAmount);
        Document userDocument = collection.findOneAndUpdate(filter, update);
        return userDocument != null;
    }

    @Override
    public boolean incrementBankAccountBalance(String bankAccountNumber, Double additionalAmount) {
        MongoCollection<Document> collection = database.getCollection("banks");
        Bson filter = Filters.eq("bankAccountNumber", bankAccountNumber);
        Bson update = Updates.inc("balance", additionalAmount);
        Document userDocument = collection.findOneAndUpdate(filter, update);
        return userDocument != null;
    }

    @Override
    public boolean verifyWalletNumber(String walletNumber) {
        MongoCollection<Document> collection = database.getCollection("wallets");
        long count = collection.countDocuments(new Document("walletNumber", walletNumber));
        return count != 0;
    }

    @Override
    public boolean verifyBankAccountNumber(String bankAccountNumber, String mobileNumber) {
        MongoCollection<Document> collection = database.getCollection("banks");
        long count = collection.countDocuments(new Document("bankAccountNumber", bankAccountNumber).append("mobileNumber", mobileNumber));
        return count != 0;
    }
}
