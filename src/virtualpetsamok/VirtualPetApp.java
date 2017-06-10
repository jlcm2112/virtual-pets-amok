package virtualpetsamok;

import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) {

		VirtualPetShelter shelter = new VirtualPetShelter();
		Scanner input = new Scanner(System.in);

		OrganicPet steve = new OrgDog("OrgDog", "Shih-Tzu");
		shelter.intake(steve);
		RoboticPet paul = new RoboDog("RoboDog", "A robotic dog");
		shelter.intake(paul);
		OrganicPet jess = new OrgCat("OrgCat", "Siamese");
		shelter.intake(jess);
		RoboticPet oly = new RoboCat("RoboCat", "A robotic cat");
		shelter.intake(oly);

		boolean quit = false;

		do {//test for litterbox overflow
			if (shelter.getLitterBox() >= 100) {
				writeLine("The litterbox is overflowing and it's negatively affecting the health of all organic cats in the shelter.");
				for (VirtualPet pet : shelter.pets()) {
					if (pet instanceof OrgCat) {
						((OrgCat) pet).decreaseHealth();
					}
				}
			}//test each dog cage messiness 
			for (VirtualPet pet : shelter.pets()) {
				if (pet instanceof OrgDog) {

					if (((OrgDog) pet).getCageMessiness() >= 100) {
						writeLine("The organic dog " + pet.getName()
								+ "'s cage needs cleaning and it's currently negatively affecting their health.");
						((OrgDog) pet).decreaseHealth();
					}
				}
			}//test robotic pets for maintenance issues
			for (VirtualPet pet : shelter.pets()) {
				if (pet instanceof RoboticPet) {

					if (((RoboticPet) pet).getOilLevel() <= 10) {
						writeLine("The robotic pet " + pet.getName()
								+ "'s needs oil and it's currently negatively affecting their health.");
						 pet.decreaseHealth();
					}
				}
			}

			writeLine("\nThank you for volunteering at the animal shelter!");
			writeLine("\nThis is the status of your pets: ");
			writeLine("\nName\t|Mood\t|Health\t|Hunger\t|Thirst\t|OilLvl\t|CageMess");
			writeLine("--------|-------|-------|-------|-------|-------|-------");

			for (VirtualPet currentPet : shelter.pets()) {
				System.out.print(currentPet.getName() + "\t|" + ((VirtualPet) currentPet).getMood() + "\t|"
						+ ((VirtualPet) currentPet).getHealth() + "\t|");
				if (currentPet instanceof OrganicPet) {
					System.out.print(((OrganicPet) currentPet).getHunger() + "\t|"
							+ ((OrganicPet) currentPet).getThirst() + "\t|N/A\t|");
				} else if (currentPet instanceof RoboticPet) {
					System.out.print("N/A\t|N/A\t|" + ((RoboticPet) currentPet).getOilLevel() + "\t|");
				}
				if (currentPet instanceof OrgDog) {
					System.out.print("" + ((OrgDog) currentPet).getCageMessiness() + "\t|");
				} else {
					System.out.print("N/A\t|");
				}
				System.out.print("\n");

			}
			
			writeLine("The litterbox is: " + shelter.getLitterBox());
			writeLine("\nWhat would you like to do next?");
			writeLine(
					"\n1.Feed the organic pets \n2.Water the organic pets \n3.Play with a pet \n4.Adopt a pet \n5.Admit a pet \n6.Clean Cages \n7.Clean Litterbox \n8.Walk Dogs \n9.Maintain all RoboPets \n10.Do nothing \n11.Quit");
			String response = input.nextLine();

			switch (response) {
			case "1":
				shelter.feedAllOrganic();
				writeLine("You fed all the organic pets!");
				break;
			case "2":
				shelter.waterAllOrganic();
				writeLine("You watered all the organic pets!");
				break;
			case "3": // play
				writeLine("Ok, so you'd like to play with a pet. Please choose one:\n");
				displayPets(shelter);
				writeLine("\nWhich pet would you like to play with?");
				String petName = input.nextLine();
				shelter.playOne(shelter.getPet(petName));
				writeLine("OK, you play with " + shelter.getPet(petName).getName() + ". ");
				break;
			case "4": // adopt
				writeLine("Ok, so you'd like to adopt a pet. Please choose one:\n");
				displayPets(shelter);
				writeLine("\nWhich pet would you like to adopt");
				String nameToAdopt = input.nextLine();
				VirtualPet pet = shelter.getPet(nameToAdopt);
				shelter.adoptPet(pet);
				writeLine("You adopted " + pet.getName() + ". Please take good care of him/her!");
				break;
			case "5":// intake
				writeLine("Ok you have a pet for us! Is it organic or robotic?");
				String response2 = input.next();
				if (response2.equalsIgnoreCase("organic")) {
					writeLine("Great! is your organic pet a cat or a dog?");
					String response3 = input.next();
					input.nextLine();
					if (response3.equalsIgnoreCase("dog")) {
						writeLine("Great! What is the dog's name?");
						String name = input.nextLine();
						writeLine("Great! What is a short description of the dog?");
						String description = input.nextLine();
						OrganicPet x = new OrgDog(name, description);
						shelter.intake(x);
						writeLine("Thanks! We'll take good care of " + x.getName()+".");
					} else if (response3.equalsIgnoreCase("cat")) {
						writeLine("Great! What is the cat's name?");
						String name = input.nextLine();
				
						writeLine("Great! What is a short description of the cat?");
						String description = input.nextLine();
						OrganicPet y = new OrgCat(name, description);
						shelter.intake(y);
						writeLine("Thanks! We'll take good care of " + y.getName()+".");
					}

				} else if (response2.equalsIgnoreCase("robotic")) {
					writeLine("Great! is your robotic pet a cat or a dog?");
					String response3 = input.next();
					input.nextLine();

					if (response3.equalsIgnoreCase("dog")) {
						writeLine("Great! What is the dog's name?");
						String name = input.nextLine();
						writeLine("Great! What is a short description of the dog?");
						String description = input.nextLine();
						RoboticPet r = new RoboDog(name, description);
						shelter.intake(r);
						writeLine("Thanks! We'll take good care of " + r.getName()+".");

					} else if (response3.equalsIgnoreCase("cat")) {
						writeLine("Great! What is the cat's name?");
						String name = input.nextLine();
						writeLine("Great! What is a short description of the cat?");
						String description = input.nextLine();
						RoboticPet w = new RoboCat(name, description);
						shelter.intake(w);
						writeLine("Thanks! We'll take good care of " + w.getName()+".");
					}
				}
				break;
			case "6":
				shelter.cleanDogCages();
				writeLine("You clean all the organic dog cages!");
				break;
			case "7":
				shelter.cleanLitterBox();
				writeLine("You cleaned the litterbox!");
				break;
			case "8":
				shelter.walkDogs();
				writeLine("You walked all the dogs!");
				break;
			case "9":
				shelter.maintainAllRobo();
				writeLine("You maintained all robotic pets!");
				break;
			case "10":
				// tick
				break;
			case "11":
				writeLine("Nobody likes a quitter...");
				System.exit(0);
			default:
				writeLine("Sorry, I didn't understand you. Try again.");
				break;
			}
			shelter.tickAllPets();

		} while (!quit);
		input.close();
	}

	private static void displayPets(VirtualPetShelter shelter) {
		for (VirtualPet currentPet : shelter.pets()) {
			writeLine("" + currentPet);
		}
	}

	public static void writeLine(String message) {
		System.out.println(message);
	}
}