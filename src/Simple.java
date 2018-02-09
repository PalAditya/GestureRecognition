import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Simple 
{
    JButton button[]=new JButton[24];
    JTextArea text[]=new JTextArea[24];
    JPanel panel[]=new JPanel[24];
    JPanel mainPanel=new JPanel();
    JButton mButton=new JButton("Roll");
    JButton mButton1=new JButton("Player 1 details");
    JButton mButton2=new JButton("Player 2 details");
    JButton mButton3=new JButton("Player 3 details");
    JTextArea mText=new JTextArea(30,30);
    String arr[]={"Delhi","Agra","Lucknow","Dehradun","Jalandhar","Okay","Kolkata","Nagpur","Aerodrome","Varanasi","Allahabad","Okay","Mumbai","Transport","Steamer","Channai","Ahmedabad","Okay","Kanpur","Bhubaneshwar","Railways","Bhopal","Indore","Okay"};
    int cost[]={4500,1500,2500,1700,2000,0,4500,2500,5000,2000,1500,0,4500,4000,7000,4500,2800,0,3000,2200,7000,2500,2500,0};
    int l_cost[]={700,200,350,250,350,0,700,450,750,350,200,0,700,750,1000,700,300,0,330,230,1000,350,350,0};
    String player1[]={"0","0","0","0","0","0","0","0"};
    String player2[]={"0","0","0","0","0","0","0","0"};
    String player3[]={"0","0","0","0","0","0","0","0"};
    int turn,flag=0,pos1,pos2,pos3,prop1,prop2,prop3,bal1=25000,bal2=25000,bal3=25000;
    public static void main(String args[])
    {
        Simple obj=new Simple();
        obj.go();
    }
    public void go()
    {
        int i=0;
        JPanel panelD=new JPanel();
        JPanel panelR=new JPanel();
        panelR.setLayout(new BoxLayout(panelR,BoxLayout.Y_AXIS));
        JPanel panelU=new JPanel();
        JPanel panelL=new JPanel();
        panelL.setLayout(new BoxLayout(panelL,BoxLayout.Y_AXIS));
        button[17]=new JButton("Just Like That");
        panelU.add(button[17]);
        button[11]=new JButton("Milk Carton");
        panelR.add(button[11]);
        JFrame frame=new JFrame();
        for(i=0;i<24;i++)
        {
            if(i==5||i==11||i==17||i==23)
                continue;
            else
            {
                button[i]=new JButton("Available\n");
                text[i]=new JTextArea();
                text[i].append(arr[i]+"\n");
                text[i].append(cost[i]+"");
                panel[i]=new JPanel();
                panel[i].setLayout(new BoxLayout(panel[i],BoxLayout.Y_AXIS));
                panel[i].add(button[i]);
                panel[i].add(text[i]);
                if(i<5)
                {
                    panelD.add(panel[i]);
                }
                else if(i>5&&i<11)
                {
                    panelR.add(panel[i]);
                }
                else if(i>11&&i<17)
                {
                    panelU.add(panel[i]);
                }
                else
                {
                    panelL.add(panel[i]);
                }
            }
        }
        button[5]=new JButton("Jail");
        panelD.add(button[5]);
        button[23]=new JButton("Start, Dude");
        panelL.add(button[23]);
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
        mainPanel.add(mButton);
        mainPanel.add(mButton1);
        mainPanel.add(mButton2);
        mainPanel.add(mButton3);
        mainPanel.add(mText);
        mButton.addActionListener(new mListener());
        frame.getContentPane().add(BorderLayout.SOUTH,panelD);
        frame.getContentPane().add(BorderLayout.EAST,panelR);
        frame.getContentPane().add(BorderLayout.NORTH,panelU);
        frame.getContentPane().add(BorderLayout.WEST,panelL);
        frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button[0].addActionListener(new Listener0());
        button[1].addActionListener(new Listener1());
        button[2].addActionListener(new Listener2());
        button[3].addActionListener(new Listener3());
        button[4].addActionListener(new Listener4());
        button[6].addActionListener(new Listener5());
        button[7].addActionListener(new Listener6());
        button[8].addActionListener(new Listener7());
        button[9].addActionListener(new Listener8());
        button[10].addActionListener(new Listener9());
        button[12].addActionListener(new Listener10());
        button[13].addActionListener(new Listener11());
        button[14].addActionListener(new Listener12());
        button[15].addActionListener(new Listener13());
        button[16].addActionListener(new Listener14());
        button[18].addActionListener(new Listener15());
        button[19].addActionListener(new Listener16());
        button[20].addActionListener(new Listener17());
        button[21].addActionListener(new Listener18());
        button[22].addActionListener(new Listener19());
        mButton1.addActionListener(new ListenerDetails1());
        mButton2.addActionListener(new ListenerDetails2());
        mButton3.addActionListener(new ListenerDetails3());
    }
    public int getTurn()
    {
        if(flag%3==1)
            return 1;
        else if(flag%3==2)
            return 2;
        else
            return 3;
    }
    public class ListenerDetails1 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            int i;
            String str="";
            for(i=0;i<8;i++)
                if(player1[i].equals("0")!=true)
                str=str+player1[i]+" ";
            mText.setText("");
            mText.append(str+"\n");
            mText.append(bal1+"");
        }
    }
     public class ListenerDetails2 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            int i;
            String str="";
            for(i=0;i<8;i++)
                if(player2[i].equals("0")!=true)
                str=str+player2[i]+" ";
            mText.setText("");
            mText.append(str+"\n");
            mText.append(bal2+"");
        }
    }
      public class ListenerDetails3 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            int i;
            String str="";
            for(i=0;i<8;i++)
                if(player3[i].equals("0")!=true)
                str=str+player3[i]+" ";
            mText.setText("");
            mText.append(str+"\n");
            mText.append(bal3+"");
        }
    }
    public class mListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            flag++;
            int t;
            if(flag%3==1)
            {
                pos1=(pos1+(int)(Math.random()*6+1))%24;
                if(pos1==11||pos1==17||pos1==23)
                    pos1=pos1+1;
                if(pos1==5)
                {
                    mText.setText("");
                    mText.append("Player 1, you are in jail. You are fined 500 rupees");
                    bal1-=500;
                    return;
                }
                String str;
                str=text[pos1].getText();
                if(str.indexOf("Sold")==-1)
                {
                    mText.setText("");
                    mText.append("Player 1, you are at "+arr[pos1]+". Do you wish to buy? If yes, click on button");
                }
                else
                {
                    t=find(pos1);
                    if(t!=1)
                    {
                        mText.setText("");
                        mText.append("Player 1, you are at "+arr[pos1]+". You are fined");
                        bal1-=l_cost[pos1];
                        if(t==2)
                            bal2+=l_cost[pos1];
                        else
                            bal3+=l_cost[pos1];
                    }
                }
            }
            else if(flag%3==2)
            {
                pos2=(pos2+(int)(Math.random()*6+1))%24;
                if(pos2==11||pos2==17||pos2==23)
                    pos2=pos2+1;
                if(pos2==5)
                {
                    mText.setText("");
                    mText.append("Player 2, you are in jail. You are fined 500 rupees");
                    bal2-=500;
                    return;
                }
                String str;
                str=text[pos2].getText();
                if(str.indexOf("Sold")==-1)
                {
                    mText.setText("");
                    mText.append("Player 2, you are at "+arr[pos2]+". Do you wish to buy? If yes, click on button");
                }
                else
                {
                   t=find(pos2);
                    if(t!=2)
                    {
                        mText.setText("");
                        mText.append("Player 2, you are at "+arr[pos2]+". You are fined");
                        bal2-=l_cost[pos2];
                        if(t==1)
                            bal1+=l_cost[pos2];
                        else
                            bal3+=l_cost[pos2];
                    }
                }
            }
            else
            {
                pos3=(pos3+(int)(Math.random()*6+1))%24;
                if(pos3==11||pos3==17||pos3==23)
                    pos3=pos3+1;
                if(pos3==5)
                {
                    mText.setText("");
                    mText.append("Player 3, you are in jail. You are fined 500 rupees");
                    bal3-=500;
                    return;
                }
                String str;
                str=text[pos3].getText();
                if(str.indexOf("Sold")==-1)
                {
                    mText.setText("");
                    mText.append("Player 3, you are at "+arr[pos3]+". Do you wish to buy? If yes, click on button");
                }
                else
                {
                   t=find(pos3);
                    if(t!=3)
                    {
                        mText.setText("");
                        mText.append("Player 3, you are at "+arr[pos3]+". You are fined");
                        bal3-=l_cost[pos3];
                        if(t==2)
                            bal2+=l_cost[pos3];
                        else
                            bal1+=l_cost[pos3];
                    }
                }
            }
        }
    }
    public int find(int a)
    {
      String str=arr[a];
      int i;
      for(i=0;i<8;i++)
          if(player1[i].equals(str))
              return 1;
          else if(player2[i].equals(str))
              return 2;
          else if(player3[i].equals(str))
              return 3;
            return 0;      
    }
    public int update(int p1,String str,int p2)
    {
        if(p1==1)
        {
            player1[prop1++]=str;
            bal1-=cost[p2];
            if(bal1<0)
            {
                bal1+=cost[p2];
                return 0;
            }
        }
        else if(p1==2)
        {
            player2[prop2++]=str;
            bal2-=cost[p2];
            if(bal2<0)
            {
                bal2+=cost[p2];
                return 0;
            }
        }
        else
        {
            player3[prop3++]=str;
            bal3-=cost[p2];
            if(bal3<0)
            {
                bal3+=cost[p2];
                return 0;
            }
        }
        return 1;
    }
    public class Listener0 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            turn=getTurn();
            int x;
            x=update(turn,arr[0],0);
            if(x==1)
            {
                text[0].setText("");
                text[0].append(arr[0]+"\n"+"Sold to player"+turn);
                button[0].setEnabled(false);
            }
            else
            {
                mText.setText("");
                mText.append("Player"+turn+" , you do not have sufficient money.");
            }       
        }
    }
    public class Listener1 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            turn=getTurn();
                int x;
            x=update(turn,arr[1],1);
            if(x==1)
            {
                text[1].setText("");
                text[1].append(arr[1]+"\n"+"Sold to player"+turn);
                button[1].setEnabled(false);
            }
            else
            {
                mText.setText("");
                mText.append("Player"+turn+" , you do not have sufficient money.");
             }     
        }
    }
    public class Listener2 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            turn=getTurn();
                   int x;
            x=update(turn,arr[2],2);
            if(x==1)
            {
                
                text[2].setText("");
                text[2].append(arr[2]+"\n"+"Sold to player"+turn);
                button[2].setEnabled(false);
            }
            else
            {
                mText.setText("");
                mText.append("Player"+turn+" , you do not have sufficient money.");
             }     
        }
    }
    public class Listener3 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
             turn=getTurn();
                   int x;
            x=update(turn,arr[3],3);
            if(x==1)
            {
               
                text[3].setText("");
                text[3].append(arr[3]+"\n"+"Sold to player"+turn);
                button[3].setEnabled(false);
            }
            else
            {
                mText.setText("");
                mText.append("Player"+turn+" , you do not have sufficient money.");
             }     
        }
    }
    public class Listener4 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            turn=getTurn();
                  int x;
            x=update(turn,arr[4],4);
            if(x==1)
            {
                
                text[4].setText("");
                text[4].append(arr[4]+"\n"+"Sold to player"+turn);
                button[4].setEnabled(false);
            }
            else
            {
                mText.setText("");
                mText.append("Player"+turn+" , you do not have sufficient money.");
             }     
        }
    }
    public class Listener5 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            turn=getTurn();
                   int x;
            x=update(turn,arr[6],6);
            if(x==1)
            {
                
                text[6].setText("");
                text[6].append(arr[6]+"\n"+"Sold to player"+turn);
                button[6].setEnabled(false);
            }
            else
            {
                mText.setText("");
                mText.append("Player"+turn+" , you do not have sufficient money.");
             }     
        }
    }
    public class Listener6 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            turn=getTurn();
                  int x;
            x=update(turn,arr[7],7);
            if(x==1)
            {
                
                text[7].setText("");
                text[7].append(arr[7]+"\n"+"Sold to player"+turn);
                button[7].setEnabled(false);
            }
            else
            {
                mText.setText("");
                mText.append("Player"+turn+" , you do not have sufficient money.");
             }     
            
        }
    }
    public class Listener7 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            turn=getTurn();
                   int x;
            x=update(turn,arr[8],8);
            if(x==1)
            {
                
                text[8].setText("");
                text[8].append(arr[8]+"\n"+"Sold to player"+turn);
                button[8].setEnabled(false);
            }
            else
            {
                mText.setText("");
                mText.append("Player"+turn+" , you do not have sufficient money.");
             }     
        }
    }
    public class Listener8 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            turn=getTurn();
                   int x;
            x=update(turn,arr[9],9);
            if(x==1)
            {
                
                text[9].setText("");
                text[9].append(arr[9]+"\n"+"Sold to player"+turn);
                button[9].setEnabled(false);
            }
            else
            {
                mText.setText("");
                mText.append("Player"+turn+" , you do not have sufficient money.");
             }     
        }
    }
    public class Listener9 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            turn=getTurn();
                   int x;
            x=update(turn,arr[10],10);
            if(x==1)
            {
                
                text[10].setText("");
                text[10].append(arr[10]+"\n"+"Sold to player"+turn);
                button[10].setEnabled(false);
            }
            else
            {
                mText.setText("");
                mText.append("Player"+turn+" , you do not have sufficient money.");
             }     
        }
    }
    public class Listener10 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            turn=getTurn();
                   int x;
            x=update(turn,arr[12],12);
            if(x==1)
            {
                
                text[12].setText("");
                text[12].append(arr[12]+"\n"+"Sold to player"+turn);
                button[12].setEnabled(false);
            }
            else
            {
                mText.setText("");
                mText.append("Player"+turn+" , you do not have sufficient money.");
             }     
        }
    }
    public class Listener11 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            turn=getTurn();
                   int x;
            x=update(turn,arr[13],13);
            if(x==1)
            {
                
                text[13].setText("");
                text[13].append(arr[13]+"\n"+"Sold to player"+turn);
                button[13].setEnabled(false);
            }
            else
            {
                mText.setText("");
                mText.append("Player"+turn+" , you do not have sufficient money.");
             }     
        }
    }
    public class Listener12 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
             turn=getTurn();
                   int x;
            x=update(turn,arr[14],14);
            if(x==1)
            {
               
                text[14].setText("");
                text[14].append(arr[14]+"\n"+"Sold to player"+turn);
                button[14].setEnabled(false);
            }
            else
            {
                mText.setText("");
                mText.append("Player"+turn+" , you do not have sufficient money.");
             }     
        }
    }
    public class Listener13 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            turn=getTurn();
                   int x;
            x=update(turn,arr[15],15);
            if(x==1)
            {
                
                text[15].setText("");
                text[15].append(arr[15]+"\n"+"Sold to player"+turn);
                button[15].setEnabled(false);
            }
            else
            {
                mText.setText("");
                mText.append("Player"+turn+" , you do not have sufficient money.");
             }     
        }
    }
    public class Listener14 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            turn=getTurn();
                  int x;
            x=update(turn,arr[16],16);
            if(x==1)
            {
                
                text[16].setText("");
                text[16].append(arr[16]+"\n"+"Sold to player"+turn);
                button[16].setEnabled(false);
            }
            else
            {
                mText.setText("");
                mText.append("Player"+turn+" , you do not have sufficient money.");
             }     
        }
    }
    public class Listener15 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            turn=getTurn();
                   int x;
            x=update(turn,arr[18],18);
            if(x==1)
            {
                
                text[18].setText("");
                text[18].append(arr[18]+"\n"+"Sold to player"+turn);
                button[18].setEnabled(false);
            }
            else
            {
                mText.setText("");
                mText.append("Player"+turn+" , you do not have sufficient money.");
             }     
        }
    }
    public class Listener16 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            turn=getTurn();
                   int x;
            x=update(turn,arr[19],19);
            if(x==1)
            {
                
                text[19].setText("");
                text[19].append(arr[19]+"\n"+"Sold to player"+turn);
                button[19].setEnabled(false);
            }
            else
            {
                mText.setText("");
                mText.append("Player"+turn+" , you do not have sufficient money.");
             }     
        }
    }
    public class Listener17 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            turn=getTurn();
                   int x;
            x=update(turn,arr[20],20);
            if(x==1)
            {
                
                text[20].setText("");
                text[20].append(arr[20]+"\n"+"Sold to player"+turn);
                button[20].setEnabled(false);
            }
            else
            {
                mText.setText("");
                mText.append("Player"+turn+" , you do not have sufficient money.");
             }     
        }
    }
    public class Listener18 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            turn=getTurn();
                   int x;
            x=update(turn,arr[21],21);
            if(x==1)
            {
                
                text[21].setText("");
                text[21].append(arr[21]+"\n"+"Sold to player"+turn);
                button[21].setEnabled(false);
            }
            else
            {
                mText.setText("");
                mText.append("Player"+turn+" , you do not have sufficient money.");
             }     
        }
    }
    public class Listener19 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            turn=getTurn();
                   int x;
            x=update(turn,arr[22],22);
            if(x==1)
            {
                
                text[22].setText("");
                text[22].append(arr[22]+"\n"+"Sold to player"+turn);
                button[22].setEnabled(false);
            }
            else
            {
                mText.setText("");
                mText.append("Player"+turn+" , you do not have sufficient money.");
             }     
        }
    }
}     