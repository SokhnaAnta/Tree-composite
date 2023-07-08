import java.util.ArrayList;


public class Directory extends Composite {
    private ArrayList<Composite> composants = new ArrayList<Composite>();
    
    public Directory(String name,int colonne) {
       super(name, colonne) ;
    }

    public void ajout(Composite composant) {
        this.composants.add(composant);
    }

    public void afficher() {
        for(int i=0 ; i< this.getColonne() ;i++){
         System.out.print("\u2502\t");
        }
        System.out.println("\u251C\u2500\u2500"+ getName());
        for (Composite c : this.composants) {
            c.afficher();
        }
    }
    
}