/*This code encrypts based on key value provided by user. it first shifts alphabets through the required key, then fills them in spiral array 
and then reads them in vertical manner to produce final output string. Spaces are filled with '*' and asterix with space. any other special character
is ignored. The decrypt method is also given to check the validity..to verify, just remove the comment line within squareEncrypt() method
The GUI is for fun. Input-output is obvious. Put the string in string field and shift value in shift field
Author-Aditya Pal*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class EncryptJavaGUI 
{
    JTextArea area,area2,answer;
    String utility;
    int usefulA,usefulB;
    JButton button,button2;
    public static void main(String args[])
    {
        EncryptJavaGUI obj=new EncryptJavaGUI();
        obj.gui();
    }
    public void gui()
    {
        JFrame frame=new JFrame();
        button=new JButton("Encrypt");
        button2=new JButton("Decrypt");
        JLabel label1=new JLabel("String");
        JLabel label2=new JLabel("Shift");
        area=new JTextArea(6,20);
        area2=new JTextArea(6,20);
        answer=new JTextArea(6,20);
        JPanel panel=new JPanel();
        panel.add(label1);
        panel.add(area);
        panel.add(label2);
        panel.add(area2);
        panel.add(answer);
        panel.add(button);
        panel.add(button2);
        frame.getContentPane().add(panel);
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button.addActionListener(new DoStuff());
        button2.addActionListener(new DoStuffAgain());
    }
    public class DoStuff implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
                go();
        }
    }
    public void go()
    {
        String str,newstr="";
        char ch;
        int i,l,var,key;
        area.selectAll();
        str=area.getSelectedText();
        area2.selectAll();
        str=str.toUpperCase();
        key=Integer.parseInt(area2.getSelectedText());
        key=key%26;
        l=str.length();
        for(i=0;i<l;i++)
        {
            ch=str.charAt(i);
            if(ch>=65&&ch<=90)
            {
                var=(int)ch+key;
                if(var>90)
                    var=var-26;
                newstr=newstr+(char)var;
            }
            else
                newstr=newstr+ch;
        }
        squareEncrypt(newstr,key);
    }
    public void squareEncrypt(String newstr,int key)
    {
        int i,l,var,j,c1=0,c2,r1=0,r2,k=0;
        char ch;
        l=newstr.length();
        for(i=1;;i++)
            if(i*i>l)
                break;
        var=i;
        StringBuffer finalstr=new StringBuffer(var*var);
        for(i=l;i<var*var;i++)
            newstr=newstr+" ";
        char A[][]=new char[var][var];
            c2=var-1;
            r2=var-1;
            while(k<var*var)
                {
                    for(i=c1;i<=c2;i++)
                    {
                            ch=newstr.charAt(k++);
                        if(ch==' ')
                            ch='*';
                        else if(ch=='*')
                            ch=' ';
                        A[r1][i]=ch;
                    }
 
                    for(j=r1+1;j<=r2;j++)
                    {
                        ch=newstr.charAt(k++);
                    if(ch==' ')
                        ch='*';
                    else if(ch=='*')
                            ch=' ';
                        A[j][c2]=ch;
                    }
 
                    for(i=c2-1;i>=c1;i--)
                    {
                        ch=newstr.charAt(k++);
                    if(ch==' ')
                        ch='*';
                    else if(ch=='*')
                            ch=' ';
                        A[r2][i]=ch;
                    }
 
                    for(j=r2-1;j>=r1+1;j--)
                    {
                        ch=newstr.charAt(k++);
                    if(ch==' ')
                        ch='*';
                    else if(ch=='*')
                            ch=' ';
                        A[j][c1]=ch;
                    }
 
                 c1++;
                 c2--;
                 r1++;
                 r2--;
                }
            for(i=0;i<var;i++)
                for(j=0;j<var;j++)
                    finalstr.append(A[j][i]);
            utility=finalstr.toString();
            answer.selectAll();
                if(answer.getSelectedText()!=null)
                answer.setText("");
            answer.append(utility);
            usefulA=var;
            usefulB=key;
    }
    public class DoStuffAgain implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            squareDecrypt(utility,usefulA,usefulB);
        }
    }   
    public void squareDecrypt(String str,int var,int key)
    {
        char arr[][]=new char[var][var];
        int i,j,k=0,c1=0,c2=var-1,r1=0,r2=var-1,temp=0;
        char ch;
        StringBuffer decrypt=new StringBuffer(var*var);
        StringBuffer finalDecrypt=new StringBuffer(var*var);
        for(i=0;i<var;i++)
            for(j=0;j<var;j++)
            {
                ch=str.charAt(temp++);
                if(ch==' ')
                    ch='*';
                else if(ch=='*')
                    ch=' ';
                arr[j][i]=ch;
            }
        temp=0;
        while(k<var*var)
                {
                    for(i=c1;i<=c2;i++)
                    {
                        decrypt.append(arr[r1][i]);
                        k++;
                    }
 
                    for(j=r1+1;j<=r2;j++)
                    {
                        decrypt.append(arr[j][c2]);
                        k++;
                    }
 
                    for(i=c2-1;i>=c1;i--)
                    {
                        decrypt.append(arr[r2][i]);
                        k++;
                    }
 
                    for(j=r2-1;j>=r1+1;j--)
                    {
                        decrypt.append(arr[j][c1]);
                        k++;
                    }
 
                 c1++;
                 c2--;
                 r1++;
                 r2--;
                }
        for(i=0;i<var*var;i++)
        {
            ch=decrypt.charAt(i);
            if(ch>=65&&ch<=90)
            {
                temp=(int)ch-key;
                if(temp<65)
                    temp+=26;
                finalDecrypt.append((char)temp);
            }
            else
                finalDecrypt.append(ch);
        }
        answer.setText("");
        answer.append(finalDecrypt.toString());
    }
}

