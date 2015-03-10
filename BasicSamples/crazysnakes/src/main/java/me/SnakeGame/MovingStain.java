package me.SnakeGame;

/**
 * Created by stephen on 3/5/15.
 */
public class MovingStain {
    public static final int TYPE_1 = 0;
    public static final int TYPE_2 = 1;
    public static final int TYPE_3 = 2;

    public boolean moveLeft;
    public boolean moveRight;
    public boolean moveUp;
    public boolean moveDown;
    public boolean moveUpRight;
    public boolean moveUpLeft;
    public boolean moveDownRight;
    public boolean moveDownLeft;


    public int x, y;
    public int type;

    public MovingStain(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;

    }

}
