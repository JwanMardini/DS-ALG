import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.IntStream;

public class Main {
    private static File file = new File("./FileWithRandomNumbers.txt");
    

    public static void main(String[] args) throws IOException {
        int[] input = {100, 1000, 10000, 100000};
        int counter = 0;
        for(int i : input){
            System.out.println();
            System.out.println("Input size: " + input[counter]);
            counter++;
            quickSortUsingFirstElementPivot(i);
            System.out.println();
            insertionSort(i);
            System.out.println();
            quickSortMedianPivot(i);
        }
    }




    public static int[] fileReader(File file, int elementNum) throws IOException{
        int [] arr = new int[elementNum];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int index = 0;
            while ((line = br.readLine()) != null && index < elementNum) {
                arr[index++] = Integer.parseInt(line);
            }
        }
        return arr;
    }


    public static void quickSortUsingFirstElementPivot(int input)throws IOException{
        System.out.println("quickSortUsingFirstElementPivot");
        System.out.printf("%-5s%-25s%-20s%-25s\n", "Run", "Iterative Running Time", "Recursion Running Time", "Recursion Status");
        
        QuickSort qs = new QuickSort();
        long totalRunningTimeIterative = 0;
        long totalRunningTimeRecursion = 0;
        

        for (int i = 0; i < 10; i++) {
            // Iterative
            int[] arr = fileReader(file, input);
            long startTimeIterative = System.currentTimeMillis();
            qs.quickSortIterativeWithFirstElementPivot(arr);
            long currentTimeIterative = System.currentTimeMillis();
            long runningTimeIterative = currentTimeIterative - startTimeIterative;

            // Recursion
            int[] arrRecur = fileReader(file, input);
            long startTimeRecursion = System.currentTimeMillis();
            try {
                qs.quickSortRecursiveWithFirstElementPivot(arrRecur);
                long currentTimeRecursion = System.currentTimeMillis();
                long runningTimeRecursion = currentTimeRecursion - startTimeRecursion;

                System.out.printf("%-5d%-25d%-20d%-25s\n", (i + 1), runningTimeIterative, runningTimeRecursion, "Success");

                totalRunningTimeIterative += runningTimeIterative;
                totalRunningTimeRecursion += runningTimeRecursion;

            } catch (StackOverflowError e) {
                System.out.printf("%-5d%-25d%-20s%-25s\n", (i + 1), runningTimeIterative, "", "Stack Overflow");
            }
        }

        System.out.println("Average running time iterative: " + totalRunningTimeIterative / 10.0);
        System.out.println("Average running time recursion: " + totalRunningTimeRecursion / 10.0);

    }

    public static void quickSortMedianPivot(int input) throws IOException{
        System.out.println("quickSortMedianPivot");
        System.out.printf("%-5s%-25s%-20s%-25s\n", "Run", "Iterative Running Time", "Recursion Running Time", "Recursion Status");

        QuickSortMedian3 qs = new QuickSortMedian3();
        long totalRunningTimeIterative = 0;
        long totalRunningTimeRecursion = 0;

        for (int i = 0; i < 10; i++) {
            // Iterative
            int[] arr = fileReader(file, input);
            long startTimeIterative = System.currentTimeMillis();
            qs.quickSortIterativeWithMedian3Pivot(arr);
            long currentTimeIterative = System.currentTimeMillis();
            long runningTimeIterative = currentTimeIterative - startTimeIterative;

            // Recursion
            int[] arrRecur = fileReader(file, input);
            long startTimeRecursion = System.currentTimeMillis();
            try {
                qs.quickSortRecursiveWithMedian3Pivot(arrRecur);
                long currentTimeRecursion = System.currentTimeMillis();
                long runningTimeRecursion = currentTimeRecursion - startTimeRecursion;

                System.out.printf("%-5d%-25d%-20d%-25s\n", (i + 1), runningTimeIterative, runningTimeRecursion, "Success");

                totalRunningTimeIterative += runningTimeIterative;
                totalRunningTimeRecursion += runningTimeRecursion;

            } catch (StackOverflowError e) {
                System.out.printf("%-5d%-25d%-20s%-25s\n", (i + 1), runningTimeIterative, "", "Stack Overflow");
            }
        }

        System.out.println("Average running time iterative: " + totalRunningTimeIterative / 10.0);
        System.out.println("Average running time recursion: " + totalRunningTimeRecursion / 10.0);

    }


    public static void insertionSort(int input) throws IOException{
        System.out.println("insertionSort");
        System.out.printf("%-5s%-25s%-20s%-25s\n", "Run", "Iterative Running Time", "Recursion Running Time", "Recursion Status");

        InsertionSort is = new InsertionSort();
        long totalRunningTimeIterative = 0;
        long totalRunningTimeRecursion = 0;

        for (int i = 0; i < 10; i++) {
            // Iterative
            int[] arr = fileReader(file, input);
            Integer[] arr2 = intArrayToIntegerArray(arr);
            long startTimeIterative = System.currentTimeMillis();
            is.insertionSort(arr2);
            long currentTimeIterative = System.currentTimeMillis();
            long runningTimeIterative = currentTimeIterative - startTimeIterative;

            // Recursion
            int[] arrRecur = fileReader(file, input);
            long runningTimeRecursion = 0;
            long startTimeRecursion = System.currentTimeMillis();
            try {
                is.insertionSortRecursive(arrRecur, arrRecur.length);
                long currentTimeRecursion = System.currentTimeMillis();
                runningTimeRecursion = currentTimeRecursion - startTimeRecursion;

                System.out.printf("%-5d%-25d%-20d%-25s\n", (i + 1), runningTimeIterative, runningTimeRecursion, "Success");

            } catch (StackOverflowError e) {
                System.out.printf("%-5d%-25d%-20s%-25s\n", (i + 1), runningTimeIterative, "", "Stack Overflow");
            }
            totalRunningTimeIterative += runningTimeIterative;
            totalRunningTimeRecursion += runningTimeRecursion;
        }

        System.out.println("Average running time iterative: " + totalRunningTimeIterative / 10.0);
        System.out.println("Average running time recursion: " + totalRunningTimeRecursion / 10.0);

    }







    public static Integer[] intArrayToIntegerArray(int[] intArray) {
    return IntStream.of(intArray)
                    .boxed() // Convert int to Integer (autoboxing)
                    .toArray(Integer[]::new);
}
}
