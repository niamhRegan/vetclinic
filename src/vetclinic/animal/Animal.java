package vetclinic.animal;

public class Animal {

	private String name;
	private int age;
	private String condition;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return 	"TYPE: ANIMAL\n" + 
				"NAME: " + this.getName()+ "\n" + 
				"AGE: " + this.getAge() + "\n" + 
				"CONDITION: " + this.getCondition() + "\n";
	}
	
}
