package Demobank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Denglu extends JFrame implements ActionListener {
        JButton jb1, jb2, jb3, jb4, jb5,jb7,jb8;  //创建按钮
        JLabel jlb1, jlb2;   //标签
        String username;

        public Denglu(String username) {  //构造方法
            this.username=username;
            jb1 = new JButton("查询");
            jb2 = new JButton("存款");
            jb3 = new JButton("取款");
            jb4 = new JButton("转账");
            jb5 = new JButton("改密");
            jb7 = new JButton("退卡");
            jb8 = new JButton("查询记录");
            jlb1=new JLabel("欢迎光临！！");
            jlb2=new JLabel("请选择您的服务");

            ImageIcon ii = new ImageIcon("C:\\Users\\Joker\\Pictures\\9.jpg");
            JLabel b1 = new JLabel(ii);
            b1.setBounds(0, 0, ii.getIconWidth(), ii.getIconHeight());

        jb1.addActionListener(this);   //事件监听
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);
        jb5.addActionListener(this);
        jb7.addActionListener(this);
        jb8.addActionListener(this);


            this.setTitle("银行管理管理系统");  //设置窗体标题
            this.setBounds(300, 180, 600, 500);
            this.setLayout(null);            //设置布局，不采用布局

            //设置按钮的位置和大小
        jb1.setBounds( 0,50,90,60);
        jb2.setBounds( 0,150,90,60);
        jb3.setBounds( 0,250,90,60);
        jb4.setBounds( 500,50,90,60);
        jb5.setBounds( 500,150,90,60);
        jb7.setBounds(500,250,90,60);
        jb8.setBounds(220,400,150,60);
        jlb1.setBounds(220,80,250,150);
        jlb2.setBounds(200,130,250,150);
        //设置字体
            jlb1.setFont(new Font("楷体",Font.PLAIN,30));
            jlb2.setFont(new Font("楷体",Font.PLAIN,30));
            jb1.setFont(new Font("楷体",Font.PLAIN,20));
            jb2.setFont(new Font("楷体",Font.PLAIN,20));
            jb3.setFont(new Font("楷体",Font.PLAIN,20));
            jb4.setFont(new Font("楷体",Font.PLAIN,20));
            jb5.setFont(new Font("楷体",Font.PLAIN,20));
            jb7.setFont(new Font("楷体",Font.PLAIN,20));
            jb8.setFont(new Font("楷体",Font.PLAIN,20));
        //设置文字颜色
            jlb1.setForeground(Color.red);
            jlb2.setForeground(Color.blue);
            jb1.setForeground(Color.red);
            jb2.setForeground(Color.green);
            jb3.setForeground(Color.black);
            jb4.setForeground(Color.blue);
            jb5.setForeground(Color.yellow);
            jb7.setForeground(Color.pink);
            jb8.setForeground(Color.black);
        this.add(jb1);   //加入窗体
        this.add(jb2);
        this.add(jb3);
        this.add(jb4);
        this.add(jb5);
        this.add(jb7);
        this.add(jb8);
        this.add(jlb1);
        this.add(jlb2);
        this.add(b1);

            this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);  //设置可关闭
            this.setVisible(true);  //设置可见
            this.setResizable(false);    //设置不可拉伸大小
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if (e.getActionCommand() == "查询") {
                //String order = e.getActionCommand();
                try {
                    new Inquiry(username);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                //new Login(e.getActionCommand());
            } else if (e.getActionCommand() == "存款") {
                new SaveMoney(username);
                //new Login(e.getActionCommand());
            } else if (e.getActionCommand() == "取款") {
                new DrawMoney(username);
            } else if (e.getActionCommand() == "转账") {
                new Transfer(username);
            } else if (e.getActionCommand() == "改密") {
                new Modify(username);
            }
            else if (e.getActionCommand() == "查询记录") {
                new Test1();
            }
            else if (e.getActionCommand() == "退卡") {
                new Menu();
               // System.exit(0);
            }

        }
    }
