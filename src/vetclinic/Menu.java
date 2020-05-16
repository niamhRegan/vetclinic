package vetclinic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import vetclinic.animal.Animal;
import vetclinic.animal.Cat;
import vetclinic.animal.Dog;
import vetclinic.animal.Pig;
import vetclinic.animal.Rabbit;
import vetclinic.staff.Admin;
import vetclinic.staff.It;
import vetclinic.staff.Medical;
import vetclinic.staff.Nurse;
import vetclinic.staff.Receptionist;
import vetclinic.staff.Staff;
import vetclinic.staff.TraineeVet;
import vetclinic.staff.Vet;

// Menu class - shows menus and accepts user input 
public class Menu {

	private Setup setup;

	// useDelimiter("\n") makes sure you can enter a name with spaces
	// https://stackoverflow.com/questions/39514730/how-to-take-input-as-string-with-spaces-in-java-using-scanner
	private Scanner keyboard = new Scanner(System.in).useDelimiter("\n");

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

                case 3:
                	this.displayStaffByTask();
                	break;
                    
                case 4:
                	this.searchStaffByName();
                	break;
                    
                case 5:
                	this.displayAnimals();
                    break;

                case 6:
                	this.displayAnimalsByType();
                	break;
                    
                case 7:
                	this.searchAnimalByName();
                	break;

                case 8:
                	this.displayAllAnimalsAssigned();
                    break;

                case 9:
                	this.displayAllAnimalsAssignedInOrder();
                    break;

