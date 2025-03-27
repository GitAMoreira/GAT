package main.menuFeatures;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;

import game.Achievement;
import game.Category;
import game.Game;

public class BasicOperations implements IBasicOperations{

    // With this being a small and personal project, relative paths are used instead of absolute ones for simplicity sake
    private String dataFilesPath = "Data/";
    private Scanner sc = new Scanner(System.in); // Not closed!
    
    public void add(String subMenu){
        String filePath = dataFilesPath + subMenu + ".txt";
        if(fileExists(subMenu)){
            switch (subMenu) {
                // GAMES
                case "GAMES":
                    System.out.println("Name of the game?\n");
                    String gameName = sc.nextLine();
                    
                    System.out.println("Pick the game category:\n");
                    String gameCategory = sc.nextLine();

                    Game game = new Game(gameName, gameCategory);
                    game.saveInformation(game, filePath);

                    break;

                // CATEGORIES
                case "CATEGORIES":
                    System.out.println("Name of the category?\n");
                    String categoryName = sc.nextLine();

                    Category category = new Category(categoryName);
                    category.saveInformation(category, filePath);

                    break;

                // ACHIEVEMENTS
                case "ACHIEVEMENTS":
                    System.out.println("Name of the achievement?\n");
                    String achievementName = sc.nextLine();
                    
                    System.out.println("Description of the achievement?");
                    String achievementDescription = sc.nextLine();
                    
                    System.out.println("Is this achievement completed already? y/n");
                    String isCompletedString = checkYNInput(sc.nextLine());
                    boolean isCompleted;
                    if(isCompletedString.equals("y")){
                        isCompleted = true;
                    }else{
                        isCompleted = false;
                    }

                    LocalDate date = null;
                    if(isCompleted == true){
                        System.out.println("Do you want to use today's date? y/n");
                        String isTodayDate = checkYNInput(sc.nextLine());
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                        // INSUFFICIENT VALIDATION IN THE INPUT DATE **********************************************************************************************
                        if(isTodayDate.equals("y")){
                            date = LocalDate.now();
                        }else{
                            System.out.println("Input the desired date: (dd/mm/yyyy) or type 'n' to abort and add a date later.");
                            String inputDate = sc.nextLine();

                            while(true){
                                if(inputDate.trim().toLowerCase().equals("n")){
                                    date = null;
                                    break;
                                }else if(inputDate.contains(".*[a-zA-Z].*")){
                                    System.out.println("Invalid input. Make sure to include only numbers and the forward slash: (dd/mm/yyyy)");
                                }else{
                                    date = LocalDate.parse(inputDate, formatter);
                                    break;
                                }
                            }
                        }
                    }

                    Achievement achievement;
                    if(date == null){
                        achievement = new Achievement(achievementName, achievementDescription, isCompleted);
                    }else{
                        achievement = new Achievement(achievementName, achievementDescription, isCompleted, date);
                    }
                    achievement.saveInformation(achievement, filePath);

                    break;

                default:
                    break;
            }
        }
    }

    public void list(String subMenu){
        String filePath = dataFilesPath + subMenu + ".txt";

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;//, lineSplit[];
            int count = 1;
            
            while((line = br.readLine()) != null){
                //lineSplit = line.split(";");
                System.out.println(count + ": " + line);
                count++;
            }
            
        } catch(FileNotFoundException e) {
            System.out.println("File not found! Consider adding new entries to create a new file.");
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void modify(String subMenu){
        
    }

    public void delete(String subMenu){

    }

    /*
     * This method checks if the file exists in order to either open it or create it straight away
     */
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

    /*
     * Checks the user input when it comes to y/n questions
     */
    private String checkYNInput(String input){
        while(true){
            if(input.trim().toLowerCase().equals("y")){
                break;
            }else if(input.trim().toLowerCase().equals("n")){
                break;
            }else{
                System.out.println("Invalid input. Type either 'y' or 'n'.");
                input = sc.nextLine();
            }
        }
        return input;
    }
}
