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

		do {
			if (shelter.getLitterBox() >= 100) {
				writeLine("The litterbox is really dirty and is affecting the health of all cats in the shelter.");
				for (OrganicPet currentPet : shelter.organicCats()) {
					((OrgCat) currentPet).decreaseHealth();
				}
			}
				for (OrganicPet currentPet : shelter.organicDogs()) {
					if (((OrgDog) currentPet).getCageMessiness() >= 100) {
						writeLine("The organic dog " + currentPet.getName() + "'s cage needs cleaning and is currently negatively affecting their health.");
					((OrgDog) currentPet).decreaseHealth();
					}
				}

			writeLine("\nThank you for volunteering at the animal shelter!");
			writeLine("\nThis is the status of your pets: ");
			writeLine("\nName\t|Mood\t|Health\t|Hunger\t|Thirst\t|OilLvl\t|CageMess");
			writeLine("--------|-------|-------|-------|-------|-------|-------");

			for (OrganicPet currentPet : shelter.organicCats()) {
				writeLine(currentPet.getName() + "\t|" + ((VirtualPet) currentPet).getMood() + "\t|"
						+ ((VirtualPet) currentPet).getHealth() + "\t|" + currentPet.getHunger() + "\t|"
						+ currentPet.getThirst() + "\t|" + "N/A" + "\t|" + "N/A");
			}
			for (OrganicPet currentPet : shelter.organicDogs()) {
				writeLine(currentPet.getName() + "\t|" + ((VirtualPet) currentPet).getMood() + "\t|"
						+ ((VirtualPet) currentPet).getHealth() + "\t|" + currentPet.getHunger() + "\t|"
						+ currentPet.getThirst() + "\t|" + "N/A" + "\t|" + ((OrgDog) currentPet).getCageMessiness());
			}
			for (RoboticPet currentPet : shelter.roboticDogs()) {
				writeLine(currentPet.getName() + "\t|" + ((VirtualPet) currentPet).getMood() + "\t|"
						+ ((VirtualPet) currentPet).getHealth() + "\t|" + "N/A" + "\t|" + "N/A" + "\t|"
						+ currentPet.getOilLevel() + "\t|" + "N/A");
			}
			for (RoboticPet currentPet : shelter.roboticCats()) {
				writeLine(currentPet.getName() + "\t|" + ((VirtualPet) currentPet).getMood() + "\t|"
						+ ((VirtualPet) currentPet).getHealth() + "\t|" + "N/A" + "\t|" + "N/A" + "\t|"
						+ currentPet.getOilLevel() + "\t|" + "N/A");
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
				writeLine("OK, you play with " + petName + ". ");
				break;
			case "4": //adopt
				writeLine("Ok, so you'd like to adopt a pet. Please choose one:\n");
				displayPets(shelter);
				writeLine("\nWhich pet would you like to adopt");
				String nameToAdopt = input.nextLine();
				VirtualPet x = shelter.getPet(nameToAdopt);
				shelter.adoptPet(x);
				writeLine("You adopted " + nameToAdopt + ". Please take good care of him/her!");
				break;
			case "5"://intake
				writeLine("Ok you have a pet for us! Is it organic or robotic?");
				String response2 = input.nextLine();
				if (response2.equalsIgnoreCase("organic")) {
					writeLine("Great! is your organic pet a cat or a dog?");
					String response3 = input.nextLine();
					if (response3.equalsIgnoreCase("dog")) {
						writeLine("Great! What is the dog's name?");
						String name = input.nextLine();
						writeLine("Great! What is a short description of the dog?");
						String description = input.nextLine();
						OrganicPet d = new OrgDog(name, description);
						shelter.intake(d);
					} else if (response3.equalsIgnoreCase("cat")) {
						writeLine("Great! What is the cat's name?");
						String name = input.nextLine();
						writeLine("Great! What is a short description of the cat?");
						String description = input.nextLine();
						OrganicPet c = new OrgCat(name, description);
						shelter.intake(c);
					}

				} else if (response2.equalsIgnoreCase("robotic")) {
					writeLine("Great! is your robotic pet a cat or a dog?");
					String response3 = input.nextLine();

					if (response3.equalsIgnoreCase("dog")) {
						writeLine("Great! What is the dog's name?");
						String name = input.nextLine();
						writeLine("Great! What is a short description of the dog?");
						String description = input.nextLine();
						RoboticPet d = new RoboDog(name, description);
						shelter.intake(d);
					} else if (response3.equalsIgnoreCase("cat")) {
						writeLine("Great! What is the cat's name?");
						String name = input.nextLine();
						writeLine("Great! What is a short description of the cat?");
						String description = input.nextLine();
						RoboticPet c = new RoboCat(name, description);
						shelter.intake(c);
					}
				}
				break;
			case "6":
				shelter.cleanDogCages();
				writeLine("You clean all the dog cages!");
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

		}while(!quit);input.close();

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