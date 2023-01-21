import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in); // "System.in" pour entrer clavier
//      String mot = sc.nextLine(); // Le sc.next c'est ou est stocker le mot de l'entree clavier, "next", lire un mot
        Panel pa = new Panel();

        Pendu p = FonctionPendu.init(pa);
        while (!FonctionPendu.estFini(p))
        {
            char c = pa.lettre(p);
            FonctionPendu.jouerLettre(p,c);

            pa.affichage(p);
            if (FonctionPendu.estGagne(p))
                pa.Gagne(p);
            else if (FonctionPendu.estFini(p))
                pa.Perdu(p);
        }
    }
}