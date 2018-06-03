import java.io.*;
class Quicksort
{
    int partition(int arr[],int beg,int end,int loc)
    {
        int left=0,right=0,temp=0;
        left=beg;
        loc=beg;
        right=end;
        while(right!=left)
        {
            while(arr[loc]<arr[right]&&right!=0)
            right--;
            temp=arr[right];
            arr[right]=arr[left];
            arr[left]=temp;
            if(right!=left)
            {
                loc=right;
                while(arr[loc]>arr[left]&&left!=end)
                left++;
            }
            if(right!=left)
            {
                loc=left;
                temp=arr[right];
                arr[right]=arr[left];
                arr[left]=temp;
            }
        }
        return loc;
    }
    void quicksort(int arr[],int beg,int end)
    {
        int loc=0;
        if(beg<end)
        {
            loc=partition(arr,beg,end,loc);
            quicksort(arr,beg,loc-1);
            quicksort(arr,loc+1,end);
        }
    }
    void main()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=0,i=0;
        System.out.println("How many numbers?");
        n=Integer.parseInt(br.readLine());
        int arr[]=new int[n];
        System.out.println("Enter array elements");
        for(i=0;i<n;i++)
        arr[i]=Integer.parseInt(br.readLine());
        System.out.println("Array is:");
        for(i=0;i<n;i++)
        System.out.print(arr[i]+"\t");
        System.out.println();
        quicksort(arr,0,n-1);
        System.out.println("The sorted array is: ");
        for(i=0;i<n;i++)
        System.out.print(arr[i]+"\t");
        System.out.println();
    }
}