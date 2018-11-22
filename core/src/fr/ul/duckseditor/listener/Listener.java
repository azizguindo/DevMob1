package fr.ul.duckseditor.listener;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.QueryCallback;
import fr.ul.duckseditor.Model.*;
import javafx.stage.FileChooser;

import javax.swing.*;
import java.util.ArrayList;

public class Listener implements InputProcessor {

    private ArrayList<Integer> codes;
    private ArrayList<Body> bodies;
    private String car;
    private String msg;
    private Monde monde;
    private OrthographicCamera camera;
    Vector3 touchPos;

    public Listener(Monde monde,OrthographicCamera camera){
        this.monde=monde;
        this.camera=camera;
        bodies = new ArrayList<Body>();
        touchPos = new Vector3();
    }


    public QueryCallback query(){
        bodies = new ArrayList<Body>();
        QueryCallback q = new QueryCallback() {
            @Override
            public boolean reportFixture(Fixture fixture) {
                bodies.add(fixture.getBody());
                return true;
            }
        };
        return q;
    }


    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.ESCAPE){
            Gdx.app.exit();
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        codes.remove(Integer.valueOf(keycode));
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        this.car = Character.toString(character);
        return true;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touchPos.set(screenX, screenY, 0);
        camera.unproject(touchPos);
        float x = touchPos.x;
        float y = touchPos.y;
        monde.getWorld().QueryAABB(query(), x , y , x , y );
        for (Body body : bodies) {
            Objet o = null;
            if (body == monde.getBloc().getBody()) {
                o = new Bloc();
                ((Bloc) o).create(monde, BodyDef.BodyType.DynamicBody, 15, 15);
                monde.ajouterObjet(o);
            } else if (body == monde.getBlocRectangle().getBody()) {
                o = new BlocRectangle();
                ((BlocRectangle) o).create(monde, BodyDef.BodyType.DynamicBody, 18, 18);
                monde.ajouterObjet(o);
            } else if (body == monde.getCibleBeige().getBody()) {
                o = new CibleBeige();
                ((CibleBeige) o).create(monde, BodyDef.BodyType.DynamicBody, 15, 15);
                monde.ajouterObjet(o);
            } else if (body == monde.getBoutonsFichier().getObjet1()) {
                {
                    FileChooser fileChooser = new FileChooser();
                    //JFrame frame = new JFrame();
                    //frame.setVisible(true);
                    //int res = fileChooser.showOpenDialog(frame);
                    //frame.dispose();
                }

            }
        }


            return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        Vector3 newTouchPos = new Vector3();
        newTouchPos.set(screenX, screenY, 0);
        //camera.unproject(newTouchPos);
        Vector3 delta = newTouchPos.cpy().sub(touchPos);
        camera.unproject(delta);
        for (Body body : bodies) {
             if(monde.contient(body)){
                 System.out.println(delta.x);
                 System.out.println(body.getPosition().x);
                 body.setTransform(delta.x, delta.y-.5f, 0);
            }
        }
        //touchPos=newTouchPos;
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public static void main (String[] arg) {
    }
}
