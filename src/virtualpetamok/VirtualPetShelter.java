package virtualpetamok;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {
	// Map of pets and attributes
	private int litterBox = 50;

	Map<String, VirtualPet> shelterPets = new HashMap<String, VirtualPet>();
	Map<String, OrganicPet> organicDogs = new HashMap<String, OrganicPet>();
	Map<String, OrganicPet> organicCats = new HashMap<String, OrganicPet>();
	Map<String, RoboticPet> roboticDogs = new HashMap<String, RoboticPet>();
	Map<String, RoboticPet> roboticCats = new HashMap<String, RoboticPet>();

	public int getLitterBox() {
		return litterBox;
	}

	public void cleanLitterBox() {
		litterBox = 0;
	}

	public void maintainAllRobo() {
		for (RoboticPet d : roboticDogs.values()) {
			d.oilPet();
			d.recharge();
		}
		for (RoboticPet c : roboticCats.values()) {
			c.oilPet();
			c.recharge();
		}
	}

	public void cleanDogCages() {
		for (OrganicPet d : organicDogs.values()) {
			((OrgDog) d).cleanCage();
		}
	}

	public void walkDogs() {
		for (OrganicPet d : organicDogs.values()) {
			((Dog) d).walk();
		}
		for (RoboticPet d : roboticDogs.values()) {
			((Dog) d).walk();
		}

	}

	public void intake(OrganicPet pet) {
		shelterPets.put(pet.getName(), (VirtualPet) pet);
		if (pet instanceof OrgCat) {
			organicCats.put(pet.getName(), pet);
		}
		if (pet instanceof OrgDog) {
			organicDogs.put(pet.getName(), pet);
		}
	}

	public void intake(RoboticPet pet) {
		shelterPets.put(pet.getName(), (VirtualPet) pet);
		if (pet instanceof RoboCat) {
			roboticCats.put(pet.getName(), pet);
		}
		if (pet instanceof RoboDog) {
			roboticDogs.put(pet.getName(), pet);
		}
	}

	public void feedAllOrganic() {
		for (OrganicPet p : organicDogs.values()) {
			p.feed();
		}
		for (OrganicPet p : organicCats.values()) {
			p.feed();
		}
		litterBox += 10;
	}

	public void waterAllOrganic() {
		for (OrganicPet p : organicDogs.values()) {
			p.water();
		}
		for (OrganicPet p : organicCats.values()) {
			p.water();
		}
		litterBox += 5;
	}

	// Tick method (**ASK BRIAN WHY WE ARE RETURNING CAGE MESSINESS FOR DOGS**)
	void tickAllPets() {
		for (OrganicPet p : organicDogs.values()) {
			p.tick();
		}
		for (OrganicPet p : organicCats.values()) {
			litterBox += p.tick();
		}
		for (RoboticPet d : roboticDogs.values()) {
			((RoboDog) d).tick();
		}
		for (RoboticPet c : roboticCats.values()) {
			((RoboCat) c).tick();
		}
	}

	// Method returning collection of all pets in the shelter
	public Collection<VirtualPet> pets() {
		return shelterPets.values();
	}

	public Collection<OrganicPet> organicDogs() {
		return organicDogs.values();
	}

	public Collection<OrganicPet> organicCats() {
		return organicCats.values();
	}

	public Collection<RoboticPet> roboticDogs() {
		return roboticDogs.values();
	}

	public Collection<RoboticPet> roboticCats() {
		return roboticCats.values();
	}

	// Method to return a pet from the map by name
	public VirtualPet getPet(String name) {
		return shelterPets.get(name);

	}

	// Method to play with one pet
	public void playOne(VirtualPet player) {
		player.play();
	}

	// Method to adopt a pet
	public void adoptPet(VirtualPet pet) {
		shelterPets.remove(pet.getName());

		if (pet instanceof RoboDog) {
			roboticDogs.remove(pet.getName(), pet);
		}
		if (pet instanceof RoboCat) {
			roboticCats.remove(pet.getName(), pet);
		}
		if (pet instanceof OrgDog) {
			organicDogs.remove(pet.getName(), pet);
		}
		if (pet instanceof OrgCat) {
			organicCats.remove(pet.getName(), pet);
		}
	}
}