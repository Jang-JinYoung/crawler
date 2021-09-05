package crawler.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

    private static Connection conn;

    /**
     * 데이터 베이스 연결 메소드 입니다.
     * @return 연결된 Connection 객체를 반환합니다.
     */
    public static Connection open() {

        String url = "";
        String id = "";
        String pw = "";
        // 수정 테스트
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, id, pw);
            return conn;
        } catch (Exception e) {
            System.out.println("DB.open()"+e);
            e.printStackTrace();
        }

        return null;
    }

}
