import java.io.*;
import java.util.*;
class input_creator
{
    /*int a,b;
    input_creator(int x,int y)
    {
        a=x;
        b=y;
    }*/
    public static void main(String args[])throws IOException
    {
        input_creator obj=new input_creator();
        obj.go();
    }
    /*class Comp implements Comparator<input_creator>
    {
        public int compare(input_creator a,input_creator b)
        {
            if(a.a>b.a||a.b>b.b)
            return 1;
            else if(a.a<b.a||a.b<b.b)
            return -1;
            else
            return 0;
        }
    }*/
    public void go()throws IOException
    {
        FileWriter f = new FileWriter("C:/users/lenovo/documents/input00.txt");
        BufferedWriter br=new BufferedWriter(f);
        ArrayList<Integer> al=new ArrayList<>();
        int i,n,m,j,r,k;
        r=44;
        br.write(r+"");
        br.newLine();
        for(i=0;i<r;i++)
        {
            n=gen();
            m=gen();
            br.write(n+" ");
            br.write(m+" ");
            br.newLine();
            for(j=0;j<n;j++)
            {
               for(k=0;k<m;k++)
               {
                   br.write(gen()+" ");
               }
               br.newLine();
            }
        }
        br.close();
    }
    int gen()
    {
        return ((int)(Math.random()*100)+1);
    }
}