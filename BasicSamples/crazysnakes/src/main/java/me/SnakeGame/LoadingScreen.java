package me.SnakeGame;

/**
 * Created by stephen on 3/4/15.
 */
import me.framework.Game;
import me.framework.Graphics;
import me.framework.Graphics.PixmapFormat;
import me.framework.Screen;

public class LoadingScreen extends Screen {
    public LoadingScreen(Game game) {
        super(game);
    }
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        Assets.background = g.newPixmap("background.png", PixmapFormat.RGB565);
        Assets.logo = g.newPixmap("logo.png", PixmapFormat.ARGB444);
        Assets.mainMenu = g.newPixmap("mainmenu.png", PixmapFormat.ARGB444);
        Assets.buttons = g.newPixmap("buttons.png", PixmapFormat.ARGB444);
        Assets.help1 = g.newPixmap("help1.png", PixmapFormat.ARGB444);
        Assets.help2 = g.newPixmap("help2.png", PixmapFormat.ARGB444);
        Assets.help3 = g.newPixmap("help3.png", PixmapFormat.ARGB444);
        Assets.numbers = g.newPixmap("numbers.png", PixmapFormat.ARGB444);
        Assets.ready = g.newPixmap("ready.png", PixmapFormat.ARGB444);
        Assets.pause = g.newPixmap("pausemenu.png", PixmapFormat.ARGB444);
        Assets.gameOver = g.newPixmap("gameover.png", PixmapFormat.ARGB444);
        Assets.headUp = g.newPixmap("headup.png", PixmapFormat.ARGB444);
        Assets.headLeft = g.newPixmap("headleft.png", PixmapFormat.ARGB444);
        Assets.headDown = g.newPixmap("headdown.png", PixmapFormat.ARGB444);
        Assets.headRight = g.newPixmap("headright.png", PixmapFormat.ARGB444);
        Assets.tail = g.newPixmap("tail.png", PixmapFormat.ARGB444);
        Assets.stain1 = g.newPixmap("stain1.png", PixmapFormat.ARGB444);
        Assets.stain2 = g.newPixmap("stain2.png", PixmapFormat.ARGB444);
        Assets.stain3 = g.newPixmap("stain3.png", PixmapFormat.ARGB444);
        Assets.moving1 = g.newPixmap("moving1.png", PixmapFormat.ARGB444);
        Assets.moving2 = g.newPixmap("moving2.png", PixmapFormat.ARGB444);
        Assets.moving3 = g.newPixmap("moving3.png", PixmapFormat.ARGB444);
        Assets.click = game.getAudio().newSound("click.ogg");
        Assets.eat = game.getAudio().newSound("eat.ogg");
        Assets.bitten = game.getAudio().newSound("bitten.ogg");
        Settings.load(game.getFileIO());
        game.setScreen(new MainMenuScreen(game));
    }
    public void present(float deltaTime) {
    }
    public void pause() {
    }
    public void resume() {
    }
    public void dispose() {
    }
}