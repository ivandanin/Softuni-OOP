package ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private final List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        if (getMoney() >= product.getCost()) {
            products.add(product);
            setMoney(getMoney() - product.getCost());
            System.out.printf("%s bought %s%n", getName(), product.getName());
        } else {
            System.out.printf("%s can't afford %s%n", getName(), product.getName());
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(getName() + " - ");
        output.append(getProducts().isEmpty()
        ? "Nothing bought"
                : output.append(products.stream()
                .map(Product::getName)
        .collect(Collectors.joining(", "))));
        return output.toString();
    }
}
