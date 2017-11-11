import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class GUI1
{
    JButton button,button2;
    public static void main(String args[])
    {
        try
        {
            GUI1 obj=new GUI1();
            obj.graphic();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void graphic()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        JFrame frame=new JFrame();
        button=new JButton("I'm just a button :P");
        button2=new JButton("Another button");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.SOUTH,button);
        frame.getContentPane().add(BorderLayout.NORTH,button2);
        frame.setSize(400,400);
        frame.setVisible(true);
        button.addActionListener(new LabelListener());
        button2.addActionListener(new ColorListener());
    }
        class LabelListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                    button.setText("Yikes!");
            }
        }
        class ColorListener implements ActionListener
        {
            int click=1;
                public void actionPerformed(ActionEvent event)
                {
                    if(click%3==1)
                    {
                        button2.setText("That worked. Wow !");
                    }
                    else if(click%3==2)
                    {
                        button2.setText("That's...awesome!");
                    }
                    else
                    {
                        button2.setText("I think this worked!");
                    }
                    click++;
                }
        }
}