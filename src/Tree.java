 import java.io.File;
 import java.nio.file.Paths;

public class Tree{


      public static void main(String[] args) {

            String path = Paths.get(".").toAbsolutePath().toString(); 

            if(args.length>0)
            {
                  path = args[0] ;
            }      

            File file = new File(path) ;
             
            if (file.isDirectory()) {
                  Directory mainDirectory = new Directory(file.getName(), 0);
                  subDirectory(file, mainDirectory);
                  mainDirectory.afficher();
            } 
      }

      private static  void subDirectory(File directory, Directory parent) 
      {
            File[] files = directory.listFiles();
            
            if (files != null) {
            for (File file : files) {
                  if (file.isDirectory()) {
                        Directory subDirectory = new Directory(file.getName(), parent.getColonne() + 1);
                        parent.ajout(subDirectory);
                        subDirectory(file, subDirectory);
                  } else {
                        Fichier fichier = new Fichier(file.getName(), parent.getColonne() + 1);
                        parent.ajout(fichier);
                  }
            }
            }
      }


}
