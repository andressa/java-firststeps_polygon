import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/*
 * Created by asivolella at 2016-01-27
 */
public class PolygonTest {
    private double epsilon = 0.0001; // tolerance when asserting equals for doubles
    private Polygon polygon, triangle, square;
    private int informedNumberOfVertices = 3;

    @Before
    public void setUp(){
        this.polygon = new Polygon(informedNumberOfVertices);
        this.triangle = new Polygon(3);
        this.square = new Polygon(4);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldRaiseExceptionWhenNumberOfVerticesIsLowerThan3(){
        Polygon polygon = new Polygon(2);
    }

    @Test
    public void shouldSetNumberOfVertices(){
        int expectedNumberOfVertices = this.informedNumberOfVertices;
        int actualNumberOfVertices = this.polygon.getNumberOfVertices();
        assertEquals(
            "setNumberOfVertices is not setting nVertices correctly", expectedNumberOfVertices, actualNumberOfVertices
        );
    }

    @Test
    public void shouldCreateCoordinate(){
        Coordinate coordinate = new Coordinate(0, 0);
        this.polygon.addCoordinate(coordinate);
        Coordinate coord = this.polygon.getCoordinate(0);
        assertNotNull("addCoordinate is not adding any coordinate", coord);
    }

    @Test
    public void shouldCoordinateStoredMustBeEqual() {
        Coordinate expected = new Coordinate(1,1);

        this.polygon.addCoordinate(new Coordinate(1,1));

        Coordinate actual = this.polygon.getCoordinate(0);

        assertArrayEquals(expected.getArrayCoordinate(), actual.getArrayCoordinate(), this.epsilon);
    }

    @Test
    public void shouldReturnNullInCaseVerticeDoesNotExist(){
        this.polygon.addCoordinate(new Coordinate(0, 0));
        Coordinate coord = this.polygon.getCoordinate(2);
        assertNull("Should return Null in case requested vertice does not exist", coord);
    }

    @Test
    public void shouldReturnCoordinate0WhenNumberOfVerticesPlus1IsRequired(){
        Coordinate previous = new Coordinate(0, 0);
        Coordinate current = new Coordinate(1, 1);
        Coordinate next = new Coordinate(2, 2);

        this.polygon.addCoordinate(previous);
        this.polygon.addCoordinate(current);
        this.polygon.addCoordinate(next);

        Coordinate actualCoordinate = this.polygon.getCoordinate(3);

        assertArrayEquals(
            "Get coordinate 0 when vertice 3 is requested",
            previous.getArrayCoordinate(),
            actualCoordinate.getArrayCoordinate(),
            this.epsilon
        );
    }

    @Test
    public void shouldReturnCoordinate2WhenNumberOfVerticesMinous1IsRequired(){
        Coordinate previous = new Coordinate(0, 0);
        Coordinate current = new Coordinate(1, 1);
        Coordinate next = new Coordinate(2, 2);

        this.polygon.addCoordinate(previous);
        this.polygon.addCoordinate(current);
        this.polygon.addCoordinate(next);

        Coordinate actualCoordinate = this.polygon.getCoordinate(-1);

        assertArrayEquals(
            "getCoordinante(-1) is not returning coordindate 2 if it is a triangle",
            next.getArrayCoordinate(), actualCoordinate.getArrayCoordinate(), this.epsilon
        );
    }

    @Test
    public void shoudlAddNumberOfVerticesAsNumberOfCoordinates(){
        for (int vertice = 0; vertice < this.informedNumberOfVertices; vertice ++){
            this.polygon.addCoordinate(new Coordinate(1, 1));
        }
        int expectedStoredCoordinates = this.informedNumberOfVertices;
        int actualStoredCoordinates = this.polygon.getNumberOfCoordinates();
        assertEquals(
                "numberOfCoordinates are different from numberOfVertices",
                expectedStoredCoordinates,
                actualStoredCoordinates
        );
    }

    @Test
    public void shouldReceiveTwoNewCoordinates() {
        Coordinate expectedCoordinate1 = new Coordinate(0,0);
        Coordinate expectedCoordinate2 = new Coordinate(1,1);

        this.polygon.addCoordinate(expectedCoordinate1);
        this.polygon.addCoordinate(expectedCoordinate2);

        Coordinate actualCoordinate1 = this.polygon.getCoordinate(0);
        Coordinate actualCoordinate2 = this.polygon.getCoordinate(1);

        assertArrayEquals(
             "Coordinate1 is not being set correctly",
             expectedCoordinate1.getArrayCoordinate(),
             actualCoordinate1.getArrayCoordinate(),
             this.epsilon
        );

        assertArrayEquals(
             "Coordinate2 is not being set correctly",
             expectedCoordinate2.getArrayCoordinate(),
             actualCoordinate2.getArrayCoordinate(),
             this.epsilon
        );
    }

    @Test
    public void shouldReturnTriangleArea(){
        this.triangle.addCoordinate(new Coordinate(0, 0));
        this.triangle.addCoordinate(new Coordinate(0, 1));
        this.triangle.addCoordinate(new Coordinate(1, 0));

        double expectedArea = 0.5;

        double actualArea = this.triangle.calculateArea();
        assertEquals("Triangle area (from calculateArea) is not returning 0.5.", expectedArea, actualArea, this.epsilon);
    }

    @Test
    public void shouldReturnSquareArea(){
        this.square.addCoordinate(new Coordinate(0, 0));
        this.square.addCoordinate(new Coordinate(0, 2));
        this.square.addCoordinate(new Coordinate(2, 2));
        this.square.addCoordinate(new Coordinate(2, 0));

        double expectedArea = 4;

        double actualArea = this.square.calculateArea();
        assertEquals("Square area is not returning 4.", expectedArea, actualArea, this.epsilon);
    }
}
