import java.io.*;
import java.util.*;
class Djikstra
{
    private int V;
    class Pair
    {
        int w,v;
        Pair(int V,int W)
        {
            w=W;
            v=V;
        }
    }
    private LinkedList<Pair> adj[];
    int parent[]=new int[9];
    Djikstra(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
    void addEdge(int u, int x1,int x2)
    {
        Pair obj=new Pair(x1,x2);
        //Pair obj2=new Pair(u,x2);
        adj[u].add(obj);  
        //adj[x1].add(obj2);
    }
    void shortestPath(int u)
    {
        PriorityQueue<Pair> pq = new PriorityQueue(V,new Comparator<Pair>() 
        {
            public int compare(Pair a1, Pair a2) 
            {
                return a1.w-a2.w;
            }
        }
        );
        int dist[]=new int[V];
        int i;
        /*for(i=0;i<V;i++)
        {
            Iterator itr=adj[i].iterator();
            while(itr.hasNext())
            {
                Pair temp2=(Pair)itr.next();
                //System.out.println(i+": "+temp2.v+" "+temp2.w);
            }
        }*/
        for(i=0;i<V;i++)
        dist[i]=Integer.MAX_VALUE;
        dist[u]=0;
        pq.add(new Pair(u,0));
        while(!pq.isEmpty())
        {
            Pair temp=pq.poll();
            int vertex=temp.v,weight=temp.w,v1,w1;
            //System.out.println(vertex+" "+weight);
            Iterator itr=adj[vertex].iterator();
            while(itr.hasNext())
            {
                Pair temp2=(Pair)itr.next();
                v1=temp2.v;
                w1=temp2.w;
                //System.out.println("Iterating for "+vertex+": "+v1+","+w1);
                if(dist[v1]>w1+dist[vertex])
                {
                    dist[v1]=w1+dist[vertex];
                    //parent[v1]=vertex;
                    pq.add(new Pair(v1,dist[v1]));
                }
            }
        }
        /*for(i=0;i<V;i++)
        if(dist[i]==Integer.MAX_VALUE)
        System.out.print("1000000000 ");
        else
        System.out.print(dist[i]+" ");*/
        //printSolution(dist);
    }
    void shortestPath2(int u)
    {
        FibonacciHeap<Integer> objts=new FibonacciHeap<>();
        FibonacciHeap.Entry dist[];
        dist=new FibonacciHeap.Entry[V];
        for(int i=0;i<V;i++)
            dist[i]=new FibonacciHeap.Entry<>(0,-9); 
        /*PriorityQueue<Pair> pq = new PriorityQueue(V,new Comparator<Pair>() 
        {
            public int compare(Pair a1, Pair a2) 
            {
                return a1.w-a2.w;
            }
        }
        );*/
        int dist2[]=new int[V];
        int i;
        for(i=0;i<V;i++)
        {
            /*Iterator itr=adj[i].iterator();
            while(itr.hasNext())
            {
                Pair temp2=(Pair)itr.next();
                //System.out.println(i+": "+temp2.v+" "+temp2.w);
            }*/
            dist2[i]=Integer.MAX_VALUE;
        }
        dist2[u]=0;
        //for(i=0;i<V;i++)
        //dist[i].mPriority=Integer.MAX_VALUE;
        //dist[u]=0;
        //pq.add(new Pair(u,0));
        //dist[u]=objts.enqueue(u, 0);
        for(i=0;i<V;i++)
        dist[i]=objts.enqueue(i,dist2[i]);
        while(!objts.isEmpty())
        {
            //Pair temp=pq.poll();
            FibonacciHeap.Entry<Integer> temp=objts.dequeueMin();
            int vertex=temp.mElem,weight=(int)temp.mPriority,v1,w1;
            //dist[vertex].mPriority=-9;
            //System.out.println(vertex+" "+weight);
            Iterator itr=adj[vertex].iterator();
            while(itr.hasNext())
            {
                Pair temp2=(Pair)itr.next();
                v1=temp2.v;
                w1=temp2.w;
                //System.out.println("Iterating for "+vertex+": "+v1+","+w1);
                if(dist2[v1]>w1+(int)dist[vertex].mPriority)
                {
                    dist2[v1]=w1+(int)dist2[vertex];
                    dist[v1].mPriority=w1+dist[vertex].mPriority;
                    //parent[v1]=vertex;
                    //pq.add(new Pair(v1,dist[v1]));
                    objts.decreaseKey(dist[v1],dist[v1].mPriority);
                }
            }
        }
        /*for(i=0;i<V;i++)
        if(dist2[i]==Integer.MAX_VALUE)
        System.out.println(i+":1000000000");
        else
        System.out.println(i+":"+dist2[i]);*/
        //printSolution(dist);
    }
    void longestPath(int u)
    {
        PriorityQueue<Pair> pq = new PriorityQueue(9,new Comparator<Pair>() 
        {
            public int compare(Pair a1, Pair a2) 
            {
                return a2.w-a1.w;
            }
        }
        );
        int dist[]=new int[9];
        int i;
        /*for(i=0;i<9;i++)
        {
            Iterator itr=adj[i].iterator();
            while(itr.hasNext())
            {
                Pair temp2=(Pair)itr.next();
                System.out.println(i+": "+temp2.v+" "+temp2.w);
            }
        }*/
        for(i=0;i<9;i++)
        dist[i]=Integer.MIN_VALUE;
        dist[u]=0;
        pq.add(new Pair(u,0));
        while(!pq.isEmpty())
        {
            Pair temp=pq.poll();
            int vertex=temp.v,weight=temp.w,v1,w1;
            Iterator itr=adj[vertex].iterator();
            while(itr.hasNext())
            {
                Pair temp2=(Pair)itr.next();
                v1=temp2.v;
                w1=temp2.w;
                //System.out.println("Iterating for "+vertex+": "+v1+","+w1);
                if(dist[v1]<w1+dist[vertex])
                {
                    dist[v1]=w1+dist[vertex];
                    parent[v1]=vertex;
                    pq.add(new Pair(v1,dist[v1]));
                }
            }
        }
        for(i=0;i<9;i++)
        System.out.println(i+": "+dist[i]);
        printSolution(dist);
    }
    void printPath(int j)
    {
        if(parent[j]==-1)
        return;
        printPath(parent[j]);
        System.out.print(j+" ");
    }
    void printSolution(int dist[])
    {
        System.out.print(0+": "+dist[0]+" 0");
        System.out.println();
        for (int i=1;i<9;i++)
        {
            System.out.print(i+": "+dist[i]+" 0 ");
            printPath(i);
            System.out.println();
        }
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
 
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException
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
 
        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
 
        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
 
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
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
 
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
    public static void main(String args[])throws IOException
    {
        int i,m,n,u,v,w;
        Reader reader=new Reader();
        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //n=Integer.parseInt(st.nextToken());
        //m=Integer.parseInt(st.nextToken());
        n=reader.nextInt();
        m=reader.nextInt();
        Djikstra g=new Djikstra(n);
        for(i=0;i<m;i++)
        {
            /*StringTokenizer st2=new StringTokenizer(br.readLine());
            u=Integer.parseInt(st2.nextToken());
            v=Integer.parseInt(st2.nextToken());
            w=Integer.parseInt(st2.nextToken());*/
            u=reader.nextInt();
            v=reader.nextInt();
            w=reader.nextInt();
            g.addEdge(u,v,w);
        }
        g.shortestPath2(0);
        /*g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 7, 11);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 8, 2);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 5, 14);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1);
        g.addEdge(6, 8, 6);
        g.addEdge(7, 8, 7);
        g.parent[0]=-1;
        g.shortestPath(0);*/
        
    }
}