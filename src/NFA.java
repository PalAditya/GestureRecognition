import java.util.*;
public class NFA
{
   private String finalStateList="";
   class CreateNFA
   {
       int states,alphabet;
       private int row=0;
       private int start=0;
       private int stateCount=0;
       
       ArrayList<Integer>[][] arr;
       CreateNFA(int n,int t)
       {
           arr=new ArrayList[n][t+1];
           for(int i=0;i<n;i++)
               for(int j=0;j<t+1;j++)
               {
                   arr[i][j]=new ArrayList<>();
                   //arr[i][j]=null;
               }
           states=n;
           alphabet=t;
           //arr=new int[n][t+1];
       }
       void addStartState(String x)
       {
           //System.out.println("I got "+x);
           String read[]=x.split(" ");
           int i=0,j=0,l;
           for(i=0;i<alphabet;i++)
           {
               l=read[i].length();
               for(j=0;j<l;j++)
                   if(read[i].charAt(j)-48>=states)
                       arr[row][i]=null;
                   else
                    arr[row][i].add(read[i].charAt(j)-48);
           }
           row++;
       }
       void addState(String x)//Adds a state
       {
           String read[]=x.split(" ");
           //System.out.println("I got "+x);
           int i=0,j=0,l;
           for(i=0;i<alphabet;i++)
           {
               l=read[i].length();
               for(j=0;j<l;j++)
                   if(read[i].charAt(j)-48>=states)
                       arr[row][i]=null;
                   else
                    arr[row][i].add(read[i].charAt(j)-48);
           }
           row++;
       }
       void resetStart(int x)
       {
           start=x;
       }
       void addFinalState(String x)
       {
           String read[]=x.split(" ");
           System.out.println("I got "+x);
           int i=0,j=0,l;
           for(i=0;i<alphabet;i++)
           {
               l=read[i].length();
               for(j=0;j<l;j++)
                   if(read[i].charAt(j)-48>=states)
                       arr[row][i]=null;
                   else
                    arr[row][i].add(read[i].charAt(j)-48);
           }
           arr[row][i].add(1);
           row++;
       }
       void markFinal(int x)
       {
           arr[x][alphabet].add(1);
       }
       void unMarkFinal(int x)
       {
           arr[x][alphabet]=null;
       }
       String getSorted(ArrayList<Integer> x)
       {
           Collections.sort(x);
           Iterator itr=x.iterator();
           String s="";
           while(itr.hasNext())
               s+=itr.next();
           return s;
       }
       String getSorted(TreeSet<Integer> x)
       {
           Iterator itr=x.iterator();
           String s="";
           while(itr.hasNext())
               s+=itr.next();
           return s;
       }
       void checkAndPut(ArrayList<String> states,String x)//Checks if a new state and if so, adds it to state list
       {
           int flag=0;
           Iterator itr=states.iterator();
           while(itr.hasNext())
           {
               if(itr.next().equals(x))
               {
                   flag=1;
                   break;
               }
           }
           if(flag==0)
           {
               states.add(x);
               //System.out.println("Put "+x);
           }
       }
       void display(ArrayList<Integer> a[][],int x)//displays the contents
       {
           int i,j;
           for (i=0;i<x;i++)
           {
               for(j=0;j<alphabet;j++)
               {
                   if(a[i][j]!=null)
                        System.out.print(a[i][j]+" ");
                   else
                       System.out.print("NULL ");
               }
               System.out.println();
           }
       }
       int convert(ArrayList<Integer> arr2[][],int labels[][],ArrayList<String> states)//Converts the NFA to DFA for evaluation
       {
           
           int i,j,counted=0,l,state=start,x;
           String umm="";
           states.add("0");//Assumption: 0 is the start state
           while(counted<states.size())
           {
               String toExamine=states.get(counted);
               //System.out.println("Examining "+toExamine);
               l=toExamine.length();
               for(i=0;i<alphabet;i++)
               {
                   TreeSet<Integer> ts=new TreeSet<>();
                   for(j=0;j<l;j++)
                   {
                       x=toExamine.charAt(j)-48;
                       if(arr[x][i]!=null)
                       ts.addAll(arr[x][i]);
                   }
                   umm=getSorted(ts);
                   checkAndPut(states,umm);
                   if(ts.size()>0)
                       arr2[counted][i].addAll(ts);
                   else
                       arr2[counted][i]=null;
                   labels[counted][i]=states.indexOf(umm);//labels array does an internal re-labeling of each state for evaluation
               }
               counted++;
           }
           display(arr2,states.size());
           /*for(i=0;i<states.size();i++)
           {
               for(j=0;j<alphabet;j++)
               {
                   System.out.print(labels[i][j]+" ");
               }
               System.out.println();
           }*/
           return states.size();
       }
       boolean evaluate(String x)
       {
           ArrayList<String> states=new ArrayList<>();
           ArrayList<Integer> arr2[][]=new ArrayList[100][alphabet]; 
           int i,j,state=0,l1,l=x.length(),times,move;
           for(i=0;i<100;i++)
           {
               for(j=0;j<alphabet;j++)
               {
                   arr2[i][j]=new ArrayList<>();
               }
           }
           int labels[][]=new int[100][alphabet];
           times=convert(arr2,labels,states);
           state=0;
           for(i=0;i<l;i++)
           {
               move=x.charAt(i)-48;
               state=labels[state][move];
           }
           String got=states.get(state);
           l=got.length();
           l1=finalStateList.length();
           for(i=0;i<l;i++)
           {
               for(j=0;j<l1;j++)
               {
                   if(got.charAt(i)==finalStateList.charAt(j))
                       return true;
               }
           }
           return false;
       }
       public void show()
       {
           int i,j,n=states,t=alphabet;
           for(i=0;i<n;i++)
            {
                for(j=0;j<t+1;j++)
                {
                    if(arr[i][j]!=null)
                        System.out.print(Arrays.toString(arr[i][j].toArray())+" ");
                    else
                        System.out.print("NULL ");
                }
                System.out.println();
            }
       }
   }
   public static void main(String args[])
   {
       NFA obj=new NFA();
       obj.showHelp();
       obj.go();
   }
   
