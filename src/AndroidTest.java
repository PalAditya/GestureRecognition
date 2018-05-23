import java.util.*;
class AndroidTest 
{
    private int V;
    class Pair
    {
        int v;
        double w;
        Pair(int V,double W)
        {
            w=W;
            v=V;
        }
    }
    private LinkedList<Pair> adj[];
    AndroidTest(int v)
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
    public static void main(String args[] ){
       AndroidTest obj=new AndroidTest(0);
       obj.go();
    }
    public void go()
    {
        Scanner sc=new Scanner(System.in);
        double data[][]={{24.3,56.3,20},{24.3,45.5,36},{24.3,45,25},{24.3,92,28.4},{46.2,60,25.7},{64.3,30.5,34.8},{24.3,60,42.4},{24.3,60,65.6},
        {44.3,60,25.8},{34.3,40.7,36.4},{24.3,36.8,36.8},{44.3,36,24},{24.3,60,15},{24.3,49,17.6},{24.3,60,26.3},{34.3,60,32.7}};
        int i=0,k=0;
        AndroidTest g=new AndroidTest(16);
        for(i=0;i<12;i++)
        {
            g.addEdge(i,i+4,5);
        }
        for(i=12;i<16;i++)
        {
            g.addEdge(i,i-12,20);
        }
        g.addEdge(15,0,80);
        for(i=0;i<15;i++)
        {
            if((i+1)%4!=0)
            g.addEdge(i,i+1,5);
            else
            g.addEdge(i,i-3,20);
        }
        //g.display();
        g.modifyEdgeCost(data);
        //g.display();
        g.shortestPath(0);
    }
    void display()
    {
        for(int i=0;i<V;i++)
        {
            Iterator itr=adj[i].iterator();
            while(itr.hasNext())
            {
                Pair temp2=(Pair)itr.next();
                System.out.println(i+": "+temp2.v+" "+temp2.w);
            }
        }
    }
    void modifyEdgeCost(double data[][])
    {
        int i;
        double weight;
        for(i=0;i<V;i++)
        {
            ListIterator itr=adj[i].listIterator();
            while(itr.hasNext())
            {
                Pair temp2=(Pair)itr.next();
                weight=temp2.w;
                if(data[temp2.v][0]>30)
                    weight=data[temp2.v][0]-30+weight;
                if(data[temp2.v][1]<50)
                    weight=50-data[temp2.v][1]+weight;
                if(data[temp2.v][2]>25&&data[temp2.v][0]>30)
                    weight=data[temp2.v][0]-30+weight;
                temp2.w=weight;
                itr.remove();
                itr.add(temp2);
            }
        }
    }
    void shortestPath(int u)
    {
        PriorityQueue<Pair> pq = new PriorityQueue(V,new Comparator<Pair>() 
        {
            public int compare(Pair a1, Pair a2) 
            {
                return (a1.w-a2.w)>0?1:-1;
            }
        }
        );
        double dist[]=new double[V];
        int i;
        for(i=0;i<V;i++)
        {
            Iterator itr=adj[i].iterator();
            while(itr.hasNext())
            {
                Pair temp2=(Pair)itr.next();
                //System.out.println(i+": "+temp2.v+" "+temp2.w);
            }
        }
        for(i=0;i<V;i++)
        dist[i]=Integer.MAX_VALUE;
        dist[u]=0;
        pq.add(new Pair(u,0));
        while(!pq.isEmpty())
        {
            Pair temp=pq.poll();
            int vertex=temp.v,v1;
            double weight=temp.w,w1;
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
        for(i=0;i<V;i++)
        if(dist[i]==Integer.MAX_VALUE)
        System.out.print("1000000000 ");
        else
        System.out.print(dist[i]+" ");
        //printSolution(dist);
    }
}