package Demobank;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DrawMoney
 * 本类实现 对取钱操作的实现，
 * 主要思路 实现对用户金额的修改
 * 但在输入金额是 要判断 金额的大小 是否能够取出  且不能出现负数
 * 取钱必须使用同步锁
 *
 * @author contentcl
 * @Date 2019年5月7日 下午7:58:09
 *
 */
public class DrawMoney extends JFrame implements ActionListener {
    String countname;
    JButton jb1, jb2;  //按钮
    JLabel jlb1, jlb2; //标签
    JTextArea jta1,jta2;
    Date date=new Date();
    SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String username;
        public DrawMoney(String username) {
            setBg();
            this.username = username;
            //添加图标
            Image logo = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Joker\\Pictures\\10.jpg");
            setIconImage(logo);
            TrayIcon icon = new TrayIcon(logo);
            icon.setImageAutoSize(true);
            SystemTray systemTray = SystemTray.getSystemTray();
            try {
                systemTray.add(icon);
            } catch (AWTException e) {
                e.printStackTrace();
            }

            jb1 = new JButton("确定");
            jb2 = new JButton("重置");

            jb1.setFont(new Font("楷体",Font.PLAIN,19));
            jb1.setForeground(Color.green);
            jb2.setFont(new Font("楷体",Font.PLAIN,19));
            jb2.setForeground(Color.blue);
        //设置按钮监听
            jb1.addActionListener(this);
            jb2.addActionListener(this);


            jlb1 = new JLabel("请输入取款金额：");  //添加标签
            jlb1.setFont(new Font("楷体",Font.PLAIN,22));
            jlb1.setForeground(Color.red);
        //创建文本框
        jta1 = new JTextArea();
        jta2 = new JTextArea();


        //设置布局
        this.setTitle("取款");
        this.setLayout(null);
        this.setSize(600, 500);

        //存入标签和文本框
        jlb1.setBounds(200, 80, 200, 20);
        jta1.setBounds(170, 140, 250, 50);
        jta1.setFont(new   java.awt.Font("Dialog",   0,   15));

        //确定和重置按钮
        jb1.setBounds(200, 220, 90, 28);
        jb2.setBounds(300, 220, 90, 28);

        //显示结果文本框

        jta2.setBounds(170, 270, 250, 50);
        jta2.setFont(new   java.awt.Font("Dialog",   0,   15));

        this.add(jlb1);
        this.add(jta1);
        this.add(jb1);
        this.add(jb2);
        this.add(jta2);

        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置仅关闭当前窗口

        this.setVisible(true);  //设置可见
        this.setResizable(false);	//设置不可拉伸大小

    }
    public void setBg(){
        ((JPanel)this.getContentPane()).setOpaque(false);
        ImageIcon img=new ImageIcon("C:\\Users\\Joker\\Pictures\\10.jpg");
        JLabel background=new JLabel(img);
        this.getLayeredPane().add(background,new Integer(Integer.MIN_VALUE));
        background.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
    }
    //清空账号和密码框
    private void clear(){
        jta1.setText("");    //设置为空
        jta2.setText("");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "确定"){
            try {
                //获取用户注册的各项数据
                String dmoney = jta1.getText().trim();
                drawmoney();   //将存入金额传入判断是否合法
                String newmoney=jta2.getText().trim();
                String dtime=sf.format(date);
                //实现用户注册 ,这里好像是连接数据库的
                User1 user1 = new User1(dmoney,newmoney,dtime,username);
                Userdao dao = new UserDaoImpl();
                boolean result = dao.drawmoney(user1);
                System.out.println(result);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        else if (e.getActionCommand()=="重置"){
            clear();
        }
    }

    private void drawmoney() throws IOException {
        if (jta1.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "金额为空，请重新输入！","消息提示",JOptionPane.WARNING_MESSAGE);
        }
        else if(new Check().checkmoney(jta1.getText())){
            String nowmoney = new UserMessage().updatemoney(username,-Integer.parseInt(jta1.getText()));
            if (!nowmoney.equals("负数")){
                jta2.setText("您的余额为:\n "+nowmoney);
                jta1.setText("");
            }
            else{
                JOptionPane.showMessageDialog(null, "余额不足请重新输入:","消息提示",JOptionPane.WARNING_MESSAGE);
                clear();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "存入金额不合法!","消息提示",JOptionPane.WARNING_MESSAGE);
        }

    }




}
