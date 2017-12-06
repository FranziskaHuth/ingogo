package mobi.ingogo.interview.service.directions;

import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsResult;
import mobi.ingogo.interview.model.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DirectionsService {
	private GeoApiContext context = new GeoApiContext();

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public DirectionsService(@Value("${google.maps.key}") String apiKey) {
		context.setApiKey(apiKey);
	}

	/* TODO:  Update this method to pass the correct parameters to Google DirectionsAPI, and return a suitable response
  	 * https://github.com/googlemaps/google-maps-services-java
	 */
	public void getDirections(Position origin, Position destination) {
		logger.debug("origin: {}, destination: {}", origin, destination);

		try {
			DirectionsApiRequest request = DirectionsApi.newRequest(context);
			// request.set...

			DirectionsResult googleResponse = request.await();
			// ...

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


}
