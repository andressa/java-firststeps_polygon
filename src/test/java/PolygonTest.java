import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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

        assertEquals("Coordinate is not setting X coordinate", expected.getX(), actual.getX(), this.epsilon);
        assertEquals("Coordinate is not setting Y coordinate", expected.getY(), actual.getY(), this.epsilon);
    }

    @Test
    public void shouldReturnNullInCaseVerticeDoesNotExist(){
        this.polygon.addCoordinate(new Coordinate(0, 0));
        Coordinate coord = this.polygon.getCoordinate(1);
        assertNull("Should return Null in case requested vertice does not exist", coord);
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

        assertEquals(
             "Coordinate1 is not setting Y correctly",
             expectedCoordinate1.getY(),
             actualCoordinate1.getY(),
             this.epsilon
        );
        assertEquals(
             "Coordinate1 is not setting X correctly",
             expectedCoordinate1.getX(),
             actualCoordinate1.getX(),
             this.epsilon
        );

        assertEquals(
             "Coordinate 2 is not setting X correctly",
             expectedCoordinate2.getX(),
             actualCoordinate2.getX(),
             this.epsilon
        );
        assertEquals(
             "Coordinate 2 is not setting Y correctly",
             expectedCoordinate2.getY(),
             actualCoordinate2.getY(),
             this.epsilon
        );
    }
}
