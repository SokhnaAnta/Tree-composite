 import java.io.File;
 import java.nio.file.Paths;

public class Tree{


      public static void main(String[] args) {

            String path = Paths.get(".").toAbsolutePath().toString(); 
            boolean showfile = false ; 
            if(args.length==1)

            {  
                  if (!args[0].equalsIgnoreCase("/f")){
                      path = args[0];
                  }
                  else showfile=true ;
                                   
            }     
            if(args.length ==2){
                   if(args[1].equalsIgnoreCase("/f")) showfile = true;
                    path = args[0];

            } 
            
            File file = new File(path) ;
             
            if (file.isDirectory()) {
                  Directory mainDirectory = new Directory(path, 0);
                  if(showfile){
                        subDirectoryAndFile(file, mainDirectory);
                  }
                  else{
                        subDirectory(file, mainDirectory);
                  }
                 
                  mainDirectory.afficher();
            } 
            else{
                  System.out.println("le chemin specifié n'est pas un folder");
            }
      }

      private static  void subDirectoryAndFile(File directory, Directory parent) 
      {
            File[] files = directory.listFiles();
            
            if (files != null) {
            for (File file : files) {
                  if (file.isDirectory()) {
                        Directory subDirectory = new Directory(file.getName(), parent.getColonne() + 1);
                        parent.ajout(subDirectory);
                        subDirectoryAndFile(file, subDirectory);
                  } else {
                        Fichier fichier = new Fichier(file.getName(), parent.getColonne() + 1);
                        parent.ajout(fichier);
                  }
            }
            }
      }

      private static void subDirectory(File directory, Directory parent){
         
            File[] files = directory.listFiles();
            
            if (files != null) {
            for (File file : files) {
                  if (file.isDirectory()) {
                        Directory subDirectory = new Directory(file.getName(), parent.getColonne() + 1);
                        parent.ajout(subDirectory);
                        subDirectory(file, subDirectory);
                  } 
            }
            }
      }


}
