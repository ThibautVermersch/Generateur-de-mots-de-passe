import java.util.Scanner;

class menu {
    static Scanner sc = new Scanner(System.in);
    private static boolean stop = false;

    public static void afficherMenu() {
        System.out.println("Que voulez vous faire :");
        System.out.println("1. Afficher les informations de la machine");
        System.out.println("2. Afficher les informations d'un article");
        System.out.println("3. Acheter un article");
        System.out.println("99. Eteindre la machine");
    }

    public static int recupChoix() {
        return sc.nextInt();
    }

    public static void realiserChoix(int choix, VendingMachine machine) {
        switch (choix) {
            case 1:
                machine.afficherStock();
                break;
            case 2:
                System.out.println("Entrez le numéro de l'article :");
                int numAffiche = recupChoix();

                if (numAffiche < 1 || numAffiche > machine.getTailleStock()) {
                    System.out.println("Erreur dans le numéro de l'article : " + numAffiche);
                    break;
                }

                machine.getItem(numAffiche - 1).afficherInfos(numAffiche);
                break;
            case 3:
                System.out.println("entrez le numéro de l'article");
                machine.getItem(recupChoix() - 1).acheter();
                break;
            case 99:
                stop = true;
                break;
            default:
                break;
        }
    }

    public static void main(String[] str) {
        VendingMachine machine = new VendingMachine();
        while (!stop) {
            afficherMenu();
            realiserChoix(recupChoix(), machine);
        }

    }
}
