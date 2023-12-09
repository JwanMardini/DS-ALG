import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Task4 {
    public static void usingArrayList(int n, int m){
        ArrayList<Integer> arr = getArrayList(n);
        long startTime = System.nanoTime();
        System.out.println(Josephus(arr, 0, m));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000;
        System.out.println("ArrayList: " + duration + " nanoseconds");

    }

    public static void usingArrayListIterator(int n, int m){
        ArrayList<Integer> arr = getArrayList(n);
        long startTime = System.nanoTime();
        System.out.println(JosephusIterator(arr, 0, m));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000;
        System.out.println("ArrayList Iterator: " + duration + " nanoseconds");

    }

    public static void usingLinkedList(int n, int m){
        MyLinkedList<Integer> list = getMyLinkedList(n);
        long startTime = System.nanoTime();
        System.out.println(Josephus(list, 0, m));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000;
        System.out.println("LinkedList: " + duration + " nanoseconds");
    }

    public static void usingLinkedListIterator(int n, int m){
        LinkedList<Integer> list = getLinkedList(n);
        long startTime = System.nanoTime();
        System.out.println(JosephusIterator(list, 0, m));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000;
        System.out.println("LinkedList Iterator: " + duration + " nanoseconds");

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
                                  long runningTimeLi, long runningTimeLiIt) throws IOException {
        String filePath = "output.txt";
        bw.write("n = " + n + ", m = " + m + "\n");
        bw.write("ArrayList: " + runningTimeAr + " nanoseconds\n");
        bw.write("ArrayList Iterator: " + runningTimeArIt + " nanoseconds\n");
        bw.write("LinkedList: " + runningTimeLi + " nanoseconds\n");
        bw.write("LinkedList Iterator: " + runningTimeLiIt + " nanoseconds\n");
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
            System.out.println("5. Test all with an input array");
            System.out.println("6. Exit");
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

                    Integer[] mArr = {10, 100, 1000};
                    String filePath = "output.txt";
                    try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                        for (int i = 0; i < nArr.length; i++) {
                            System.out.println("n = " + nArr[i]);
                            for (int j = 0; j < mArr.length; j++) {
                                System.out.println("m = " + mArr[j]);
                                long startTime = System.nanoTime();
                                usingArrayList(nArr[i], mArr[j]);
                                long endTime = System.nanoTime();
                                long durationAr = (endTime - startTime) / 1000;

                                long startTime1 = System.nanoTime();
                                usingArrayListIterator(nArr[i], mArr[j]);
                                long endTime1 = System.nanoTime();
                                long durationArIt = (endTime1 - startTime1) / 1000;

                                long startTime2 = System.nanoTime();
                                usingLinkedList(nArr[i], mArr[j]);
                                long endTime2 = System.nanoTime();
                                long durationLi = (endTime2 - startTime2) / 1000;

                                long startTime3 = System.nanoTime();
                                usingLinkedListIterator(nArr[i], mArr[j]);
                                long endTime3 = System.nanoTime();
                                long durationLiIt = (endTime3 - startTime3) / 1000;

                                fileWriter(bw, nArr[i], mArr[j], durationAr, durationArIt, durationLi, durationLiIt);
                            }
                            System.out.println();

                        }
                    }
                    System.out.println("see output.txt");

                case 6:
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
