import java.util.*;
import java.io.*;
class Round1Jam
{
    public static void main(String args[]) throws IOException
    {
        Round1Jam obj=new Round1Jam();
        obj.go();
    }
    public void go() throws IOException
    {
        Scanner sc=new Scanner(System.in);
        int t,i,dis,horse,min=Integer.MAX_VALUE,ind=0,v_rel=0,a=1;
        double time=0.0,dist=0.0;
        t=sc.nextInt();
        while(t-->0)
        {
            dis=sc.nextInt();
            horse=sc.nextInt();
            int arr[][]=new int[horse][2];
            for(i=0;i<horse;i++)
            {
                arr[i][0]=sc.nextInt();
                arr[i][1]=sc.nextInt();
                if(arr[i][1]<min)
                {
                    min=arr[i][1];
                    ind=i;
                }
            }
            for(i=0;i<ind;i++)
            {
                v_rel=arr[i][1]-arr[i+1][1];
                if(v_rel>0)
                {
                    time=time+(double)(arr[i+1][0]-arr[i][0])/(v_rel)*1.0;
                    arr[i][1]=arr[i+1][1];
                }
                else
                    continue;
            }
            dist=(1.0)*dis-arr[ind][1]*time-arr[ind][0];
            time=time+dist/(arr[ind][1])*1.0;
            System.out.printf("Case #%d: %.6f\n",a,(dis)/time*1.0);
            a++;
            time=0.0;
        }
    }
}