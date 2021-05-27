package com.test.crawler.api;

import com.test.crawler.model.Cafe;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class Crawler {

    public ArrayList<Cafe> crawler() {

        ArrayList<String> hrefs = new ArrayList<>();
        ArrayList<Cafe> cafeList = new ArrayList<>();

        try {

            //page
            for(int i=1; i<=1; i++) {
                //?page=i
                String URL = "https://www.mangoplate.com/search/%EA%B4%91%EC%A7%84%EA%B5%AC%20%EC%B9%B4%ED%8E%98?keyword=%EA%B4%91%EC%A7%84%EA%B5%AC%20%EC%B9%B4%ED%8E%98&page="+i;

                Document doc = Jsoup.connect(URL).get();

                Elements elements = doc.select("div[class=\"search-list-restaurants-inner-wrap\"]");

                System.out.println(i+"페이지");
                for (Element e : elements.select("div[class=\"info\"]")) {
                    String href = refineHref(e.select("a").outerHtml());


                    hrefs.add(href);
                }
            }

            for(String href : hrefs) {
                System.out.println(cafeList.size() + "번");
                String URL = "https://www.mangoplate.com" + href;

                Document doc = Jsoup.connect(URL).get();

                Elements elements = doc.select("section[class=\"restaurant-detail\"]");


                for(Element e : elements) {

                    Cafe cafe = new Cafe();

                    //카페 이름
                    String title = e.select("h1[class=\"restaurant_name\"]").text();
                    cafe.setTitle(title);

                    //주소
                    String address = e.select("span[class=\"Restaurant__InfoAddress--Text\"]").text();
                    address = address.substring(0, address.length()/2);
                    cafe.setAddress(address);

                    //카페 메뉴 + 가격
                    //List<String> items = e.select("li[class=\"Restaurant_MenuItem\"]").eachText();
                    String menus = e.select("li[class=\"Restaurant_MenuItem\"]").text();
                    cafe.setMenus(menus);

                    cafeList.add(cafe);
                }

            }

            //hrefs 초기화
            hrefs.clear();

        } catch (Exception e) {
            System.out.println("Crawler() "+e);
        }

        return cafeList;

    }

    private String refineHref(String info) {

        //info = <a href="/restaurants/Iwug3C-3E8"> <h2 class="title">최가커피 </h2> </a>
        int firstStr = info.indexOf("\"");
        int lastStr = info.indexOf(">");

        String href = info.substring(firstStr+1, lastStr-1);


        return href;
    }

    private String refineTitle(String info) {

        //info = <a href="/restaurants/Iwug3C-3E8"> <h2 class="title">최가커피 </h2> </a>
        int firstStr = info.indexOf("e\">");
        int lastStr = info.indexOf("</h2>");

        String title = info.substring(firstStr+3, lastStr-1);

        return title;

    }
}
