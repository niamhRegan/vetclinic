package vetclinic.staff;

public class Staff {

	private static int counter = 1;
	private String name;
	private int number;
	private float salary;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public float getSalary() {
		return salary;
	}
	
	public void setSalary(float salary) {
		this.salary = salary;
	}

	// return the current counter and then increment it 
	public static int getNewId() {
		return counter++;
	}	
}
