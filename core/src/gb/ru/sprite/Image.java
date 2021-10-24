package gb.ru.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import gb.ru.base.Sprite;
import gb.ru.math.Rect;

public class Image extends Sprite {

    private static float V_LEN = 0.01f;
    private Vector2 touch;
    private Vector2 v;

    public Image(Texture region) {
        super(new TextureRegion(region));
        touch = new Vector2();
        v = new Vector2();

    }

    @Override
    public void update(float delta) {
        if (touch.dst(pos) < V_LEN) {
            pos.set(touch);
        } else {
            pos.add(v);
        }

    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        this.touch.set(touch);
        v.set(touch.cpy().sub(pos)).setLength(V_LEN);
        return false;
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.1f);
    }
}