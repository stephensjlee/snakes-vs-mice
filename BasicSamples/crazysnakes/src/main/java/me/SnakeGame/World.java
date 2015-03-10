package me.SnakeGame;

import android.graphics.Point;

import java.util.Random;

/**
 * Created by stephen on 3/4/15.
 */

/*
TODO: create a method to determine availability of spots?
-Stains cannot occupy snake squares
-Stains cannot occupy other stains
 */
public class World {
    static final int WORLD_WIDTH = 10;
    static final int WORLD_HEIGHT = 13;
    static final int SCORE_INCREMENT = 10;
    static final float TICK_INITIAL = 0.5f;
    static final float TICK_DECREMENT = 0.05f;

    public Snake snake;
    public Stain stain;
    public MovingMouse movingMouse;
    public boolean gameOver = false;
    public int score = 0;

    boolean fields[][] = new boolean[WORLD_WIDTH][WORLD_HEIGHT];
    Random random = new Random();
    float tickTime = 0;
    static float tick = TICK_INITIAL;

    public World() {
        snake = new Snake();
        placeStain();
        placeMovingMouse();
    }

    //sets the valid locations to "false" and invalid locations to "true"
    private void setInvalidLocation(){
        for (int x = 0; x < WORLD_WIDTH; x++) {
            for (int y = 0; y < WORLD_HEIGHT; y++) {
                fields[x][y] = false;
            }
        }
        int len = snake.parts.size();
        for (int i = 0; i < len; i++) {
            SnakePart part = snake.parts.get(i);
            fields[part.x][part.y] = true;
        }
    }

    private Point setCoordBounds(Point p){
        if (p.x >= WORLD_WIDTH - 1) {
            p.x = 0;
        }
        if (p.y >= WORLD_HEIGHT - 1) {
            p.y = 0;
        }
        if (p.x < 0) {
            p.x = WORLD_WIDTH - 1;
        }
        if (p.y < 0) {
            p.y = WORLD_HEIGHT - 1;
        }
        return p;
    }

    //static stain is consumed
    private void placeStain() {
        setInvalidLocation();
        //Sets the next location of stain
        Point p = new Point(random.nextInt(WORLD_WIDTH),random.nextInt(WORLD_HEIGHT));
        while (true) {
            if (fields[p.x][p.y] == false)
                break;
            p.x += 1;
            p = setCoordBounds(p);
        }
        stain = new Stain(p.x, p.y, random.nextInt(3));
    }

    //moving stain (i.e. mouse) is consumed
    private void placeMovingMouse() {
        setInvalidLocation();
        //Sets the next location of stain
        Point p = new Point(random.nextInt(WORLD_WIDTH),random.nextInt(WORLD_HEIGHT));
        while (true) {
            if (fields[p.x][p.y] == false)
                break;
            p.x += 1;
            p = setCoordBounds(p);
        }
        movingMouse = new MovingMouse(p.x, p.y, random.nextInt(3));
    }

    private void moveMovingMouse(){
        setInvalidLocation();
        Point p = new Point(movingMouse.x, movingMouse.y);
        while (true) {
            int ran = random.nextInt(5);
            //TODO: find a better way to code this?
            switch(ran){
                case 1:
                    p.y += 1;
                    break;
                case 2:
                    p.y -= 1;
                    break;
                case 3:
                    p.x += 1;
                    break;
                case 4:
                    p.x -= 1;
                    break;
                default:
                    assert ran >= 0 && ran <= 8;
            }

            p = setCoordBounds(p);
            //if mouse cannot move to needed direction, it stays put in original location
            if(fields[p.x][p.y] == true){
                p.x = movingMouse.x;
                p.y = movingMouse.y;
            }
            break;
        }
        movingMouse = new MovingMouse(p.x, p.y, movingMouse.type);
    }


    public void update(float deltaTime) {
        if (gameOver)
            return;

        tickTime += deltaTime;

        while (tickTime > tick) {
            tickTime -= tick;
            snake.advance();
            moveMovingMouse();
            if (snake.checkBitten()) {
                gameOver = true;
                return;
            }

            SnakePart head = snake.parts.get(0);
            if (head.x == stain.x && head.y == stain.y) {
                score += SCORE_INCREMENT;
                snake.eat();
                if (snake.parts.size() == WORLD_WIDTH * WORLD_HEIGHT) {
                    gameOver = true;
                    return;
                } else {
                    placeStain();
                }

                if (score % 100 == 0 && tick - TICK_DECREMENT > 0) {
                    tick -= TICK_DECREMENT;
                }
            }
            if (head.x == movingMouse.x && head.y == movingMouse.y) {
                score += SCORE_INCREMENT;
                snake.eat();
                if (snake.parts.size() == WORLD_WIDTH * WORLD_HEIGHT) {
                    gameOver = true;
                    return;
                } else {
                    placeMovingMouse();
                }

                if (score % 100 == 0 && tick - TICK_DECREMENT > 0) {
                    tick -= TICK_DECREMENT;
                }
            }
        }
    }
}
