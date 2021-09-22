package com.bridgelabz.hotel_reservation_system.hotel_reservation_system;

/**
 * @author tushar.kasturi_ymedi
 * @param hotelName          This stores the name of the hotel
 * @param regularWeekRate    This stores the weekday rates of regular customers
 * @param regularWeekendRate This stores rates of weekend rates of regular
 *                           customers
 */
public class Hotel {

	String hotelName;
	public int regularWeekRate;
	public int regularWeekendRate;
	public int rating;

	public Hotel(String hotelName, int rating, int regularWeekRate, int regularWeekendRate) {
		super();
		this.rating = rating;
		this.hotelName = hotelName;
		this.regularWeekRate = regularWeekRate;
		this.regularWeekendRate = regularWeekendRate;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRegularWeekRate() {
		return regularWeekRate;
	}

	public void setRegularWeekRate(int regularWeekRate) {
		this.regularWeekRate = regularWeekRate;
	}

	public int getRegularWeekendRate() {
		return regularWeekendRate;
	}

	public void setRegularWeekendRate(int regularWeekendRate) {
		this.regularWeekendRate = regularWeekendRate;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", regularWeekRate=" + regularWeekRate + ", regularWeekendRate="
				+ regularWeekendRate + ", rating=" + rating + "]";
	}

}
