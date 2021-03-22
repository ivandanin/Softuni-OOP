package ValidStudent;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        String email = scan.nextLine();

        try {
            Student student = new Student(name,email);
        }catch (InvalidPersonNameException exception){
            System.out.println(exception.getMessage());
        }
    }
}
