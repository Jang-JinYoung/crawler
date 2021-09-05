package crawler.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import crawler.model.Country;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import java.util.ArrayList;

public class Crawler {

    public ArrayList<Country> main() {

        String json = "{\"continents\":[\n" +
                "{\"id\":\"cont1\",\"name\":\"아시아\",\n" +
                "\"nations\":[{\"id\":\"asia01\",\"name\":\"네팔\"},{\"id\":\"asia27\",\"name\":\"대만\"},{\"id\":\"asia02\",\"name\":\"대한민국\"},{\"id\":\"asia03\",\"name\":\"동티모르\"},{\"id\":\"asia04\",\"name\":\"라오스\"},{\"id\":\"asia06\",\"name\":\"말레이시아\"},{\"id\":\"asia07\",\"name\":\"몰디브\"},{\"id\":\"asia08\",\"name\":\"몽골\"},\n" +
                "{\"id\":\"asia09\",\"name\":\"미얀마\"},\n" +
                "{\"id\":\"asia10\",\"name\":\"방글라데시\"},\n" +
                "{\"id\":\"asia11\",\"name\":\"베트남\"},{\"id\":\"asia12\",\"name\":\"부탄\"},\n" +
                "{\"id\":\"asia99\",\"name\":\"북한\"},{\"id\":\"asia14\",\"name\":\"브루나이\"},\n" +
                "{\"id\":\"asia15\",\"name\":\"스리랑카\"},{\"id\":\"asia16\",\"name\":\"싱가포르\"},\n" +
                "{\"id\":\"asia17\",\"name\":\"우즈베키스탄\"},{\"id\":\"asia18\",\"name\":\"인도\"},{\"id\":\"asia19\",\"name\":\"인도네시아\"},{\"id\":\"asia21\",\"name\":\"일본\"},{\"id\":\"asia22\",\"name\":\"중국\"},{\"id\":\"asia23\",\"name\":\"카자흐스탄\"},{\"id\":\"asia24\",\"name\":\"캄보디아\"},{\"id\":\"asia25\",\"name\":\"키르기스스탄\"},{\"id\":\"asia26\",\"name\":\"타이\"},{\"id\":\"asia28\",\"name\":\"타지키스탄\"},{\"id\":\"asia29\",\"name\":\"투르크메니스탄\"},{\"id\":\"asia30\",\"name\":\"파키스탄\"},{\"id\":\"asia31\",\"name\":\"필리핀\"}]},{\"id\":\"cont2\",\"name\":\"유럽\",\"nations\":[{\"id\":\"eu18\",\"name\":\"교황청\"},{\"id\":\"eu02\",\"name\":\"그리스\"},{\"id\":\"eu03\",\"name\":\"네덜란드\"},{\"id\":\"eu04\",\"name\":\"노르웨이\"},{\"id\":\"eu05\",\"name\":\"덴마크\"},{\"id\":\"eu06\",\"name\":\"독일\"},{\"id\":\"eu07\",\"name\":\"라트비아\"},{\"id\":\"eu08\",\"name\":\"러시아\"},{\"id\":\"eu09\",\"name\":\"루마니아\"},{\"id\":\"eu10\",\"name\":\"룩셈부르크\"},{\"id\":\"eu11\",\"name\":\"리투아니아\"},{\"id\":\"eu12\",\"name\":\"리히텐슈타인\"},{\"id\":\"eu14\",\"name\":\"모나코\"},{\"id\":\"eu15\",\"name\":\"몬테네그로\"},{\"id\":\"eu16\",\"name\":\"몰도바\"},{\"id\":\"eu17\",\"name\":\"몰타\"},{\"id\":\"eu19\",\"name\":\"벨기에\"},{\"id\":\"eu20\",\"name\":\"벨라루스\"},{\"id\":\"eu21\",\"name\":\"보스니아헤르체고비나\"},{\"id\":\"eu13\",\"name\":\"북마케도니아\"},{\"id\":\"eu22\",\"name\":\"불가리아\"},{\"id\":\"eu44\",\"name\":\"사이프러스\"},{\"id\":\"eu23\",\"name\":\"산마리노\"},{\"id\":\"eu24\",\"name\":\"세르비아\"},{\"id\":\"eu25\",\"name\":\"스웨덴\"},{\"id\":\"eu26\",\"name\":\"스위스\"},{\"id\":\"eu35\",\"name\":\"스페인\"},{\"id\":\"eu27\",\"name\":\"슬로바키아\"},{\"id\":\"eu28\",\"name\":\"슬로베니아\"},{\"id\":\"mea06\",\"name\":\"아르메니아\"},{\"id\":\"eu29\",\"name\":\"아이슬란드\"},{\"id\":\"eu30\",\"name\":\"아일랜드\"},{\"id\":\"eu31\",\"name\":\"아제르바이잔\"},{\"id\":\"eu32\",\"name\":\"안도라\"},{\"id\":\"eu33\",\"name\":\"알바니아\"},{\"id\":\"eu34\",\"name\":\"에스토니아\"},{\"id\":\"eu36\",\"name\":\"영국\"},{\"id\":\"eu37\",\"name\":\"오스트리아\"},{\"id\":\"eu38\",\"name\":\"우크라이나\"},{\"id\":\"eu39\",\"name\":\"이탈리아\"},{\"id\":\"eu01\",\"name\":\"조지아\"},{\"id\":\"eu41\",\"name\":\"체코\"},{\"id\":\"eu42\",\"name\":\"코소보\"},{\"id\":\"eu43\",\"name\":\"크로아티아\"},{\"id\":\"eu46\",\"name\":\"포르투갈\"},{\"id\":\"eu47\",\"name\":\"폴란드\"},{\"id\":\"eu48\",\"name\":\"프랑스\"},{\"id\":\"eu49\",\"name\":\"핀란드\"},{\"id\":\"eu50\",\"name\":\"헝가리\"}]},{\"id\":\"cont3\",\"name\":\"중동\",\"nations\":[{\"id\":\"mea01\",\"name\":\"레바논\"},{\"id\":\"mea02\",\"name\":\"바레인\"},{\"id\":\"mea03\",\"name\":\"사우디아라비아\"},{\"id\":\"mea04\",\"name\":\"시리아\"},{\"id\":\"mea05\",\"name\":\"아랍에미리트\"},{\"id\":\"mea07\",\"name\":\"아프가니스탄\"},{\"id\":\"mea08\",\"name\":\"예멘\"},{\"id\":\"mea09\",\"name\":\"오만\"},{\"id\":\"mea10\",\"name\":\"요르단\"},{\"id\":\"mea11\",\"name\":\"이라크\"},{\"id\":\"mea12\",\"name\":\"이란\"},{\"id\":\"mea13\",\"name\":\"이스라엘\"},{\"id\":\"mea14\",\"name\":\"카타르\"},{\"id\":\"mea15\",\"name\":\"쿠웨이트\"},{\"id\":\"mea16\",\"name\":\"터키\"},{\"id\":\"mea17\",\"name\":\"팔레스타인\"}]},{\"id\":\"cont4\",\"name\":\"아프리카\",\"nations\":[{\"id\":\"af01\",\"name\":\"가나\"},{\"id\":\"af02\",\"name\":\"가봉\"},{\"id\":\"af03\",\"name\":\"감비아\"},{\"id\":\"af04\",\"name\":\"기니\"},{\"id\":\"af05\",\"name\":\"기니비사우\"},{\"id\":\"af06\",\"name\":\"나미비아\"},{\"id\":\"af07\",\"name\":\"나이지리아\"},{\"id\":\"af08\",\"name\":\"남수단공화국\"},{\"id\":\"af09\",\"name\":\"남아프리카공화국\"},{\"id\":\"af10\",\"name\":\"니제르\"},{\"id\":\"af11\",\"name\":\"라이베리아\"},{\"id\":\"af12\",\"name\":\"레소토\"},{\"id\":\"af14\",\"name\":\"르완다\"},{\"id\":\"af15\",\"name\":\"리비아\"},{\"id\":\"af16\",\"name\":\"마다가스카르\"},{\"id\":\"af19\",\"name\":\"말라위\"},{\"id\":\"af20\",\"name\":\"말리\"},{\"id\":\"af21\",\"name\":\"모로코\"},{\"id\":\"af22\",\"name\":\"모리셔스\"},{\"id\":\"af23\",\"name\":\"모리타니\"},{\"id\":\"af24\",\"name\":\"모잠비크\"},{\"id\":\"af25\",\"name\":\"베냉\"},{\"id\":\"af26\",\"name\":\"보츠와나\"},{\"id\":\"af27\",\"name\":\"부룬디\"},{\"id\":\"af28\",\"name\":\"부르키나파소\"},{\"id\":\"af29\",\"name\":\"상투메프린시페\"},{\"id\":\"af31\",\"name\":\"세네갈\"},{\"id\":\"af32\",\"name\":\"세이셸\"},{\"id\":\"af34\",\"name\":\"소말리아\"},{\"id\":\"af35\",\"name\":\"수단\"},{\"id\":\"af37\",\"name\":\"시에라리온\"},{\"id\":\"af38\",\"name\":\"알제리\"},{\"id\":\"af39\",\"name\":\"앙골라\"},{\"id\":\"af41\",\"name\":\"에리트레아\"},{\"id\":\"af36\",\"name\":\"에스와티니\"},{\"id\":\"af42\",\"name\":\"에티오피아\"},{\"id\":\"af43\",\"name\":\"우간다\"},{\"id\":\"af44\",\"name\":\"이집트\"},{\"id\":\"af45\",\"name\":\"잠비아\"},{\"id\":\"af46\",\"name\":\"적도기니\"},{\"id\":\"af47\",\"name\":\"중앙아프리카공화국\"},{\"id\":\"af48\",\"name\":\"지부티\"},{\"id\":\"af49\",\"name\":\"짐바브웨\"},{\"id\":\"af50\",\"name\":\"차드\"},{\"id\":\"af51\",\"name\":\"카메룬\"},{\"id\":\"af52\",\"name\":\"카보베르데\"},{\"id\":\"af53\",\"name\":\"케냐\"},{\"id\":\"af54\",\"name\":\"코모로\"},{\"id\":\"af55\",\"name\":\"코트디부아르\"},{\"id\":\"af56\",\"name\":\"콩고\"},{\"id\":\"af57\",\"name\":\"콩고민주공화국\"},{\"id\":\"af58\",\"name\":\"탄자니아\"},{\"id\":\"af59\",\"name\":\"토고\"},{\"id\":\"af60\",\"name\":\"튀니지\"}]},{\"id\":\"cont5\",\"name\":\"북아메리카\",\"nations\":[{\"id\":\"na02\",\"name\":\"미국\"},{\"id\":\"na03\",\"name\":\"캐나다\"}]},{\"id\":\"cont6\",\"name\":\"남아메리카\",\"nations\":[{\"id\":\"sa01\",\"name\":\"가이아나\"},{\"id\":\"sa03\",\"name\":\"과테말라\"},{\"id\":\"sa04\",\"name\":\"그레나다\"},{\"id\":\"sa06\",\"name\":\"니카라과\"},{\"id\":\"sa07\",\"name\":\"도미니카공화국\"},{\"id\":\"sa08\",\"name\":\"도미니카연방\"},{\"id\":\"sa10\",\"name\":\"멕시코\"},{\"id\":\"sa12\",\"name\":\"바베이도스\"},{\"id\":\"sa13\",\"name\":\"바하마\"},{\"id\":\"sa17\",\"name\":\"베네수엘라\"},{\"id\":\"sa18\",\"name\":\"벨리즈\"},{\"id\":\"sa19\",\"name\":\"볼리비아\"},{\"id\":\"sa20\",\"name\":\"브라질\"},{\"id\":\"Sa22\",\"name\":\"세인트루시아\"},{\"id\":\"Sa23\",\"name\":\"세인트빈센트그레나딘\"},{\"id\":\"Sa24\",\"name\":\"세인트키츠네비스\"},{\"id\":\"sa25\",\"name\":\"수리남\"},{\"id\":\"sa27\",\"name\":\"아르헨티나\"},{\"id\":\"sa28\",\"name\":\"아이티\"},{\"id\":\"sa29\",\"name\":\"앤티가바부다\"},{\"id\":\"sa31\",\"name\":\"에콰도르\"},{\"id\":\"sa32\",\"name\":\"엘살바도르\"},{\"id\":\"sa33\",\"name\":\"온두라스\"},{\"id\":\"sa34\",\"name\":\"우루과이\"},{\"id\":\"sa35\",\"name\":\"자메이카\"},{\"id\":\"sa36\",\"name\":\"칠레\"},{\"id\":\"sa38\",\"name\":\"코스타리카\"},{\"id\":\"sa39\",\"name\":\"콜롬비아\"},{\"id\":\"sa40\",\"name\":\"쿠바\"},{\"id\":\"sa43\",\"name\":\"트리니다드토바고\"},{\"id\":\"sa44\",\"name\":\"파나마\"},{\"id\":\"sa45\",\"name\":\"파라과이\"},{\"id\":\"sa46\",\"name\":\"페루\"}]},{\"id\":\"cont7\",\"name\":\"오세아니아\",\"nations\":[{\"id\":\"oc02\",\"name\":\"나우루\"},{\"id\":\"oc04\",\"name\":\"뉴질랜드\"},{\"id\":\"oc07\",\"name\":\"마셜제도\"},{\"id\":\"oc08\",\"name\":\"미크로네시아\"},{\"id\":\"oc09\",\"name\":\"바누아투\"},{\"id\":\"oc11\",\"name\":\"사모아\"},{\"id\":\"oc12\",\"name\":\"솔로몬제도\"},{\"id\":\"oc13\",\"name\":\"오스트레일리아\"},{\"id\":\"oc17\",\"name\":\"키리바시\"},{\"id\":\"oc19\",\"name\":\"통가\"},{\"id\":\"oc20\",\"name\":\"투발루\"},{\"id\":\"oc21\",\"name\":\"파푸아뉴기니\"},{\"id\":\"oc22\",\"name\":\"팔라우\"},{\"id\":\"oc24\",\"name\":\"피지\"}]}]}";


        JsonParser jsonParser = new JsonParser();
        //parsing
        JsonObject jsonObject = (JsonObject) jsonParser.parse(json);
        //대륙 array
        JsonArray continents = (JsonArray) jsonObject.get("continents");

        ArrayList<Country> countries = new ArrayList<>();
        for(int i=0; i<continents.size(); i++) {
            JsonObject continentObject = (JsonObject) continents.get(i);
            JsonArray nations = (JsonArray) continentObject.get("nations");
//            System.out.println("대륙 : " + continentObject.get("name"));
            String continent = continentObject.get("name").toString().replace("\"", "");
            for(int j=0; j< nations.size(); j++) {
                JsonObject nationObject = (JsonObject) nations.get(j);
//                System.out.println("나라 : " + nationObject.get("name").toString().replace("\"", ""));
                String country =  nationObject.get("name").toString().replace("\"", "");
                Country con = new Country();
                con.setContinent(continent);
                con.setCountry_kr(country);
                countries.add(con);
            }
        }

        return crawler(countries);

    }

