import java.util.ArrayList;
public class Dealer extends Gracz{
    private ArrayList<Karta> reka = new ArrayList<Karta>();
    public Dealer(){
        ArrayList<Karta> reka;
    }
    public ArrayList<String> pokazRekeDealera() {
        ArrayList<String> rekaDString = new ArrayList<>();
        System.out.println("karty dealera: ");
//        rekaDString.add(0,"UKRYTA");
        for (int i = 0; i < this.reka.size(); i++) {
            rekaDString.add(i, reka.get(i).toString());
        }
        return rekaDString;
    }


}
