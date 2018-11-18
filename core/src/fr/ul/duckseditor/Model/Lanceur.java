package fr.ul.duckseditor.Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import fr.ul.duckseditor.DataFactory.TextureFactory;

public class Lanceur {
    private Body objet;
    private PolygonShape shape;
    private Texture lanceur;
    private TextureFactory textureFactory;

    public Lanceur(){
        shape = new PolygonShape();
        float[] pts ={0,0,0,4,2,4,2,0};
        shape.set(pts);
        textureFactory = new TextureFactory();
    }

    public void create(Monde monde){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(7f,17);
        objet=monde.getWorld().createBody(bodyDef );
        FixtureDef fixtureDef1 = new FixtureDef();
        fixtureDef1.shape = shape;
        fixtureDef1.density = 1f;
        fixtureDef1.restitution = 0.5f;
        objet.createFixture(fixtureDef1);
        Vector2 gravity = new Vector2(0, -10f);
        objet.applyForceToCenter(gravity,true);
        shape.dispose();
    }

    public void draw(SpriteBatch sb){
        lanceur = textureFactory.getBeam();
        Vector2 v = objet.getPosition();
        sb.draw(lanceur,v.x,v.y,1,4);
    }
}
