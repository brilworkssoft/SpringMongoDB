package com.mongodb;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.m101j.util.Helpers.printJson;
import static java.util.Arrays.asList;

public class InsertTest {
	public static void main(String[] args) {
		MongoClient client = new MongoClient("localhost", 27017);

		MongoDatabase db = client.getDatabase("course");

		MongoCollection<Document> coll = db.getCollection("insertTest");
		coll.drop();

		Document smith = new Document().append("name", "Smith").append("age", 30).append("profession", "programmer");

		Document jhon = new Document().append("name", "Jhon").append("age", 22).append("profession", "Hacker");

		printJson(smith);
		// coll.insertOne(smith);
		coll.insertMany(asList(smith, jhon));
		printJson(smith);
		printJson(jhon);

		client.close();
	}
}