                case 10:
                	this.goToNextPatient();
                    break;
                    
            }            
        } while(choice != 11);
        System.out.println("Bye");
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

            try {
            	choice = keyboard.nextInt();            
	        } catch(Exception e) {
	            // if bad input print error and read input to remove it from scanner
	        	// https://stackoverflow.com/questions/38830142/how-to-handle-invalid-input-when-using-scanner-nextint
	            System.out.println("\nBad input!");
	            keyboard.next();
	        }
            
        } while (choice < 1 || choice > 11);
        // return the users choice
        return choice;
    }	

	// display staff by category e.g. Nurse
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

	// choose a member of medial staff
	public Medical chooseMedicalStaff() {
		// get list of medical staff
		ArrayList<Medical> list = this.setup.getMedical();
		// display list of medical staff
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + 1);
			System.out.println(list.get(i));
		}	
		
		// get users choice
		int choice = 0;
        do {
            System.out.println("\nChoose an option: 1 .. " + list.size());
            choice = keyboard.nextInt();            
        } while (choice < 1 || choice > list.size());

        // return the medical the user selected
        return list.get(choice - 1);
	}

	// display all animals assigned to a medical staff
	public void displayAllAnimalsAssigned() {
		// get all medical staff
		Medical selectedMedical = this.chooseMedicalStaff();
		// get list of animals for that medical staff (in any order) 
		ArrayList<Animal> list = selectedMedical.getPatientList();
		// print out the animals
		System.out.println("\nList of patients for " + selectedMedical.getName() + ":");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	// display all animals assigned to a medical staff in the order they will be seen
	public void displayAllAnimalsAssignedInOrder() {
		// get all medical staff
		Medical selectedMedical = this.chooseMedicalStaff();
		// get the queue for the medical which retains order
		ArrayDeque<Animal> queue = selectedMedical.getPatientQueue();
        // loop over queue and print out elements in order
        System.out.println("\nList of patients for in order " + selectedMedical.getName() + ":");
        int order = 1;
        for (Animal animal: queue) {
			System.out.println("ORDER: " + order++);
            System.out.println(animal);         	
        }
	}

	// choose a medical staff and then make them "see" their next patient
	public void goToNextPatient() {
		// get all medical staff
		Medical selectedMedical = this.chooseMedicalStaff();
		// get next patient from queue (removes it from queue)
		Animal nextPatient = selectedMedical.getNextPatient();
		// display the next patient 
		System.out.println("\nNext patient for " + selectedMedical.getName() + " is:");		
        System.out.println(nextPatient);		
	}

	// display animals by type e.g. Pig
	public void displayAnimalsByType() {
		// show options
		System.out.println("\nChoose a animal type:" +
    	        "\n1) Cat\n" +
    	        "\n2) Dog\n" +
    	        "\n3) Rabbit\n" +
    	        "\n4) Pig\n");

		// get users choice
        int choice = 0;
        do {
            System.out.println("\nChoose an option (1..4):");
            choice = keyboard.nextInt();
        } while (choice < 1 || choice > 4);

        // perform action based on choice
        switch (choice) {
        	case 1:
        		this.displayCats();
        		break;
        	case 2:
        		this.displayDogs();
        		break;
        	case 3:
        		this.displayRabbits();
        		break;
        	case 4:
        		this.displayPigs();
        		break;
        }
	}

	// prompt user for a name and return it
	public String getNameFromUser() {
		// display main menu
		System.out.println("Enter name to search for:");
        String name = keyboard.next();
        return name;
    }	
	
	
	// get name from user and display all animals than have same name
	public void searchAnimalByName() {		
		// get name to search for from user
		String name = this.getNameFromUser();
		// get list of animals
		ArrayList<Animal> list = this.setup.getAnimals();
		// loop over all animals
		for (int i = 0; i < list.size(); i++) {
			Animal currentAnimal = list.get(i);
			// if current animal name matches the search name print it out
			if (currentAnimal.getName().equalsIgnoreCase(name)) {
				System.out.println(currentAnimal);				
			}
		}	
	}

	// show staff performing a certain tasks
	public void displayStaffByTask() {
		// get list of all tasks
		ArrayList<String> tasks = this.setup.getTasks();

		// show the list and allow user to pick one
		for (int i = 0; i < tasks.size(); i++) {
			System.out.println(i + 1 + " " + tasks.get(i));
		}	
		
		// get users choice
		int choice = 0;
        do {
            System.out.println("\nChoose an option: 1 .. " + tasks.size());
            choice = keyboard.nextInt();            
        } while (choice < 1 || choice > tasks.size());

        String choosenTask = tasks.get(choice - 1);

        // get lsit of all admin staff
        ArrayList<Admin> list = this.setup.getAdmin();
		// loop over admin staff
		for (int i = 0; i < list.size(); i++) {
			Admin currentAdmin = list.get(i);
			// if current admins task equals the choosen task
			if (currentAdmin.getTask().equals(choosenTask)) {
				// display the current admin
	            System.out.println(currentAdmin);				
			}
		}
        
	}
    
	// get name from user and display all staff than have same name
	public void searchStaffByName() {		
		// get name to search for from user
		String name = this.getNameFromUser();
		// get list of animals
		ArrayList<Staff> list = this.setup.getStaff();
		// loop over all staff
		for (int i = 0; i < list.size(); i++) {
			Staff currentStaff = list.get(i);
			// if current staff name contains the search name print it out
			if (currentStaff.getName().equalsIgnoreCase(name)) {
				System.out.println(currentStaff);				
			}
		}	
	}
	
	// display staff
	public void displayStaff() {
		// loop over staff list and display each one
		for (int i = 0; i < this.setup.getStaff().size(); i++) {			
			System.out.println(i + 1);
			System.out.println(this.setup.getStaff().get(i));
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
	
	// display animals
	public void displayAnimals() {
		// loop over animals and display each one
		for (int i = 0; i < this.setup.getAnimals().size(); i++) {
			System.out.println(i + 1);
			System.out.println(this.setup.getAnimals().get(i));
		}	
	}	
	
	// display medical
	public void displayMedical() {
		// get list of Medical
		ArrayList<Medical> list = this.setup.getMedical();
		// loop over list and display each one
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + 1);
			System.out.println(list.get(i));
		}	
	}		

	// display dogs
	public void displayDogs() {
		// get list of Dog
		ArrayList<Dog> list = this.setup.getDogs();
		// loop over list and display each one
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + 1);
			System.out.println(list.get(i));
		}	
	}

	// display cats
	public void displayCats() {
		// get list of Cat
		ArrayList<Cat> list = this.setup.getCats();
		// loop over list and display each one
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + 1);
			System.out.println(list.get(i));
		}	
	}

	// display Rabbits
	public void displayRabbits() {
		// get list of Rabbit
		ArrayList<Rabbit> list = this.setup.getRabbits();
		// loop over list and display each one
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + 1);
			System.out.println(list.get(i));
		}	
	}

	// display pigs
	public void displayPigs() {
		// get list of Pig
		ArrayList<Pig> list = this.setup.getPigs();
		// loop over list and display each one
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + 1);
			System.out.println(list.get(i));
		}	
	}
	
}
