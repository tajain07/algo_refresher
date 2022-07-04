package binary_search;

/**
 * Example :
 * <p>
 * Input : pages[] = {12, 34, 67, 90}
 * m = 2
 * Output : 113
 * Explanation:
 * There are 2 number of students. Books can be distributed
 * in following fashion :
 * 1) [12] and [34, 67, 90]
 * Max number of pages is allocated to student
 * 2 with 34 + 67 + 90 = 191 pages
 * 2) [12, 34] and [67, 90]
 * Max number of pages is allocated to student
 * 2 with 67 + 90 = 157 pages
 * 3) [12, 34, 67] and [90]
 * Max number of pages is allocated to student
 * 1 with 12 + 34 + 67 = 113 pages
 * <p>
 * Of the 3 cases, Option 3 has the minimum pages = 113.
 * <p>
 * https://www.geeksforgeeks.org/allocate-minimum-number-pages/
 */
public class AllocateMinimumNumberOfPages {
    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};  //Number of pages in books

        int m = 2;  //No. of students

        System.out.println("Minimum number of pages = " + findPages(arr, arr.length, m));
    }

    private static int findPages(int[] arr, int length, int no_student) {
        int start = arr[0];
        int end = 0;
        int res = -1;

        if (length < no_student)
            return -1;

        for (int i = 0; i < length; i++) {
            start = Math.max(start, arr[i]);
            end += arr[i];
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isValid(arr, length, no_student, mid)) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(start);
        System.out.println(end);
        return res;
    }

    private static boolean isValid(int[] arr, int length, int no_student, int mx) {
        int student = 1;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += arr[i];
            if (sum > mx) {
                student++;
                sum = arr[i];
            }
        }

        return student <= no_student;

    }
}
