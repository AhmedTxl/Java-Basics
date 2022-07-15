import java.util.Arrays;

/**
 *
 * @author Ahmed
 */
public class MinHeap {
    int index; // This variable used for detecting element position in Array-Based heap.
    int size; // Max element number that user chose to the heap.
    int[] heap; // Array-Based heap.
    
    // Constructor that create the heap, so we can apply other operation on it.
    public MinHeap(int maxQ) {
        this.size = maxQ;
        this.index = 0;
        this.heap = new int[size];
    }
    
    // insertion method for heap that insert by [ index ] variable and increase it to point to the next position for insertion again.
    public void insert(int value) {
        
        if (index >= size) {
            return;
        }

        heap[index] = value;      
        
        index++;
    }
    
    // delete the first element in the array => heap[0].
    public int delete() {
        int pop = heap[0];
        heap[0] = heap[--index];
        minHeapify(0);
        return pop;
    }
    
    // Check if passing position is heap leaf elements.
    public boolean isLeaf(int pos) {
        return getRightChild(pos) >= size || getLeftChild(pos) >= size;
    }
    
    // Return Parent Position.
    public int getParent(int childPos) {
        return (childPos - 1) / 2;
    }
    
    // Return Left Child Position.
    public int getLeftChild(int parentPos) { 
        return (2 * parentPos) + 1;
    }
    
    // Return Right Child Position.
    public int getRightChild(int parentPos) {
        return (2 * parentPos) + 2;
    }
    
    // Swapping two elements in the heap(arrray) by passing (i , j).
    public void swap(int i, int j) {
        int temp;
        temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    
    // This method sorts all heap to start from min-value to max-value.
    public void minHeapify(int i) {
        for(int cur = 0; cur < index; cur++){
          while (heap[cur] < heap[getParent(cur)]) {
            swap(cur, getParent(cur));
            cur = getParent(cur);
          }
        }
    }
    
    // Repeat sorting function (minHeapify) depending on heap depth.
    public void minHeap() {
        for (int i = (index / 2); i >= 1; i--) {
            minHeapify(i);
        }
    }
    
    // display heap elements depending on its Depth.
    public void display() {
        System.out.println("Root : " + heap[0]);
        for (int i = 0; i < (index / 2); i++) {
            System.out.print("Parent : " + heap[i]);
            if (getLeftChild(i) < index) {
                System.out.print(" | Left Child : " + heap[getLeftChild(i)]);
            }
            if (getRightChild(i) < index) {
                System.out.print(" | Right Child : " + heap[getRightChild(i)]);
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        MinHeap test = new MinHeap(7); // Create a new heap.
        
        // Here fill the heap with elements.
        test.insert(7);
        test.insert(6);
        test.insert(5);
        test.insert(4);
        test.insert(3);
        test.insert(2);
        test.insert(1);
        
        System.out.println("The min Heap : " + Arrays.toString(test.heap));
        
        test.display();
        System.out.println("-----------------------------------");
        test.minHeap();
        test.display();
        System.out.println("-----------------------------------");
        System.out.println("Deleted item : " + test.delete());
        test.display();
    }
    
}
