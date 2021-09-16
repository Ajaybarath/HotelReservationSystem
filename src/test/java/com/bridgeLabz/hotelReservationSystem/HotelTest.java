package com.bridgeLabz.hotelReservationSystem;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import org.junit.Assert;

public class HotelTest {

	@Test
	public void hotelNameAndRateTest() {

		Hotel hotel = new Hotel("Lakewood", 110, 90);

		HotelReservationSystem hotelReservationSystem = new HotelReservationSystem();
		hotelReservationSystem.addHotel(hotel);

//		Assert.assertEquals("Lakewood", hotelReservationSystem.hotel.getRate());

	}

	@Test
	public void getCheapHotelTest() throws ParseException {
		Hotel hotel1 = new Hotel("Lakewood", 110, 90);
		Hotel hotel2 = new Hotel("RidgeWood", 220, 50);
		Hotel hotel3 = new Hotel("BridgeWood", 160, 150);

		HotelReservationSystem hotelReservationSystem = new HotelReservationSystem();
		hotelReservationSystem.addHotel(hotel1);
		hotelReservationSystem.addHotel(hotel2);
		hotelReservationSystem.addHotel(hotel3);

		LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 16);
		LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 20);

		Hotel hotel = hotelReservationSystem.findCheapHotels(startDate, endDate);

		Assert.assertEquals(hotel.getName(), "Lakewood");

	}

	@Test
	public void addWeekEndAndWeekDayRateToHotel() {
		Hotel hotel1 = new Hotel("Lakewood", 110, 90);
		Hotel hotel2 = new Hotel("RidgeWood", 220, 50);
		Hotel hotel3 = new Hotel("BridgeWood", 160, 150);

		HotelReservationSystem hotelReservationSystem = new HotelReservationSystem();
		hotelReservationSystem.addHotel(hotel1);
		hotelReservationSystem.addHotel(hotel2);
		hotelReservationSystem.addHotel(hotel3);

		Assert.assertEquals(hotel1.getWeekDaysRate(), 110);
		Assert.assertEquals(hotel1.getWeekEndRate(), 90);
	}

	@Test
	public void findCheapestHotelsBasedOnWeekEndAndWeekDayRateTestCase() {
		Hotel hotel1 = new Hotel("Lakewood", 110, 90);
		Hotel hotel2 = new Hotel("RidgeWood", 220, 150);
		Hotel hotel3 = new Hotel("BridgeWood", 150, 50);

		HotelReservationSystem hotelReservationSystem = new HotelReservationSystem();
		hotelReservationSystem.addHotel(hotel1);
		hotelReservationSystem.addHotel(hotel2);
		hotelReservationSystem.addHotel(hotel3);
		LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 17);
		LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 19);

		Hotel cheapHotel = hotelReservationSystem.findCheapHotelsWithWeekDaysAndWeekEndRates(startDate, endDate);
		System.out.println(cheapHotel.getName() + ", and TotalRates : "
				+ hotelReservationSystem.calculateHotelPrice(cheapHotel, startDate, endDate));
		Assert.assertEquals(hotelReservationSystem.calculateHotelPrice(cheapHotel, startDate, endDate), 200);
	}

	@Test
	public void addHotelRating() {
		Hotel hotel1 = new Hotel("Lakewood", 110, 90, 3);
		Hotel hotel2 = new Hotel("RidgeWood", 220, 150, 5);
		Hotel hotel3 = new Hotel("BridgeWood", 150, 50, 4);

		HotelReservationSystem hotelReservationSystem = new HotelReservationSystem();
		hotelReservationSystem.addHotel(hotel1);
		hotelReservationSystem.addHotel(hotel2);
		hotelReservationSystem.addHotel(hotel3);

		Assert.assertEquals(5, hotel2.getRating());
	}

	@Test
	public void findCheapestHotelsWithGoodRatingTestCase() {
		Hotel hotel1 = new Hotel("Lakewood", 110, 90, 3);
		Hotel hotel2 = new Hotel("RidgeWood", 220, 150, 5);
		Hotel hotel3 = new Hotel("BridgeWood", 150, 50, 4);

		HotelReservationSystem hotelReservationSystem = new HotelReservationSystem();
		hotelReservationSystem.addHotel(hotel1);
		hotelReservationSystem.addHotel(hotel2);
		hotelReservationSystem.addHotel(hotel3);
		LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 17);
		LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 19);

		Hotel cheapHotel = hotelReservationSystem.findCheapHotelsWithGoodRating(startDate, endDate);
		System.out.println(cheapHotel.getName() + ", Rating : " + cheapHotel.getRating() + ", and TotalRates : "
				+ hotelReservationSystem.calculateHotelPrice(cheapHotel, startDate, endDate));

		Assert.assertEquals(hotelReservationSystem.calculateHotelPrice(cheapHotel, startDate, endDate), 200);
	}

	@Test
	public void findBestRatedHotelInTheDateRangeTestCase() {
		Hotel hotel1 = new Hotel("Lakewood", 110, 90, 3);
		Hotel hotel2 = new Hotel("RidgeWood", 220, 150, 5);
		Hotel hotel3 = new Hotel("BridgeWood", 150, 50, 4);

		HotelReservationSystem hotelReservationSystem = new HotelReservationSystem();
		hotelReservationSystem.addHotel(hotel1);
		hotelReservationSystem.addHotel(hotel2);
		hotelReservationSystem.addHotel(hotel3);
		LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 17);
		LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 19);

		Hotel bestHotel = hotelReservationSystem.findBestRatedHotel(startDate, endDate);
		System.out.println(bestHotel.getName() + ", and TotalRates : "
				+ hotelReservationSystem.calculateHotelPrice(bestHotel, startDate, endDate));

		Assert.assertEquals(hotelReservationSystem.calculateHotelPrice(bestHotel, startDate, endDate), 370);
	}

	@Test
	public void addPriceForRewardCustomers() {
		Hotel hotel1 = new Hotel("Lakewood", 110, 90, 3, 80, 80);
		Hotel hotel2 = new Hotel("RidgeWood", 220, 150, 5, 100, 40);
		Hotel hotel3 = new Hotel("BridgeWood", 150, 50, 4, 110, 50);

		HotelReservationSystem hotelReservationSystem = new HotelReservationSystem();
		hotelReservationSystem.addHotel(hotel1);
		hotelReservationSystem.addHotel(hotel2);
		hotelReservationSystem.addHotel(hotel3);

		Assert.assertEquals(100, hotel2.getRewardCustomerWeekDaysRate());
	}

	@Test
	public void findCheapestHotelsWithGoodRatingForRewardCustomerTestCase() {
		Hotel hotel1 = new Hotel("Lakewood", 110, 90, 3, 80, 80);
		Hotel hotel2 = new Hotel("RidgeWood", 220, 150, 5, 100, 40);
		Hotel hotel3 = new Hotel("BridgeWood", 150, 50, 4, 110, 50);

		HotelReservationSystem hotelReservationSystem = new HotelReservationSystem();
		hotelReservationSystem.addHotel(hotel1);
		hotelReservationSystem.addHotel(hotel2);
		hotelReservationSystem.addHotel(hotel3);

		Scanner s = new Scanner(System.in);
		System.out.print("Enter start date : dd/mm/yyyy : ");
		String stDate = s.next();
		System.out.print("Enter end date : dd/mm/yyyy : ");
		String enDate = s.next();

		System.out.print("Enter 1 for reward customer and 2 for normal customer:  ");

		int customerType = s.nextInt();

		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate startDate = LocalDate.parse(stDate, dateFormat);

		LocalDate endDate = LocalDate.parse(enDate, dateFormat);

		Hotel hotel = new Hotel();
		
		switch (customerType) {
		case 1:
			hotel = hotelReservationSystem.findCheapHotelsWithGoodRatingForRewardCustomers(startDate,
					endDate);
			System.out.println(hotel.getName() + ", Rating : " + hotel.getRating() + ", and TotalRates : "
					+ hotelReservationSystem.calculateHotelPriceForRewardCustomers(hotel, startDate, endDate));
			break;

		case 2:
			hotel = hotelReservationSystem.findCheapHotelsWithGoodRating(startDate, endDate);
			System.out.println(hotel.getName() + ", Rating : " + hotel.getRating() + ", and TotalRates : "
					+ hotelReservationSystem.calculateHotelPrice(hotel, startDate, endDate));
			break;
			
		default:
			 System.out.println("Enter a valid number");
			 break;
		}

		Assert.assertEquals(
				hotelReservationSystem.calculateHotelPriceForRewardCustomers(hotel, startDate, endDate), 140);
	}

}
