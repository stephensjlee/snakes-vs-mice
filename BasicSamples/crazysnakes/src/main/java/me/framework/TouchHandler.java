package me.framework;

import android.view.View;

import java.util.List;

/**
 * Created by stephen on 3/4/15.
 */
public interface TouchHandler extends View.OnTouchListener {
    public boolean isTouchDown(int pointer);
    public int getTouchX(int pointer);
    public int getTouchY(int pointer);
    public List<Input.TouchEvent> getTouchEvents();
}