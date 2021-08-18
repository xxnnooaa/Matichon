package com.example.matichon.service;

import java.io.IOException;

import org.json.JSONArray;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Getlink {
    public JSONArray putpgLink(String linky) {

        JSONArray urls = new JSONArray();

        try {
            Document doc = Jsoup.connect(linky).get();

            Elements item = doc.select(".td_module_10.td_module_wrap.td-animation-stack");
            Elements links = item.select(".entry-title.td-module-title a");

            for(int i=0 ; i< links.size() ; i++) {

            urls.put(links.get(i).attr("href"));

        }

    
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return urls;

    }
}
