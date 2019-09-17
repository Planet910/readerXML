package com.readerXML.feedreader.model;

import lombok.Data;

import java.net.URI;

@Data
public class Feed {
    private URI url;
    private Schedule updateSchedule;
}
