package com.bridgelabz.hotel_reservation_system.hotel_reservation_system;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
 
/**
 * This is the HotelReservationSystem class
 * 
 * @param hotel This is a array list of hotel type
 */
public class HotelReservationSystem {

	public static ArrayList<Hotel> hotel = new ArrayList<Hotel>();

	// This method is used to add hotel
	public static boolean addHotel(String hotelName, int rating, int regularCustomerWeekRate,
			int regularCustomerWeekendRate) {
		hotel.add(new Hotel(hotelName, rating, regularCustomerWeekRate, regularCustomerWeekendRate));
		return true;
	}
	
	//This method returns the no of hotels
	public static int hotelCount() {
		return hotel.size();
	}
	
	//This method returns the cheapest hotel
	public static String findCheapestHotel(String lowerRange, String upperRange) {

		HashMap<String, Integer> hotelRateMap = new HashMap<>();
		int min = Integer.MAX_VALUE;
		String cheapHotel = null;

		DateTimeFormatter format = DateTimeFormatter.ofPattern("ddMMMyyyy");
		LocalDate lower = LocalDate.parse(lowerRange, format);
		LocalDate upper = LocalDate.parse(upperRange, format);
		int numDays = Period.between(lower, upper).getDays();

		for (Hotel hotel : hotel) {
			int totalRate = 0;
			for (int i = 0; i < numDays; i++) {
				totalRate += hotel.getRegularCustomerWeekRate();
			}
			hotelRateMap.put(hotel.getHotelName(), totalRate);
		}
		for (Map.Entry map : hotelRateMap.entrySet()) {
			if (min > (int) map.getValue()) {
				min = (int) map.getValue();
				cheapHotel = (String) map.getKey();
			}
		}
		return cheapHotel;
	}
}
