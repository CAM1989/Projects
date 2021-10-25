package gb.ru.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import gb.ru.base.BaseScreen;
import gb.ru.math.Rect;
import gb.ru.sprite.Aero;
import gb.ru.sprite.Background;
import gb.ru.sprite.Star;

public class GameScreen extends BaseScreen {

    private static final int STAR_COUNT = 64;
    private static final float STEP = 0.05f;

    private TextureAtlas atlas;
    private Texture bg;
    private Background background;

    private Star[] stars;
    private Aero aero;

    @Override
    public void show() {
        super.show();
        atlas = new TextureAtlas("textures/mainAtlas.tpack");
        bg = new Texture("textures/bg.png");
        background = new Background(bg);
        stars = new Star[STAR_COUNT];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star(atlas);
        }
        aero = new Aero(atlas);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        for (Star star : stars) {
            star.resize(worldBounds);
        }
        aero.resize(worldBounds);
    }

    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
        atlas.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == 19) {
            aero.setBottom(aero.getBottom() + STEP);
        }
        if (keycode == 20) {
            aero.setBottom(aero.getBottom() - STEP);
        }
        if (keycode == 21) {
            aero.setLeft(aero.getLeft() - STEP);
        }
        if (keycode == 22) {
            aero.setRight(aero.getRight() + STEP);
        }
        return super.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        return super.keyUp(keycode);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        return super.touchDown(touch, pointer, button);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        return super.touchUp(touch, pointer, button);
    }

    private void update(float delta) {
        for (Star star : stars) {
            star.update(delta);
        }
        aero.update(delta);
    }

    private void draw() {
        batch.begin();
        background.draw(batch);
        for (Star star : stars) {
            star.draw(batch);
        }
        aero.draw(batch);
        batch.end();
    }
}
