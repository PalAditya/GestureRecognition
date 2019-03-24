/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */
/*
Schedule 1 inputs:
6
4
3
1 1
1 2
1 3
3
2 4
2 2
2 3
3
1 2
2 3
1 1
4
1 3
2 5
1 2
1 3
Schedule 2 inputs (Deadlocks; chane the last line to 1 2 to break deadlock):
6
3
2
1 1
1 2
3
1 2
2 1
2 3
3
2 3
1 2
1 1
*/
import java.util.*;
public class strict2PL 
{
    int lockable_items;
    ArrayList<Integer> read_set[];
    int write_lock[];
    ArrayList<Tuple> q=new ArrayList<>();

    private boolean randomlySkip(int sched) 
    {
        /*Uncomment to simulate random schedule*/
        //return Math.random()*sched>=sched/2;
        return false;
    }
    class Tuple
    {
        int type,id,item;
        Tuple(int a,int b,int c)
        {
            type=a;
            id=b;
            item=c;
        }
    }
    strict2PL(int x)
    {
        lockable_items=x;
        read_set=new ArrayList[x];
        for(int i=0;i<x;i++)
            read_set[i]=new ArrayList<>();
        write_lock=new int[x];
        Arrays.fill(write_lock,-1);
    }
    boolean read(int transaction,int item)
    {
        //Grant lock if nobody has claimed this lock yet, or it is a read lock
        if(write_lock[item]==-1)
        {
            read_set[item].add(transaction);
            return true;//can proceed
        }
        else if(write_lock[item]==transaction)
        {
            return true;
        }
        else
        {
            q.add(new Tuple(1,transaction,item));
            return false;//Wait, no proceeding possible
        }
    }
    boolean write(int transaction,int item)
    {
        //Grant lock if nobody has claimed this lock yet, or it is a read lock
        if(write_lock[item]==-1&&((read_set[item].isEmpty())||(read_set[item].get(0)==transaction&&read_set[item].size()==1)))
        {
            write_lock[item]=transaction;
            return true;
        }
        else if(write_lock[item]==transaction)
        {
            return true;
        }
        else
        {
            q.add(new Tuple(2,transaction,item));
            return false;
        }
    }
    void commit(int transaction)
    {
        //Release locks
        int i;
        for(i=0;i<lockable_items;i++)
        {
            if(write_lock[i]==transaction)
                write_lock[i]=-1;
            Iterator iterator=read_set[i].iterator();
            while(iterator.hasNext())
            {
                if(transaction==(int)iterator.next())
                    iterator.remove();
            }
        }
    }
    class Transaction
    {
        int len;
        int type[];
        int item[];
        boolean done;
        int point;
        Transaction(int x)
        {
            len=x;
            type=new int[x];
            item=new int[x];
            done=false;
            point=0;
        }
    }
    public static void main(String args[])
    {
        strict2PL obj=new strict2PL(0);
        obj.go();
    }
    public void go()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of lockable items");
        int no,sched,i,len,j;
        no=sc.nextInt();
        System.out.println("Enter number of schedules");
        sched=sc.nextInt();
        strict2PL obj=new strict2PL(no);
        Transaction arr[]=new Transaction[sched];
        for(i=0;i<sched;i++)
        {
            System.out.println("Enter length of transaction "+(i+1));
            len=sc.nextInt();
            arr[i]=new Transaction(len);
            System.out.println("Enter 1 for read() and 2 for write(); then enter item number in range 0 to "+(obj.lockable_items-1));
            for(j=0;j<len;j++)
            {
                arr[i].type[j]=sc.nextInt();
                arr[i].item[j]=sc.nextInt();
            }
        }
        String schedule="";
        int finished=0;
        boolean happened=false;
        try
        {           
            while(finished!=sched)
            {
                happened=false;
                for(i=0;i<sched;i++)
                {
                    //System.out.println(happened);
                    //System.out.println(i+","+arr[i].point+","+arr[i].len);
                    if(arr[i].done||randomlySkip(sched))
                        continue;
                    if(arr[i].type[arr[i].point]==1)
                    {
                        if(obj.read(i,arr[i].item[arr[i].point]))
                        {
                            arr[i].point++;
                            System.out.println("Transaction "+(i+1)+": Read, line "+(arr[i].point)+" ");
                            happened=true;
                            if(arr[i].point==arr[i].len)
                            {
                                obj.commit(i);
                                System.out.println("Done with transaction "+(i+1));
                                schedule+=(i+1)+" ";
                                arr[i].done=true;
                                finished++;
                            }
                        }
                    }
                    else if(arr[i].type[arr[i].point]==2)
                    {
                        if(obj.write(i,arr[i].item[arr[i].point]))
                        {
                            arr[i].point++;
                            System.out.println("Transaction "+(i+1)+": Wrote, line "+(arr[i].point)+" ");
                            happened=true;
                        }
                        if(arr[i].point==arr[i].len)
                        {
                            obj.commit(i);
                            System.out.println("Done with transaction "+(i+1));
                            schedule+=(i+1)+" ";
                            arr[i].done=true;
                            finished++;
                        }
                    }
                }
                if(!happened)
                {
                    System.out.println("We encountered a deadlock. Please check input carefully");
                    break;
                }
            }
            System.out.println("The serilization order is: "+schedule);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
