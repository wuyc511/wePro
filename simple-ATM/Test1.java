package Demobank;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test1  extends JFrame {
    //private final String username;
    //定义组件
    private JLabel la1;
    private JTextArea t1;
    private JScrollPane j1;
    private JTableHeader j2;
    private JTable j3;
    private JButton j4,j5,b1,b2,b3;
    public Test1() {
        super("银行记录查询结果");
        setBg();
        this.setSize(750, 530);
        this.setLayout(null);
        this.setLocation(300, 80);
        //创建组件
        this.j1 = new JScrollPane();
        this.j1.setBounds(20, 20, 700, 300);

        this.j4 = new JButton("查询全部");
        this.j4.setBounds(10, 390, 180, 40);
        this.j5=new JButton("退出查询");
        this.j5.setBounds(450,440,180,40);
        this.b1=new JButton("查询取款记录");
        this.b1.setBounds(290, 390, 180, 40);
        this.b2=new JButton("查询存款记录");
        this.b2.setBounds(540, 390, 180, 40);
        this.b3=new JButton("查询转账记录");
        this.b3.setBounds(150, 440, 180, 40);

        b1.setFont(new Font("楷体",Font.PLAIN,19));
        b1.setForeground(Color.green);
        b2.setFont(new Font("楷体",Font.PLAIN,19));
        b2.setForeground(Color.red);
        b3.setFont(new Font("楷体",Font.PLAIN,19));
        b3.setForeground(Color.blue);
        j4.setFont(new Font("楷体",Font.PLAIN,19));
        j4.setForeground(Color.orange);
        j5.setFont(new Font("楷体",Font.PLAIN,19));
        j5.setForeground(Color.pink);
        la1=new JLabel("请输入要查询的账号：");
        la1.setFont(new Font("楷体",Font.PLAIN,19));
        la1.setForeground(Color.black);
        t1=new JTextArea();
        la1.setBounds(140, 330, 250, 40);
        t1.setBounds(350, 330, 200, 40);
        t1.setFont(new   java.awt.Font("Dialog",   0,   15));
        add(this.la1);
        add(this.t1);
        add(this.j1);
        add(this.j4);
        add(this.j5);
        add(this.b1);
        add(this.b2);
        add(this.b3);
        this.setVisible(true);
//给按钮注册监听
//点击按钮时的事件处理     取款
        this.b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s1=null;
                s1=t1.getText();
                String sql = "select username,dmoney,dtime from userInfo where username="+s1+" and dmoney is not null";
                //建立连接
                PreparedStatement ps = MyUtil.getPreparedStatement(sql);
                ResultSet rs = null;
                try {
                    rs = ps.executeQuery();
                    //计算有多少条数据
                    int count = 0;
                    while (rs.next()) {
                        count++;
                    }
                    try {
                        rs = ps.executeQuery();
                    } catch (SQLException e2) {
                        e2.printStackTrace();
                    }
                    //将查询获得的记录数据转换成适合生成JTable的数据形式
                    Object[][] info = new Object[count][3];
                    count = 0;
                    while (rs.next()) {
                        info[count][0] = rs.getString("username");
                        info[count][1] = rs.getString("dmoney");
                        info[count][2] = rs.getString("dtime");
                        count++;
                    }
                    //定义表头
                    String[] title = { "账户", "取款金额","取款时间"};
                    //创建JTable
                    j3 = new JTable(info, title);
                    //显示表头
                    j2 = j3.getTableHeader();
                    //将JTable加入到带滚动条的面板中
                    j1.getViewport().add(j3);

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        //存款
        this.b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s1=null;
                s1=t1.getText();
                //s1="%"+s1+"%";
                //String sql = "select username,smoney,time from userInfo where username like '%"+s1+"%'";and 's1'like ?
                String sql = "select username,smoney,time from userInfo  where username="+s1+" and smoney is not null ";
                //建立连接
                PreparedStatement ps = MyUtil.getPreparedStatement(sql);

                ResultSet rs = null;
                try {
                    rs = ps.executeQuery();

                    //计算有多少条数据
                    int count = 0;
                    while (rs.next()) {
                        count++;
                    }
                    try {
                        rs = ps.executeQuery();
                    } catch (SQLException e2) {
                        e2.printStackTrace();
                    }
                    //将查询获得的记录数据转换成适合生成JTable的数据形式
                    Object[][] info = new Object[count][3];
                    count = 0;
                    while (rs.next()) {
                        info[count][0] = rs.getString("username");
                        info[count][1] = rs.getString("smoney");
                        info[count][2] = rs.getString("time");
                        count++;
                    }
                    //定义表头
                    String[] title = {"账户", "存款金额",    "存款时间"};
                    //创建JTable
                    j3 = new JTable(info, title);
                    //显示表头
                    j2 = j3.getTableHeader();
                    //将JTable加入到带滚动条的面板中
                    j1.getViewport().add(j3);

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
       //转账
        this.b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s1=null;
                s1=t1.getText();
                String sql = "select username,tmoney,account,ttime from userInfo where username="+s1+" and tmoney is not null";
                //建立连接
                PreparedStatement ps = MyUtil.getPreparedStatement(sql);

                ResultSet rs = null;
                try {
                    rs = ps.executeQuery();

                    //计算有多少条数据
                    int count = 0;
                    while (rs.next()) {
                        count++;
                    }
                    try {
                        rs = ps.executeQuery();
                    } catch (SQLException e2) {
                        e2.printStackTrace();
                    }
                    //将查询获得的记录数据转换成适合生成JTable的数据形式
                    Object[][] info = new Object[count][4];
                    count = 0;
                    while (rs.next()) {
                        info[count][0] = rs.getString("username");
                        info[count][1] = rs.getString("tmoney");
                        info[count][2] = rs.getString("account");
                        info[count][3] = rs.getString("ttime");
                        count++;
                    }
                    //定义表头
                    String[] title = {"账户", "转账金额","转账账户", "转账时间"};
                    //创建JTable
                    j3 = new JTable(info, title);
                    //显示表头
                    j2 = j3.getTableHeader();
                    //将JTable加入到带滚动条的面板中
                    j1.getViewport().add(j3);

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        //按钮j4的事件  查询全部
        this.j4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String sql = "select * from userInfo";
                    //建立连接
                    PreparedStatement ps = MyUtil.getPreparedStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    //计算有多少条数据
                    int count = 0;
                    while (rs.next()) {
                        count++;
                    }
                    rs = ps.executeQuery();
                    //将查询获得的记录数据转换成适合生成JTable的数据形式
                    Object[][] info = new Object[count][13];
                    count = 0;
                    while (rs.next()) {
                        info[count][0] = rs.getString("name");
                        info[count][1] = rs.getString("userid");
                        info[count][2] = rs.getString("username");
                        info[count][3] = rs.getString("password");
                        info[count][4] = rs.getString("money");
                        info[count][5] = rs.getString("dmoney");
                        info[count][6] = rs.getString("smoney");
                        info[count][7] = rs.getString("newmoney");
                        info[count][8] = rs.getString("tmoney");
                        info[count][9] = rs.getString("account");
                        info[count][10] = rs.getString("time");
                        info[count][11] = rs.getString("dtime");
                        info[count][12] = rs.getString("ttime");
                        count++;
                    }
                    //定义表头

                    String[] title = {"姓名", "身份证", "账户", "密码", "开户金额", "取款金额", "存款金额", "剩余金额","转款金额","转款账户","存款时间","取款时间","转帐时间"};
                    //创建JTable
                    j3 = new JTable(info, title);
                    //显示表头
                    j2 = j3.getTableHeader();
                    //将JTable加入到带滚动条的面板中
                    j1.getViewport().add(j3);

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        this.j5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        new Test1();
    }
    public void setBg(){
        ((JPanel)this.getContentPane()).setOpaque(false);
        ImageIcon img=new ImageIcon("C:\\Users\\Joker\\Pictures\\10.jpg");
        JLabel background=new JLabel(img);
        this.getLayeredPane().add(background,new Integer(Integer.MIN_VALUE));
        background.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
    }

}
