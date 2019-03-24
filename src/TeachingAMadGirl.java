
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */
public class TeachingAMadGirl 
{
    JFrame frame;
    int x, y;
    JPanel panel=new JPanel();
            int press=1;
    JButton button=new JButton("Food here");
     JButton button2=new JButton("Don't press me also!");
    public static void main(String args[])
    {
        TeachingAMadGirl obj=new TeachingAMadGirl();
        obj.go();
    }
    class ColorStuff2 extends JPanel
{
    @Override
    public void paintComponent(Graphics g)
    {
        //super.paintComponent(g);
        g.setColor(Color.PINK);
        g.fillRect(0 ,0,this.getWidth() , this.getHeight()); 
        g.setColor(Color.RED);
        g.fillRect(x,y,400,300);
        
        /*Snake snake=new Snake();
        for(Point point:snake.snakeParts)
        {
            g.setColor(Color.WHITE);
            g.fillRect(point.x*snake.scale,point.y*snake.scale,snake.scale,snake.scale);
        }
        g.fillRect(snake.head.x*snake.scale,snake.head.y*snake.scale,snake.scale,snake.scale);*/
    }
}
    public void go()
    {
        frame=new JFrame();
        frame.setTitle("Kurkure");
        //frame.setSize(800,800);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        ColorStuff2 obj2=new ColorStuff2();
        frame.getContentPane().add(BorderLayout.CENTER,obj2);
        frame.getContentPane().setBackground(Color.PINK);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font bigFont = new Font("serif", Font.BOLD, 48);
        
       
        button.setSize(400,600);
        button.setFont(bigFont);
        button.addActionListener(new Listener1());
         button2.addActionListener(new Listener2());
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(button);
        panel.add(button2);
        
        //frame.getContentPane().add(BorderLayout.EAST,panel);
        
        while(x<=300)
        {
            x++;
            y++;
            obj2.repaint();
            
            try
            {
                Thread.sleep(10);
            }catch(InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }
        /*while(y<=500)
        {
            
        }*/
        obj2.repaint();
        String arr[]={"Umm","Umm2","Umm3"};
        JList list=new JList(arr);
        //checkbox.add(arr);
        panel.add(list);
        //frame.getContentPane().add(BorderLayout.NORTH,button2);
        //frame.getContentPane().add(BorderLayout.EAST,button);
    }
    class Listener1 implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(press%2!=0)
                button.setText("God played a cruel joke!");
            else
                button.setText("Food here");
            press++;
        }
    }
       class Listener2 implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(press%2!=0)
                button2.setBackground(Color.GREEN);
            else
            {
                button2.setBackground(Color.GRAY);
                //button2.setColor();
                button2.setText("hi i'm ugly again!");
            }
            press++;
        }
    }

}
