import java.io.*;
class LinkedList1
{
    Node header;
    LinkedList1()
    {
        header=null;
    }
    void create(int n)
    {
        Node newnode=new Node(n);
        if (header==null)
        header=newnode;
        else
        {
            Node Temp=header;
            while(Temp.link!=null)
            Temp=Temp.link;
            Temp.link=newnode;
        }
    }
    void main()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        create(1);
        create(2);
        create(3);
        Node Temp=header;
        for(int i=1;i<=3;i++)
        {
            System.out.println(Temp.data);
            Temp=Temp.link;
        }
    }
}