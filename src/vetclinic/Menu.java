package vetclinic;

import java.util.ArrayList;
import java.util.Scanner;

import vetclinic.staff.It;
import vetclinic.staff.Nurse;
import vetclinic.staff.Receptionist;
import vetclinic.staff.TraineeVet;
import vetclinic.staff.Vet;

public class Menu {

	private Setup setup;
    private Scanner keyboard = new Scanner(System.in);

    public Menu() {
    	// create setup class which creates all the staff and animals and assigns animals and tasks    	
    	this.setup = new Setup();
    	this.setup.performSetup();
    }
    
    // main menu loop
    public void mainMenuLoop() {
        // perform action based on input choice
    	int choice = 0;
        do {
            choice = this.getMainMenuChoice();
            switch (choice) {
                case 1:
                	this.displayStaff();
                    break;

                case 2:
                	this.displayStaffByCategory();
                    break;
                    
                case 5:
                	this.displayAnimals();
                    break;                    
            }            
        } while(choice != 11);
        System.out.println("Good Bye");
    }    
    
	public int getMainMenuChoice() {
		// display main menu
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

		// get user input
        int choice = 0;
        do {
            System.out.println("\nChoose an option (1..11):");
            choice = keyboard.nextInt();            
        } while (choice < 1 || choice > 11);

        // return the users choice
        return choice;
    }	

	
	// OPTION 1 - display staff
	public void displayStaff() {
		// loop over staff list and display each one
		for (int i = 0; i < this.setup.getStaff().size(); i++) {			
			System.out.println(i + 1);
			System.out.println(this.setup.getStaff().get(i));
		}	
	}

	
	// OPTION 2 - display staff by category e.g. Nurse
	public void displayStaffByCategory() {
		// show options
		System.out.println("\nChoose a staff category:" +
    	        "\n1) IT\n" +
    	        "\n2) Receptionist\n" +
    	        "\n3) Nurse\n" +
    	        "\n4) Trainee Vet\n" +
    	        "\n5) Vet\n");

		// get users choice
		int choice = 0;
        do {
            System.out.println("\nChoose an option (1..5):");
            choice = keyboard.nextInt();            
        } while (choice < 1 || choice > 5);

        // perform action based on input choice
        switch (choice) {
        	case 1:
        		this.displayIt();
        		break;
        	case 2:
        		this.displayReceptionist();
        		break;
        	case 3:
        		this.displayNurse();
        		break;
        	case 4:
        		this.displayTraineeVet();
        		break;
        	case 5:
        		this.displayVet();
        		break;
        }
	}
	
	// display IT
	public void displayIt() {
		// get list of It
		ArrayList<It> list = this.setup.getIt();
		// loop over list and display each one
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + 1);
			System.out.println(list.get(i));
		}	
	}

	// display Receptionist
	public void displayReceptionist() {
		// get list of Receptionist
		ArrayList<Receptionist> list = this.setup.getReceptionist();
		// loop over list and display each one
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + 1);
			System.out.println(list.get(i));
		}	
	}
	
	// display Nurse
	public void displayNurse() {
		// get list of Nurse
		ArrayList<Nurse> list = this.setup.getNurse();
		// loop over list and display each one
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + 1);
			System.out.println(list.get(i));
		}	
	}

	// display TraineeVet
	public void displayTraineeVet() {
		// get list of TraineeVet
		ArrayList<TraineeVet> list = this.setup.getTraineeVet();
		// loop over list and display each one
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + 1);
			System.out.println(list.get(i));
		}	
	}
	
	// display Vet
	public void displayVet() {
		// get list of Vet
		ArrayList<Vet> list = this.setup.getVet();
		// loop over list and display each one
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + 1);
			System.out.println(list.get(i));
		}	
	}
	

	
	// OPTION 5 - display animals
	public void displayAnimals() {
		// loop over animals and display each one
		for (int i = 0; i < this.setup.getAnimals().size(); i++) {
			System.out.println(i + 1);
			System.out.println(this.setup.getAnimals().get(i));
		}	
	}	
	
}
