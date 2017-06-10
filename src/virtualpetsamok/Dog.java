package virtualpetsamok;

public abstract class Dog extends VirtualPet {

	public Dog(String nameParam, String descriptionParam) {
		super(nameParam, descriptionParam);
	}
	
	public abstract void walk();
	

}
