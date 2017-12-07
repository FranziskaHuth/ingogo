package mobi.ingogo.interview.controller;


import mobi.ingogo.interview.dto.GeoPositionDto;
import mobi.ingogo.interview.dto.RouteRequestDto;
import mobi.ingogo.interview.dto.RouteResponseDto;
import mobi.ingogo.interview.model.Position;
import mobi.ingogo.interview.model.error.ValidationError;
import mobi.ingogo.interview.service.directions.DirectionsResponse;
import mobi.ingogo.interview.service.directions.DirectionsService;
import mobi.ingogo.interview.model.GeocodeResult;
import mobi.ingogo.interview.service.geocoder.GeocoderService;
import mobi.ingogo.interview.service.geocoder.LocationInfoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = {"/api/geo"})
public class GeoApiController {

    @Autowired
    private DirectionsService directionsService;
    @Autowired
    private GeocoderService geocoderService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/route", method = RequestMethod.POST)
    public ResponseEntity<RouteResponseDto> route(@RequestBody RouteRequestDto request)throws ValidationError {

        directionsService.validateRoute(request);
        DirectionsResponse directions = directionsService.getDirections(directionsService.getPosition(request.getPickup()), directionsService.getPosition(request.getDropoff()));

        RouteResponseDto response = new RouteResponseDto();
        response.setDistanceInKm(directions.getDistanceInKm());
        response.setDurationInMinutes(directions.getDurationInMinutes());
        response.setPickup(directions.getStartLocation());
        response.setDropoff(directions.getEndLocation());
        response.setEncodedPolyline(directions.getPolyLine().getEncodedPath());
        logger.info("route post response: " + response.toString());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/positionEcho", method = RequestMethod.POST)
    public ResponseEntity<GeoPositionDto> position(@RequestBody GeoPositionDto position) {
        logger.debug("Received position: {}, {}", position.getLatitude(), position.getLongitude());

        return new ResponseEntity<>(position, HttpStatus.OK);
    }

    @RequestMapping(value = "/locationInfo", method = RequestMethod.POST)
    public ResponseEntity<LocationInfoResponse> location(@RequestBody GeoPositionDto position) {
        try {
            GeocodeResult result = geocoderService.reverseGeocode(new Position(Double.valueOf(position.getLatitude()), Double.valueOf(position.getLongitude())));
            LocationInfoResponse response= new LocationInfoResponse(result.getSuburb(),result.getStreetAdress());
            logger.info("locationInfo post response: " + response.toString());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
