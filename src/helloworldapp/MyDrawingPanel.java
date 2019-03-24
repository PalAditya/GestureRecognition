package helloworldapp;
import java.applet.Applet;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
public class MyDrawingPanel
{class Heart extends Applet {
   @Override
   public void paint(Graphics g) {  
       
        Graphics2D g2 = (Graphics2D)g;  
        
        //Loop for animation 'heart' :p ;
        for(int i =  0;i < 400;i++){
        g2.setColor(Color.red);
        g2.fillOval(200 + i, 0 + i, 60,350);
      
            try {
                Thread.sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(Heart.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        }
         for(int i =  0;i < 400;i++){
        g2.setColor(Color.red);
        g2.fillOval(600 + i,400 - i , 60,350);
            try {
                Thread.sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(Heart.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        }   
    }  
  }
    JFrame frame;
    int x=600,y=300;
    int imx=50,imy=50;
    int flag=0,count=1;
    public static void main(String args[])
    {
        MyDrawingPanel obj=new MyDrawingPanel();
        obj.call();
    }
    @SuppressWarnings("SleepWhileInLoop")
    public void call()
    {
        
        frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DrawingPanel obj=new DrawingPanel();
        JPanel panel=new JPanel();
        JButton button=new JButton("Huh?");
        panel.add(button);
        panel.setBackground(Color.RED);
        frame.getContentPane().add(obj);
        frame.setBackground( Color.BLUE );
        //frame.getContentPane().add(BorderLayout.EAST,panel);
        //frame.getContentPane().add(BorderLayout.WEST,panel);
        //frame.getContentPane().add(fxPanel);
        //frame.getContentPane().add(BorderLayout.SOUTH,new Heart());
       // Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //frame.setSize((int)screenSize.getHeight(),(int)screenSize.getWidth());
        //frame.setSize(1400,800);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        //frame.setUndecorated(true);
        frame.setVisible(true);
        final JFXPanel fxPanel = new JFXPanel();
        try
        {
            String bip = "C:/Users/Lenovo/Downloads/Friends.mp3";
            Media hit = new Media(new File(bip).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(hit);
            mediaPlayer.play();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
            imx=-20;
            imy=50;
            //flag=1;
            while(imy<=150)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imy=50;
            while(imx<=5)
            {
                obj.repaint();
                imy+=2;
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            while(imx<=30)
            {
                obj.repaint();
                imy-=2;
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            while(imy<=150)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imx=50;
            imy=50;
            while(imx<=100)
            {
                obj.repaint();
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imx=50;
            while(imy<=100)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            while(imx<=100)
            {
                obj.repaint();
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imx=50;
            while(imy<=150)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            while(imx<=100)
            {
                obj.repaint();
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imy=50;
            imx=170;
            while(imx>=120)
            {
                obj.repaint();
                imx--;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            while(imy<=150)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imx=120;
            while(imx<=150)
            {
                obj.repaint();
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            while(imy>=110)
            {
                obj.repaint();
                imy--;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            while(imx<=170)
            {
                obj.repaint();
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            while(imy<=150)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imx=190;
            imy=50;
            while(imy<=150)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imy=100;
            while(imx<=240)
            {
                obj.repaint();
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imy=50;
            while(imy<=150)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imy=50;
            imx=260;
            while(imy<=150)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imy=50;
            while(imx<=310)
            {
                obj.repaint();
                imy+=2;
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            while(imy>=50)
            {
                obj.repaint();
                imy--;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imx=330;
            while(imy<=150)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imy=50;
            while(imx<=380)
            {
                obj.repaint();
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imx=330;
            imy=100;
            while(imx<=380)
            {
                obj.repaint();
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imy=50;
            while(imy<=150)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imx=540;
            imy=70;
            while(imy>=50)
            {
                obj.repaint();
                imy--;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            while(imx>=490)
            {
                obj.repaint();
                imx--;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            while(imy<=100)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            while(imx<=540)
            {
                obj.repaint();
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            while(imy<=150)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            while(imx>=490)
            {
                obj.repaint();
                imx--;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            while(imy>=130)
            {
                obj.repaint();
                imy--;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imx=560;
            imy=50;
            while(imy<=150)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imy=50;
            while(imx<=610)
            {
                obj.repaint();
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imx=560;
            imy=100;
            while(imx<=610)
            {
                obj.repaint();
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imy=50;
            while(imy<=150)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imx=630;
            imy=50;
            while(imy<=150)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imy=100;
            while(imx<=680)
            {
                obj.repaint();
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imy=50;
            while(imy<=150)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imx=700;
            imy=50;
            while(imy<=150)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imy=50;
            while(imx<=750)
            {
                obj.repaint();
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imx=700;
            imy=100;
            while(imx<=750)
            {
                obj.repaint();
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imy=50;
            while(imy<=150)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imx=-20;
            imy=180;
            while(imy<=230)
            {
                obj.repaint();
                imy+=2;
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
             while(imy>=180)
            {
                obj.repaint();
                imy-=2;
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
             imy=230;
             imx=5;
              while(imy<=280)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
              imx=50;
              imy=180;
               while(imx<=100)
            {
                obj.repaint();
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
                while(imy<=280)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
                 while(imx>=50)
            {
                obj.repaint();
                imx--;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
                  while(imy>=180)
            {
                obj.repaint();
                imy--;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
                  imx=120;
                  imy=180;
                   while(imy<=280)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
                while(imx<=170)
            {
                obj.repaint();
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
                 while(imy>=180)
            {
                obj.repaint();
                imy--;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
                 imx=190;
                 imy=180;
                  while(imy<=210)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
                  imx=210;
                  imy=180;
                   while(imy<=280)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
               imy=180;
                while(imx<=260)
            {
                obj.repaint();
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
                 while(imy<=230)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
                  while(imx>=210)
            {
                obj.repaint();
                imx--;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
                   while(imy<=280)
            {
                obj.repaint();
                imy++;
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
                   imx=280;
                   imy=180;
                    while(imy<=280)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
                     while(imx<=330)
            {
                obj.repaint();
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
                     imy=230;
                     imx=280;
                      while(imx<=330)
            {
                obj.repaint();
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
                imy=180;
                imx=280;
                while(imx<=330)
            {
                obj.repaint();
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
                imx=400;
                 while(imx<=450)
            {
                obj.repaint();
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
                 imx=425;
                  while(imy<=280)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
                  imx=470;
                  imy=180;
                   while(imy<=280)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
                   imy=230;
                    while(imx<=520)
            {
                obj.repaint();
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imy=180;
            while(imy<=280)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imx=540;
            imy=180;
            while(imy<=280)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            while(imx<=590)
            {
                obj.repaint();
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imy=230;
            imx=540;
            while(imx<=590)
            {
                obj.repaint();
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imy=180;
            imx=540;
            while(imx<=590)
            {
                obj.repaint();
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imx=650;
            imy=180;
            while(imy<=280)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imx=640;
            while(imx<=700)
            {
                obj.repaint();
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            while(imy>=230)
            {
                obj.repaint();
                imy--;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            while(imx>=650)
            {
                obj.repaint();
                imx--;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imx=700;
            while(imy>=180)
            {
                obj.repaint();
                imy--;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            while(imx>=640)
            {
                obj.repaint();
                imx--;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imx=720;
            while(imy<=280)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            while(imx<=770)
            {
                obj.repaint();
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imy=230;
            imx=720;
            while(imx<=770)
            {
                obj.repaint();
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imy=180;
            imx=720;
            while(imx<=770)
            {
                obj.repaint();
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imx=840;
            imy=200;
            while(imy>=180)
            {
                obj.repaint();
                imy--;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            while(imx>=790)
            {
                obj.repaint();
                imx--;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            while(imy<=230)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            while(imx<=840)
            {
                obj.repaint();
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            while(imy<=280)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            while(imx>=790)
            {
                obj.repaint();
                imx--;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            while(imy>=260)
            {
                obj.repaint();
                imy--;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imx=860;
            imy=180;
            while(imx<=910)
            {
                obj.repaint();
                imx++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            imx=885;
            while(imy<=280)
            {
                obj.repaint();
                imy++;
                try
                {
                    Thread.sleep(5);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            flag=1;
    }
    public class DrawingPanel extends JPanel
    {
        @Override
        public void paintComponent(Graphics g)
        {
            //super.paintComponent(g);
            //g.setColor(Color.white); 
            //g.fillRect(0 ,0,this.getWidth(),this.getHeight()); 
            g.setColor(Color.WHITE);
            g.fillOval(imx+100,imy,10,10);
            //if (flag==1)
            //{
                //System.out.println("Voila");
                count++;
                if(count<150||count>250&&count<400||count>500&&count<650)
                    g.setColor(Color.RED);
                else
                    g.setColor(Color.BLUE);
                if(count==650)
                    count=0;
                g.setFont(new Font("TimesRoman", Font.PLAIN, 150)); 
                g.drawString("\u2665", 400, 500);
            //}
        }
    }
}