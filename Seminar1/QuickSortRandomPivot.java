import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class QuickSortRandomPivot {
    // Function to swap two elements
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // Function to partition the array
    private static int partitionLeft(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high);
        return i;
    }
    // Function to perform random partition
    private static int partitionRight(int[] arr, int low, int high) {
        Random rand = new Random();
        int r = low + rand.nextInt(high - low);
        swap(arr, r, high);
        return partitionLeft(arr, low, high);
    }
    // Recursive function for quicksort
    private static void quicksortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int p = partitionRight(arr, low, high);
            quicksortHelper(arr, low, p - 1);
            quicksortHelper(arr, p + 1, high);
        }
    }

    public  void quickSortRec(int[] arr) {
        quicksortHelper(arr, 0, arr.length - 1);
    }




    // Iterative
    public void quickSortIterative(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int low = 0;
        int high = arr.length - 1;

        stack.push(low);
        stack.push(high);

        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();

            int p = partitionRight(arr, low, high);

            if (p - 1 > low) {
                stack.push(low);
                stack.push(p - 1);
            }

            if (p + 1 < high) {
                stack.push(p + 1);
                stack.push(high);
            }
        }
    }

    // Function to print the array
    private static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {6, 4, 12, 8, 15, 16};
        System.out.print("Original array: ");
        printArray(arr);
        //quickSortRec(arr);
        System.out.print("\nSorted array: ");
        printArray(arr);


        int[] arr2 = {4, 2, 7, 1, 9, 5, 3};
        System.out.println("Original array: " + Arrays.toString(arr2));
        //quickSortIterative(arr2);
        System.out.println("Sorted array: " + Arrays.toString(arr2));
    }
    
}
