package com.mongodb;

import static java.util.Arrays.asList;

import org.bson.BsonDocument;
import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// MongoClient client=new MongoClient();

		// MongoClient client=new MongoClient("localhost",27017);

		// MongoClient client=new MongoClient(new
		// ServerAddress("localhost",27017));

		// MongoClient client = new MongoClient(asList(new
		// ServerAddress("localhost", 27017)));

		// MongoClient client = new MongoClient(new
		// MongoClientURI("mongodb://localhost:27017"));

		MongoClientOptions options = MongoClientOptions.builder().connectionsPerHost(100).build();

		// this is heavy object so configure it in spring bean or some else
		MongoClient client = new MongoClient(new ServerAddress(), options);

		// this is light object so can create any time any where and it is
		// immutable
		MongoDatabase db = client.getDatabase("test").withReadPreference(ReadPreference.secondary());

		// this is light object so can create any time any where and it is
		// immutable and this is generic because can switch to another document like below
		//MongoCollection<BsonDocument> collection = db.getCollection("test",BsonDocument.class);
		MongoCollection<Document> collection = db.getCollection("test");
		collection.count();
		client.close();
	}
}
