import java.io.*;
public class InputOutput1 implements Serializable
{
    public static void main(String args[])
    {
        InputOutputTest one=new InputOutputTest(5);
        System.out.println(one.a);
        try
        {
            FileOutputStream fileStream=new FileOutputStream("MyGame.ser");  
            ObjectOutputStream os=new ObjectOutputStream(fileStream);
            os.writeObject(one);
            os.close();
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        one=null;
        try
        {
            FileInputStream fileStreamIs=new FileInputStream("MyGame.ser");
            ObjectInputStream is=new ObjectInputStream(fileStreamIs);
            InputOutputTest obj1=(InputOutputTest)is.readObject();
            System.out.println(obj1.getA());
            is.close();
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}   
