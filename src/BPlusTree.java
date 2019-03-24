/**
 *
 * @author Lenovo
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class BPlusTree<K extends Comparable<? super K>, V> {
    class Pair
    {
        int level;
        InternalNode node;
        Pair(InternalNode a,int b)
        {
            node=a;
            level=b;
        }
    }
    private void displayLevelOrder(InternalNode root) 
    {     
        try
        {
            Queue<Pair> q=new LinkedList<>();
            q.add(new Pair(root,0));
            boolean displayed=false;
            int lev=0;
            ArrayList<V> al=new ArrayList<>();
            System.out.println("Tree");
            while(!q.isEmpty())
            {
                Pair p=(Pair)q.poll();
                List<Node> x = p.node.children;
                List<K> y=p.node.keys;
                Iterator iterator=y.iterator();
                while(iterator.hasNext())
                {
                    System.out.print("("+p.node.getValue((K)iterator.next())+","+p.level+")");
                }
                iterator=x.iterator();
                while(iterator.hasNext())
                {
                    Node temp=(Node)iterator.next();
                    if(temp.getClass()==InternalNode.class)
                    {
                        q.add(new Pair((InternalNode)temp,p.level+1));
                    }
                    else
                    {
                        //if(!displayed)
                        //{
                            LeafNode n=(LeafNode)temp;
                            List<V> values=n.values;
                            //while(n!=null)
                            //{
                                Iterator i=values.iterator();
                                while(i.hasNext())
                                    al.add((V) i.next());
                                //n=n.next;
                            //}
                            //displayed=true;
                            lev=p.level+1;
                        //}
                    }
                }
            }
            System.out.println("\nLeaf");
            int i=0,size=al.size();
            for(i=0;i<size;i++)
            {
                System.out.print("("+al.get(i)+","+lev+")");
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
	public static enum RangePolicy {EXCLUSIVE, INCLUSIVE}
        /*Track the min and max values*/
        int minKey=Integer.MAX_VALUE;
        int maxKey=Integer.MIN_VALUE;
	/**
	 * The branching factor used when none specified in constructor.
	 */
	private static final int DEFAULT_BRANCHING_FACTOR = 128;

	/**
	 * The branching factor for the B+ tree, that measures the capacity of nodes
	 * (i.e., the number of children nodes) for internal nodes in the tree.
	 */
	private int branchingFactor;
	/**
	 * The root node of the B+ tree.
	 */
	private Node root;
        /*Default constructor*/
	public BPlusTree() {
		this(DEFAULT_BRANCHING_FACTOR);
	}
        /**
         * Allows custom branching Factor
        * @param branchingFactor=Number of max tree pointers
        */
	public BPlusTree(int branchingFactor) {
		if (branchingFactor <= 2)
			throw new IllegalArgumentException("Illegal branching factor: "
					+ branchingFactor);
		this.branchingFactor = branchingFactor;
		root = new LeafNode();// Root is initially a leaf node
	}
	/**
	 * Returns the value to which the specified key is associated, or
	 * {@code null} if this tree contains no association for the key.
	 *
	 * <p>
	 * A return value of {@code null} does not <i>necessarily</i> indicate that
	 * the tree contains no association for the key; it's also possible that the
	 * tree explicitly associates the key to {@code null}.
	 * 
	 * @param key
	 *            the key whose associated value is to be returned
	 * 
	 * @return the value to which the specified key is associated, or
	 *         {@code null} if this tree contains no association for the key
	 */
	public V search(K key) {
		return root.getValue(key);
	}
	/**
	 * Returns the values associated with the keys specified by the range:
	 * {@code key1} and {@code key2}.
	 * 
	 * @param key1
	 *            the start key of the range
	 * @param policy1
	 *            the range policy, {@link RangePolicy#EXCLUSIVE} or
	 *            {@link RangePolicy#INCLUSIVE}
	 * @param key2
	 *            the end end of the range
	 * @param policy2
	 *            the range policy, {@link RangePolicy#EXCLUSIVE} or
	 *            {@link RangePolicy#INCLUSIVE}
	 * @return the values associated with the keys specified by the range:
	 *         {@code key1} and {@code key2}
	 */
	public List<V> searchRange(K key1, RangePolicy policy1, K key2,
			RangePolicy policy2) {
		return root.getRange(key1, policy1, key2, policy2);
	}
	/**
	 * Associates the specified value with the specified key in this tree. If
	 * the tree previously contained a association for the key, the old value is
	 * replaced.
	 * 
	 * @param key
	 *            the key with which the specified value is to be associated
	 * @param value
	 *            the value to be associated with the specified key
	 */
	public void insert(K key, V value) {
		root.insertValue(key, value);
	}
        /**
         * Overridden for integer insertion with key itself as value
        * @param value Value to be input in node
        */
        public void insert(V value)
        {
            int x=Integer.parseInt(value.toString());
            if(x<minKey)
                minKey=x;
            if(x>maxKey)
                maxKey=x;
            root.insertValue((K)value, value);
        }
	/**
	 * Removes the association for the specified key from this tree if present.
	 * 
	 * @param key
	 *            the key whose association is to be removed from the tree
	 */
	public void delete(K key) {
		root.deleteValue(key);
	}
        /**
         * @return Returns string representation of tree nodes
         */
        @Override
	public String toString() {
		Queue<List<Node>> queue = new LinkedList<>();
		queue.add(Arrays.asList(root));
		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			Queue<List<Node>> nextQueue = new LinkedList<>();
			while (!queue.isEmpty()) {
				List<Node> nodes = queue.remove();
				sb.append('{');
				Iterator<Node> it = nodes.iterator();
				while (it.hasNext()) {
					Node node = it.next();
					sb.append(node.toString());
					if (it.hasNext())
						sb.append(", ");
					if (node instanceof BPlusTree.InternalNode)
						nextQueue.add(((InternalNode) node).children);
				}
				sb.append('}');
				if (!queue.isEmpty())
					sb.append(", ");
				else
					sb.append('\n');
			}
			queue = nextQueue;
		}

		return sb.toString();
	}
        //Superclass of tree and leaf nodes
	private abstract class Node {
		List<K> keys;
		int keyNumber() {
			return keys.size();
		}
		abstract V getValue(K key);

		abstract void deleteValue(K key);

		abstract void insertValue(K key, V value);

		abstract K getFirstLeafKey();

		abstract List<V> getRange(K key1, RangePolicy policy1, K key2,
				RangePolicy policy2);

		abstract void merge(Node sibling);

		abstract Node split();

		abstract boolean isOverflow();

		abstract boolean isUnderflow();

                @Override
		public String toString() {
			return keys.toString();
		}
	}

	private class InternalNode extends Node {
		List<Node> children;

		InternalNode() {
			this.keys = new ArrayList<>();
			this.children = new ArrayList<>();
		}
		@Override
		V getValue(K key) {
			return getChild(key).getValue(key);
		}
		@Override
		void deleteValue(K key) {
			Node child = getChild(key);
			child.deleteValue(key);
			if (child.isUnderflow()) {
				Node childLeftSibling = getChildLeftSibling(key);
				Node childRightSibling = getChildRightSibling(key);
				Node left = childLeftSibling != null ? childLeftSibling : child;
				Node right = childLeftSibling != null ? child
						: childRightSibling;
				left.merge(right);
				deleteChild(right.getFirstLeafKey());
				if (left.isOverflow()) {
					Node sibling = left.split();
					insertChild(sibling.getFirstLeafKey(), sibling);
				}
				if (root.keyNumber() == 0)
					root = left;
			}
		}

		@Override
		void insertValue(K key, V value) {
			Node child = getChild(key);
			child.insertValue(key, value);
			if (child.isOverflow()) {
				Node sibling = child.split();
				insertChild(sibling.getFirstLeafKey(), sibling);
			}
			if (root.isOverflow()) {
				Node sibling = split();
				InternalNode newRoot = new InternalNode();
				newRoot.keys.add(sibling.getFirstLeafKey());
				newRoot.children.add(this);
				newRoot.children.add(sibling);
				root = newRoot;
			}
		}

		@Override
		K getFirstLeafKey() {
			return children.get(0).getFirstLeafKey();
		}

		@Override
		List<V> getRange(K key1, RangePolicy policy1, K key2,
				RangePolicy policy2) {
			return getChild(key1).getRange(key1, policy1, key2, policy2);
		}

		@Override
		void merge(Node sibling) {
			@SuppressWarnings("unchecked")
			InternalNode node = (InternalNode) sibling;
			keys.add(node.getFirstLeafKey());
			keys.addAll(node.keys);
			children.addAll(node.children);

		}

		@Override
		Node split() {
			int from = keyNumber() / 2 + 1, to = keyNumber();
			InternalNode sibling = new InternalNode();
			sibling.keys.addAll(keys.subList(from, to));
			sibling.children.addAll(children.subList(from, to + 1));

			keys.subList(from - 1, to).clear();
			children.subList(from, to + 1).clear();

			return sibling;
		}

		@Override
		boolean isOverflow() {
			return children.size() > branchingFactor;
		}

		@Override
		boolean isUnderflow() {
			return children.size() < (branchingFactor + 1) / 2;
		}

		Node getChild(K key) {
			int loc = Collections.binarySearch(keys, key);
			int childIndex = loc >= 0 ? loc + 1 : -loc - 1;
			return children.get(childIndex);
		}

		void deleteChild(K key) {
			int loc = Collections.binarySearch(keys, key);
			if (loc >= 0) {
				keys.remove(loc);
				children.remove(loc + 1);
			}
		}

		void insertChild(K key, Node child) {
			int loc = Collections.binarySearch(keys, key);
			int childIndex = loc >= 0 ? loc + 1 : -loc - 1;
			if (loc >= 0) {
				children.set(childIndex, child);
			} else {
				keys.add(childIndex, key);
				children.add(childIndex + 1, child);
			}
		}

		Node getChildLeftSibling(K key) {
			int loc = Collections.binarySearch(keys, key);
			int childIndex = loc >= 0 ? loc + 1 : -loc - 1;
			if (childIndex > 0)
				return children.get(childIndex - 1);

			return null;
		}

		Node getChildRightSibling(K key) {
			int loc = Collections.binarySearch(keys, key);
			int childIndex = loc >= 0 ? loc + 1 : -loc - 1;
			if (childIndex < keyNumber())
				return children.get(childIndex + 1);

			return null;
		}
	}

	private class LeafNode extends Node {
		List<V> values;
		LeafNode next;

		LeafNode() {
			keys = new ArrayList<>();
			values = new ArrayList<>();
		}
                void display(LeafNode node)
                {
                    Iterator iterator=node.values.iterator();
                    while(iterator.hasNext())
                        System.out.print(iterator.next()+" ");
                    System.out.println();
                    if(node.next!=null)
                        display(node.next);
                }
		@Override
		V getValue(K key) {
			int loc = Collections.binarySearch(keys, key);
			return loc >= 0 ? values.get(loc) : null;
		}

		@Override
		void deleteValue(K key) {
			int loc = Collections.binarySearch(keys, key);
			if (loc >= 0) {
				keys.remove(loc);
				values.remove(loc);
			}
		}

		@Override
		void insertValue(K key, V value) {
			int loc = Collections.binarySearch(keys, key);
			int valueIndex = loc >= 0 ? loc : -loc - 1;
			if (loc >= 0) {
				values.set(valueIndex, value);
			} else {
				keys.add(valueIndex, key);
				values.add(valueIndex, value);
			}
			if (root.isOverflow()) {
				Node sibling = split();
				InternalNode newRoot = new InternalNode();
				newRoot.keys.add(sibling.getFirstLeafKey());
				newRoot.children.add(this);
				newRoot.children.add(sibling);
				root = newRoot;
			}
		}

		@Override
		K getFirstLeafKey() {
			return keys.get(0);
		}

		@Override
		List<V> getRange(K key1, RangePolicy policy1, K key2,
				RangePolicy policy2) {
			List<V> result = new LinkedList<>();
			LeafNode node = this;
			while (node != null) {
				Iterator<K> kIt = node.keys.iterator();
				Iterator<V> vIt = node.values.iterator();
				while (kIt.hasNext()) {
					K key = kIt.next();
					V value = vIt.next();
					int cmp1 = key.compareTo(key1);
					int cmp2 = key.compareTo(key2);
					if (((policy1 == RangePolicy.EXCLUSIVE && cmp1 > 0) || (policy1 == RangePolicy.INCLUSIVE && cmp1 >= 0))
							&& ((policy2 == RangePolicy.EXCLUSIVE && cmp2 < 0) || (policy2 == RangePolicy.INCLUSIVE && cmp2 <= 0)))
						result.add(value);
					else if ((policy2 == RangePolicy.EXCLUSIVE && cmp2 >= 0)
							|| (policy2 == RangePolicy.INCLUSIVE && cmp2 > 0))
						return result;
				}
				node = node.next;
			}
			return result;
		}

		@Override
		void merge(Node sibling) {
			@SuppressWarnings("unchecked")
			LeafNode node = (LeafNode) sibling;
			keys.addAll(node.keys);
			values.addAll(node.values);
			next = node.next;
		}

		@Override
		Node split() {
			LeafNode sibling = new LeafNode();
			int from = (keyNumber() + 1) / 2, to = keyNumber();
			sibling.keys.addAll(keys.subList(from, to));
			sibling.values.addAll(values.subList(from, to));

			keys.subList(from, to).clear();
			values.subList(from, to).clear();

			sibling.next = next;
			next = sibling;
			return sibling;
		}

		@Override
		boolean isOverflow() {
			return values.size() > branchingFactor - 1;
		}

		@Override
		boolean isUnderflow() {
			return values.size() < branchingFactor / 2;
		}
	}
        public static void main(String args[])
        {
            /*Integer only,no key-value pair for now*/
            BPlusTree tree=new BPlusTree(3);
            tree.insert(20); 
            tree.insert(5); 
            tree.insert(6); 
            tree.insert(12); 
            tree.insert(30); 
            tree.insert(7); 
            tree.insert(17);
            tree.insert(1); 
            tree.insert(3); 
            tree.insert(7); 
            tree.insert(10); 
            tree.insert(11); 
            tree.insert(13); 
            tree.insert(14); 
            tree.insert(15); 
            tree.insert(18); 
            tree.insert(16); 
            tree.insert(19); 
            tree.display(tree);
            if(tree.searchRange(6,BPlusTree.RangePolicy.INCLUSIVE,6,BPlusTree.RangePolicy.INCLUSIVE).size()==1)
                System.out.println("Present");
            else
                System.out.println("Not present");
            tree.delete(6);
            tree.display(tree);
            if(tree.searchRange(6,BPlusTree.RangePolicy.INCLUSIVE,6,BPlusTree.RangePolicy.INCLUSIVE).size()==1)
                System.out.println("Present");
            else
                System.out.println("Not present");
        }
        public void display(BPlusTree tree)
        {
            System.out.println("Sorted");
            List<Integer> list=tree.searchRange(tree.minKey, BPlusTree.RangePolicy.INCLUSIVE, tree.maxKey, BPlusTree.RangePolicy.INCLUSIVE);
            Iterator iterator=list.iterator();
            while(iterator.hasNext())
            {
                System.out.print(iterator.next()+" ");
            }
            System.out.println();
            tree.displayLevelOrder((InternalNode)tree.root);
            System.out.println();
        }    
}
