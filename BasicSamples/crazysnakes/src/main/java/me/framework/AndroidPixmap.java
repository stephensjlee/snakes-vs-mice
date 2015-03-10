package me.framework;

import android.graphics.Bitmap;
import me.framework.Graphics.PixmapFormat;

/**
 * Created by stephen on 3/4/15.
 */
public class AndroidPixmap implements Pixmap {
    Bitmap bitmap;
    PixmapFormat format;
    public AndroidPixmap(Bitmap bitmap, PixmapFormat format) {
        this.bitmap = bitmap;
        this.format = format;
    }
    public int getWidth() {
        return bitmap.getWidth();
    }
    public int getHeight() {
        return bitmap.getHeight();
    }
    public PixmapFormat getFormat() {
        return format;
    }
    public void dispose() {
        bitmap.recycle();
    }
}