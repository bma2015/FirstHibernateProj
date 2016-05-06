package com.armedia.mvc.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("Car")
public class FourWheeler extends Vehicle {
	private String steeringWheel;

	/**
	 * @return the steeringWheel
	 */
	public String getSteeringWheel() {
		return steeringWheel;
	}

	/**
	 * @param steeringWheel the steeringWheel to set
	 */
	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}
}
