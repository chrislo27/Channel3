package channelthree.savefile;

import channelthree.Settings;

import com.badlogic.gdx.Preferences;


public class SaveFile {

	private int currentlyLoaded = -1;
	
	public SaveFile(){
		
	}
	
	public SaveFile load(int index){
		Preferences pref = Settings.getPref("savefile-" + index);
		
		return this;
	}
	
	public int getCurrentlyLoadedIndex(){
		return currentlyLoaded;
	}
	
	public boolean hasLoaded(){
		return currentlyLoaded != -1;
	}
	
}
