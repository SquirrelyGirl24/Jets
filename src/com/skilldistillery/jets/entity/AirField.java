package com.skilldistillery.jets.entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirField {

	List<Jet> jets1 = readJetsFromFile("jets.txt");
	private List<Jet> jets;
	private Scanner kb = new Scanner(System.in);

	public void listFleet() {
		System.out.println("The Fleet: ");
		for (int i = 0; i < jets1.size(); i++) {
			System.out.println(this.jets1.get(i));
			System.out.println();
		}
	}

	private List<Jet> readJetsFromFile(String file) {
		List<Jet> jets = new ArrayList<Jet>();
		try {
			BufferedReader bufIn = new BufferedReader(new FileReader(file));
			Jet jet;
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] jetFields = line.split(",");
				String model = jetFields[0];
				double speed = Double.parseDouble(jetFields[1]);
				int range = Integer.parseInt(jetFields[2]);
				long price = Long.parseLong(jetFields[3]);
				String type = jetFields[4];
				// which type of jet/constructor to call
				if (type.equals("F")) {
					jet = new FighterJet(model, speed, range, price);
				} else if (type.equals("C")) {
					jet = new CargoPlane(model, speed, range, price);
				} else {
					jet = new JetImpl(model, speed, range, price);
				}
					jets.add(jet);
			}
			bufIn.close();
		} catch (IOException e) {
			System.err.println(e);
		}
		return jets;
	}

	public AirField() {
		super();
	}

	public void flyAllJets() {
		System.out.println("Fleet preparing for take-off: ");
		for (Jet jet : jets1) {
			jet.fly();
			System.out.println();
		}
	}

	public void fastestJet() {
		Jet prior = this.jets1.get(0);
		Jet fastest = this.jets1.get(0);
		for (int i = 0; i < jets1.size(); i++) {
			Jet jet = this.jets1.get(i);
			if (jet != null) {
				if (prior.getSpeed() > this.jets1.get(i).getSpeed()) {
					prior = this.jets1.get(i);
				}
				if (fastest.getSpeed() < this.jets1.get(i).getSpeed()) {
					fastest = this.jets1.get(i);
				}
			}
		}
		System.out.println("The fastest jet is: " + fastest);
	}

	public void longestRange() {
		Jet prior = this.jets1.get(0);
		Jet longestRange = this.jets1.get(0);
		for (int i = 0; i < jets1.size(); i++) {
			Jet jet = this.jets1.get(i);
			if (jet != null) {
				if (prior.getRange() > this.jets1.get(i).getRange()) {
					prior = this.jets1.get(i);
				}
				if (longestRange.getRange() < this.jets1.get(i).getRange()) {
					longestRange = this.jets1.get(i);
				}
			}
		}
		System.out.println("The jet with the longest range is " + longestRange);
	}

	public void loadCargo() {
		System.out.println("Loading all cargo planes: ");
		for (Jet jet : jets1) {
			if (jet instanceof CargoCarrier) {
				System.out.println(jet.getModel());
				((CargoCarrier) jet).loadCargo();
			}
		}
	}

	public void startFight() {
		System.out.println("Start Dogfight: ");
		for (Jet jet : jets1) {
			if (jet instanceof CombatReady) {
				System.out.println(jet.getModel());
				((CombatReady) jet).fight();
			}
		}
	}

	public void parkJet(Jet jet) {
		this.jets1.add(jet);
	}

	public List<Jet> getJets() {
		return jets;
	}

	public void setJets(List<Jet> jets) {
		this.jets = jets;
	}
}
