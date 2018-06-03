import java.io.*; 
import java.net.*;
public class DailyAdviceClient
{
    public void go()
    {
        try
        {
            Socket s=new Socket("127.0.0.1",4242);
            InputStreamReader is=new InputStreamReader(s.getInputStream());
            BufferedReader br=new BufferedReader(is);
            String advice=br.readLine();
            System.out.println("Today you should: "+advice);
            is.close();
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
    }
    public static void main(String args[])
    {
        DailyAdviceClient obj=new DailyAdviceClient();
        obj.go();
    }
}