import java.io.*;
import java.util.*;
class Kruskal
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
    Kruskal(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
    void addEdge(int u, int x1,int x2)
    {
        Pair obj=new Pair(x1,x2);
        Pair obj2=new Pair(u,x2);
        adj[u].add(obj);  
        adj[x1].add(obj2);
    }
    void MST(int u)
    {
        //To be implemented
    }
    public static void main(String args[])
    {
        Kruskal g=new Kruskal(7);
        g.addEdge(0, 1, 8);
        g.addEdge(0, 2, 4);
        g.addEdge(0, 3, 6);
        g.addEdge(1, 2, 3);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 4, 9);
        g.addEdge(1 ,4, 4);
        g.addEdge(3, 4, 2);
        g.addEdge(3, 5, 3);
        g.addEdge(4, 5, 1);
        g.addEdge(5, 6, 9);
        g.parent[0]=-1;
        
        /*for(int i=0;i<9;i++)
        g.parent[i]=0;
        g.parent[0]=-1;
        g.longestPath(0);*/
    }
}