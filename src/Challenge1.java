import java.io.*;
public class Challenge1
{
    public static void main(String args[]) throws IOException
    {
        Challenge1 obj=new Challenge1();
        obj.go();
    }
    public void go() throws IOException
    {
        /*BellmanFord obj=new BellmanFord(3,3);
        obj.addEdge(0, 1, 1);
        obj.addEdge(1, 2, 1);
        obj.addEdge(0, 2, 1);
        obj.show(0, 2, obj.getEdgeArray());*/
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int i,n,sum=0;
        int arr[],arr2[];
        System.out.println("Enter size of array");
        n=Integer.parseInt(br.readLine());
        arr=new int[n];
        System.out.println("Enter elements");
        for(i=0;i<n;i++)
            arr[i]=Integer.parseInt(br.readLine());
        arr2=new int[101];
        for(i=0;i<n;i++)
            arr2[arr[i]]++;
        for(i=0;i<101;i++)
        {
            sum=sum+arr2[i]/2;
        }
        System.out.println("There exists "+sum+" pairs");
    }
}
