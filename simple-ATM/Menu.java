package Demobank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

/**
 *
 * @author contentcl
 * Menu类是一个 菜单类，也是最为底层的一个类
 * 提供各个功能的按钮 ：查询、存款、取款、转账、改密、开户、退卡和挂失
 *
 * 此类未使用布局， 所以使用坐标固定了各个标签和按钮的位置
 *
 */

public class Menu extends JFrame implements ActionListener {
//MyButton r1 ,r2;
    JButton jb6,jb7, jb8,jb9;  //创建按钮
    JLabel jlb1, jlb2, jlb3;   //标签

    public Menu(){  //构造方法


        jb6 = new JButton("开户");
        jb8 = new JButton("挂失");
        jb9 = new JButton("登录");
        jb7 = new JButton("退卡");


        jlb1 = new JLabel("你还不知足！！银行");
        jlb1.setFont(new   java.awt.Font("Dialog",   1,   28)); //设置字体类型， 是否加粗，字号
        jlb2 = new JLabel("欢迎您");
        jlb2.setFont(new   java.awt.Font("Dialog",   1,   20));
        jlb3 = new JLabel("请您选择服务");
        jlb3.setFont(new   java.awt.Font("Dialog",   1,   22));
        jlb1.setFont(new Font("楷体",Font.PLAIN,40));
        jlb2.setFont(new Font("楷体",Font.PLAIN,40));
        jlb3.setFont(new Font("楷体",Font.PLAIN,30));
        jb9.setFont(new Font("楷体",Font.PLAIN,20));
        jb8.setFont(new Font("楷体",Font.PLAIN,20));
        jb6.setFont(new Font("楷体",Font.PLAIN,20));
        jb7.setFont(new Font("楷体",Font.PLAIN,20));
        jb6.setForeground(Color.black);
        jb7.setForeground(Color.black);
        jlb1.setForeground(Color.black);
        jlb2.setForeground(Color.yellow);
        jlb3.setForeground(Color.red);
        jb9.setForeground(Color.green);
        jb8.setForeground(Color.blue);
        ImageIcon ii=new ImageIcon("C:\\Users\\Joker\\Pictures\\9.jpg");
        JLabel b1=new JLabel(ii);
        b1.setBounds(0,0,ii.getIconWidth(),ii.getIconHeight());

        jb6.addActionListener(this);
        jb7.addActionListener(this);
        jb8.addActionListener(this);
        jb9.addActionListener(this);

        this.setTitle("银行管理管理系统");  //设置窗体标题
        this.setSize(600, 500);   //设置窗体大小
        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置仅关闭当前窗口
        this.setLayout(null);			//设置布局，不采用布局

        //设置按钮的位置和大小

        jb6.setBounds(100,320,80,50);
        jb8.setBounds(200,320,80,50);
        jb9.setBounds(300,320,80,50);
        jb7.setBounds(400,320,80,50);

        //设置标签的位置和大小
        jlb1.setBounds(130,90,400,50);
        jlb2.setBounds(230,150,150,50);
        jlb3.setBounds(200,220,250,50);


        this.add(jb6);
        this.add(jb7);
        this.add(jb8);
        this.add(jb9);
        this.add(jlb1);
        this.add(jlb2);
        this.add(jlb3);
        this.add(b1);
        //this.add(p1);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);  //设置可关闭

        this.setVisible(true);  //设置可见
        this.setResizable(false);	//设置不可拉伸大小
    }


    @Override
    public void actionPerformed(ActionEvent e){

       if (e.getActionCommand()=="开户"){
            new Register();  //跳转开户界面
        }
        else if (e.getActionCommand()=="挂失"){
            new ReportLose();
        }
        else if (e.getActionCommand()=="退卡"){
            System.exit(0);
        }
        else if(e.getActionCommand()=="登录"){
           new Login1(e.getActionCommand());
           dispose();
        }
    }
  private   class MyJpanel extends JPanel {
        ImageIcon bg;
        public MyJpanel(URL bg){
            this.setOpaque(false);
            this.bg=new ImageIcon(bg);
        }
        public void paintComponent(Graphics g){
            g.drawImage(bg.getImage(),0,0,this);
            super.paintComponent(g);
        }
    }
}