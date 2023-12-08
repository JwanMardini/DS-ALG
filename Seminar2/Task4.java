import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Task4 {
    public static void usingArrayList(int n, int m){
        ArrayList<Integer> arr = getArrayList(n);
        System.out.println(Josephus(arr, 0, m));

    }

    public static void usingArrayListIterator(int n, int m){
        ArrayList<Integer> arr = getArrayList(n);
        System.out.println(JosephusIterator(arr, 0, m));

    }

    public static void usingLinkedList(int n, int m){
        MyLinkedList<Integer> list = getMyLinkedList(n);
        System.out.println(Josephus(list, 0, m));
    }

    public static void usingLinkedListIterator(int n, int m){
        LinkedList<Integer> list = getLinkedList(n);
        System.out.println(JosephusIterator(list, 0, m));

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println();
            System.out.println("Choose data structure: ");
            System.out.println("1. ArrayList");
            System.out.println("2. ArrayList Iterator");
            System.out.println("3. LinkedList");
            System.out.println("4. LinkedList Iterator");
            System.out.println("5. Exit");
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
