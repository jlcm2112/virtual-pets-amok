package virtualpetamok;

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
	
	public abstract String getName();
	
	public abstract int getHealth();
	
	public abstract int getMood();
	
	public abstract void play();
	
	public abstract int tick();
	
	public abstract int generateRandom();
	
	@Override
	public String toString() {
		return ("[" + name + "] " + description); 
	}
}