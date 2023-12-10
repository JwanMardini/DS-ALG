import java.util.LinkedList;
import java.util.Queue;

public class Task2c {
    static Queue queue1 = new LinkedList<>();
    static Queue queue2 = new LinkedList<>();

    public void push(int element) {
        queue2.add(element); // add to queue2
        while (!queue1.isEmpty()) { // move all elements from queue1 to queue2
            queue2.add(queue1.remove()); // remove from queue1 and add to queue2
        }
        Queue temp = queue1; // swap queue1 and queue2
        queue1 = queue2; // queue1 is now queue2
        queue2 = temp;// queue2 is now queue1
    }

    public int pop() {
        if (queue1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return (int) queue1.remove(); // remove from queue1
        }
    }

    public int top() {
        if (queue1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return (int) queue1.peek(); // peek from queue1
        }
    }

    public static void main(String[] args) {
        Task2c stack = new Task2c();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    
}
