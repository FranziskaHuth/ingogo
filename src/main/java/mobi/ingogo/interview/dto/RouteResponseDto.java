package mobi.ingogo.interview.dto;

/**
 * Created by Simon on 27/11/17.
 */
public class RouteResponseDto {
	GeoPositionDto pickup;
	GeoPositionDto dropoff;
	String encodedPolyline;
	Double durationInMinutes;
	Double distanceInKm;

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

	public String getEncodedPolyline() {
		return encodedPolyline;
	}

	public void setEncodedPolyline(String encodedPolyline) {
		this.encodedPolyline = encodedPolyline;
	}

	public Double getDurationInMinutes() {
		return durationInMinutes;
	}

	public void setDurationInMinutes(Double durationInMinutes) {
		this.durationInMinutes = durationInMinutes;
	}

	public Double getDistanceInKm() {
		return distanceInKm;
	}

	public void setDistanceInKm(Double distanceInKm) {
		this.distanceInKm = distanceInKm;
	}
}
