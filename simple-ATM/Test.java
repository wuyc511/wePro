package Demobank;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test extends JFrame {
    private final String username;
    //定义组件
    private JScrollPane j1;
    private JTableHeader j2;
    private JTable j3;
    private JButton j4,j5;

    public Test(String username) {
        super("银行记录查询结果");
        setBg();
        this.username=username;
        this.setSize(1200, 450);
        this.setLayout(null);
        this.setLocation(100, 130);
        //创建组件
        this.j1 = new JScrollPane();
        this.j1.setBounds(20, 70, 1160, 250);
        this.j4 = new JButton("查询");
        this.j4.setBounds(360, 350, 150, 45);
        this.j5=new JButton("退出查询");
        this.j5.setBounds(750,350,150,45);

        add(this.j1);
        add(this.j4);
        add(this.j5);
        this.setVisible(true);
//给按钮注册监听
//点击按钮时的事件处理
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
    public void setBg() {
        ((JPanel) this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon("C:\\Users\\Joker\\Pictures\\a5.jpg");
        JLabel background = new JLabel(img);
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
    }
    }
