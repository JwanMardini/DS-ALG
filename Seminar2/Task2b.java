import java.util.Stack;

public class Task2b {
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
            int temp = (int) stack.pop(); // store the last element
            int result = dequeue(); // dequeue the rest of the elements
            stack.push(temp);// push the last element back
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
