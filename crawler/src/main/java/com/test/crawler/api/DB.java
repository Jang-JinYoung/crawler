package com.test.crawler.api;

import com.test.crawler.model.Cafe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class DB {

    Connection conn = null;

    public void insert(ArrayList<Cafe> cafeList) {
        com.test.crawler.config.DB db = new com.test.crawler.config.DB();

        try {

            PreparedStatement pstat = null;
            Connection conn  = db.open();


            for(Cafe cafe : cafeList) {
                String sql = "insert into tblCafe values (seqCafe.nextVal, ?, ?, ?)";

                pstat = conn.prepareStatement(sql);

                pstat.setString(1, cafe.getTitle());
                pstat.setString(2, cafe.getAddress());
                pstat.setString(3, cafe.getMenus());

                //메뉴가 비어있는건 넣지 않겠습니다
                if(!cafe.getMenus().isEmpty())
                    pstat.execute();

            }

            pstat.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("API.DB()" + e);
        }

    }
}
