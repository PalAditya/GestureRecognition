import java.util.*;
import java.math.*;
class somee{
char my,notmy;
int n=3;
public static void print(char [][]board)
{
   // system("cls");
    System.out.print("\n\n"); 
    System.out.println(board[0][0]+""+
                             board[0][1]+""+board[0][2]);
    System.out.print("\t\t\t--------------\n");
    System.out.println(board[1][0]+""
                             +board[1][1]+""+ board[1][2]);
    System.out.print("\t\t\t--------------\n");
    System.out.println(board[2][0]+""+
                             board[2][1]+""+board[2][2]);
  
    return;
}
int check(char [][]board)
{
    if(board[0][0]==board[2][2] && board[2][2]==board[0][2] && board[2][2]==notmy )
    return 1;
    else if(board[0][2]==board[2][2] && board[2][2]==board[2][0] && board[2][0]==notmy )
    return 1;
    else if(board[2][2]==board[2][0] && board[2][0]==board[0][0] && board[0][0]==notmy )
    return 1;
    else if(board[2][0]==board[0][0] && board[0][0]==board[0][2] && board[0][2]==notmy )
    return 1;
    else
    return 0;
}
char whowon(char [][]board)
{
    int flag=0;
    char ch=' ';
    for(int x=0;x<n;x++)
    for(int y=1;y<n;y++)
    {
    if(board[x][y]!=board[x][y-1])
    break;
    if(y==n-1 && board[x][y]!=' ')
    {
      ch=board[x][y];
      flag=1;
    }
    }
    if(flag==1)
    return ch;
    for(int y=0;y<n;y++)
    for(int x=1;x<n;x++)
    {
        if(board[x][y]!=board[x-1][y])
        break;
        if(x==n-1 && board[x][y]!=' ')
        {
            ch=board[x][y];
            flag=1;
        }
    }
    if(flag==1)
    return ch;
    for(int x=1;x<n;x++)
    {
        if(board[x][x]!=board[x-1][x-1])
        break;
        if(x==n-1 && board[x][x]!=' ')
        {
            ch=board[x][x];
            flag=1;
        }
    }
    if(flag==1)
    return ch;
    for(int x=1;x<n;x++)
    {
        if(board[x][(n-1)-x]!=board[x-1][(n-1)-(x-1)])
        break;
        if(x==n-1 && board[x][(n-1)-x]!=' ')
        {
            ch=board[x][(n-1)-x];
            flag=1;
        }
    }
    if(flag==1)
    return ch;
    return ' ';
}
public void findbest(char [][]board,Set<Integer> occupy)
{
    long val[]=new long[n*n];
    int index=-1;
    for(int x=0;x<n*n;x++)
    val[x]=-1000000000;
    Iterator iterator=occupy.iterator();
   // for(set<int>::iterator x=occupy.begin();x!=occupy.end();x++)
    while(iterator.hasNext())
    val[(int)iterator.next()]=0;
    for(int times=0;times<1000;times++)
    {
        char dummy[][]=new char[n][n];
        for(int x=0;x<n;x++)
        for(int y=0;y<n;y++)
        dummy[x][y]=board[x][y];
        Set<Integer> dummyset=occupy;
        int step_1=0,step_2=0,xx_1=0,yy_1=0,xx_2=0,yy_2=0;
        while(!dummyset.isEmpty() && (whowon(dummy)==' '))
        {
            int dxx,dyy;
            int el=(int)(Math.random()*dummyset.size());
            // srand((clock()-timer)*100);
            //int el=rand()%(dummyset.size());
            Iterator x=dummyset.iterator(); 
            int venu=0;
            while(el>0)
         {
            venu=(int)x.next();
            el--;
         }
            dummy[venu/n][venu%n]=my;
           // system.out.println<<"\nentered "<<(*x/n)<<" "<<(*x%n);
           dummyset.remove(venu);
            //dummyset.remove(x);
      
            if(step_1==0)
            {
             xx_1=venu/n;
             yy_1=venu%n;
            }
            if(dummyset.isEmpty()||whowon(dummy)!=' ')
            break;
            //srand((clock()-timer)*100);
            el=(int)(Math.random()*dummyset.size());
            x=dummyset.iterator();
           while(el>0)
         {
            venu=(int)x.next();
            el--;
         }
          dummy[(venu)/n][(venu)%n]=notmy;
          //system.out.println<<"\nentered "<<(*x/n)<<" "<<(*x%n);
          //temp=dummyset.get(x);
          dummyset.remove(venu);
          if(step_2==0)
         {
            xx_2=venu/n;
            xx_2=venu%n;
         }
         step_1++;
         step_2++;
        // check(dummy,val,dummyset);
        }
       /*
        if(check(dummy))
        {
            val[xx_1*n+yy_1]-=INT_MAX;
            val[xx_2*n+yy_2]+=INT_MAX;
        }*/
        if(whowon(dummy)==my && step_1==0)
        val[xx_1*n+yy_1]+=100000000;
        else if(whowon(dummy)==my)
        {
        val[xx_1*n+yy_1]+=1;
        val[xx_2*n+yy_2]-=100;
        }
        if(whowon(dummy)==notmy&& step_2==0)
        {
            
            //val[xx_1*n+yy_1]-=1000;
            val[xx_2*n+yy_2]+=100000000;
            //val[xx_1*n+yy_1]-=100;
            
        }
        else if(whowon(dummy)==notmy)
        {
            val[xx_1*n+yy_1]-=1000;
            val[xx_2*n+yy_2]+=100;
        }
       // system.out.println<<"choose "<<xx_1<<" "<<yy_1<<" value is"<<val[xx_1*n+yy_1]<<"\n";
    }
        long max=-100000000;
        for(int x=0;x<n*n;x++)
        {
            if(max<val[x])
            {
                max=val[x];
                index=x;
            }
        }
        board[index/n][index%n]=my;
        occupy.remove(index);
}
public void playsecond(char [][]board,Set<Integer> occupy)
{
    while(!occupy.isEmpty() && whowon(board)==' ')
    {
        int x,y;
    do
    {
    System.out.println("\nENTER THE VALID POSITIONS ");
    Scanner reader=new Scanner(System.in);
    x=reader.nextInt();
    y=reader.nextInt();
    }while(!occupy.contains(x*n+y));
    board[x][y]=notmy;
    occupy.remove(x*n+y);
    print(board);
    if(occupy.isEmpty()||whowon(board)!=' ' )
    break;
    findbest(board,occupy);
    print(board);
    }
}
public void playfirst(char [][] board,Set<Integer> occupy)
{
    //system.out.println<<"hello";
    while(!occupy.isEmpty() && whowon(board)==' ')
    {
    int x,y;
    findbest(board,occupy);
    print(board);
    if(occupy.isEmpty()||whowon(board)!=' ' )
    break;
   // step_1:
    do{
    System.out.println("\nENTER THE VALID POSITIONS ");
    Scanner reader=new Scanner(System.in);
    x=reader.nextInt();
    //Scanner reader1=new Scanner(System.in);
    y=reader.nextInt();
    }while(!occupy.contains(x*n+y));
    board[x][y]=notmy;
    occupy.remove(x*n+y);
    print(board);
    }
}
}
public class tictactoe extends somee{
    public static void main(String[] args)
    {
    //cin>>n
    tictactoe obj=new tictactoe();
    obj.go();
}
public void go()
{
    char board[][]=new char[n][n];
    for(int x=0;x<n;x++)
    for(int y=0;y<n;y++)
    board[x][y]=' ';
    Set<Integer> occupy=new HashSet<Integer>();
    for(int x=0;x<n*n;x++)
    occupy.add(x);
    System.out.println("Enter character ");
    Scanner reader = new Scanner(System.in);
    //n=reader.nextInt();
    my=(notmy=='x'||notmy=='X')?'o':'x';
    char ans=reader.next().charAt(0);
    System.out.println("Wanna play first ?");
    ans=reader.next().charAt(0);
    if(ans=='y' || ans=='Y')
        playsecond(board,occupy);
    else
        playfirst(board,occupy);
        if(whowon(board)==' ')
        System.out.println("\nITS A TIE");
        else if(whowon(board)==my)
        System.out.println("\nI WON !!!");
        else 
        System.out.println("\nYOU WON!!!");
        System.exit(0);
    }   
}