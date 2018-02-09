import java.util.*;
class Trig
{
    public void main()
    {
        Scanner sc=new Scanner(System.in);
        String test,str="";
        test=sc.next();
        match_brackets obj=new match_brackets();
        test=obj.go(test);
        int i,l=test.length(),j,count=0;
        char ch,ch2;
        for(i=l-1;i>=0;i--)
        {
            ch=test.charAt(i);
            if(ch>='a'&&ch<='z')
            {
                for(j=i+1;;j++)
                {
                    ch2=test.charAt(j);
                    if(ch2=='(')
                    count++;
                    else if(ch2==')')
                    {
                        if(count==1)
                        {
                            str=str+ch2;
                            break;
                        }
                        else
                        count--;
                    }
                    str=str+ch2;
                }
                str=Math.sin(Double.parseDouble(str))+"";
                test=test.substring(0,i-2)+str+test.substring(j+1);
                str="";
                count=0;
                i=test.length();
            }
        }
        sc.close();
    }
}