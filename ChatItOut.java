import javax.swing.JFrame;

public class ChatItOut {
   public static void main(String[] args) {
      
      
      Thread thread1 = new Thread () 
      {
          public void run ()
          {
              Server sally = new Server();
              sally.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              sally.startRunning();
          }
      };
      Thread thread2 = new Thread ()
      {
          public void run () 
          {
              Client charlie;
              charlie = new Client("127.0.0.1");
              charlie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              charlie.startRunning();
          }
      };
      /*Thread thread3 = new Thread ()
      {
          public void run () 
          {
              Client charlie2;
              charlie2 = new Client("127.0.0.1");
              charlie2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              charlie2.startRunning();
          }
      };*/
      thread1.start();
      long t=30000000,i;
      t=t*10;
      for ( i=0;i<t;i++);
      thread2.start();
      //for ( i=0;i<t;i++);
      //thread3.start();
    }
}
