package fr.ul.duckseditor.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import fr.ul.duckseditor.DucksEditor;
import fr.ul.duckseditor.listener.Listener;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.a=8;
		config.width=960;
		config.height=540;
		new LwjglApplication(new DucksEditor(), config);
        Listener listener = new Listener();
        Gdx.input.setInputProcessor(listener);
	}
}
