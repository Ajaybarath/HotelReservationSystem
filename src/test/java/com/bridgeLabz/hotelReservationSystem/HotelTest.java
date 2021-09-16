package com.bridgeLabz.hotelReservationSystem;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;

public class HotelTest {

	@Test
	public void hotelNameAndRateTest() {

		Hotel hotel = new Hotel("Lakewood", 110);

		Assert.assertEquals("Lakewood", hotel.getName());
		Assert.assertEquals(110, hotel.getRate());
	}
	
	
	public void getCheapHotelTest() throws ParseException {
		Hotel hotel1 = new Hotel("Lakewood", 110);
		Hotel hotel2 = new Hotel("RidgeWood", 220);
		Hotel hotel3 = new Hotel("BridgeWood", 160);
		
		HotelReservationSystem hotelReservationSystem = new HotelReservationSystem();
		hotelReservationSystem.addHotel(hotel1);
		hotelReservationSystem.addHotel(hotel2);
		hotelReservationSystem.addHotel(hotel3);
		
		String sDate="16/09/2021";  
	    Date startDate=new SimpleDateFormat("dd/MM/yyyy").parse(sDate);  
	    
	    String eDate="20/09/2021";  
	    Date endDate=new SimpleDateFormat("dd/MM/yyyy").parse(eDate);  

		Hotel hotel = hotelReservationSystem.findCheapHotels(startDate, endDate);
		
		Assert.assertEquals(hotel.getName(), "Lakewood");
		
	}
}
