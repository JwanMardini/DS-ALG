import java.util.LinkedList;
import java.util.Queue;

public class Task2d {
    // source https://www.geeksforgeeks.org/stack-using-queue/
    Queue<Integer> queue = new LinkedList<>();

    public void push(int element) {
        System.out.println("Pushing element: " + element);
        queue.add(element);

        int s = queue.size();
        for (int i = 0; i < s - 1; i++) {
            queue.add(queue.remove());
        }
        System.out.println("After push, queue: " + queue);
    }

    public int pop() {
        if (queue.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            int poppedElement = queue.remove();
            System.out.println("Popping element: " + poppedElement);
            return poppedElement;
        }
    }

    public int top() {
        if (queue.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            int topElement = queue.peek();
            System.out.println("Top element: " + topElement);
            return topElement;
        }
    }

    public static void main(String[] args) {
        Task2d stack = new Task2d();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Top element: " + stack.top());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
        stack.push(4);
        System.out.println("Top element: " + stack.top());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
    }
}
