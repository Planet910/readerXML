package com.readerXML.feedreader.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import com.mongodb.client.result.UpdateResult;
import com.readerXML.feedreader.factory.MongoFactory;
import com.readerXML.feedreader.model.Tea;
import org.bson.BsonDocument;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public class TeaRepository {

    private static MongoCollection<Tea> collection;

    public TeaRepository() {
        MongoFactory instance = MongoFactory.getInstance();
        MongoDatabase db = instance.getDatabase();
        collection = db.getCollection(Tea.class.getSimpleName().toLowerCase(), Tea.class);
    }

    public List<Tea> getTeasByVendorId(String vendorId) {
        Bson filter = Filters.eq("vendorId", vendorId);
        return collection.find(filter, Tea.class).into(new ArrayList<>());
    }

    public List<Tea> findAll() {
        return collection.find(new BsonDocument(), Tea.class).into(new ArrayList<>());
    }

    public UpdateResult upsertTea(Tea tea) {
        Bson filter = Filters.eq("_id", tea.getId());
        ReplaceOptions options = new ReplaceOptions().upsert(true);

        return collection.replaceOne(filter, tea, options);
    }

    public Tea findById(String id) {
        Bson filter = Filters.eq("_id", id);
        return collection.find(filter).first();
    }


}
