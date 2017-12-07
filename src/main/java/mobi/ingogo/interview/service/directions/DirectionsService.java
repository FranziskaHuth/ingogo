package mobi.ingogo.interview.service.directions;

import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import mobi.ingogo.interview.dto.GeoPositionDto;
import mobi.ingogo.interview.dto.RouteRequestDto;
import mobi.ingogo.interview.model.Position;
import mobi.ingogo.interview.model.validation.RouteRequestDtoValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DirectionsService {
    private GeoApiContext context = new GeoApiContext();

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private RouteRequestDtoValidator validator;

    @Autowired
    public DirectionsService(@Value("${google.maps.key}") String apiKey, RouteRequestDtoValidator validator) {
        context.setApiKey(apiKey);
        this.validator = validator;
    }

    public DirectionsResponse getDirections(Position origin, Position destination) {
        logger.debug("origin: {}, destination: {}", origin, destination);

        try {
            DirectionsApiRequest request = DirectionsApi.newRequest(context);
            request.origin(origin.toString());
            request.destination(destination.toString());
            DirectionsResult googleResponse = request.await();
            return createDirectionsResponse(googleResponse.routes[0]);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private DirectionsResponse createDirectionsResponse(DirectionsRoute route) {
        GeoPositionDto start = new GeoPositionDto();
        start.setLatitude(String.valueOf(route.legs[0].startLocation.lat));
        start.setLongitude(String.valueOf(route.legs[0].startLocation.lng));

        GeoPositionDto end = new GeoPositionDto();
        end.setLatitude(String.valueOf(route.legs[0].endLocation.lat));
        end.setLongitude(String.valueOf(route.legs[0].endLocation.lng));

        return new DirectionsResponse(route.overviewPolyline,route.legs[0].distance,route.legs[0].duration,  start,  end);
    }


    public Position getPosition(GeoPositionDto route) {
        return new Position(Double.valueOf(route.getLatitude()), Double.valueOf(route.getLongitude()));
    }

    public void validateRoute(RouteRequestDto request) {
        validator.validateRouteRequestDto(request);
    }
}
