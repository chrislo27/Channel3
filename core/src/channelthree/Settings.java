package channelthree;

import ionium.registry.GlobalVariables;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;


public class Settings {

	private static Settings instance;

	public float musicVolume = 1;
	public float soundVolume = 1;

	public int actualWidth = GlobalVariables.getInt("DEFAULT_WIDTH");
	public int actualHeight = GlobalVariables.getInt("DEFAULT_HEIGHT");
	public boolean fullscreen = false;

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
		actualWidth = pref.getInteger("actualWidth", GlobalVariables.getInt("DEFAULT_WIDTH"));
		actualHeight = pref.getInteger("actualHeight", GlobalVariables.getInt("DEFAULT_HEIGHT"));
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
