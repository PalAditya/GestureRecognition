import java.io.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
    
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String s1,s2;
    int t,i;
    t=Integer.parseInt(br.readLine());
    while(t-->0)
    {
        s1=br.readLine();
        s2=br.readLine();
        int al[]=new int[26];
        int bob[]=new int[26];
        fill(al,s1);
        fill(bob,s2);
        int al_w=0,bob_w=0;
        for(i=0;i<26;i++)
        {
            if(al[i]>bob[i])
            al_w=1;
            else if(bob[i]>al[i])
            bob_w=1;
        }
        if(al_w==1&&bob_w==0)
        System.out.println("You win some.");
        else if(al_w==0&&bob_w==1)
        System.out.println("You lose some.");
        else
        System.out.println("You draw some.");
    }
    }
    static void fill(int arr[],String str)
    {
        int i,l=str.length();
        char ch;
        for(i=0;i<l;i++)
        {
            ch=str.charAt(i);
            if(ch!=' ')
            arr[ch-97]++;
        }
    }
}
