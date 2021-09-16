package com.bridgeLabz.hotelReservationSystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
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
		} else {
			hotelList.add(hotel);
			System.out.println("Hotel " + hotel.getName() + " added successfully");
		}

	}

	public Hotel findCheapHotels(LocalDate start, LocalDate end) {

		Hotel cheapHotel = hotelList.stream().min((n1, n2) -> n1.getWeekDaysRate() - n2.getWeekDaysRate()).orElse(null);

		long noOfDaysBetween = ChronoUnit.DAYS.between(start, end);

		return cheapHotel;
	}

	public Hotel findCheapHotelsWithWeekDaysAndWeekEndRates(LocalDate start, LocalDate end) {

		Hotel cheapHotel = hotelList.stream().min((n1, n2) -> calculateHotelPrice(n1, start, end)
				- calculateHotelPrice(n2, start, end)).orElse(null);

		return cheapHotel;
	}

	
	public int calculateHotelPrice(Hotel hotel, LocalDate start, LocalDate end) {
		final int startW = start.getDayOfWeek().getValue();
	    final int endW = end.getDayOfWeek().getValue();

	    final long days = ChronoUnit.DAYS.between(start, end);
	    long daysWithoutWeekends = days - 2*(days/7); //remove weekends

	    if (days % 7 != 0) { //deal with the rest days
	        if (startW == 7) {
	            daysWithoutWeekends -= 1;
	        } else if (endW == 7) {  //they can't both be Sunday, otherwise rest would be zero
	            daysWithoutWeekends -= 1;
	        } else if (endW < startW) { //another weekend is included
	            daysWithoutWeekends -= 2;
	        }
	    }
	    long daysWithWeekends = days - daysWithoutWeekends;

		long price = (daysWithoutWeekends * hotel.getWeekDaysRate()) + (daysWithWeekends * hotel.getWeekEndRate());

		System.out.println(price + " " + hotel.getName() + " " + daysWithoutWeekends + " " + daysWithWeekends);
		return (int) price;
	    
	    
	}

}
