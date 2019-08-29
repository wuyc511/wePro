package Demobank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SaveMoney
 * 本类实现 存钱的操作  注意金额的处理
 * 取款时 还未实现同步，必须使用同步来完成
 * @author contentcl
 * @Date 2019年5月10日 下午3:59:38
 *
 */
public class SaveMoney extends JFrame implements ActionListener {

    JButton jb1, jb2;  //按钮
    JLabel jlb1, jlb2; //标签
    JTextArea jta1,jta2;

    Date date=new Date();
    SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String username;
    public SaveMoney(String username) {
        setBg();
        this.username = username;
        jb1 = new JButton("确定");
        jb2 = new JButton("重置");
        jb1.setFont(new Font("楷体",Font.PLAIN,19));
        jb1.setForeground(Color.green);
        jb2.setFont(new Font("楷体",Font.PLAIN,19));
        jb2.setForeground(Color.blue);
        //设置按钮监听
        jb1.addActionListener(this);
        jb2.addActionListener(this);

        jlb1 = new JLabel("请输入存入金额：");  //添加标签
        jlb1.setFont(new Font("楷体",Font.PLAIN,22));
        jlb1.setForeground(Color.red);
        //创建文本框
        jta1 = new JTextArea();
        jta2 = new JTextArea();

        //设置布局
        this.setTitle("存钱");
        this.setLayout(null);
        this.setSize(600, 500);

        //存入标签和文本框
        jlb1.setBounds(200, 80, 200, 20);
        jta1.setBounds(170, 140, 250, 50);
        jta1.setFont(new   java.awt.Font("Dialog",   0,   15)); //设置字体为字形， 不加粗，15号字体

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
        if (e.getActionCommand()=="确定"){

            try {
                //获取用户注册的各项数据
                String smoney =jta1.getText().trim();
                savemoney();   //将存入金额传入判断是否合法
                String newmoney=jta2.getText().trim();
                String time=sf.format(date);
                //实现用户注册 ,这里好像是连接数据库的
                User2 user2 = new User2(smoney,newmoney,time,username);
                Userdao dao = new UserDaoImpl();
                boolean result = dao.savemoney(user2);
                System.out.println(result);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        else if (e.getActionCommand()=="重置"){
            clear();
        }

    }

    private void savemoney() throws IOException {
        if (jta1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "金额为空，请重新输入！", "消息提示", JOptionPane.WARNING_MESSAGE);
        } else if (new Check().checkmoney(jta1.getText())) {  //验证金额是否合法
            //将账户和金额传入， 进行存储
            String nowmoney = new UserMessage().updatemoney(username, Integer.parseInt(jta1.getText()));
            if (!(nowmoney.equals("负数"))) {
                jta2.setText("您的余额为:\n " + nowmoney);
                jta1.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "存入金额不合法!", "消息提示", JOptionPane.WARNING_MESSAGE);
        }
    }
}