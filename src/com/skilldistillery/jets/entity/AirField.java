package com.skilldistillery.jets.entity;

import java.util.List;
import java.util.Scanner;

public class AirField {
	private List<Jet> jets;
	Scanner kb = new Scanner(System.in);

	public void listFleet() {
		System.out.println("The Fleet: ");
		for (int i = 0; i < jets.size(); i++) {
			System.out.println(this.jets.get(i));
			System.out.println();
		}
	}

	public void flyAllJets() {
		System.out.println("Fleet preparing for takeoff: ");
		for (Jet jet : jets) {
			jet.fly();
			System.out.println();
		}
	}

	public void fastestJet() {
		Jet prior = this.jets.get(0);
		Jet fastest = this.jets.get(0);
		for (int i = 0; i < jets.size(); i++) {
			Jet jet = this.jets.get(i);
			if (jet != null) {
				if (prior.getSpeed() > this.jets.get(i).getSpeed()) {
					prior = this.jets.get(i);
				}
				if (fastest.getSpeed() < this.jets.get(i).getSpeed()) {
					fastest = this.jets.get(i);
				}
			}
		}
		System.out.println("The fastest jet is: " + fastest);
	}

	public void longestRange() {
		Jet prior = this.jets.get(0);
		Jet longestRange = this.jets.get(0);
		for (int i = 0; i < jets.size(); i++) {
			Jet jet = this.jets.get(i);
			if (jet != null) {
				if (prior.getRange() > this.jets.get(i).getRange()) {
					prior = this.jets.get(i);
				}
				if (longestRange.getRange() < this.jets.get(i).getRange()) {
					longestRange = this.jets.get(i);
				}
			}
		}
		System.out.println("The jet with the longest range is " + longestRange);
	}

	public void loadCargo() {
		System.out.println("Loading all cargo planes: ");
		for (Jet jet : jets) {
			if (jet instanceof CargoCarrier) {
				System.out.println(jet.getModel());
				((CargoCarrier) jet).loadCargo();
			}
		}
	}

	public void startFight() {
		System.out.println("Start Dogfight: ");
		for (Jet jet : jets) {
			if (jet instanceof CombatReady) {
				System.out.println(jet.getModel());
				((CombatReady) jet).fight();
			}
		}
	}

	public void parkJet(Jet jet) {
		this.jets.add(jet);
	}
}
