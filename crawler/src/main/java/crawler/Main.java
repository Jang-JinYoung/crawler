package crawler;

import crawler.api.Crawler;
import crawler.api.DB;
import crawler.model.Country;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        System.out.println("프로그램시작");
        Crawler crawler = new Crawler();
        ArrayList<Country> countries = crawler.main();
        
        DB db = new DB();
        db.main(countries);

    }
}
