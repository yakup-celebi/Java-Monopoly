import java.util.Random;

public class SansKarti {

    private int miktar; 

    public SansKarti() {
        Random r = new Random();
        this.miktar = r.nextInt(401) - 200;
    }

    public void uygula(Oyuncu oyuncu) {
        oyuncu.setBakiye(oyuncu.getBakiye() + miktar);

        if (miktar >= 0) {
            System.out.println("Sans Karti: " + miktar + " kasadan al...");
        } else {
            System.out.println("Sans Karti: " + (-miktar) + " bankaya ode...");
        }
    }

    public int getEtki() {
        return miktar;
    }
}
