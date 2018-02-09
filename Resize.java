import java.util.*;
class Resize
{
    public static void main(String args[])
    {
        Resize obj=new Resize();
        obj.go();
    }
    public void go()
    {
        int size=3,i=0;
        @SuppressWarnings("unchecked")
        LinkedList<Integer> arr[]=new LinkedList[size];
        for(i=0;i<size;i++)
        arr[i]=new LinkedList<Integer>();
        arr[0].add(1);
        arr[0].add(2);
        arr[1].add(3);
        arr[2].add(4);
        arr[2].add(5);
        arr[2].add(6);
        for (i=0;i<size;i++)
        {
            for (Integer j: arr[i])
                System.out.print(j+" ");
            System.out.println();
        }
    }
}