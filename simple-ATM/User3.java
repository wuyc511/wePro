package Demobank;

public class User3 {
    private  String username;
    String tmoney;
    String account;
    String ttime;
    public User3(){
    }

    public User3(String tmoney, String account,String ttime,String username) {
        this.tmoney = tmoney;
        this.account = account;
        this.ttime=ttime;
        this.username=username;
    }

    public String getTmoney() {
        return tmoney;
    }

    public void setTmoney(String tmoney) {
        this.tmoney = tmoney;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getTtime() {
        return ttime;
    }

    public void setTtime(String ttime) {
        this.ttime = ttime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
