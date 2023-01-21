import javax.swing.*;
public class Panel {
    JPanel panel = new JPanel();
    String PanelMot()
    {
        return JOptionPane.showInputDialog(panel, "Le mot a trouvé  : ");
    }
    void Gagne(Pendu p)
    {
        JOptionPane.showMessageDialog(panel, "Bravo !");
    }
    void Perdu (Pendu p)
    {
        JOptionPane.showMessageDialog(panel, "Dommage ! \n" + "Le mot c'était : " + p.motATrouve);
    }

    char lettre (Pendu p)
    {
        String mot = JOptionPane.showInputDialog(panel,"Entrez une lettre : ");
        if (mot.isEmpty())
            return ' ';
        return mot.charAt(0);
    }

    void affichage (Pendu p)
    {
        JOptionPane.showMessageDialog(panel, FonctionPendu.mot(p) + ",  "
                + FonctionPendu.nombreErreur(p) + "/" + Pendu.MAX + "<- erreurs");
    }
}
