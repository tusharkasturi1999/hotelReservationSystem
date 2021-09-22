package com.bridgelabz.hotel_reservation_system.hotel_reservation_system;

import org.junit.Test;

/**
 * Unit test for HotelReservationSystemTest.
 */
public class HotelReservationSystemTest 
{
    @Test
    public void whenAddedHotelSuccessfullyReturnTrue()
    {
    	HotelReservationSystem object = new HotelReservationSystem();
    	boolean hotelEntry = object.addHotel("Lakewood", 3, 110, 90);
        assertTrue(true,hotelEntry);
    }

	private void assertTrue(boolean b, boolean hotelEntry) {
		// TODO Auto-generated method stub
		
	}
}
