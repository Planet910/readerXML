package com.readerXML.feedreader.factory;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.readerXML.feedreader.config.ConfigUtil;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public class MongoFactory {

    private static MongoFactory instance;
    private static MongoClient mongoClient;
    private static CodecRegistry pojoCodecRegistry;

    private MongoFactory() {}

    public static MongoFactory getInstance() {
        if(instance == null) {
            instance = new MongoFactory();
            CodecRegistry defaultCodecRegistry = MongoClientSettings.getDefaultCodecRegistry();
            CodecRegistry fromProvider = CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build());
            pojoCodecRegistry = CodecRegistries.fromRegistries(defaultCodecRegistry, fromProvider);

            MongoClientSettings settings = MongoClientSettings.builder()
                    .codecRegistry(pojoCodecRegistry)
                    .applyConnectionString(new ConnectionString(ConfigUtil.MONGO_CONNECTION))
                    .build();

            mongoClient = MongoClients.create(settings);
        }
        return instance;
    }

    public MongoDatabase getDatabase() {
        return mongoClient.getDatabase(ConfigUtil.DATABASE).withCodecRegistry(pojoCodecRegistry);
    }
}
