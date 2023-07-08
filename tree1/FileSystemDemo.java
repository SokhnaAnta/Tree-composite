import java.util.ArrayList;
import java.util.List;

interface FileSystemComponent {
    void display(String indent);
}

class File implements FileSystemComponent {
    private String name;

    public File(String name) {
        this.name = name;
    }

    public void display(String indent) {
        System.out.println(indent + name);
    }
}

class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> children;

    public Directory(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void addComponent(FileSystemComponent component) {
        children.add(component);
    }

    public void removeComponent(FileSystemComponent component) {
        children.remove(component);
    }

    public void display(String indent) {
        System.out.println(indent + "[" + name + "]");
        indent += "   ";
        for (FileSystemComponent component : children) {
            component.display(indent);
        }
    }
}

public class FileSystemDemo {
    public static void main(String[] args) {
        // Création des fichiers
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        File file3 = new File("file3.txt");

        // Création des répertoires
        Directory directory1 = new Directory("directory1");
        Directory directory2 = new Directory("directory2");

        // Ajout des fichiers aux répertoires
        directory1.addComponent(file1);
        directory2.addComponent(file2);
        directory2.addComponent(file3);

        // Ajout des répertoires à un répertoire parent
        Directory rootDirectory = new Directory("root");
        rootDirectory.addComponent(directory1);
        rootDirectory.addComponent(directory2);

        // Affichage de la structure
        rootDirectory.display("");
    }
}
