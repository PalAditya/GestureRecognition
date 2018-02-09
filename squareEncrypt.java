import java.io.*;
class squareEncrypt
{
    public void main()throws IOException
    {
        BufferedReader br=new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        String str="";
        System.out.println("Do enter a string");
        str=br.readLine();
        System.out.println("You entered: "+str);
        encrypt(str);
    }
    public void encrypt(String str)
    {
        int l,i,temp,j,a=0;
        l=str.length();
        for(i=1;;i++)
        if(i*i>l)
        break;
        temp=i;
        char arr[][]=new char[temp][temp];
        for(i=0;i<temp;i++)
        for(j=0;j<temp;j++)
        if(a<l)
        if(str.charAt(a++)!=' ')
        arr[i][j]=str.charAt(a-1);
        else
        arr[i][j]='*';
        else
        arr[i][j]='*';
        str="";
        for(i=0;i<temp;i++)
        for(j=0;j<temp;j++)
        str=str+arr[j][i];
        System.out.println("Encrypted version is: "+str);
        decrypt(str,temp);
    }
    public void decrypt(String str,int temp)
    {
        int i=0,j=0,a=0;
        char arr[][]=new char[temp][temp];
        for(i=0;i<temp;i++)
        for(j=0;j<temp;j++)
        arr[j][i]=str.charAt(a++);
        str="";
        for(i=0;i<temp;i++)
        for(j=0;j<temp;j++)
        if(arr[i][j]!='*')
        str=str+arr[i][j];
        else
        str=str+" ";
        System.out.println("The decrypted string is: "+str);
    }
}