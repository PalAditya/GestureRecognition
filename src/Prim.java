import java.io.*;
import java.util.*;
class Prim
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
    public LinkedList<Pair> adj[];
    int parent[];
    Prim(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
        parent=new int[V];
    }
    void addEdge(int u, int x1,int x2)
    {
        Pair obj=new Pair(x1,x2);
        Pair obj2=new Pair(u,x2);
        adj[u].add(obj);  
        adj[x1].add(obj2);
    }
    void shortestPath(int u)
    {
        /*PriorityQueue<Pair> pq = new PriorityQueue(7,new Comparator<Pair>() 
        {
            public int compare(Pair a1, Pair a2) 
            {
                return a1.w-a2.w;
            }
        });*/
        FibonacciHeap<Integer> objts=new FibonacciHeap<>();
        FibonacciHeap.Entry dist[];
        dist=new FibonacciHeap.Entry[V];
        for(int i=0;i<V;i++)
            dist[i]=new FibonacciHeap.Entry<>(0,-9); 
        int included[]=new int[V];
        int dist2[]=new int[V];
        int i;
        for(i=0;i<V;i++)
        {
            dist2[i]=Integer.MAX_VALUE;
            dist[i]=objts.enqueue(i, dist2[i]);
        }
        dist2[0]=0;
        objts.decreaseKey(dist[0], 0);
        //pq.add(new Pair(u,0));
        while(!objts.isEmpty())
        {
            FibonacciHeap.Entry<Integer> temp=objts.dequeueMin();
            int vertex=temp.mElem,weight=(int)temp.mPriority,v1,w1;
            included[vertex]=1;
            for (Pair temp2 : adj[vertex]) {
                v1=temp2.v;
                w1=temp2.w;
                if(dist2[v1]>w1&&included[v1]!=1)
                {
                    dist2[v1]=w1;
                    parent[v1]=vertex;
                    dist[v1].mPriority=w1;
                    objts.decreaseKey(dist[v1], w1);
                    
                }
            }
        }
        int d=0;
        /*for(i=0;i<V;i++)
        {
            System.out.print(dist2[i]+" ");
            d+=dist2[i];
        }
        System.out.println("\n"+d);*/
        //printSolution(dist);
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
            //printPath(i);
            System.out.println();
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int v,e,i,a,b,c;
        v=sc.nextInt();
        e=sc.nextInt();
        Prim g=new Prim(v);
        for(i=0;i<e;i++)
        {
            a=sc.nextInt();
            b=sc.nextInt();
            c=sc.nextInt();
            g.addEdge(a, b, c);
        }
        sc.close();
        g.shortestPath(0);
        /*for(int i=0;i<9;i++)
        g.parent[i]=0;
        g.parent[0]=-1;
        g.longestPath(0);*/
    }
}