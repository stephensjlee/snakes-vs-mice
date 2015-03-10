package me.framework;

/**
 * Created by stephen on 3/2/15.
 */
public interface Pixmap {
    public int getWidth();

    public int getHeight();

    public Graphics.PixmapFormat getFormat();

    public void dispose();
}
