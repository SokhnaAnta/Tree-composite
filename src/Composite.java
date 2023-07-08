
public abstract class Composite {
    private String name;
    private int colonne ; 
    
    public Composite(String name,int colonne) {
        this.name = name;
        this.colonne = colonne ;
    }

    public int getColonne() {
        return colonne;
    }

    public abstract void afficher();

    public void ajout(Composite c) {

    };

    public String getName() {
        return this.name;
    }



}