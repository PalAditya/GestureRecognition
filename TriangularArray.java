
import java.io.*;
class TriangularArray
{
    Node2 header;
    TriangularArray()
    {
        header=null;
    }
    void create(int n)
    {
        Node2 newnode=new Node2(n);
        Node2 Temp=header;
        while(Temp.down!=null)
        Temp=Temp.down;
        while(Temp.link!=null)
        Temp=Temp.link;
        Temp.link=newnode;
    }
    void createfirst(int n)
    {
        Node2 newnode=new Node2(n);
        if (header==null)
        header=newnode;
        else
         {
            Node2 Temp=header;
            while(Temp.down!=null)
            Temp=Temp.down;
            Temp.down=newnode;
        }
    }
    void display()
    {
        Node2 Temp=header;
        Node2 Temp2=header;
        while(Temp2!=null)
        {
            while(Temp!=null)
            {
                System.out.print(Temp.data+" ");
                Temp=Temp.link;
            }
            Temp=Temp2.down;
            Temp2=Temp2.down;
            System.out.println("");
        }
    }
    void main()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int i=0,j=0;
        for(i=1;i<=5;i++)//Here heght is five. You can take user input
        for(j=1;j<=i;j++)
        {
            if(j==1)
            createfirst(5);//This 5 can be user input
            else
            create(5);
        }
        display();
    }
}