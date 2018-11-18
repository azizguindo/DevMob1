package fr.ul.duckseditor.Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import fr.ul.duckseditor.DataFactory.TextureFactory;

public class Bord {
    private Body objet;
    private PolygonShape bords;
    private Texture background;
    private TextureFactory textureFactory;

    public Bord(){
        bords = new PolygonShape();
        float[] pts ={0,6,0,36,64,36,64,6};
        bords.set(pts);
        textureFactory = new TextureFactory();
    }
    public void create(Monde monde) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(0, 0);
        objet = monde.getWorld().createBody(bodyDef);
        bords.setAsBox(64, 11);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = bords;
        fixtureDef.density = 0.5f;
        fixtureDef.restitution = 0.5f;
        objet.createFixture(fixtureDef);
        bords.dispose();
    }
    public void draw(SpriteBatch sb){
        background = textureFactory.getBackground();
        Vector2 v = objet.getPosition();
        sb.draw(background,v.x,v.y,64,36);
    }
}
