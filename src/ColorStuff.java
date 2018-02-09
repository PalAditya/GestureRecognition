import java.awt.*;
import javax.swing.*;
public class ColorStuff
{
class ColorStuff2 extends JPanel
{
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.fillRect(0,0,400,400);
        g.setColor(Color.BLACK);
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
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button=new JButton("Umm");
        frame.add(obj);
        //frame.add(button);
        obj.repaint(); 
    }
}
