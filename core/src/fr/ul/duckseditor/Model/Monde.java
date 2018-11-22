package fr.ul.duckseditor.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import fr.ul.duckseditor.DataFactory.TextureFactory;
import fr.ul.duckseditor.listener.Listener;

import java.util.ArrayList;

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
    private BlocRectangle blocRectangle;
    private Bloc bloc;
    private CibleBeige cibleBeige;
    private SpriteBatch spriteBatch;
    private ArrayList<Objet> lesObjets;


    public Monde() {
        world = new World(new Vector2(0, -10f), true);
        largeur = 64;
        hauteur = 36;
        textureFactory = new TextureFactory();
        panneau = new Panneau();
        boutonPlay = new BoutonPlay();
        boutonTrash = new BoutonTrash();
        boutonsFichier = new BoutonsFichier();
        blocRectangle = new BlocRectangle();
        bloc = new Bloc();
        cibleBeige = new CibleBeige();
        bord = new Bord();
        heros = new Heros();
        lesObjets = new ArrayList<Objet>();
    }

    public void create() {
        panneau.create(this);
        boutonPlay.create(this);
        boutonTrash.create(this);
        boutonsFichier.create(this);
        blocRectangle.create(this, BodyDef.BodyType.StaticBody, 7, 16);
        bloc.create(this, BodyDef.BodyType.StaticBody, 6.5f, 13);
        cibleBeige.create(this, BodyDef.BodyType.StaticBody, 7.5f, 10);
        heros.create(this, BodyDef.BodyType.DynamicBody, 32, 18);
        bord.create(this);
        spriteBatch = new SpriteBatch();
    }

    public void draw(SpriteBatch sb) {
        spriteBatch = sb;
        bord.draw(sb);
        panneau.draw(sb);
        boutonPlay.draw(sb);
        boutonTrash.draw(sb);
        boutonsFichier.draw(sb);
        blocRectangle.draw(sb);
        bloc.draw(sb);
        cibleBeige.draw(sb);
        heros.draw(sb);
        for (Objet objet : lesObjets) {
            objet.draw(sb);
        }
        render();
    }

    public void render() {
        world.step(Gdx.graphics.getDeltaTime(), 6, 2);
    }

    public void ajouterObjet(Objet objet) {
        lesObjets.add(objet);
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

    public Bloc getBloc() {
        return bloc;
    }

    public BlocRectangle getBlocRectangle() {
        return blocRectangle;
    }

    public CibleBeige getCibleBeige() {
        return cibleBeige;
    }

    public BoutonsFichier getBoutonsFichier() {
        return boutonsFichier;
    }

    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }

    public ArrayList<Objet> getLesObjets() {
        return lesObjets;
    }

    public boolean contient(Body body){
        boolean contient = false;
        for (Objet objet : lesObjets){
            if(objet.getBody()==body){
                contient = contient || true;
            }
        }
        return contient;
    }

}
