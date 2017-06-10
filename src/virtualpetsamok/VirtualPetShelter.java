package virtualpetsamok;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {
	// Map of pets and attributes
	private int litterBox = 50;

	private Map<String, VirtualPet> shelterPets = new HashMap<String, VirtualPet>();

	public int getLitterBox() {
		return litterBox;
	}

	public void cleanLitterBox() {
		litterBox = 0;
	}

	public void maintainAllRobo() {
		for (VirtualPet pet : pets()) {
			if (pet instanceof RoboticPet) {
				((RoboticPet) pet).oilPet();
				((RoboticPet) pet).recharge();
			}
		}
	}

	public void cleanDogCages() {
		for (VirtualPet pet : pets()) {
			if (pet instanceof OrgDog) {
				((OrgDog) pet).cleanCage();
			}
		}
	}

	public void walkDogs() {
		for (VirtualPet pet : pets()) {
			if (pet instanceof Dog) {
				((Dog) pet).walk();
			}
		}

	}

	public void intake(VirtualPet pet) {
		shelterPets.put(pet.getName(), (VirtualPet) pet);
	}

	public void intake(RoboticPet pet) {
		shelterPets.put(pet.getName(), (VirtualPet) pet);
	}

	public void intake(OrganicPet pet) {
		shelterPets.put(pet.getName(), (VirtualPet) pet);
	}

	public void feedAllOrganic() {
		for (VirtualPet pet : pets()) {
			if (pet instanceof OrganicPet) {
				((OrganicPet) pet).feed();
			}
		}
		litterBox += 10;
	}

	public void waterAllOrganic() {
		for (VirtualPet pet : pets()) {
			if (pet instanceof OrganicPet) {
				((OrganicPet) pet).water();
			}
		}
		litterBox += 5;
	}

	// Tick method (**ASK BRIAN WHY WE ARE RETURNING CAGE MESSINESS FOR ORGANIC
	// DOGS**)
	void tickAllPets() {
		for (VirtualPet pet : pets()) {
			if (pet instanceof OrgCat) {
				litterBox += ((OrgCat) pet).tick();
			} else if (pet instanceof OrganicPet) {
				((OrganicPet) pet).tick();
			}
		}
	}

	// Method returning collection of all pets in the shelter
	public Collection<VirtualPet> pets() {
		return shelterPets.values();
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
	}
}