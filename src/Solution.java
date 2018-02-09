import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Solution obj=new Solution();
        obj.go();
    }
    /* void initialize( int arr[ ], int n,int size[],int x[])
    {
        for(int i = 0;i<n;i++)
        {
            arr[ i ] = i ;
            size[ i ] = 1;
            x[i]=i;
        }
    }*/
    void w_union(int arr[ ],int size[ ],int a,int b)
    {
        int root_A = root(arr,a);
        int root_B = root(arr,b);
        if(size[root_A] < size[root_B ])
        {
            arr[ root_A ] = arr[root_B];
            size[root_B] += size[root_A];
        }
        else
        {
            arr[ root_B ] = arr[root_A];
            size[root_A] += size[root_B];
        }
    }
    int root (int Arr[ ] ,int i)
    {
        while(Arr[ i ] != i)
        {
            Arr[ i ] = Arr[ Arr[ i ] ] ; 
            i = Arr[ i ]; 
        }
        return i;
    }
    /*boolean find(int arr[],int A,int B)
    {
        if( root(arr,A)==root(arr,B) )       //if A and B have same root,means they are connected.
        return true;
        else
        return false;
    }*/
    public void go()
    {
        Scanner sc=new Scanner(System.in);
        int t,n,i,m,j,p,count=0,max=0;
        t=sc.nextInt();
        while(t-->0)
        {
            max=0;
            count=1;
            n=sc.nextInt();
            m=sc.nextInt();
            p=n*m;
            int aux[][]=new int[n][m];
            int arr[]=new int[p];
            int size[]=new int[p];
            for(i=0;i<p;i++)
            {
                size[i]=1;
                arr[i]=p+1;
            }
            for(i=0;i<n;i++)
            {
                for(j=0;j<m;j++)
                {
                    aux[i][j]=sc.nextInt();
                    if(aux[i][j]==1)
                    arr[i*m+j]=i*m+j;
                }
            }
            /*for(i=0;i<n;i++)
            {
                for(j=0;j<m;j++)
                {
                    System.out.print(aux[i][j]+" ");
                }
                System.out.println();
            }*/
            for(i=0;i<n;i++)
            {
                for(j=0;j<m;j++)
                {
                    if(aux[i][j]==1&&j<m-1&&aux[i][j+1]==1)
                    w_union(arr,size,i*m+j,i*m+j+1);
                    if(aux[i][j]==1&&i<n-1&&j<m-1&&aux[i+1][j+1]==1)
                    w_union(arr,size,i*m+j,(i+1)*m+j+1);
                    if(aux[i][j]==1&&i<n-1&&aux[i+1][j]==1)
                    w_union(arr,size,i*m+j,(i+1)*m+j);
                    if(aux[i][j]==1&&i>0&&j<m-1&&aux[i-1][j+1]==1)
                    w_union(arr,size,i*m+j,(i-1)*m+j+1);
                }
            }
            int x[]=new int[p];
            /* for(i=0;i<p;i++)
            if(arr[i]!=p+1)
            x[i]=root(arr,i);
            Arrays.sort(x);*/
            Arrays.sort(arr);
            /*for(i=0;i<p;i++)
                System.out.print(arr[i]+" ");
            System.out.println();*/
            /*for(i=0;i<p;i++)
            System.out.print(x[i]+" ");
            System.out.println();*/
            int count2=0;
            for(i=0;i<p-1;i++)
            {
                if(arr[i]==arr[i+1]&&arr[i]!=p+1)
                count++;
                else
                {
                    if(count>max)
                    {
                        max=count;
                    }
                    count=1;
                }
                if(arr[i]==217)
                    count2++;
            }
            if(count>max)
            max=count;
            System.out.println(max+" "+count2);
        }
        sc.close();
    }
}