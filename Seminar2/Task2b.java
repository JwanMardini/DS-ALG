import java.util.Stack;

public class Task2b {
    // source https://www.geeksforgeeks.org/queue-using-stacks/
    Stack stack = new Stack();

    public void enqueue(int element) {
        stack.push(element);
    }

    public int dequeue() {
        if (stack.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else if (stack.size() == 1) {
            return (int) stack.pop();
        } else {
            int temp = (int) stack.pop();
            int result = dequeue();
            stack.push(temp);
            return result;
        }
    }

    public static void main(String[] args) {
        Task2b queue = new Task2b();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(4);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
    
}
