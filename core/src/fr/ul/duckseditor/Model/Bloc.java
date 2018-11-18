package fr.ul.duckseditor.Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import fr.ul.duckseditor.DataFactory.TextureFactory;

public class Bloc {
    private Body objet;
    private CircleShape shape;
    private Texture bloc;
    private TextureFactory textureFactory;

    public Bloc(){
        shape = new CircleShape();
        shape.setRadius(1);
        textureFactory = new TextureFactory();
    }

    public void create(Monde monde){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(6.5f,14);
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
        bloc = textureFactory.getBlock();
        Vector2 v = objet.getPosition();
        sb.draw(bloc,v.x,v.y,2,2);
    }
}
