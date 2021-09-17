package com.bridgeLabz.hotelReservationSystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HotelReservationSystem {

	public static void main(String args[]) {

		System.out.println("Welcome to hotel reservation system ");
	}

	private List<Hotel> hotelList;

	public HotelReservationSystem() {
		hotelList = new ArrayList<>();
	}

	public List<Hotel> addHotel(Hotel hotel) {

		if (hotelList.contains(hotel)) {
			System.out.println("Hotel already exists");
		} else {
			hotelList.add(hotel);
			System.out.println("Hotel " + hotel.getName() + " added successfully");
		}

		return hotelList;

	}

	public Hotel findCheapHotels(LocalDate start, LocalDate end) {

		Hotel cheapHotel = hotelList.stream()
				.min((hotel1, hotel2) -> hotel1.getWeekDaysRate() - hotel2.getWeekDaysRate()).orElse(null);

		return cheapHotel;
	}

	public Hotel findCheapHotelsWithWeekDaysAndWeekEndRates(LocalDate start, LocalDate end) {

		Hotel cheapHotel = hotelList.stream().min(
				(hotel1, hotel2) -> calculateHotelPrice(hotel1, start, end) - calculateHotelPrice(hotel2, start, end))
				.orElse(null);

		return cheapHotel;
	}

	public Hotel findCheapHotelsWithGoodRating(LocalDate start, LocalDate end) {

		try {
			List<Hotel> contacts = hotelList.stream()
					.sorted((hotel1, hotel2) -> hotel2.getRating() - (hotel1.getRating()))
					.sorted((hotel1, hotel2) -> calculateHotelPrice(hotel1, start, end)
							- calculateHotelPrice(hotel2, start, end))
					.collect(Collectors.toList());

			return contacts.get(0);
		} catch (Exception e) {
			return new Hotel();
		}

	}

	public Hotel findBestRatedHotel(LocalDate start, LocalDate end) {

		Hotel bestHotel = hotelList.stream().max((hotel1, hotel2) -> hotel1.getRating() - (hotel2.getRating()))
				.orElse(null);

		return bestHotel;
	}

	public Hotel findCheapHotelsWithGoodRatingForRewardCustomers(LocalDate start, LocalDate end) {

		try {
			List<Hotel> hotel = hotelList.stream().sorted((hotel1, hotel2) -> hotel2.getRating() - (hotel1.getRating()))
					.sorted((hotel1, hotel2) -> calculateHotelPriceForRewardCustomers(hotel1, start, end)
							- calculateHotelPriceForRewardCustomers(hotel2, start, end))
					.collect(Collectors.toList());

			return hotel.get(0);
		} catch (Exception e) {
			return new Hotel();
		}

	}

	public int calculateHotelPrice(Hotel hotel, LocalDate start, LocalDate end) {
		final int startW = start.getDayOfWeek().getValue();
		final int endW = end.getDayOfWeek().getValue();

		final long days = ChronoUnit.DAYS.between(start, end);

		Predicate<LocalDate> isWeekend = date -> date.getDayOfWeek() == DayOfWeek.SATURDAY
				|| date.getDayOfWeek() == DayOfWeek.SUNDAY;

		int daysWithoutWeekends = (int) start.datesUntil(end).filter(isWeekend.negate()).count();

		long daysWithWeekends = days - daysWithoutWeekends;

		long price = (daysWithoutWeekends * hotel.getWeekDaysRate()) + (daysWithWeekends * hotel.getWeekEndRate());

		return (int) price;

	}

	public int calculateHotelPriceForRewardCustomers(Hotel hotel, LocalDate start, LocalDate end) {
		final int startW = start.getDayOfWeek().getValue();
		final int endW = end.getDayOfWeek().getValue();

		final long days = ChronoUnit.DAYS.between(start, end);
		long daysWithoutWeekends = days - 2 * (days / 7); // remove weekends

		if (days % 7 != 0) { // deal with the rest days
			if (startW == 7) {
				daysWithoutWeekends -= 1;
			} else if (endW == 7) { // they can't both be Sunday, otherwise rest would be zero
				daysWithoutWeekends -= 1;
			} else if (endW < startW) { // another weekend is included
				daysWithoutWeekends -= 2;
			}
		}
		long daysWithWeekends = days - daysWithoutWeekends;

		long price = (daysWithoutWeekends * hotel.getRewardCustomerWeekDaysRate())
				+ (daysWithWeekends * hotel.getRewardCustomerWeekEndRate());

		return (int) price;

	}

}
