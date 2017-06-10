package virtualpetamok;

public interface OrganicPet {

	String getName();

	void feed();

	void water();
	
	int tick();
	
	int getHunger();
	int getThirst();

}