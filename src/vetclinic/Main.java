package vetclinic;

import java.util.ArrayList;

import vetclinic.animal.Animal;
import vetclinic.animal.AnimalFactory;

public class Main {

	public static void main(String[] args) {
		System.out.println("Vet Clinic");

		AnimalFactory animalFactory = new AnimalFactory();
		ArrayList<Animal> animals = animalFactory.createAnimals(1000);
		System.out.println(animals);
		
		
	}

}
