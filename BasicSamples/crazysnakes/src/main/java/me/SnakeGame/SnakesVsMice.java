package me.SnakeGame;

import me.framework.AndroidGame;
import me.framework.Screen;

/**
 * Created by stephen on 3/4/15.
 */
public class SnakesVsMice extends AndroidGame {
    public Screen getStartScreen(){
        return new LoadingScreen(this);
    }
}
