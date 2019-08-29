package Demobank;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDaoImpl implements Userdao {
    @Override//取钱
    public boolean drawmoney(User1 user1) {
        try {
            String sql="insert into userInfo(dmoney,newmoney,dtime,username) values(?,?,?,?)";
            //建立连接   PreparedStatement比Statement好一些
            PreparedStatement ps=MyUtil.getPreparedStatement(sql);

            String username=user1.getUsername();
            String dmoney=user1.getDmoney();
            String newmoney=user1.getNewmoney();
            String dtime=user1.getDtime();

            ps.setString(1,dmoney);
            ps.setString(2,newmoney);
            ps.setString(3,dtime);
            ps.setString(4,username);

            int result=ps.executeUpdate();
            if(result>0){
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override//存钱
    //(smoney,newmoney,time)
    public boolean savemoney(User2 user2) {
        try {
            String sql="insert into userInfo(smoney,newmoney,time,username) values(?,?,?,?)";
            //建立连接   PreparedStatement比Statement好一些
            PreparedStatement ps=MyUtil.getPreparedStatement(sql);
            String username=user2.getUsername();
            String time=user2.getTime();
            String smoney=user2.getSmoney();
            String newmoney=user2.getNewmoney();
            ps.setString(1,smoney);
            ps.setString(2,newmoney);
            ps.setString(3,time);
            ps.setString(4,username);
            int result=ps.executeUpdate();
            if(result>0){
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override//转账
    public boolean transmoney(User3 user3) {
        try {
            String sql="insert into userInfo(tmoney,account,ttime,username) values(?,?,?,?)";
            //建立连接
            PreparedStatement ps=MyUtil.getPreparedStatement(sql);
            String username=user3.getUsername();
            String tmoney=user3.getTmoney();
            String account=user3.getAccount();
            String ttime=user3.getTtime();

            ps.setString(1,tmoney);
            ps.setString(2,account);
            ps.setString(3,ttime);
            ps.setString(4,username);
            int result=ps.executeUpdate();
            if(result>0){
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override//登录
    public boolean Denglu(String username, String password) {
        return false;
    }

    @Override//注册
    public boolean register(User user) {
        String sql="insert into userInfo(name,userid,username,password,money) values(?,?,?,?,?)";
        PreparedStatement  ps=MyUtil.getPreparedStatement(sql);
        //因为这里是增加数据，需要传人用户名和密码
        String name=user.getName();
        String userid=user.getUserid();
        String username=user.getUsername();
        String password=user.getPassword();
        String money=user.getMoney();
        try {
            //这里表示第一列是username  第二列是password
            ps.setString(1, name);
            ps.setString(2, userid);
            ps.setString(3, username);
            ps.setString(4, password);
            ps.setString(5, money);

            int result=ps.executeUpdate();
            if(result>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }


    }

