import java.util.Stack;

public class QuickSort {

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    public static int pivot(int[] array, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if (array[i] < array[pivotIndex]) {
                swapIndex++;
                swap(array, swapIndex, i);
            }
        }
        swap(array, pivotIndex, swapIndex);

        return swapIndex;
    }
    

    private static void quickSortRec(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = pivot(array, left, right);
            quickSortRec(array, left, pivotIndex-1);
            quickSortRec(array, pivotIndex+1, right);
        }
    }

    public void quickSortRecursiveWithFirstElementPivot(int[] array) {
        quickSortRec(array, 0, array.length-1);
    }


    public void quickSortIterativeWithFirstElementPivot(int[] array){
         // Create a stack to keep track of subarrays that need to be sorted
        Stack<Integer> stack = new Stack<>();
        
        // Initialize left and right indices for the entire array
        int left = 0;
        int right = array.length - 1;

        // Push the initial subarray indices onto the stack
        stack.push(right);
        stack.push(left);

        // Process the stack until it is empty
        while (!stack.isEmpty()) {
            // Pop the subarray indices from the stack
            left = stack.pop();
            right = stack.pop();

            // Partition the subarray and get the pivot index
            int pivotIndex = pivot(array, left, right);

            // Push the left subarray indices onto the stack if needed
            if (pivotIndex - 1 > left) {
                stack.push(pivotIndex - 1);
                stack.push(left);
            }

            // Push the right subarray indices onto the stack if needed
            if (pivotIndex + 1 < right) {
                stack.push(right);
                stack.push(pivotIndex + 1);
            }
        }
    
    }
}



