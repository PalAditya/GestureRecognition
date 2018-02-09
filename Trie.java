import java.io.*;
import java.util.*;
class Trie
{
    int max=0;
    class TrieNode 
    {
        char content; 
        boolean isEnd; 
        //int count;  
        LinkedList<TrieNode> childList; 
        /* Constructor */
        public TrieNode(char c)
        {
            childList = new LinkedList<TrieNode>();
            isEnd = true;
            content = c;
            //count = 0;
        }  
        public TrieNode subNode(char c)
        {
            if (childList != null)
                for (TrieNode eachChild : childList)
                    if (eachChild.content == c)
                        return eachChild;
            return null;
        }
    }
    private TrieNode root;
     /* Constructor */
    public Trie()
    {
        root = new TrieNode(' '); 
    }
     /* Function to insert word */
    /*public void insert(String word)
    {
        //if (search(word) == true) 
        //   return;        
        TrieNode current = root; 
        for (char ch : word.toCharArray() )
        {
            TrieNode child = current.subNode(ch);
            if (child != null)
                current = child;
            else 
            {
                 current.childList.add(new TrieNode(ch));
                 current = current.subNode(ch);
            }
            //current.count++;
        }
        current.isEnd = true;
    }*/
    public int myInsert(String word)
    {
        //if (search(word) == true) 
        //   return;        
        int p=0;
        TrieNode current = root; 
        //int flag=0;
        for (char ch : word.toCharArray() )
        {
            TrieNode child = current.subNode(ch);
            if (child != null)
                current = child;
            else 
            {
                 //flag=1;
                 p++;
                 current.childList.add(new TrieNode(ch));
                 current = current.subNode(ch);
            }
            //current.count++;
        }
        current.isEnd=true;
        return p;
    }
    /* Function to search for word */
    /*public boolean search(String word)
    {
        TrieNode current = root;  
        for (char ch : word.toCharArray() )
        {
            if (current.subNode(ch) == null)
                return false;
            else
                current = current.subNode(ch);
        }      
        if (current.isEnd == true) 
            return true;
        return false;
    }
    void delete(String word)
    {
        TrieNode current = root;  
        for (char ch : word.toCharArray() )
        current=current.subNode(ch);
        current.isEnd=false;
    }*/
    public int mySearch(String word)
    {
        TrieNode current=root;
        int l=word.length();
        for(int i=0;i<l;i++)
        {
            char ch=word.charAt(i);
            TrieNode next=current.subNode(ch);
            //System.out.println(i);
            if(next==null)
            return -1;
            else
            current=next;
        }
        //recurse(current);
        System.out.println(max);
        max=0;
        return 1;
    }
    /*public void recurse(TrieNode current)
    {
        if(current.childList!=null)
        {
            //System.out.println(current.isEnd);
            max++;
            System.out.println(max);
            //System.out.println(max);
            for(TrieNode eachChild: current.childList)
            recurse(eachChild);
        }
    }*/
    /* Function to remove a word */
    /*public void remove(String word)
    {
        if (search(word) == false)
        {
            System.out.println(word +" does not exist in trie\n");
            return;
        }             
        TrieNode current = root;
        for (char ch : word.toCharArray()) 
        { 
            TrieNode child = current.subNode(ch);
            if (child.count == 1) 
            {
                current.childList.remove(child);
                return;
            } 
            else 
            {
                child.count--;
                current = child;
            }
        }
        current.isEnd = false;
    }*/
    public static void main(String args[])throws IOException
    {
        Trie obj=new Trie();
        obj.go();
    }
    public void go()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n,q,i,p=0,x;
        String str;
        //StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(br.readLine());
        //q=Integer.parseInt(st.nextToken());
        Trie trying=new Trie();
        for(i=0;i<n;i++)
        {
            str=br.readLine();
            p=p+trying.myInsert(str);
        }
        System.out.println(p+1);
        //sc.close();
    }
}    