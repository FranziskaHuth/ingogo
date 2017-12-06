package mobi.ingogo.interview.service.directions;

import mobi.ingogo.interview.model.Position;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DirectionsServiceTest {

	private DirectionsService directionsService;

	@Before
	public void setUp() throws Exception {
		directionsService = new DirectionsService("AIzaSyBzlLYISGjL_ovJwAehh6ydhB56fCCpPQw");
	}

	@Test
	public void exampleTest() throws Exception {
		// Setup
		Position origin = new Position(-33.5, 151.5);
		Position destination = new Position(-33.6, 151.6);

		// Execute (this will fail until the service is implemented correctly)
		// directionsService.getDirections(origin, destination);

		// Verify
		assertThat(1 + 2, is(3));
	}
}