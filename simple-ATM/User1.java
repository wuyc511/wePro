package Demobank;

public class User1 {
    private  String username;
    private String dmoney;
    private String newmoney;
    private String dtime;

    public User1() {

    }

    public User1( String dmoney, String newmoney,String dtime,String username) {

        this.dmoney = dmoney;
        this.newmoney = newmoney;
        this.dtime=dtime;
        this.username=username;
    }


    public String getDmoney() {
        return dmoney;
    }

    public void setDMoney(String dmoney) {
        this.dmoney = dmoney;
    }

    public String getNewmoney() {
        return newmoney;
    }

    public void setNewmoney(String newmoney) {
        this.newmoney = newmoney;
    }

    public String getDtime() {
        return dtime;
    }

    public void setDtime(String dtime) {
        this.dtime = dtime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
