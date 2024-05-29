/* 3.1 Write a java program that initializes the values {67, 22, 5, 73, 99, 45, 101, 32, 10, 98} in an array and uses a binary search approach to find an index location of the following specified values of the array. 	    [10]
    - `Sample runs of your program>`
    - Enter the number your searching for: 101
    - The item was found at index location 9
    - Enter the item you are searching for: 65
    - The item was not found in the list
 */
public class Main {
    private static void insertionSort(int[] arr) {
        int low = 0;
        int high = arr.length;

        for (int i, k = low; ++k < high; ) {
            int arri = arr[i = k];
            if (arri < arr[i - 1]) {
                while (--i >= low && arri < arr[i]) {
                    arr[i + 1] = arr[i];
                }
                arr[i + 1] = arri;
            }
        }
    }

    private static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1; // (low + high) / 2
            int midVal = arr[mid];

            if (midVal < key) low = mid + 1;
            else if (midVal > key) high = mid - 1;
            else return mid; // key found
        }
        return -(low + 1);  // key not found.
    }

    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);

        System.out.print("Enter the number your searching for: ");
        int targetNum = input.nextInt();

        int[] values = {67, 22, 5, 73, 99, 45, 101, 32, 10, 98};
        insertionSort(values);                      // java.util.Arrays.sort(values);
        int key = binarySearch(values, targetNum);  // int key = java.util.Arrays.binarySearch(values, targetNum);

        if (key >= 0) {
            System.out.println("The item was found at index location " + key);
        } else {
            System.out.println("The item was not found in the list");
        }
    }
}