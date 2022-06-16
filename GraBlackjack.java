import java.util.ArrayList;
import java.util.Scanner;
public class GraBlackjack {
    private Scanner scanner = new Scanner(System.in);
    private int liczbagraczy;
    private ArrayList<Gracz> gracze = new ArrayList<Gracz>();
    private Gracz dealer;
    private int mocStolu = 0;



        public void rozpocznijGre() {
            String imiona;
            Dealer dealer = new Dealer();
            System.out.println("Ile osób gra (1-6)");
            liczbagraczy = scanner.nextInt();
            if (liczbagraczy < 1 || liczbagraczy > 6) {
                System.err.println("Zla liczba graczy!");
                System.exit(1);
            }
            for (int i = 0; i < liczbagraczy; i++) {
                this.gracze = new ArrayList<Gracz>();
                System.out.println("Podaj imie gracza nr " + (i+1) + " !");
                imiona = scanner.next();
                gracze.add(new Gracz(imiona));
            }

            System.out.println("Iloma taliami chcesz zagrac?");
            int n = scanner.nextInt();
            Talia talia = new Talia(n,true);
            System.out.println("Rozdajemy!");
            dealer.wyczyscReke();
            for (int m = 0; m < 2; m++) {
                for (int i = 0; i < liczbagraczy; i++) {
                    if (gracze.get(i).getBank() > 0) {
                        gracze.get(i).dodajKarte(talia.rozdajKolejnaKarte());
                    }
                }
                dealer.dodajKarte(talia.rozdajKolejnaKarte());
            }
            System.out.println(talia);
            System.out.println(gracze.get(1).pokazRekeGracza(true));

        }


//        public void rozdanie(){
//            for (int i = 0; i < liczbagraczy; i++) {
//                gracze[i].wyczyscReke();
//                if (gracze[i].getBank()>0) {
//                    gracze[i].dodajKarte(talia.)
//                }
//
//
//            }
//        }

}

