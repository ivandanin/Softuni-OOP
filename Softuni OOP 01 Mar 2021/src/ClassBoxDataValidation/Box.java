package ClassBoxDataValidation;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box (double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    public double calculateVolume() {
        return length * width * height;
    }

    public double calculateLateralSurfaceArea() {
        return 2 * height * (length + width);
    }

    public double calculateSurfaceArea() {
        return 2 * length * width + 2 * length * height + 2 * width * height;
    }

    private void setHeight(double height) {
        if (height < 0) {
            System.out.println("Height cannot be zero or negative.");
        }
            this.height = height;
    }

    private void setWidth(double width) {
        if (width < 0) {
            System.out.println("Width cannot be zero or negative.");
        }
            this.width = width;
    }

    private void setLength(double length) {
        if (length < 0) {
            System.out.println("Length cannot be zero or negative.");
        }
            this.length = length;
    }
}
