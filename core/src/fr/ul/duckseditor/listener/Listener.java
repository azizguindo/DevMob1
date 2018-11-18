package fr.ul.duckseditor.listener;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class Listener implements InputProcessor {
    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.ESCAPE){
            System.out.println("Quitter");
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
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
        System.out.println(listener.keyDown(5));
    }
}
