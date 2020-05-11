package vetclinic.staff;

public class Vet extends Medical {

	public String toString() {
		return "TYPE: VET\n" +
				"NAME: " + this.getName() + "\n" + 
				"NUMBER: " + this.getNumber() + "\n" + 
				"SALARY: " + this.getSalary() + "\n";
	}
	
}
