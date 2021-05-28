package crawler;

import crawler.api.DB;
import crawler.model.Cafe;
import crawler.api.Crawler;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        System.out.println("프로그램시작");
        Crawler crawler = new Crawler();
        ArrayList<Cafe> cafeList = crawler.crawler();
        
//        DB db = new DB();
//        db.insert(cafeList);

    }
}
