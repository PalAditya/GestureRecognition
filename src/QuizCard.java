import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class QuizCard
{
    private JTextArea question;
    private JTextArea answer;
    private JTextArea option;  
    private ArrayList<QuizCardReal> cardList ; 
    private JFrame frame;
    public static void main(String args[])
    {
        QuizCard obj=new QuizCard();
        obj.go();
    }
    public void go()
    {
        frame=new JFrame("Quiz-O-Matic!");
        JPanel mainPanel=new JPanel();
        JPanel mainPanel2=new JPanel();
        Font bigFont=new Font("sanserif",Font.BOLD,24);
        question=new JTextArea(6,20);
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        question.setFont(bigFont);
        JScrollPane qScroller = new JScrollPane(question); 
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); 
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        option = new JTextArea(6, 20);
        option.setLineWrap(true); 
        option.setWrapStyleWord(true);
        option.setFont(bigFont);
        JScrollPane oScroller = new JScrollPane(option);
        oScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); 
        oScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        answer = new JTextArea(6, 20);
        answer.setLineWrap(true); 
        answer.setWrapStyleWord(true);
        answer.setFont(bigFont);
        JScrollPane aScroller = new JScrollPane(answer);
        aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); 
        aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        JButton nextButton = new JButton("Next Card"); 
        cardList = new ArrayList<QuizCardReal>();
        JLabel qLabel = new JLabel("Question:");
        JLabel aLabel = new JLabel("Answer:");
        JLabel oLabel = new JLabel("Option:");
        mainPanel.add(qLabel); 
        mainPanel.add(qScroller); 
        mainPanel.add(oLabel); 
        mainPanel.add(oScroller); 
        mainPanel2.add(aLabel);
        mainPanel2.add(aScroller);
        mainPanel2.add(nextButton); 
        nextButton.addActionListener(new NextCardListener()); 
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File"); 
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem saveMenuItem = new JMenuItem("Save") ;
        newMenuItem.addActionListener(new NewMenuListener());
        saveMenuItem.addActionListener(new SaveMenuListener());
        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu); 
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.NORTH,mainPanel);
        frame.getContentPane().add(BorderLayout.SOUTH,mainPanel2);
        frame.setSize(500,600) ;
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public class NextCardListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            QuizCardReal card = new QuizCardReal(question.getText(),option.getText(), answer.getText()); 
            cardList.add(card);
            clearCard();
        }
    }
    public class SaveMenuListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ev) 
        {
            QuizCardReal card = new QuizCardReal(question.getText(),option.getText(),answer.getText());
            cardList.add(card);
            JFileChooser fileSave=new JFileChooser();
            fileSave.showSaveDialog(frame);
            saveFile(fileSave.getSelectedFile());
        }
    } 
    public class NewMenuListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            cardList.clear();
            clearCard();
        }
    }
    private void clearCard()
    {
        question.setText("");
        answer.setText("");
        option.setText("");
        question.requestFocus();
    }
    private void saveFile(File file)
    {
        try
        {
            BufferedWriter writer=new BufferedWriter(new FileWriter(file));
            for(QuizCardReal card: cardList)
            {
                writer.write(card.getQuestion()+"/");
                writer.write(card.getOptions()+"/");
                writer.write(card.getAnswer()+"\n");
            }
            writer.close();
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
    }
}