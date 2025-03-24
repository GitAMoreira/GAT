package game;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class Achievement {

    private String name;
    private String description;
    private LocalDate dateCompleted;
    private boolean isCompleted;
    
    /*
     * Constructor used for achievements that have already been completed and therefore can have a dateCompleted
     */
    public Achievement(String name, String description, boolean isCompleted, LocalDate dateCompleted){
        this.name = name;
        this.description = description;
        this.isCompleted = isCompleted;
        this.dateCompleted = dateCompleted;
    }

    public Achievement(String name, String description, boolean isCompleted){
        this.name = name;
        this.description = description;
        this.isCompleted = isCompleted;
        this.dateCompleted = null;
    }

    public void saveInformation(Achievement achievement, String path){
        try(FileWriter fw = new FileWriter(path, true)){
            fw.write(achievement.name + ";" + achievement.description + ";" + isCompleted + ";" + dateCompleted + "\n");
            System.out.println("New achievement added!");
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Failed to add a new achievement.");
        }
    }
}
