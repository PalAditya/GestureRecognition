/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */
import java.util.*;
public class KruskalVsPrim
{
    int V;
    KruskalVsPrim(int v)
    {
        V=v;
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
        /*for(i=0;i<V;i++)
            {
            for(j=0;j<V;j++)
            System.out.print(mat[i][j]+" ");
            System.out.println();
            }
            System.out.println();*/
    }
    public static void main(String args[])
    {
        //AllPairsShortestPath obj=new AllPairsShortestPath(0);
        int i,k,v,j,e,t,l;
        double p;
        Scanner sc=new Scanner(System.in);
        
        for(l=0;l<2;l++)
        {     
            System.out.println("Vertex? Probability?");
            v=sc.nextInt();
            KruskalVsPrim obj=new KruskalVsPrim(v);
            p=sc.nextDouble();
            e=0;
            t=0;
            Prim g1=new Prim(v);
            int g[][]=new int[v][v];
            obj.x(p, g);
            /*for(i=0;i<v;i++)
            {
            for(j=0;j<v;j++)
            System.out.print(g[i][j]+" ");
            System.out.println();
            }
            System.out.println();*/
            for(i=0;i<v;i++)
            for(j=0;j<v;j++)
            {
                if(g[i][j]<21&&g[i][j]>-1)
                {
                    g1.addEdge(i,j,g[i][j]);
                    e++;
                }
            }
            Kruskal g2=new Kruskal(v,e);
            //System.out.println(e);
            for(i=0;i<v;i++)
            for(j=0;j<v;j++)
            {
                if(g[i][j]<21&&g[i][j]>-1)
                {
                    g2.addEdge(i,j,g[i][j],t++);
                    e++;
                }
            }
            /*for(i=0;i<v;i++)
            {
                Iterator<Prim.Pair> itr=g1.adj[i].iterator();
                while(itr.hasNext())
                {
                    Prim.Pair x=itr.next();
                    System.out.println(x.v+" "+x.w);
                    g2.addEdge(i, x.v, x.w, t++);
                }
            }*/
            long t1,t2,t3;
            t1=System.nanoTime();
            g1.shortestPath(0);
            t2=System.nanoTime();
            g2.KruskalMST();
            t3=System.nanoTime();
            System.out.println("With vertex "+v+" and probability "+p+", Prim took "+(t2-t1)*1.0/Math.pow(10, 9)+" and Kruskal took "+(t3-t2)*1.0/Math.pow(10,9));
        }
    }
    
}
