package vetclinic.animal;

public class Dog extends Animal {

	public String toString() {
		return 	"TYPE: DOG\n" + 
				"NAME: " + this.getName()+ "\n" + 
				"AGE: " + this.getAge() + "\n" + 
				"CONDITION: " + this.getCondition() + "\n";
	}
	
}