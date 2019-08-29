package Demobank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/*
 * Login
 * 此类是用户登录
 * 此类同时实现了 清空账号和密码框、验证登录信息，并做处理
 * 跳转到登录个人信息选项界面
 * */
public class Login extends JFrame implements ActionListener {
    private static final Object BorderLayout =null ;
    JLabel lb_backgroud;
    JButton jb1, jb2;  //按钮
    JPanel jp1, jp2, jp3,jp4;        //面板
    JTextField jtf;   //文本框
    JLabel jlb1, jlb2; //标签
    JPasswordField jpf; //密码框

    String username = "123";   //账号密码
    String passwordd = "123";
    String order;
    public Login(String order) {
        setBackgroudImage();
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

        /*ImageIcon ii = new ImageIcon("C:\\Users\\Joker\\Pictures\\10.jpg");
        JLabel b1 = new JLabel(ii);*/
        //b1.setBounds(0, 0, ii.getIconWidth(), ii.getIconHeight());
        //设置按钮监听
        /*jb1.setBounds(180,400,100,50);
        jb2.setBounds(420,400,100,50);
*/
        jb1.addActionListener(this);
        jb2.addActionListener(this);

        jp1 = new JPanel();  //创建面板
        jp2 = new JPanel();
        jp3 = new JPanel();
jp1.setBounds(120,50,200,50);
jp2.setBounds(120,100,200,50);
jp3.setBounds(120,160,200,50);
        //设置按钮监听
      /*  jb3.addActionListener(this);
        jb4.addActionListener(this);
        jb5.addActionListener(this);
        jb6.addActionListener(this);
        jb7.addActionListener(this);
        jb8.addActionListener(this);*/

        jlb1 = new JLabel("请输入账号：");  //添加标签
        jlb2=new JLabel("请输入密码：");
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

        //将JPane加入JFrame中
        /*this.add(jlb1);
        this.add(jtf);
        this.add(jlb2);
        this.add(jpf);*/
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
       // this.add(b1);
        //设置布局
        this.setTitle("用户登录");
       // this.setLayout(new GridLayout(3, 1));
        this.setLayout((LayoutManager) BorderLayout);
        this.setSize(450, 350);   //设置窗体大小
        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置仅关闭当前窗口

        this.setVisible(true);  //设置可见
        this.setResizable(false);    //设置不可拉伸大小
    }

    private void setBackgroudImage() {
        ((JPanel) this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon("C:\\Users\\Joker\\Pictures\\10.jpg"); // 添加图片
        lb_backgroud = new JLabel(img);
        this.getLayeredPane().add(lb_backgroud, new Integer(Integer.MIN_VALUE));
        lb_backgroud.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
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
}
