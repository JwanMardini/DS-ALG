import java.util.Arrays;

public class Main {
        public static void main(String[] args) {
        

        int[] myArray = {4,6,1,7,3,2,5};
        int[] myArray2 = {4,6,1,7,3,2,5};

/*         int returnedIndex = QuickSort.pivot(myArray, 0, 6);

        System.out.println( "\nReturned Index: " + returnedIndex); */
        long startTime = System.nanoTime();
		QuickSort.quickSortIterative(myArray);
        long currentTime = System.nanoTime();

        long runningTime = currentTime - startTime;
        System.out.println( Arrays.toString( myArray ) );
        System.out.println("Running time for quick sort iterative " + runningTime);

        System.out.println("**********");

        long startTime2 = System.nanoTime();
		QuickSort.quickSortRecursive(myArray2);
        long currentTime2 = System.nanoTime();

        long runningTime2 = currentTime2 - startTime2;
        System.out.println( Arrays.toString( myArray2 ) );
        System.out.println("Running time for quick sort recursive " + runningTime2);

        /*
            EXPECTED OUTPUT:
            ----------------
            Returned Index: 3
            [2, 1, 3, 4, 6, 7, 5]

         */

    }
    
    
}
