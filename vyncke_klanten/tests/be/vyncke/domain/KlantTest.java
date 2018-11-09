package be.vyncke.domain;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class KlantTest {

    static Klant klant;
    static int testKlantId;
    static int testAge;
    static String testVoornaam;
    static String testNaam;
    static String testEmail;
    static String testPassword;



    @BeforeAll
    static void setup (){
        // nodige variabelen initialiseren
        testKlantId = 1;
        testAge = 28;
        testVoornaam = "Husein";
        testNaam = "Kasem";
        testEmail = "husein.kasem.90@gmail.com";
        testPassword = "password";
        klant = new Klant(testVoornaam, testNaam, testEmail, testPassword, testAge);
    }

    @Test
    void initTest() {
        //default constructor
        Klant newKlant = new Klant();
        assertFalse(newKlant == null);
        //constructor met parameters
        Klant newKlant2 = new Klant("voornaam","naam","email@gmail.com", "password", 20);
        assertTrue(newKlant != null);
    }

    @Test
    void idTest() {
        klant.setId(testKlantId);
        assertEquals(testKlantId, klant.getId());
    }

    @Test
    void voornaamTest() {
        //normaal geval
        klant.setVoornaam("Husein");
        assertEquals("Husein", klant.getVoornaam());
        // te lang voornaam
        String langVoornaam = "lannnnnngggggg voornaaaaaaammmmmmmmmmmmmmmmmmm";
        klant.setVoornaam(langVoornaam);
        assertEquals(langVoornaam.substring(0,20), klant.getVoornaam());
        // lege voornaam
        try{
            klant.setVoornaam("");
        }catch (Exception e){
            assertEquals(e.getMessage(), "De naam mag niet leeg zijn");
        }
    }

    @Test
    void naamTest() {
        //normaal geval
        klant.setNaam(testNaam);
        assertEquals(testNaam, klant.getNaam());
        // lege naam
        klant.setNaam("");
        assertEquals("no name", klant.getNaam());
        // te lang naam
        String langNaam = "lannnnnngggggg naaaaaaammmmmmmmmmmmmmmmmmm";
        klant.setNaam(langNaam);
        assertEquals(langNaam.substring(0,20), klant.getNaam());
    }

    @Test
    void naamTest1() {
        String naam = "naam";
        String langNaam = "lannnnnngggggg naaaaaaammmmmmmmmmmmmmmmmmm";

        klant.setNaam(naam);
        boolean isNaamTeLang = naam.length() > 20;

        if (naam != null && isNaamTeLang){
            assertTrue(klant.getNaam().length() == 20);
        }else{
            assertFalse(klant.getNaam().length() > 20);
        }

        klant.setNaam(langNaam);
        isNaamTeLang = langNaam.length() > 20;

        if (langNaam != null && isNaamTeLang){
            assertTrue(klant.getNaam().length() == 20);
        }else{
            assertFalse(klant.getNaam().length() > 20);
        }
    }

    @Test
    void naamTest3() {
        //normaal geval
        String leegNaam = "";
        String naam = "naam";
        boolean isNaamTeKort = naam.length() == 0;
        boolean isLeegNaamTeKort = leegNaam.length() == 0;
        klant.setNaam(testNaam);
        assertEquals(testNaam, klant.getNaam());
        // lege naam
        klant.setNaam("");
        assertEquals("no name", klant.getNaam());
        // te lang naam
        String langNaam = "lannnnnngggggg naaaaaaammmmmmmmmmmmmmmmmmm";
        klant.setNaam(langNaam);
        assertEquals(langNaam.substring(0,20), klant.getNaam());
    }

    @Test
    void emailTest() {
        klant.setEmail(testEmail);
        assertEquals(testEmail, klant.getEmail());
    }

    @Test
    void passwordTest() {
        klant.setPasswoord(testPassword);
        assertEquals(testPassword, klant.getPasswoord());
    }

    @Test
    void ageTest() {
        // normaal geval
        klant.setAge(20);
        assertEquals(20, klant.getAge());

    }

    @Test
    void ageTest2(){
        // te klein leeftijd
        try{
            klant.setAge(-10);
        }catch (Exception e){
            assertEquals(e.getMessage(), "De leeftijd mag niet 0 of nigatieve nummer zijn");
        }
    }

    @Test
    void ageTest3() {
        // te groot leeftijd
        try {
            klant.setAge(1000);
        }catch (Exception e){
            assertEquals(e.getMessage(), "De leeftijd mag niet meer dan 120 zijn");
        }
    }
}