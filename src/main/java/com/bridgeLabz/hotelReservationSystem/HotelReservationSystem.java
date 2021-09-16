package com.bridgeLabz.hotelReservationSystem;

import java.util.ArrayList;
import java.util.List;

public class HotelReservationSystem {
	
	public static void main(String args[]) {

		System.out.println("Welcome to hotel reservation system ");
	}
	
	private List<Hotel> hotelList;
	
	public HotelReservationSystem() {
		hotelList = new ArrayList<>();
	}
	
	public void addHotel(Hotel hotel) {
		
		if (hotelList.contains(hotel)) {
			System.out.println("Hotel already exists");
		}
		else {
			hotelList.add(hotel);
			System.out.println("Hotel " + hotel.getName() + " added successfully");
		}
		
	}
	
	

}
