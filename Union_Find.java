import java.util.*;
class Union_Find
{
    void initialize( int arr[ ], int n,int size[],int x[])
    {
        for(int i = 0;i<n;i++)
        {
            arr[ i ] = i ;
            size[ i ] = 1;
            x[i]=i;
        }
    }
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
    boolean find(int arr[],int A,int B)
    {
        if( root(arr,A)==root(arr,B) )       //if A and B have same root,means they are connected.
        return true;
        else
        return false;
    }
    public static void main(String args[])
    {
        System.out.println("Eh?");
    }
}