import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Task4 {
    public static Integer usingArrayList(int n, int m){
        ArrayList<Integer> arr = getArrayList(n);
        long startTime = System.nanoTime();
        Integer result = Josephus(arr, 0, m);
        System.out.println(result);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000;
        System.out.println("ArrayList: " + duration + " nanoseconds");
        return result;
    }

    public static Integer usingArrayListIterator(int n, int m){
        ArrayList<Integer> arr = getArrayList(n);
        long startTime = System.nanoTime();
        Integer result = JosephusIterator(arr, 0, m);
        System.out.println(result);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("ArrayList Iterator: " + duration + " nanoseconds");
        return result;
    }

    public static Integer usingLinkedList(int n, int m){
        MyLinkedList<Integer> list = getMyLinkedList(n);
        long startTime = System.nanoTime();
        Integer result = Josephus(list, 0, m);
        System.out.println(result);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("LinkedList: " + duration + " nanoseconds");
        return result;
    }

    public static Integer usingLinkedListIterator(int n, int m){
        LinkedList<Integer> list = getLinkedList(n);
        long startTime = System.nanoTime();
        Integer result = JosephusIterator(list, 0, m);
        System.out.println(result);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("LinkedList Iterator: " + duration + " nanoseconds");
        return result;

    }

    public static ArrayList<Integer> getArrayList(int n){
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            arr.add(i);
        }
        return arr;
    }

    public static LinkedList<Integer> getLinkedList(int n){
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++){
            list.add(i);
        }
        return list;
    }

    public static MyLinkedList<Integer> getMyLinkedList(int n){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 1; i <= n; i++){
            list.append(i);
        }
        return list;
    }

    public static Integer Josephus(ArrayList<Integer> list, int start, int m){
        if (list.size() == 1) return list.get(0);
        int index = (start + m) % list.size();
        list.remove(index);
        return Josephus(list, index, m);
    }

    public static Integer JosephusIterator(ArrayList<Integer> list, int start, int m){
        ListIterator<Integer> iterator = list.listIterator();
        if (list.size() == 1) return list.get(0);
        int index = (start + m) % list.size(); // get index of element to be removed by adding m to start and modding by size of list
        int i = 0;
        while (iterator.hasNext()){
            iterator.next(); // move to next element
            if (i == index){ // if index is found
                iterator.remove(); // remove element
                break; // break out of loop when element is removed
            }
            i++;
        }
        return JosephusIterator(list, index, m);
    }
    public static Integer Josephus(MyLinkedList<Integer> list, int start, int m){
        if (list.getLength() == 1) return (Integer) list.getHead().value;
        int index = (start + m) % list.getLength();
        list.remove(index);
        return Josephus(list, index, m);
    }

    public static Integer JosephusIterator(LinkedList<Integer> list, int start, int m){
        ListIterator<Integer> iterator = list.listIterator();
        if (list.size() == 1) return (Integer) list.get(0);
        int index = (start + m) % list.size();
        int i = 0;
        while (iterator.hasNext()){
            iterator.next();
            if (i == index){
                iterator.remove();
                break;
            }
            i++;
        }
        return JosephusIterator(list, index, m);
    }

    public static void fileWriter(BufferedWriter bw, Integer n, Integer m, long runningTimeAr, long runningTimeArIt,
                                  long runningTimeLi, long runningTimeLiIt, Integer winner) throws IOException {
        String filePath = "output.txt";
        bw.write("n = " + n + ", m = " + m + "\n");
        bw.write("ArrayList: " + runningTimeAr + " nanoseconds\n");
        bw.write("ArrayList Iterator: " + runningTimeArIt + " nanoseconds\n");
        bw.write("LinkedList: " + runningTimeLi + " nanoseconds\n");
        bw.write("LinkedList Iterator: " + runningTimeLiIt + " nanoseconds\n");
        bw.write("Winner: " + winner + "\n");
        bw.write("\n");
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println();
            System.out.println("Choose data structure: ");
            System.out.println("1. ArrayList");
            System.out.println("2. ArrayList Iterator");
            System.out.println("3. LinkedList");
            System.out.println("4. LinkedList Iterator");
            System.out.println("5. Different n and m = 1");
            System.out.println("6. n = 10000, Different m");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter n: ");
                    int n = scanner.nextInt();
                    System.out.print("Enter m: ");
                    int m = scanner.nextInt();
                    usingArrayList(n, m);
                    break;
                case 2:
                    System.out.print("Enter n: ");
                    n = scanner.nextInt();
                    System.out.print("Enter m: ");
                    m = scanner.nextInt();
                    usingArrayListIterator(n, m);
                    break;
                case 3:
                    System.out.print("Enter n: ");
                    n = scanner.nextInt();
                    System.out.print("Enter m: ");
                    m = scanner.nextInt();
                    usingLinkedList(n, m);
                    break;
                case 4:
                    System.out.print("Enter n: ");
                    n = scanner.nextInt();
                    System.out.print("Enter m: ");
                    m = scanner.nextInt();
                    usingLinkedListIterator(n, m);
                    break;
                case 5:
                    Integer[] nArr = {1000, 1500, 2000, 2500, 3000, 3500, 4000, 4500
                            , 5000, 5500, 6000, 6500, 7000, 7500, 8000, 8500, 9000, 9500, 10000, 15000, 20000, 25000, 30000
                            , 35000, 40000, 45000, 50000, 55000, 60000, 65000, 70000, 75000, 80000, 85000, 90000, 95000, 100000};

                    Integer steps = 1;
                    String filePath = "output.txt";
                    try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                        for (int i = 0; i < nArr.length; i++) {
                            long startTime = System.nanoTime();
                            Integer result = usingArrayList(nArr[i], steps);
                            long endTime = System.nanoTime();
                            long runningTimeAr = (endTime - startTime);

                            startTime = System.nanoTime();
                            usingArrayListIterator(nArr[i], steps);
                            endTime = System.nanoTime();
                            long runningTimeArIt = (endTime - startTime);

                            startTime = System.nanoTime();
                            usingLinkedList(nArr[i], steps);
                            endTime = System.nanoTime();
                            long runningTimeLi = (endTime - startTime);

                            startTime = System.nanoTime();
                            usingLinkedListIterator(nArr[i], steps);
                            endTime = System.nanoTime();
                            long runningTimeLiIt = (endTime - startTime);

                            fileWriter(bw, nArr[i], steps, runningTimeAr, runningTimeArIt, runningTimeLi, runningTimeLiIt, result);

                        }
                    }
                    System.out.println("see output.txt");
                case 6:
                    n = 10000;
                    Integer[] mArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
                    filePath = "output2.txt";

                    try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                        for (int i = 0; i < mArr.length; i++) {
                            long startTime = System.nanoTime();
                            Integer result = usingArrayList(n, mArr[i]);
                            long endTime = System.nanoTime();
                            long runningTimeAr = (endTime - startTime);

                            startTime = System.nanoTime();
                            usingArrayListIterator(n, mArr[i]);
                            endTime = System.nanoTime();
                            long runningTimeArIt = (endTime - startTime);

                            startTime = System.nanoTime();
                            usingLinkedList(n, mArr[i]);
                            endTime = System.nanoTime();
                            long runningTimeLi = (endTime - startTime);

                            startTime = System.nanoTime();
                            usingLinkedListIterator(n, mArr[i]);
                            endTime = System.nanoTime();
                            long runningTimeLiIt = (endTime - startTime);

                            fileWriter(bw, n, mArr[i], runningTimeAr, runningTimeArIt, runningTimeLi, runningTimeLiIt, result);

                        }
                    }
                    System.out.println("see output2.txt");

                case 7:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
        /*int n = 50;
        int m = 6;
        long startTime = System.nanoTime();
        usingArrayList(n, m);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000;
        System.out.println("ArrayList: " + duration + " nanoseconds");

        startTime = System.nanoTime();
        usingArrayListIterator(n, m);
        endTime = System.nanoTime();
        duration = (endTime - startTime)/1000;
        System.out.println("ArrayList Iterator: " + duration + " nanoseconds");

        startTime = System.nanoTime();
        usingLinkedList(n, m);
        endTime = System.nanoTime();
        duration = (endTime - startTime)/1000;
        System.out.println("LinkedList: " + duration + " nanoseconds");

        startTime = System.nanoTime();
        usingLinkedListIterator(n, m);
        endTime = System.nanoTime();
        duration = (endTime - startTime)/1000;
        System.out.println("LinkedList Iterator: " + duration + " nanoseconds");*/

    }

}
