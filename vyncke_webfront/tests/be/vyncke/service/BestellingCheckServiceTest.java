package be.vyncke.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.AdditionalMatchers.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.MockitoAnnotations.initMocks;

// We gebruiken het Mockito mocking framework

class BestellingCheckServiceTest {

    // We zorgen met mocking dat we geen database of systeem nodig hebben om de testen te schrijven
    // We gebruiken een mock voor de Service, hier bestaat momenteel enkel een Interface voor
    @Mock
    be.vyncke.service.BestellingCheckService BestellingCheckService;

    // Dit zijn de geldige ticketnummers: 123456, 123457, 123458
    // and(), gt(), lt() zijn Mockito AdditionalMatchers
    public static int GeldigeBestelling() {
        return and(gt(1), lt(9));
    }

    // Dit is het juiste klantnummer bij deze tickets
    // eq() is een Mockito Matcher
    public static int juisteKlantNo() {
        return eq(13);
    }
    public static int juistePrijs() { return eq(150);
    }


    @BeforeEach
    void setUp() {

        // Instantieer de mock-objecten
        initMocks(this);

        // Proforma matchers - want deze gaan we niet in de testen gebruiken
        Mockito.when(BestellingCheckService.checkBestellingGeldigheid(GeldigeBestelling()))
                .thenReturn(true);
        Mockito.when(BestellingCheckService.checkBestellingGeldigheid(not(GeldigeBestelling())))
                .thenReturn(false);


        Mockito.when(BestellingCheckService.checkBestelling((GeldigeBestelling()), not(juisteKlantNo())))
                .thenReturn("Probeer opnieuw aub")
                .thenReturn("Verkeerde Bestelling of klantnummer");


        Mockito.when(BestellingCheckService.checkBestelling(not(GeldigeBestelling()), anyInt()))
                .thenReturn("Onbekend bestelling");


        Mockito.when(BestellingCheckService.checkBetaling(GeldigeBestelling(), juisteKlantNo(), juistePrijs()))
                .thenReturn("U heeft betaald");

        Mockito.when(BestellingCheckService.checkBetaling(GeldigeBestelling(), juisteKlantNo(), not(juistePrijs())))
                .thenReturn("Uw bestelling is nog niet betaald");
    }

    @Test
    void ts16() {
        assertEquals("Onbekend bestelling", BestellingCheckService.checkBestelling(10, 14));
    }

    @Test
    void ts8() {
        assertEquals("Probeer opnieuw aub", BestellingCheckService.checkBestelling(2, 2468));
        assertEquals("Verkeerde Bestelling of klantnummer", BestellingCheckService.checkBestelling(2, 2469));
    }

    @Test
    void ts7() {
        assertEquals("U heeft betaald", BestellingCheckService.checkBetaling(2, 13, 150));
    }

    @Test
    void ts5() {
        assertEquals("Uw bestelling is nog niet betaald", BestellingCheckService.checkBetaling(2, 13, 0));
    }
}