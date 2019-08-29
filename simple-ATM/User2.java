package Demobank;

public class User2 {
    private  String username;
    private String smoney;
    private String newmoney;
    private String time;
    public User2() {

    }

    public User2(String smoney, String newmoney,String  time,String username) {
        this.smoney = smoney;
        this.newmoney = newmoney;
        this.time=time;
        this.username=username;
    }

    public String getSmoney() {
        return smoney;
    }

    public void setSmoney(String smoney) {
        this.smoney = smoney;
    }

    public String getNewmoney() {
        return newmoney;
    }

    public void setNewmoney(String newmoney) {
        this.newmoney = newmoney;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
