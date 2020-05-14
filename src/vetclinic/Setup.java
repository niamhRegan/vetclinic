package vetclinic;

import java.util.ArrayList;
import java.util.Random;

import vetclinic.animal.Animal;
import vetclinic.animal.AnimalFactory;
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
import vetclinic.staff.StaffFactory;
import vetclinic.staff.TraineeVet;
import vetclinic.staff.Vet;

// this class create the list of animals and staff
// assigns aminals to medical staff
// assigns tasks to admin staff

public class Setup {

	private Random rnd = new Random();
	private ArrayList<Animal> animals = null;
	private ArrayList<Staff> staff = null;
	private ArrayList<String> tasks = null;

	// create all animals and staff and assign animals to medical staff and assign tasks to admin staff 
	public void performSetup() {
		// create animals using factory
		AnimalFactory animalFactory = new AnimalFactory();
		this.animals = animalFactory.createAnimals();
	
		// create staff using factory
		StaffFactory staffFactory = new StaffFactory();
		this.staff = staffFactory.createStaff();
		this.tasks = staffFactory.getTasks();
		
		// assign animals to medical staff
		ArrayList<Medical> medicalStaff = this.getMedical();		

		// loop through all animals
		for (int i = 0; i < animals.size(); i++) {	
			// randomly choose a medical staff
			Medical selectedStaff = medicalStaff.get(this.rnd.nextInt(medicalStaff.size()));
			// add current animal as a patient of that medical staff
			selectedStaff.addPatient(animals.get(i));			
		}		
	}

	// return list of Animals
	public ArrayList<Animal> getAnimals() {
		return this.animals;
	}

	// return list of Staff
	public ArrayList<Staff> getStaff() {
		return this.staff;
	}

	// return list of Tasks
	public ArrayList<String> getTasks() {
		return this.tasks;
	}

	// return a list of medical staff
	public ArrayList<Medical> getMedical() {
		ArrayList<Medical> list = new ArrayList<Medical>();
		// loop through all staff
		for (int i = 0; i < this.staff.size(); i++) {
			Staff currentStaff = this.staff.get(i);
			// if current staff is medical add to list
			if (currentStaff instanceof Medical) {
				// can put a Medical into a list of Staff because Medical contains everything in Staff
				// but cannot put a Staff into a Medical because Staff doesn't have everyting in Medical
				// so need to cast Staff to a Medical
				list.add((Medical) currentStaff);
			}
		}
		return list;
	}
	
	// return a list of admin staff
	public ArrayList<Admin> getAdmin() {
		ArrayList<Admin> list = new ArrayList<Admin>();
		// loop through all staff
		for (int i = 0; i < this.staff.size(); i++) {
			Staff currentStaff = this.staff.get(i);
			// if current staff is admin add to list
			if (currentStaff instanceof Admin) {
				// need to cast Staff to Admin
				list.add((Admin) currentStaff);
			}
		}
		return list;
	}
	
	// return a list of it staff
	public ArrayList<It> getIt() {
		ArrayList<It> list = new ArrayList<It>();
		// loop through all staff
		for (int i = 0; i < this.staff.size(); i++) {
			Staff currentStaff = this.staff.get(i);
			// if current staff is it add to list
			if (currentStaff instanceof It) {
				// need to cast Staff to It
				list.add((It) currentStaff);
			}
		}
		return list;
	}

	// return a list of receptionist
	public ArrayList<Receptionist> getReceptionist() {
		ArrayList<Receptionist> list = new ArrayList<Receptionist>();
		// loop through all staff
		for (int i = 0; i < this.staff.size(); i++) {
			Staff currentStaff = this.staff.get(i);
			// if current staff is it add to list
			if (currentStaff instanceof Receptionist) {
				// need to cast Staff to Nurse
				list.add((Receptionist) currentStaff);
			}
		}
		return list;
	}
	
	// return a list of nurses
	public ArrayList<Nurse> getNurse() {
		ArrayList<Nurse> list = new ArrayList<Nurse>();
		// loop through all staff
		for (int i = 0; i < this.staff.size(); i++) {
			Staff currentStaff = this.staff.get(i);
			// if current staff is it add to list
			if (currentStaff instanceof Nurse) {
				// need to cast Staff to Nurse
				list.add((Nurse) currentStaff);
			}
		}
		return list;
	}

	// return a list of trainee vets
	public ArrayList<TraineeVet> getTraineeVet() {
		ArrayList<TraineeVet> list = new ArrayList<TraineeVet>();
		// loop through all staff
		for (int i = 0; i < this.staff.size(); i++) {
			Staff currentStaff = this.staff.get(i);
			// if current staff is it add to list
			if (currentStaff instanceof TraineeVet) {
				// need to cast Staff to Nurse
				list.add((TraineeVet) currentStaff);
			}
		}
		return list;
	}

	// return a list of vets
	public ArrayList<Vet> getVet() {
		ArrayList<Vet> list = new ArrayList<Vet>();
		// loop through all staff
		for (int i = 0; i < this.staff.size(); i++) {
			Staff currentStaff = this.staff.get(i);
			// if current staff is it add to list
			if (currentStaff instanceof Vet) {
				// need to cast Staff to Nurse
				list.add((Vet) currentStaff);
			}
		}
		return list;
	}

	// return a list of dogs
	public ArrayList<Dog> getDogs() {
		ArrayList<Dog> list = new ArrayList<Dog>();
		// loop through all animals
		for (int i = 0; i < this.animals.size(); i++) {
			Animal currentAnimal = this.animals.get(i);
			// if current staff is it add to list
			if (currentAnimal instanceof Dog) {
				// need to cast Animal to Dog
				list.add((Dog) currentAnimal);
			}
		}
		return list;
	}
	
	// return a list of cats
	public ArrayList<Cat> getCats() {
		ArrayList<Cat> list = new ArrayList<Cat>();
		// loop through all animals
		for (int i = 0; i < this.animals.size(); i++) {
			Animal currentAnimal = this.animals.get(i);
			// if current staff is it add to list
			if (currentAnimal instanceof Cat) {
				// need to cast Animal to Cat
				list.add((Cat) currentAnimal);
			}
		}
		return list;
	}

	// return a list of rabbits
	public ArrayList<Rabbit> getRabbits() {
		ArrayList<Rabbit> list = new ArrayList<Rabbit>();
		// loop through all animals
		for (int i = 0; i < this.animals.size(); i++) {
			Animal currentAnimal = this.animals.get(i);
			// if current staff is it add to list
			if (currentAnimal instanceof Rabbit) {
				// need to cast Animal to Rabbit
				list.add((Rabbit) currentAnimal);
			}
		}
		return list;
	}

	// return a list of pigs
	public ArrayList<Pig> getPigs() {
		ArrayList<Pig> list = new ArrayList<Pig>();
		// loop through all animals
		for (int i = 0; i < this.animals.size(); i++) {
			Animal currentAnimal = this.animals.get(i);
			// if current staff is it add to list
			if (currentAnimal instanceof Pig) {
				// need to cast Animal to Pig
				list.add((Pig) currentAnimal);
			}
		}
		return list;
	}
	
}
