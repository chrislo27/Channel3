package channelthree.savefile;

import channelthree.Settings;

import com.badlogic.gdx.Preferences;


public class SaveFile {

	public SaveFile(){
		
	}
	
	public SaveFile load(int index){
		Preferences pref = Settings.getPref("savefile-" + index);
		
		return this;
	}
	
}
