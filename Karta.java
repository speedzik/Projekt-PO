public class Karta {
    private Kolory kolor;
    private int wartosc;
    private int moc;

    public Karta(Kolory bjkolor, int bjwartosc) {
        this.kolor = bjkolor;
        this.wartosc = bjwartosc;

    }

    public int getWartosc() {
        return wartosc;
    }

    public String toString(){
        String intStr = "Nieznany";

        switch (this.wartosc) {
            case 1 -> intStr = "As";
            case 2 -> intStr = "Dwójka";
            case 3 -> intStr = "Trójka";
            case 4 -> intStr = "Czwórka";
            case 5 -> intStr = "Piątka";
            case 6 -> intStr = "Szóstka";
            case 7 -> intStr = "Siódemka";
            case 8 -> intStr = "Ósemka";
            case 9 -> intStr = "Dziewiątka";
            case 10 -> intStr = "Dziesiątka";
            case 11 -> intStr = "Walet";
            case 12 -> intStr = "Dama";
            case 13 -> intStr = "Król";
        }
        return intStr + " koloru " + kolor.toString();
    }

    public int getMoc() {
        int mocInt = 0;
        switch (this.moc){
            case 1 -> mocInt = -1;
            case 2 -> mocInt = 1;
            case 3 -> mocInt = 1;
            case 4 -> mocInt = 1;
            case 5 -> mocInt = 1;
            case 6 -> mocInt = 0;
            case 7 -> mocInt = 0;
            case 8 -> mocInt = 0;
            case 9 -> mocInt = 0;
            case 10 -> mocInt = -1;
            case 11 -> mocInt = -1;
            case 12 -> mocInt = -1;
            case 13 -> mocInt = -1;
        }return mocInt;
    }
}
