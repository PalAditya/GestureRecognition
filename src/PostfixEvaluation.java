import java.io.*;
class PostfixEvaluation
{
    public double evaluate(String str,InnerStack stack)
    {
        char ch;
        int i=0,l=str.length();
        String s[]=str.split(" ");
        double num1,num2;
        for(i=0;i<s.length;i++)
        {
            ch=s[i].charAt(0);
            if(isOperator(ch))
            {
                num1=stack.pop();
                num2=stack.pop();
                switch(ch)
                {
                    case '+':
                    stack.push(num2+num1);
                    break;
                    case '-':
                    stack.push(num2-num1);
                    break;
                    case '*':
                    stack.push(num2*num1);
                    break;
                    case '/':
                    stack.push((double)(1.0)*num2/num1);
                    break;
                    case '^':
                    stack.push(Math.pow(num2,num1));
                    break;
                    default:
                    System.out.println("I don't know that symbol yet...");
                }
            }
            else
            {
                stack.push(Double.parseDouble(s[i]));
            }
        }
        return stack.pop();
    }
    public double execute(String s)
    {
        double d;
        InnerStack stack=new InnerStack(s.length());
        d=evaluate(s,stack);
        return d;
    }
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter postfix");
        String s=br.readLine();
        PostfixEvaluation obj=new PostfixEvaluation();
        System.out.println(obj.execute(s));
    }
    public boolean isOperator(char ch)
    {
        return(ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='^');
    }
    public class InnerStack
    {
        double arr[];
        int top,size;
        InnerStack(int l)
        {
            size=l;
            arr=new double[size];
            top=-1;
        }
        void push(double d)
        {
            if(top==size-1)
            {
                System.out.println("Insertion not posible");
                return;
            }
            arr[++top]=d;
        }
        double pop()
        {
            if(top==-1)
            {
                System.out.println("Deletion not posible");
                return 0.0;
            }
            return arr[top--];
        }
    }
}