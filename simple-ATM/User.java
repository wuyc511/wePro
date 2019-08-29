package Demobank;

public class User {

    private String name;
    private String userid;
    private String username;
    private String password;
    private String money;

    public User() {

    }

    public User(String name, String userid, String username, String password, String money) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.userid = userid;
        this.money = money;

    }


    /**
     * @return the username
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}