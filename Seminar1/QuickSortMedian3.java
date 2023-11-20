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
    int pivot = array[highIndex];
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


 
  public static void main(String[] args) {
    int[] array = { 7, 6, 5, 4, 3, 2, 1 };
    System.out.println("Unsorted: " + Arrays.toString(array));
 
    QuickSortMedian3 qs = new QuickSortMedian3();
    qs.quickSortRecursiveWithMedian3Pivot(array);
    System.out.println("Sorted: " + Arrays.toString(array));

    System.out.println();

    int[] array2 = { 7, 6, 5, 4, 3, 2, 1 };
    System.out.println("Unsorted: " + Arrays.toString(array2));
    qs.quickSortIterativeWithMedian3Pivot(array2);
    System.out.println("Sorted: " + Arrays.toString(array2));

} 
}