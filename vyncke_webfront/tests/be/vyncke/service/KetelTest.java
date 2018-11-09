package be.vyncke.service;

import be.vyncke.domain.Ketel;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class KetelTest {
    static Ketel ketel;


    @BeforeAll
    static void setup(){
        ketel = new Ketel();
    }

    @Test
    void setEnergieOutput_EP1() {
        try{
            ketel.setEnergieOutput(-5);
        }catch (Exception e){
            assertEquals("De energie output moet minder of gelijk aan 5000", e.getMessage());
        }
    }

    @Test
    void setEnergieOutput_EP2() {
        ketel.setEnergieOutput(1500);
        assertEquals(1500,ketel.getEnergieOutput());
    }

    @Test
    void setEnergieOutput_EP3() {
        try{
            ketel.setEnergieOutput(6000);
        }catch (Exception e){
            assertEquals("De energie output moet minder of gelijk aan 5000", e.getMessage());
        }
    }

    @Test
    void setEnergieOutput_BVA1() {
        try{
            ketel.setEnergieOutput(-1);
        }catch (Exception e){
            assertEquals("De energie output moet minder of gelijk aan 5000", e.getMessage());
        }
    }

    @Test
    void setEnergieOutput_BVA2() {
        ketel.setEnergieOutput(0);
        assertEquals(0,ketel.getEnergieOutput());
    }

    @Test
    void setEnergieOutput_BVA3() {
        ketel.setEnergieOutput(1);
        assertEquals(1,ketel.getEnergieOutput());
    }

    @Test
    void setEnergieOutput_BVA4() {
        ketel.setEnergieOutput(4999);
        assertEquals(4999,ketel.getEnergieOutput());
    }
    @Test
    void setEnergieOutput_BVA5() {
        ketel.setEnergieOutput(5000);
        assertEquals(5000,ketel.getEnergieOutput());
    }
    @Test
    void setEnergieOutput_BVA6() {
        try{
            ketel.setEnergieOutput(5001);
        }catch (Exception e){
            assertEquals("De energie output moet minder of gelijk aan 5000", e.getMessage());
        }
    }
}