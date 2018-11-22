package fr.ul.duckseditor.Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import fr.ul.duckseditor.DataFactory.TextureFactory;

public class BlocRectangle extends Objet {
    private TextureFactory textureFactory;

    public BlocRectangle(){
        shape = new PolygonShape();
        float[] pts ={0,0,0,4,1,4,1,0};
        ((PolygonShape) shape).set(pts);
        //((PolygonShape) shape).setAsBox(1,4);
        textureFactory = new TextureFactory();
        texture = textureFactory.getBeam();
    }

    public void draw(SpriteBatch sb){
        Vector2 v = objet.getPosition();
        sb.draw(texture,v.x,v.y,1,4);
    }
}
