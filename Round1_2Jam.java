import java.util.*;
import java.io.*;
class Round1_2Jam
{
    public static void main(String args[]) throws IOException
    {
        Round1_2Jam obj=new Round1_2Jam();
        obj.go();
    }
    public void go() throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //Scanner sc=new Scanner(System.in);
        int t,i,b,inp,len,ind,a=0,count=1,flag=0,cust=0,j=0,k=0;
        String l1="";
        t=Integer.parseInt(br.readLine());
        while(t-->0)
        {
            b=Integer.parseInt(br.readLine());
            int set[]=new int[b];
            cust=Integer.parseInt(br.readLine());
            int batch[][]=new int[cust][b*2+1];
            while(cust-->0)
            {
                //System.out.println("******");
                l1=br.readLine();
                String arr[]=l1.split(" ");
                len=arr.length;
                //for(i=0;i<arr.length;i++)
                //System.out.print(arr[i]);
                //System.out.println();
                for(i=0;i<len;i++)
                {
                    batch[a][i+1]=Integer.parseInt(arr[i]);
                    //System.out.print(batch[a][i+1]+" ");
                }
                //System.out.println();
                a++;
            }
            //System.out.println("%%%%%");
            cust=a;
            /*for(i=0;i<cust;i++)
            {
                System.out.println("%%%%%");
                for(j=0;j<b+1;j++)
                System.out.print(batch[i][j]+" ");
                System.out.println();
            }*/
            
            for(i=0;i<b;i++)
            {
                for(j=0;j<cust;j++)
                {
                    if(batch[j][0]!=1000)
                    {
                        for(k=1;k<b+1;k=k+2)
                        {
                            if(batch[j][k]==i+1&&batch[j][k+1]!=1)
                            {
                               batch[j][0]=1000;
                               set[i]=1;
                               break;
                            }
                        }
                    }
                    else
                    continue;
                    //sc.close();
                }
            }
            for(i=0;i<b;i++)
            {
                for(j=0;j<cust;j++)
                {
                    if(batch[j][0]!=1000)
                    {
                        for(k=1;k<b+1;k=k+2)
                        {
                            if(batch[j][k]==i+1&&batch[j][k+1]==1&&set[i]!=1)
                            {
                               batch[j][0]=1000;
                               set[i]=1;
                               break;
                            }
                        }
                    }
                    else
                    continue;
                    //sc.close();
                }
            }
            for(i=0;i<cust;i++)
            {
                if(batch[i][0]!=1000)
                {
                    System.out.println("Case #"+count+": Impossible");
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                System.out.print("Case #"+count+": ");
                for(i=0;i<b;i++)
                System.out.print(set[i]+" ");
            }
            System.out.println();
            count++;
            flag=0;
        }
    }
}