import java.lang.reflect.Array;

/*
 * Created by asivolella on 2016-01-27.
 */
public class Coordinate {
    private double x, y;
    private double[] coordinate;

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
        this.coordinate = new double[]{x, y};
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double[] getArrayCoordinate() {
        return this.coordinate;
    }
}
