package channelthree.transition;

import ionium.templates.Main;
import ionium.transition.Fade;
import channelthree.util.RainEffect;


public class FadeWithRain extends Fade {

	int drops = RainEffect.DEF_DROPS;
	int splats = RainEffect.DEF_SPLATS;
	float partToSplat = RainEffect.DEF_PART_TO_SPLAT;
	
	public FadeWithRain(boolean fadeOut, int color, float time, int drops, int splats, float partToSplat){
		super(fadeOut, color, time);
		
		this.drops = drops;
		this.splats = splats;
		this.partToSplat = partToSplat;
	}
	
	public FadeWithRain(boolean fadeOut, int color, float time){
		super(fadeOut, color, time);
		
		this.drops = RainEffect.DEF_DROPS;
		this.splats = RainEffect.DEF_SPLATS;
		this.partToSplat = RainEffect.DEF_PART_TO_SPLAT;
	}
	
	@Override
	public void render(Main main){
		super.render(main);
		
		RainEffect.rainEffect(main.batch, drops, splats, partToSplat);
	}
}
