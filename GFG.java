import java.util.*;
class GFG {
    public static void main(String args[] ) throws Exception {
       GFG obj=new GFG();
       obj.go();
    }
    public void go()
    {
        Scanner sc=new Scanner(System.in);
        int t,n,m,i;
        long k;
        t=sc.nextInt();
        char arr[][]=new char[26][200000];
        while(t-->0)
        {
            HashSet<Long> hs=new HashSet<>();
            n=sc.nextInt();
            m=sc.nextInt();
            for(i=0;i<n;i++)
                hs.add(sc.nextLong());
            for(i=0;i<m;i++)
            {
                k=sc.nextLong();
                if(hs.contains(k))
                    System.out.println("YES");
                else
                   {
                       System.out.println("NO");
                       hs.add(k);
                   } 
            }
        }
    }
}
