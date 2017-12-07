package mobi.ingogo.interview.service.directions;

import mobi.ingogo.interview.model.Position;
import mobi.ingogo.interview.model.validation.RouteRequestDtoValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class DirectionsServiceTest {

    private DirectionsService directionsService;

    @Before
    public void setUp() throws Exception {
        directionsService = new DirectionsService("AIzaSyBzlLYISGjL_ovJwAehh6ydhB56fCCpPQw", new RouteRequestDtoValidator());
    }

    @Test
    public void testWhenGetDirectionsRouteResultIsNull() throws Exception {
        // Setup
        Position origin = new Position(-33.5, 151.5);
        Position destination = new Position(-33.6, 151.6);

        DirectionsResponse response=directionsService.getDirections(origin, destination);
        // Verify
        Assert.assertNull("", response);

    }
}