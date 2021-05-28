package com.skilldistillery.jets.entity;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void fight() {
		System.out.println(" is preparing for a Dogfight!");
	}
	
	@Override
	public String toString() {
		return "FighterJet [Model: " + getModel() + ", Speed: " + getSpeed() + ", Range: " + getRange() + ", Price: $"
				+ getPrice() + "million";
	}
}
