package Demobank;

public interface Userdao {
    //登录   注册  取款
    boolean Denglu(String username,String password);
    boolean register(User user);
    boolean drawmoney(User1 user1);
    boolean savemoney(User2 user2);
    boolean transmoney(User3 user3);
}
