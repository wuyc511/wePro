package Demobank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Number
{

    private static final long serialVersionUID = 1L;
    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 400;

    public static void main(String[] args) {
     JFrame f=new JFrame("超级计算机");
     f.setBounds(400,200,500,400);
    //数字键盘容器
    JPanel pan=new JPanel();
    f.add(pan);
    //数字键盘上的按钮
    JButton btnNum1;   //按键1
    JButton btnNum2;   //按键2
    JButton btnNum3;   //按键3
    JButton btnNum4;   //按键4
    JButton btnNum5;   //按键5
    JButton btnNum6;   //按键6
    JButton btnNum7;   //按键7
    JButton btnNum8;   //按键8
    JButton btnNum9;   //按键9
    JButton btnNum0;   //按键0
    JButton btnDot;    //小数点
    JButton btnNum00;  //按键00
    JButton btnOK;     //确认
    JButton btnCancel; //取消
    JButton btnReset;  //重置

/*

        //窗口大小
        pan.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        //窗口居中
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        pan.setLocation(
                (dim.width - dim.getSize().width) / 2,
                (dim.height - dim.getSize().height) / 2);
*/

        //标题
        f.setTitle("超级计算机！！");

        /*//使窗体边界无法改变（也无法进行最大化）
        pan.setResizable(false);*/

        //关闭窗口时退出程序
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setLayout(new BorderLayout());
        //要绑定的事件
        //InsertNumberAction insertNumber = new InsertNumberAction();
        //OkCommandAction okCommand = new OkCommandAction();
        //CancelCommandAction cancelCommand = new CancelCommandAction();
        //ResetCommandAction resetCommand = new ResetCommandAction();

        //输入键盘
        //panel = new JPanel();
        pan.setLayout(new GridLayout(4, 4));

        //数字7
        btnNum7 = new JButton("7");
        btnNum7.setFont(new Font("Andalus", Font.BOLD, 60));
        //btnNum7.addActionListener(insertNumber);
        pan.add(btnNum7);

        //数字8
        btnNum8 = new JButton("8");
        btnNum8.setFont(new Font("Andalus", Font.BOLD, 60));
        //btnNum8.addActionListener(insertNumber);
        pan.add(btnNum8);

        //数字9
        btnNum9 = new JButton("9");
        btnNum9.setFont(new Font("Andalus", Font.BOLD, 60));
        //btnNum9.addActionListener(insertNumber);
        pan.add(btnNum9);

        //取消按钮
        btnCancel = new JButton("取消");
        btnCancel.setForeground(Color.RED);
        btnCancel.setFont(new Font("宋体", Font.BOLD, 40));
        //btnCancel.addActionListener(cancelCommand);
        pan.add(btnCancel);

        //数字4
        btnNum4 = new JButton("4");
        btnNum4.setFont(new Font("Andalus", Font.BOLD, 60));
        //btnNum4.addActionListener(insertNumber);
        pan.add(btnNum4);

        //数字5
        btnNum5 = new JButton("5");
        btnNum5.setFont(new Font("Andalus", Font.BOLD, 60));
        //btnNum5.addActionListener(insertNumber);
        pan.add(btnNum5);

        //数字6
        btnNum6 = new JButton("6");
        btnNum6.setFont(new Font("Andalus", Font.BOLD, 60));
        //btnNum6.addActionListener(insertNumber);
        pan.add(btnNum6);

        //重置按钮
        btnReset = new JButton("重置");
        btnReset.setForeground(Color.BLUE);
        btnReset.setFont(new Font("宋体", Font.BOLD, 40));
        //btnReset.addActionListener(resetCommand);
        pan.add(btnReset);

        //数字1
        btnNum1 = new JButton("1");
        btnNum1.setFont(new Font("Andalus", Font.BOLD, 60));
        //btnNum1.addActionListener(insertNumber);
        pan.add(btnNum1);

        //数字2
        btnNum2 = new JButton("2");
        btnNum2.setFont(new Font("Andalus", Font.BOLD, 60));
        //btnNum2.addActionListener(insertNumber);
        pan.add(btnNum2);

        //数字3
        btnNum3 = new JButton("3");
        btnNum3.setFont(new Font("Andalus", Font.BOLD, 60));
        //btnNum3.addActionListener(insertNumber);
        pan.add(btnNum3);

        //空按钮
        pan.add(new JButton(""));

        //小数点（摆设）
        btnDot = new JButton(".");
        btnDot.setFont(new Font("Andalus", Font.BOLD, 60));
        pan.add(btnDot);

        //数字0
        btnNum0 = new JButton("0");
        btnNum0.setFont(new Font("Andalus", Font.BOLD, 60));
        //btnNum0.addActionListener(insertNumber);
        pan.add(btnNum0);

        //数字00（摆设）
        btnNum00 = new JButton("00");
        btnNum00.setFont(new Font("Andalus", Font.BOLD, 60));
        pan.add(btnNum00);

        //确定按钮
        btnOK = new JButton("确定");
        btnOK.setForeground(Color.GREEN);
        btnOK.setFont(new Font("宋体", Font.BOLD, 40));
       // btnOK.addActionListener(okCommand);
        pan.add(btnOK);

        f.add(pan, BorderLayout.CENTER);

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);
    }
}
