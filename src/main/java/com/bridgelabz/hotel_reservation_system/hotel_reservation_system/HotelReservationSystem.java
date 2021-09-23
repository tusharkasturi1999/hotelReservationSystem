package com.bridgelabz.hotel_reservation_system.hotel_reservation_system;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.*;
 
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
	
	/**
	 * to check if a date is weekday or weekend
	 * @param day
	 * @return true for weekends
	 */
	public static boolean checkWeekend(DayOfWeek day) {
		switch (day) {
		case SATURDAY:
			return true;
		case SUNDAY:
			return true;
		default:
			return false;
		}
	}
	//This method returns the cheapest hotel
	public static String findCheapestHotel(String lowerRange,String upperRange) {

		HashMap<String,Integer> hotelRateMap = new HashMap<>();
		int minTotalRate = Integer.MAX_VALUE;
		String cheapHotel = null;

		DateTimeFormatter format = DateTimeFormatter.ofPattern("ddMMMyyyy");
		LocalDate lower = LocalDate.parse(lowerRange, format);
		LocalDate upper = LocalDate.parse(upperRange, format);
		long numDays = Period.between(lower, upper).getDays()+1;

		List<LocalDate> listOfDates = Stream.iterate(lower, date -> date.plusDays(1))
				.limit(numDays)
				.collect(Collectors.toList());

		for(Hotel hotel: hotel) {
			int totalRate = 0;
			for(LocalDate date : listOfDates)
			{
				if(checkWeekend(date.getDayOfWeek())) 
				{
					totalRate += hotel.getRegularCustomerWeekendRate();
				}
				else
					totalRate += hotel.getRegularCustomerWeekRate();
			}
			hotelRateMap.put(hotel.getHotelName(),totalRate);
		}

		for (Map.Entry map : hotelRateMap.entrySet()) {      
			if(minTotalRate > (int)map.getValue()) 
			{
				minTotalRate = (int)map.getValue();
				cheapHotel = (String)map.getKey();
			}
			else if(minTotalRate == (int)map.getValue()){
				cheapHotel = cheapHotel + ","+ map.getKey();
			}
		}
		System.out.println("Cheapest hotel for the given dates is "+cheapHotel+" for $"+minTotalRate);
		return cheapHotel;
	}
}
