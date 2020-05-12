package vetclinic;

import java.util.ArrayList;

import vetclinic.animal.Animal;
import vetclinic.animal.AnimalFactory;

public class Main {

	public static void main(String[] args) {
		System.out.println("Vet Clinic");

		// create animals using factory
		AnimalFactory animalFactory = new AnimalFactory();
		ArrayList<Animal> animals = animalFactory.createAnimals();
		System.out.println(animals);		

		// show main menu loop
		Menu menu = new Menu();
		menu.mainMenuLoop();
	}

}
