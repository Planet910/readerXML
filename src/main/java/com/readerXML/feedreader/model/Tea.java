package com.readerXML.feedreader.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bson.codecs.pojo.annotations.BsonId;

import java.net.URL;
import java.time.Year;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Tea {

    @BsonId
    private String id;
    @EqualsAndHashCode.Include
    private String name;
    @EqualsAndHashCode.Include
    private Year year;
    @EqualsAndHashCode.Include
    private Season season;
    private String cultivar;
    private String origin;
    private int elevation;
    @EqualsAndHashCode.Include
    private String teaType;
    private String description;
    private int vendorWebsiteRating;
    private int rating;
    private URL url;
    private List<String> imagesId;
    private List<String> tags;
    @EqualsAndHashCode.Include
    private Vendor vendor;
    private List<BuyOption> buyOptions;
}
