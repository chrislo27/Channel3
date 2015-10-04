package channelthree.util;

import ionium.registry.AssetRegistry;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;

public final class RainEffect {

	public static final int DEF_DROPS = 20;
	public static final int DEF_SPLATS = 4;
	public static final float DEF_PART_TO_SPLAT = 0.15f;
	
	/**
	 * 
	 * @param batch
	 * @param drops
	 * @param splats
	 * @param partToSplat bottom percentage of where to splat
	 */
	public static void rainEffect(Batch batch, int drops, int splats, float partToSplat) {
		Texture raindrop = AssetRegistry.getTexture("raindrop");

		for (int i = 0; i < drops; i++) {
			batch.draw(raindrop, Gdx.graphics.getWidth() * MathUtils.random(),
					Gdx.graphics.getHeight() * MathUtils.random());
		}

		for (int i = 0; i < splats; i++) {
			batch.draw(AssetRegistry.getTexture("raindrop_splat" + MathUtils.random(0, 4)),
					Gdx.graphics.getWidth() * MathUtils.random(), Gdx.graphics.getHeight()
							* MathUtils.random() * partToSplat);
		}
	}

}
