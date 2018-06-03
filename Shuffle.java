import java.io.*;
class Shuffle
{
    void main()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s1="abc",s2="def",s3="bdeafc";
        int i=0,a=0,b=0;
        for(i=0;i<s3.length();i++)
        {
            if(s3.charAt(i)==s1.charAt(a))
            a++;
            else if(s3.charAt(i)==s2.charAt(b))
            b++;
            else
            break;
        }
        if(i==s3.length())
        System.out.println("Valid");
        else
        System.out.println("Invalid");
    }
}