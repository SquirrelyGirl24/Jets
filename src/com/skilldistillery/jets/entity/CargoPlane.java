package com.skilldistillery.jets.entity;

public class CargoPlane extends Jet implements CargoCarrier {

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void loadCargo() {
		System.out.println(" is loaading cargo for transport.");
	}

	@Override
	public String toString() {
		return "CargoPlane [Model: " + getModel() + ", Speed: " + getSpeed() + ", Range: " + getRange() + ", Price: $"
				+ getPrice() + "million";
	}

}
