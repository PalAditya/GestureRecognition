import java.util.*;
class match_brackets
{
    public void main()
    {
        Scanner sc=new Scanner(System.in);
        String test="";
        test=sc.next();
        match_brackets obj=new match_brackets();
        obj.go(test);
        sc.close();
    }
    public String go(String test)
    {
        
        String str="";
        
        int op=0,cl=0,l=test.length(),i;
        char c;
        for(i=0;i<l;i++)
        {
            c=test.charAt(i);
            if(c=='(')
            {
                str=str+"(";
                op++;
            }
            else if(c==')')
            {
                if(cl<op)
                {
                    op--;
                    str=str+")";
                }
                else
                    continue;
            }
            else
                str=str+c;
        }
        for(i=0;i<op;i++)
            str=str+")";
        System.out.println(str);
        return str;
    }
}