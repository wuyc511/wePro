package Demobank;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Transfer
 * 本类实现 转账的操作， 注意金额的处理
 * @author contentcl
 * @Date 2019年5月9日 下午10:00:05
 *
 */
public class Transfer extends JFrame implements ActionListener {
    String countname;
    JButton jb1, jb2;  //按钮
    JLabel jlb1, jlb2; //标签
    JTextArea jta1;    //文本框
    JTextField jtf1;
    JPanel jp1;
    Date date=new Date();
    SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //public static boolean flag=true;
    String username;
    public Transfer(String username) {
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


        jlb1 = new JLabel("请输入转出金额：");  //添加标签
        jlb2 = new JLabel("对方账号");
        jlb1.setFont(new Font("楷体",Font.PLAIN,22));
        jlb1.setForeground(Color.red);
        jlb2.setFont(new Font("楷体",Font.PLAIN,22));
        jlb2.setForeground(Color.red);
        //创建文本框
        jta1 = new JTextArea();   //转出金额
        jtf1 = new JTextField(13);


        //设置布局
        this.setTitle("转账");
        this.setLayout(null);
        this.setSize(600, 500);

        //创建对方账户的标签
       // jp1.setBounds(20, 10, 210, 160);

        //存入标签和文本框

       // jp1.setBounds(200, 50, 200, 20);
        jlb2.setBounds(200, 50, 200, 20);
        jlb1.setBounds(200, 180, 200, 20);
        jta1.setBounds(170, 230, 250, 50);
        jta1.setFont(new   java.awt.Font("Dialog",   0,   15));
        jtf1.setBounds(170, 100, 250, 50);
        //确定和重置按钮
        jb1.setBounds(200, 330, 90, 28);
        jb2.setBounds(300, 330, 90, 28);


        //this.add(jp1);
        this.add(jtf1);
        this.add(jlb2);
        this.add(jlb1);
        this.add(jta1);
        this.add(jb1);
        this.add(jb2);
        //jp1.setOpaque(false);//把jp1面板设为透明
        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置仅关闭当前窗口

        this.setVisible(true);  //设置可见
        this.setResizable(false);	//设置不可拉伸大小

    }

    public void setBg(){
        ((JPanel)this.getContentPane()).setOpaque(false);
        ImageIcon img=new ImageIcon("C:\\Users\\Joker\\Pictures\\9.jpg");
        JLabel background=new JLabel(img);
        this.getLayeredPane().add(background,new Integer(Integer.MIN_VALUE));
        background.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
    }

    //清空账号和密码框
    private void clear(){
        jtf1.setText("");
        jta1.setText("");    //设置为空
        //jta2.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand()=="确定"){
            try {
                //获取用户注册的各项数据
                String tmoney =jta1.getText().trim();
                String account=jtf1.getText().trim();
                String ttime=sf.format(date);
                transfer();
                //实现用户注册 ,这里好像是连接数据库的
                User3 user3 = new User3(tmoney,account,ttime,username);
                Userdao dao = new UserDaoImpl();
                boolean result = dao.transmoney(user3);
                System.out.println(result);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        else if (e.getActionCommand()=="重置"){
            clear();
        }

    }

    private void transfer() throws IOException {
        if (jta1.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "金额为空，请重新输入！","消息提示",JOptionPane.WARNING_MESSAGE);
        }
        else if (jtf1.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "转入账号，请重新输入！","消息提示",JOptionPane.WARNING_MESSAGE);
        }
        else if(new Check().checkmoney(jta1.getText())){  //验证金额是否合法
            if(new Check().check2(jtf1.getText())){   //验证账户是否存在
                new TransferToOthers(countname,jtf1.getText(),jta1.getText());  //将本人账户名 对方账户名和金额传递过去
                clear();
            }
            else{
                JOptionPane.showMessageDialog(null, "账户不存在","消息提示",JOptionPane.WARNING_MESSAGE);
                clear();
            }

        }
        else{
            JOptionPane.showMessageDialog(null, "金额不合法","消息提示",JOptionPane.WARNING_MESSAGE);
            clear();
        }

    }


}

