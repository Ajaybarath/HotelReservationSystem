package com.bridgeLabz.hotelReservationSystem;

public class Hotel {

	private String name;
	private int weekDaysRate;
	private int weekEndRate;

	public Hotel(String name, int weekDaysRate, int weekEndRate) {
		super();
		this.name = name;
		this.weekDaysRate = weekDaysRate;
		this.weekEndRate = weekEndRate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeekDaysRate() {
		return weekDaysRate;
	}

	public int getWeekEndRate() {
		return weekEndRate;
	}

	public void setWeekDaysRate(int weekDaysRate) {
		this.weekDaysRate = weekDaysRate;
	}

	public void setWeekEndRate(int weekEndRate) {
		this.weekEndRate = weekEndRate;
	}

}
