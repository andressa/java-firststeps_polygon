/*
 Java Polygon.
    by Andressa Sivolella <asivolella@thoughtworks.com>
    at 2016-01-26
 */
import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;

public class Polygon {
    private int numberOfVertices;
    private List<Coordinate> vertices = new ArrayList<>();

    public Polygon(int numberOfVertices){
        Validate.inclusiveBetween(3, Integer.MAX_VALUE, numberOfVertices);
        this.numberOfVertices = numberOfVertices;
    }

    public void addCoordinate(Coordinate coordinate) {
        this.vertices.add(coordinate);
    }

    public Coordinate getCoordinate(int index) {
        return this.vertices.get(index);
    }

    public int getNumberOfVertices() {
        return this.numberOfVertices;
    }

    public int getNumberOfCoordinates() {
        return this.vertices.size();
    }
}


