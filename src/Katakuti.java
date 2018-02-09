import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Katakuti
{
    JFrame frame;
    JPanel mainPanel,panel2[];
    JButton button[];
    int click=1;
    public static void main(String args[])
    {
        Katakuti obj=new Katakuti();
        obj.go();
    }
    public void go()
    {
        frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setVisible(true);
        button=new JButton[9];
        panel2=new JPanel[3];
        mainPanel=new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
        int i;
        for(i=0;i<9;i++)
        {
            button[i]=new JButton("Nothing Much");
        }
        button[0].addActionListener(new Listener0());
        button[1].addActionListener(new Listener1());
        button[2].addActionListener(new Listener2());
        button[3].addActionListener(new Listener3());
        button[4].addActionListener(new Listener4());
        button[5].addActionListener(new Listener5());
        button[6].addActionListener(new Listener6());
        button[7].addActionListener(new Listener7());
        button[8].addActionListener(new Listener8());
        for(i=0;i<3;i++)
        {
            panel2[i]=new JPanel();
        }
        for(i=0;i<9;i++)
        {
            if(i<3)
                panel2[0].add(button[i]);
            else if(i>=3&&i<6)
                panel2[1].add(button[i]);
            else
                panel2[2].add(button[i]);
        }
        mainPanel.add(panel2[0]);
        mainPanel.add(panel2[1]);
        mainPanel.add(panel2[2]);
        frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
    }
    public class Listener0 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
           if(click%2!=1)
               button[0].setText("Cross");
           else
               button[0].setText("Circle");
           click++;
           button[0].setEnabled(false);
        }
    }
    public class Listener1 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(click%2!=1)
               button[1].setText("Cross");
           else
               button[1].setText("Circle");
            click++;
            button[1].setEnabled(false);
        }
    }
    public class Listener2 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(click%2!=1)
               button[2].setText("Cross");
           else
               button[2].setText("Circle");
            click++;
            button[2].setEnabled(false);
        }
    }
    public class Listener3 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(click%2!=1)
               button[3].setText("Cross");
           else
               button[3].setText("Circle");
            click++;
            button[3].setEnabled(false);
        }
    }
    public class Listener4 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(click%2!=1)
               button[4].setText("Cross");
           else
               button[4].setText("Circle");
            click++;
            button[4].setEnabled(false);
        }
    }
    public class Listener5 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
           if(click%2!=1)
               button[5].setText("Cross");
           else
               button[5].setText("Circle");
            click++;
            button[5].setEnabled(false);
        }
    }
    public class Listener6 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(click%2!=1)
               button[6].setText("Cross");
           else
               button[6].setText("Circle");
            click++;
            button[6].setEnabled(false);
        }
    }
    public class Listener7 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
           if(click%2!=1)
               button[7].setText("Cross");
           else
               button[7].setText("Circle");
            click++;
            button[7].setEnabled(false);
        }
    }
    public class Listener8 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(click%2!=1)
               button[8].setText("Cross");
           else
               button[8].setText("Circle");
            click++;
            button[8].setEnabled(false);
        }
    }
}
