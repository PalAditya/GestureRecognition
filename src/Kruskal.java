import java.util.*;
class Kruskal
{
    class Edge implements Comparable<Edge>
    {
        int src, dest, weight;
        public int compareTo(Edge compareEdge)
        {
            return this.weight-compareEdge.weight;
        }
    };
    Edge toDelete=new Edge();
    Edge toAdd=new Edge();
    int max=0;
    class Graph
    {
        int V;
        LinkedList<Pair> adj[];
        class Pair
        {
            int a,b;
            Pair(int x,int y)
            {
                a=x;
                b=y;
            }
        }
        Graph(int v)
        {
            V=v;
            adj=new LinkedList[v];
            for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
        }
        void addEdge(int a,int b,int c)
        {
            adj[a].add(new Pair(b,c));
            adj[b].add(new Pair(a,c));
        }
        void dfs(int src,boolean visited[])
        {
            if(visited[src]==true)
                return;
            visited[src]=true;
            Iterator itr=adj[src].iterator();
            while(itr.hasNext())
            {
                Pair x=(Pair)itr.next();
                if(x.b>max)
                {
                    max=x.b;
                    toDelete.src=src;
                    toDelete.dest=x.a;
                    toDelete.weight=max;
                }
                //System.out.println(x.a+" "+x.b+" "+max);
                dfs(x.a,visited);
            }
            //return max;
        }
        void bfs(int src,boolean visited[],int comp[])
        {
            LinkedList<Integer> queue = new LinkedList<>();
            if(visited[src])
                return;
            visited[src]=true;
            queue.add(src);

            while (!queue.isEmpty())
            {
                
                int x = queue.poll();
               // System.out.print(x+","+src+" ");
                comp[x]=src;
                Iterator<Pair> i = adj[x].listIterator();
                while (i.hasNext())
                {
                    int n = i.next().a;
                    if (!visited[n])
                    {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
            //System.out.println();
        }
    }
    class subset
    {
        int parent, rank;
    };
    int V, E;
    Edge edge[];
    Kruskal(int v, int e)
    {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i=0; i<e; ++i)
            edge[i] = new Edge();
    }
    /*
    7 10
    0 1 2
    1 2 3
    2 3 4
    3 4 1
    4 5 5
    5 0 8
    0 2 6
    2 4 3
    5 6 6
    6 3 7
    */
    void updateMSTAddEge(Edge result[],int u,int v,int w)
    {
        int i,l=result.length;
        Graph g=new Graph(l+1);
        for(i=0;i<l;i++)
            g.addEdge(result[i].src,result[i].dest,result[i].weight);
        g.addEdge(u, v, w);
        boolean visited[]=new boolean[l+1];
        g.dfs(u,visited);
        //System.out.println(max);
        
    }
    void updateMSTDeleteEdge(Edge result[],int u,int v,int w)
    {
        int i,l=result.length,flag=0;
        Graph g=new Graph(l+1);
        for(i=0;i<l;i++)
        {
            if(result[i].src==u&&result[i].dest==v&&result[i].weight==w)
            {
                flag=1;
                continue;
            }
            g.addEdge(result[i].src,result[i].dest,result[i].weight);
        }
        if(flag==0)
            return;
        boolean visited[]=new boolean[l+1];
        int comp[]=new int[l+1];
        for(i=0;i<l;i++)
        g.bfs(i,visited,comp);
        /*for(i=0;i<l;i++)
            System.out.print(comp[i]+" ");*/
        //System.out.println(max);
        int r=edge.length,min=Integer.MAX_VALUE;
        for(i=0;i<r;i++)
        {
            if(comp[edge[i].src]!=comp[edge[i].dest]&&edge[i].weight<min&&!(edge[i].src==u&&edge[i].dest==v&&edge[i].weight==w))
            {
                toAdd.src=edge[i].src;
                toAdd.dest=edge[i].dest;
                toAdd.weight=edge[i].weight;
                min=edge[i].weight;
            }
        }
    }
    int find(subset subsets[], int i)
    {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
 
        return subsets[i].parent;
    }
    void Union(subset subsets[], int x, int y)
    {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else
        {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
    void KruskalMST()
    {
        Edge result[] = new Edge[V];  
        int e = 0;  
        int i = 0; 
        for (i=0; i<V; ++i)
            result[i] = new Edge();
        Arrays.sort(edge);
        subset subsets[] = new subset[V];
        for(i=0; i<V; ++i)
            subsets[i]=new subset();
        for (int v = 0; v < V; ++v)
        {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        i = 0;
        while (e < V - 1)
        {
            Edge next_edge = new Edge();
            next_edge = edge[i++]; 
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);
            if (x != y)
            {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
        }
        System.out.println("Following are the edges in " + 
                                     "the constructed MST");
        int cost=0;
        for (i = 0; i < e; ++i)
        {
            System.out.println(result[i].src+" -> " +result[i].dest);
            cost+=result[i].weight;
        }
        System.out.println("And cost is: "+cost);
        /*updateMSTAddEge(result, 1, 6, 2);
        System.out.println("Following are the edges in " + 
                                     "the new MST");
        cost=0;
        int k=0;
        for (i = 0; i < e; ++i)
        {
            if(result[i].src==toDelete.src&&result[i].dest==toDelete.dest&&result[i].weight==toDelete.weight)
                continue;
            System.out.println(result[i].src+" -> " +result[i].dest);
            k++;
            cost+=result[i].weight;
        }
        if(k!=e)
        {
            System.out.println("1 -> 6");
            cost+=2;
        }
        System.out.println("And cost is: "+cost);*/
        updateMSTDeleteEdge(result,1,2,3);
        System.out.println("Following are the edges in " + 
                                     "the new MST");
        cost=0;
        int k=0;
        for (i = 0; i < e; ++i)
        {
            if(result[i].src==1&&result[i].dest==2&&result[i].weight==3)
                continue;
            System.out.println(result[i].src+" -> " +result[i].dest);
            k++;
            cost+=result[i].weight;
        }
        if(k!=e)
        {
            System.out.println(toAdd.src+" -> "+toAdd.dest);
            cost+=toAdd.weight;
        }
        System.out.println("And cost is: "+cost);
        
    }
    void addEdge(int u,int v,int w,int i)
    {
        edge[i].src=u;
        edge[i].dest=v;
        edge[i].weight=w;
    }
    public static void main(String args[])
    {
        int i,u,v,w,ve,ed;
        Scanner sc=new Scanner(System.in);
        ve=sc.nextInt();
        ed=sc.nextInt();
        Kruskal obj=new Kruskal(ve,ed);
        for(i=0;i<ed;i++)
        {
            u=sc.nextInt();
            v=sc.nextInt();
            w=sc.nextInt();
            obj.addEdge(u, v, w,i);
        }   
        obj.KruskalMST();
        
    }
}