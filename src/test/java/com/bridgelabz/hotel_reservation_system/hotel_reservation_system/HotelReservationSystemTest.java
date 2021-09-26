package com.bridgelabz.hotel_reservation_system.hotel_reservation_system;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HotelReservationSystemTest {
	HotelReservationSystem hotelSystem = new HotelReservationSystem();

	@Before
	public void CheckIfHotelIsAddedToSystem() {
		hotelSystem.addHotel("Lakewood", 110, 90, 80, 80, 3);
		hotelSystem.addHotel("Bridgewood", 150, 50, 110, 150, 4);
		hotelSystem.addHotel("Ridgewood", 220, 150, 100, 40, 5);
		int hotelCount = HotelReservationSystem.hotelCount();
		Assert.assertEquals(3, hotelCount);
	}

	@Test
	public void checkCheapestHotelWhenGivenDateRangeForRegularCustomer() 
	{
		String cheapHotel;
		try {
			cheapHotel = hotelSystem.findCheapestHotel("Regular","11Sep2020","12Sep2020");
			Assert.assertEquals("Bridgewood",cheapHotel);
		} catch (HotelReservationException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void checkCheapestHotelWhenGivenDateRangeForRewardCustomer() 
	{
		String cheapHotel;
		try {
			cheapHotel = hotelSystem.findCheapestHotel("Reward","11Sep2020","12Sep2020");
			Assert.assertEquals("Ridgewood",cheapHotel);
		} catch (HotelReservationException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void checkGivenWrongDateRangeShouldHandleException() 
	{
		String cheapHotel;
		try {
			cheapHotel = hotelSystem.findCheapestHotel("Reward","11Sep2020","8Sep2020");
			Assert.assertEquals("Ridgewood",cheapHotel);
		} catch (HotelReservationException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void checkGivenWrongCustomerTypeShouldHandleException() 
	{
		String cheapHotel;
		try {
			cheapHotel = hotelSystem.findCheapestHotel("general","11Sep2020","8Sep2020");
			Assert.assertEquals("Ridgewood",cheapHotel);
		} catch (HotelReservationException e) {
			System.out.println(e.getMessage());
		}
	}
}