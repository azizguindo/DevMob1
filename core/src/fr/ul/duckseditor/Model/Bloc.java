package fr.ul.duckseditor.Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import fr.ul.duckseditor.DataFactory.TextureFactory;

public class Bloc extends Objet {

    private TextureFactory textureFactory;

    public Bloc() {
        shape = new PolygonShape();
        float[] pts ={0,0,0,2,2,2,2,0};
        ((PolygonShape) shape).set(pts);
        textureFactory = new TextureFactory();
        texture = textureFactory.getBlock();
    }

    public void draw(SpriteBatch sb){
        Vector2 v = objet.getPosition();
        sb.draw(texture,v.x,v.y,2,2);
    }

}
