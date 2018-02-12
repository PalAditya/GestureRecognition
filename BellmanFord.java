import java.util.*;
class BellmanFord
{
    class Edge
    {
        int u,v,w;
        Edge(int a,int b,int c)
        {
            u=a;
            v=b;
            w=c;
        }    
    }
    void printPath(int p[],int i)
    {
        if(p[i]==-1)
        return;
        printPath(p,p[i]);
        System.out.print(i+" ");
    }
    public void main()
    {
        Scanner sc=new Scanner(System.in);
        BellmanFord obj=new BellmanFord();
        int i,v,e,u,ve,w,j,neg=0;
        System.out.println("No. of vertices and edges please");
        v=sc.nextInt();
        e=sc.nextInt();
        Edge arr[]=new Edge[e];
        System.out.println("Input edges");
        for(i=0;i<e;i++)
        {
            u=sc.nextInt();
            ve=sc.nextInt();
            w=sc.nextInt();
            arr[i]=new Edge(u,ve,w);
        }
        int dist[]=new int[v];
        int p[]=new int[v];
        for(i=0;i<v;i++)
        dist[i]=Integer.MAX_VALUE;
        dist[1]=0;
        p[1]=-1;
        for(i=0;i<v-1;i++)
        {
            for(j=0;j<e;j++)
            {
                if(dist[arr[j].u]!=Integer.MAX_VALUE&&dist[arr[j].v]>dist[arr[j].u]+arr[j].w)
                {
                    dist[arr[j].v]=dist[arr[j].u]+arr[j].w;
                    p[arr[j].v]=arr[j].u;
                }
            }
        }
        for(j=0;j<e;j++)
        if(dist[arr[j].u]!=Integer.MAX_VALUE&&dist[arr[j].v]>dist[arr[j].u]+arr[j].w)
        {
            neg=1;
            System.out.println("Negative cycle");
            break;
        }
        if(neg==0)
        {
            System.out.println("Distances are: ");
            for(i=0;i<v;i++)
            System.out.println(i+" "+dist[i]);
            System.out.println("Path followed:");
            for(i=0;i<v;i++)
            { 
                System.out.print("1 ");
                obj.printPath(p,i);
                System.out.println();
            }
        }
    }
}