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
        PriorityQueue<Pair> pq = new PriorityQueue(9,new Comparator<Pair>() 
        {
            public int compare(Pair a1, Pair a2) 
            {
                return a1.w-a2.w;
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
        dist[i]=Integer.MAX_VALUE;
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
                if(dist[v1]>w1+dist[vertex])
                {
                    dist[v1]=w1+dist[vertex];
                    parent[v1]=vertex;
                    pq.add(new Pair(v1,dist[v1]));
                }
            }
        }
        /*for(i=0;i<9;i++)
        System.out.println(i+": "+dist[i]);*/
        printSolution(dist);
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
        /*for(i=0;i<9;i++)
        System.out.println(i+": "+dist[i]);*/
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
    public static void main(String args[])
    {
        Djikstra g=new Djikstra(9);
        g.addEdge(0, 1, 4);
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
        g.shortestPath(0);
        for(int i=0;i<9;i++)
        g.parent[i]=0;
        g.parent[0]=-1;
        g.longestPath(0);
    }
}