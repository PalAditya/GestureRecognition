import java.util.*;
public class PageRank { 
public int path[][] = new int[100][100];
public double pagerank[] = new double[100]; 
public void calc(double totalNodes)
{
    double InitialPageRank;
    double OutgoingLinks=0; 
    double DampingFactor = 0.85; 
    double TempPageRank[] = new double[100];
    int ExternalNodeNumber;
    int InternalNodeNumber; 
    int k=1; // For Traversing
    int step=1;
    InitialPageRank = 1/totalNodes;
    System.out.print(" Total Number of Nodes :"+totalNodes+"\t Initial PageRank  of All Nodes :"+InitialPageRank+"\n");
    for(k=1;k<=totalNodes;k++)
    {
      pagerank[k]=InitialPageRank;
    }    
    System.out.print("Initial PageRank Values , 0th Step... \n");
    for(k=1;k<=totalNodes;k++)
    {
      System.out.print(" Page Rank of "+k+" is :\t"+pagerank[k]+"\n");
    }  
     while(true&&step<=1000) // Iterations
     {
         for(k=1;k<=totalNodes;k++)
         {  
            TempPageRank[k]=pagerank[k];
            pagerank[k]=0;
         }
         for(InternalNodeNumber=1;InternalNodeNumber<=totalNodes;InternalNodeNumber++)
         {
              for(ExternalNodeNumber=1;ExternalNodeNumber<=totalNodes;ExternalNodeNumber++)
              {
                    if(path[ExternalNodeNumber][InternalNodeNumber] == 1)
                    { 
                          k=1;
                          OutgoingLinks=0;  
                          while(k<=totalNodes)
                          {
                                if(path[ExternalNodeNumber][k] == 1 )
                                {
                                  OutgoingLinks=OutgoingLinks+1; // Counter for Outgoing Links
                                }  
                                k=k+1;  
                          }      
                          pagerank[InternalNodeNumber]+=DampingFactor*TempPageRank[ExternalNodeNumber]*(1/OutgoingLinks);    
                    }
              }  
              pagerank[InternalNodeNumber]+=(1-DampingFactor)*1.0/totalNodes;
         }     
         System.out.print("\n After "+step+"th Step \n");
         for(k=1;k<=totalNodes;k++) 
          System.out.print(" Page Rank of "+k+" is :\t"+pagerank[k]+"\n"); 
         step = step+1;
         int count=0;
         for(k=1;k<=totalNodes;k++)
         if(Math.abs(pagerank[k]-TempPageRank[k])>0.005)
         count++;
         //System.out.println("Count: "+count);
         if(count==0)
         break;
    }
    System.out.print("\n Final Page Rank : \n"); 
    for(k=1;k<=totalNodes;k++)
    {
        System.out.print(" Page Rank of "+k+" is :\t"+pagerank[k]+"\n"); 
    }   
 } 
public static void main(String args[])
{
        int nodes,i,j,cost,count;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Number of WebPages");
        nodes = in.nextInt();
        PageRank p = new PageRank();
        System.out.println("Enter the Adjacency Matrix with 1 indicating a path & 0 indicating no path between the two webpages");
        for(i=1;i<=nodes;i++)
        {
               count=0;
               for(j=1;j<=nodes;j++)
               {
                    p.path[i][j]=in.nextInt();
                    if(j==i)
                      p.path[i][j]=0;
                    if(p.path[i][j]==1)
                    count++;
               }
               if(count==0)//handling sinks by augmentation
               {
                   for(j=1;j<=nodes;j++)
                   {
                        p.path[i][j]=1;
                        if(j==i)
                          p.path[i][j]=0;
                   }
               }
               count=0;
        }
        p.calc(nodes);
}  
}