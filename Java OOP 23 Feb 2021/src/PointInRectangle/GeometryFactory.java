package PointInRectangle;

public class GeometryFactory {
    public static Rectangle createRectangle(int[] pointInfo) {
        return new Rectangle(createPoint(pointInfo[0], pointInfo[1]), createPoint(pointInfo[2], pointInfo[3]));
    }
    public static Point createPoint(int x, int y) {
        return new Point(x, y);
    }
    public static Point createPoint(int[] pointInfo) {
        if (pointInfo.length != 2) {
            throw new IllegalStateException("Point should be x & y");
        }
        return createPoint(pointInfo[0], pointInfo[1]);
    }
}
