package me.framework;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

import java.io.IOException;

/**
 * Created by stephen on 3/2/15.
 */
public class AndroidMusic implements Music, MediaPlayer.OnCompletionListener {
    MediaPlayer mediaPlayer;
    boolean isPrepared = false;

    public AndroidMusic(AssetFileDescriptor assetFileDescriptor){
        try{
            mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(),
                    assetFileDescriptor.getStartOffset(),
                    assetFileDescriptor.getLength());
            mediaPlayer.prepare();
            isPrepared = true;
            mediaPlayer.setOnCompletionListener(this);
        }
        catch(Exception e){
            throw new RuntimeException("Couldn't load music");
        }
    }

    public void dispose(){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
        mediaPlayer.release();
    }

    public boolean isLooping(){
        return mediaPlayer.isLooping();
    }

    public boolean isPlaying(){
        return mediaPlayer.isPlaying();
    }

    public boolean isStopped(){
        return !isPrepared;
    }

    public void pause(){
        if(mediaPlayer.isPlaying())
            mediaPlayer.pause();
    }

    public void play(){
        if(mediaPlayer.isPlaying())
            return;
        try{
            synchronized (this){
                if(!isPrepared)
                    mediaPlayer.prepare();
                mediaPlayer.start();
            }
        }catch(IllegalStateException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void setLooping(boolean isLooping){
        mediaPlayer.setLooping(isLooping());
    }

    public void setVolume(float volume){
        mediaPlayer.setVolume(volume, volume);
    }

    public void stop(){
        mediaPlayer.stop();
        synchronized (this){
            isPrepared = false;
        }
    }

    public void onCompletion(MediaPlayer player){
        synchronized (this){
            isPrepared = false;
        }
    }
}
