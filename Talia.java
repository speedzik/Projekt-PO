import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
public class Talia {

    private ArrayList<Karta> myTalia = new ArrayList<>();
    private int liczbaKart;
    private ArrayList<Karta> taliaOdrzuconych = new ArrayList<>();
    public Talia(int liczbaTalii, boolean czyPrzetasowane) {

        this.liczbaKart = liczbaTalii * 52;
        this.myTalia = new ArrayList<Karta>(this.liczbaKart);
        int n = 0;

        for (int j = 0; j < liczbaTalii; j++) {
            for (int i = 0; i < 4; i++) {
                for (int k = 1; k <= 13 ; k++) {
                    this.myTalia.add(new Karta(Kolory.values()[i],k));
                    n++;
                }
            }
        }
        if (czyPrzetasowane) {
            this.przetasuj();
        }
    }

    public void przetasuj() {
        Random rng = new Random();
        Karta temp;
        int m;
        for (int i = 0; i < this.liczbaKart; i++) {
            m = rng.nextInt(this.liczbaKart);
            temp = this.myTalia.get(i);
            this.myTalia.set(i,this.myTalia.get(m));
            this.myTalia.set(m,temp);
        }
    }

//    public ArrayList<Karta> shuffle() {
//        Collections.shuffle(myTalia);
//        return myTalia;
//    }

    public Karta rozdajKolejnaKarte() {
        Karta kartazGory = this.myTalia.get(0);
        this.myTalia.remove(0);
        return kartazGory;
    }

    public void printDeck(int numToPrint){
        for (int i = 0; i < numToPrint; i++) {
            System.out.println(i+1 + "/" + this.liczbaKart + " " + this.myTalia.get(i).toString());
        }
    }


}
