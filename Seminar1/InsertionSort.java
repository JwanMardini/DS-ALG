public class InsertionSort {
    public int counter = 0;
    // Method to perform insertion sort on an array of elements
    public <AnyType extends Comparable<? super AnyType>>
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



    public void insertionSortRecursive(int arr[], int n) { 
        this.counter++;
        // Base case 
        if (n <= 1) 
            return; 
       
        // Sort first n-1 elements 
        insertionSortRecursive( arr, n-1 ); 
       
        // Insert last element at its correct position 
        // in sorted array. 
        int last = arr[n-1]; 
        int j = n-2; 
       
        /* Move elements of arr[0..i-1], that are 
          greater than key, to one position ahead 
          of their current position */
        while (j >= 0 && arr[j] > last) 
        { 
            arr[j+1] = arr[j]; 
            j--; 
        } 
        arr[j+1] = last; 
    }

    public int getCounter(){
        return this.counter;
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
    

