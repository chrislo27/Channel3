package channelthree.load;

import ionium.animation.Animation;
import ionium.registry.handler.IAssetLoader;
import ionium.util.AssetMap;

import java.util.HashMap;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class AssetLoader implements IAssetLoader {

	@Override
	public void addManagedAssets(AssetManager manager) {
		// raindrops
		manager.load(AssetMap.add("raindrop", "images/rain/raindrop.png"), Texture.class);
		for(int i = 0; i < 5; i++){
			manager.load(AssetMap.add("raindrop_splat" + i, "images/rain/splat" + i + ".png"), Texture.class);
		}
	}

	@Override
	public void addUnmanagedTextures(HashMap<String, Texture> textures) {
	}

	@Override
	public void addUnmanagedAnimations(HashMap<String, Animation> animations) {
	}

}
