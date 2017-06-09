package pets;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
 
Map<String, VirtualPet> mapOfPets = new HashMap<String, VirtualPet>(); //instance variable

public void walkDogs() {
	
}


public void

public Collection<VirtualPet> pets(){
	return mapOfPets.values();
}
public VirtualPet getPet(String name){
	return mapOfPets.get(name);
}
public void intake(VirtualPet pet){
	mapOfPets.put(pet.name, pet);
}
public void adopt(VirtualPet pet){
	mapOfPets.remove(pet.name);
} 
public void feedPets(){
	for(VirtualPet currentPet: pets()){
		currentPet.feed();
	}
}
public void waterPets(){
	for(VirtualPet currentPet: pets()){
		currentPet.water();
	}
}
public void playWith(String name){
	getPet(name).play();
}
public void cleanCage(String name){
	getPet(name).cleanCage();
}
public void tick() {
	for(VirtualPet currentPet: pets()){
		currentPet.tick();
	}
}
@Override
public String toString() {
	return ("" + mapOfPets.keySet() + mapOfPets.values()); 
}
}
