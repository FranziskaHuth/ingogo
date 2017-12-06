package mobi.ingogo.interview.dto;

/**
 * Created by Simon on 27/11/17.
 */
public class RouteRequestDto {
	private GeoPositionDto pickup;
	private GeoPositionDto dropoff;

	public GeoPositionDto getPickup() {
		return pickup;
	}

	public void setPickup(GeoPositionDto pickup) {
		this.pickup = pickup;
	}

	public GeoPositionDto getDropoff() {
		return dropoff;
	}

	public void setDropoff(GeoPositionDto dropoff) {
		this.dropoff = dropoff;
	}
}
