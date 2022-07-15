import java.util.Scanner;

/**
 *
 * @author Ahmed
 */
public class BinaryTree {

    static int root = 0; // This variable is the index of first element.  
    static int index; // This variable used for detecting element position in Array-Based Binary Tree.
    static int size; // Max element number that user choose to the Binary Tree.
    static int[] bt; // Array-Based Binary Tree.
    
    // Constructor that create the Binary Tree, so we can apply other operation on it.
    public BinaryTree(int maxQ) {
        BinaryTree.size = maxQ;
        BinaryTree.index = 1;
        BinaryTree.bt = new int[size];
    }
    
    // Check if passing position is Binary Tree leaf elements.
    public boolean isLeaf(int pos) {
        return getRightChild(pos) >= size || getLeftChild(pos) >= size;
    }
    
    // return root postition.
    public static int getRoot() {
        return 1;
    }
    
    // set the root of tree.
    public void setRoot(int value) {
        bt[1] = value;
        
        index++;
    }
    
    // Return Parent Position.
    public static int getParent(int childPos) {
        return ((childPos - 1) + 1) / 2;
    }
    
    // Return Left Child Position.
    public static int getLeftChild(int parentPos) { 
        return (2 * parentPos);
    }
    
    // set left child by passing parent position.
    public void setLeft(int rt, int key)
    {
        int t = (rt * 2);
 
        if (bt[rt] == 1) {
            System.out.printf("Can't set child at %d, no parent found\n", t);
        }
        else {
            bt[t] = key;
        }
        
        index++;
    }
    
    // set right child by passing parent position.
    public void setRight(int rt, int key)
    {
        int t = (rt * 2) + 1;
 
        if (bt[rt] == 1) {
            System.out.printf("Can't set child at " + t + ", no parent found\n", t);
        }
        else {
            bt[t] = key;
        }
        
        index++;
    }
    
    // Return Right Child Position.
    public static int getRightChild(int parentPos) {
        return (2 * parentPos) + 1;
    }
    public int result = -1;
    public int search(int key, int indx) {
        
        
        // Compare key with root's value.
        if (key == bt[indx]) {
            result = bt[indx];
            return result;
        }
        // Comapare if root or parent is bigger than (key).
        else if (key < bt[indx] && (bt[getRightChild(indx)] != 0 || bt[getLeftChild(indx)] != 0)) {
            if (key == bt[getLeftChild(indx)]) {
                    result = bt[getLeftChild(indx)];
                    return result;
            }
            else {
                search(key, getLeftChild(indx)); // Call the method again with new (index).
            }
        }
        // Compare if root or parent is smaller than (key).
        else if (key > bt[indx] && (bt[getRightChild(indx)] != 0 || bt[getLeftChild(indx)] != 0)) {
            if (key == bt[getRightChild(indx)]) {
                result = bt[getRightChild(indx)];
                return result;
            }
            else {
                search(key, getRightChild(indx));
            }
        }
        else {
            return result;
        }
        
        return result;
    }
    
    // Shows binary tree elements.
    public void display() {
        
        System.out.println("Root : " + bt[1]);
        
        for (int i = 1; i <= (index / 2); i++) {
            
            if (bt[getRightChild(i)] != 0 || bt[getLeftChild(i)] != 0) {
                System.out.print("Parent : " + bt[i]);
            }
            
            if (getLeftChild(getParent(i)) < index) {
                System.out.print(" | Left Child : " + bt[getLeftChild(i)]);
            }
            
            if (getRightChild(getParent(i)) < index && bt[getRightChild(i)] != 0) {
                System.out.print(" | Right Child : " + bt[getRightChild(i)]);
            }
    
            System.out.println();
        }
    }

    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int temp;
        BinaryTree test = new BinaryTree(15); // here i create a new binary tree by constructor and set the size of tree equal [15] elements.
        // sets the root and other elements by passing there index and the value that want to be inserted.
        test.setRoot(63);
        test.setLeft(1, 27);
        test.setRight(1, 80);
        test.setLeft(2, 13);
        test.setRight(2, 51);
        test.setLeft(3, 70);
        
        
        test.display(); // shows binary tree elements
   
        System.out.println("--------------------------------");
        
        // here program will ask the user to enter a number to search if it's exist in the tree or not, if not hten it will return [-1].
        System.out.print("Enter a number to search for : ");
        temp = in.nextInt();
        
        System.out.println(test.search(temp, 1));
    }
}
