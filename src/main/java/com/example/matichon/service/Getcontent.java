package com.example.matichon.service;

import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Getcontent {
    public JSONObject putData(String data){

        JSONObject matichon = new JSONObject();
        Document doc;
        try {
            doc = Jsoup.connect(data).get();

            Elements item = doc.select(".td-post-title");
            Elements title = item.select("h1.entry-title");
             Elements items = doc.select(".td-post-content");
             Elements abstracts = items.select(" p");
               Elements pubDate = item.select("time");
            
                

            
            String md5Hex = DigestUtils.md5Hex(data.toString()); 
            matichon.put("text_title", title.text());
            matichon.put("text_description", abstracts.text());
            matichon.put("date", pubDate.get(0).text());
            matichon.put("url", data);
            matichon.put("MD5", md5Hex);
            


        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        return matichon;
    }
}
