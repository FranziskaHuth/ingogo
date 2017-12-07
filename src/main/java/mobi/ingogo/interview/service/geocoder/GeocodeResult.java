package mobi.ingogo.interview.service.geocoder;

public class GeocodeResult {
    private String suburb;
    private String streetAddress;
    private String streetNumber;
    private String streetName;

    public GeocodeResult(String suburb, String streetNumber, String streetName) {
        this.suburb = suburb;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
    }

    public GeocodeResult() {
    }


    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getStreetAdress() {
        if (streetNumber != null) {
            return streetNumber + " " + streetName;
        } else {
            return streetName;
        }

    }

    public void setStreetAdress(String streetAdress) {
        this.streetAddress = streetAdress;
    }
}
