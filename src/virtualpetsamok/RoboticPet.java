package virtualpetsamok;

public interface RoboticPet {

	String getName();
	
	public void oilPet();
	public int getOilLevel();
	public void recharge();
	public abstract void tick();

}