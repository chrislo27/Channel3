package channelthree;

import ionium.menutree.MenuElement;
import ionium.menutree.MenuTree;
import ionium.registry.ConstantsRegistry;
import ionium.screen.Updateable;
import ionium.templates.Main;
import ionium.util.Translator;

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

		menu = new MenuTree(main, 288f / ConstantsRegistry.getInt("DEFAULT_WIDTH"),
				1f - (388f / ConstantsRegistry.getInt("DEFAULT_HEIGHT")), 32);

		menu.addElement(new MenuElement(menu) {

			@Override
			public String getRenderText() {
				return "option 1";
			}

		});
		menu.addElement(new MenuElement(menu) {

			@Override
			public String getRenderText() {
				return "option 2";
			}

		}.setSublevel(new Array<MenuElement>(new MenuElement[] { new MenuElement(menu) {

			@Override
			public String getRenderText() {
				return "sub-option 1";
			}

		}, new MenuElement(menu) {

			@Override
			public String getRenderText() {
				return "sub-option 2";
			}

		}.setSublevel(new Array<MenuElement>(new MenuElement[]{new MenuElement(menu) {

			@Override
			public String getRenderText() {
				return "sub-sub-option 1";
			}

		}, new MenuElement(menu) {

			@Override
			public String getRenderText() {
				return "sub-sub-option 2";
			}

		}})), new MenuElement(menu) {

			@Override
			public String getRenderText() {
				return "sub-option 3";
			}

		} })));
		menu.addElement(new MenuElement(menu) {

			@Override
			public String getRenderText() {
				return "option 3";
			}

		});
	}

	@Override
	public void render(float delta) {
		main.batch.begin();

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
	}

	@Override
	public void hide() {
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
