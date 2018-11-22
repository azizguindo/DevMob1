package fr.ul.duckseditor.Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;
import fr.ul.duckseditor.DataFactory.TextureFactory;

public abstract class Objet {
    protected Body objet;
    protected Shape shape;
    private TextureFactory textureFactory;
    protected BodyDef bodyDef;
    protected Texture texture;
    private SpriteBatch spriteBatch;

    public Objet(){
        bodyDef = new BodyDef();
        spriteBatch = new SpriteBatch();
    }

    public void create(Monde monde, BodyDef.BodyType type,float X,float Y){
        bodyDef.type = type;
        bodyDef.position.set(X,Y);
        objet=monde.getWorld().createBody(bodyDef );
        FixtureDef fixtureDef1 = new FixtureDef();
        fixtureDef1.shape = shape;
        fixtureDef1.density = 1f;
        fixtureDef1.restitution = 0.5f;
        objet.createFixture(fixtureDef1);
        shape.dispose();
        spriteBatch = monde.getSpriteBatch();
    }

    public Body getBody() {
        return objet;
    }
    public void draw(SpriteBatch sb){
        Vector2 v = objet.getPosition();
        sb.draw(texture,v.x,v.y,2,2);
    }
}
