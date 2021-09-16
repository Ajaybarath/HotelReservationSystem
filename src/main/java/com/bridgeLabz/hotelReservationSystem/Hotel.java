package com.bridgeLabz.hotelReservationSystem;

public class Hotel {

	private String name;
	private int rate;

	public Hotel(String name, int rate) {
		super();
		this.name = name;
		this.rate = rate;
	}

	public String getName() {
		return name;
	}

	public int getRate() {
		return rate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRate(int  rate) {
		this.rate = rate;
	}

}
