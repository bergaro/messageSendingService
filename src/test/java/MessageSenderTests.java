import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderTests {
    @Test
    public void sendRsForRusIpTest() {
        final Location location = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        final Map<String, String> headers = new HashMap<>();
        final String original = "172.123.12.11";
        final String expected ="Добро пожаловать";

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(original)).thenReturn(location);
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, original);

        final String result = messageSender.send(headers);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void sendRsForUsaIpTest() {
        final Location location = new Location("New York", Country.USA, " 10th Avenue", 32);
        final Map<String, String> headers = new HashMap<>();
        final String original = "96.44.183.149";
        final String expected ="Welcome";

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(original)).thenReturn(location);
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, original);

        final String result = messageSender.send(headers);

        Assertions.assertEquals(expected, result);
    }


}
