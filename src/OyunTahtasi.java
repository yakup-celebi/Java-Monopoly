import java.awt.BorderLayout;
import java.util.List;
import java.util.Scanner;

public class OyunTahtasi {

    private Sehir[][] konum;

    public OyunTahtasi() {
        konum = new Sehir[10][10];

        konum[0][0] = new Sehir("Baslangic", 0, 0, false);
        konum[0][3] = new Sehir("Vergi", 0, 200, false);
        konum[0][6] = new Sehir("Sans Karti", 0, 0, false);
        konum[0][9] = new Sehir("Kodes", 0, 0, false);
        konum[3][9] = new Sehir("Sans Karti", 0, 0, false);
        konum[6][9] = new Sehir("Sans Karti", 0, 0, false);
        konum[9][9] = new Sehir("Ucretsiz Otopark", 0, 0, false);
        konum[9][6] = new Sehir("Sans Karti", 0, 0, false);
        konum[9][3] = new Sehir("Sans Karti", 0, 0, false);
        konum[9][0] = new Sehir("Kodese Gir", 0, 0, false);
        konum[6][0] = new Sehir("Sans Karti", 0, 0, false);
        konum[3][0] = new Sehir("Vergi", 0, 100, false);

        konum[0][1] = new Sehir("Usak", 80, 20, true);
        konum[0][2] = new Sehir("Bartin", 100, 25, true);
        konum[0][4] = new Sehir("Batman", 120, 30, true);
        konum[0][5] = new Sehir("Malatya", 140, 35, true);
        konum[0][7] = new Sehir("Manisa", 160, 40, true);
        konum[0][8] = new Sehir("Mardin", 180, 45, true);
        konum[1][9] = new Sehir("Diyarbakir", 190, 50, true);
        konum[2][9] = new Sehir("Isparta", 200, 60, true);
        konum[4][9] = new Sehir("Afyon", 210, 65, true);
        konum[5][9] = new Sehir("Konya", 230, 70, true);
        konum[7][9] = new Sehir("Bolu", 250, 75, true);
        konum[8][9] = new Sehir("Zonguldak", 80, 200, true);
        konum[9][8] = new Sehir("Duzce", 270, 85, true);
        konum[9][7] = new Sehir("Bursa", 280, 90, true);
        konum[9][5] = new Sehir("Eskisehir", 290, 95, true);
        konum[9][4] = new Sehir("Maras", 300, 100, true);
        konum[9][2] = new Sehir("Kayseri", 310, 110, true);
        konum[9][1] = new Sehir("Antalya", 320, 120, true);
        konum[8][0] = new Sehir("Mugla", 340, 130, true);
        konum[7][0] = new Sehir("Izmir", 360, 140, true);
        konum[5][0] = new Sehir("Kocaeli", 380, 150, true);
        konum[4][0] = new Sehir("Istanbul", 400, 160, true);
        konum[2][0] = new Sehir("Ankara", 450, 180, true);
        konum[1][0] = new Sehir("Cankiri", 500, 200, true);
    }

    public void tahtaYazdir(List<Oyuncu> oyuncular) {
        int hucreGenisligi = 14;
            System.out.println("#########################################################################################################################################");

        for (int i = 0; i < konum.length; i++) {
            StringBuilder sehirSatiri = new StringBuilder();
            StringBuilder oyuncuSatiri = new StringBuilder();
            for (int j = 0; j < konum[i].length; j++) {           
                String hucre = "----";            
                if (konum[i][j] != null) {
                    hucre = konum[i][j].getIsim();
                }            
                if (hucre.length() > hucreGenisligi - 1) {
                    hucre = hucre.substring(0, hucreGenisligi - 1);
                }            
                sehirSatiri.append(String.format("%-" + hucreGenisligi + "s", hucre));
                String oyuncuHucre = "";
                for (Oyuncu o : oyuncular) {
                    int x = o.getBulunduguYer().get(0);
                    int y = o.getBulunduguYer().get(1);
                    if (x == i && y == j) {
                        oyuncuHucre = "[" + o.getIsim() + "]";
                        break;
                    }
                }           
                if (oyuncuHucre.length() > hucreGenisligi - 1) {
                    oyuncuHucre = oyuncuHucre.substring(0, hucreGenisligi - 1);
                }            
                oyuncuSatiri.append(String.format("%-" + hucreGenisligi + "s", oyuncuHucre));
            }
            System.out.println(sehirSatiri.toString());
            System.out.println(oyuncuSatiri.toString());
        }
        System.out.println("############################################################################################################################################");

    }

