package AnimalFarm;

public class Chicken {
    private String name;
    private int age;
    private double product;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);

    }

    private void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    private void setName(String name) {
        if (name == null || name.trim().length() < 1) {
            System.out.println("Name cannot be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private double productPerDay() {
        if (getAge() < 6) {
            product += 2;
        } else if (getAge() < 12) {
            product += 1;
        } else {
            product += 0.75;
        }
        return product;
    }

    private double calculateProductPerDay() {
        return productPerDay();
    }

    @Override
    public String toString() {
        if (age < 15) {
            return String.format("Chicken %s (age %d) can produce %.2f eggs per day.", getName(), getAge(), calculateProductPerDay());
        }
        return "Age should be between 0 and 15.";
    }
}
