package main;

import java.util.Scanner;

public class Main{

    public static void main(String[] args){
        menu();
    }

    /*
     * Main menu
     */
    private static void menu(){
        Scanner sc = new Scanner(System.in);

        System.out.println("*** MAIN MENU ***\n" +
            "1 - Games\n" + 
            "2 - Categories\n" + 
            "3 - Achievements\n" +
            "0 - Exit");

        int option = sc.nextInt();

        switch (option) {
            case 1:
                System.out.println("GAMES MENU MISSING");
                break;
            
            case 2:
                System.out.println("CATEGORIES MENU MISSING");
                break;

            case 3:
                System.out.println("ACHIEVEMENTS MENU MISSING");
                break;

            case 0:
                System.out.println("Cya!");
                break;

            default:
                System.out.println("Invalid option! Pick one from those available!");
                menu();
                break;
                
        }

        // Prevent resource leaks
        sc.close();
    }

}