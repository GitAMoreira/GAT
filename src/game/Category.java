package game;

import java.io.FileWriter;
import java.io.IOException;

public class Category {
    
    private String name;

    public Category(String name){
        this.name = name;
    }

    public void saveInformation(Category category, String path){
        try(FileWriter fw = new FileWriter(path, true)){
            fw.write(category.name + "\n");
            System.out.println("New category added!");
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Failed to add a new category.");
        }
    }
    
}
