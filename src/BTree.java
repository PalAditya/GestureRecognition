/**
 *
 * @author Lenovo
 */
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BTree
{

    ArrayList<String> getLevel(ArrayList<Pair> al,int k,boolean createChild)
        {
            Iterator iterator=al.iterator();
            ArrayList<String> st=new ArrayList<>();
            String keysk="{\"keys\":[";
            while(iterator.hasNext())
            {
                Pair x=(Pair)iterator.next();
                if(x.level!=k)
                    continue;
                //System.out.println("Val: "+x.val+",Delim: "+x.delim);
                if(x.delim!=1)
                    keysk=keysk+"\""+x.val+"\",";
                else
                {
                    keysk=keysk+"\""+x.val+"\"]}";
                    if(createChild)
                        keysk+=",\"children\":[]}";
                    st.add(keysk);
                    //System.out.println(keysk);
                    keysk="{\"keys\":[";
                }
            }
            return st;
        }
    class BTreeNode 
    { 
        int keys[];  // An array of keys 
        int t;      // Minimum degree (defines the range for number of keys) 
        BTreeNode C[]; // An array of child pointers 
        int n;     // Current number of keys 
        boolean leaf;
        String json;
        // Constructor for BTreeNode class 
        BTreeNode(int t1, boolean leaf1) 
        { 
            // Copy the given minimum degree and leaf property 
            t = t1; 
            leaf = leaf1; 
            // Allocate memory for maximum number of possible keys 
            // and child pointers 
            keys = new int[2*t-1]; 
            C = new BTreeNode[2*t]; 
            n = 0; 
            json="{";
        } 
        
        void traverse() //preorder
        { 
            // There are n keys and n+1 children, travers through n keys 
            // and first n children 
            int i; 
            System.out.println("My n is: "+n);
            for (i = 0; i < n; i++) 
            { 
                // If this is not leaf, then before printing key[i], 
                // traverse the subtree rooted with child C[i]. 
                if (!leaf) 
                    C[i].traverse(); 
                //System.out.print(keys[i]+" ");
            } 
            // Print the subtree rooted with last child 
            if (!leaf) 
                C[i].traverse(); 
        }
        void jsonify()
        {
            int i;
            json+="\"keys\":{[";
            for(i=0;i<n-1;i++)
            {
                System.out.print("\""+keys[i]+"\",");
            }
            System.out.print("\""+keys[i]+"\"],\"children\":[");
        }
        BTreeNode search(int k) 
        { 
            // Find the first key greater than or equal to k 
            int i = 0; 
            while (i < n && k > keys[i]) 
                i++; 
            // If the found key is equal to k, return this node 
            if (keys[i] == k) 
                return this; 
            // If key is not found here and this is a leaf node 
            if (leaf) 
                return null; 
            return C[i].search(k); 
        } 
        void insert(int k) 
        { 
            // If tree is empty 
            if (root == null) 
            { 
                // Allocate memory for root 
                root = new BTreeNode(t, true); 
                root.keys[0] = k;  // Insert key 
                root.n = 1;  // Update number of keys in root 
            } 
            else // If tree is not empty 
            { 
                if (root.n == 2*t-1) 
                { 
                    // Allocate memory for new root 
                    BTreeNode s = new BTreeNode(t, false); 

                    // Make old root as child of new root 
                    s.C[0] = root; 
                    // Split the old root and move 1 key to the new root 
                    s.splitChild(0, root); 

                    // New root has two children now.  Decide which of the 
                    // two children is going to have new key 
                    int i = 0; 
                    if (s.keys[0] < k) 
                        i++; 
                    s.C[i].insertNonFull(k);  
                    root = s; 
                } 
                else  // If root is not full, call insertNonFull for root 
                    root.insertNonFull(k); 
            } 
        }
        void insertNonFull(int k) 
        { 
            // Initialize index as index of rightmost element 
            int i = n-1; 
            if (leaf) 
            { 
                // The following loop does two things 
                // a) Finds the location of new key to be inserted 
                // b) Moves all greater keys to one place ahead 
                while (i >= 0 && keys[i] > k) 
                { 
                    keys[i+1] = keys[i]; 
                    i--; 
                } 

                // Insert the new key at found location 
                keys[i+1] = k; 
                n = n+1; 
            } 
            else // If this node is not leaf 
            { 
                // Find the child which is going to have the new key 
                while (i >= 0 && keys[i] > k) 
                    i--; 

                // See if the found child is full 
                if (C[i+1].n == 2*t-1) 
                { 
                    // If the child is full, then split it 
                    splitChild(i+1, C[i+1]); 

                    // After split, the middle key of C[i] goes up and 
                    // C[i] is splitted into two.  See which of the two 
                    // is going to have the new key 
                    if (keys[i+1] < k) 
                        i++; 
                } 
                C[i+1].insertNonFull(k); 
            } 
        } 
        void splitChild(int i, BTreeNode y) 
        { 
            BTreeNode z = new BTreeNode(y.t, y.leaf); 
            z.n = t - 1; 

            // Copy the last (t-1) keys of y to z 
            for (int j = 0; j < t-1; j++) 
                z.keys[j] = y.keys[j+t]; 

            // Copy the last t children of y to z 
            if (y.leaf == false) 
            { 
                for (int j = 0; j < t; j++) 
                    z.C[j] = y.C[j+t]; 
            } 

            // Reduce the number of keys in y 
            y.n = t - 1; 

            // Since this node is going to have a new child, 
            // create space of new child 
            for (int j = n; j >= i+1; j--) 
                C[j+1] = C[j]; 

            // Link the new child to this node 
            C[i+1] = z; 

            // A key of y will move to this node. Find location of 
            // new key and move all greater keys one space ahead 
            for (int j = n-1; j >= i; j--) 
                keys[j+1] = keys[j]; 

            // Copy the middle key of y to this node 
            keys[i] = y.keys[t-1]; 

            // Increment count of keys in this node 
            n = n + 1; 
        } 
        int findKey(int k) 
        { 
            int idx=0; 
            while (idx<n && keys[idx] < k) 
                ++idx; 
            return idx; 
        } 
        void remove(int k) 
        { 
            int idx = findKey(k); 
            if (idx < n && keys[idx] == k) 
            { 
                // If the node is a leaf node - removeFromLeaf is called 
                // Otherwise, removeFromNonLeaf function is called 
                if (leaf) 
                    removeFromLeaf(idx); 
                else
                    removeFromNonLeaf(idx); 
            } 
            else
            { 

                // If this node is a leaf node, then the key is not present in tree 
                if (leaf) 
                { 
                    System.out.println("The key "+k+" is does not exist in the tree"); 
                    return; 
                } 
                // The key to be removed is present in the sub-tree rooted with this node 
                // The flag indicates whether the key is present in the sub-tree rooted 
                // with the last child of this node 
                boolean flag = ( (idx==n)? true : false ); 
                // If the child where the key is supposed to exist has less that t keys, 
                // we fill that child 
                if (C[idx].n < t) 
                    fill(idx); 

                // If the last child has been merged, it must have merged with the previous 
                // child and so we recurse on the (idx-1)th child. Else, we recurse on the 
                // (idx)th child which now has atleast t keys 
                if (flag && idx > n) 
                    C[idx-1].remove(k); 
                else
                    C[idx].remove(k); 
            } 
        } 
        void removeFromLeaf (int idx) 
        { 

            // Move all the keys after the idx-th pos one place backward 
            for (int i=idx+1; i<n; ++i) 
                keys[i-1] = keys[i]; 

            // Reduce the count of keys 
            n--; 
        } 
        void removeFromNonLeaf(int idx) 
        { 

            int k = keys[idx]; 

            // If the child that precedes k (C[idx]) has atleast t keys, 
            // find the predecessor 'pred' of k in the subtree rooted at 
            // C[idx]. Replace k by pred. Recursively delete pred 
            // in C[idx] 
            if (C[idx].n >= t) 
            { 
                int pred = getPred(idx); 
                keys[idx] = pred; 
                C[idx].remove(pred); 
            } 

            // If the child C[idx] has less that t keys, examine C[idx+1]. 
            // If C[idx+1] has atleast t keys, find the successor 'succ' of k in 
            // the subtree rooted at C[idx+1] 
            // Replace k by succ 
            // Recursively delete succ in C[idx+1] 
            else if  (C[idx+1].n >= t) 
            { 
                int succ = getSucc(idx); 
                keys[idx] = succ; 
                C[idx+1].remove(succ); 
            } 

            // If both C[idx] and C[idx+1] has less that t keys,merge k and all of C[idx+1] 
            // into C[idx] 
            // Now C[idx] contains 2t-1 keys 
            // Free C[idx+1] and recursively delete k from C[idx] 
            else
            { 
                merge(idx); 
                C[idx].remove(k); 
            } 
        } 
        int getPred(int idx) 
        { 
            // Keep moving to the right most node until we reach a leaf 
            BTreeNode cur=C[idx]; 
            while (!cur.leaf) 
                cur = cur.C[cur.n]; 

            // Return the last key of the leaf 
            return cur.keys[cur.n-1]; 
        } 
        int getSucc(int idx) 
        { 

            // Keep moving the left most node starting from C[idx+1] until we reach a leaf 
            BTreeNode cur = C[idx+1]; 
            while (!cur.leaf) 
                cur = cur.C[0]; 
            // Return the first key of the leaf 
            return cur.keys[0]; 
        } 
        void fill(int idx) 
        { 

            // If the previous child(C[idx-1]) has more than t-1 keys, borrow a key 
            // from that child 
            if (idx!=0 && C[idx-1].n>=t) 
                borrowFromPrev(idx); 

            // If the next child(C[idx+1]) has more than t-1 keys, borrow a key 
            // from that child 
            else if (idx!=n && C[idx+1].n>=t) 
                borrowFromNext(idx); 

            // Merge C[idx] with its sibling 
            // If C[idx] is the last child, merge it with with its previous sibling 
            // Otherwise merge it with its next sibling 
            else
            { 
                if (idx != n) 
                    merge(idx); 
                else
                    merge(idx-1); 
            } 
        }
        void borrowFromPrev(int idx) 
        { 

            BTreeNode child=C[idx]; 
            BTreeNode sibling=C[idx-1]; 

            // The last key from C[idx-1] goes up to the parent and key[idx-1] 
            // from parent is inserted as the first key in C[idx]. Thus, the  loses 
            // sibling one key and child gains one key 

            // Moving all key in C[idx] one step ahead 
            for (int i=child.n-1; i>=0; --i) 
                child.keys[i+1] = child.keys[i]; 

            // If C[idx] is not a leaf, move all its child pointers one step ahead 
            if (!child.leaf) 
            { 
                for(int i=child.n; i>=0; --i) 
                    child.C[i+1] = child.C[i]; 
            } 

            // Setting child's first key equal to keys[idx-1] from the current node 
            child.keys[0] = keys[idx-1]; 

            // Moving sibling's last child as C[idx]'s first child 
            if(!child.leaf) 
                child.C[0] = sibling.C[sibling.n]; 

            // Moving the key from the sibling to the parent 
            // This reduces the number of keys in the sibling 
            keys[idx-1] = sibling.keys[sibling.n-1]; 

            child.n += 1; 
            sibling.n -= 1;  
        } 

        // A function to borrow a key from the C[idx+1] and place 
        // it in C[idx] 
        void borrowFromNext(int idx) 
        { 

            BTreeNode child=C[idx]; 
            BTreeNode sibling=C[idx+1]; 

            // keys[idx] is inserted as the last key in C[idx] 
            child.keys[(child.n)] = keys[idx]; 

            // Sibling's first child is inserted as the last child 
            // into C[idx] 
            if (!(child.leaf)) 
                child.C[(child.n)+1] = sibling.C[0]; 

            //The first key from sibling is inserted into keys[idx] 
            keys[idx] = sibling.keys[0]; 

            // Moving all keys in sibling one step behind 
            for (int i=1; i<sibling.n; ++i) 
                sibling.keys[i-1] = sibling.keys[i]; 

            // Moving the child pointers one step behind 
            if (!sibling.leaf) 
            { 
                for(int i=1; i<=sibling.n; ++i) 
                    sibling.C[i-1] = sibling.C[i]; 
            } 

            // Increasing and decreasing the key count of C[idx] and C[idx+1] 
            // respectively 
            child.n += 1; 
            sibling.n -= 1; 
        } 

        // A function to merge C[idx] with C[idx+1] 
        // C[idx+1] is freed after merging 
        void merge(int idx) 
        { 
            BTreeNode child = C[idx]; 
            BTreeNode sibling = C[idx+1]; 

            // Pulling a key from the current node and inserting it into (t-1)th 
            // position of C[idx] 
            child.keys[t-1] = keys[idx]; 

            // Copying the keys from C[idx+1] to C[idx] at the end 
            for (int i=0; i<sibling.n; ++i) 
                child.keys[i+t] = sibling.keys[i]; 

            // Copying the child pointers from C[idx+1] to C[idx] 
            if (!child.leaf) 
            { 
                for(int i=0; i<=sibling.n; ++i) 
                    child.C[i+t] = sibling.C[i]; 
            } 

            // Moving all keys after idx in the current node one step before - 
            // to fill the gap created by moving keys[idx] to C[idx] 
            for (int i=idx+1; i<n; ++i) 
                keys[i-1] = keys[i]; 

            // Moving the child pointers after (idx+1) in the current node one 
            // step before 
            for (int i=idx+2; i<=n; ++i) 
                C[i-1] = C[i]; 

            // Updating the key count of child and the current node 
            child.n += sibling.n+1; 
            n--; 

            // Freeing the memory occupied by sibling 
            sibling=null; 
        } 
    }
    BTreeNode root;
    int t;
    BTree(int x)
    {
        root=null;
        t=x;
    }
    class Pair
    {
        int level;
        BTreeNode node;
        int val=0;
        int delim=0;
        Pair(BTreeNode a,int b)
        {
            node=a;
            level=b;
        }
        Pair(int a,int b)
        {
            val=a;
            level=b;
        }
        Pair(int a,int b,int c)
        {
            val=a;
            level=b;
            delim=c;
        }
    }
    void levelOrder() throws UnsupportedEncodingException
    {
        int i;
        ArrayList<Pair> al=new ArrayList<>();
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        int mlevel=0;
        while(!q.isEmpty())
        {
            Pair x=(Pair)q.poll();
            for(i=0;i<x.node.n;i++)
            {
                //System.out.print("("+x.node.keys[i]+","+x.level+") ");
                if(i!=x.node.n-1)
                    al.add(new Pair(x.node.keys[i],x.level));
                else
                    al.add(new Pair(x.node.keys[i],x.level,1));
                if(!x.node.leaf)
                {
                    q.add(new Pair(x.node.C[i],x.level+1));
                    mlevel=Math.max(mlevel,x.level+1);
                }
            }
            if(!x.node.leaf)
            {
                q.add(new Pair(x.node.C[i],x.level+1));
                mlevel=Math.max(mlevel,x.level+1);
            }       
        }
        //System.out.print("\n"+mlevel);
        ArrayList<String> x=getLevel(al,mlevel,false);
        int j,l,k,done=0;
        for(i=mlevel-1;i>=0;i--)
        {
            done=0;
            ArrayList<String> vals=getLevel(al,i,true);
            //System.out.println(Arrays.toString(vals.toArray()));
            l=vals.size();
            ArrayList<String> temp=new ArrayList<>();
            for(j=0;j<l;j++)
            {
                String y=vals.get(j);
                y=y.substring(9,y.indexOf("]"));
                //System.out.println(y);
                y=y.replace("\"","");
                y=y.replace("\"", "");
                //System.out.println("Y: "+y);
                String r[]=y.split(",");
                String s="";
                //System.out.println("DEBUG:"+x.size()+","+r.length);
                for(k=0;k<=r.length;k++)
                {
                    if(k!=r.length)
                        s+=x.get(done++)+",";
                    else
                        s+=x.get(done++);
                    //done++;
                }
                //System.out.println("NewString");
                String newString=vals.get(j).substring(0,vals.get(j).indexOf("]")+1)+",\"children\":["+s+"]}";
                if(done==x.size())
                    newString+=",";
                //System.out.println(newString);
                temp.add(newString);
            }
            x.clear();
            x.addAll(temp);
        }
        String str="";
        for(i=0;i<x.size();i++)
            str+=x.get(i);
        int counter=0;
        String temp="";
        l=str.length();
        for(i=l-1;i>=0;i--)
        {
            if(str.charAt(i)==','&&counter<mlevel)
            {
                counter++;
                continue;
            }
            temp=str.charAt(i)+temp;
        }
        str=temp;
        //System.out.println(str);
        BTreeVisualization obj=new BTreeVisualization("structure="+URLEncoder.encode(str, "UTF-8")+"&level="+URLEncoder.encode(str, "UTF-8"));
        obj.call();
    }
    void remove(int k) 
    { 
        if (root==null) 
        { 
            System.out.println("The tree is empty"); 
            return; 
        } 
        root.remove(k); 

        // If the root node has 0 keys, make its first child as the new root 
        //  if it has a child, otherwise set root as NULL 
        if (root.n==0) 
        { 
            BTreeNode tmp = root; 
            if (root.leaf) 
                root =null; 
            else
                root = root.C[0]; 

            // Free the old root 
            tmp=null; 
        }  
    }
    public static void main(String args[]) throws UnsupportedEncodingException 
    { 
        BTree tree=new BTree(10); // A B-Tree with minium degree 3 
        tree.go();
    }
    public void go() throws UnsupportedEncodingException
    {
        root=new BTreeNode(10,true);
        /*root.insert(1);
        root.insert(2);
        root.insert(3);
        root.insert(4);
        root.insert(5);
        root.insert(6);
        root.insert(7);
        root.insert(8);
        root.insert(9);
        root.insert(10);
        for(int i=11;i<=21;i++)
            root.insert(i);
        levelOrder();*/
        for(int xx=1;xx<=90;xx++)
            root.insert(xx);
        /*System.out.println("Traversal of the constucted tree is "); 
        root.traverse();
        System.out.println();*/
        //System.out.println("Leve order traversal of the constucted tree is ");
        levelOrder();
        /*System.out.println();
        root.remove(6);
        System.out.println("Leve order traversal of the constucted tree is ");
        levelOrder();
        System.out.println();
        root.remove(5);
        System.out.println("Leve order traversal of the constucted tree is ");
        levelOrder();
        System.out.println();
        root.remove(1);
        root.remove(3);
        System.out.println("Leve order traversal of the constucted tree is ");
        levelOrder();
        System.out.println();
        System.out.println("Traversal of the constucted tree is "); 
        root.traverse();
        System.out.println();
        int k = 6; 
        if(root.search(k) != null) 
            System.out.println("Present");
        else
            System.out.println("Not Present");
        k = 15; 
        if(root.search(k) != null) 
            System.out.println("Present");
        else
            System.out.println("Not Present");*/
    } 
}
