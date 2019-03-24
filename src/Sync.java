public class Sync {
    class Arrivals implements Runnable
    {
        Sync sync;
        Arrivals(Sync s)
        {
            sync=s;
        }
        public void run()
        {     
            while(true)
            {
                try
                {
                    sync.arrive();
                }catch(InterruptedException e)
                {
                    System.out.println(e.getMessage());
                }
            }
            
        }       
        
    }
    class Departures implements Runnable
    {
        Sync sync;
        Departures(Sync s)
        {
            sync=s;
        }
        public void run()
        {
            while(true)
            {
                try
                {

                    sync.depart();
                }catch(InterruptedException e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    protected int spaces,capacity,count;
    Arrivals a;
    Departures d;
    Sync(int n)
    {
        capacity=spaces=n;
        count=1000;
        a=new Arrivals(this);
        d=new Departures(this);
        Thread t1=new Thread(a);
        Thread t2=new Thread(d);
        t1.start();
        t2.start();
    }
    synchronized void arrive()throws InterruptedException
    {
        while(spaces==0)
            wait();
        --spaces;
        System.out.println("Arrive called: "+spaces+" left");
        count--;
        if(count==0)
            System.exit(0);
        notifyAll();
    }
    synchronized void depart()throws InterruptedException
    {
        while(spaces==capacity)
            wait();
        ++spaces;
        System.out.println("Depart called: "+spaces+" left");
        count--;
        if(count==0)
            System.exit(0);
        notifyAll();
    }
    public static void main(String args[])
    {
        Sync obj=new Sync(100);
        //obj.go();
    }
    /*public void go()
    {
        Sync obj=new Sync(100);
    }  */ 
}