   public void showHelp()
   {
       System.out.println("This NFA creator supports a maximum of 10 states. Each state should correspond to a digit between 0-9 and the transition"
               + "\nfunction for each state should be defined exactly as the alphabet is, without spaces, which means all the states it can go to on"
               + "\napplying alphabet(0) should be a word then all the states it can go to on applying alphabet(1) should be next and so on.\n"
               + "For example, if it can go to states 0 and 1 on applying 0 and to 1 only on aplying 1 (from 1), the function is 01 1. Next\n"
               + "function should be on next line");
   }
   public void go()
   {
       Scanner sc=new Scanner(System.in);
       int n,t;
       System.out.println("Please enter number of states in the NFA and the number of letters in your alphabet, respectively");
       n=sc.nextInt();
       t=sc.nextInt();
       sc.nextLine();
       CreateNFA obj=new CreateNFA(n,t);
       System.out.println("Please enter the transition function for all the states one by one as a string and add spaces to deliminate end of 1 cycle and following"+
               " the order such that transition corresponding to first letter of alphabet is entered first and so on. First function should be start state");
       int i,j,l;
       for(i=0;i<n;i++)
       {
           String x=sc.nextLine();
            if(i==0)
                obj.addStartState(x);
            else
                obj.addState(x);
       }
       System.out.println("Please enter list of final states as a single string, without spaces");
       String x=sc.next();
       finalStateList=x;
       l=x.length();
       for(i=0;i<l;i++)
           obj.markFinal(x.charAt(i)-48);
       System.out.println("Enter word to evaluate");
       x=sc.next();
       obj.show();
       if(obj.evaluate(x))
           System.out.println(x+" is accepted by NFA");
       else
           System.out.println(x+" is rejected by NFA");
   } 
}
