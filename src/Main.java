import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // "System.in" pour entrer clavier

        System.out.print("Le mot à trouvé : ");
        String mot = sc.nextLine(); // Le sc.next c'est ou est stocker le mot de l'entree clavier, "next", lire un mot
        Pendu p = FonctionPendu.init(mot); // Initialise selon le mot

        while (!FonctionPendu.estFini(p))
        {
            System.out.print("Entrée une lettre : ");
            char c = sc.next().charAt(0); // On choisis la lettre que l'on veut grace a "charArt"
            FonctionPendu.jouerLettre(p,c);

            System.out.println(FonctionPendu.mot(p).toString() + ",  " + FonctionPendu.nombreErreur(p) + "/" + Pendu.MAX + "<- erreurs"); // To string convertir en String

            if (FonctionPendu.estGagne(p))
                System.out.println("Bravo !");
            else if (FonctionPendu.estFini(p))
            {
                System.out.println("Dommage, Bien joué !");
                System.out.println("Le mot c'était : " + p.motATrouve);
            }
        }
    }
}