import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        quickSortUsingFirstElementPivot();


        /*int[] myArray = {4,6,1,7,3,2,5};
        int[] myArray2 = {4,6,1,7,3,2,5};

        int returnedIndex = QuickSort.pivot(myArray, 0, 6);

        System.out.println( "\nReturned Index: " + returnedIndex); 
        long startTimeIterative = System.nanoTime();
		QuickSort.quickSortIterative(myArray);
        long currentTimeIterative = System.nanoTime();

        long runningTimeIterative = currentTimeIterative - startTimeIterative;
        System.out.println( Arrays.toString( myArray ) );
        System.out.println("Running time for quick sort iterative " + runningTimeIterative);

        System.out.println("**********");

        long startTimeIterative2 = System.nanoTime();
		QuickSort.quickSortRecursive(myArray2);
        long currentTime2 = System.nanoTime();

        long runningTime2 = currentTime2 - startTimeIterative2;
        System.out.println( Arrays.toString( myArray2 ) );
        System.out.println("Running time for quick sort recursive " + runningTime2);*/

    }

    public static int[] fileReader(File file, int elementNum) throws IOException{
        int [] arr = new int[elementNum];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int index = 0;
            while ((line = br.readLine()) != null && index < 100) {
                arr[index++] = Integer.parseInt(line);
            }
        }
        return arr;
    }


    public static void quickSortUsingFirstElementPivot()throws IOException{
        File file = new File("./FileWithRandomNumbers.txt");
        QuickSort qs = new QuickSort();
        long totalRunningTimeIterative = 0;
        long totalRunningTimeRecursion = 0;
        for(int i = 0; i < 10; i++){
            // Iterative
            int[] arr = fileReader(file, 100);
            long startTimeIterative = System.nanoTime();
            qs.quickSortIterative(arr);
            long currentTimeIterative = System.nanoTime();
            long runningTimeIterative = currentTimeIterative - startTimeIterative;
            System.out.println("Running time for iterative quick sort with pivot [0], Iterative " + (i + 1) + ": " + runningTimeIterative);
            System.out.println();
            totalRunningTimeIterative += runningTimeIterative;

            // Recursion
            int[] arrRecur = fileReader(file, 100);
            long startTimeRecursion = System.nanoTime();
            try{
                qs.quickSortRecursive(arrRecur);
                long currentTimeRecursion = System.nanoTime();
                long runningTimeRecursion = currentTimeRecursion - startTimeRecursion;
                System.out.println("Running time for recursion quick sort with pivot [0], iterative " + (i + 1) + ": " + runningTimeRecursion);
                System.out.println();
                totalRunningTimeRecursion += runningTimeRecursion;
            }catch(StackOverflowError e){
                System.out.println("Stack overflow");
                System.out.println();
                
            }
        }
        System.out.println("Avrage running time iterative: " + totalRunningTimeIterative / 10.0);
        System.out.println("Avrage running time recursion: " + totalRunningTimeRecursion / 10.0);

    }
}
