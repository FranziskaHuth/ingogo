package mobi.ingogo.interview.tools;

import mobi.ingogo.interview.dto.GeoPositionDto;
import mobi.ingogo.interview.dto.RouteRequestDto;

public class RouteRequestData {

    public static RouteRequestDto getValidRoute() {
        RouteRequestDto route = new RouteRequestDto();
        route.setPickup(getValidPositionDropOff());
        route.setDropoff(getValidPickUpPosition());
        return route;
    }

    private static GeoPositionDto getValidPickUpPosition() {
        GeoPositionDto geoPickUp = new GeoPositionDto();
        geoPickUp.setLongitude("151.235481");
        geoPickUp.setLatitude("-33.919291");
        return geoPickUp;
    }

    private static GeoPositionDto getValidPositionDropOff() {
        GeoPositionDto geoDropOff = new GeoPositionDto();
        geoDropOff.setLongitude("151.204772");
        geoDropOff.setLatitude("-33.864942");
        return geoDropOff;
    }
}
