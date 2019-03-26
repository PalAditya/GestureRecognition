/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */
public class BTreeVisualization {
    String str="";
    BTreeVisualization(String s)
    {
        str=s;
    }
    public static void main(String args[])
    {
        //BTreeVisualization obj=new BTreeVisualization("https://paladitya.github.io/js-clrs-btree-gh-pages/js-clrs-btree-gh-pages/btree.html?structure={%22keys%22:%20[10,20,30],%20%22children%22:%20[{%22keys%22:%20[1,2]},%20{%22keys%22:%20[11,12]},%20{%22keys%22:%20[21,22]},%20{%22keys%22:%20[31,32]}]%20}&level=2");
        //obj.call();
    }
    public void call()
    {
        try
        {
            System.out.println(str);
            Runtime.getRuntime().exec(new String[]{"cmd", "/c","start chrome https://paladitya.github.io/js-clrs-btree-gh-pages/js-clrs-btree-gh-pages/btree.html?"+str});
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());     
        }
    }
    
}
