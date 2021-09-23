package com.bridgelabz.hotel_reservation_system.hotel_reservation_system;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for HotelReservationSystemTest.
 */
public class HotelReservationSystemTest {

	@Before
	public void CheckIfHotelIsAddedToSystem() {
		HotelReservationSystem.addHotel("LakeWood", 3, 110, 90);
		HotelReservationSystem.addHotel("Bridgewood", 4, 150, 50);
		HotelReservationSystem.addHotel("Ridgewood", 5, 220, 150);
		int hotelCount = HotelReservationSystem.hotelCount();
		assertEquals(3, hotelCount);
	}

	@Test
	public void checkCheapestHotelWhenGivenDateRange() {
		String cheapHotel = HotelReservationSystem.findCheapestHotel("12Sep2020", "15Sep2020");
		assertEquals("LakeWood", cheapHotel);
	}

}
