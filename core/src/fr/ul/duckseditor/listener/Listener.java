package fr.ul.duckseditor.listener;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.QueryCallback;

import java.util.ArrayList;

public class Listener implements InputProcessor {

    private ArrayList<Integer> codes;
    private ArrayList<Body> bodies;
    private String car;
    private String msg;

    public Listener(){
        bodies = new ArrayList<Body>();
        codes = new ArrayList<Integer>();
        car="";
        update();
    }

    private void update(){
        msg="";
        for(Object c :codes){
            msg +=  c + " ";
        }
        msg += car;
    }

    public String getMsg() {
        return msg;
    }

    public QueryCallback query(){
        QueryCallback q = new QueryCallback() {
            @Override
            public boolean reportFixture(Fixture fixture) {
                bodies.add(fixture.getBody());
                return false;
            }
        };
        return q;
    }


    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.ESCAPE){
            Gdx.app.exit();
        }
        codes.add(Integer.valueOf(keycode));
        update();
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        codes.remove(Integer.valueOf(keycode));
        update();
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        this.car = Character.toString(character);
        update();
        return true;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
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
        Listener listener = new Listener();
        //System.out.println(listener.keyDown(5));
    }
}
