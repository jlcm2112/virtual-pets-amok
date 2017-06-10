package virtualpetsamok;

public class OrgDog extends Dog implements OrganicPet {

	protected int cageMessiness;
	protected int hunger;
	protected int thirst;

	public OrgDog(String newName, String newDescription) {
		super(newName, newDescription);
		cageMessiness = 50;
		hunger = 50;
		thirst = 50;
	}

	public void feed() {
		hunger -= 20;
		mood += 10;
		cageMessiness += 10;
	}

	public void water() {
		thirst -= 20;
		mood += 10;
		cageMessiness += 10;
	}

	@Override
	public void walk() {
		cageMessiness -= 20;
		mood += 20;
		health += 10;
		hunger += 5;
		thirst += 5;
	}

	@Override
	public void play() {
		mood += 20;
		hunger += 10;
		thirst += 10;
		health += 10;
	}

	@Override 
	public int tick() {
		hunger += (5 + generateRandom());
		thirst += (5 + generateRandom());
		mood -= (5 + generateRandom());
		cageMessiness += (5 + generateRandom());
		return 0;
	}

	@Override
	public int getHunger() {
		return hunger;
	}

	public int getCageMessiness() {
		return cageMessiness;
	}

	public void cleanCage() {
		cageMessiness = 0;
		mood += 10;
		health += 10;
	}

	@Override
	public int getThirst() {
		return thirst;
	}
}