package mobi.ingogo.interview.service.geocoder;

public class LocationInfoResponse {
    private String suburb;
    private String streetAddress;

    public LocationInfoResponse(String suburb, String streetAddress) {
        this.suburb = suburb;
        this.streetAddress = streetAddress;
    }

    @Override
    public String toString() {
        return "LocationInfoResponse{" +
                "suburb='" + suburb + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                '}';
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
}
