package channelthree.load;

import ionium.registry.ConstantsRegistry;


public class ConstTweaks {

	public static final void tweakConstants(){
		ConstantsRegistry.instance().putInt("TICKS", 60);
	}
	
}
