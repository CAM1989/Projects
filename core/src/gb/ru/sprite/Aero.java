package gb.ru.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import gb.ru.base.Sprite;
import gb.ru.math.Rect;

public class Aero extends Sprite {
    private final Vector2 v;

    public Aero(TextureAtlas atlas) {
        super(atlas.findRegion("main_ship"));
        v = new Vector2();
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.1f);
        setLeft(worldBounds.getLeft() + worldBounds.getHalfWidth() - 0.06f);
        setBottom(worldBounds.getBottom());
    }

    @Override
    public void update(float delta) {
        super.update(delta);
    }


}

