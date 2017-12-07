package mobi.ingogo.interview.service.directions;

import com.google.maps.model.Distance;
import com.google.maps.model.Duration;
import com.google.maps.model.EncodedPolyline;
import mobi.ingogo.interview.dto.GeoPositionDto;

public class DirectionsResponse {
    private EncodedPolyline polyLine;
    private Distance distance;
    private Duration duration;
    private GeoPositionDto startLocation, endLocation;

    public DirectionsResponse(EncodedPolyline polyLine, Distance distance, Duration duration, GeoPositionDto startLocation, GeoPositionDto endLocation) {
        this.polyLine = polyLine;
        this.distance = distance;
        this.duration = duration;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
    }

    public EncodedPolyline getPolyLine() {
        return polyLine;
    }

    public Distance getDistance() {
        return distance;
    }

    public Double getDistanceInKm() {
        return distance.inMeters / 1000.0;
    }

    public Duration getDuration() {
        return duration;
    }

    public Double getDurationInMinutes() {
        return duration.inSeconds / 60.0;
    }

    public GeoPositionDto getStartLocation() {
        return startLocation;
    }

    public GeoPositionDto getEndLocation() {
        return endLocation;
    }
}
