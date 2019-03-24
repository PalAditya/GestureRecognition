import java.io.*;
import java.util.*;
class QuestionACC
{
    int max=0;
    class TrieNode 
    {
        char content; 
        int isEnd; 
        LinkedList<TrieNode> childList; 
        public TrieNode(char c)
        {
            childList = new LinkedList<TrieNode>();
            isEnd = -1;
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
    public QuestionACC()
    {
        root = new TrieNode(' '); 
    }
    class Node
    {
        int key;
        Node left,right;
        int height;
        int desc;
    }
    int height(Node N)
    {
        if (N == null)
            return 0;
        return N.height;
    }
    int max(int a, int b)
    {
        return (a > b) ? a : b;
    }
    Node newNode(int key)
    {
        Node node=new Node();
        node.key = key;
        node.left = null;
        node.right = null;
        node.height = 1; // initially added at leaf
        node.desc = 0;
        return (node);
    }
    Node rightRotate(Node y)
    {
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
        int val = (T2 != null) ? T2.desc : -1;
        y.desc = y.desc - (x.desc + 1) + (val + 1);
        x.desc = x.desc - (val + 1) + (y.desc + 1);
        return x;
    }
    Node leftRotate(Node x)
    {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
        int val = (T2 != null) ? T2.desc : -1;
        x.desc = x.desc - (y.desc + 1) + (val + 1);
        y.desc = y.desc - (val + 1) + (x.desc + 1);
        return y;
    }
    int getBalance(Node N)
    {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }  
    Node insert(Node node, int key)
    {
        if (node == null)
            return (newNode(key));
     
        if (key < node.key) {
            node.left = insert(node.left, key);
            node.desc++;
        }
     
        else if (key > node.key) {
            node.right = insert(node.right, key);
            node.desc++;
        }
     
        else // Equal keys not allowed
            return node;
        node.height = 1 + max(height(node.left),
                               height(node.right));
        int balance = getBalance(node);
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }
    Node minValueNode(Node node)
    {
        Node current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }
    int countGreater(Node root, int x,int k)
    {
        int res = 0;
        while (root != null) {
            int desc = (root.right != null) ? 
                       root.right.desc : -1;
            if (root.key > x) {
                res = res + desc + 1 + 1;
                root = root.left;
            } else if (root.key < x)
                root = root.right;
            else {
                res = res + desc + 1;
                break;
            }
        }
        return k-res-1;
    }
    Node deleteNode(Node root, int key)
    {
        if (root == null)
            return root;
        if (key < root.key) {
            root.left = deleteNode(root.left, key);
            root.desc = root.desc - 1;
        }
     
        // If the key to be deleted is greater than the
        // root's key, then it lies in right subtree
        else if (key > root.key) {
            root.right = deleteNode(root.right, key);
            root.desc = root.desc - 1;
        }
     
        // if key is same as root's key, then This is
        // the node to be deleted
        else {
            if(root.left==null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else {
                Node temp = minValueNode(root.right);
                root.key = temp.key;
                root.right = deleteNode(root.right, temp.key);
                root.desc = root.desc - 1;
            }
        } 
        if (root == null)
            return root;
     
        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        root.height = 1 + max(height(root.left),
                               height(root.right));
     
        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to
        // check whether this node became unbalanced)
        int balance = getBalance(root);
     
        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);
     
        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
     
        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);
     
        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
     
        return root;
    }
    public void insert(String word,int x)
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
        current.isEnd = x;
    }
    public int search(String word)
    {
        TrieNode current = root;  
        for (char ch : word.toCharArray() )
        {
            if (current.subNode(ch) == null)
                return -1;
            else
                current = current.subNode(ch);
        }      
        return current.isEnd;
    }
    void delete(String word)
    {
        TrieNode current = root;  
        for (char ch : word.toCharArray() )
        current=current.subNode(ch);
        current.isEnd=-1;
    }
    public static void main(String args[])throws IOException
    {
        QuestionACC obj=new QuestionACC();
        obj.go();
    }
    public void go()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        /*FileReader fr = new FileReader("D:/Documents/Stream/input10.txt");
        BufferedReader br=new BufferedReader(fr);
        FileWriter f = new FileWriter("D:/Documents/Stream/output10.txt");
        BufferedWriter br2=new BufferedWriter(f);*/
        int q=Integer.parseInt(br.readLine()),x,k=0;
        Node root=null;
        QuestionACC obj2=new QuestionACC();
        String a="",b="";
        while(q-->0)
        {
            StringTokenizer st=new StringTokenizer(br.readLine());
            a=st.nextToken();
            if(a.charAt(0)=='S')
            {
                b=st.nextToken();
                x=obj2.search(b);
                if(x>-1)
                {
                    root=deleteNode(root,x);
                    k--;
                }
                x=Integer.parseInt(st.nextToken());
                obj2.insert(b,x);
                root=insert(root,x);
                k++;
            }
            else if(a.charAt(0)=='R')
            {
                b=st.nextToken();
                x=obj2.search(b);
                if(x>-1)
                {
                    obj2.delete(b);
                    root=deleteNode(root,x);
                    k--;
                }
            }
            else
            {
                b=st.nextToken();
                x=obj2.search(b);
                if(x==-1)
                    {
                        /*br2.write("-1");
                        br2.newLine();*/
                       System.out.println("-1");
                    }
                else
                {
                    int z=countGreater(root,x,k);
                    /*br2.write(z+"");
                    br2.newLine();*/
                    System.out.println(z);
                }
            }
        }
        //fr.close();
        //f.close();
        //br.close();
        //br2.close();
         
    }
}