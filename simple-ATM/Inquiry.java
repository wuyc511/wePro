package Demobank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Inquiry 此类时对用户信息查询的编写，
 * 我们将查询出用户的姓名、身份证号和账户余额
 * 此类还实现了对用户的身份证号信息进行保护（隐藏）
 * 还进行对用户的 姓名的第一个字变为* 起到保护用户个人隐私
 * @author contentcl
 * @Date 2019年5月8日 上午8:54:17
 *
 */
public class Inquiry extends JFrame implements ActionListener {

    JLabel jlb1, jlb2, jlb3;  //标签
    JTextField jtf1,jtf2,jtf3;   //文本框
    JPasswordField jpf; //密码框
    JPanel jp1,jp2,jp3;		//面板

    public Inquiry(String countname) throws IOException {
        setBg();
        //标签信息
        jlb1 = new JLabel(" 姓名:");
        jlb2 = new JLabel("身份证号:");
        jlb3 = new JLabel(" 余额:");
        jlb1.setFont(new Font("楷体",Font.PLAIN,22));
        jlb2.setFont(new Font("楷体",Font.PLAIN,22));
        jlb3.setFont(new Font("楷体",Font.PLAIN,22));
        jlb1.setForeground(Color.green);
        jlb2.setForeground(Color.red);
        jlb3.setForeground(Color.blue);

        jtf1 = new JTextField(13);
        jtf2 = new JTextField(13);
        jtf3 = new JTextField(13);

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();

        jp1.add(jlb1);
        jp1.add(jtf1);
        jp2.add(jlb2);
        jp2.add(jtf2);
        jp3.add(jlb3);
        jp3.add(jtf3);

        //设置布局
        this.setTitle("查询");
        this.setLayout(null);   //采用空布局

        jp1.setBounds(200,50,200,70);
        jp2.setBounds(200,130,200,70);
        jp3.setBounds(200,210,200,70);
        //将JPane加入JFrame中
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        //把背景面板设为透明的
        jp1.setOpaque(false);
        jp2.setOpaque(false);
        jp3.setOpaque(false);
        //this.setSize(300, 300);   //设置窗体大小
        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置仅关闭当前窗口
        this.setSize(600, 500);   //设置窗体大小
        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)
        this.setVisible(true);  //设置可见
        this.setResizable(false);	//设置不可拉伸大小

        //设置背景图片

        String [] message = new UserMessage().read(countname);

        //将姓名的第一个字变为*
        message[0] ="*"+message[0].substring(1,message[0].length());
        //对客户信息进行隐藏--> 将身份证号第6到12位变成*
        message[1] =message[1].substring(0,6)+"*******"+message[1].substring(13,message[1].length());

        jtf1.setText(message[0]);
        jtf2.setText(message[1]);
        jtf3.setText(message[4]);
    }
    //面板调用
    public void setBg(){
        ((JPanel)this.getContentPane()).setOpaque(false);
        ImageIcon img=new ImageIcon("C:\\Users\\Joker\\Pictures\\10.jpg");
        JLabel background=new JLabel(img);
        this.getLayeredPane().add(background,new Integer(Integer.MIN_VALUE));
        background.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
    }
}
