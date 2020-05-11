package vetclinic.staff;

public class It extends Admin {

	public String toString() {
		return "TYPE: IT\n" +
				"NAME: " + this.getName() + "\n" + 
				"NUMBER: " + this.getNumber() + "\n" + 
				"SALARY: " + this.getSalary() + "\n" +
				"TASK: " + this.getTask() + "\n";
	}
	
}