    public void ilerleme(Oyuncu oyuncu,List<Oyuncu> oyuncular) {
        if (oyuncu.getKodes()> 0) {
            oyuncu.setKodes(oyuncu.getKodes()- 1);
            System.out.println(oyuncu.getIsim() + " kodeste. Bu tur zar atamaz. Kalan tur sayisi: " + oyuncu.getKodes());
            return;
        }
        System.out.println("############################################################################################################################################");
        System.out.println(oyuncu.getIsim()+"\n"
                +" Once varliklarinizi gorup sonra zar atamak icin #goster# yaziniz.\n"
                +" Zar atmak icin enter tusuna basiniz...");
        Scanner scanner = new Scanner(System.in);
        String goster = scanner.nextLine();
        if(goster.equals("goster")){
            System.out.println(oyuncu.getIsim()+" kisisnin bakiyesi: "+oyuncu.getBakiye());
            System.out.println(oyuncu.getIsim()+" kisisnin bulundugu yer: "+oyuncu.getBulunduguYer());
            System.out.println(oyuncu.getIsim()+" kisisnin sahip oldugu sehirler: ");
            for(String a: oyuncu.getSahipOlduguSehirler()){
                System.out.println(a);
            }
        }
        Zar zar = new Zar();
        int adim = zar.zarAt();
        
        System.out.println(oyuncu.getIsim() + " zar atti: " + adim);

        int x = oyuncu.getBulunduguYer().get(0);
        int y = oyuncu.getBulunduguYer().get(1);

        for (int i = 0; i < adim; i++) {
            
            if (x == 0 && y == 0 && i != 0) {
                oyuncu.setBakiye(oyuncu.getBakiye() + 200);
                System.out.println(oyuncu.getIsim() + " kisisi baslangictan gectigi icin 200 aldi.");
            }
            
            if(x == 0 && y < 9) {
                y++;
            }
            else if(y == 9 && x < 9) {
                x++;
            }
            else if(x == 9 && y > 0) {
                y--;
            }
            else if(y == 0 && x > 0) {
                x--;
            }
        }

        oyuncu.getBulunduguYer().set(0, x);
        oyuncu.getBulunduguYer().set(1, y);
        System.out.println(oyuncu.getIsim() + " yeni konumu: [" + x + "," + y + "]");

        Sehir sehir = konum[x][y];
        if (sehir != null) {   
            System.out.println("Bakiyesi: "+oyuncu.getBakiye());
            tahtaYazdir(oyuncular);

            if (sehir.isAlinabilir() && sehir.getSahibi() == null) {
                System.out.println("Geldiginiz yer "+ sehir.getIsim() +" sahibi yok...");
                System.out.println(sehir.getIsim()+" sehrinin fiyati: "+sehir.getSatinAlma());
                System.out.println(oyuncu.getIsim()+ " kisisinin bakiyesi: "+oyuncu.getBakiye());
                if (oyuncu.getBakiye() >= sehir.getSatinAlma()) {                    
                    boolean dongu = true;
                    while(dongu){
                        System.out.print(oyuncu.getIsim()+" almak ister misiniz? (e h)");
                        String almakİstermi = scanner.nextLine();
                        if(almakİstermi.equals("e")){
                            oyuncu.setBakiye(oyuncu.getBakiye() - sehir.getSatinAlma());
                            oyuncu.getSahipOlduguSehirler().add(sehir.getIsim());
                            sehir.setSahibi(oyuncu);
                            System.out.println(sehir.getIsim() + " satin alindi...");
                            dongu=false;
                        }else if(almakİstermi.equals("h")){
                            System.out.println("Alinmadan devam ediliyor");
                            dongu = false;
                        }else{
                            System.out.println("Hatali tuslama yaptiniz tekrar deneyiniz...");
                        }
                    }
                }        
            } else if (sehir.getSahibi() != null && sehir.getSahibi() != oyuncu) {
                System.out.println("Geldiginiz yerin sahibi: "+sehir.getSahibi().getIsim());
                if(oyuncu.getBakiye()>= sehir.getKira()){
                    oyuncu.setBakiye(oyuncu.getBakiye() - sehir.getKira());
                    sehir.getSahibi().setBakiye(sehir.getSahibi().getBakiye() + sehir.getKira());
                    System.out.println(sehir.getSahibi().getIsim()+" kisisine "+sehir.getKira()+" tutari odendi");
                }else{
                    System.out.println("Geldiginiz yerin sahibi: "+sehir.getSahibi().getIsim()+" maalesef kirayi odeyecek paraniz yokk");
                    oyuncu.setBakiye(oyuncu.getBakiye()-sehir.getKira());
                }
            }else if(sehir.getSahibi()==oyuncu){
                System.out.println(sehir.getIsim()+" kendi sehrine geldi...");
            }else if (sehir.getIsim().equals("Kodese Gir")) {
                oyuncu.getBulunduguYer().set(0, 0);
                oyuncu.getBulunduguYer().set(1, 9);
                oyuncu.setKodes(2);
                System.out.println(oyuncu.getIsim() + " kodese girdiniz 2 tur oynamayacaksiniz...");
            return;
            }else if(sehir.getIsim().equals("Sans Karti")){
                System.out.println("Sans kartina geldiniz!");
                SansKarti kart = new SansKarti();
                kart.uygula(oyuncu);
                System.out.println(oyuncu.getIsim()+ " kisisinin bakiyesi: "+oyuncu.getBakiye());
            }else if(sehir.getIsim().equals("Vergi")){
                oyuncu.setBakiye(oyuncu.getBakiye()-sehir.getKira());
                System.out.println(oyuncu.getIsim()+" kisisi "+sehir.getKira()+" kadar vergi odedi...");
                System.out.println(oyuncu.getIsim()+ " kisisinin bakiyesi: "+oyuncu.getBakiye());                        
            }else if(sehir.getIsim().equals("Ucretsiz Otopark")){               
                System.out.println(oyuncu.getIsim()+" ucretsiz otoparka geldiniz...");                        
            }else if(sehir.getIsim().equals("Kodes")){               
                System.out.println(oyuncu.getIsim()+" kodesde ziyaretcisizniz...");                        
            }
       }
    }
    
    public void iflasEdeninSehriniSilme(Oyuncu oyuncu){
        for (int i = 0; i < konum.length; i++) {
            for (int j = 0; j < konum[i].length; j++) {
                Sehir s = konum[i][j];
                if (s != null && s.getSahibi() == oyuncu) {
                    s.setSahibi(null);
                }
            }
        }
    }
    
}
