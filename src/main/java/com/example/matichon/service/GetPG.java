package com.example.matichon.service;

import org.json.JSONArray;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetPG {
    public JSONArray putLink(String link){

        JSONArray urls = new JSONArray();
        urls.put(link);

        try {
            Document doc = Jsoup.connect(urls.get(0).toString()).get();

            Elements item = doc.select(".page-nav .td-pb-padding-side");
            Elements n = item.select(".last ");

            int max=Integer.parseInt(n.text());
           
            for(int i=2 ; i<= max ; i++) {

                urls.put("https://www.matichon.co.th/page/"+i+"?s=%E0%B9%80%E0%B8%AB%E0%B8%A5%E0%B9%89%E0%B8%B2");
    
            }

        } catch (Exception e) {
            //TODO: handle exception
        }
        return urls;
    }

}
