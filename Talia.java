import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
public class Talia {



    private ArrayList<Karta> myTalia = new ArrayList<>();
    private int liczbaKart;

    public Talia(){
        this(1,false);
    }

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
    }

//    public void przetasuj() {
//        Random rng = new Random();
//        ArrayList<Karta> tmpTalia = new ArrayList<Karta>();
//        int m = 0;
//        int oryginalnyrozmiar = this.liczbaKart;
//        for (int i = 0; i < oryginalnyrozmiar; i++) {
//            m = rng.nextInt(this.liczbaKart);
//            tmpTalia.add(this.myTalia.get(m));
//            this.myTalia.remove(m);
//        }
//        this.myTalia = tmpTalia;
//    }

    public ArrayList<Karta> shuffle() {
        Collections.shuffle(myTalia);
        return myTalia;
    }

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
