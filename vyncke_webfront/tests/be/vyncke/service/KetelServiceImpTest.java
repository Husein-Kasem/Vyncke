package be.vyncke.service;

import be.vyncke.domain.Ketel;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

class KetelServiceImpTest {

    static KetelServiceImp ketelServiceImp;
    static Ketel ketel;

    @BeforeAll
    static void setup(){
        ketelServiceImp = new KetelServiceImp();
    }

    @Test
    void TC1() {
        // no status >> Beschikbaar (S0 - 1)
        ketel = ketelServiceImp.ketelKaken();
        assertThat(ketel.getStatus().equals("Beschikbaar"));
        // Beschikbaar >> Uitgeleend (S1 - 2)
        assertThat(ketelServiceImp.ketelUitlenen(ketel).equals("Uitgeleend"));
        // Uitgeleend >> Beschikbaar (S2 - 1)
        assertThat(ketelServiceImp.ketelTerughalen(ketel).equals("Beschikbaar"));
    }

    @Test
    void TC2() {
        // Beschikbaar >> Onder reparatie (S1 - 3)
        assertThat(ketelServiceImp.ketelLatenRepareren(ketel).equals("Onder reparatie"));
        // Onder reparatie >> Beschikbaar (S3 - 1)
        assertThat(ketelServiceImp.ketelBeschikbaarZetten(ketel).equals("Beschikbaar"));
        // Beschikbaar >> Onder reparatie (S1 - 3)
        assertThat(ketelServiceImp.ketelLatenRepareren(ketel).equals("Onder reparatie"));
        // Onder reparatie >> Kapot (S3 - 4)
        assertThat(ketelServiceImp.ketelOnrepareerbaarVerklaren(ketel).equals("Kapot"));
    }

    @Test
    void TC3() {
        ketel = ketelServiceImp.ketelKaken();
        ketel.setStatus("Onder reparatie");
        // Onder reparatie >> Beschikbaar (S3 - 1)
        assertThat(ketelServiceImp.ketelBeschikbaarZetten(ketel).equals("Beschikbaar"));
        // Beschikbaar >> Uitgeleend (S1 - 2)
        assertThat(ketelServiceImp.ketelUitlenen(ketel).equals("Uitgeleend"));
        // Uitgeleend >> Beschikbaar (S2 - 1)
        assertThat(ketelServiceImp.ketelTerughalen(ketel).equals("Beschikbaar"));
        // Beschikbaar >> Onder reparatie (S1 - 3)
        assertThat(ketelServiceImp.ketelLatenRepareren(ketel).equals("Onder reparatie"));
        // Onder reparatie >> Beschikbaar (S3 - 1)
        assertThat(ketelServiceImp.ketelBeschikbaarZetten(ketel).equals("Beschikbaar"));
        // Beschikbaar >> Onder reparatie (S1 - 3)
        assertThat(ketelServiceImp.ketelLatenRepareren(ketel).equals("Onder reparatie"));
    }

    @Test
    void TC4() {
        // no status >> Beschikbaar (S0 - 1)
        ketel = ketelServiceImp.ketelKaken();
        assertThat(ketel.getStatus().equals("Beschikbaar"));
        // Beschikbaar >> Uitgeleend (S1 - 2)
        assertThat(ketelServiceImp.ketelUitlenen(ketel).equals("Uitgeleend"));
        // Uitgeleend >> Beschikbaar (S2 - 1)
        assertThat(ketelServiceImp.ketelTerughalen(ketel).equals("Beschikbaar"));
        // Beschikbaar >> Onder reparatie (S1 - 3)
        assertThat(ketelServiceImp.ketelLatenRepareren(ketel).equals("Onder reparatie"));
        // Onder reparatie >> Beschikbaar (S3 - 1)
        assertThat(ketelServiceImp.ketelBeschikbaarZetten(ketel).equals("Beschikbaar"));
        // Beschikbaar >> Onder reparatie (S1 - 3)
        assertThat(ketelServiceImp.ketelLatenRepareren(ketel).equals("Onder reparatie"));
        // Onder reparatie >> Kapot (S3 - 4)
        assertThat(ketelServiceImp.ketelOnrepareerbaarVerklaren(ketel).equals("Kapot"));
    }

    @Test
    void TC5(){
        ketel = ketelServiceImp.ketelKaken();
        // Beschikbaar >> Uitgeleend (S1 - 2)
        assertThat(ketelServiceImp.ketelUitlenen(ketel).equals("Uitgeleend"));
        // Uitgeleend >> Beschikbaar (S2 - 1)
        assertThat(ketelServiceImp.ketelTerughalen(ketel).equals("Beschikbaar"));
        // Beschikbaar >> Onder reparatie (S1 - 3)
        assertThat(ketelServiceImp.ketelLatenRepareren(ketel).equals("Onder reparatie"));
        // Onder reparatie >> Kapot (S3 - 4)
        assertThat(ketelServiceImp.ketelOnrepareerbaarVerklaren(ketel).equals("Kapot"));
    }

    @Test
    void TC6(){
        // no status >> Beschikbaar (S0 - 1)
        ketel = ketelServiceImp.ketelKaken();
        assertThat(ketel.getStatus().equals("Beschikbaar"));
        // Beschikbaar >> Uitgeleend (S1 - 2)
        assertThat(ketelServiceImp.ketelUitlenen(ketel).equals("Uitgeleend"));
        // Uitgeleend >> Onder reparatie (S2 - 3) IllegalStateException expected
        try{
            ketelServiceImp.ketelLatenRepareren(ketel);
        }catch (Exception e){
            assertThat("De ketel is niet beschikbaar en kan niet naar reparatie gestuurd worden"
                    .equals(e.getMessage()));
        }
        ketel.setStatus("Kapot");
        // Kapot >> Beschikbaar (S4 - 1) IllegalStateException expected
        try {
            ketelServiceImp.ketelTerughalen(ketel);
        }catch (Exception e){
            assertThat("De ketel is niet uitgeleed en kan niet teruggehaald worden"
                    .equals(e.getMessage()));
        }
    }
}