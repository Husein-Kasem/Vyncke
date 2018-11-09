package be.vyncke.service;

import be.vyncke.domain.Ketel;

public class KetelServiceImp implements KetelService {
    @Override
    public Ketel ketelKaken() {
        Ketel ketel = new Ketel("X50", 400);
        ketel.setStatus("Beschikbaar");
        return ketel;
    }

    @Override
    public String ketelUitlenen(Ketel ketel) {
        if (ketel.getStatus() == "Beschikbaar"){
            ketel.setStatus("Uitgeleend");
        }else{
            throw new IllegalStateException("De ketel is niet beschikbaar en kan niet uitgeleed worden");
        }
        return ketel.getStatus();
    }

    @Override
    public String ketelTerughalen(Ketel ketel) {
        if (ketel.getStatus() == "Uitgeleend"){
            ketel.setStatus("Beschikbaar");
        }else{
            throw new IllegalStateException("De ketel is niet uitgeleed en kan niet teruggehaald worden");
        }
        return ketel.getStatus();
    }

    @Override
    public String ketelLatenRepareren(Ketel ketel) {
        if (ketel.getStatus() == "Beschikbaar"){
            ketel.setStatus("Onder reparatie");
        }else{
            throw new IllegalStateException("De ketel is niet beschikbaar en kan niet naar reparatie gestuurd worden");
        }
        return ketel.getStatus();
    }

    @Override
    public String ketelBeschikbaarZetten(Ketel ketel) {
        if (ketel.getStatus() == "Onder reparatie"){
            ketel.setStatus("Beschikbaar");
        }else{
            throw new IllegalStateException("De ketel is niet onder reparatie en kan niet beschikbaar gezet worden");
        }
        return ketel.getStatus();
    }

    @Override
    public String ketelOnrepareerbaarVerklaren(Ketel ketel) {
        if (ketel.getStatus() == "Onder reparatie"){
            ketel.setStatus("Kapot");
        }else{
            throw new IllegalStateException("De ketel is niet onder reparatie en kan niet als onrepareerbaar verklaard worden");
        }
        return ketel.getStatus();
    }
}
