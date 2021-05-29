package com.skilldistillery.jets.app;

import java.util.Scanner;

import com.skilldistillery.jets.entity.AirField;
import com.skilldistillery.jets.entity.CargoPlane;
import com.skilldistillery.jets.entity.FighterJet;
import com.skilldistillery.jets.entity.JetImpl;

public class JetsApplication {
	private AirField airField;
	private Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		JetsApplication jetsApp = new JetsApplication();
		jetsApp.launch();
	}

	private void launch() {
		while (true) {
			displayUserMenu();
			System.out.println();
		}
	}

	private void displayUserMenu() {
		System.out.println("Please select from the menu below:");
		System.out.println("1. List fleet.");
		System.out.println("2. Fly all jets.");
		System.out.println("3. View fastest jet.");
		System.out.println("4. View jet with longest range.");
		System.out.println("5. Load all cargo planes!");
		System.out.println("6. DOGFIGHT!!!");
		System.out.println("7. Add a jet to the fleet.");
		System.out.println("8. Remove a jet from the fleet");
		System.out.println("9. Quit.");
		System.out.print("Selection: ");
		int choice = kb.nextInt();

		switch (choice) {
		case 1:
			System.out.println();
			airField.listFleet();
			break;
		case 2:
			System.out.println();
			airField.flyAllJets();
			break;
		case 3:
			System.out.println();
			airField.fastestJet();
			break;
		case 4:
			System.out.println();
			airField.longestRange();
			break;
		case 5:
			System.out.println();
			airField.loadCargo();
			break;
		case 6:
			System.out.println();
			airField.startFight();
			break;
		case 7:
			createJet();
			break;
		case 8:
			removeJet(); // need code for this
			break;
		case 9:
			quitProgram();
			break;
		}
	}

	public void createJet() {
		System.out.println("Let's create your own jet. What type do you want to create?");
		System.out.println("1. Fighter Jet");
		System.out.println("2. Cargo Carrier");
		System.out.println("3. Commercial Jet");
		System.out.print("Selection: ");
		int choice = kb.nextInt();
		
		switch (choice) {
		case 1: 
			createFighterJet();
			break;
		case 2: 
			createCargoPlane();
			break;
		case 3: 
			createJetImpl();
			break;
		}
	}

	private void createFighterJet() {
		System.out.println("Please enter a model name: ");
		String model = kb.next();
		System.out.println("Please enter the speed in MPH: ");
		double speed = kb.nextDouble();
		System.out.println("Please enter the range in kMi: ");
		int range = kb.nextInt();
		System.out.println("Please enter the price in USD (millions): ");
		long price = kb.nextLong();
		
		FighterJet userCreated = new FighterJet(model, speed, range, price);
		airField.parkJet(userCreated);
	}

	private void createCargoPlane() {
		System.out.println("Please enter a model name: ");
		String model = kb.next();
		System.out.println("Please enter the speed in MPH: ");
		double speed = kb.nextDouble();
		System.out.println("Please enter the range in kMi: ");
		int range = kb.nextInt();
		System.out.println("Please enter the price in USD (millions): ");
		long price = kb.nextLong();
		
		CargoPlane userCreated = new CargoPlane(model, speed, range, price);
		airField.parkJet(userCreated);
	}

	private void createJetImpl() {
		System.out.println("Please enter a model name: ");
		String model = kb.next();
		System.out.println("Please enter the speed in MPH: ");
		double speed = kb.nextDouble();
		System.out.println("Please enter the range in kMi: ");
		int range = kb.nextInt();
		System.out.println("Please enter the price in USD (millions): ");
		long price = kb.nextLong();
		
		JetImpl userCreated = new JetImpl(model, speed, range, price);
		airField.parkJet(userCreated);
	}

	public void removeJet() {

	}

	private void quitProgram() {
		System.out.println("Exiting the Fleet, Goodbye!");
	}

}
