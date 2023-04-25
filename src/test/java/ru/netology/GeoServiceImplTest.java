package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceImplTest {
    private  Location location;
    @BeforeEach
    public void setUp()
    {
        GeoService geoService = new GeoServiceImpl();
        location = geoService.byIp("96.58.231.190");
    }
    @Test
    public void checkCity()
    {
        Assertions.assertEquals("New York", location.getCity());
    }
    @Test
    public void checkCounty()
    {
        Assertions.assertEquals(Country.USA, location.getCountry());
    }
}
