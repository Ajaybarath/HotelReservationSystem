package com.bridgeLabz.hotelReservationSystem;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

import org.junit.Assert;

public class HotelTest {

	@Test
	public void hotelNameAndRateTest() {

		Hotel hotel = new Hotel("Lakewood", 110);
		
		HotelReservationSystem hotelReservationSystem = new HotelReservationSystem();
		hotelReservationSystem.addHotel(hotel);
		
//		Assert.assertEquals("Lakewood", hotelReservationSystem.hotel.getRate());
	
	}
	
	
	public void getCheapHotelTest() throws ParseException {
		Hotel hotel1 = new Hotel("Lakewood", 110);
		Hotel hotel2 = new Hotel("RidgeWood", 220);
		Hotel hotel3 = new Hotel("BridgeWood", 160);
		
		HotelReservationSystem hotelReservationSystem = new HotelReservationSystem();
		hotelReservationSystem.addHotel(hotel1);
		hotelReservationSystem.addHotel(hotel2);
		hotelReservationSystem.addHotel(hotel3);
		

		LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 16);
		LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 20);

		Hotel hotel = hotelReservationSystem.findCheapHotels(startDate, endDate);
		
		Assert.assertEquals(hotel.getName(), "Lakewood");
		
	}
}
