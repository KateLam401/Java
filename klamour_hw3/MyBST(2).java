
// you may want to change the import statements as needed
import net.datastructures.*;
import java.util.Comparator;

// generic binary search tree
public class MyBST<E> extends LinkedBinaryTree<E> {

	private Comparator<E> comp;
	private int size = 0;
	
	public MyBST(Comparator<E> c) {comp = c;};
	public MyBST(){ this(new DefaultComparator<E>()); }
	
	public int size() { return size; }
	public boolean isEmpty() { return size() == 0; }
	
	public Position<E> add(Position<E> p, E e){

		if (p == null){
			Position<E> temp = addRoot(e); // new node is created and becomes the root
			return temp;
		}
		
		Node<E> cursor = validate(p);  // cursor is x in the pseudocode
		Node<E> pr = cursor;           // pr is y in the pseudocode
		
		// complete this method

	}
	
	// Print a binary tree horizontally
	// Modified version of https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
	// Modified by Keith Gutfreund
	
	void print(Position<E> p){ 
		print ("", p); 
	}
	
	private void print(String prefix, Position<E> p){
	  if (p != null){
	    print(prefix + "     ", right(p));
	    System.out.println (prefix + ("|-- ") + p.getElement());
	    print(prefix + "     ", left(p));
	  }
	}

	// print a binary tree using inorder tree traversal
	public void inorderPrint(Position<E> p){
		if (p == null) return;
		Node<E> n = validate(p);
		inorderPrint(n.getLeft());
		System.out.print(n.getElement() + "  ");
		inorderPrint(n.getRight());
	}
	
	public static void main(String[] args) {
		
		// binary search tree stroing integers
		MyBST<Integer> t =   new MyBST<>();

		// test add method
		t.add(t.root, 100);
		t.add(t.root, 50);
		t.add(t.root, 150);
		t.add(t.root, 70);
		t.add(t.root, 30);
		t.add(t.root, 130);
		t.add(t.root, 140);
		t.add(t.root, 120);
		
		System.out.println("Number of nodes is: " + t.size);
		
		System.out.println("Print tree horizontally: ");
		t.print(t.root);
		System.out.println("\n");
		
		System.out.println("Print tree by inorder traversal: ");
		t.inorderPrint(t.root);

		System.out.println("\n");
		
	}

}
