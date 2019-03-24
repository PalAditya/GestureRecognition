import java.util.*;
public class NFAExtension
{
   private String finalStateList="";
   class CreateNFAExtension
   {
       int states,alphabet;
       private int row=0;
       private int start=0;
       private int stateCount=0;
       
       ArrayList<Integer>[][] arr;
       CreateNFAExtension(int n,int t)
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
               String read2[]=read[i].split(",");
               l=read2.length;
               for(j=0;j<l;j++)
                   if(Integer.parseInt(read2[j])>=states)
                       arr[row][i]=null;
                   else
                    arr[row][i].add(Integer.parseInt(read2[j]));
           }
           row++;
       }
       void addState(String x)
       {
           String read[]=x.split(" ");
           //System.out.println("I got "+x);
           int i=0,j=0,l;
           for(i=0;i<alphabet;i++)
           {
               String read2[]=read[i].split(",");
               l=read2.length;
               for(j=0;j<l;j++)
                   if(Integer.parseInt(read2[j])>=states)
                       arr[row][i]=null;
                   else
                    arr[row][i].add(Integer.parseInt(read2[j]));
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
           //System.out.println("I got "+x);
           int i=0,j=0,l;
           for(i=0;i<alphabet;i++)
           {
               String read2[]=read[i].split(",");
               l=read2.length;
               for(j=0;j<l;j++)
                   if(Integer.parseInt(read2[j])>=states)
                       arr[row][i]=null;
                   else
                    arr[row][i].add(Integer.parseInt(read2[j]));
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
               s+=itr.next()+",";
           if(s.length()>=1)
               return s.substring(0,s.length()-1);
           else
               return s;
       }
       String getSorted(TreeSet<Integer> x)
       {
           Iterator itr=x.iterator();
           String s="";
           while(itr.hasNext())
               s+=itr.next()+",";
           if(s.length()>=1)
               return s.substring(0,s.length()-1);
           else
               return s;
       }
       void checkAndPut(ArrayList<String> states,String x)
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
       void display(ArrayList<Integer> a[][],int x)
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
       int convert(ArrayList<Integer> arr2[][],int labels[][],ArrayList<String> states,ArrayList<Integer> eps[])
       {
           
           int i,j,counted=0,l,state=start,x;
           String umm="";
           /*ArrayList<Integer> arr2[][]=new ArrayList[100][alphabet]; 
           int i,j,counted=0,l,state=start,x;
           
           for(i=0;i<100;i++)
           {
               for(j=0;j<alphabet;j++)
               {
                   arr2[i][j]=new ArrayList<>();
               }
           }*/
           //arr2[0][0]=arr[0][0];
           //states.add(getSorted(arr[0][0]));
           TreeSet<Integer> temp=new TreeSet<>();
           temp.add(0);
           temp.addAll(eps[0]);
           Iterator itr=temp.iterator();
           while(itr.hasNext())
               umm+=itr.next()+",";
           umm=umm.substring(0,umm.length()-1);
           temp=null;
           //System.out.println("Initial state is: "+umm);
           states.add(umm);
           while(counted<states.size())
           {
               String toExamine=states.get(counted);
               //System.out.println("Examining "+toExamine);
               String use[]=toExamine.split(",");
               l=use.length;              
               for(i=0;i<alphabet;i++)
               {
                   TreeSet<Integer> ts=new TreeSet<>();
                   for(j=0;j<l;j++)
                   {
                       if(use[j].length()==0)
                           continue;
                       x=Integer.parseInt(use[j]);
                       if(arr[x][i]!=null)
                       ts.addAll(arr[x][i]);
                   }
                   umm=getSorted(ts);
                   checkAndPut(states,umm);
                   if(ts.size()>0)
                       arr2[counted][i].addAll(ts);
                   else
                       arr2[counted][i]=null;
                   labels[counted][i]=states.indexOf(umm);
               }
               counted++;
           }
           System.out.println("So statecount is: "+states.size());
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
       private void modify(ArrayList<Integer> eps[])
       {
            int i,j;
            for(i=0;i<states;i++)
            {
                TreeSet<Integer> oneMore=new TreeSet<>();
                for(j=0;j<alphabet;j++)
                {
                    if(arr[i][j]!=null)
                    {
                        //System.out.println("The i,j combination is ("+i+","+j+")");
                        oneMore.addAll(arr[i][j]);
                        Iterator itr=arr[i][j].iterator();
                        while(itr.hasNext())
                        {
                            int x=(int)itr.next();
                            //System.out.println("We'll add "+Arrays.toString(eps[x].toArray()));
                            oneMore.addAll(eps[x]);
                        }
                        arr[i][j].clear();
                        arr[i][j].addAll(oneMore);
                    }
                }
                
            }
            show();
       }
       boolean evaluate(String x,ArrayList<Integer> eps[],int flag)
       {
           if(flag==1)
           modify(eps);
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
           times=convert(arr2,labels,states,eps);
           state=0;
           String xx[]=x.split(",");
           l=xx.length;
           for(i=0;i<l;i++)
           {
               move=Integer.parseInt(xx[i]);
               state=labels[state][move];
           }
           String got=states.get(state);
           //System.out.println(got);
           String examine1[]=got.split(",");
           String examine2[]=finalStateList.split(",");
           l1=examine2.length;
           l=examine1.length;
           for(i=0;i<l;i++)
           {
               for(j=0;j<l1;j++)
               {
                   if(examine1[i].equals(examine2[j]))
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
   class EPSClosure//Uses DFS to compute epsilon closure of all states
   {
        private int V;
        private LinkedList<Integer> adj[];
        EPSClosure(int v)
        {
            V = v;
            adj = new LinkedList[v];
            for (int i=0; i<v; ++i)
                adj[i] = new LinkedList();
        }
        void addEdge(int v, int w)
        {
            adj[v].add(w);  // Add w to v's list.
        }
        void DFSUtil(int v,boolean visited[],ArrayList<Integer> a)
        {
            visited[v] = true;
            a.add(v);
            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                    DFSUtil(n, visited,a);
            }
        }
        void DFS(int v,ArrayList<Integer> r)
        {
            boolean visited[] = new boolean[V];
            DFSUtil(v, visited,r);
            //System.out.println(Arrays.toString(r.toArray()));
        }
   }
   public static void main(String args[])
   {
       NFAExtension obj=new NFAExtension();
       obj.showHelp();
       obj.go();
   }
   public void showHelp()
   {
       System.out.println("This NFA creator supports as many states as desired (subject to memory constraints :)) and epsilon transitions."
               + "\nTransition function for each state should be defined exactly as the alphabet is, with commas separating states it can go to on applying"
               + "\n the individual alphabet. For example, the states it can go to on"
               + "\napplying alphabet(0) should be a comma-separated word then all the states it can go to on applying alphabet(1) should be next and so on.\n"
               + "If it can go to states 0 and 1 on applying 0 and to 1 only on aplying 1 (from 1), the function is 0,1 1. Next\n"
               + "function should be on next line");
   }
   public void go()
   {
       Scanner sc=new Scanner(System.in);
       int n,t,flag=0;
       System.out.println("Please enter number of states in the NFAExtension and the number of letters in your alphabet, respectively");
       n=sc.nextInt();
       t=sc.nextInt();
       sc.nextLine();
       CreateNFAExtension obj=new CreateNFAExtension(n,t);
       System.out.println("Please enter the transition function for all the states one by one as a string (comma separated) and add spaces to deliminate end of 1 cycle and following"+
               " the order such that transition corresponding to first letter of alphabet is entered first and so on. First function should be start state");
       int i,j,l,m,a,b;
       for(i=0;i<n;i++)
       {
           String x=sc.nextLine();
            if(i==0)
                obj.addStartState(x);
            else
                obj.addState(x);
       }
       EPSClosure ep=new EPSClosure(n);
       System.out.println("We will now handle epsilon transitions for each state. Please enter the total number of such transitions and"+
               " then enter them one by one. Enter 0 to create NFA without epsilon transition");
       m=sc.nextInt();
       if(m>0)
           flag=1;
       while(m-->0)
       {
           a=sc.nextInt();
           b=sc.nextInt();
           ep.addEdge(a, b);
       }
       ArrayList<Integer> eps[]=new ArrayList[n];
       for(i=0;i<n;i++)
           eps[i]=new ArrayList<>();
       for(i=0;i<n;i++)
           ep.DFS(i,eps[i]);
       System.out.println("Please enter list of final states as a single string, with commas (like 0,1,2)");
       String x=sc.next();
       finalStateList=x;
       String xx[]=x.split(",");
       l=xx.length;
       for(i=0;i<l;i++)
           obj.markFinal(Integer.parseInt(xx[i]));
       System.out.println("Enter word to evaluate (Comma-separated)");
       x=sc.next();
       obj.show();
       if(obj.evaluate(x,eps,flag))
           System.out.println(x+" is accepted by NFA");
       else
           System.out.println(x+" is rejected by NFA");
   } 
}

