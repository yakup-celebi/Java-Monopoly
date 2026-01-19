public class Sehir {

    private String isim;
    private int satinAlma;
    private int kira;
    private boolean alinabilir;
    public Oyuncu sahibi; 

    public Sehir(String isim, int satinAlma, int kira, boolean alinabilir) {
        this.isim = isim;
        this.satinAlma = satinAlma;
        this.kira = kira;
        this.alinabilir = alinabilir;
        this.sahibi = null; 
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getSatinAlma() {
        return satinAlma;
    }

    public void setSatinAlma(int satinAlma) {
        this.satinAlma = satinAlma;
    }

    public int getKira() {
        return kira;
    }

    public void setKira(int kira) {
        this.kira = kira;
    }

    public boolean isAlinabilir() {
        return alinabilir;
    }

    public void setAlinabilir(boolean alinabilir) {
        this.alinabilir = alinabilir;
    }

    public Oyuncu getSahibi() {
        return sahibi;
    }

    public void setSahibi(Oyuncu sahibi) {
        this.sahibi = sahibi;
    }
}
