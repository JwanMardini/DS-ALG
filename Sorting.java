import java.util.Arrays;

public class Sorting {
    // Method to perform bubble sort on an array of integers
    public static <AnyType extends Comparable<? super AnyType>>
    void bubbleSort(AnyType[] arr) {
        // Get the length of the array
        int n = arr.length;
        
        // Flag to track whether any swaps occurred in a pass
        boolean swapped;

        // Repeat the sorting process until no swaps are made in a pass
        do {
            // Reset the swapped flag for each pass
            swapped = false;

            // Reduce the size of the unsorted portion of the array
            n = n - 1;

            // Iterate through the array
            for (int i = 0; i < n; i++) {
                // Compare adjacent elements and swap if they are in the wrong order
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    AnyType temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    
                    // Set the swapped flag to true if a swap occurs
                    swapped = true;
                }
            }
        } while (swapped); // Continue looping until no swaps are made in a pass
    }

    public static <AnyType extends Comparable<? super AnyType>>
    void selectionSort(AnyType[] arr) {
        // Iterate through the array
        for (int i = 0; i <= arr.length - 2; i++) {
            // Assume the current index is the minimum
            int min = i;
    
            // Find the index of the minimum element in the unsorted portion
            for (int j = i + 1; j <= arr.length - 1; j++) {
                if (arr[j].compareTo(arr[min]) < 0) {
                    min = j;
                }
            }
    
            // Swap the minimum element with the first element in the unsorted portion
            AnyType temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }


    // Method to perform insertion sort on an array of elements
    public static <AnyType extends Comparable<? super AnyType>>
    void insertionSort(AnyType[] a) {
        int j;
        
        // Iterate through the array starting from the second element
        for (int p = 1; p < a.length; p++) {
            // Save the current element to be inserted in the right position
            AnyType temp = a[p];
            
            // Move elements greater than temp to the right to make space for temp
            for (j = p; j > 0 && temp.compareTo(a[j - 1]) < 0; j--) {
                a[j] = a[j - 1];
            }
            
            // Insert temp into the correct position in the sorted portion
            a[j] = temp;
        }
    }

    private static <AnyType extends Comparable<? super AnyType>>
    void mergeSort(AnyType[] a, AnyType[] tmpArray, int left, int right) {
        // Check if the array has more than one element
        if (left < right) {
            // Find the middle point of the array
            int center = (left + right) / 2;

            // Recursively divide and sort the left and right halves
            mergeSort(a, tmpArray, left, center);
            mergeSort(a, tmpArray, center + 1, right);

            // Merge the sorted halves
            merge(a, tmpArray, left, center + 1, right);
        }
    }

    public  <AnyType extends Comparable<? super AnyType>>
    void mergeSort(AnyType[] a) {
        // Create a temporary array for merging
        AnyType[] tmpArray = Arrays.copyOf(a, a.length);

        // Call the recursive mergeSort method
        mergeSort(a, tmpArray, 0, a.length - 1);
    }

    private static <AnyType extends Comparable<? super AnyType>>
    void merge(AnyType[] a, AnyType[] tmpArray, int leftPos, int rightPos, int rightEnd) {
        // Determine the end of the left subarray
        int leftEnd = rightPos - 1;
        // Initialize the temporary array position and the number of elements
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        // Merge the two sorted subarrays into the temporary array
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a[leftPos].compareTo(a[rightPos]) <= 0) {
                tmpArray[tmpPos++] = a[leftPos++];
            } else {
                tmpArray[tmpPos++] = a[rightPos++];
            }
        }

        // Copy any remaining elements from the left subarray to the temporary array
        while (leftPos <= leftEnd) {
            tmpArray[tmpPos++] = a[leftPos++];
        }

        // Copy the merged elements from the temporary array back to the original array
        for (int i = 0; i < numElements; i++, rightEnd--) {
            a[rightEnd] = tmpArray[rightEnd];
        }
    }

    public static <AnyType extends Comparable<? super AnyType>>
    void quicksort(AnyType[] a) {
        // Entry point for the quicksort algorithm
        quicksort(a, 0, a.length - 1);
    }

    /**
     * Return median of left, center, and right.
     * Order these and hide the pivot.
     */
    private static <AnyType extends Comparable<? super AnyType>>
        AnyType median3(AnyType[] a, int left, int right) {
        // Calculate the center index
        int center = (left + right) / 2;

        // Order left, center, and right elements
        if (a[center].compareTo(a[left]) < 0) {
            swapReferences(a, left, center);
        }
        if (a[right].compareTo(a[left]) < 0) {
            swapReferences(a, left, right);
        }
        if (a[right].compareTo(a[center]) < 0) {
            swapReferences(a, center, right);
        }

        // Hide the pivot at position right - 1
        swapReferences(a, center, right - 1);

        // Return the pivot value
        return a[right - 1];
    }

    private static <AnyType extends Comparable<? super AnyType>>
        void quicksort(AnyType[] a, int left, int right) {
        // Check if the array size is greater than or equal to the cutoff value
        int CUTOFF = 10;
        if (left + CUTOFF <= right) {
            // Select the pivot using median-of-three
            AnyType pivot = median3(a, left, right);

            // Begin partitioning
            int i = left, j = right - 1;
            for (;;) {
                // Find elements greater and smaller than the pivot
                while (a[++i].compareTo(pivot) < 0) {
                }
                while (a[--j].compareTo(pivot) > 0) {
                }
                if (i < j) {
                    // Swap elements if needed
                    swapReferences(a, i, j);
                } else {
                    break;
                }
            }

            // Restore the pivot to its correct position
            swapReferences(a, i, right - 1);

            // Recursively sort the subarrays
            quicksort(a, left, i - 1);  // Sort small elements
            quicksort(a, i + 1, right); // Sort large elements
        } else {
            // Do an insertion sort on the subarray if it's smaller than the cutoff
            insertionSort(a, left, right);
        }
    }

    private static <AnyType> void swapReferences(AnyType[] array, int index1, int index2) {
        AnyType temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static <AnyType extends Comparable<? super AnyType>> 
    void insertionSort(AnyType[] a, int left, int right) {
    for (int p = left + 1; p <= right; p++) {
        AnyType tmp = a[p];
        int j;

        // Shift elements to the right until the correct position for tmp is found
        for (j = p; j > left && tmp.compareTo(a[j - 1]) < 0; j--) {
            a[j] = a[j - 1];
        }

        // Insert tmp into the correct position
        a[j] = tmp;
    }
}

    

}
