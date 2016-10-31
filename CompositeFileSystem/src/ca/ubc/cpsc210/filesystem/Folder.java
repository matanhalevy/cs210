package ca.ubc.cpsc210.filesystem;

import java.util.ArrayList;
import java.util.List;

public class Folder extends FileSystemResource {
    private List<FileSystemResource> children;

    public Folder(String name){
        this.name = name;
        children = new ArrayList<FileSystemResource>();
    }

    public void addChild(FileSystemResource f){
        if (!children.contains(f)){
            children.add(f);
        }
    }

    public void print(int indent) {
        printIndent(indent);
        System.out.println("Folder: " + this.name);
        for (FileSystemResource f : children){
            f.print(indent + 1);
        }
    }

	

}
