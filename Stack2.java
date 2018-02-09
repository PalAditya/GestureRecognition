import java.io.*;
class Stack2//Object-oriented implementation
{
    int top,size;
    int arr[];
    Stack2(int n)
    {
        size=n;
        arr=new int[size];
        top=-1;
    }
    void push(int d)
    {
        if(top==size-1)
        {
            System.out.println("Insertion not posible");
            return;
        }
        arr[++top]=d;
    }
    void pop()
    {
        if(top==-1)
        {
            System.out.println("Deletion not posible");
            return;
        }
        System.out.println("Deleted element is: "+arr[top--]);
    }
    void display()
    {
        if(top==-1)
        {
            System.out.println("Stack is empty");
            return;
        }
        int i=0;
        for(i=top;i>=0;i--)
        System.out.println(arr[i]);
    }
    void main()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=0,ch=0,d=0;
        System.out.println("Enter the size of the stack 1");
        n=Integer.parseInt(br.readLine());
        Stack2 obj=new Stack2(n);
        System.out.println("Enter the size of the stack 2");
        n=Integer.parseInt(br.readLine());
        Stack2 obj2=new Stack2(n);
        do
        {
            System.out.println("Press 1 to push in stack 1, 2 to pop from Stack 1,3 to display stack 1, 4 to push in stack 2, 5 to pop from Stack 2,6 to display stack 2,7 to exit");
            ch=Integer.parseInt(br.readLine());
            switch(ch)
            {
                case 1:
                System.out.println("Enter the number to insert");
                d=Integer.parseInt(br.readLine());
                obj.push(d);
                break;
                case 2:
                obj.pop();
                break;
                case 3:
                obj.display();
                break;
                case 7:
                break;
                case 4:
                System.out.println("Enter the number to insert");
                d=Integer.parseInt(br.readLine());
                obj2.push(d);
                break;
                case 5:
                obj2.pop();
                break;
                case 6:
                obj2.display();
                break;
                default:
                System.out.println("Drunk or what man?");
            }
        }while(ch!=7);
    }
}