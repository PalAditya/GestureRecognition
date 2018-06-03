import java.io.*;
class Game
{
    int val;
    String name;
    int roll()
    {
        int r;
        r=((int)(Math.random()*6+1));
        return r;
    }
    public void main()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Game p1=new Game();
        Game p2=new Game();
        p1.name="Aditya";
        p2.name="Debjit";
        p1.val=p1.roll();
        System.out.println(p1.name+" has value "+p1.val);
        p2.val=p2.roll();
        System.out.println(p2.name+" has value "+p2.val);
        System.out.println(""+((p1.val>p2.val)?p1.name:p2.name)+" wins");
    }
}