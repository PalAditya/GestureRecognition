import java.util.*;
class AllPairsShortestPath
{
    int V;
    AllPairsShortestPath(int v)
    {
        V=v;
    }
    void floydWarshall(int g[][])
    {
        int dist[][]=new int[V][V];
        int i,j,k;
        for(i=0;i<V;i++)
        for(j=0;j<V;j++)
        dist[i][j]=g[i][j];
        for(i=0;i<V;i++)
        {
            for(j=0;j<V;j++)
            {
                for(k=0;k<V;k++)
                {
                    if(dist[j][k]>dist[j][i]+dist[i][k])
                    dist[j][k]=dist[j][i]+dist[i][k];
                }
            }
        }
        /*System.out.println("Solution...");
        for(i=0;i<V;i++)
        {
            for(j=0;j<V;j++)
            System.out.print(dist[i][j]+" ");
            System.out.println();
        }*/
    }
    int func(double p)
    {
        return (int)Math.round(Math.random()*p);
    }
    void x(double p,int mat[][])
    {
        int i,j;
        for(i=0;i<V;i++)
        for(j=i;j<V;j++)
        if(i!=j)
        if(func(p)>=1)
        mat[i][j]=(int)(Math.random()*21);
        else
        mat[i][j]=Integer.MAX_VALUE;
        else
        mat[i][j]=0;
        for(i=0;i<V;i++)
        for(j=0;j<i;j++)
        mat[i][j]=mat[j][i];
    }
    public static void main(String args[])
    {
        System.out.println("Vertex? Probability?");
        Scanner sc=new Scanner(System.in);
        for(int k=0;k<3;k++)
        {
            int v=sc.nextInt(),i,j;
            double p=sc.nextDouble();
            AllPairsShortestPath obj=new AllPairsShortestPath(v);
            Djikstra gr=new Djikstra(v);
            int g[][]=new int[v][v];
            obj.x(p,g);
            for(i=0;i<v;i++)
            for(j=0;j<v;j++)
            {
            //g[i][j]=sc.nextInt();
            if(g[i][j]<10000&&g[i][j]>0)
            gr.addEdge(i,j,g[i][j]);
            }
            //System.out.println();
            /*for(i=0;i<v;i++)
            {
            for(j=0;j<v;j++)
            System.out.print(g[i][j]+" ");
            System.out.println();
            }
            System.out.println();*/
            long t1,t2,t3,t4;
            t1=System.nanoTime();
            obj.floydWarshall(g);
            t2=System.nanoTime();
            //t4=System.nanoTime();
            for(i=0;i<v;i++)
            gr.shortestPath2(i);
            t3=System.nanoTime();
            for(i=0;i<v;i++)
            gr.shortestPath(i);
            t4=System.nanoTime();
            //System.out.println();
            System.out.println("With probability "+p+", Floyd warshall took "+(t2-t1)*1.0/Math.pow(10,9)+" and Johnson took "+(t3-t2)*1.0/Math.pow(10,9)+" and binary heap (huhu) took "+(t4-t3)*1.0/Math.pow(10,9));
        }
    }
}
