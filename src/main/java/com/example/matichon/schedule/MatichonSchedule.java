package com.example.matichon.schedule;

import com.example.matichon.service.GetPG;
import com.example.matichon.service.Getcontent;
import com.example.matichon.service.Getlink;
import com.example.matichon.service.Post;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MatichonSchedule {
    @Scheduled(fixedRate = 80000)

    public void getdata() {
        GetPG s = new GetPG();
        JSONArray link = s.putLink("https://www.matichon.co.th/?s=%E0%B9%80%E0%B8%AB%E0%B8%A5%E0%B9%89%E0%B8%B2");

        for(int  i=0; i<link.length(); i++){
            
            Getlink links = new Getlink();
            JSONArray url = links.putpgLink(link.get(i).toString());

            for(int j=0; j<url.length(); j++){

                Getcontent data = new Getcontent();
                JSONObject item = data.putData(url.get(j).toString());

                Post in = new Post();
                in.post(item);
            }
        }
        System.out.println("Post Data is Success!");
    }
}
