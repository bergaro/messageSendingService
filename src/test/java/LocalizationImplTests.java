import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationImplTests {

    @Test
    public void checkRusLocalization() {
        final String expected = "Добро пожаловать";
        final String result;
        LocalizationService localizationService = new LocalizationServiceImpl();
        result = localizationService.locale(Country.RUSSIA);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void checkGerLocalization() {
        final String expected = "Welcome";
        final String result;
        LocalizationService localizationService = new LocalizationServiceImpl();
        result = localizationService.locale(Country.GERMANY);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void checkUsaLocalization() {
        final String expected = "Welcome";
        final String result;
        LocalizationService localizationService = new LocalizationServiceImpl();
        result = localizationService.locale(Country.USA);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void checkBraLocalization() {
        final String expected = "Welcome";
        final String result;
        LocalizationService localizationService = new LocalizationServiceImpl();
        result = localizationService.locale(Country.BRAZIL);
        Assertions.assertEquals(expected, result);
    }
}
