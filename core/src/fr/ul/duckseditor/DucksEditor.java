package fr.ul.duckseditor;

import com.badlogic.gdx.Game;
import fr.ul.duckseditor.View.EditorScreen;

public class DucksEditor extends Game {
	private EditorScreen editorScreen;


	@Override
	public void create () {
		editorScreen =new EditorScreen();
		setScreen(editorScreen);
	}

	
	@Override
	public void dispose () {
		editorScreen.dispose();
	}
}
