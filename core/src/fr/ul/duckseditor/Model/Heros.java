package fr.ul.duckseditor.Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import fr.ul.duckseditor.DataFactory.TextureFactory;

public class Heros {
    private Body objet;
    private CircleShape shape;
    private Texture hero;
    private TextureFactory textureFactory;

    public Heros(){
        shape = new CircleShape();
        shape.setRadius(1);
        textureFactory = new TextureFactory();
    }

    public void create(Monde monde){
        BodyDef bodyDef1 = new BodyDef();
        bodyDef1.type = BodyDef.BodyType.DynamicBody;
        bodyDef1.position.set(monde.getLargeur(),monde.getHauteur());
        objet=monde.getWorld().createBody(bodyDef1 );
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
        hero = textureFactory.getDuck();
        Vector2 v = objet.getPosition();
        sb.draw(hero,v.x/2f,v.y/2f,2,2);
    }
}
