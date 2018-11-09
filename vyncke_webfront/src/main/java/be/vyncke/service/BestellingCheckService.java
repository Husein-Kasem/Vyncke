package be.vyncke.service;


public interface BestellingCheckService {

    public boolean checkBestellingGeldigheid(int Bestellingnr);

    public String checkBetaling(int Bestellingnr, int klantnr, int betaling);

    public String checkBestelling(int Bestellingnr, int klantnr);
}

