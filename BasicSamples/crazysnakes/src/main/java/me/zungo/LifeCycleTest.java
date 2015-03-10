package me.zungo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by stephen on 3/2/15.
 */
public class LifeCycleTest extends Activity {
    StringBuilder builder = new StringBuilder();
    TextView textView;

    private void log(String text){
        Log.d("LifeCycleTest", text);
        builder.append(text);
        builder.append('\n');
        textView.setText(builder.toString());
    }

    @Override
    public void onCreate(Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
        textView = new TextView(this);
        textView.setText(builder.toString());
        setContentView(textView);
        log("created");
    }

    @Override
    protected void onResume(){
        super.onResume();
        log("resumed");
    }

    @Override
    protected  void onPause(){
        super.onPause();
        log("paused");

        if(isFinishing()){
            log("finishing");
        }
    }
}
