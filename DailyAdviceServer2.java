import java.io.*;
import java.net.*;
class DailyAdviceServer2
{
    String[] adviceList = {"Take smaller bites", "Go for the tight jeans. No they do NOT make you look fat.", "One word: inappropriate", "Just for today, be honest. Tell your boss what you *really* think", "You might want to rethink that haircut."};
    public void go()
    {
        try
        {
            ServerSocket ss=new ServerSocket(4242);
            while(true)
            {
                Socket sock=ss.accept();
                PrintWriter pw=new PrintWriter(sock.getOutputStream());
                String advice=adviceList[(int) (Math.random() * adviceList.length)];
                pw.println(advice);
                pw.close();
                System.out.println(advice);
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String args[])
    {
        DailyAdviceServer2 obj=new DailyAdviceServer2();
        obj.go();
    }
}
                
                