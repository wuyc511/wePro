package Demobank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class MyUtil {
    //定义一个方法实现连接数据库    PreparedStatement比Statement好一些
    //需要一个静态方法
    public static PreparedStatement getPreparedStatement(String sql) {
        PreparedStatement ps=null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
                    "scott", "tiger");
            ps=conn.prepareStatement(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }   catch (SQLException ex) {
            Logger.getLogger(MyUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        //这里返回一个ps
        return ps;
    }


}


