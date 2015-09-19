package channelthree.load;

import ionium.registry.ConstantsRegistry;
import ionium.util.DebugSetting;


public class ConstTweaks {

	public static final void tweakConstants(){
		ConstantsRegistry.instance().putInt("TICKS", 60);
		
		DebugSetting.showFPS = false;
	}
	
}
