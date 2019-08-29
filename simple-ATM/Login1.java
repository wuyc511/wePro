package Demobank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Login1 extends JFrame implements ActionListener {
    private static final Object BorderLayout =null ;
    JLabel lb_backgroud;
    JButton jb1, jb2,jb3;  //按钮
    JPanel jp1, jp2, jp3;        //面板
    JTextField jtf;   //文本框
    JLabel jlb1, jlb2; //标签
    JPasswordField jpf; //密码框

    String username = "123";   //账号密码
    String passwordd = "123";
    String order;
    public Login1(String order) {
        setBg();//调用下面写的背景图片
        //添加图标
        Image logo1 = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Joker\\Pictures\\10.jpg");
        setIconImage(logo1);
        TrayIcon icon = new TrayIcon(logo1);
        icon.setImageAutoSize(true);
        SystemTray systemTray = SystemTray.getSystemTray();
        try {
            systemTray.add(icon);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        this.order = order;
        jb1 = new JButton("登录");
        jb2 = new JButton("重置");
        jb3 = new JButton("返回");
        jb1.setFont(new Font("楷体",Font.PLAIN,19));
        jb1.setForeground(Color.blue);
        jb2.setFont(new Font("楷体",Font.PLAIN,19));
        jb2.setForeground(Color.red);
        jb3.setFont(new Font("楷体",Font.PLAIN,19));
        jb3.setForeground(Color.green);

        //设置按钮监听

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);

        jp1 = new JPanel();  //创建面板
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp1.setBounds(150,80,300,80);
        jp2.setBounds(150,160,300,80);
        jp3.setBounds(150,280,300,80);
        //设置按钮监听

        jlb1 = new JLabel("请输入账号：");  //添加标签
        jlb2=new JLabel("请输入密码：");
        jlb1.setFont(new Font("楷体",Font.PLAIN,22));
        jlb1.setForeground(Color.orange);
        jlb2.setFont(new Font("楷体",Font.PLAIN,22));
        jlb2.setForeground(Color.orange);
        //创建文本框
        jtf = new JTextField(15);
        jpf = new JPasswordField(15);

        //加入面板
        jp1.add(jlb1);
        jp1.add(jtf);

        jp2.add(jlb2);
        jp2.add(jpf);

        jp3.add(jb1);
        jp3.add(jb2);
        jp3.add(jb3);
        //将JPane加入JFrame中
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        //把背景面板设为透明的
        jp1.setOpaque(false);
        jp2.setOpaque(false);
        jp3.setOpaque(false);

        //设置布局
        this.setTitle("用户登录");
        // this.setLayout(new GridLayout(3, 1));
        this.setLayout((LayoutManager) BorderLayout);
        this.setSize(600, 500);   //设置窗体大小
        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置仅关闭当前窗口

        this.setVisible(true);  //设置可见
        this.setResizable(false);    //设置不可拉伸大小
    }
    //设置背景图片
    public void setBg(){
        ((JPanel)this.getContentPane()).setOpaque(false);
        ImageIcon img=new ImageIcon("C:\\Users\\Joker\\Pictures\\10.jpg");
        JLabel background=new JLabel(img);
        this.getLayeredPane().add(background,new Integer(Integer.MIN_VALUE));
        background.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "登录") {
            try {
                login();
            } catch (HeadlessException | IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getActionCommand() == "重置") {
            clear();
        }else if(e.getActionCommand() == "返回"){
            new Menu();
        }
    }

    //清空账号和密码框
    private void clear() {
        jtf.setText("");    //设置为空
        jpf.setText("");

    }

    //验证登录信息，并做处理
    public void login() throws HeadlessException, IOException {
        //判断账户名和密码是否包含中文
        if (new Check().checkcountname(jtf.getText()) || new Check().checkcountname(jpf.getText())) {
            JOptionPane.showMessageDialog(null, "用户名或密码存在中文，不合法!", "消息提示", JOptionPane.WARNING_MESSAGE);
        } else if (jtf.getText().isEmpty() && jpf.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "账号密码为空，请输入！", "消息提示", JOptionPane.WARNING_MESSAGE);
        } else if (jtf.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "账号为空，请输入！", "消息提示", JOptionPane.WARNING_MESSAGE);
        } else if (jpf.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "密码为空，请输入！", "消息提示", JOptionPane.WARNING_MESSAGE);

        } else if (new Check().check1(jtf.getText(), jpf.getText())) {
            JOptionPane.showMessageDialog(null, "登录成功！", "提示消息", JOptionPane.WARNING_MESSAGE);
            //dispose();  //使文原窗体消失
            if (order.equals("登录")) {
                new Denglu(jtf.getText());
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "账号密码错误请重新输入！", "消息提示", JOptionPane.ERROR_MESSAGE);
                clear();  //调用清除函数
            }
        }
    }

    public static void main(String[] args) {
        new Login1("登录");
    }
}
