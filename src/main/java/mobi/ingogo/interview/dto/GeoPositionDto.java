package mobi.ingogo.interview.dto;

/**
 * Created by Simon on 27/11/17.
 */
public class GeoPositionDto {
	private String latitude;
	private String longitude;
	private int accuracy;

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
}
