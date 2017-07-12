package core;
import util.loops.Loop;
import util.MyJoy;
import util.MyJoystick;
import config.JoyConfig;
import core.subsystems.Drive;

/**
 * @author Trevor
 * intergrate joystick input;
 */
public class Teleop {
	MyJoy joy = MyJoy.getInstance();
	Drive drive = Drive.getInstance();

	public Teleop(){

	}
	private final Loop loop = new Loop() {

		@Override
		public void onStart() {

		}

		@Override
		public void onLoop() {
			joy.update();
		}

		@Override
		public void onStop() {

		}
	};

	public Loop getLoop() {
		return loop;
	}
}
