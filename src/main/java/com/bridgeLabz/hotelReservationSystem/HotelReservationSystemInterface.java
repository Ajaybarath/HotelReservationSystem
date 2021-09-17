package com.bridgeLabz.hotelReservationSystem;

import java.time.LocalDate;
import java.util.List;

public interface HotelReservationSystemInterface {

	public List<Hotel> addHotel(Hotel hotel);
	
	public Hotel findCheapHotels(LocalDate start, LocalDate end);
	
	public Hotel findCheapHotelsWithWeekDaysAndWeekEndRates(LocalDate start, LocalDate end);
	
	public Hotel findCheapHotelsWithGoodRating(LocalDate start, LocalDate end) throws HotelReservationSystemException;
	
	public Hotel findBestRatedHotel(LocalDate start, LocalDate end);
	
	public Hotel findCheapHotelsWithGoodRatingForRewardCustomers(LocalDate start, LocalDate end) throws HotelReservationSystemException;
	
	public int calculateHotelPrice(Hotel hotel, LocalDate start, LocalDate end);
	
	public int calculateHotelPriceForRewardCustomers(Hotel hotel, LocalDate start, LocalDate end);

}
