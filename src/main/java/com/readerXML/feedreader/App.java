package com.readerXML.feedreader;

import com.readerXML.feedreader.model.Tea;
import com.readerXML.feedreader.repository.TeaRepository;

public class App {

    public static void main(String[] args) {
        TeaRepository repository = new TeaRepository();

        for (Tea tea : repository.findAll()) {
            System.out.println(tea);
        }
    }
}