    private ArrayList<Country> crawler(ArrayList<Country> countries) {

        ArrayList<Country> countryList = new ArrayList<>();
        try {
            for(int i=0; i<countries.size(); i++) {
//            for(int i=0; i<30; i++) {
                System.out.println(i + " " + countries.get(i).getCountry_kr());

                //작업 시작
                Country temp = countries.get(i);

                String query = "";
                if(i != 29)
                    query = countries.get(i).getCountry_kr() + " 국가정보";
                else
                    query = query + countries.get(i).getCountry_kr();
                String url = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query="+query;
//                System.out.println(url);
                Document doc = Jsoup.connect(url).get();
                //나라이름_한국어 + 나라이름_영국어
                System.out.println(doc.select("dl.info_naflag dt").text());
                String country[] = doc.select("dl.info_naflag dt").text().split(" ");
                temp.setCountry_eng(country[1]);

                //수도
                String capital = doc.select("dl.info_naflag dd").first().text();
                System.out.println(capital.substring(3));
                temp.setCapital(capital.substring(3));
                
                //나라이미지 주소
                String image_path = doc.select("div.img_naflag img").attr("src");
                System.out.println(image_path);
                temp.setImage_path(image_path);

                //언어
                String language = doc.select("dl.lst_nadata dd").first().text();
                System.out.println(language);
                temp.setLanguage(language);

                //위도 + 경도
                String script = doc.select("div.api_subject_bx script").html();
//                System.out.println(script);
                String script_temp[] = script.split("\n");
                String lat_lng = script_temp[script_temp.length-1];
//                System.out.println(lat_lng);
                lat_lng = lat_lng.substring(lat_lng.indexOf("{ \"center"));
                lat_lng = (lat_lng.substring(0, lat_lng.indexOf(')')));
//                System.out.println(lat_lng);

                JsonParser jsonParser = new JsonParser();
                JsonObject jsonObject = (JsonObject) jsonParser.parse(lat_lng);
                JsonObject pos = (JsonObject) jsonObject.get("center");
                String lat = pos.get("lat").toString();
                String lng = pos.get("lng").toString();
                System.out.println(lat + " " + lng);

                temp.setLat(lat);
                temp.setLng(lng);

                countryList.add(temp);

                System.out.println(temp.toString());
                System.out.println("---------------------------------------------------------------OK");

                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return countryList;


    }

}
