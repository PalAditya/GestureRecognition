import java.awt.*;
import javax.swing.*;
 
public class DrawTree extends JPanel 
{
    int arr[]={2,1,3};
    int level[]={0,1,1};
    int shift[]={0,-1,1};
    public void paintComponent(Graphics g) 
    { 
        Font f = new Font("Dialog", Font.PLAIN, 12);
        FontMetrics fontMetrics = g.getFontMetrics();
        g.setFont(f);
        int midScreen=400;
        int start=20;
        for(int i=0;i<3;i++)
        {
             g.setColor(Color.RED);
             g.fillOval(midScreen+shift[i]*50, start+level[i]*50, 30, 30);
             g.setColor(Color.BLACK);
             g.drawString(arr[i]+"",midScreen+shift[i]*50+12,start+level[i]*50+18);
        }
    }
    public static void main(String[] args) 
    {
            JFrame.setDefaultLookAndFeelDecorated(true);
            JFrame frame = new JFrame("Draw Oval and Circle");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setBackground(Color.white);
            frame.setSize(1000,1000);     
            DrawTree panel = new DrawTree();
            frame.add(panel);
            frame.setVisible(true);
    }
}
