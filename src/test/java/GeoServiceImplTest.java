import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import java.util.ArrayList;
import java.util.List;

public class GeoServiceImplTest {

    private static List<Location> locations = new ArrayList<>(9);
    private static GeoService geoService;
    @BeforeAll
    public static void setLocations() {
            // LOCALHOST.equals(ip)
        locations.add(new Location(null, null, null, 0));
            // MOSCOW_IP.equals(ip)
        locations.add(new Location("Moscow", Country.RUSSIA, "Lenina", 15));
            // NEW_YORK_IP.equals(ip)
        locations.add(new Location("New York", Country.USA, " 10th Avenue", 32));
            // ip.startsWith("172.")
        locations.add(new Location("Moscow", Country.RUSSIA, null, 0));
            // ip.startsWith("96.")
        locations.add(new Location("New York", Country.USA, null,  0));
    }
    @BeforeAll
    public static void setGeoService() {
        geoService = new GeoServiceImpl();
    }

    @Test
    public void checkDifferentLocalhostIp() {
        final String ip = "127.0.0.1";
        final Location expected = locations.get(0);
        Location result = geoService.byIp(ip);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void checkDifferentMoscowIp() {
        final String ip = "172.0.32.11";
        final Location expected = locations.get(1);
        Location result = geoService.byIp(ip);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void checkDifferentNewYrokIp() {
        final String ip = "96.44.183.149";
        final Location expected = locations.get(2);
        Location result = geoService.byIp(ip);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void checkDifferentRusIp() {
        final String ip = "172.1.28.16";
        final Location expected = locations.get(3);
        Location result = geoService.byIp(ip);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void checkDifferentEngIp() {
        final String ip = "96.43.122.132";
        final Location expected = locations.get(4);
        Location result = geoService.byIp(ip);
        Assertions.assertEquals(expected, result);
    }
}
