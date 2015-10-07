package channelthree.savefile;

import channelthree.Settings;

import com.badlogic.gdx.Preferences;

public class SaveFile {

	private static SaveFile instance;

	private SaveFile() {
	}

	public static SaveFile instance() {
		if (instance == null) {
			instance = new SaveFile();
			instance.loadResources();
		}
		return instance;
	}

	private void loadResources() {

	}

	private int currentlyLoaded = -1;
	private Preferences pref = null;

	public SaveFile load(int index) {
		pref = Settings.getPref("savefile-" + index);

		currentlyLoaded = index;
		return this;
	}

	public SaveFile wipe() {
		if (!hasLoaded()) throw new IllegalStateException(
				"Cannot clear savefile when nothing is loaded yet! (index: " + currentlyLoaded
						+ ", pref null?: " + (pref == null) + ")");
		
		return this;
	}

	public SaveFile save() {
		if (!hasLoaded()) throw new IllegalStateException(
				"Cannot save savefile when nothing is loaded yet! (index: " + currentlyLoaded
						+ ", pref null?: " + (pref == null) + ")");

		pref.flush();

		return this;
	}

	public SaveFile unload() {
		if (!hasLoaded()) throw new IllegalStateException(
				"Cannot unload savefile when nothing is loaded yet! (index: " + currentlyLoaded
						+ ", pref null?: " + (pref == null) + ")");

		pref = null;
		currentlyLoaded = -1;

		return this;
	}

	public int getCurrentlyLoadedIndex() {
		return currentlyLoaded;
	}

	public boolean hasLoaded() {
		return currentlyLoaded != -1 && pref != null;
	}

}
