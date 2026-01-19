
import java.util.ArrayList;
import java.util.List;

public class Oyuncu {

    public String isim;
    public int bakiye;
    public List<String> sahipOlduguSehirler;
    public ArrayList<Integer> bulunduguYer;
    private Integer kodes=0;

    public Oyuncu(String isim, int bakiye, List<String> sahipOlduguSehirler, ArrayList<Integer> bulunduguYer,Integer kodes) {
        this.isim = isim;
        this.bakiye = bakiye;
        this.sahipOlduguSehirler =  (sahipOlduguSehirler != null) ? sahipOlduguSehirler : new ArrayList<>();
        this.kodes = kodes;
        this.bulunduguYer = bulunduguYer;
    }

    public Integer getKodes() {
        return kodes;
    }

    public void setKodes(Integer kodes) {
        this.kodes = kodes;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getBakiye() {
        
        return bakiye;
    }

    public void setBakiye(int bakiye) {
        this.bakiye = bakiye;
    }

    public List<String> getSahipOlduguSehirler() {
        return sahipOlduguSehirler;
    }

    public void setSahipOlduguSehirler(List<String> sahipOlduguSehirler) {
        this.sahipOlduguSehirler = sahipOlduguSehirler;
    }

    public ArrayList<Integer> getBulunduguYer() {
        return bulunduguYer;
    }

    public void setBulunduguYer(ArrayList<Integer> bulunduguYer) {
        this.bulunduguYer = bulunduguYer;
    }
    
}
