
import java.util.ArrayList;
import java.util.Scanner;
public class GraBlackjack {
    private Scanner scanner = new Scanner(System.in);
    private int liczbagraczy;
    private ArrayList<Gracz> gracze = new ArrayList<Gracz>();
    private Dealer dealer = new Dealer();
    private int mocStolu;

    private ArrayList<Gracz> grajacy = new ArrayList<Gracz>();


    private int liczbaObecnieGrajacych;
    private Talia talia = new Talia(3, true);

    public void rozpocznijGre() {
        String imiona;
        Dealer dealer = new Dealer();
        System.out.println("Ile osób gra (1-6)");
        liczbagraczy = scanner.nextInt();
        mocStolu = 0;

        if (liczbagraczy < 1 || liczbagraczy > 6) {
            System.err.println("Zla liczba graczy!");
            System.exit(1);
        }
        for (int i = 0; i < liczbagraczy; i++) {
            System.out.println("Podaj imie gracza nr " + (i + 1) + " !");
            imiona = scanner.next();
            gracze.add(new Gracz(imiona));
        }

        System.out.println("Iloma taliami chcesz zagrac?");
        int n = scanner.nextInt();
        Talia talia = new Talia(n, true);
    }


        public void symulacja(){
        talia.printDeck();

            for (int c = 0; c < liczbagraczy; c++) {
                if (gracze.get(c).getBank()>=0 && mocStolu <= gracze.get(c).getParametr_stolu()){
                    grajacy.add(gracze.get(c));
                }
            }

        for (int m = 0; m < 2; m++) {
            dealer.dodajKarte(talia.rozdajKolejnaKarte());
                for (int i = 0; i < grajacy.size(); i++) {
                        if (grajacy.get(i).getBank() >= 0) {
                            mocStolu += talia.rozdajKolejnaKarte().getMoc();
                            grajacy.get(i).dodajKarte(talia.rozdajKolejnaKarte());
                        }

                }
            }

        System.out.println(dealer.pokazReke(false));
        liczbaObecnieGrajacych = grajacy.size();
        for (int i = 0; i < liczbaObecnieGrajacych; i++) {
            System.out.println(grajacy.get(i).pokazRekeGracza() + " " + grajacy.get(i).getSumaReki());           System.out.println(grajacy.get(i).getSumaMocy(grajacy.get(i).getReka()));
            System.out.println(grajacy.get(i).getParametr_reki());
            System.out.println(mocStolu);
            mocStolu += grajacy.get(i).getSumaMocy(grajacy.get(i).getReka());
        }

        for (int i = 0; i < liczbaObecnieGrajacych; i++) {
            while (grajacy.get(i).getParametr_reki() > grajacy.get(i).getSumaReki() && mocStolu <= grajacy.get(i).getParametr_stolu()) {
                System.out.println(grajacy.get(i).getImie() + " dobiera karte");
                grajacy.get(i).dodajKarte(talia.rozdajKolejnaKarte());
                System.out.println(grajacy.get(i).pokazRekeGracza() + " " + grajacy.get(i).getSumaReki());
            }
        }
        dealer.pokazReke(true);

        while (dealer.getSumaReki() < 21) {
            System.out.println("Dealer dobiera karte");
            mocStolu += talia.rozdajKolejnaKarte().getMoc();
            dealer.dodajKarte(talia.rozdajKolejnaKarte());
            System.out.println(dealer.pokazRekeGracza() + " " + dealer.getSumaReki());
        }
            System.out.println(mocStolu);

            for (int i = 0; i < liczbaObecnieGrajacych; i++) {
                if(dealer.getSumaReki() > grajacy.get(i).getSumaReki() && !(grajacy.get(i).getSumaReki() > 21) && dealer.getSumaReki() < 21){
                    grajacy.get(i).przegrana();
                }else if (grajacy.get(i).getSumaReki() == 21){
                    grajacy.get(i).wygrana();
                }else{
                    grajacy.get(i).wygrana();
                }
            }

    }
}


