import java.util.*;
public class DFA
{
   class CreateDFA
   {
       int states,alphabet;
       private int row=0;
       private int start=0;
       int arr[][];
       CreateDFA(int n,int t)
       {
           states=n;
           alphabet=t;
           arr=new int[n][t+1];
       }
       void addStartState(int ...a)
       {
           int i=0;
           for(i=0;i<alphabet;i++)
           arr[0][i]=a[i];
           row++;
       }
       void addState(int ...a)
       {
           int i=0;
           for(i=0;i<alphabet;i++)
           arr[row][i]=a[i];
           row++;
       }
       void resetStart(int x)
       {
           start=x;
       }
       void addFinalState(int ...a)//Can accept a transition function to create the final state
       {
           int i=0;
           for(i=0;i<alphabet;i++)
           arr[row][i]=a[i];
           arr[row][i]=1;
           row++;
       }
       void markFinal(int x)//Marks a state as final
       {
           arr[x][alphabet]=1;
       }
       void unMarkFinal(int x)//Unmarks a state from being final
       {
           arr[x][alphabet]=0;
       }
       boolean evaluate(String x)//Evaluates the string
       {
           int i,l=x.length(),move,state;
           state=start;
           for(i=0;i<l;i++)
           {
               move=x.charAt(i)-48;
               state=arr[state][move];
           }
           if(arr[state][alphabet]==1)
                return true;
           else
               return false;
       }
   }
   public static void main(String args[])
   {
       DFA obj=new DFA();
       obj.showHelp();
       obj.go();
   }
   public void showHelp()
   {
       System.out.println("This DFA creator supports a maximum of 10 states. Each state should correspond to a digit between 0-9 and the transition"
               + " function for each state should be defined exactly as the alphabet is, without spaces");
   }
   public void go()
   {
       Scanner sc=new Scanner(System.in);
       int n,t;
       System.out.println("Please enter number of states in the DFA and the number of letters in your alphabet, respectively");
       n=sc.nextInt();
       t=sc.nextInt();
       /*int states[][]=new int[n][t];
       System.out.println("Please assume the states to be indexed as 0,1,2... and enter the transitions correponding to the alphabets in the same order in all"+
       "states");*/
       CreateDFA obj=new CreateDFA(n,t);
       System.out.println("Please enter the transition function for all the states one by one as a string (without any space) and following"+
               " the order such that transition corresponding to first letter of alphabet is entered first and so on. First function should be start state");
       int i,j,l;
       for(i=0;i<n;i++)
       {
           String x=sc.next();
           l=x.length();
           //System.out.println("T L: "+t+","+l);
           if(t!=l)
               continue;
           int a[]=new int[l];
           for(j=0;j<l;j++)
               a[j]=x.charAt(j)-48;
            if(i==0)
                obj.addStartState(a);
            else
                obj.addState(a);
       }
       System.out.println("Please enter list of final states as a single string, without spaces");
       String x=sc.next();
       l=x.length();
       for(i=0;i<l;i++)
           obj.markFinal(x.charAt(i)-48);
       System.out.println("Enter word to evaluate");
       x=sc.next();
       /*obj.addStartState(1,0);
       obj.addState(1,2);
       obj.addFinalState(2,2);*/
       //obj.markFinal(0);
       //String x="001";
       if(obj.evaluate(x))
           System.out.println(x+" is accepted by DFA");
       else
           System.out.println(x+" is rejected by DFA");
   } 
}
