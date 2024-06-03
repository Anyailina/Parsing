package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String URL = "https://ria.ru/lenta/";
        try {
            Document document = Jsoup.connect(URL).get();
            Elements items = document.select("div.list-item__content");
            items.forEach(e -> {
                String text = e.select("a.list-item__title").text();
                String url = e.select("a").last().absUrl("href");
                System.out.println(text + "-" + url);
            });
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}