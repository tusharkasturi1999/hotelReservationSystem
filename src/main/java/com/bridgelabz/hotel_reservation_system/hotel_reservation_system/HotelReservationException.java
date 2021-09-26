package com.bridgelabz.hotel_reservation_system.hotel_reservation_system;

/**
 * HotelReservationException exception handing class
 * 
 * @author tushar.kasturi_ymedi
 *
 */
public class HotelReservationException extends Exception {
	public enum ExceptionType {
		WRONG_DATE, WRONG_CUSTOMER
	}

	public ExceptionType type;

	public HotelReservationException(ExceptionType type, String message) {
		super(message);
		this.type = type;
	}

}