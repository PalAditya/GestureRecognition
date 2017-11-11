import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class Calculator 
{    
    JButton button[]=new JButton[20];
    JTextArea text;
    public static void main(String args[])
    {
        Calculator obj=new Calculator();
        obj.getToIt();
    }
    public void getToIt()
    {
        text=new JTextArea(10,20);
        int i;
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        JPanel panel=new JPanel();
        JPanel panel1=new JPanel();
        JPanel panel2=new JPanel();
        JPanel panel3=new JPanel();
        JPanel panel4=new JPanel();
        JPanel panel5=new JPanel();
        JPanel displayPanel=new JPanel();
        for(i=0;i<10;i++)
        {
            button[i]=new JButton(i+"");
            if(i<4)
                panel1.add(button[i]);
            else if(i>=4&&i<8)
                panel2.add(button[i]);
            else
                panel3.add(button[i]);
        }
        button[10]=new JButton("=");
        button[11]=new JButton("+");
        panel3.add(button[10]);
        panel3.add(button[11]);
        button[12]=new JButton("-");
        button[13]=new JButton("*");
        button[14]=new JButton("/");
        button[15]=new JButton("^");
        button[16]=new JButton("(");
        button[17]=new JButton(")");
        button[18]=new JButton("Del");
        button[19]=new JButton("AC");
        for(i=12;i<16;i++)
        {
            panel4.add(button[i]);
        }
        for(i=16;i<20;i++)
        {
            panel5.add(button[i]);
        }
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);
        panel.add(panel5);
        displayPanel.add(text);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.getContentPane().add(BorderLayout.EAST,panel);
        frame.getContentPane().add(BorderLayout.NORTH,displayPanel);
        frame.setResizable(false);
        frame.setVisible(true);
        button[0].addActionListener(new Listener0());
        button[1].addActionListener(new Listener1());
        button[2].addActionListener(new Listener2());
        button[3].addActionListener(new Listener3());
        button[4].addActionListener(new Listener4());
        button[5].addActionListener(new Listener5());
        button[6].addActionListener(new Listener6());
        button[7].addActionListener(new Listener7());
        button[8].addActionListener(new Listener8());
        button[9].addActionListener(new Listener9());
        button[10].addActionListener(new Listener10());
        button[11].addActionListener(new Listener11());
        button[12].addActionListener(new Listener12());
        button[13].addActionListener(new Listener13());
        button[14].addActionListener(new Listener14());
        button[15].addActionListener(new Listener15());
        button[16].addActionListener(new Listener16());
        button[17].addActionListener(new Listener17());
        button[18].addActionListener(new Listener18());
        button[19].addActionListener(new Listener19());
    }
    public boolean isOperator(char ch)
    {
        return(ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='^');
    }
    public class Listener0 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            text.append("0");
        }
    }
    public class Listener1 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            text.append("1");
        }
    }
    public class Listener2 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            text.append("2");
        }
    }
    public class Listener3 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            text.append("3");
        }
    }
    public class Listener4 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            text.append("4");
        }
    }
    public class Listener5 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            text.append("5");
        }
    }
    public class Listener6 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            text.append("6");
        }
    }
    public class Listener7 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            text.append("7");
        }
    }
    public class Listener8 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            text.append("8");
        }
    }
    public class Listener9 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            text.append("9");
        }
    }
    public class Listener10 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            InfixToPostFixEvalution str=new InfixToPostFixEvalution();
            double i=0.0;
            String s;
            text.selectAll();
            s=text.getSelectedText();
            s=convertDesired(s);
            if(s.equals("Null")!=true)
            {
                s=str.convertToPostfix(s);
                text.append("=");
                PostfixEvaluation obj=new PostfixEvaluation();
                i=obj.execute(s);
                text.append(i+"");
            }
            else
            {
                text.append("Press AC and retry!");
            }
        }
    }
    public String convertDesired(String str)
    {
        String abc[]=new String[50];
        int i=0,a=0,j=0,add=0,sub=0;
        String dummy="";
        char ch;
        for(i=0;i<str.length();i++)
        {
           ch=str.charAt(i);
           if(isOperator(ch)&&isOperator(str.charAt(i+1)))
           {
               for(j=i;;j++)
               {
                   ch=str.charAt(j);
                   if(ch=='+')
                   {
                       add++;
                   }
                   else if(ch=='-')
                   {
                       sub++;
                   }
                   else if((ch>=48&&ch<=57)||ch=='.')
                   {
                       break;
                   }
                   else
                   {
                       text.append("Invalid");
                       return "Null";
                   }
               }
               if(dummy.equals("")==false)
               abc[a++]=dummy+" ";
               dummy="";
               if(sub%2==1)
               {
                   abc[a++]='-'+" ";
               }
               else
               {
                   abc[a++]='+'+" ";
               }
               add=0;
               sub=0;
               i=j-1;
           }
           else if((ch>=48&&ch<=57)||ch=='.')
           {
               dummy=dummy+ch;
           }
           else
           {
               if(dummy.equals("")==false)
               abc[a++]=dummy+" ";
               abc[a++]=ch+" ";
               dummy="";
           }
        }
        abc[a++]=dummy;
        dummy="";
        for(i=0;i<a;i++)
        {
            dummy=dummy+abc[i];
        }
        return dummy;
    }
    public class Listener11 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            text.append("+");
        }
    }
    public class Listener12 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            text.append("-");
        }
    }
    public class Listener13 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            text.append("*");
        }
    }
    public class Listener14 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            text.append("/");
        }
    }
    public class Listener15 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            text.append("^");
        }
    }
    public class Listener16 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            text.append("(");
        }
    }
    public class Listener17 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            text.append(")");
        }
    }
    public class Listener18 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            text.selectAll();
            String str=text.getSelectedText();
            str=str.substring(0,str.length()-1);
            text.setText("");
            text.append(str);
        }
    }
    public class Listener19 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            text.setText("");
        }
    }
}
