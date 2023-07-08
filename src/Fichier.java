public class Fichier extends Composite{

    public Fichier(String name,int colonne) {
        super(name, colonne) ;
     }
    public void ajout(Composite nom){}

    public void afficher( )
	{   for(int i=0 ; i< this.getColonne() ;i++){
        System.out.print("\u2502\t");
       }
		System.out.print("\u2514\u2500"+ getName()+"\n");
	}
}