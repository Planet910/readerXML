package com.readerXML.feedreader.model;

import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonProperty;

@Data
public class User {

    @BsonProperty("id")
    private String id;
    private String email;
    private String password;
    private String name;
    private String surname;
    private boolean enabled;
}