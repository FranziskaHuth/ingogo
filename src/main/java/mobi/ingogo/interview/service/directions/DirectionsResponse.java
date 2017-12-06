package mobi.ingogo.interview.service.directions;

import com.google.maps.model.EncodedPolyline;

// TODO: Add fields to this response object so it can be populated by the DirectionsService
public class DirectionsResponse {
    private EncodedPolyline polyLine ;
    private String distance;
    private String duration;

    public DirectionsResponse(EncodedPolyline polyLine, String distance, String duration) {
        this.polyLine = polyLine;
        this.distance = distance;
        this.duration = duration;
    }

    public EncodedPolyline getPolyLine() {
        return polyLine;
    }

    public Integer getDistance() {
        return 0;
    }

    public Integer getDuration() {
        return 0;
    }
}
