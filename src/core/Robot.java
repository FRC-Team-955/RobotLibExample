package core;

import auto.AutoChooser;
import auto.AutoModeExecutor;
import config.LoopConfig;
import core.subsystems.Drive;
import edu.wpi.first.wpilibj.IterativeRobot;
import util.loops.Looper;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	Drive drive = Drive.getInstance();
	Teleop teleop = new Teleop();
	
	Looper looper = new Looper(new LoopConfig());
	AutoModeExecutor autoModeExecutor;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		looper.register(drive.getLoop());
		looper.register(teleop.getLoop());
		AutoChooser.init();
	}

	@Override
	public void autonomousInit() {
		try {
			// Start loop for subsystems
			looper.start();
			// Create auto executor, pull mode from dashboard, and start executing slected mode
			autoModeExecutor = new AutoModeExecutor();
			autoModeExecutor.setMode(AutoChooser.getAutoMode());
			autoModeExecutor.start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void teleopInit() {
		try {
			// Start subsystem loop
			looper.start();
			// Set drive to open loop joystick mode
			drive.openLoopJoyMode();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void disabledInit() {
		looper.stop();
	}
	
}

