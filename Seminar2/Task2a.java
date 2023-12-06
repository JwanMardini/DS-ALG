import java.util.Stack;

public class Task2a {
    // source https://www.geeksforgeeks.org/queue-using-stacks/
    Stack stack1 = new Stack();
    Stack stack2 = new Stack();

    
    public void enqueue(int element) {
        stack1.push(element);
    }

    public int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return (int) stack2.pop();
        } else {
            return (int) stack2.pop();
        }
    }

    public static void main(String[] args) {
        Task2a queue = new Task2a();
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
