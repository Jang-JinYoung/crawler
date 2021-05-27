package com.test.crawler;

import com.test.crawler.api.Crawler;
import com.test.crawler.api.DB;
import com.test.crawler.model.Cafe;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        System.out.println("프로그램시작");
        Crawler crawler = new Crawler();
        ArrayList<Cafe> cafeList = crawler.crawler();

        DB db = new DB();
        //db.insert(cafeList);
        //12312312312

    }
}
