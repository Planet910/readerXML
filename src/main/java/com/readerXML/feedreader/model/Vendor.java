package com.readerXML.feedreader.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bson.codecs.pojo.annotations.BsonId;

import java.net.URL;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Vendor {

    @BsonId
    private String id;
    @EqualsAndHashCode.Include
    private String name;
    @EqualsAndHashCode.Include
    private URL url;
    private String description;
}
