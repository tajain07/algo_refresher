package heap;

import java.util.Arrays;

public class MinHeap {
    private int[] heap;
    private int size;
    private int maxSize;

    public int getSize() {
        return size;
    }

    public MinHeap(int capacity) {
        this.heap = new int[capacity];
        this.maxSize = capacity;
        this.size = 0;
    }

    private void ensureCapacity() {

        if (size >= maxSize) {
            int[] newArray;
            newArray = Arrays.copyOf(heap, maxSize * 2);
            this.heap = newArray;
            maxSize = maxSize * 2;
        }
    }

    public void insert(int element) {
        ensureCapacity();

        int currentIndex = size;
        heap[size++] = element;


        while (heap[parent(currentIndex)] > heap[currentIndex]) {
            swap(currentIndex, parent(currentIndex));
            currentIndex = parent(currentIndex);

        }

    }

    private int parent(int index) {
        return index / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private void heapify(int index) {

    }

    private void swap(int index, int parent) {
        int temp = heap[index];
        heap[index] = heap[parent];
        heap[parent] = temp;
    }

    private void minHeapify(int index) {
        int smallest = index;
        int leftChild = leftChild(index);
        int rightChild = rightChild(index);

        if (leftChild < size && heap[leftChild] < heap[smallest])
            smallest = leftChild;
        if (rightChild < size && heap[rightChild] < heap[smallest])
            smallest = rightChild;

        if (smallest != index) {
            swap(smallest, index);
            minHeapify(smallest);
        }


    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(2);
        minHeap.insert(21);
        minHeap.insert(22);
        minHeap.insert(4);
        minHeap.insert(12);
        minHeap.insert(1);

        while (minHeap.size > 0) {
            int min = minHeap.extractMin();
            System.out.println(min);
        }

        System.out.println(minHeap);
    }

    public int extractMin() {
        int minVal = heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = 0;
        size--;
        minHeapify(0);
        return minVal;
    }


}
