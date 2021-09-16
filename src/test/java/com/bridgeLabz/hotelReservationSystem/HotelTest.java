package com.bridgeLabz.hotelReservationSystem;

import org.junit.Test;

import org.junit.Assert;

public class HotelTest {

	@Test
	public void hotelNameAndRateTest() {

		Hotel hotel = new Hotel("LakeWood", 110);

		Assert.assertEquals("LakeWood", hotel.getName());
		Assert.assertEquals(110, hotel.getRate());
	}
}