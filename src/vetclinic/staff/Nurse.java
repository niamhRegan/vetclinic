package vetclinic.staff;

public class Nurse extends Medical {

	public String toString() {
		return "TYPE: NURSE\n" +
				"NAME: " + this.getName() + "\n" + 
				"NUMBER: " + this.getNumber() + "\n" + 
				"SALARY: " + this.getSalary() + "\n";
	}
	
}
