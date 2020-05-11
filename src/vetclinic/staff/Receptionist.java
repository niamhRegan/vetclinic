package vetclinic.staff;

public class Receptionist extends Admin {

	public String toString() {
		return "TYPE: RECEPTIONIST\n" +
				"NAME: " + this.getName() + "\n" + 
				"NUMBER: " + this.getNumber() + "\n" + 
				"SALARY: " + this.getSalary() + "\n" +
				"TASK: " + this.getTask() + "\n";
	}

}
