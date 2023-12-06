public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int length;

    public class Node<T> {
        public T value;
        public Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    public LinkedList(T value) {
        Node<T> newNode = new Node<>(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void printList() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(T value) {
        Node<T> newNode = new Node<>(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public void prepend(T value) {
        Node<T> newNode = new Node<>(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node<T> removeFirst() {
        if (length == 0) return null;
        Node<T> temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) tail = null;
        return temp;
    }

    public Node<T> removeLast() {
        if (length == 0) return null;
        if (length == 1) return removeFirst();
        Node<T> temp = head;
        Node<T> prev = head;
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        tail = prev;
        length--;
        return temp;
    }

    public Node<T> remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();
        Node<T> prev = get(index - 1);
        Node<T> temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public Node<T> get(int index) {
        if (index < 0 || index >= length) return null;
        Node<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, T value) {
        Node<T> temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, T value) {
        if (index < 0 || index >= length) return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length - 1) {
            append(value);
            return true;
        }
        Node<T> temp = get(index - 1);
        Node<T> newNode = new Node<>(value);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public void getTail() {
        if (this.tail == null) return;
        else System.out.println(this.tail.value);
    }

    public void getHead() {
        if (this.head == null) return;
        else System.out.println(this.head.value);
    }

    public void getLength() {
        System.out.println(this.length);
    }
}
