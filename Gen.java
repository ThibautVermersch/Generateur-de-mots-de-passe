import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Gen {
    private static final Scanner sc = new Scanner(System.in);
    private static final SecureRandom random = new SecureRandom();
    private static final String MINUSCULES = "abcdefghijklmnopqrstuvwxyz";
    private static final String MAJUSCULES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String CHIFFRES   = "0123456789";
    private static final String SYMBOLES   = "!@#$%^&*()-_=+[]{}<>,.?";
    private static final String TOUS_CARACTERES = MINUSCULES + MAJUSCULES + CHIFFRES + SYMBOLES;

    private static String mdp = "";

    //Genere un mots de passe sécurisé
    private static void genMDP() {
        int taille = 0;
        while (taille < 10 || taille > 20) {
            System.out.print("Veuillez entrer la taille du mot de passe souhaitée (entre 10 et 20) : ");
            if (sc.hasNextInt()) {
                taille = sc.nextInt();
            } else {
                sc.next();
            }
        }
        sc.nextLine();

        ArrayList<Character> caracteres = new ArrayList<>();
        caracteres.add(MINUSCULES.charAt(random.nextInt(MINUSCULES.length()))); // permet d'avoir au moins 1 minuscule
        caracteres.add(MAJUSCULES.charAt(random.nextInt(MAJUSCULES.length()))); // permet d'avoir au moins 1 majuscule
        caracteres.add(CHIFFRES.charAt(random.nextInt(CHIFFRES.length()))); // permet d'avoir au moins 1 chiffre
        caracteres.add(SYMBOLES.charAt(random.nextInt(SYMBOLES.length()))); // permet d'avoir au moins 1 symbole

        for (int i = 4; i < taille; i++) {
            caracteres.add(TOUS_CARACTERES.charAt(random.nextInt(TOUS_CARACTERES.length()))); // recupere des characteres aleatoire
        }

        Collections.shuffle(caracteres, random); // mélange la liste de caractere

        StringBuilder sb = new StringBuilder(); // on transforme la liste en chaine de characteres
        for (char c : caracteres) {
            sb.append(c);
        }
        mdp = sb.toString();

        System.out.println("Voici votre mot de passe de " + taille + " caractères : " + mdp);

        isSave();
    }

    //Procédure qui permet de demander la save
    public static void isSave() {
        String rep = "";
        while (!rep.equalsIgnoreCase("y") && !rep.equalsIgnoreCase("n")) {
            System.out.print("Voulez-vous sauvegarder ce mot de passe dans un fichier ? (y / n) : ");
            rep = sc.nextLine().trim();
        }

        if (rep.equalsIgnoreCase("y")) {
            save();
        }
    }

    //procédure de sauvegarde dans un fichier mdp.txt
    private static void save() {
        try {
            Path fichier = Path.of("mdp.txt");
            Files.writeString(fichier, mdp + System.lineSeparator(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND); // écriture / création du fichier si il existe pas
            System.out.println("Mot de passe enregistré dans le fichier : " + fichier.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Erreur lors de l'enregistrement : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        genMDP();
    }
}