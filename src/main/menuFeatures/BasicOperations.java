package main.menuFeatures;

import java.io.FileNotFoundException;
import java.util.Scanner;

import game.Game;

import java.io.File;

public class BasicOperations implements IBasicOperations{

    // With this being a small and personal project, relative paths are used instead of absolute ones for simplicity sake
    private String dataFilesPath = "Data/";
    private Scanner sc = new Scanner(System.in);
    
    public void add(int option, String subMenu){
        if(fileExists(subMenu)){
            switch (option) {
                case 1:
                    System.out.println("Name of the game?\n");
                    String name = sc.nextLine();
                    System.out.println("Pick the game category:\n");
                    String category = sc.nextLine();

                    Game game = new Game(name, category);
                    game.saveInformation(game, dataFilesPath + subMenu + ".txt");

                    break;
            
                default:
                    break;
            }
        }
    }

    public void list(String subMenu){

    }

    public void modify(String subMenu){
        
    }

    public void delete(String subMenu){

    }

    public boolean fileExists(String subMenu){
        String filePathString = dataFilesPath + subMenu + ".txt";
        File file = new File(filePathString);

        try{
            if(file.exists()){
                return true;
            }else{
                file.createNewFile();
                return true;
            }
        }catch(FileNotFoundException e){
            return false;
        }catch(Exception e){
            return false;
        }
    }
}
