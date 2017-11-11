package helloworldapp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MyDrawingPanel
{  
    JFrame frame;
    int x=600,y=300;
    public static void main(String args[])
    {
        MyDrawingPanel obj=new MyDrawingPanel();
        obj.call();
    }
    public void call()
    {
        frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DrawingPanel obj=new DrawingPanel();
        frame.getContentPane().add(obj);
        frame.setSize(400,400);
        frame.setVisible(true);
            /*while(x>=300)
            {
                obj.repaint();
                x--;
                y=300;
                try
                {
                    Thread.sleep(50);
                }
                catch(Exception ex)
                {
                    System.out.println(ex.getMessage());
                }
            }*/
            while(y<=600)
            {
                obj.repaint();
                x=300;
                y++;
                try
                {
                    Thread.sleep(25);
                }
                catch(Exception ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            while(x<=450)
            {
                obj.repaint();
                x++;
                y=600;
                try
                {
                    Thread.sleep(5);
                }
                catch(Exception ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
    }
    public class DrawingPanel extends JPanel
    {
        public void paintComponent(Graphics g)
        {
            g.setColor(Color.white); 
            //g.fillRect(0 ,0,this.getWidth(),this.getHeight()); 
            g.setColor(Color.orange);
            g.fillOval(x,y,10,10);
        }
    }
}