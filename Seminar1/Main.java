import java.io.*;
//import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    private static final File file = new File("./FileWithRandomNumbers.txt");
    

    public static void main(String[] args) throws IOException {
        /*clearFile("insertionSort.txt");
        clearFile("quickSortMedian3.txt");
        clearFile("quickSortWith1Element.txt");
        clearFile("quickSortRandomPivot.txt");*/
        clearFile("BinarySearch.txt");

        int[] input = {1000, 5000, 10000, 50000, 100000, 500000, 1000000};
        for(int i : input){
            /*System.out.println();
            System.out.println("Input size: " + i);
            quickSortUsingFirstElementPivot(i);
            System.out.println();
            quickSortMedianPivot(i);
            System.out.println();
            quickSortRandomPivot(i);
            System.out.println();
            insertionSort(i);
            System.out.println();*/
            int[] arr = fileReader(file, i);
            binarySearch(arr, 100, i);
        }

    }




    private static int[] fileReader(File file, int elementNum) throws IOException{
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

    private static int[] randomFileReader(File file, int elementNum) throws IOException {
        int[] arr = new int[elementNum];
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r")) {
            for (int i = 0; i < elementNum; i++) {
                long randomPosition = (long) (Math.random() * randomAccessFile.length());
                randomAccessFile.seek(randomPosition);
                String line = randomAccessFile.readLine();
                if (line != null && !line.trim().isEmpty()) {
                    arr[i] = Integer.parseInt(line.trim());
                } else {
                    // Handle the case where the end of the file is reached
                    // or an empty line is encountered
                    i--; // Retry for the current index
                }
            }
        }
        return arr;
    }

    public static void quickSortUsingFirstElementPivot(int input)throws IOException{
        try (PrintWriter fileWriter = new PrintWriter(new BufferedWriter(new FileWriter("quickSortWith1Element.txt", true)))){
            System.out.println("Input size: " + input);
            fileWriter.println("Input size: " + input);
            System.out.println("quickSortUsingFirstElementPivot");
            System.out.printf("%-5s%-25s%-20s%-25s\n", "Run", "Iterative Running Time ", "Recursion Running Time ", "Recursion Status");
            fileWriter.println("quickSortUsingFirstElementPivot");
            fileWriter.printf("%-5s%-25s%-20s%-25s\n", "Run", "Iterative Running Time ", "Recursion Running Time ", "Recursion Status");
            
            long totalRunningTimeIterative = 0;
            long totalRunningTimeRecursion = 0;
            

            for (int i = 0; i < 10; i++) {
                QuickSort qs = new QuickSort();
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

                    System.out.printf("%-5d%-25d%-20d%-25s\n", (i + 1), runningTimeIterative, runningTimeRecursion, "       Success");
                    fileWriter.printf("%-5d%-25d%-20d%-25s\n", (i + 1), runningTimeIterative, runningTimeRecursion, "       Success");

                    totalRunningTimeIterative += runningTimeIterative;
                    totalRunningTimeRecursion += runningTimeRecursion;

                } catch (StackOverflowError e) {
                    System.out.printf("%-5d%-25d%-20s%-25s\n", (i + 1), runningTimeIterative, "", "Stack Overflow");
                    fileWriter.printf("%-5d%-25d%-20s%-25s\n", (i + 1), runningTimeIterative, "", "Stack Overflow");
                }
            }

            System.out.println("Average running time iterative: " + totalRunningTimeIterative / 10.0);
            System.out.println("Average running time recursion: " + totalRunningTimeRecursion / 10.0);
            fileWriter.println("Average running time iterative: " + totalRunningTimeIterative / 10.0);
            fileWriter.println("Average running time recursion: " + totalRunningTimeRecursion / 10.0);
            fileWriter.println();
        }

    }

    public static void quickSortMedianPivot(int input) throws IOException{
        try (PrintWriter fileWriter = new PrintWriter(new BufferedWriter(new FileWriter("quickSortMedian3.txt", true)))){
            System.out.println("Input size: " + input);
            fileWriter.println("Input size: " + input);
            System.out.println("quickSortMedianPivot");
            fileWriter.println("quickSortMedianPivot");

            System.out.printf("%-5s%-25s%-20s%-25s\n", "Run", "Iterative Running Time ", "Recursion Running Time ", "Recursion Status");
            fileWriter.printf("%-5s%-25s%-20s%-25s\n", "Run", "Iterative Running Time ", "Recursion Running Time ", "Recursion Status");

            long totalRunningTimeIterative = 0;
            long totalRunningTimeRecursion = 0;

            for (int i = 0; i < 10; i++) {
                QuickSortMedian3 qs = new QuickSortMedian3();
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

                    System.out.printf("%-5d%-25d%-20d%-25s\n", (i + 1), runningTimeIterative, runningTimeRecursion, "       Success");
                    fileWriter.printf("%-5d%-25d%-20d%-25s\n", (i + 1), runningTimeIterative, runningTimeRecursion, "       Success");

                    totalRunningTimeIterative += runningTimeIterative;
                    totalRunningTimeRecursion += runningTimeRecursion;

                } catch (StackOverflowError e) {
                    System.out.printf("%-5d%-25d%-20s%-25s\n", (i + 1), runningTimeIterative, "", "Stack Overflow");
                    fileWriter.printf("%-5d%-25d%-20s%-25s\n", (i + 1), runningTimeIterative, "", "Stack Overflow");
                }
            }

            System.out.println("Average running time iterative: " + totalRunningTimeIterative / 10.0);
            System.out.println("Average running time recursion: " + totalRunningTimeRecursion / 10.0);
            fileWriter.println("Average running time iterative: " + totalRunningTimeIterative / 10.0);
            fileWriter.println("Average running time recursion: " + totalRunningTimeRecursion / 10.0);
            fileWriter.println();
        }

    }

    public static void quickSortRandomPivot(int input) throws IOException{
        try (PrintWriter fileWriter = new PrintWriter(new BufferedWriter(new FileWriter("quickSortRandomPivot.txt", true)))){
            System.out.println("Input size: " + input);
            fileWriter.println("Input size: " + input);
            System.out.println("quickSortRandomPivot");
            fileWriter.println("quickSortRandomPivot");

            System.out.printf("%-5s%-25s%-20s%-25s\n", "Run", "Iterative Running Time ", "Recursion Running Time ", "Recursion Status");
            fileWriter.printf("%-5s%-25s%-20s%-25s\n", "Run", "Iterative Running Time ", "Recursion Running Time ", "Recursion Status");
            
            long totalRunningTimeIterative = 0;
            long totalRunningTimeRecursion = 0;

            for (int i = 0; i < 10; i++) {
                QuickSortRandomPivot qs = new QuickSortRandomPivot();
                // Iterative
                int[] arr = fileReader(file, input);
                long startTimeIterative = System.currentTimeMillis();
                qs.quickSortIterative(arr);
                long currentTimeIterative = System.currentTimeMillis();
                long runningTimeIterative = currentTimeIterative - startTimeIterative;

                // Recursion
                int[] arrRecur = fileReader(file, input);
                long startTimeRecursion = System.currentTimeMillis();
                try {
                    qs.quickSortRec(arrRecur);
                    long currentTimeRecursion = System.currentTimeMillis();
                    long runningTimeRecursion = currentTimeRecursion - startTimeRecursion;

                    System.out.printf("%-5d%-25d%-20d%-25s\n", (i + 1), runningTimeIterative, runningTimeRecursion, "       Success");
                    fileWriter.printf("%-5d%-25d%-20d%-25s\n", (i + 1), runningTimeIterative, runningTimeRecursion, "       Success");

                    totalRunningTimeIterative += runningTimeIterative;
                    totalRunningTimeRecursion += runningTimeRecursion;

                } catch (StackOverflowError e) {
                    System.out.printf("%-5d%-25d%-20s%-25s\n", (i + 1), runningTimeIterative, "", "Stack Overflow");
                    fileWriter.printf("%-5d%-25d%-20s%-25s\n", (i + 1), runningTimeIterative, "", "Stack Overflow");
                }
            }

            System.out.println("Average running time iterative: " + totalRunningTimeIterative / 10.0);
            System.out.println("Average running time recursion: " + totalRunningTimeRecursion / 10.0);
            fileWriter.println("Average running time iterative: " + totalRunningTimeIterative / 10.0);
            fileWriter.println("Average running time recursion: " + totalRunningTimeRecursion / 10.0);
            fileWriter.println();
        }
    }

    public static void insertionSort(int input) throws IOException{
        try (PrintWriter fileWriter = new PrintWriter(new BufferedWriter(new FileWriter("insertionSort.txt", true)))){
            System.out.println("Input size: " + input);
            fileWriter.println("Input size: " + input);
            System.out.println("insertionSort");
            System.out.printf("%-5s%-25s%-20s%-25s\n", "Run", "Iterative Running Time ", "Recursion Running Time ", "Recursion Status");
            fileWriter.println("insertionSort");
            fileWriter.printf("%-5s%-25s%-20s%-25s\n", "Run", "Iterative Running Time ", "Recursion Running Time ", "Recursion Status");

            
            long totalRunningTimeIterative = 0;
            long totalRunningTimeRecursion = 0;

            for (int i = 0; i < 10; i++) {
                InsertionSort is = new InsertionSort();
                // Iterative
                int[] arr = fileReader(file, input);
                long startTimeIterative = System.currentTimeMillis();
                is.insertionSortIterative(arr);
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

                    System.out.printf("%-5d%-25d%-20d%-25s\n", (i + 1), runningTimeIterative, runningTimeRecursion, "       Success");
                    fileWriter.printf("%-5d%-25d%-20d%-25s\n", (i + 1), runningTimeIterative, runningTimeRecursion, "       Success");

                } catch (StackOverflowError e) {
                    System.out.printf("%-5d%-25d%-20s%-25s\n", (i + 1), runningTimeIterative, "", "Stack Overflow");
                    fileWriter.printf("%-5d%-25d%-20s%-25s\n", (i + 1), runningTimeIterative, "", "Stack Overflow");
                }
                totalRunningTimeIterative += runningTimeIterative;
                totalRunningTimeRecursion += runningTimeRecursion;
                System.out.println("Recursions counter: " + is.getCounter());
            }

            System.out.println("Average running time iterative: " + totalRunningTimeIterative / 10.0);
            System.out.println("Average running time recursion: " + totalRunningTimeRecursion / 10.0);
            

            fileWriter.println("Average running time iterative: " + totalRunningTimeIterative / 10.0);
            fileWriter.println("Average running time recursion: " + totalRunningTimeRecursion / 10.0);
            fileWriter.println();
            
        }

    }


    public static boolean binarySearch(int[] arr, int num, int input) throws IOException{
        boolean search = false;
        try (PrintWriter fileWriter = new PrintWriter(new BufferedWriter(new FileWriter("BinarySearch.txt", true)))){

            long totalRunningTime = 0;
            int low = arr[0];
            int high = arr[arr.length - 1];
            for (int i = 0; i < 10; i++) {
                BinarySearch bs = new BinarySearch();
                QuickSortMedian3 qs = new QuickSortMedian3();
                qs.quickSortIterativeWithMedian3Pivot(arr);
                long startTime = System.nanoTime();
                search = bs.binarySearch(arr, low, high, num) == -1;
                long currentTime = System.nanoTime();
                long runningTime = currentTime - startTime;
                totalRunningTime += runningTime;
            }

            System.out.println("Input size: " + input);
            fileWriter.println("Input size: " + input);
            System.out.println("Number to search: " + num);
            fileWriter.println("Number to search: " + num);
            System.out.println("Average searching time: " + totalRunningTime/10.0);
            fileWriter.println("Average searching time: " + totalRunningTime/10.0);


            if (search) {
                System.out.println("Not Found");
                fileWriter.println("Not Found");
                System.out.println();
                fileWriter.println();

            } else {
                System.out.println("Found");
                fileWriter.println("Found");
                System.out.println();
                fileWriter.println();

            }
            return search;
        }

    }



    private static void clearFile(String fileName) throws IOException {
        try (PrintWriter fileWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName, false)))) {
            // Truncate the file, effectively clearing its content
        }
    }




    private static Integer[] intArrayToIntegerArray(int[] intArray) {
    return IntStream.of(intArray)
                    .boxed() // Convert int to Integer (autoboxing)
                    .toArray(Integer[]::new);
}
}
