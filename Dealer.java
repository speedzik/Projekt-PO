import java.util.ArrayList;
public class Dealer extends Uczestnik{
    private ArrayList<Karta> reka = new ArrayList<>();
    public Dealer(){
    }
    public ArrayList<String> pokazReke(boolean czykoniec) {
        ArrayList<String> rekaDString = new ArrayList<>();
        System.out.println("karty dealera: ");
        if (!czykoniec) {
            rekaDString.add(0, "UKRYTA");
            for (int i = 1; i < this.reka.size(); i++) {
                rekaDString.add(i, reka.get(i).toString());
            }
        } else {
            for (int i = 0; i < this.reka.size(); i++) {
                rekaDString.add(i, reka.get(i).toString());
            }
        }
       return rekaDString;
    }

    public Karta dodajKarte(Karta bjKarta) {
        if(this.numKart == 10) {
            System.err.print("Za duzo kart!");
            System.exit(1);
        }
        this.reka.add(bjKarta);
        this.numKart++;
        return bjKarta;
    }


}
