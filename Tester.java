import java.io.*;
import java.util.*;
public class Tester
{
    int val,ind;
    Tester(int a,int b)
    {
        val=a;
        ind=b;
    }
    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
        public int nextLong() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
    public static void main(String args[]) throws IOException
    {
        Tester obj=new Tester(0,0);
        obj.go();
    }
    public void go()throws IOException
    {
        //BufferedReader br2=new BufferedReader(new FileReader("C:/users/lenovo/documents/Stream/input10.txt"));
        //String str=br2.readLine();
        //FileWriter f = new FileWriter("C:/users/lenovo/documents/Stream/output10.txt");
        //BufferedWriter br=new BufferedWriter(f);
        long t,n,m,q,i,j,med=0,flag=0;
        //t=Long.parseLong(str);
        Scanner sc=new Scanner(System.in);
        t=sc.nextLong();
        while(t-->0)
        {
            //n=Long.parseLong(br2.readLine());
            n=sc.nextLong();
            PriorityQueue< Long > max = new PriorityQueue <Long> (10, Collections.reverseOrder() );
            PriorityQueue< Long > min = new PriorityQueue <> ();
            while(n-->0)
            {
                //str=br2.readLine();
                //StringTokenizer st=new StringTokenizer(str);
                //m=Long.parseLong(st.nextToken());
                m=sc.nextLong();
                if(m==1)
                {
                    //m=Long.parseLong(st.nextToken());
                    m=sc.nextLong();
                    if(max.size()>min.size())
                    {
                        if(m<med)
                        {
                            min.add(max.poll());
                            max.add(m);
                        }
                        else
                        {
                            min.add(m);
                        }
                        med=(max.peek()+min.peek())/2;
                        flag=1;
                    }
                    else if(max.size()<min.size())
                    {
                        if(m<med)
                        {
                            max.add(m);
                        }
                        else
                        {
                            max.add(min.poll());
                            min.add(m);
                        }
                        med=(max.peek()+min.peek())/2;
                        flag=1;
                    }
                    else
                    {
                        if(m<med)
                        {
                            max.add(m);
                            med=max.peek();
                            flag=2;
                        }
                        else
                        {
                            min.add(m);
                            med=min.peek();
                            flag=3;
                        }
                    }
                }
                else if(m==2)
                {
                    //br.write(med+"");
                    //br.newLine();
                    System.out.println(med);
                }
                else
                {
                    if(flag==1)
                    {
                        max.poll();
                        min.poll();
                    }
                    else if(flag==2)
                    {
                        max.poll();
                    }
                    else
                    {
                        min.poll();
                    }
                }
            }
        }
        //br.close();
        //br2.close();
    }
}