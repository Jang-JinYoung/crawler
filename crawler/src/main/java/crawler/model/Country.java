package crawler.model;

public class Country {

    private String continent;
    private String country_kr;
    private String country_eng;
    private String capital;
    private String image_path;
    private String language;
    private String lat;
    private String lng;

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCountry_kr() {
        return country_kr;
    }

    public void setCountry_kr(String country_kr) {
        this.country_kr = country_kr;
    }

    public String getCountry_eng() {
        return country_eng;
    }

    public void setCountry_eng(String country_eng) {
        this.country_eng = country_eng;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Country{" +
                "continents='" + continent + '\'' +
                ", country_kr='" + country_kr + '\'' +
                ", country_eng='" + country_eng + '\'' +
                ", capital='" + capital + '\'' +
                ", image_path='" + image_path + '\'' +
                ", language='" + language + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                '}';
    }
}
