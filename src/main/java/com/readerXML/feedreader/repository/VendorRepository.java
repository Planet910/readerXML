package com.readerXML.feedreader.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.readerXML.feedreader.factory.MongoFactory;
import com.readerXML.feedreader.model.Vendor;
import org.bson.BsonDocument;

import java.util.ArrayList;
import java.util.List;

public class VendorRepository {

    private static MongoCollection<Vendor> collection;

    public VendorRepository() {
        MongoFactory instance = MongoFactory.getInstance();
        MongoDatabase db = instance.getDatabase();
        collection = db.getCollection(Vendor.class.getSimpleName().toLowerCase(), Vendor.class);
    }

    public List<Vendor> getVendors() {
       return collection.find(new BsonDocument()).into(new ArrayList<>());
    }
}
