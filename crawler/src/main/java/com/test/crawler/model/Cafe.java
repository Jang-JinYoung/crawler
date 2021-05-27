package com.test.crawler.model;

public class Cafe {

    //카페이름
    private String title;
    //카페주소
    private String address;
    //카페메뉴+가격
    private String menus;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMenus() {
        return menus;
    }

    public void setMenus(String menus) {
        this.menus = menus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
