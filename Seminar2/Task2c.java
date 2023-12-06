import java.util.LinkedList;
import java.util.Queue;

public class Task2c {
    // source https://www.geeksforgeeks.org/stack-using-queue/
    static Queue queue1 = new LinkedList<>();
    static Queue queue2 = new LinkedList<>();

    public void push(int element) {
        queue2.add(element);
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }
        Queue temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        if (queue1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return (int) queue1.remove();
        }
    }

    public int top() {
        if (queue1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return (int) queue1.peek();
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
