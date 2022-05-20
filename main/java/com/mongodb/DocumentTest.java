package com.mongodb;

import java.util.Arrays;
import java.util.Date;

import org.bson.Document;
import org.bson.types.ObjectId;
import static com.mongodb.m101j.util.Helpers.printJson;

public class DocumentTest {

	public static void main(String[] args) {
		Document document = new Document().append("str", "Hitesh").append("int", 1).append("l", 1l)
				.append("double", 2.2).append("b", false).append("d", new Date()).append("objectId", new ObjectId())
				.append("null", null).append("array", Arrays.asList(1, 2, 3))
				.append("embeddedDoc", new Document("x", 0));

		String str = document.getString("str");
		String str2 = (String) document.get("str");
		int i = document.getInteger("int");
		printJson(document);
	}

}
