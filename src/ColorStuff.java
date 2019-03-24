import java.awt.*;
import javax.swing.*;
public class ColorStuff
{
class ColorStuff2 extends JPanel
{
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(10,20,400,300);
        
        /*Snake snake=new Snake();
        for(Point point:snake.snakeParts)
        {
            g.setColor(Color.WHITE);
            g.fillRect(point.x*snake.scale,point.y*snake.scale,snake.scale,snake.scale);
        }
        g.fillRect(snake.head.x*snake.scale,snake.head.y*snake.scale,snake.scale,snake.scale);*/
    }
}
public static void main(String args[])
    {
        ColorStuff a=new ColorStuff();
        a.go();
    }
public void go()
    {
        JFrame frame=new JFrame();
        ColorStuff2 obj=new ColorStuff2();
        frame.setSize(400,400);
         frame.getContentPane().add(obj);
         obj.repaint();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button=new JButton("Umm");
       
        //frame.add(button);
         
    }
}
