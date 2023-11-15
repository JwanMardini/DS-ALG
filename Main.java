import java.util.Arrays;

public class Main {
    

    public static void main(String[] args) {
        Sorting sort = new Sorting();
        Integer[] arr = {8, 4, 3, 2, 5, 9, 6, 1, 7, 4, 12, 11, 10, 13, 15, 14, 16, 18, 17, 19, 20, 21, 22, 23, 24, 25 };
        System.out.println("Unsorted array: " + Arrays.toString(arr));
        sort.mergeSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));   
    }

    
}
