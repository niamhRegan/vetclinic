package vetclinic.staff;

public class TraineeVet extends Medical {

	public String toString() {
		return "TYPE: TRAINEE VET\n" +
				"NAME: " + this.getName() + "\n" + 
				"NUMBER: " + this.getNumber() + "\n" + 
				"SALARY: " + this.getSalary() + "\n";
	}
	
}
