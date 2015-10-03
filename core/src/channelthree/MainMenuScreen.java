package channelthree;

import ionium.menutree.MenuElement;
import ionium.menutree.MenuTree;
import ionium.registry.GlobalVariables;
import ionium.screen.Updateable;
import ionium.templates.Main;
import ionium.util.Translator;
import channelthree.util.RainEffect;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.utils.Array;

public class MainMenuScreen extends Updateable {

	public BitmapFont titleFont;
	public channelthree.Main main;

	private MenuTree menu;

	public MainMenuScreen(channelthree.Main m) {
		super(m);
		this.main = m;

		FreeTypeFontGenerator ttfGenerator = new FreeTypeFontGenerator(
				Gdx.files.internal("fonts/KenVector Future Thin.ttf"));
		FreeTypeFontParameter ttfParam = new FreeTypeFontParameter();
		ttfParam.magFilter = TextureFilter.Nearest;
		ttfParam.minFilter = TextureFilter.Nearest;
		ttfParam.genMipMaps = true;
		ttfParam.size = 72;
		titleFont = ttfGenerator.generateFont(ttfParam);
		titleFont.getData().markupEnabled = true;

		ttfGenerator.dispose();

		menu = new MenuTree(main, 288f / GlobalVariables.getInt("DEFAULT_WIDTH"),
				1f - (388f / GlobalVariables.getInt("DEFAULT_HEIGHT")), 32);

		menu.addElement(new MenuElement(menu) {

			@Override
			public String getRenderText() {
				return Translator.getMsg("menu.newgame");
			}

			@Override
			public boolean onAction() {
				return false;
			}

		});
		menu.addElement(new MenuElement(menu) {

			@Override
			public String getRenderText() {
				return Translator.getMsg("menu.continuegame");
			}

			@Override
			public boolean onAction() {
				return false;
			}
			
			@Override
			public boolean isEnabled(){
				return true;
			}

		});
		menu.addElement(new MenuElement(menu) {

			@Override
			public String getRenderText() {
				return Translator.getMsg("menu.options");
			}

			@Override
			public boolean isEnabled() {
				return false;
			}

			@Override
			public boolean onAction() {
				return false;
			}

		});
		menu.addElement(new MenuElement(menu) {

			@Override
			public String getRenderText() {
				return Translator.getMsg("menu.quit");
			}

			@Override
			public boolean onAction() {
				Gdx.app.exit();
				return true;
			}

		});

	}

	@Override
	public void render(float delta) {
		main.batch.begin();

		RainEffect.rainEffect(main.batch, 20, 4, 0.15f);
		
		titleFont.setColor(1, 1, 1, 1);
		titleFont.draw(main.batch, Translator.getMsg("gamename"), 256, Main.convertY(256));

		menu.render(main.batch, main.vectorFont);

		main.batch.end();
	}

	@Override
	public void renderUpdate() {
	}

	@Override
	public void tickUpdate() {
	}

	@Override
	public Array<String> getDebugStrings(Array<String> array) {
		return array;
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		menu.onScreenShow();
	}

	@Override
	public void hide() {
		menu.onScreenHide();
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		titleFont.dispose();
	}

}
