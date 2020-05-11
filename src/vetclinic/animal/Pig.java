package vetclinic.animal;

public class Pig extends Animal {

	public String toString() {
		return 	"TYPE: PIG\n" + 
				"NAME: " + this.getName()+ "\n" + 
				"AGE: " + this.getAge() + "\n" + 
				"CONDITION: " + this.getCondition() + "\n";
	}
	
}
