import java.util.ArrayList;
import java.util.Random;


public class Gracz {
    private String imie;
    private ArrayList<Karta> reka = new ArrayList<Karta>(10);
    protected int numKart;
    private int parametr_reki;

    private int parametr_stolu;

    private int bank = 1100;

    public Gracz(){

    }

    public Gracz(String imie) {
        Random rpg = new Random();
        this.imie = imie;
        this.parametr_reki = rpg.nextInt(15,20);
        this.wyczyscReke();
        this.parametr_stolu = rpg.nextInt(-2, 10);
    }

    public void wyczyscReke() {
        if (this.reka.size() != 0) {
            for (int i = 0; i < 10; i++) {
                this.reka.remove(0);
            }
            this.numKart = 0;
        }
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

    public int getSumaReki() {
        int sumaReki = 0;
        int wartoscKarty;
        int liczbaAsow = 0;

        for (int i = 0; i < this.numKart; i++) {
            wartoscKarty = this.reka.get(i).getWartosc();

            if (wartoscKarty == 1) {
                liczbaAsow++;
                sumaReki += 11;
            } else if (wartoscKarty > 10) {
                sumaReki += 10;
            } else {
                sumaReki += wartoscKarty;
            }
        }
        while(sumaReki > 21 && liczbaAsow > 0) {
            sumaReki -= 10;
            liczbaAsow--;
        }
        return sumaReki;
    }
    public ArrayList<String> pokazRekeGracza() {
        ArrayList<String> rekaString = new ArrayList<>();
        System.out.println("karty gracza " + this.imie + ": ");
        for (int i = 0; i < this.reka.size(); i++) {
            rekaString.add(i, reka.get(i).toString());
        }
        return rekaString;
    }

    public int getSumaMocy(ArrayList<Karta> reka){
        int sumaMocy = 0;
        for (int i = 0; i < this.numKart; i++) {
            sumaMocy += this.reka.get(i).getMoc();
        }
        return sumaMocy;
    }

    public boolean czyParametr_RekiZgodny() {
        return this.getSumaReki() <= parametr_reki;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public int getMocReki(int mocReki) {
        mocReki = 0;
        for (int i = 0; i < 10; i++) {
            mocReki += this.reka.get(i).getMoc();
        }
        return mocReki;
    }

    public int wygrana() {
        bank += 150;
        return bank;
    }

    public int przegrana() {
        bank -= 100;
        return bank;
    }

    public int getBank() {
        return bank;
    }

    public int getParametr_stolu() {
        return parametr_stolu;
    }
}
