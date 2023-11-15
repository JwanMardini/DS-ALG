public class Searching {
    public static <AnyType extends Comparable<? super AnyType>>
    int linearSearch(AnyType[] arr, AnyType key) {
        for (int i = 0; i < arr.length; i++) {
            if (key.equals(arr[i])) {
                return i; // Return the index where the key is found
            }
        }
        return -1; // Return -1 if the key is not found
    }


    public static <AnyType extends Comparable<? super AnyType>>
    int binarySearch(AnyType[] a, AnyType x) {
        // Initialize low and high indices for the search range
        int low = 0, high = a.length - 1;

        // Continue the search as long as the search range is valid
        while (low <= high) {
            // Calculate the middle index of the current search range
            int mid = (low + high) / 2;

            // Compare the middle element to the target element x
            if (a[mid].compareTo(x) < 0) {
                // If the middle element is less than x, adjust the search range to the right half
                low = mid + 1;
            } else if (a[mid].compareTo(x) > 0) {
                // If the middle element is greater than x, adjust the search range to the left half
                high = mid - 1;
            } else {
                // If the middle element is equal to x, return the index as the target is found
                return mid; // Found
            }
        }

        // If the loop exits, the target element x is not present in the array
        return -1; // Not found
    }
}
