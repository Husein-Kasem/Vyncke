package be.vyncke.service;


import be.vyncke.domain.Ketel;

public interface KetelService {
    Ketel ketelKaken();
    String ketelUitlenen(Ketel ketel);
    String ketelTerughalen(Ketel ketel);
    String ketelLatenRepareren(Ketel ketel);
    String ketelBeschikbaarZetten(Ketel ketel);
    String ketelOnrepareerbaarVerklaren(Ketel ketel);
}

