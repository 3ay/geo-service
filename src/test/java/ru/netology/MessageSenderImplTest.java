package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

public class MessageSenderImplTest {
    private MessageSender messageSender;

    @Mock
    private GeoService geoService;

    @Mock
    private LocalizationService localizationService;
    @BeforeEach
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
        messageSender = new MessageSenderImpl(geoService, localizationService);
    }
    @Test
    public void checkRussianText() {
        when(
                geoService.byIp("172.123.12.19")
        ).thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));
        when(
                localizationService.locale(Country.RUSSIA)
        ).thenReturn("Добро пожаловать");
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");
        String actual = messageSender.send(headers);
        String expected = "Добро пожаловать";
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void checkEnglishText() {
        when(
                geoService.byIp("96.250.7.176")
        ).thenReturn(new Location("New York", Country.USA, null, 0));
        when(
                localizationService.locale(Country.USA)
        ).thenReturn("Welcome");
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.250.7.176");
        String actual = messageSender.send(headers);
        String expected = "Welcome";
        Assertions.assertEquals(expected, actual);
    }
}
