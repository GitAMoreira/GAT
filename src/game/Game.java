package game;

import java.io.FileWriter;
import java.io.IOException;

import game.Category;

public class Game {
    
    private String name;
    //private Category category;
    private String category;

    public Game(String name, String category){
        this.name = name;
        this.category = category;
    }

    public void saveInformation(Game game, String path){
        try(FileWriter fw = new FileWriter(path, true)){
            fw.write(game.name + ";" + game.category + "\n");
            System.out.println("New game added!");
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Failed to add a new game.");
        }
    }
}
