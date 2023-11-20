import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

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


    // Median of 3 from the book

    private static <AnyType extends Comparable<? super AnyType>>
    AnyType median3( AnyType [ ] a, int left, int right )
    {
        int center = ( left + right ) / 2;
        if( a[ center ].compareTo( a[ left ])<0){
            swapReferences( a, left, center );
        }
        if( a[ right ].compareTo( a[ left ] ) < 0 ){
            swapReferences( a, left, right );
        }
        if( a[ right ].compareTo( a[ center ] ) < 0 ){
            swapReferences( a, center, right );
        }
        // Place pivot at position right - 1
        swapReferences( a, center, right - 1 );
        return a[ right - 1 ];
    }

    private static <AnyType extends Comparable<? super AnyType>>
    void swapReferences(AnyType[] a, int i, int j) {
        AnyType tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


/**
 * Internal quicksort method that makes recursive calls.
 * Uses median-of-three partitioning and a cutoff of 10.
 * @param a an array of Comparable items.
 * @param left the left-most index of the subarray.
 * @param right the right-most index of the subarray.
 */
    private static <AnyType extends Comparable<? super AnyType>>
    void quicksort( AnyType [ ] a, int left, int right ){
        int CUTOFF = 0;
        if( left + CUTOFF <= right ){
            AnyType pivot = median3( a, left, right );

            // Begin partitioning
            int i = left + 1, j = right;
            for( ; ; ){
                while( a[ i ].compareTo( pivot )<0){i++;}
                while( a[ j ].compareTo( pivot )>0){j--;};
                if( i < j ){
                    swapReferences( a, i, j );
                }
                else{
                    break;
                }
            }
            swapReferences( a, i, right-1); // Restore pivot

            quicksort( a, left, i-1); // Sort small elements
            quicksort( a, i + 1, right ); // Sort large elements
        }else{ // Do an insertion sort on the subarray
            //insertionSort( a, left, right );
        }
    }
    public void quickSortRecursiveWithMedian3Pivot(int[] array){
        Integer[] arr = intArrayToIntegerArray(array);
        quicksort(arr, 0, arr.length - 1);
    }
    

    private static Integer[] intArrayToIntegerArray(int[] intArray) {
    return IntStream.of(intArray)
                    .boxed() // Convert int to Integer (autoboxing)
                    .toArray(Integer[]::new);
}

    public static void main(String[] args) {
        int[] arr = {5,7,8,2,34,99,6,43};
        QuickSort qs = new QuickSort();
        System.out.println(Arrays.toString(arr));
        qs.quickSortRecursiveWithMedian3Pivot(arr);
        System.out.println(Arrays.toString(arr));
    }
}



