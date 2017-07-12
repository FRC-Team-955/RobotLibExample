package core.subsystems;

import config.DriveConfig;
import config.DriveConfigDefault;
import util.MyJoy;

public class Drive extends drive.Drive{
	
	// Singleton
	private static Drive instance = new Drive();
	public static Drive getInstance() {
		return instance;
	}
	
	public Drive() {
		super(new DriveConfig(), MyJoy.getInstance());
		// TODO Auto-generated constructor stub
	}

}
