import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
public class SnakeAndLadder {
    public static void main(String args[])
    {
        SnakeAndLadder obj=new SnakeAndLadder();
        obj.go();
    }
    public void go()
    {
        JFrame frame = buildFrame();
        try
        {
        final BufferedImage image =(BufferedImage)(ImageIO.read(new File("C:\\Users\\Lenovo\\Desktop\\GBoard.gif")).getScaledInstance(600, 600, Image.SCALE_DEFAULT));
        JPanel pane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        };
        frame.add(pane);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    private JFrame buildFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
        return frame;
    }

}
