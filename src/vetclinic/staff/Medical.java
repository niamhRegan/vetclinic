package vetclinic.staff;

import java.util.ArrayDeque;
import java.util.ArrayList;
import vetclinic.animal.Animal;

public class Medical extends Staff {

	// each medical staff has a queue of patients
	private ArrayDeque<Animal> patients = new ArrayDeque<Animal>();

	// remove the next animal from the patient queue
	public Animal getNextPatient() {
		return this.patients.remove();
	}

	// add animal to queue
	public void addPatient(Animal animal) {
		this.patients.add(animal);
	}

	// return list of patients which has no order
	public ArrayList<Animal> getPatientList() {
	    return new ArrayList<Animal>(this.patients);
	}

	// return list of patients in a queue which keeps the order
	public ArrayDeque<Animal> getPatientQueue() {
	    return this.patients;
	}
	
	public String toString() {
		return "TYPE: MEDICAL\n" +
				"NAME: " + this.getName() + "\n" + 
				"NUMBER: " + this.getNumber() + "\n" + 
				"SALARY: " + this.getSalary() + "\n";
	}
}
