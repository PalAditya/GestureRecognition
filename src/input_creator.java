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
        FileWriter f = new FileWriter("D:/Documents/Stream/input10.txt");
        BufferedWriter br=new BufferedWriter(f);
        String arr[]={"chemistry","signals","systems","love","magic","defence","darkarts","pds","algorithms","nlp","herbology",
                "textingcrush","watchstarwars","havefun","potions","photography","transfiguration","flyinglessons","arithmancy","cps","ie","dec",
        "textingcrushagain","stalkingpeople","sleep","trynottogrin","physics","english","magicalcreatures","charms","shippingharmony","estm","biology",
        "geometry","uff","linearalgebra","beinguseless","divination","energyblast","mugglestudies","matlab","differentiation","astronomy",
        "fencing","lotsoffencing","historyofmagic","chemistry","signals","systems","love","magic","defence","darkarts","pds","algorithms","nlp","herbology",
                "textingcrush","watchstarwars","havefun","potions","photography","transfiguration","flyinglessons","arithmancy","cps","ie","dec",
        "textingcrushagain","stalkingpeople","sleep","trynottogrin","physics","english","magicalcreatures","charms","shippingharmony","estm","biology",
        "geometry","uff","linearalgebra","beinguseless","divination","energyblast","mugglestudies","matlab","differentiation","astronomy",
        "fencing","lotsoffencing","historyofmagic","chemistry","signals","systems","love","magic","defence","darkarts","pds","algorithms","nlp","herbology",
                "textingcrush","watchstarwars","havefun","potions","photography","transfiguration","flyinglessons","arithmancy","cps","ie","dec",
        "textingcrushagain","stalkingpeople","sleep","trynottogrin","physics","english","magicalcreatures","charms","shippingharmony","estm","biology",
        "geometry","uff","linearalgebra","beinguseless","divination","energyblast","mugglestudies","matlab","differentiation","astronomy",
        "fencing","lotsoffencing","historyofmagic","chemistry","signals","systems","love","magic","defence","darkarts","pds","algorithms","nlp","herbology",
                "textingcrush","watchstarwars","havefun","potions","photography","transfiguration","flyinglessons","arithmancy","cps","ie","dec",
        "textingcrushagain","stalkingpeople","sleep","trynottogrin","physics","english","magicalcreatures","charms","shippingharmony","estm","biology",
        "geometry","uff","linearalgebra","beinguseless","divination","energyblast","mugglestudies","matlab","differentiation","astronomy",
        "fencing","lotsoffencing","historyofmagic","chemistry","signals","systems","love","magic","defence","darkarts","pds","algorithms","nlp","herbology",
                "textingcrush","watchstarwars","havefun","potions","photography","transfiguration","flyinglessons","arithmancy","cps","ie","dec",
        "textingcrushagain","stalkingpeople","sleep","trynottogrin","physics","english","magicalcreatures","charms","shippingharmony","estm","biology",
        "geometry","uff","linearalgebra","beinguseless","divination","energyblast","mugglestudies","matlab","differentiation","astronomy",
        "fencing","lotsoffencing","historyofmagic","chemistry","signals","systems","love","magic","defence","darkarts","pds","algorithms","nlp","herbology",
                "textingcrush","watchstarwars","havefun","potions","photography","transfiguration","flyinglessons","arithmancy","cps","ie","dec",
        "textingcrushagain","stalkingpeople","sleep","trynottogrin","physics","english","magicalcreatures","charms","shippingharmony","estm","biology",
        "geometry","uff","linearalgebra","beinguseless","divination","energyblast","mugglestudies","matlab","differentiation","astronomy",
        "fencing","lotsoffencing","historyofmagic"};
        int i,type,count2=0,count3=0,n=0,l=arr.length;
        int gen=0,gen2,k1=1;
        br.write(100000+"");
        br.newLine();   
        TreeSet<Integer> ts=new TreeSet();
        for(i=0;i<99999;i++)
        {
            type=(int)(Math.random()*3)+1;
            if(type==2)
            {
                while(true)
                {
                    gen=(int)(Math.random()*1000000000)+1;
                    if(ts.add(gen))
                        break;          
                }
                gen2=(int)(Math.random()*l);
                br.write("Set "+arr[gen2]+" "+gen);
                br.newLine();
                k1++;
                n++;
            }
            else if(type==1&&n==0)
                if(k1%8==0)
                    type=2;
                else
                    type=3;
            if(type==1)
            {
                gen2=(int)(Math.random()*l);
                br.write("Remove "+arr[gen2]);
                br.newLine();
                n--;
            }
            else
            {
                gen2=(int)(Math.random()*l);
                br.write("Query "+arr[gen2]);
                br.newLine();
                k1++;
            }
        }
         gen2=(int)(Math.random()*l);
         br.write("Query "+arr[gen2]);
         br.newLine();
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