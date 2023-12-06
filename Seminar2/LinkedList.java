public class LinkedList {
    private Node head;
    private Node tail;
    private int length;


    public class Node {
        public int value;
        public Node next;
        
        public Node(int value) {
            this.value = value;
        }
        
    }
    

    public LinkedList(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(int value){
        Node newNode = new Node(value);
        if (length == 0){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public void prepend (int value){
        Node newNode = new Node(value);
        if (length == 0){
            head = newNode;
            tail = newNode;
        }else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst(){
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) tail = null;
        return temp;
    }

    public Node removeLast(){
        if (length == 0) return null;
        if (length == 1) return removeFirst();
        Node temp = head;
        Node prev = head;
        while(temp.next != null){
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        tail = prev;
        length--;
        return temp;
    }


    public Node remove(int index){
        if(index < 0 || index >= length) return null;
        if (index == 0) return removeLast();
        if (index == length -1) return removeLast();
        Node prev = get(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }
    
    public Node get(int index){
        if(index < 0 || index >= length) return null;
        Node temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value){
        Node temp = get(index);
        if (temp != null){
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value){
        if(index < 0 || index >= length) return false;
        if (index == 0){
            prepend(value);
            return true;
        }
        if (index == length - 1){
            append(value);
            return true;
        }
        Node temp = get(index - 1);
        Node newNode = new Node(value);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }
    
        


    public void getTail(){
        System.out.println(this.tail.value);
    }

    public void getHead(){
        System.out.println(this.head.value);
    }

    public void getLength(){
        System.out.println(this.length);
    }
}
