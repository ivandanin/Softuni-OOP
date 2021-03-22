package ValidStudent;

public class Student {

    private String name;
    private String email;

    public Student(String name, String email) {
        this.setName(name);
        setEmail(email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.matches("[A-Za-z]+")) {
        throw new InvalidPersonNameException("Name must contain only letters");
        }
            this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!email.contains("@")) {
        throw new InvalidPersonNameException("Invlaid e-mail");
        }
            this.email = email;
    }
}
