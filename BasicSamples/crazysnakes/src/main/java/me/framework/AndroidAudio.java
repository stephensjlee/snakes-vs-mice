package me.framework;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;

import java.io.IOException;

/**
 * Created by stephen on 3/2/15.
 */
public class AndroidAudio implements Audio {
    AssetManager assets;
    SoundPool soundPool;

    public AndroidAudio(Activity activity){
        activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        this.assets = activity.getAssets();
        //20 sounds in parallel
        this.soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);
    }

    public Music newMusic(String filename){
        try{
            AssetFileDescriptor assetFileDescriptor = assets.openFd(filename);
            return new AndroidMusic(assetFileDescriptor);
        } catch(IOException e){
            throw new RuntimeException("Couldn't load music '"+filename+"'");
        }
    }

    public Sound newSound(String filename){
        try{
            AssetFileDescriptor assetFileDescriptor=assets.openFd(filename);
            int soundId = soundPool.load(assetFileDescriptor, 0);
            return new AndroidSound(soundPool, soundId);
        }
        catch (IOException e){
            throw new RuntimeException("Couldn't load sound '" + filename + "'");
        }
    }
}
