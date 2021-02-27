package ValidationData;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;
    private double percentBonus;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.percentBonus = percentBonus;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().length() < 3) {
            throw new IllegalStateException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().length() < 3) {
        throw new IllegalStateException("Last name cannot be less than 3 symbols");
    }
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalStateException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 460) {
            throw new IllegalStateException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    public double getPercentBonus() {
        return percentBonus;
    }

    public void setPercentBonus(double percentBonus) {
        this.percentBonus = percentBonus;
    }


    public String toString() {
        return String.format("%s %s gets %f leva", getFirstName(), getLastName(), getSalary());
   }

    public void increaseSalary(double bonus) {
        if (getAge() < 30) {
            this.setSalary(this.getSalary() + (this.getSalary() * bonus / 200));
        } else {
            this.setSalary(this.getSalary() + (this.getSalary() * bonus / 100));
        }
    }
}
