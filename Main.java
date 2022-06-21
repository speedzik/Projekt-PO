import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ile symulacji mam wykonać?");
        int s = scanner.nextInt();
        GraBlackjack mojagra = new GraBlackjack();
        Talia talia1 = new Talia(3,true);

        for (int i = 0; i < s; i++) {
            mojagra.rozpocznijGre();
            mojagra.symulacja();
        }
    }
}
