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
    private double area;

    public Polygon(int numberOfVertices){
        Validate.inclusiveBetween(3, Integer.MAX_VALUE, numberOfVertices);
        this.numberOfVertices = numberOfVertices;
    }

    public void addCoordinate(Coordinate coordinate) {
        this.vertices.add(coordinate);
    }

    public Coordinate getCoordinate(int index) {
        Coordinate coordinate;
        try {
            coordinate = this.vertices.get(index);
        } catch (ArrayIndexOutOfBoundsException e) {
            coordinate = this.vertices.get(this.vertices.size() - 1);
        } catch (IndexOutOfBoundsException e){
            if (index == this.vertices.size()){
                coordinate = this.vertices.get(0);
            }else{
                coordinate = null;
            }
        }
        return coordinate;
    }

    public int getNumberOfVertices() {
        return this.numberOfVertices;
    }

    public int getNumberOfCoordinates() {
        return this.vertices.size();
    }


    public double calculateArea() {
        this.area = 0;
        for (int vertice = 0; vertice < this.numberOfVertices; vertice ++){
            Coordinate currentCoordinate = this.getCoordinate(vertice);
            Coordinate nextCoordinate = this.getCoordinate(vertice + 1);
            Coordinate previousCoordinate = this.getCoordinate(vertice - 1);
            this.area += (currentCoordinate.getX() * nextCoordinate.getY() - currentCoordinate.getX() * previousCoordinate.getY());

        }
        this.area /= 2;
        this.area = Math.abs(this.area);
        return this.area;
    }
}


