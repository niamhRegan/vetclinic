package vetclinic.animal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class AnimalFactory {

    private Random rnd = new Random();

    // read a file line by line into an array list
	public ArrayList<String> readFile(String filePath) {
		ArrayList<String> list = new ArrayList<String>();
	    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {	 
	        String line;
	        while ((line = br.readLine()) != null) {
	        	list.add(line);
	        }
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }		
	    return list;
	}
	
	// get list of pet names
	public ArrayList<String> getNames() {
		return this.readFile("petnames.txt");
	}

	// get list of pet conditions
	public ArrayList<String> getConditions() {
		return this.readFile("conditions.txt");
	}

	// create list of animals
	public ArrayList<Animal> createAnimals() {
		ArrayList<String> names = this.getNames();
		ArrayList<String> conditions = this.getConditions();
		ArrayList<Animal> animals = new ArrayList<Animal>();

		// loop count times
		for (int i = 0; i < 1000; i++) {
			// get name, condition and age
			String name = names.get(this.rnd.nextInt(names.size()));
			String condition = conditions.get(this.rnd.nextInt(conditions.size()));
			int age = this.rnd.nextInt(10);
			
			// randomly pick an animal type
			Animal animal = null;
			int animalType = this.rnd.nextInt(4);

			// create the animal
			switch (animalType) {
				case 0:
					animal = this.createCat(name, condition, age);
					break;
				case 1:
					animal = this.createDog(name, condition, age);
					break;
				case 2:
					animal = this.createPig(name, condition, age);
					break;
				case 3:
					animal = this.createRabbit(name, condition, age);
					break;
			}
			// add the animal to the list
			animals.add(animal);
		}		
		return animals;
	}

	// create a Cat
	public Cat createCat(String name, String condition, int age) {
		Cat cat = new Cat();
		cat.setName(name);
		cat.setCondition(condition);
		cat.setAge(age);
		return cat;
	}

	// create a Dog
	public Dog createDog(String name, String condition, int age) {
		Dog dog = new Dog();
		dog.setName(name);
		dog.setCondition(condition);
		dog.setAge(age);
		return dog;
	}

	// create a Pig	
	public Pig createPig(String name, String condition, int age) {
		Pig pig = new Pig();
		pig.setName(name);
		pig.setCondition(condition);
		pig.setAge(age);
		return pig;
	}

	// create a Rabbit
	public Rabbit createRabbit(String name, String condition, int age) {
		Rabbit rabbit = new Rabbit();
		rabbit.setName(name);
		rabbit.setCondition(condition);
		rabbit.setAge(age);
		return rabbit;
	}

}
