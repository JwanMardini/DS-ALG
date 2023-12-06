public class Contact {
    private String name;
    private String address;

    public Contact(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() { return this.name; }
    public String getAddress() { return this.address; }

    public String toString() {
        return this.name + " lives at " + this.address;
    }
}
