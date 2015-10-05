package channelthree.transition;

import ionium.templates.Main;
import ionium.transition.Fade;
import channelthree.util.RainEffect;

public class FadeWithRain extends Fade {

	int startDrops = RainEffect.DEF_DROPS;
	int startSplats = RainEffect.DEF_SPLATS;
	float startPartToSplat = RainEffect.DEF_PART_TO_SPLAT;

	int endDrops = startDrops;
	int endSplats = startSplats;
	float endPartToSplat = startPartToSplat;

	public FadeWithRain(boolean fadeOut, int color, float time, int startDrops, int startSplats,
			float startPartToSplat, int endDrops, int endSplats, float endPartToSplat) {
		super(fadeOut, color, time);

		this.startDrops = startDrops;
		this.startSplats = startSplats;
		this.startPartToSplat = startPartToSplat;

		this.endDrops = endDrops;
		this.endSplats = endSplats;
		this.endPartToSplat = endPartToSplat;
	}

	public FadeWithRain(boolean fadeOut, int color, float time, int drops, int splats,
			float partToSplat) {
		this(fadeOut, color, time, drops, splats, partToSplat, drops, splats, partToSplat);
	}

	public FadeWithRain(boolean fadeOut, int color, float time) {
		this(fadeOut, color, time, RainEffect.DEF_DROPS, RainEffect.DEF_SPLATS,
				RainEffect.DEF_PART_TO_SPLAT);
	}

	@Override
	public void render(Main main) {
		super.render(main);

		float elapsedTime = startingTime - timeLeft;
		float timePercentage = 1f - (elapsedTime / startingTime);
		
		// (((startTime - timeRemaining) / startTime) * (endScale - startScale)) + startScale
		
		int currentDrops = (int) (((startingTime - timeLeft) / startingTime) * (endDrops - startDrops) + startDrops);
		int currentSplats = (int) (((startingTime - timeLeft) / startingTime) * (endSplats - startSplats) + startSplats);
		float currentPartToSplat = ((startingTime - timeLeft) / startingTime) * (endPartToSplat - startPartToSplat) + startPartToSplat;
		
		RainEffect.rainEffect(main.batch, currentDrops, currentSplats, currentPartToSplat);
	}
}
