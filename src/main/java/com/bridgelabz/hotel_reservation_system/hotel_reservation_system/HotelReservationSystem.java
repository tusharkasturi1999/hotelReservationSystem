package com.bridgelabz.hotel_reservation_system.hotel_reservation_system;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.util.stream.*;

/**
 * @author tushar.kasturi_ymedi This is the HotelReservationSystem class
 * @param hotel This is a array list of hotel type
 */
public class HotelReservationSystem {

	public static ArrayList<Hotel> hotel = new ArrayList<Hotel>();

	// This method is used to add hotel
	public boolean addHotel(String hotelName, int regularCustomerWeekRate, int regularCustomerWeekendRate,
			int rewardCustomerWeekRate, int rewardCustomerWeekendRate, int rating) {
		hotel.add(new Hotel(hotelName, regularCustomerWeekRate, regularCustomerWeekendRate, rewardCustomerWeekRate,
				rewardCustomerWeekendRate, rating));
		return true;
	}

	// This method returns the no of hotels
	public static int hotelCount() {
		return hotel.size();
	}

	/**
	 * to check if a date is weekday or weekend
	 * 
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

	/*
	 * method to validate the customer type
	 */
	public boolean validateCustomerType(String custType) throws HotelReservationException {
		String pattern = "^[Rr](egular||eward)$";
		boolean result = Pattern.matches(pattern, custType);
		if (result == true) {
			return true;
		} else {
			throw new HotelReservationException(HotelReservationException.ExceptionType.WRONG_CUSTOMER,
					"Please enter a valid customer Type");
		}
	}

	/**
	 * findCheapestHotel method to find cheapest hotel
	 * 
	 * @param lowerRange of date
	 * @param upperRange of date
	 * @customerType is a regular or reward customer
	 * @return cheapest hotel name
	 * @throws HotelReservationException
	 */
	public String findCheapestHotel(String customerType, String lowerRange, String upperRange)
			throws HotelReservationException {

		HashMap<Hotel, Integer> hotelRateMap = new HashMap<>();
		int minTotalRate = Integer.MAX_VALUE;
		Hotel cheapHotel = null;
		int maxRating = 0;
		String cheapHotelName = null;
		DateTimeFormatter format = DateTimeFormatter.ofPattern("ddMMMyyyy");
		LocalDate lower = null;
		LocalDate upper = null;
		long numDays = 0;
		validateCustomerType(customerType);

		try {
			lower = LocalDate.parse(lowerRange, format);
			upper = LocalDate.parse(upperRange, format);
			numDays = Period.between(lower, upper).getDays() + 1;
			if (numDays <= 0) {
				throw new HotelReservationException(HotelReservationException.ExceptionType.WRONG_DATE,
						"Please enter proper date range");
			}
		} catch (Exception e) {
			throw new HotelReservationException(HotelReservationException.ExceptionType.WRONG_DATE,
					"Please enter proper date range");
		}

		List<LocalDate> listOfDates = Stream.iterate(lower, date -> date.plusDays(1)).limit(numDays)
				.collect(Collectors.toList());

		for (Hotel hotel : hotel) {
			int totalRate = 0;
			for (LocalDate date : listOfDates) {
				if (checkWeekend(date.getDayOfWeek())) {
					if (customerType.equals("Regular"))
						totalRate += hotel.getRegularCustomerWeekendRate();
					else
						totalRate += hotel.getRewardCustomerWeekendRate();
				} else {
					if (customerType.equals("Regular"))
						totalRate += hotel.getRegularCustomerWeekRate();
					else
						totalRate += hotel.getRewardCustomerWeekRate();
				}
			}
			hotelRateMap.put(hotel, totalRate);
		}

		for (Map.Entry map : hotelRateMap.entrySet()) {
			if (minTotalRate > (int) map.getValue()) {
				minTotalRate = (int) map.getValue();
				cheapHotel = (Hotel) map.getKey();
				maxRating = cheapHotel.getRating();
				cheapHotelName = cheapHotel.getHotelName();
			} else if (minTotalRate == (int) map.getValue()) {
				cheapHotel = (Hotel) map.getKey();
				if (maxRating < cheapHotel.getRating()) {
					maxRating = cheapHotel.getRating();
					minTotalRate = (int) map.getValue();
					cheapHotelName = cheapHotel.getHotelName();
				}
			}
		}
		System.out.println(customerType + " customer, " + cheapHotelName + ", Rating:" + maxRating
				+ " and Total Rates: $" + minTotalRate);
		return cheapHotelName;
	}
}
