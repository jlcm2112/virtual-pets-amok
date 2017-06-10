package virtualpetsamok;

public class OrgCat extends Cat implements OrganicPet {
	protected int hunger;
	protected int thirst;
	
	public OrgCat(String nameParam, String descriptionParam) {
		super(nameParam, descriptionParam);
		hunger = 50;
		thirst = 50;	}

	@Override
	public void feed() {
		hunger -= 20;
		mood += 10;
	}

	@Override
	public void water() {
		thirst -= 20;
		mood += 10;		
	}

	@Override
	public void play() {
		mood += 20;
		hunger += 10;
		thirst += 10;		
	}

	@Override
	public int tick() { // increments hunger, thirst, and mood, and returns integer which will be used to affect litter
		hunger += (5 + generateRandom());
		thirst += (5 + generateRandom());
		mood -= (5 + generateRandom());		
		return (1 + generateRandom());
	}

	@Override
	public int getHunger() {
		return hunger;
	}

	@Override
	public int getThirst() {
		return thirst;
	}


}