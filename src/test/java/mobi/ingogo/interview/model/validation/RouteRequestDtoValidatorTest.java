package mobi.ingogo.interview.model.validation;

import mobi.ingogo.interview.dto.GeoPositionDto;
import mobi.ingogo.interview.dto.RouteRequestDto;
import mobi.ingogo.interview.model.error.ValidationError;
import mobi.ingogo.interview.tools.RouteRequestData;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RouteRequestDtoValidatorTest {

    private RouteRequestDtoValidator validator;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setup() {
        validator = new RouteRequestDtoValidator();
    }

    @Test
    public void testWithInvalidPickUp() {
        thrown.expect(ValidationError.class);
        thrown.expectMessage("Invalid pickUp parameter");
        RouteRequestDto route = RouteRequestData.getValidRoute();
        GeoPositionDto invalidPickup = route.getPickup();
        invalidPickup.setLatitude("blub");

        validator.validateRouteRequestDto(route);
    }

    @Test
    public void testWithInvalidDropOff() {
        thrown.expect(ValidationError.class);
        thrown.expectMessage("Invalid dropOff parameter");
        RouteRequestDto route = RouteRequestData.getValidRoute();
        GeoPositionDto invalidDropOff = route.getDropoff();
        invalidDropOff.setLatitude("blub");

        validator.validateRouteRequestDto(route);
    }

    @Test
    public void testWithRouteNull() {
        thrown.expect(ValidationError.class);
        thrown.expectMessage("Invalid route parameter");
        RouteRequestDto route = new RouteRequestDto();

        validator.validateRouteRequestDto(route);
    }

    @Test
    public void testWithRoutePickUpNull() {
        thrown.expect(ValidationError.class);
        thrown.expectMessage("Invalid route parameter");
        RouteRequestDto route = RouteRequestData.getValidRoute();
        route.setPickup(null);

        validator.validateRouteRequestDto(route);
    }

    @Test
    public void testWithRouteDropOffNull() {
        thrown.expect(ValidationError.class);
        thrown.expectMessage("Invalid route parameter");
        RouteRequestDto route = RouteRequestData.getValidRoute();
        route.setDropoff(null);

        validator.validateRouteRequestDto(route);
    }

    @Test
    public void testWithRouteDropOffLongitudeNull() {
        thrown.expect(ValidationError.class);
        thrown.expectMessage("Invalid dropOff parameter");
        RouteRequestDto route = RouteRequestData.getValidRoute();
        GeoPositionDto dropOff = route.getDropoff();
        dropOff.setLongitude(null);

        validator.validateRouteRequestDto(route);
    }

    @Test
    public void testWithRouteDropOffLatitudeNull() {
        thrown.expect(ValidationError.class);
        thrown.expectMessage("Invalid dropOff parameter");
        RouteRequestDto route = RouteRequestData.getValidRoute();
        GeoPositionDto dropOff = route.getDropoff();
        dropOff.setLatitude(null);

        validator.validateRouteRequestDto(route);
    }

    @Test
    public void testWithRoutePickupLongitudeNull() {
        thrown.expect(ValidationError.class);
        thrown.expectMessage("Invalid pickUp parameter");
        RouteRequestDto route = RouteRequestData.getValidRoute();
        GeoPositionDto pickUp = route.getPickup();
        pickUp.setLongitude(null);

        validator.validateRouteRequestDto(route);
    }

    @Test
    public void testWithRoutePickupLatitudeNull() {
        thrown.expect(ValidationError.class);
        thrown.expectMessage("Invalid pickUp parameter");
        RouteRequestDto route = RouteRequestData.getValidRoute();
        GeoPositionDto pickUp = route.getPickup();
        pickUp.setLatitude(null);

        validator.validateRouteRequestDto(route);
    }
}
