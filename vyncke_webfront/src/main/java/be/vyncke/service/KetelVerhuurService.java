package be.vyncke.service;

public interface KetelVerhuurService {
    public boolean checkKetelBestaat(int ketelId);
    public boolean checkKetelVerhuurd(int ketelId);
    public boolean checkKlantBestaat(int klantId);
    public String verhuurKetel(int keltelId, int klantId);
}
