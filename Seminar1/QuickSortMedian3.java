import java.util.Arrays;
import java.util.Stack;

public class QuickSortMedian3 {
    
  private static void quickSortRec(int[] array, int lowIndex, int highIndex) {
    if (lowIndex < highIndex) {
      int partitionIndex = partition(array, lowIndex, highIndex);
 
      quickSortRec(array, lowIndex, partitionIndex - 1);
      quickSortRec(array, partitionIndex + 1, highIndex);
    }
  }

  private static void quickSortIterative(int[] array, int lowIndex, int highIndex) {
        Stack<Integer> stack = new Stack<>();
        stack.push(lowIndex);
        stack.push(highIndex);

        while (!stack.isEmpty()) {
            highIndex = stack.pop();
            lowIndex = stack.pop();

            int partitionIndex = partition(array, lowIndex, highIndex);

            if (partitionIndex - 1 > lowIndex) {
                stack.push(lowIndex);
                stack.push(partitionIndex - 1);
            }

            if (partitionIndex + 1 < highIndex) {
                stack.push(partitionIndex + 1);
                stack.push(highIndex);
            }
        }
    }
 
    private static int partition(int[] array, int lowIndex, int highIndex) {
        int pivot = medianOfThree(array, lowIndex, highIndex);
        // Swap the pivot with the last element to simplify the partitioning logic
        swap(array, pivot, highIndex);

        pivot = array[highIndex];
        int i = (lowIndex - 1);

        for (int j = lowIndex; j < highIndex; j++) {
            if (array[j] < pivot) {
            i++;
            swap(array, i, j);
        }
        }
        swap(array, i + 1, highIndex);
        return (i + 1);
    }
 
  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public void quickSortRecursiveWithMedian3Pivot(int[] array) {
    quickSortRec(array, 0, array.length - 1);
  }

  public void quickSortIterativeWithMedian3Pivot(int[] array) {
    int lowIndex = 0;
    int highIndex = array.length - 1;
    quickSortIterative(array, lowIndex, highIndex);
}
  private static int medianOfThree(int arr[], int low, int high) {
    int mid = low + (high - low) / 2;
    if (arr[low] > arr[mid])
      swap(arr, low, mid);
    if (arr[low] > arr[high])
        swap(arr, low, high);
    if (arr[mid] > arr[high])
        swap(arr, mid, high);
    return mid;
    }


 
  public static void main(String[] args) {
    QuickSortMedian3 qs = new QuickSortMedian3();
    int[] array2 = {15, 13, 19, 12, 16, 18, 22};
    System.out.println("Unsorted: " + Arrays.toString(array2));
    qs.quickSortIterativeWithMedian3Pivot(array2);
    System.out.println("Sorted: " + Arrays.toString(array2));



} 
}