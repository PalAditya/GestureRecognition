public class Play
{
    int current_pos,flag=1,balance;
    Play()
    {
        current_pos=23;
        balance=10000;
    }
        Play player1=new Play();
        Play player2=new Play();
        Play player3=new Play();
     public static void main(String args[])
    {
        Play obj=new Play();
        obj.records();
    }
    public int go()
    {
        return ((int)(Math.random()*6+1));
    }
    public void records()
    {
        if(flag++%3==1)
        {
            player1.current_pos+=go();
            player1.balance=update();
        }
        if(flag++%3==2)
        {
            player2.current_pos+=go();
            player1.balance=update();
        }
        if(flag++%3==0)
        {
            player3.current_pos+=go();
            player1.balance=update();
        }
    }
    public int update()
    {
        return 0;
    }
}
