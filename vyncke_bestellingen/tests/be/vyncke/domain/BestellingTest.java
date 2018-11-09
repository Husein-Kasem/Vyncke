package be.vyncke.domain;
import org.junit.jupiter.api.*;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BestellingTest {

    static Bestelling bestelling;
    static int testBestellingId;
    static int testKlantId;
    static int testKetelId;
    static String testStatus;
    static Calendar calender;
    static Date today;
    static Date nextWeek;
    static Date nextNextWeek;



    @BeforeAll
    static void setup (){
        // nodige variabelen initialiseren
        calender = Calendar.getInstance();
        today = calender.getTime();
        calender.add(Calendar.DATE, 7);
        nextWeek = calender.getTime();
        calender.add(Calendar.DATE, 7);
        nextNextWeek = calender.getTime();

        testBestellingId = testKetelId = testKlantId = 1;
        testStatus = "Nieuw";
        bestelling = new Bestelling(nextWeek, testKetelId, testKlantId, testStatus);
    }

    @Test
    void setId() {
        this.bestelling.setId(testBestellingId);
        assertEquals(testBestellingId, bestelling.getId());

    }

    @Test
    void getId() {
        this.bestelling.setId(1);
        assertEquals(1,this.bestelling.getId());

    }

    @Test
    void setDatumAangemaakt() {
        this.bestelling.setDatumAangemaakt(new Date());
        assertEquals(new Date(), this.bestelling.getDatumAangemaakt());
    }

    @Test
    void getDatumAangemaakt() {
        Date date = this.bestelling.getDatumAangemaakt();
        assertEquals(date, this.bestelling.getDatumAangemaakt());
    }

    @Test
    void setDatumDeadline() {
        this.bestelling.setDatumDeadline(nextWeek);
        assertEquals(nextWeek, this.bestelling.getDatumDeadline());
    }

    @Test
    void getDatumDeadline() {
        this.bestelling.setDatumDeadline(nextWeek);
        assertEquals(nextWeek, this.bestelling.getDatumDeadline());
    }

    @Test
    void getKetel() {
        this.bestelling.setKetel(testKetelId);
        assertEquals(testKetelId, this.bestelling.getKetel());
    }

    @Test
    void setKetel() {
        this.bestelling.setKetel(testKetelId);
        assertEquals(testKetelId, this.bestelling.getKetel());
    }

    @Test
    void getKlant() {
        this.bestelling.setKlant(testKlantId);
        assertEquals(testKlantId, this.bestelling.getKlant());
    }

    @Test
    void setKlant() {
        this.bestelling.setKlant(testKlantId);
        assertEquals(testKlantId, this.bestelling.getKlant());
    }

    @Test
    void getStatus() {
        this.bestelling.setStatus(testStatus);
        assertEquals(testStatus, this.bestelling.getStatus());
    }

    @Test
    void setStatus() {
        this.bestelling.setStatus(testStatus);
        assertEquals(testStatus, this.bestelling.getStatus());
    }

    @Test
    void checkInitialisation() {
        Bestelling bestelling2 = new Bestelling();
        assertTrue(bestelling2 != null);
        Bestelling bestelling3 = new Bestelling(nextNextWeek, 1, 1, testStatus);
        assertFalse(bestelling3 == null);
    }
}