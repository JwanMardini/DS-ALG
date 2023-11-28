import java.util.Arrays;

public class InsertionSort {
    public int counter = 0;
    // Method to perform insertion sort on an array of elements
    public void insertionSortIterative(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }



    public void insertionSortRecursive(int arr[], int n) {
        this.counter++;
        // Base case
        if (n <= 1)
            return;
        // Sort first n-1 elements
        insertionSortRecursive( arr, n-1 );

        int key = arr[n-1];
        int j = n-2;

        while (j >= 0 && arr[j] > key)
        {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = key;
    }

    public int getCounter(){
        return this.counter;
    }




    public static void main(String args[])
    {
        int arr[] = { 12, 11, 8, 5, 6 };

        System.out.println(Arrays.toString(arr));

        InsertionSort ob = new InsertionSort();

        ob.insertionSortRecursive(arr, arr.length);

        System.out.println(Arrays.toString(arr));
    }
}



// Driver Metho
    /*public static void main(String[] args) {
        // Example with Integer array
        Integer[] intArray = {5, 2, 9, 1, 5, 6};
        System.out.println("Original Integer array: " + Arrays.toString(intArray));
        insertionSort(intArray);
        System.out.println("Sorted Integer array: " + Arrays.toString(intArray));

        // Example with String array
        String[] strArray = {"apple", "orange", "banana", "grape", "kiwi"};
        System.out.println("Original String array: " + Arrays.toString(strArray));
        insertionSort(strArray);
        System.out.println("Sorted String array: " + Arrays.toString(strArray));
    }*/
    

