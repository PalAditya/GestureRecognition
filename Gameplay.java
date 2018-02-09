import java.io.*;
class Gameplay
{
    int arr[][];
    Gameplay()
    {
        arr=new int[10][10];
    }
    public void init()
    {
        int i=0,j=0;
        for(i=0;i<10;i++)
        for(j=0;j<10;j++)
        arr[i][j]=0;
    }
    public int createShip(Battleship obj)
    {
        int ind1=0,ind2=0,flag=0;
        while(true)
        {
            ind1=(int)(Math.random()*10);
            ind2=(int)(Math.random()*10);
            if(arr[ind1][ind2]==0)
            {
                break;
            }
        }
        if((ind1+2)<10)
        {
            if(arr[ind1+1][ind2]==0&&arr[ind1+2][ind2]==0)
            flag=1;
        }    
        if((ind1-2)>=0)
        {
            if(arr[ind1-1][ind2]==0&&arr[ind1-2][ind2]==0)
            flag=2;
        }
        else
        flag=0;
        if(flag==1)
        {
            arr[ind1][ind2]=1;
            arr[ind1+1][ind2]=1;
            arr[ind1+2][ind2]=1;
            obj.index[0]=ind1;
            obj.index[1]=ind1+1;
            obj.index[2]=ind1+2;
            obj.col=ind2;
            return 1;
        }
        else if(flag==2)
        {
            arr[ind1][ind2]=1;
            arr[ind1-1][ind2]=1;
            arr[ind1-2][ind2]=1;
            obj.index[0]=ind1;
            obj.index[1]=ind1-1;
            obj.index[2]=ind1-2;
            obj.col=ind2;
            return 1;
        }
        else
        return 0;
    }
    public void main()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int flag=0;
        Gameplay obj=new Gameplay();
        obj.init();
        Battleship obj1=new Battleship();
        Battleship obj2=new Battleship();
        Battleship obj3=new Battleship();
        while(flag!=1)
        flag=createShip(obj1); 
        flag=0;
        while(flag!=1)
        flag=createShip(obj2); 
        flag=0;
        while(flag!=1)
        flag=createShip(obj3); 
        flag=0;
        display();
        Guess(obj1,obj2,obj3);
    }
    public void display()
    {
        int i=0,j=0;
        for(i=0;i<10;i++)
        {
            for(j=0;j<10;j++)
            {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public void Guess(Battleship obj1,Battleship obj2,Battleship obj3)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter guesses");
        int ind1=0,ind2=0,dummy=0;
        while(true)
        {
            ind1=Integer.parseInt(br.readLine());
            ind2=Integer.parseInt(br.readLine());
            if(arr[ind1][ind2]==1)
            {
                System.out.println("Hit!");
                if(obj1.index[0]==ind1&&obj1.col==ind2||obj1.index[1]==ind1&&obj1.col==ind2||obj1.index[2]==ind1&&obj1.col==ind2)
                obj1.hit++;
                else if(obj2.index[0]==ind1&&obj2.col==ind2||obj2.index[1]==ind1&&obj2.col==ind2||obj2.index[2]==ind1&&obj2.col==ind2)
                obj2.hit++;
                else if(obj3.index[0]==ind1&&obj3.col==ind2||obj3.index[1]==ind1&&obj3.col==ind2||obj3.index[2]==ind1&&obj3.col==ind2)
                obj3.hit++;
                else
                dummy++;
                if(obj1.hit==3)
                System.out.println("You have sunk ship 1");
                if(obj2.hit==3)
                System.out.println("You have sunk ship 2");
                if(obj3.hit==3)
                System.out.println("You have sunk ship 3");
                if(obj1.hit==3&&obj2.hit==3&&obj3.hit==3)
                break;
            }
            else
            {
                System.out.println("Miss!");
            }
        }
    }
}