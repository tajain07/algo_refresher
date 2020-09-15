package heap;

import java.util.Arrays;
import java.util.Vector;

public class PriorityQueue {

    private Vector <Integer> A;

    public PriorityQueue() {
        A = new Vector <>();
    }

    public PriorityQueue(int capacity) {
        A = new Vector <>(capacity);
    }

    private int parent(int i) {
        if (i == 0)
            return 0;
        return i - 1 / 2;
    }

    // return left child of A.get(i)
    private int LEFT(int i) {
        return (2 * i + 1);
    }

    // return right child of A.get(i)
    private int RIGHT(int i) {
        return (2 * i + 2);
    }

    // swap values at two indexes
    void swap(int x, int y) {
        // swap with child having greater value
        Integer temp = A.get(x);
        A.setElementAt(A.get(y), x);
        A.setElementAt(temp, y);
    }

    // return size of the heap
    public int size() {
        return A.size();
    }

    // Recursive Heapify-down procedure. Here the node at index i
    // and its two direct children violates the heap property
    private void heapify_down(int i) {
        // get left and right child of node at index i
        int left = LEFT(i);
        int right = RIGHT(i);

        int largest = i;

        // compare A.get(i) with its left and right child
        // and find largest value
        if (left < size() && A.get(left) > A.get(i)) {
            largest = left;
        }

        if (right < size() && A.get(right) > A.get(largest)) {
            largest = right;
        }

        if (largest != i) {
            // swap with child having greater value
            swap(i, largest);

            // call heapify-down on the child
            heapify_down(largest);
        }
    }

    // Recursive Heapify-up procedure
    private void heapify_up(int i) {
        // check if node at index i and its parent violates
        // the heap property
        if (i > 0 && A.get(parent(i)) < A.get(i)) {
            // swap the two if heap property is violated
            swap(i, parent(i));

            // call Heapify-up on the parent
            heapify_up(parent(i));
        }
    }

    // check if heap is empty or not
    public Boolean isEmpty() {
        return A.isEmpty();
    }

    // insert specified key into the heap
    public void add(Integer key) {
        // insert the new element to the end of the vector
        A.addElement(key);

        // get element index and call heapify-up procedure
        int index = size() - 1;
        heapify_up(index);
    }

    // function to remove and return element with highest priority
    // (present at root). It returns null if queue is empty
    public Integer poll() {
        try {
            // if heap is empty, throw an exception
            if (size() == 0) {
                throw new Exception("Index is out of range (Heap underflow)");
            }

            // element with highest priority
            int root = A.firstElement();    // or A.get(0);

            // replace the root of the heap with the last element of the vector
            A.setElementAt(A.lastElement(), 0);
            A.remove(size() - 1);

            // call heapify-down on root node
            heapify_down(0);

            // return root element
            return root;
        }
        // catch and print the exception
        catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    // function to return, but does not remove, element with highest priority
    // (present at root). It returns null if queue is empty
    public Integer peek() {
        try {
            // if heap has no elements, throw an exception
            if (size() == 0) {
                throw new Exception("Index out of range (Heap underflow)");
            }

            // else return the top (first) element
            return A.firstElement();    // or A.get(0);
        }
        // catch the exception and print it, and return null
        catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    // function to remove all elements from priority queue
    public void clear() {
        System.out.print("Emptying queue: ");
        while (!A.isEmpty()) {
            System.out.print(poll() + " ");
        }
        System.out.println();
    }

    // returns true if queue contains the specified element
    public Boolean contains(Integer i) {
        return A.contains(i);
    }

    // returns an array containing all elements in the queue
    public Integer[] toArray() {
        return A.toArray(new Integer[size()]);
    }

    public static void main(String[] args) {
        // create a Priority Queue of initial capacity 10
        // Priority of an element is decided by element's value
        PriorityQueue pq = new PriorityQueue(10);

        // insert three integers
        pq.add(3);
        pq.add(2);
        pq.add(15);

        // print Priority Queue size
        System.out.println("Priority Queue Size is " + pq.size());

        // search 2 in Priority Queue
        Integer searchKey = 2;

        if (pq.contains(searchKey)) {
            System.out.println("Priority Queue contains " + searchKey + "\n");
        }

        // empty queue
        pq.clear();

        if (pq.isEmpty()) {
            System.out.println("Queue is Empty");
        }

        System.out.println("\nCalling remove operation on an empty heap");
        System.out.println("Element with highest priority is " + pq.poll() + '\n');

        System.out.println("Calling peek operation on an empty heap");
        System.out.println("Element with highest priority is " + pq.peek() + '\n');

        // again insert three integers
        pq.add(5);
        pq.add(4);
        pq.add(45);

        // construct array containing all elements present in the queue
        Integer[] I = pq.toArray();
        System.out.println("Printing array: " + Arrays.toString(I));

        System.out.println("\nElement with highest priority is " + pq.poll());
        System.out.println("Element with highest priority is " + pq.peek());
    }
}
