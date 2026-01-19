
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("MONOPOLY'E  HOSGELDINIZ...");
        System.out.print("Kac kisi oynamak istersiniz? ");
        int kisiSayisi =scanner.nextInt();
        scanner.nextLine();
        ArrayList<Oyuncu> oyuncular = new ArrayList<Oyuncu>();
        
   
        for(int i=0; i<kisiSayisi;i++){
            System.out.print((i+1) +". kisinin adini giriniz: ");
            String oyunucIsim = scanner.nextLine();
            ArrayList<Integer> baslangic = new ArrayList<Integer>();
            baslangic.add(0);
            baslangic.add(0);           
            Oyuncu o = new Oyuncu(oyunucIsim, 2000, null, baslangic, 0);
            oyuncular.add(o);
        }
        
        for(int i=0; i<kisiSayisi;i++){
            System.out.println((i+1)+". kisi: "+oyuncular.get(i).getIsim()+" Butcesi: "+oyuncular.get(i).getBakiye());
        }
        System.out.println("Ayni sehirde birden fazla oyuncu olursa sadece ilk gelen oyuncu gozukur...");
        OyunTahtasi oyunTahtasi = new OyunTahtasi(); 
        
        while(oyuncular.size()>1){
        for (int i=0;i<oyuncular.size();i++){
                Oyuncu o = oyuncular.get(i);
                oyunTahtasi.ilerleme(o,oyuncular);
                
                if(o.getBakiye() <= 0) {
                    System.out.println(o.getIsim() + " IFLAS ETTI!!!");
                    oyunTahtasi.iflasEdeninSehriniSilme(o);
                    oyuncular.remove(i);
                    i--;
                         break;
                }else{
                    System.out.println(o.getIsim() + " bakiye: " + o.getBakiye());
                }
            }
        }          
    }    
}
