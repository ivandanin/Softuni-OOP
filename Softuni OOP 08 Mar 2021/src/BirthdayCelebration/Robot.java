package BirthdayCelebration;

public class Robot implements Identifiable{
    String id;
    String model;

    public Robot (String id, String model) {
        this.id = id;
        this.model = model;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }
}
