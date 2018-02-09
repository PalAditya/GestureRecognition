import java.io.*;
class CoolQuestion
{
    public void main()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=0,i=0,j=0,conv=0,conv2=0,b=0,var=0,a=1;
        String s="";
        System.out.println("Enter the number");
        n=Integer.parseInt(br.readLine());
        if(n==1||n==2)
        {
            return;
        }
        else
        {
            conv=(int)Math.pow(2,(n-1));
            conv2=2*n-1;
            String arr[][]=new String[conv][conv2];
            for(i=0;i<conv;i++)
            {
                for(j=0;j<conv2;j=j+2)
                {
                    arr[i][j]=(a++)+"";
                }
                a=1;
            }
            for(i=0;i<conv;i++)
            {
                s=binaryConvert(i);
                var=s.length();
                for(j=0;j<n-1-var;j++)
                {
                    s="0"+s;
                }
                for(j=1;j<conv2;j=j+2)
                {
                    arr[i][j]=s.charAt(b++)+"";
                }
                b=0;
            }
            for(i=0;i<conv;i++)
            {
                for(j=1;j<conv2;j++)
                {
                    if(arr[i][j].equals("0"))
                    arr[i][j]="+";
                    else if(arr[i][j].equals("1"))
                    arr[i][j]="-";
                    else
                    continue;
                }
            }
            for(i=0;i<conv;i++)
            {
                for(j=0;j<conv2;j++)
                {
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            for(i=0;i<conv;i++)
            {
                if(arr[i][1].equals("+"))
                {
                    var=Integer.parseInt(arr[i][0])+Integer.parseInt(arr[i][2]);
                }
                else
                {
                     var=Integer.parseInt(arr[i][0])-Integer.parseInt(arr[i][2]);
                }
                for(j=3;j<conv2;j=j+2)
                {
                    if(arr[i][j].equals("+"))
                    var=var+Integer.parseInt(arr[i][j+1]);
                    else
                    var=var-Integer.parseInt(arr[i][j+1]);
                }
                if(var==0)
                for(j=0;j<conv2;j++)
                System.out.print(arr[i][j]);
                if(var==0)
                System.out.println();
                var=0;
            }
        }
    }
    String binaryConvert(int i)
    {
        if(i<2)
        return i+"";
        else
        return binaryConvert(i/2)+i%2+"";
    }
}