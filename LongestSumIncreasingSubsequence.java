import java.util.*;
class LongestSumIncreasingSubsequence
{
    public static void main(String args[])
    {
        int arr[]={10,5};
        int n=arr.length;
        System.out.println("Result: "+LSIS(arr,n));
    }
    static int LSIS(int arr[],int n)
    {
        int i,j,max=arr[0],max2;
        int sum[]=new int[n];
        sum[0]=arr[0];
        for(i=1;i<n;i++)
        {
            j=i-1;
            max2=0;;
            while(j>=0)
            {
                if(arr[j]<arr[i]&&sum[j]>max2)
                max2=sum[j];
                j--;
            }
            /*if(arr[j]<=arr[i])
            sum[i]=sum[j]+arr[i];
            else
            sum[i]=arr[i];*/
            sum[i]=max2+arr[i];
            if(sum[i]>max)
            max=sum[i];
        }
        for(i=0;i<n;i++)
        System.out.print(sum[i]+" ");
        System.out.println();
        return max;
    }
}