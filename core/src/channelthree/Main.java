package channelthree;

import ionium.registry.AssetRegistry;
import ionium.registry.ScreenRegistry;
import ionium.util.Logger;
import channelthree.load.AssetLoader;
import channelthree.load.ConstTweaks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;

public class Main extends ionium.templates.Main {

	public Main(Logger l) {
		super(l);
	}

	@Override
	public String getScreenToSwitchToAfterLoadingAssets() {
		return "";
	}
	
	@Override
	public void create() {
		super.create();
		
		ConstTweaks.tweakConstants();
		resizeScreenFromSettings();
		
		AssetRegistry.instance().addAssetLoader(new AssetLoader());
	}

	private void resizeScreenFromSettings(){
		if (Gdx.graphics.getWidth() != Settings.actualWidth
				|| Gdx.graphics.getHeight() != Settings.actualHeight
				|| Gdx.graphics.isFullscreen() != Settings.fullscreen) {
			Gdx.graphics.setDisplayMode(Settings.actualWidth, Settings.actualHeight,
					Settings.fullscreen);
		}
	}
	
	@Override
	public void prepareStates() {
		super.prepareStates();
		
		ScreenRegistry reg = ScreenRegistry.instance();
		
	}

	@Override
	protected void preRender() {
		super.preRender();
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	protected void postRender() {
		super.postRender();
	}
	
	@Override
	protected Array<String> getDebugStrings(){
		return super.getDebugStrings();
	}

	@Override
	public void tickUpdate() {
		super.tickUpdate();
	}

	@Override
	public void loadFont() {
		super.loadFont();
	}

	@Override
	public void dispose() {
		super.dispose();
		
		Settings.getPreferences().flush();
	}

}
