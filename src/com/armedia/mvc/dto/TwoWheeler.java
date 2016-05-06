package com.armedia.mvc.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("Bike")
public class TwoWheeler extends Vehicle {
	private String steeringHandle;

	/**
	 * @return the steeringHandle
	 */
	public String getSteeringHandle() {
		return steeringHandle;
	}

	/**
	 * @param steeringHandle the steeringHandle to set
	 */
	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}
}
