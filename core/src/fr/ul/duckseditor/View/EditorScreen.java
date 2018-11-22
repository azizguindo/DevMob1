package fr.ul.duckseditor.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import fr.ul.duckseditor.Model.Monde;
import fr.ul.duckseditor.listener.Listener;

public class EditorScreen extends ScreenAdapter {
    private Monde monde;
    private SpriteBatch sb;
    private OrthographicCamera camera;
    private FitViewport vp;
    private Listener listener;
    private Box2DDebugRenderer debugRenderer;


    public EditorScreen(){
        debugRenderer=new Box2DDebugRenderer();
        monde = new Monde();
        monde.create();
        sb=new SpriteBatch();
        camera = new OrthographicCamera ();
        vp = new FitViewport(monde.getLargeur(),monde.getHauteur(), camera);
        vp.apply();
        camera.position.set(camera.viewportWidth/2,camera.viewportHeight/2,0);
        camera.update();
        sb.setProjectionMatrix(camera.combined);
        listener = new Listener(monde,camera);
        Gdx.input.setInputProcessor(listener);
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
