import java.io.*;
import java.util.*;
class input_creator
{
    long r=(long)Math.pow(10,9);
    long r0=(long)Math.pow(10,9);
    int flag=0;
    public static void main(String args[])throws IOException
    {
        input_creator obj=new input_creator();
        obj.go();
    }
    public void go()throws IOException
    {
        FileWriter f = new FileWriter("C:/users/lenovo/documents/Stream/input10.txt");
        BufferedWriter br=new BufferedWriter(f);
        int i,type,count2=0,count3=0,n=0;
        long gen;
        br.write(5+"");
        br.newLine();
        br.write(5000000+"");
        br.newLine();
        for(i=0;i<5000000;i++)
        {
            type=(int)(Math.random()*3)+1;
            if(type==2&&count2==1)
            {
                if(count3<3&&n>2)
                {
                    type=3;
                    count3++;
                    br.write(3+"");
                    br.newLine();
                    if(n%2==0)
                        n=n-2;
                    else
                        n--;
                }
                else
                {
                    type=1;
                    count3=0;
                    gen=getRandom();
                    br.write("1 ");
                    n++;
                    br.write(gen+"");
                    br.newLine();
                }
                count2=0;
            }
            else if(type==2&&count2==0&&n>0)
            {
                count2++;
                br.write(2+"");
                br.newLine();
            }
            else if(type==3&&n>2)
            {
                type=3;
                count3++;
                br.write(3+"");
                br.newLine();
                if(n%2==0)
                    n=n-2;
                else
                    n--;
            }
            else if(type==3&&n<2)
            {
                type=1;
                count3=0;
                gen=getRandom();
                br.write("1 ");
                n++;
                br.write(gen+"");
                br.newLine();
            }
            else
            {
                gen=getRandom();
                br.write("1 ");
                n++;
                br.write(gen+"");
                br.newLine();
            }
        }
        br.write(500000+"");
        br.newLine();
        count2=0;
        count3=0;
        n=0;
        for(i=0;i<500000;i++)
        {
            type=(int)(Math.random()*3)+1;
            if(type==2&&count2==1)
            {
                if(count3<3&&n>2)
                {
                    type=3;
                    count3++;
                    br.write(3+"");
                    br.newLine();
                    if(n%2==0)
                    n=n-2;
                else
                    n--;
                }
                else
                {
                    type=1;
                    count3=0;
                    gen=getRandom();
                    br.write("1 ");
                    n++;
                    br.write(gen+"");
                    br.newLine();
                }
                count2=0;
            }
            else if(type==2&&count2==0&&n>0)
            {
                count2++;
                br.write(2+"");
                br.newLine();
            }
            else if(type==3&&n>2)
            {
                type=3;
                count3++;
                br.write(3+"");
                br.newLine();
                if(n%2==0)
                    n=n-2;
                else
                    n--;
            }
            else if(type==3&&n<2)
            {
                type=1;
                count3=0;
                gen=getRandom();
                br.write("1 ");
                n++;
                br.write(gen+"");
                br.newLine();
            }
            else
            {
                gen=getRandom();
                br.write("1 ");
                n++;
                br.write(gen+"");
                br.newLine();
            }
        }
        br.write(500000+"");
        br.newLine();
        count2=0;
        count3=0;
        n=0;
        for(i=0;i<500000;i++)
        {
            type=(int)(Math.random()*3)+1;
            if(type==2&&count2==1)
            {
                if(count3<3&&n>2)
                {
                    type=3;
                    count3++;
                    br.write(3+"");
                    br.newLine();
                    if(n%2==0)
                    n=n-2;
                else
                    n--;
                }
                else
                {
                    type=1;
                    count3=0;
                    gen=getRandom();
                    br.write("1 ");
                    n++;
                    br.write(gen+"");
                    br.newLine();
                }
                count2=0;
            }
            else if(type==2&&count2==0&&n>0)
            {
                count2++;
                br.write(2+"");
                br.newLine();
            }
            else if(type==3&&n>2)
            {
                type=3;
                count3++;
                br.write(3+"");
                br.newLine();
                if(n%2==0)
                    n=n-2;
                else
                    n--;
            }
            else if(type==3&&n<2)
            {
                type=1;
                count3=0;
                gen=getRandom();
                br.write("1 ");
                n++;
                br.write(gen+"");
                br.newLine();
            }
            else
            {
                gen=getRandom();
                br.write("1 ");
                n++;
                br.write(gen+"");
                br.newLine();
            }
        }
        br.write(700000+"");
        br.newLine();
        count2=0;
        count3=0;
        n=0;
        for(i=0;i<700000;i++)
        {
            type=(int)(Math.random()*3)+1;
            if(type==2&&count2==1)
            {
                if(count3<3&&n>2)
                {
                    type=3;
                    count3++;
                    br.write(3+"");
                    br.newLine();
                    if(n%2==0)
                    n=n-2;
                else
                    n--;
                }
                else
                {
                    type=1;
                    count3=0;
                    gen=getRandom();
                    br.write("1 ");
                    n++;
                    br.write(gen+"");
                    br.newLine();
                }
                count2=0;
            }
            else if(type==2&&count2==0&&n>0)
            {
                count2++;
                br.write(2+"");
                br.newLine();
                
            }
            else if(type==3&&n>2)
            {
                type=3;
                count3++;
                br.write(3+"");
                br.newLine();
                if(n%2==0)
                    n=n-2;
                else
                    n--;
            }
            else if(type==3&&n<2)
            {
                type=1;
                count3=0;
                gen=getRandom();
                br.write("1 ");
                n++;
                br.write(gen+"");
                br.newLine();
            }
            else
            {
                gen=getRandom();
                br.write("1 ");
                n++;
                br.write(gen+"");
                br.newLine();
            }
        }
        br.write(800000+"");
        br.newLine();
        count2=0;
        count3=0;
        n=0;
        for(i=0;i<800000;i++)
        {
            type=(int)(Math.random()*3)+1;
            if(type==2&&count2==1)
            {
                if(count3<3&&n>2)
                {
                    type=3;
                    count3++;
                    br.write(3+"");
                    br.newLine();
                    if(n%2==0)
                    n=n-2;
                else
                    n--;
                }
                else
                {
                    type=1;
                    count3=0;
                    gen=getRandom();
                    br.write("1 ");
                    n++;
                    br.write(gen+"");
                    br.newLine();
                }
                count2=0;
            }
            else if(type==2&&count2==0&&n>0)
            {
                count2++;
                br.write(2+"");
                br.newLine();
            }
            else if(type==3&&n>2)
            {
                type=3;
                count3++;
                br.write(3+"");
                br.newLine();
                if(n%2==0)
                    n=n-2;
                else
                    n--;
            }
            else if(type==3&&n<2)
            {
                type=1;
                count3=0;
                gen=getRandom();
                br.write("1 ");
                n++;
                br.write(gen+"");
                br.newLine();
            }
            else
            {
                gen=getRandom();
                br.write("1 ");
                n++;
                br.write(gen+"");
                br.newLine();
            }
        }
        br.close();
    }
    public long getRandom()
    {
        /*long gen1,gen2;
        gen1=(long)(Math.random()*-r);
        gen2=(long)(Math.random()*-r);
        return gen1+gen2;*/
        flag++;
        if(flag%2==0)
            return --r;
        else
            return ++r0;
    }
}