package vetclinic.animal;

public class Rabbit extends Animal {

	public String toString() {
		return 	"TYPE: RABBIT\n" + 
				"NAME: " + this.getName()+ "\n" + 
				"AGE: " + this.getAge() + "\n" + 
				"CONDITION: " + this.getCondition() + "\n";
	}
	
}
