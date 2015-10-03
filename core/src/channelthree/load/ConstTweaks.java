package channelthree.load;

import ionium.registry.GlobalVariables;
import ionium.util.DebugSetting;


public class ConstTweaks {

	public static final void tweakConstants(){
		GlobalVariables.instance().putInt("TICKS", 60);
		
		DebugSetting.showFPS = false;
	}
	
}
