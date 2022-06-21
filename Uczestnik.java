import java.util.ArrayList;

public abstract class Uczestnik {
    private ArrayList<Karta> reka = new ArrayList<Karta>(10);
    protected int numKart;

    private String imie;


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

    public void spalKarty(){
        for (int i = 0; i < this.reka.size(); i++) {
            this.reka.remove(i);
        }
    }

    public int getSumaReki() {
        int sumaReki = 0;
        int wartoscKarty;
        int liczbaAsow = 0;
        if(numKart <= 0){
            return 0;
        }
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
        if (sumaReki == 21){
            System.out.println("Black Jack!");
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

    public int getMocReki() {
        int mocReki = 0;
        for (int i = 0; i < numKart; i++) {
            mocReki += reka.get(i).getMoc();
        }
        return mocReki;
    }

    public int getSumaMocy(ArrayList<Karta> reka){
        int sumaMocy = 0;
        for (int i = 0; i < this.numKart; i++) {
            sumaMocy += this.reka.get(i).getMoc();
        }
        return sumaMocy;
    }

    public ArrayList<Karta> getReka(){
        return this.reka;
    }


}
