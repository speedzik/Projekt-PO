import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
public class Talia {

    private ArrayList<Karta> myTalia = new ArrayList<>();
    public int liczbaKart;

    public Talia(int liczbaTalii, boolean czyPrzetasowane) {

        liczbaKart = liczbaTalii * 52;
        myTalia = new ArrayList<Karta>(this.liczbaKart);


        for (int j = 0; j < liczbaTalii; j++) {
            for (int i = 0; i < 4; i++) {
                for (int k = 1; k <= 13 ; k++) {
                    myTalia.add(new Karta(Kolory.values()[i],k));
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
            temp = myTalia.get(i);
            myTalia.set(i,myTalia.get(m));
            myTalia.set(m,temp);
        }
    }

//    public ArrayList<Karta> shuffle() {
//        Collections.shuffle(myTalia);
//        return myTalia;
//    }

    public Karta rozdajKolejnaKarte() {
        Karta kartazGory = myTalia.get(0);
        myTalia.remove(0);
        liczbaKart--;
        return kartazGory;
    }

    public void printDeck(){
        for (int i = 0; i < liczbaKart; i++) {
            System.out.println(i+1 + "/" + this.liczbaKart + " " + this.myTalia.get(i).toString());
        }
    }

    public int getLiczbaKart(){
        return liczbaKart;
    }


}
