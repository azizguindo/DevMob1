package fr.ul.duckseditor.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import fr.ul.duckseditor.DataFactory.TextureFactory;

public class Monde {
    private World world;

    private int largeur;
    private int hauteur;
    private TextureFactory textureFactory;
    private Heros heros;
    private Bord bord;
    private Panneau panneau;
    private BoutonPlay boutonPlay;
    private BoutonTrash boutonTrash;
    private BoutonsFichier boutonsFichier;
    private Lanceur lanceur;
    private Bloc bloc;
    private CibleBeige cibleBeige;

    public Monde(){
        world = new World(new Vector2(0,-10f),true);
        largeur=64;
        hauteur=36;
        textureFactory = new TextureFactory();
        panneau = new Panneau();
        boutonPlay = new BoutonPlay();
        boutonTrash = new BoutonTrash();
        boutonsFichier = new BoutonsFichier();
        lanceur = new Lanceur();
        bloc = new Bloc();
        cibleBeige = new CibleBeige();
        bord = new Bord();
        heros = new Heros();
    }

    public void create(){
        panneau.create(this);
        boutonPlay.create(this);
        boutonTrash.create(this);
        boutonsFichier.create(this);
        lanceur.create(this);
        bloc.create(this);
        cibleBeige.create(this);
        heros.create(this);
        bord.create(this);
    }

    public void draw(SpriteBatch sb){

        bord.draw(sb);
        panneau.draw(sb);
        boutonPlay.draw(sb);
        boutonTrash.draw(sb);
        boutonsFichier.draw(sb);
        lanceur.draw(sb);
        bloc.draw(sb);
        cibleBeige.draw(sb);
        heros.draw(sb);
        render();
    }

    public void render(){
        world.step(Gdx.graphics.getDeltaTime(),6,2);
    }

    public World getWorld() {
        return world;
    }


    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public TextureFactory getTextureFactory() {
        return textureFactory;
    }
}
