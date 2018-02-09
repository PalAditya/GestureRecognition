import java.util.*;
import java.text.*;

public class DateDemo {

   public static void main(String args[]) {
      Date dNow = new Date( );
      SimpleDateFormat ft = 
      new SimpleDateFormat ("dd.MM.yyyy");

      System.out.println("Current Date: " + ft.format(dNow));
   }
}