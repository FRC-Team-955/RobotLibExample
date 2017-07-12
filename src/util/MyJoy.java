package util;

import config.JoyConfig;
import config.JoystickConfigDefaults;

public class MyJoy extends util.MyJoystick {

	// Singleton
	private static MyJoy instance = new MyJoy();
	public static MyJoy getInstance() {
		return instance;
	}
	
	public MyJoy() {
		super(new JoyConfig());
		// TODO Auto-generated constructor stub
	}

}
