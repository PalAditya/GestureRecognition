import java.io.*;
class StackPal//Non object-oriented implementation
{
    int top=-1,size;
    int arr[];
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
            System.out.println("StackPal is empty");
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
        System.out.println("Enter the size of the StackPal");
        n=Integer.parseInt(br.readLine());
        size=n;
        arr=new int[size];
        do
        {
            System.out.println("Press 1 to push, 2 to pop,3 to display, 4 to exit");
            ch=Integer.parseInt(br.readLine());
            switch(ch)
            {
                case 1:
                System.out.println("Enter the number to insert");
                d=Integer.parseInt(br.readLine());
                push(d);
                break;
                case 2:
                pop();
                break;
                case 3:
                display();
                break;
                case 4:
                break;
                default:
                System.out.println("Drunk or what man?");
            }
        }while(ch!=4);
    }
}