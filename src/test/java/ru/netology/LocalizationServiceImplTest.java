package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceImplTest {
    private LocalizationService localizationService;

    @BeforeEach
    public void setUp()
    {
        localizationService = new LocalizationServiceImpl();
    }
    @Test
    public void checkRussiaLocale()
    {
        Assertions.assertEquals("Добро пожаловать", localizationService.locale(Country.RUSSIA));
    }
    @Test
    public void checkUSALocale()
    {
        Assertions.assertEquals("Welcome", localizationService.locale(Country.USA));
    }
    @Test
    public void checkGERMANYLocale()
    {
        Assertions.assertEquals("Welcome", localizationService.locale(Country.GERMANY));
    }
    @Test
    public void checkBRAZILLocale()
    {
        Assertions.assertEquals("Welcome", localizationService.locale(Country.BRAZIL));
    }

}
