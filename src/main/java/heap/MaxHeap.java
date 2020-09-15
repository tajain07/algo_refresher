package heap;

import java.util.Arrays;

public class MaxHeap {

    private int[] heap;
    private int   size;
    private int   capacity;

    public MaxHeap(int heapSize) {
        this.size = 0;
        this.capacity = heapSize;
        this.heap = new int[capacity];
    }

    public MaxHeap(int[] a) {
        this.size = a.length - 1;
        this.capacity = a.length;
        this.heap = a;
        buildMaxHeap();
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return index / 2;
    }

    //index to size
    public int getSize() {
        return size;
    }

    /**
     * @param index
     */
    public void maxHeapify(int index) {

        int largest = index;
        int leftChild = leftChild(index);
        int rightChild = rightChild(index);

        if (leftChild < getSize() && heap[leftChild] > heap[largest]) {
            largest = leftChild;
        }
        if (rightChild < getSize() && heap[rightChild] > heap[largest]) {
            largest = rightChild;
        }

        if (largest != index) {
            swap(largest, index);
            maxHeapify(largest);
        }

    }

    private void swap(int index, int left) {
        int temp = heap[index];
        heap[index] = heap[left];
        heap[left] = temp;
    }

    public void buildMaxHeap() {

        int totalNodes = (size - 1);

        for (int parentIndex = totalNodes / 2; parentIndex >= 0; parentIndex--) {
            maxHeapify(parentIndex);
        }

    }

    public void insert(int element) {

        //Check is need to expand the array.
        ensureCapacity();

        int currentElementIndex = size;
        heap[size++] = element;

        while (heap[currentElementIndex] > heap[parent(currentElementIndex)]) {
            swap(currentElementIndex, parent(currentElementIndex));
            currentElementIndex = parent(currentElementIndex);
        }

    }

    //isHeapFull, isHeapEmpty
    private void ensureCapacity() {

        if (size >= capacity) {
            int[] newArray;
            newArray = Arrays.copyOf(heap, capacity * 2);
            this.heap = newArray;
            capacity = capacity * 2;
        }
    }

    public int[] getHeap() {
        return heap.clone();
    }

    public int extractMax() {
        int maxElement = heap[0];
        heap[0] = heap[size];
        heap[size] = 0;
        size--;

        maxHeapify(0);

        return maxElement;

    }

    public static void main(String[] args) {
        //int a[] = { 5, 3, 17, 10, 84, 19, 6, 22, 9 };
        //MaxHeap maxHeap = new MaxHeap(a);
        //System.out.println(Arrays.toString(maxHeap.getHeap()));

        MaxHeap heap = new MaxHeap(4);
        heap.insert(10);
        heap.insert(33);
        heap.insert(16);
        heap.insert(67);
        heap.insert(55);
        heap.insert(7);

        int element = heap.extractMax();
        System.out.println(element);
    }

}
