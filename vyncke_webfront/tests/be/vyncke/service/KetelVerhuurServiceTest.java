package be.vyncke.service;

import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.AdditionalMatchers.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.MockitoAnnotations.initMocks;

import static org.junit.jupiter.api.Assertions.*;

class KetelVerhuurServiceTest {

    @Mock
    KetelVerhuurService ketelVerhuurService;

    // Geldige Ketels id's: 1..5

    public static int ketelIdValidRange(){
        return and(gt(0), lt(6));
    }

    public static int klantIdValidRange(){
        return and(gt(0), lt(6));
    }

    public static int verhuurdKetelsRange(){
        return and(gt(0), lt(3));
    }

    public static int beschikbareKetelsIdRange(){
        return and(gt(3),lt(7));
    }

    @BeforeEach
    void setup(){
        //De mock objecten instantieren
        initMocks(this);

        // vragen of ketel bestaat
        Mockito.when(ketelVerhuurService.checkKetelBestaat(ketelIdValidRange()))
                .thenReturn(true);
        Mockito.when(ketelVerhuurService.checkKetelBestaat(not(ketelIdValidRange())))
                .thenReturn(false);

        // vragen of klant bestaat
        Mockito.when(ketelVerhuurService.checkKlantBestaat(klantIdValidRange()))
                .thenReturn(true);
        Mockito.when(ketelVerhuurService.checkKlantBestaat(not(klantIdValidRange())))
                .thenReturn(false);

        // vragen of ketel verhuurd
        Mockito.when(ketelVerhuurService.checkKetelVerhuurd(verhuurdKetelsRange()))
                .thenReturn(true);
        Mockito.when(ketelVerhuurService.checkKetelVerhuurd(beschikbareKetelsIdRange()))
                .thenReturn(false);

        // verhuur ketel
        Mockito.when(ketelVerhuurService.verhuurKetel(anyInt(), not(klantIdValidRange())))
                .thenReturn("Onbekend klantnummer");

        Mockito.when(ketelVerhuurService.verhuurKetel(not(ketelIdValidRange()), anyInt()))
                .thenReturn("De ketel bestaat niet");

        Mockito.when(ketelVerhuurService.verhuurKetel(verhuurdKetelsRange(),klantIdValidRange()))
                .thenReturn("De ketel is al gereserveerd");

        Mockito.when(ketelVerhuurService.verhuurKetel( beschikbareKetelsIdRange(), klantIdValidRange()))
                .thenReturn("Het huren van de ketel is gelukt")
                .thenReturn("De ketel is al gereserveerd");


    }

    @Test
    void TS1() {
        assertEquals("De ketel is al gereserveerd", ketelVerhuurService.verhuurKetel(1, 1));
    }

    @Test
    void TS2() {
        assertEquals("Het huren van de ketel is gelukt", ketelVerhuurService.verhuurKetel(4,2));
    }

    @Test
    void TS4() {
        assertEquals("Onbekend klantnummer", ketelVerhuurService.verhuurKetel(1,8));
    }

    @Test
    void TS8() {
        assertEquals("De ketel bestaat niet", ketelVerhuurService.verhuurKetel(10,10));
    }
}