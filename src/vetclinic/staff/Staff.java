package vetclinic.staff;

public class Staff {

	private String name;
	private int number;
	private int salary;

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
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String toString() {
		return "TYPE: STAFF\n" +
				"NAME: " + this.getName() + "\n" + 
				"NUMBER: " + this.getNumber() + "\n" + 
				"SALARY: " + this.getSalary() + "\n";
	}
	
}
