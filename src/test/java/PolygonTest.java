import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/*
 * Created by asivolella at 2016-01-27
 */
public class PolygonTest {
    private Polygon polygon;
    private int informedNumberOfVertices = 3;

    @Before
    public void setUp(){
        this.polygon = new Polygon(informedNumberOfVertices);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldRaiseExceptionWhenNumberOfVerticesIsLowerThan3(){
        Polygon polygon = new Polygon(2);
    }

    @Test
    public void shouldSetNumberOfVertices(){
        int expectedNumberOfVertices = this.informedNumberOfVertices;
        int actualNumberOfVertices = polygon.getNumberOfVertices();
        assertEquals(
                "setNumberOfVertices is not setting nVertices correctly", expectedNumberOfVertices, actualNumberOfVertices
        );
    }

    @Test
    public void shouldCreateCoordinate(){
        Coordinate coordinate = new Coordinate(0, 0);
        polygon.addCoordinate(coordinate);
        Coordinate coord = polygon.getCoordinate(0);
        assertNotNull("addCoordinate is not adding any coordinate", coord);
    }

    @Test
    public void shouldCoordinateStoredMustBeEqual() {
        Coordinate expected = new Coordinate(1,1);

        polygon.addCoordinate(new Coordinate(1,1));

        Coordinate actual = polygon.getCoordinate(0);

        assertEquals("Coordinate is not setting X coordinate", expected.getX(), actual.getX());
        assertEquals("Coordinate is not setting Y coordinate", expected.getY(), actual.getY());
    }

    @Test
    public void shoudlAddNumberOfVerticesAsNumberOfCoordinates(){
        for (int vertice = 0; vertice < this.informedNumberOfVertices; vertice ++){
            polygon.addCoordinate(new Coordinate(1, 1));
        }
        int expectedStoredCoordinates = this.informedNumberOfVertices;
        int actualStoredCoordinates = polygon.getNumberOfCoordinates();
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

        polygon.addCoordinate(expectedCoordinate1);
        polygon.addCoordinate(expectedCoordinate2);

        Coordinate actualCoordinate1 = polygon.getCoordinate(0);
        Coordinate actualCoordinate2 = polygon.getCoordinate(1);

        assertEquals("Coordinate1 is not setting Y correctly", expectedCoordinate1.getY(), actualCoordinate1.getY());
        assertEquals("Coordinate1 is not setting X correctly", expectedCoordinate1.getX(), actualCoordinate1.getX());

        assertEquals("Coordinate 2 is not setting X correctly", expectedCoordinate2.getX(), actualCoordinate2.getX());
        assertEquals("Coordinate 2 is not setting Y correctly", expectedCoordinate2.getY(), actualCoordinate2.getY());
    }
}
