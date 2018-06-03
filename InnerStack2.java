public class InnerStack2
{
        double arr[];
        int top,size;
        InnerStack2(int l)
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