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
	
}
