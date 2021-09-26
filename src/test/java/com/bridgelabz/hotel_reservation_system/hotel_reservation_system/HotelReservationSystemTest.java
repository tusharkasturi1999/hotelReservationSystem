package com.bridgelabz.hotel_reservation_system.hotel_reservation_system;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HotelReservationSystemTest {
	HotelReservationSystem hotelSystem = new HotelReservationSystem();	

	@Before
	public void CheckIfHotelIsAddedToSystem()
	{		
		hotelSystem.addHotel("LakeWood",3,110,90);
		hotelSystem.addHotel("Bridgewood",4,150,50);
		hotelSystem.addHotel("Ridgewood",5,220,150);
		int hotelCount = HotelReservationSystem.hotelCount();
		Assert.assertEquals(3,hotelCount);
	}
	
	@Test
	public void checkCheapestHotelWhenGivenDateRange() 
	{
		String cheapHotel = hotelSystem.findCheapestHotel("11Sep2020","12Sep2020");
		Assert.assertEquals("Bridgewood",cheapHotel);
	}
	
}