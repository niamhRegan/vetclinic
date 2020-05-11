package vetclinic.staff;

public class Admin extends Staff {

	private String task;
	
	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}
	
	public String toString() {
		return "TYPE: ADMIN\n" +
				"NAME: " + this.getName() + "\n" + 
				"NUMBER: " + this.getNumber() + "\n" + 
				"SALARY: " + this.getSalary() + "\n" +
				"TASK: " + this.getTask() + "\n";
	}
	
}
