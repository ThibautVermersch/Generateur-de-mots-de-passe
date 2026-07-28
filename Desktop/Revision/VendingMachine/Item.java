public class Item {
    private String nom;
    private double prix;
    private int quantite;

    public Item(String nom, double prix, int quantite) {
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
    }

    public String getNom() {
        return this.nom;
    }

    public double getPrix() {
        return this.prix;
    }

    public double getQuantite() {
        return this.quantite;
    }

    public void setNom(String nom) {
        if (nom == null && nom.length() <= 0) {
            return;
        }
        this.nom = nom;
    }

    public void setPrix(double prix) {
        if (prix < 0) {
            return;
        }
        this.prix = prix;
    }

    public void setQuantite(int quantite) {
        if (quantite < 0) {
            return;
        }
        this.quantite = quantite;
    }

    public void acheter() {
        if (quantite > 0) {
            quantite -= 1;
        } else {
            System.out.println("L'article n'est plus en stock");
            return;
        }
    }

    public void afficherInfos(int num) {
        System.out.println("\u001B[34m" + "Item " + num + " : " + nom + " / " + prix + " euros / "
                + quantite + " restant" + "\u001B[00m");
    }
}
