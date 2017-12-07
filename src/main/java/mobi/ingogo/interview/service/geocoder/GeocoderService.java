package mobi.ingogo.interview.service.geocoder;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.*;
import mobi.ingogo.interview.model.GeocodeResult;
import mobi.ingogo.interview.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

@Component
public class GeocoderService {
    private GeoApiContext context = new GeoApiContext();


    @Autowired
    public GeocoderService(@Value("${google.maps.key}") String apiKey) {
        context.setApiKey(apiKey);
    }

    public GeocodeResult reverseGeocode(Position input) throws InterruptedException, ApiException, IOException {
        LatLng geoPositon = new LatLng(input.getLatitude(), input.getLongitude());
        GeocodingApiRequest request = GeocodingApi.newRequest(context);
        request.latlng(geoPositon);
        try {
            GeocodingResult[] response = request.await();
            if (response.length == 0) {
                return new GeocodeResult();
            }
            //closest match is the first item
            GeocodingResult result = response[0];

            List<AddressComponent> addressComponentList = Arrays.asList(result.addressComponents);
            String streetName = getAddressComponentForType(addressComponentList, "route");
            String streetNumber = getAddressComponentForType(addressComponentList, "street_number");
            String suburb = getAddressComponentForType(addressComponentList, "locality");

            return new GeocodeResult(suburb, streetNumber, streetName);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String getAddressComponentForType(List<AddressComponent> addressComponentList, String typeInput) {
        String route = null;
        for (AddressComponent addressComponent : addressComponentList) {
            for (AddressComponentType type : Arrays.asList(addressComponent.types)) {
                if (type.toString().equals(typeInput)) {
                    route = addressComponent.longName;
                }
            }
        }
        return route;
    }


}
