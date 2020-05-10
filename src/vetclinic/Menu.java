package vetclinic;

import java.util.Scanner;

public class Menu {

    private Scanner keyboard = new Scanner(System.in);

    public void mainMenuLoop() {
        int choice = 0;
        do {
            choice = this.getMainMenuChoice();
            switch (choice) {
                case 5:
                	this.listAllAnimals();
                    break;
            }            
        } while(choice != 11);
        System.out.println("Good Bye");
    }    
    
	private int getMainMenuChoice() {
        System.out.println(
            "\n1) List all Staff\n" +
	        "\n2) List staff by categories\n" +
	        "\n3) List all Admin staff performing a certain task\n" +
	        "\n4) Search for a specific member of staff by name\n" +
	        "\n5) List all animals\n" +
	        "\n6) List animals by various types\n" +
	        "\n7) Search for a specific animal by name\n" +
	        "\n8) List all the animals assigned to a member of medical staff\n" +
	        "\n9) List the order in which pets will be looked after by a particular member of medical staff\n" +
	        "\n10) For a given member of the medical staff, pass to the next pet\n" +
            "\n11) Exit\n");

        int choice = 0;
        do {
            System.out.println("\nChoose an option (1..11):");
            choice = keyboard.nextInt();            
        } while (choice < 1 || choice > 11);
        return choice;
    }	

	private void listAllAnimals() {
		System.out.println("List All Aminals");
	}
	
}
