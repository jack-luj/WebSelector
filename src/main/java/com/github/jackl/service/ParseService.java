package com.github.jackl.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by jackl on 2017/6/28.
 */
@Service
public class ParseService {

    public String handlePage(String url,String rule){
        String re="";
        try {
            Document doc = Jsoup.connect(url).get();
            Elements  result= doc.select(rule);
            re=result.toString();
        }catch (IOException e){
            re="request "+ url+" error!";
        }
        return re;
    }
}
