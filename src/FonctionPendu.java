import javax.swing.*;
public class FonctionPendu { // Les fonctions
    public static Pendu init(Panel pa) {
        Pendu p = new Pendu(); // On creer la classe
        p.motATrouve = pa.PanelMot();

        if (p.motATrouve == null) {
            System.err.println("Vous devez mettre un mot.");
            System.exit(-1);
        }

        String mot = p.motATrouve;
        p.motATrouve = mot.toUpperCase();
        p.nbrErr = 0;
        p.lettreTrouvees = new boolean[mot.length()];
        p.motComplet = new StringBuilder(mot);

        for (int i = 0; i < mot.length(); i++) {
            char tmp = p.motComplet.charAt(i);
            if (Character.isLetter(tmp)) // Pour ne pas enlever les "-"
                p.motComplet.setCharAt(i, '_');
        }

        for (int i = 0; i < mot.length(); ++i) { // Arrays.fill(p.trouve, false) la meme chose
            char tmp = p.motATrouve.charAt(i);
            p.lettreTrouvees[i] = !Character.isLetter(tmp);
        }
        return p;
    }

    public static void jouerLettre (Pendu p, char c) { // On met une lettre dans le mot si correspond
        assert (!estFini(p));
        c = Character.toUpperCase(c);
        int tmp = p.motATrouve.indexOf(c);
        if (tmp == -1)
            p.nbrErr++;

        while (tmp >= 0) { // Si il trouve une occurence.
            p.motComplet.setCharAt(tmp, c);

            p.lettreTrouvees[tmp] = true; // On met la case vrai
            tmp = p.motATrouve.indexOf(c, tmp+1); // On regarde si les prochaine lettres a partir de tmp+1

            if (tmp != -1 && p.lettreTrouvees[tmp]) // Si un mot est deja trouvé
                p.nbrErr++;
        }
    }

    public static boolean estFini (Pendu p) { // Si la game est termine
        if (estGagne(p))
            return true;

        return p.nbrErr == Pendu.MAX; // Vrai si c'est pareil
    }

    public static boolean estGagne (Pendu p) {
        for (boolean b : p.lettreTrouvees)
            if (!b) // Si une case est fausse
                return false;
        return true;
    }

    public static StringBuilder mot(Pendu p) {
        return p.motComplet;
    }

    public static int nombreErreur (Pendu p) {
        return p.nbrErr;
    }
}
