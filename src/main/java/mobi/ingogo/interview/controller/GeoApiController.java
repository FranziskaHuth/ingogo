package mobi.ingogo.interview.controller;

import com.google.maps.model.DirectionsResult;
import com.google.maps.model.EncodedPolyline;
import mobi.ingogo.interview.dto.GeoPositionDto;
import mobi.ingogo.interview.dto.RouteRequestDto;
import mobi.ingogo.interview.dto.RouteResponseDto;
import mobi.ingogo.interview.model.error.ValidationError;
import mobi.ingogo.interview.service.directions.DirectionsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"/api/geo"})
public class GeoApiController {

    @Autowired
    private DirectionsService directionsService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/route", method = RequestMethod.POST)
    public ResponseEntity<RouteResponseDto> route(@RequestBody RouteRequestDto request){

        directionsService.validateRoute(request);
        DirectionsResult directions = directionsService.getDirections(directionsService.getPosition(request.getPickup()), directionsService.getPosition(request.getDropoff()));
        EncodedPolyline polyLine = directions.routes[0].overviewPolyline;

        RouteResponseDto response = new RouteResponseDto();
        // TODO: Populate this response object with real data from directionsService
        // e.g. to display a route on the map, set the encoded polyline
        //response.setEncodedPolyline("vx|lEmz_y[_BkV??kAlBi@hA??iChE??sDcD??qBsBkAaA??eBuAo@t@??gB|Ds@vB??mBhDa@rA??fAvAhAxA??tBhB~BfB??hCxBbB`B??}@tBmBpD??wBbEqCvF??aB`DkC~E??qBzDcBnD??wA~VqFqP??iApCoBxF??mAlE^bF??~@jFbAbH??]|DuBdG??mA`DiAhG??_@lDDzB??JTkAlB??");
        response.setEncodedPolyline(polyLine.getEncodedPath());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/positionEcho", method = RequestMethod.POST)
    public ResponseEntity<GeoPositionDto> position(@RequestBody GeoPositionDto position) {

        logger.debug("Received position: {}, {}", position.getLatitude(), position.getLongitude());

        return new ResponseEntity<>(position, HttpStatus.OK);
    }

}
