package fr.ul.duckseditor.Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import fr.ul.duckseditor.DataFactory.TextureFactory;

public class BoutonPlay{
    private Body objet;
    private CircleShape shape;
    private Texture panneau;
    private TextureFactory textureFactory;

    public BoutonPlay(){
        shape = new CircleShape();
        shape.setRadius(4);
        textureFactory = new TextureFactory();
    }

    public void create(Monde monde) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(5.5f,31);
        objet = monde.getWorld().createBody(bodyDef);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 0.5f;
        fixtureDef.restitution = 0.5f;
        objet.createFixture(fixtureDef);
        shape.dispose();
    }


    public void draw(SpriteBatch sb){
        panneau = textureFactory.getPlay();
        Vector2 v = objet.getPosition();
        sb.draw(panneau,v.x,v.y,4,4);
    }
}
