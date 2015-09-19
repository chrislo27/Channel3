package channelthree;

import ionium.registry.ConstantsRegistry;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;


public class Settings {

	private static Settings instance;

	public static float musicVolume = 1;
	public static float soundVolume = 1;

	public static int actualWidth = ConstantsRegistry.getInt("DEFAULT_WIDTH");
	public static int actualHeight = ConstantsRegistry.getInt("DEFAULT_HEIGHT");
	public static boolean fullscreen = false;

	static {
		Settings.instance(); // init settings
	}

	private Settings() {
	}

	public static Settings instance() {
		if (instance == null) {
			instance = new Settings();
			instance.loadResources();
		}
		return instance;
	}

	private Preferences pref;

	private void loadResources() {
		pref = getPref("settings");

		soundVolume = pref.getFloat("soundVolume", 1f);
		musicVolume = pref.getFloat("musicVolume", 1f);
		actualWidth = pref.getInteger("actualWidth", ConstantsRegistry.getInt("DEFAULT_WIDTH"));
		actualHeight = pref.getInteger("actualHeight", ConstantsRegistry.getInt("DEFAULT_HEIGHT"));
		fullscreen = pref.getBoolean("fullscreen", true);
	}

	public static Preferences getPref(String ref) {
		return Gdx.app.getPreferences("channel3-" + ref);
	}

	public void save() {
		pref.putFloat("sound", soundVolume).putFloat("music", musicVolume)
				.putInteger("actualWidth", actualWidth).putInteger("actualHeight", actualHeight)
				.flush();
	}

	public static Preferences getPreferences() {
		return instance().pref;
	}
	
}
