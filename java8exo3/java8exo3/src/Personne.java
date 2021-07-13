public class Personne {
    private String nom, prenom, genre, ville;
    private int annee_naissance;
    private double salaire;

    
    public Personne(String nom, String prenom, String genre, String ville, int annee_naissance, double salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
        this.ville = ville;
        this.annee_naissance = annee_naissance;
        this.salaire = salaire;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public int getAnnee_naissance() {
        return annee_naissance;
    }
    public void setAnnee_naissance(int annee_naissance) {
        this.annee_naissance = annee_naissance;
    }
    public double getSalaire() {
        return salaire;
    }
    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Personne [annee_naissance=" + annee_naissance + ", genre=" + genre + ", nom=" + nom + ", prenom="
                + prenom + ", salaire=" + salaire + ", ville=" + ville + "]";
    }
    

    
}
