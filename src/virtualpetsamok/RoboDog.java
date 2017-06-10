package virtualpetsamok;

public class RoboDog extends Dog implements RoboticPet {
	int oilLevel;

	public RoboDog(String newName, String newDescription) {
		super(newName, newDescription);
		oilLevel = 50;
	}

	@Override
	public void walk() {
		mood += 20;
		health += 10;
		oilLevel -= 5;
	}

	@Override
	public void play() {
		mood += 20;
		oilLevel -= 5;
	}

	@Override 
	public void tick() {
		mood -= (5 + generateRandom());
		oilLevel -= (5 + generateRandom());	
	}

	@Override
	public void oilPet() {
		oilLevel += 20;
	}

	@Override
	public int getOilLevel() {
		return oilLevel;
	}

	@Override
	public void recharge() {
		mood += 10;
		health += 10;
	}

}