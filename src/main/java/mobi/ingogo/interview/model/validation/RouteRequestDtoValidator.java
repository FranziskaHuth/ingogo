package mobi.ingogo.interview.model.validation;

import mobi.ingogo.interview.dto.GeoPositionDto;
import mobi.ingogo.interview.dto.RouteRequestDto;
import mobi.ingogo.interview.model.error.ValidationError;
import org.springframework.stereotype.Component;


@Component
public class RouteRequestDtoValidator {

    public void validateRouteRequestDto(RouteRequestDto request) {

        if (request.getPickup() == null || request.getDropoff() == null) {
            throw new ValidationError("Invalid route parameter", ValidationError.MISSING_OR_INVALID_DATA);
        }
        GeoPositionDto dropOff = request.getDropoff();
        GeoPositionDto pickUp = request.getPickup();

        if (dropOff.getLongitude() == null || dropOff.getLatitude() == null) {
            throw new ValidationError("Invalid dropOff parameter", ValidationError.MISSING_OR_INVALID_DATA);
        }
        if (pickUp.getLongitude() == null || pickUp.getLatitude() == null) {
            throw new ValidationError("Invalid pickUp parameter", ValidationError.MISSING_OR_INVALID_DATA);
        }
        try {
            Double.valueOf(dropOff.getLatitude());
            Double.valueOf(dropOff.getLongitude());
        } catch (NumberFormatException e) {
            throw new ValidationError("Invalid dropOff parameter", ValidationError.MISSING_OR_INVALID_DATA);
        }
        try {
            Double.valueOf(pickUp.getLatitude());
            Double.valueOf(pickUp.getLongitude());

        } catch (NumberFormatException e) {
            throw new ValidationError("Invalid pickUp parameter", ValidationError.MISSING_OR_INVALID_DATA);
        }


    }

}
