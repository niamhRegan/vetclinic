package vetclinic.animal;

public class Cat extends Animal {

	public String toString() {
		return 	"TYPE: CAT\n" + 
				"NAME: " + this.getName()+ "\n" + 
				"AGE: " + this.getAge() + "\n" + 
				"CONDITION: " + this.getCondition() + "\n";
	}
	
}
