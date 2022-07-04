package sorting;

/**
 * Not using sorting here.
 * Single iteration can solve our problem
 */
public class SecondLargestElement {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 8, 1, 15, 15, 7, 9, 2};
        int element = secondLargest(arr);
        System.out.println("element " + element);
    }

    private static int secondLargest(int[] arr) {
        int largest = arr[0];
        int secondLargest;

        if (arr[1] > arr[0]) {
            largest = arr[1];
            secondLargest = arr[0];
        } else {
            secondLargest = arr[1];
        }

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] >= largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest)
                secondLargest = arr[i];
        }
        return secondLargest;
    }
}
