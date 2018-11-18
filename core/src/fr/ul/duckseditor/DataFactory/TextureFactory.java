package fr.ul.duckseditor.DataFactory;

import com.badlogic.gdx.graphics.Texture;

public class TextureFactory {
    Texture background;
    Texture beam;
    Texture block;
    Texture cancel;
    Texture duck;
    Texture editPanel;
    Texture leftarrow;
    Texture Load;
    Texture Play;
    Texture Rewrite;
    Texture rightarrow;
    Texture Save;
    Texture Stop;
    Texture targetbeige;
    Texture targetblue;
    Texture Trash;

    public TextureFactory()
    {
        background = new Texture("images/background.png");
        beam = new Texture("images/beam.png");
        block = new Texture("images/block.png");
        cancel = new Texture("images/cancel.png");
        duck = new Texture("images/duck.png");
        editPanel = new Texture("images/editPanel.png");
        leftarrow = new Texture("images/leftarrow.png");
        Load = new Texture("images/Load.png");
        Play = new Texture("images/Play.png");
        Rewrite = new Texture("images/Rewrite.png");
        rightarrow = new Texture("images/rightarrow.png");
        Save = new Texture("images/Save.png");
        Stop = new Texture("images/Stop.png");
        targetbeige = new Texture("images/targetbeige.png");
        targetblue = new Texture("images/targetblue.png");
        Trash = new Texture("images/Trash.png");
    }

    public Texture getBackground() {
        return background;
    }

    public Texture getBeam() {
        return beam;
    }

    public Texture getBlock() {
        return block;
    }

    public Texture getCancel() {
        return cancel;
    }

    public Texture getDuck() {
        return duck;
    }

    public Texture getEditPanel() {
        return editPanel;
    }

    public Texture getLeftarrow() {
        return leftarrow;
    }

    public Texture getLoad() {
        return Load;
    }

    public Texture getPlay() {
        return Play;
    }

    public Texture getRewrite() {
        return Rewrite;
    }

    public Texture getRightarrow() {
        return rightarrow;
    }

    public Texture getSave() {
        return Save;
    }

    public Texture getStop() {
        return Stop;
    }

    public Texture getTargetbeige() {
        return targetbeige;
    }

    public Texture getTargetblue() {
        return targetblue;
    }

    public Texture getTrash() {
        return Trash;
    }
}
