package ValidPerson;

public class Main {
    public static void main(String[] args) {

        try {
            Person person = new Person("  ", "Alice", 19);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception thrown: " + e.getMessage());
        }
    }
}
