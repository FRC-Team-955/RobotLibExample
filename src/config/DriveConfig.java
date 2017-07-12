package config;

public class DriveConfig extends DriveConfigDefault {

	// Any new variables to be stored in config can be put here
	// Using static means you can access them from anywhere through DriveConfig.testParam
	// and you don't need an instance of the object
	public static final int testParam = 4;
	
	@Override
	public void setConfig() {
		
		// Overwriting the default value of 19 for this variable
		// All other variables will use the default value from DriveConfigDefault
		codesPerRev = 12;
	}

}
