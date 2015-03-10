package me.zungo;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

/**
 * Created by stephen on 3/2/15.
 */
public class KeyTest extends Activity implements View.OnKeyListener  {
    StringBuilder builder = new StringBuilder();
    TextView textView;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Context is THIS ACTIBITY!!
        textView = new TextView(this);
        textView.setText("Press keys (if you have some) !");
        textView.setOnKeyListener(this);
        textView.setFocusableInTouchMode(true);
        textView.requestFocus();
        setContentView(textView);
    }

    public boolean onKey(View view, int keyCode, KeyEvent event){
        builder.setLength(0);
        switch(event.getAction()){
            case KeyEvent.ACTION_DOWN:
                builder.append("down, ");
                break;
            case KeyEvent.ACTION_UP:
                builder.append("up, ");
                break;

        }
        builder.append(event.getKeyCode());
        builder.append(", ");
        builder.append((char) event.getUnicodeChar());
        String text = builder.toString();
        Log.d("KeyTest", text);
        textView.setText(text);

        return event.getKeyCode() != KeyEvent.KEYCODE_BACK;
    }


}
