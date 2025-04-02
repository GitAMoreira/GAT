package main;

import java.util.Scanner;

import main.menuFeatures.BasicOperations;

public class Menu {

    private BasicOperations basicOp = new BasicOperations();

    /*
     * Main menu
     */
    public void menu(){
        Scanner sc = new Scanner(System.in);

        System.out.println("*** MAIN MENU ***\n" +
            "1 - Games\n" + 
            "2 - Categories\n" + 
            "3 - Achievements\n" +
            "0 - Exit");

        int option = sc.nextInt();

        switch (option) {
            case 1:
                System.out.println("GAMES");
                SubMenu(option, "GAMES");
                break;
            
            case 2:
                System.out.println("CATEGORIES");
                SubMenu(option, "CATEGORIES");
                break;

            case 3:
                System.out.println("ACHIEVEMENTS");
                SubMenu(option, "ACHIEVEMENTS");
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

    private void SubMenu(int prevOption, String subMenu){
        Scanner sc = new Scanner(System.in);

        System.out.println("*** " + subMenu + " ***\n" +
            "1 - Add new " + subMenu.toLowerCase() + "\n" + 
            "2 - Check list\n" + 
            "3 - Delete entry\n" +
            "0 - Go back");

        int option = sc.nextInt();

        switch (option) {
            case 1:
                basicOp.add(subMenu);
                break;

            case 2:
                basicOp.list(subMenu);
                break;

            case 3:
                basicOp.delete(subMenu);
                break;

            case 0:
                menu();
                break;

            default:
                System.out.println("Invalid option! Pick one from those available!");
                SubMenu(prevOption, subMenu);
                break;   
        }
        if(option != 0){
            SubMenu(prevOption, subMenu);
        }

        // Prevent resource leaks
        sc.close();
    }
}
