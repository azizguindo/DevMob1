package fr.ul.duckseditor.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class EditorScreen extends ScreenAdapter {
    private fr.ul.duckseditor.Model.Monde monde;
    private SpriteBatch sb;
    private OrthographicCamera camera;
    private FitViewport vp;


    public EditorScreen(){

        monde = new fr.ul.duckseditor.Model.Monde();
        monde.create();
        sb=new SpriteBatch();
        camera = new OrthographicCamera ();
        vp = new FitViewport(64, 36, camera);
        vp.apply();
        camera.position.set(camera.viewportWidth/2,camera.viewportHeight/2,0);
        camera.update();
        sb.setProjectionMatrix(camera.combined);
    }

    @Override
    public void resize(int width, int height){
        vp.update(width,height);
        camera.position.set(camera.viewportWidth /2,camera.viewportHeight/2,0);
        camera.update();
        sb.setProjectionMatrix(camera.combined);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        sb.begin();
        monde.draw(sb);
        sb.end();
    }



    @Override
    public void dispose() {
        sb.dispose();
    }

    public SpriteBatch getSb() {
        return sb;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }
}
