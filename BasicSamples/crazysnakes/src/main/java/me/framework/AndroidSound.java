package me.framework;

import android.media.SoundPool;

/**
 * Created by stephen on 3/2/15.
 */
public class AndroidSound implements Sound {
    int soundId;
    SoundPool soundPool;

    public AndroidSound(SoundPool soundPool, int soundId){
        this.soundId = soundId;
        this.soundPool =soundPool;
    }

    public void play(float volume){
        soundPool.play(soundId, volume, volume, 0,0,1);
    }

    public void dispose(){
        soundPool.unload(soundId);
    }
}
