package Demobank;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MyButton extends JButton {
    /** public MyButton(int type){
         super();
         setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
         if(type==1){
             setSelectedIcon(new ImageIcon("C:\\Users\\Joker\\Pictures\\30.jpg"));
             setIcon(new ImageIcon("C:\\Users\\Joker\\Pictures\\31.jpg"));
         }else if(type==2){
             setSelectedIcon(new ImageIcon("C:\\Users\\Joker\\Pictures\\31.jpg"));
             setIcon(new ImageIcon("C:\\Users\\Joker\\Pictures\\30.jpg"));
         }
     }*/
    ImageIcon img;

    public MyButton(String icon) {
        super();
        img = new ImageIcon(Demo.class.getResource("30.jpg"));
        setBorderPainted(false);
        setOpaque(false);
        setSize(img.getIconHeight(), img.getIconWidth());
        try {
            BufferedImage bi = ImageIO.read(Demo.class.getResource("30.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void paintComponent(Graphics g) {
        if (this.getModel().isPressed()) {
            g.drawImage(img.getImage(), 1, 1, this);

        } else {
            g.drawImage(img.getImage(), 0, 0, this);
        }
        super.paintComponent(g);
    }

    BufferedImage bi;
    int rgb, alpha;

/*    public boolean contains(int x, int y) {
        try {
            rgb = bi.getRGB(x, y);
            alpha = (rgb >> 24) & 0xff;
            if (alpha == 0) {
                return false;
            } else {
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }*/
    }
