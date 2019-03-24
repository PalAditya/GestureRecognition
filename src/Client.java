
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Client extends JFrame{

   private JTextField userText;
   private JTextArea chatWindow;
   private ObjectOutputStream output;
   private ObjectInputStream input;
   private String message = "";
   private String serverIP;
   private Socket connection;
   private JButton button;
   //constructor
   public Client(String host){
      super("Client Messenger!");
      serverIP = host;
      userText = new JTextField();
      userText.setEditable(false);
      userText.addActionListener(
         new ActionListener(){
            public void actionPerformed(ActionEvent event){
               sendMessage(userText.getText());
               //System.out.println("ActionListener knows:)");
               userText.setText("");
            }
         }
      );
      button=new JButton("Send");
      userText.setSize(400,600);
      //userText.setText("\n\n\n\n\n\n\n\n\n");
      //userText.setBackground(Color.BLUE);
      add(userText, BorderLayout.NORTH);
      //add(button,BorderLayout.EAST);
      button.addActionListener(new Listener1());
      chatWindow = new JTextArea();
      add(new JScrollPane(chatWindow), BorderLayout.CENTER);
      setSize(300,150);
      setVisible(true);
   }
   class Listener1 implements ActionListener
   {
       public void actionPerformed(ActionEvent Event)
       {
           sendMessage(userText.getText());
       }
   }
   //connect to server
   public void startRunning(){
      try{
         connectToServer();
         setupStreams();
         whileChatting();
      }catch(EOFException eofException){
         showMessage("\n Client terminated connection");
      }catch(IOException ioException){
         ioException.printStackTrace();
      }finally{
         closeCrap();
      }
   }

   //connect to server
   private void connectToServer() throws IOException{
      showMessage("Attempting connection... \n");
      connection = new Socket(InetAddress.getByName(serverIP), 6789);
      showMessage("Connected to: " + connection.getInetAddress().getHostName() );
   }

   //set up streams to send and receive messages
   private void setupStreams() throws IOException{
      output = new ObjectOutputStream(connection.getOutputStream());
      output.flush();
      input = new ObjectInputStream(connection.getInputStream());
      showMessage("\n Dude your streams are now good to go! \n");
   }

   //while chatting with server
   private void whileChatting() throws IOException{
      ableToType(true);
      //sendMessage("Umm2\n");
      do{
         try{
            message = (String) input.readObject();
            showMessage("\n" + message);
            /*if(message.contains("Huhu"))
                sendMessage(message);
            System.out.println(message);*/
            //sendMessage(message);
         }catch(ClassNotFoundException classNotfoundException){
            showMessage("\n I dont know that object type");
         }
      }while(!message.equals("Bye-Bye"));
   }

   //close the streams and sockets
   private void closeCrap(){
      showMessage("\n closing crap down...");
      ableToType(false);
      try{
         output.close();
         input.close();
         connection.close();
      }catch(Exception ioException){
         ioException.printStackTrace();
      }
   }

   //send messages to server
   private void sendMessage(String message){
      try{
         output.writeObject("\nCLIENT - " + message);
         output.flush();
         showMessage("\nCLIENT - " + message);
      }catch(IOException ioException){
         chatWindow.append("\n something messed up sending message host!");
      }
   }

   //change/update chatWindow
   private void showMessage(final String m){
      SwingUtilities.invokeLater(
         new Runnable(){
            public void run(){
               chatWindow.append(m);
            }
         }
      );
   }

   //gives user permission to type crap into the text box
   private void ableToType(final boolean tof){
      SwingUtilities.invokeLater(
         new Runnable(){
            public void run(){
               userText.setEditable(tof);
            }
         }
      );     
   }
   public static void main(String[] args) {
      Client charlie;
      charlie = new Client("127.0.0.1");
      charlie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      charlie.startRunning();
   }
}