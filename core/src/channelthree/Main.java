package channelthree;

import ionium.registry.AssetRegistry;
import ionium.registry.ScreenRegistry;
import ionium.util.Logger;
import ionium.util.SpecialCharactersList;
import ionium.util.controllers.Xbox360Controllers;
import channelthree.load.AssetLoader;
import channelthree.load.ConstTweaks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.utils.Array;

public class Main extends ionium.templates.Main {

	public BitmapFont vectorFont;
	
	public Main(Logger l) {
		super(l);
	}

	@Override
	public String getScreenToSwitchToAfterLoadingAssets() {
		return "mainmenu";
	}
	
	@Override
	public void create() {
		super.create();
		
		ConstTweaks.tweakConstants();
		resizeScreenFromSettings();
		Xbox360Controllers.instance().findControllers();
		
		AssetRegistry.instance().addAssetLoader(new AssetLoader());
	}

	private void resizeScreenFromSettings(){
		if (Gdx.graphics.getWidth() != Settings.actualWidth
				|| Gdx.graphics.getHeight() != Settings.actualHeight
				|| Gdx.graphics.isFullscreen() != Settings.fullscreen) {
			Gdx.graphics.setDisplayMode(Settings.actualWidth, Settings.actualHeight,
					false);
		}
	}
	
	@Override
	public void prepareStates() {
		super.prepareStates();
		
		ScreenRegistry reg = ScreenRegistry.instance();
		
		reg.add("mainmenu", new MainMenuScreen(this));
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
		
		FreeTypeFontGenerator ttfGenerator = new FreeTypeFontGenerator(
				Gdx.files.internal("fonts/KenVector Future Thin.ttf"));
		FreeTypeFontParameter ttfParam = new FreeTypeFontParameter();
		ttfParam.magFilter = TextureFilter.Nearest;
		ttfParam.minFilter = TextureFilter.Nearest;
		ttfParam.genMipMaps = true;
		ttfParam.size = 24;
		vectorFont = ttfGenerator.generateFont(ttfParam);
		vectorFont.getData().markupEnabled = true;

		ttfGenerator.dispose();
	}

	@Override
	public void dispose() {
		super.dispose();
		
		vectorFont.dispose();
		
		Settings.getPreferences().flush();
	}

}
