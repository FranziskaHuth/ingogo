package mobi.ingogo.interview.service.geocoder;

import com.google.maps.errors.ApiException;
import mobi.ingogo.interview.model.Position;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class GeocoderReverseTest {
    GeocoderService service;

    @Before
    public void setUp() {
        service = new GeocoderService("AIzaSyBzlLYISGjL_ovJwAehh6ydhB56fCCpPQw");
    }

    @Test
    public void testReverse() throws InterruptedException, ApiException, IOException {
        GeocodeResult result = service.reverseGeocode(new Position(-33.864933, 151.204426));
        Assert.assertTrue("wrong suburb", result.getSuburb().equals("Sydney"));
        Assert.assertTrue("wrong street name", result.getStreetAdress().equals("55 Clarence Street"));
    }

    @Test
    public void testWhenNumberIsMissing() throws InterruptedException, ApiException, IOException {
        GeocodeResult result = service.reverseGeocode(new Position(-33.81291023, 151.1759779));
        Assert.assertTrue("wrong street name",result.getStreetAdress().equals("Sydney Orbital Network"));
        Assert.assertNull("wrong suburb", result.getSuburb());
    }

    @Test
    public void test3() throws InterruptedException, ApiException, IOException {
        GeocodeResult result = service.reverseGeocode(new Position(-27.45898348, 153.01174678));
        Assert.assertTrue("wrong street name",result.getStreetAdress().equals("Musgrave Road"));
        Assert.assertNull("wrong suburb", result.getSuburb());
    }

    @Test
    public void test4() throws InterruptedException, ApiException, IOException {
        GeocodeResult result = service.reverseGeocode(new Position(-27.45898348, 153.01174678));
        Assert.assertTrue("wrong street name",result.getStreetAdress().equals("Musgrave Road"));
        Assert.assertNull("wrong suburb", result.getSuburb());
    }

    @Test
    public void test5() throws InterruptedException, ApiException, IOException {
        GeocodeResult result = service.reverseGeocode(new Position(-37.73281596, 144.90839894));
        Assert.assertTrue("wrong street name",result.getStreetAdress().equals("120 Bulla Road"));
        Assert.assertTrue("wrong suburb", result.getSuburb().equals("Essendon Fields"));
    }

    @Test
    public void test6() throws InterruptedException, ApiException, IOException {
        GeocodeResult result = service.reverseGeocode(new Position(-27.48449974, 153.0342487));
        Assert.assertTrue("wrong street name",result.getStreetAdress().equals("Vulture Street"));
        Assert.assertNull("wrong suburb", result.getSuburb());
    }
}
