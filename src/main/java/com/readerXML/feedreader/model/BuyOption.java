package com.readerXML.feedreader.model;

import lombok.Data;

import java.util.List;

@Data
public class BuyOption {

    private String id;

    private int quantity;

    private String measureUnit;

    private String quantityName;

    private List<Price> prices;

    private List<Price> discountedPrices;
}
