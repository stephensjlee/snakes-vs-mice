package me.framework;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by stephen on 3/2/15.
 */
public interface FileIO {
    public InputStream readAsset(String fileName) throws IOException;

    public InputStream readFile(String fileName) throws IOException;

    public OutputStream writeFile(String filename) throws IOException;
}
