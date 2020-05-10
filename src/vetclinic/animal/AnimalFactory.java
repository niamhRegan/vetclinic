package vetclinic.animal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class AnimalFactory {

    private Random rnd = new Random();

    // read a file line by line into an array list
	private ArrayList<String> readFile(String filePath) {
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
	private ArrayList<String> getNames() {
		return this.readFile("petnames.txt");
	}

	// get list of pet conditions
	private ArrayList<String> getConditions() {
		return this.readFile("conditions.txt");
	}

	// create list of animals
	public ArrayList<Animal> createAnimals(int count) {
		ArrayList<String> names = this.getNames();
		ArrayList<String> conditions = this.getConditions();
		ArrayList<Animal> animals = new ArrayList<Animal>();
		
		for (int i = 0; i < count; i++) {
			String name = names.get(this.rnd.nextInt(names.size()));
			String condition = conditions.get(this.rnd.nextInt(conditions.size()));
			int age = this.rnd.nextInt(10);
			
			// randomly pick an animal type
			Animal animal = null;
			int animalType = this.rnd.nextInt(4);
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
			animals.add(animal);
		}		
		return animals;
	}

	private Cat createCat(String name, String condition, int age) {
		Cat cat = new Cat();
		cat.setName(name);
		cat.setCondition(condition);
		cat.setAge(age);
		cat.setCatFood("Cat Food");
		return cat;
	}

	private Dog createDog(String name, String condition, int age) {
		Dog dog = new Dog();
		dog.setName(name);
		dog.setCondition(condition);
		dog.setAge(age);
		dog.setDogFood("Dog Food");
		return dog;
	}

	private Pig createPig(String name, String condition, int age) {
		Pig pig = new Pig();
		pig.setName(name);
		pig.setCondition(condition);
		pig.setAge(age);
		pig.setPigFood("Pig Food");
		return pig;
	}

	private Rabbit createRabbit(String name, String condition, int age) {
		Rabbit rabbit = new Rabbit();
		rabbit.setName(name);
		rabbit.setCondition(condition);
		rabbit.setAge(age);
		rabbit.setRabbitFood("Rabbit Food");
		return rabbit;
	}

}
