package crawler.api;

import crawler.model.Country;
import org.checkerframework.checker.units.qual.C;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DB {
    public void main(ArrayList<Country> countries) {
        crawler.config.DB db = new crawler.config.DB();

        Connection conn = db.open();
        PreparedStatement pstat = null;
        ResultSet rs = null;

        try {

            for(int i=0; i<countries.size(); i++) {
                Country country = countries.get(i);

                String query = "insert into countryInfo (country_kr, country_eng, capital, continent, latitude, longitude, language, image_path) \n" +
                        "values (?, ?, ?, ?, ?, ?, ?, ?)";
                pstat = conn.prepareStatement(query);
                pstat.setString(1, country.getCountry_kr());
                pstat.setString(2, country.getCountry_eng());
                pstat.setString(3, country.getCapital());
                pstat.setString(4, country.getContinent());
                pstat.setString(5, country.getLat());
                pstat.setString(6, country.getLng());
                pstat.setString(7, country.getLanguage());
                pstat.setString(8, country.getImage_path());

                int result = pstat.executeUpdate();
            }


        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }



    }
}