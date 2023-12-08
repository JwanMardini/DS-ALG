public class Task3 {
    public static void main(String[] args) {
        MyLinkedList<Contact> contacts = new MyLinkedList<>();
        Contact c1 = new Contact("Ahmed", "Kristianstad");
        Contact c2 = new Contact("Alloush", "Malmö");
        Contact c3 = new Contact("Abshir", "GBG");
        contacts.append(c1);
        contacts.append(c2);
        contacts.append(c3);
        contacts.printList();
        System.out.println();

        System.out.println("Removing first contact");
        contacts.removeFirst();
        contacts.printList();
        System.out.println();

        System.out.println("Prepending a new contact");
        Contact c4 = new Contact("Abdul", "Lund");
        contacts.prepend(c4);
        contacts.printList();
        System.out.println();

        System.out.println("Removing last contact");
        contacts.removeLast();
        contacts.printList();
        System.out.println();

        System.out.println("Get node using index 1");
        System.out.println(contacts.get(1).value.toString());
        System.out.println();

        System.out.println("Inserting a new contact at index 1");
        Contact c5 = new Contact("Lolo", "Stockholm");
        contacts.insert(1, c5);
        contacts.printList();
        System.out.println();
    }
    
}
