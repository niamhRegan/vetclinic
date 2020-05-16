package vetclinic.staff;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

// Creates all Staff classes (Nurse, Vet, Trainee Vet, Receptionist, IT)
public class StaffFactory {

    private Random rnd = new Random();
    
    // read a file line by line into an array list
	public ArrayList<String> readFile(String filePath) {
		ArrayList<String> list = new ArrayList<String>();
	    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {	 
	        String line;
	        while ((line = br.readLine()) != null) {
	        	list.add(line);
	        }
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }		
	    return list;
	}
	
	// get list of people names
	public ArrayList<String> getNames() {
		return this.readFile("peoplenames.txt");
	}

	// get list of tasks
	public ArrayList<String> getTasks() {
		return this.readFile("tasks.txt");
	}
	
	// create list of staff
	public ArrayList<Staff> createStaff() {
		ArrayList<String> names = this.getNames();
		ArrayList<String> tasks = this.getTasks();
		ArrayList<Staff> staffList = new ArrayList<Staff>();
		int uniqueNumber = 1;

		// create 10 IT staff
		for (int i = 0; i < 10; i++) {
			String name = names.get(this.rnd.nextInt(names.size()));
			int salary = this.rnd.nextInt(60000);
			String task = tasks.get(this.rnd.nextInt(tasks.size()));
			Staff staff = this.createIt(name, uniqueNumber, salary, task);
			staffList.add(staff);
			uniqueNumber++;
		}

		// create 10 Receptionist staff
		for (int i = 0; i < 10; i++) {
			String name = names.get(this.rnd.nextInt(names.size()));
			int salary = this.rnd.nextInt(40000);
			String task = tasks.get(this.rnd.nextInt(tasks.size()));
			Staff staff = this.createReceptionist(name, uniqueNumber, salary, task);			
			staffList.add(staff);			
			uniqueNumber++;
		}

		// create 10 Vets
		for (int i = 0; i < 10; i++) {
			String name = names.get(this.rnd.nextInt(names.size()));
			int salary = this.rnd.nextInt(80000);
			Staff staff = this.createVet(name, uniqueNumber, salary);			
			staffList.add(staff);			
			uniqueNumber++;
		}
		
		// create 10 Trainee Vets
		for (int i = 0; i < 10; i++) {
			String name = names.get(this.rnd.nextInt(names.size()));
			int salary = this.rnd.nextInt(30000);
			Staff staff = this.createTraineeVet(name, uniqueNumber, salary);			
			staffList.add(staff);			
			uniqueNumber++;
		}
		
		// create 10 Nurses
		for (int i = 0; i < 10; i++) {
			String name = names.get(this.rnd.nextInt(names.size()));
			int salary = this.rnd.nextInt(50000);
			Staff staff = this.createNurse(name, uniqueNumber, salary);			
			staffList.add(staff);			
			uniqueNumber++;
		}		
		return staffList;
	}

	// create It
	public It createIt(String name, int number, int salary, String task) {
		It it = new It();
		it.setName(name);
		it.setNumber(number);
		it.setSalary(salary);
		it.setTask(task);
		return it;
	}

	// create Receptionist
	public Receptionist createReceptionist(String name, int number, int salary, String task) {
		Receptionist receptionist = new Receptionist();
		receptionist.setName(name);
		receptionist.setNumber(number);
		receptionist.setSalary(salary);
		receptionist.setTask(task);
		return receptionist;
	}

	// create Vet
	public Vet createVet(String name, int number, int salary) {
		Vet vet = new Vet();
		vet.setName(name);
		vet.setNumber(number);
		vet.setSalary(salary);
		return vet;
	}
	
	// create TraineeVet
	public TraineeVet createTraineeVet(String name, int number, int salary) {
		TraineeVet traineeVet = new TraineeVet();
		traineeVet.setName(name);
		traineeVet.setNumber(number);
		traineeVet.setSalary(salary);
		return traineeVet;
	}

	// create Nurse
	public Nurse createNurse(String name, int number, int salary) {
		Nurse nurse = new Nurse();
		nurse.setName(name);
		nurse.setNumber(number);
		nurse.setSalary(salary);
		return nurse;
	}
	
}
