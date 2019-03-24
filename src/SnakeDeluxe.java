import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class SnakeDeluxe implements ActionListener,KeyListener
{
    JFrame frame=new JFrame("Snake");
    ColorStuff obj=new ColorStuff();
    Timer timer=new Timer(20,this);
    ArrayList<Point> snakeParts;
    ArrayList<Point> eSnakeParts;
    ArrayList<Integer> tick;
    int ticks,direction,up,down,left,right,scale,score,tail,speed,flag,eSpeed,eTail;
    Point head,food,eHead;
    Random random;
    boolean over=false,paused=false;
    static SnakeDeluxe newSnake,snake,eSnake;
    Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
    MusicApp1 music=new MusicApp1();
    SnakeDeluxe()
    {   
        ticks=0;direction=1;up=0;down=1;left=2;right=3;scale=10;score=0;tail=1;speed=10;flag=0;eSpeed=15;eTail=0;
        snakeParts=new ArrayList<>();
        eSnakeParts=new ArrayList<>();tick=new ArrayList<>();
    }
    public void startGame()
    {
        frame.setSize(600,500);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocation(dim.width/2-frame.getWidth()/2,dim.height/2-frame.getHeight()/2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(obj);
        frame.addKeyListener(this); 
        head=new Point(0,0);
        eHead=new Point(58,0);
        random=new Random();
        food=new Point(random.nextInt(58),random.nextInt(46));
        timer.start();
    }
    public boolean notSelfCollide(int x,int y)
    {
        for(Point point:snakeParts)
        {
            if(point.equals(new Point(x,y)))
                return false;
        }
        return true;
    }
    public static void main(String args[])
    {
        snake=new SnakeDeluxe();
        eSnake=new SnakeDeluxe();
        snake.startGame();
    }
    public void eSnakeControl(Point food, Point eHead)
    {
            if(food!=null&&eHead!=null)
            {
                if((int)(food.getX()-eHead.getX())>0)
                    eHead.translate(1,0);
                else if((int)(food.getX()-eHead.getX())<0)
                    eHead.translate(-1,0);
                else if((int)(food.getY()-eHead.getY())>0)
                    eHead.translate(0,1);
                else
                    eHead.translate(0,-1);
            }
    }
    public void actionPerformed(ActionEvent event)
    { 
        if(eTail%5==0&&eTail!=0)
        {   
            over=true;
        }
        else
        {
            eSpeed=eSpeed-(int)(score/100);
            ticks++;
            if(ticks%eSpeed==0&&eHead!=null&&!over&&!paused)
            {         
                    eSnake.eSnakeParts.add(new Point(eHead.x,eHead.y));
                    eSnake.eSnakeControl(food, eHead);     
                if(eSnake.eSnakeParts.size()>eTail)
                    eSnake.eSnakeParts.remove(0);
                if(food!=null)
                {
                    if(eHead.equals(food))
                    {
                        music.play();
                        score=score-10;
                        eTail++;
                        food.setLocation(random.nextInt(58),random.nextInt(46));
                    }
                }
            }
        }
        if(tail%5==0)
        {
            tick.add(ticks);
            obj.repaint();
            if(ticks%speed==0&&head!=null&&!over&&!paused)
            {
                snakeParts.add(new Point(head.x,head.y));
                if(direction==up)
                    if(head.y-1>=0&&notSelfCollide(head.x,head.y-1))
                        head=new Point(head.x,head.y-1);
                    else
                        over=true;
                else if(direction==down)
                    if(head.y+1<=46&&notSelfCollide(head.x,head.y+1))
                        head=new Point(head.x,head.y+1);
                    else
                        over=true;
                else if(direction==left)
                    if(head.x-1>=0&&notSelfCollide(head.x-1,head.y))
                        head=new Point(head.x-1,head.y);
                    else
                        over=true;
                else
                    if(head.x+1<=58&&notSelfCollide(head.x+1,head.y))
                        head=new Point(head.x+1,head.y);
                    else
                        over=true;
                if(snakeParts.size()>tail)
                    snakeParts.remove(0);
                if(tick.get(tick.size()-1)-tick.get(0)>150)
                {
                    flag++;
                    tail++;
                    food.setLocation(random.nextInt(58),random.nextInt(46));
                    tick.clear();
                }
                if(food!=null)
                {
                    if(head.equals(food))
                    {
                        music.play();
                        score=score+50;
                        tail++;
                        food.setLocation(random.nextInt(58),random.nextInt(46));
                    }
                }
            }
        }
        else
        {
            flag=0;
            obj.repaint();
            if(ticks%speed==0&&head!=null&&!over&&!paused)
            {
                snakeParts.add(new Point(head.x,head.y));
                    if(direction==up&&notSelfCollide(head.x,head.y-1))
                        if(head.y-1>=0)
                            head=new Point(head.x,head.y-1);
                        else
                            over=true;
                    else if(direction==down&&notSelfCollide(head.x,head.y+1))
                        if(head.y+1<=46)
                            head=new Point(head.x,head.y+1);
                        else
                            over=true;
                    else if(direction==left&&notSelfCollide(head.x-1,head.y))
                        if(head.x-1>=0)
                            head=new Point(head.x-1,head.y);
                        else
                            over=true;
                    else
                        if(head.x+1<=58&&notSelfCollide(head.x+1,head.y))
                            head=new Point(head.x+1,head.y);
                        else
                            over=true;
                if(snakeParts.size()>(tail-flag))
                    snakeParts.remove(0);
                if(food!=null)
                {
                    if(head.equals(food))
                    {
                        music.play();
                        score=score+10;
                        tail++;
                        food.setLocation(random.nextInt(58),random.nextInt(46));
                    }
                }
            }
        }
    }
    public class ColorStuff extends JPanel
    {
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.fillRect(0,0,600,500);
            g.setColor(Color.BLUE);
            g.fillRect(0,0,600,500);
            g.setColor(Color.RED);
            for(Point point:snakeParts)
            {   
                g.fillRect(point.x*scale,point.y*scale,scale,scale);
            }
            g.fillRect(head.x*scale,head.y*scale,scale,scale);
            g.setColor(Color.WHITE);
            for(Point point:eSnakeParts)
            {   
                g.fillRect(point.x*scale,point.y*scale,scale,scale);
            }
            g.fillRect(eHead.x*scale,eHead.y*scale,scale,scale);
            if(tail%5==0)
                g.setColor(Color.GREEN);
            else
                g.setColor(Color.YELLOW);
            g.fillRect(food.x*scale,food.y*scale,scale,scale);
            String str="Score: "+score+", Length: "+(tail-flag)+", time: "+ticks/20+" speed: "+(11-speed);
            g.setColor(Color.WHITE);
            g.drawString(str, 30, 10);
        }
    }
    public void keyPressed(KeyEvent event)
    {
        int i=event.getKeyCode();
        if(i==KeyEvent.VK_A&&direction!=right)
            direction=left;
        if(i==KeyEvent.VK_F&&direction!=left)
            direction=right;
        if(i==KeyEvent.VK_S&&direction!=up)
            direction=down;
        if(i==KeyEvent.VK_W&&direction!=down)
            direction=up;
        if(i==KeyEvent.VK_SPACE&&over)
        {
            newSnake=new SnakeDeluxe();
            newSnake.startGame();
        }
        if(i==KeyEvent.VK_SPACE&&!over)
            paused=!paused;
         if(i==KeyEvent.VK_Z)
            if(speed>1)
                speed=speed-1;
        if(i==KeyEvent.VK_X)
            if(speed<10)
                speed=speed+1;
    }
    public void keyReleased(KeyEvent event)
    {
    }
    public void keyTyped(KeyEvent event)
    {
    }
}
