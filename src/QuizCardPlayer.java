import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class QuizCardPlayer 
{
    private JTextArea display; 
    private JTextArea answer; 
    JCheckBox box1,box2,box3,box4;
    private ArrayList <QuizCardReal> cardList;
    private QuizCardReal currentCard; 
    private int currentCardIndex; 
    private JFrame frame; 
    private JButton nextButton;
    private JPanel panel;
    private boolean isShowAnswer;
    public static void main (String[] args) 
    {
        QuizCardPlayer reader = new QuizCardPlayer();
        reader.go();
    }
    public void go()
    {
        frame = new JFrame ("Quiz Card Player");
        JPanel mainPanel=new JPanel();
        Font bigFont=new Font("sanserif",Font.BOLD,24);
        display=new JTextArea(6,20);
        display.setLineWrap(true);
        display.setWrapStyleWord(true);
        display.setFont(bigFont);
        JScrollPane qScroller = new JScrollPane(display); 
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); 
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        nextButton = new JButton("Show question"); 
        mainPanel.add(qScroller);
        mainPanel.add(nextButton);
        nextButton.addActionListener(new NextCardListener());
        JMenuBar menuBar = new JMenuBar(); 
        JMenu fileMenu = new JMenu("File"); 
        JMenuItem loadMenuItem = new JMenuItem ("Load card set"); 
        loadMenuItem.addActionListener(new OpenMenuListener()); 
        fileMenu. add (loadMenuItem) ; 
        menuBar.add(fileMenu); 
        frame.setJMenuBar(menuBar); 
        frame.getContentPane() .add(BorderLayout.NORTH, mainPanel); 
        frame.setSize(640, 500); 
        frame.setVisible(true) ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 
    public class NextCardListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent event)
        {
            if (isShowAnswer) 
            {
                 display.setText(currentCard.getAnswer()) ; 
                 nextButton.setText("Next Card"); 
                 isShowAnswer = false;
            }
            else if(currentCardIndex<cardList.size())
                showNextCard();
            else
            {
                display.setText("That was all \n");
                nextButton.setEnabled(false);
            }
        }
    }
    public class OpenMenuListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent event)
        {
           JFileChooser fileOpen=new JFileChooser();
           fileOpen.showOpenDialog(frame); 
           loadFile(fileOpen.getSelectedFile());
        }
    }
    private void loadFile(File file) 
    {
        cardList = new ArrayList<QuizCardReal>();
        try
        {
            BufferedReader reader=new BufferedReader(new FileReader(file));
            String line=null;
            while((line=reader.readLine()).equals(null)!=true)
            {
                makeCard(line);
            }
            reader.close();
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        showNextCard();
    } 
    private void makeCard(String str) 
    {
        String result[]=str.split("/");
        QuizCardReal card = new QuizCardReal(result[0], result[1]+"/"+result[2]+"/"+result[3]+"/"+result[4],result[5]); 
        cardList.add(card);
        System.out.println("Made a card");
    }
    private void showNextCard()
    {
        currentCard=cardList.get(currentCardIndex);
        currentCardIndex++;
        String arr[]=currentCard.getOptions().split("/");
        box1=new JCheckBox(arr[0]);
        box2=new JCheckBox(arr[1]);
        box3=new JCheckBox(arr[2]);
        box4=new JCheckBox(arr[3]);
        panel=new JPanel();
        panel.add(box1);
        panel.add(box2);
        panel.add(box3);
        panel.add(box4);
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        frame.getContentPane().add(BorderLayout.SOUTH,panel);
        display.setText(currentCard.getQuestion());
        nextButton.setText("Show Answer");
        isShowAnswer=true;
    }
}
