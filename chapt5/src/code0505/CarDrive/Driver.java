/**
 * 
 */
package code0505.CarDrive;

/**
 * Driver.java Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class Driver implements IDriver {

	/*
	 * (non-Javadoc)
	 * 
	 * @see code0505.CarDrive.IDriver#drive(code0505.CarDrive.ICar)
	 */
	@Override

	public void drive(ICar car) {

		car.run();

	}

}
