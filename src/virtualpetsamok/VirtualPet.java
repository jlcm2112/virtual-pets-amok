package virtualpetsamok;

import java.util.Random;

public abstract class VirtualPet {

	protected Random generator = new Random();
	
	//Instance variables
	protected String name;
	protected String description;

	protected int health;
	protected int mood;
	
	//Constructor that accepts VirtualPet and establishes default attributes for new pets
	public VirtualPet(String newName, String newDescription) {
		name = newName;
		description = newDescription;
		health = 50;
		mood = 50;
	}
	
	public String getName() {
		return name;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getMood() {
		return mood;
	}
	
	public abstract void play();
		
	public int generateRandom() {
		return generator.nextInt(10);
	}
	
	@Override
	public String toString() {
		return ("[" + name + "] " + description); 
	}

	public void decreaseHealth() {
		health -= 10;
	}
}