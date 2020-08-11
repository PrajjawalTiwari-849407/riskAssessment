package com.mfrp.risk.exception;

public class RiskNotFoundException extends Exception {
	private int id;

	public RiskNotFoundException(String user_id) {
		
		super(String.format("User is not found with id : '%s'", user_id));
	}
}