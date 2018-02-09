import java.util.*;
class GFG
{
    public static void main(String args[])
    {
        GFG obj=new GFG();
        obj.go();
    }
    public void go()
    {
        Scanner sc=new Scanner(System.in);
        int t,n,e,i,j,jump=0,a=0,count=0,flag=0,conn=0;
        t=sc.nextInt();
        while(t-->0)
        {
            n=sc.nextInt();
            e=sc.nextInt();
            int arr[][]=new int[2][2*e];
            for(i=0;i<2;i++)
            {
                for(j=0;j<2*e;j++)
                {
                    arr[i][j]=sc.nextInt();
                }
            }
            for(i=0;i<2*e;i++)
                if(arr[0][i]==1)
                        conn++;
            //System.out.println(conn);
            /*Arrays.sort(arr, new Comparator<Integer[]>(){ 
                public int compare(Integer[] int1, Integer[] int2)
                {
                    Integer numOfKeys1 = int1[0];
                    Integer numOfKeys2 = int2[0];
                    return -numOfKeys1.compareTo(numOfKeys2);
                }
            });*/
            /*System.out.println("\n");
            for(i=0;i<e;i++)
            {
                for(j=0;j<2*e;j++)
                {
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }*/
            jump=2*conn;
            //a=0;
            //while(true)
            //{
              //  if(a+jump>2*e)
                //    jump=2*e-a;
                for(i=0;i<2*e;i=i+a)
                {
                    count=i+jump-2;
                    for(j=i;j<i+jump;j=j+2)
                    {
                        if(arr[0][j]!=arr[1][count]||arr[0][j+1]!=arr[1][count+1])
                        {
                            flag=1;
                            break;
                        }
                        count=count-2;
                        if(count<0&&j+2<jump)
                        {
                            flag=1;
                            break;
                        }
                    }
                    if(count>i)
                    {
                        flag=1;
                        break;
                    }
                    a=jump;
                    jump=jump*2;
                    if(i+a+jump>2*e)
                        jump=2*e-i-a;
                }
            //}
            if(flag==1)
                System.out.println(0);
            else
                System.out.println(1);
            flag=0;
            conn=0;
        }
        sc.close();
    }
}