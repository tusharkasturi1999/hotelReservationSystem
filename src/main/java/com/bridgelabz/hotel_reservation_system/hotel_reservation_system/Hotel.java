package com.bridgelabz.hotel_reservation_system.hotel_reservation_system;
 
/**
 * @author tushar.kasturi_ymedi
 * @param hotelName          		 This stores the name of the hotel
 * @param regularCustomerWeekRate    This stores the weekday rates of regular customers
 * @param regularCustomerWeekendRate This stores rates of weekend rates of regular customers
 */
public class Hotel {

	private String hotelName;
	private int regularCustomerWeekRate;
	private int regularCustomerWeekendRate;
	private int rewardCustomerWeekRate;
	private int rewardCustomerWeekendRate;
	private int rating;

	public Hotel(String hotelName, int rating, int regularCustomerWeekRate, int regularCustomerWeekendRate) {
		this.rating = rating;
		this.hotelName = hotelName;
		this.regularCustomerWeekRate = regularCustomerWeekRate;
		this.regularCustomerWeekendRate = regularCustomerWeekendRate;
	}


	public Hotel(String hotelName, int regularCustomerWeekRate, int regularCustomerWeekendRate,
			int rewardCustomerWeekRate, int rewardCustomerWeekendRate, int rating) {
		super();
		this.hotelName = hotelName;
		this.regularCustomerWeekRate = regularCustomerWeekRate;
		this.regularCustomerWeekendRate = regularCustomerWeekendRate;
		this.rewardCustomerWeekRate = rewardCustomerWeekRate;
		this.rewardCustomerWeekendRate = rewardCustomerWeekendRate;
		this.rating = rating;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRegularCustomerWeekRate() {
		return regularCustomerWeekRate;
	}

	public void setRegularCustomerWeekRate(int regularCustomerWeekRate) {
		this.regularCustomerWeekRate = regularCustomerWeekRate;
	}

	public int getRegularCustomerWeekendRate() {
		return regularCustomerWeekendRate;
	}

	public void setRegularCustomerWeekendRate(int regularCustomerWeekendRate) {
		this.regularCustomerWeekendRate = regularCustomerWeekendRate;
	}

	public int getRating() {
		return rating;
	}

	public int getRewardCustomerWeekRate() {
		return rewardCustomerWeekRate;
	}

	public void setRewardCustomerWeekRate(int rewardCustomerWeekRate) {
		this.rewardCustomerWeekRate = rewardCustomerWeekRate;
	}

	public int getRewardCustomerWeekendRate() {
		return rewardCustomerWeekendRate;
	}

	public void setRewardCustomerWeekendRate(int rewardCustomerWeekendRate) {
		this.rewardCustomerWeekendRate = rewardCustomerWeekendRate;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", regularCustomerWeekRate=" + regularCustomerWeekRate
				+ ", regularCustomerWeekendRate=" + regularCustomerWeekendRate + ", rewardCustomerWeekRate="
				+ rewardCustomerWeekRate + ", rewardCustomerWeekendRate=" + rewardCustomerWeekendRate + ", rating="
				+ rating + "]";
	}

}
