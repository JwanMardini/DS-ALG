public class QuickSort {
    // Java program for implementation of QuickSort  
	/* This function takes last element as pivot, 
	places the pivot element at its correct 
	position in sorted array, and places all 
	smaller (smaller than pivot) to left of 
	pivot and all greater elements to right 
	of pivot */
	private static int partition(int arr[], int low, int high) 
	{ 
		int pivot = arr[high]; 
		int i = (low - 1); // index of smaller element 
		for (int j = low; j <= high - 1; j++) { 
			// If current element is smaller than or 
			// equal to pivot 
			if (arr[j] <= pivot) { 
				i++; 

				// swap arr[i] and arr[j] 
				int temp = arr[i]; 
				arr[i] = arr[j]; 
				arr[j] = temp; 
			} 
		} 

		// swap arr[i+1] and arr[high] (or pivot) 
		int temp = arr[i + 1]; 
		arr[i + 1] = arr[high]; 
		arr[high] = temp; 

		return i + 1; 
	} 

	/* The main function that implements QuickSort() 
	arr[] --> Array to be sorted, 
	low --> Starting index, 
	high --> Ending index */
	public void qSort(int arr[], int low, int high) 
	{ 
		if (low < high) { 
			/* pi is partitioning index, arr[pi] is 
			now at right place */
			int pi = partition(arr, low, high); 

			// Recursively sort elements before 
			// partition and after partition 
			qSort(arr, low, pi - 1); 
			qSort(arr, pi + 1, high); 
		} 
	}

     /* A[] --> Array to be sorted,  
   l  --> Starting index,  
   h  --> Ending index */
    public void quickSortIterative(int arr[], int l, int h) { 
       // Create an auxiliary stack 
       int[] stack = new int[h - l + 1]; 
 
       // initialize top of stack 
       int top = -1; 
 
       // push initial values of l and h to stack 
       stack[++top] = l; 
       stack[++top] = h; 
 
       // Keep popping from stack while is not empty 
       while (top >= 0) { 
           // Pop h and l 
           h = stack[top--]; 
           l = stack[top--]; 
 
           // Set pivot element at its correct position 
           // in sorted array 
           int p = partition(arr, l, h); 
 
           // If there are elements on left side of pivot, 
           // then push left side to stack 
           if (p - 1 > l) { 
               stack[++top] = l; 
               stack[++top] = p - 1; 
           } 
 
           // If there are elements on right side of pivot, 
           // then push right side to stack 
           if (p + 1 < h) { 
               stack[++top] = p + 1; 
               stack[++top] = h; 
           } 
       } 
   }

   /*public static void main(String args[]) 
   { 
       int arr[] = { 4, 3, 5, 2, 1, 3, 2, 3 }; 
       int n = 8; 
 
       // Function calling 
       quickSortIterative(arr, 0, n - 1); 
 
       for (int i = 0; i < n; i++) { 
           System.out.print(arr[i] + " "); 
       } 
   }*/




	// Driver code 
	/*public static void main(String args[]) 
	{ 

		int n = 5; 
		int arr[] = { 4, 2, 6, 9, 2 }; 

		qSort(arr, 0, n - 1); 

		for (int i = 0; i < n; i++) { 
			System.out.print(arr[i] + " "); 
		} 
	}*/
}
