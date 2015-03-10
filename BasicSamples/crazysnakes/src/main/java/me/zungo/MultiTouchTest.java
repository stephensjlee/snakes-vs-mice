package me.zungo;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * Created by stephen on 3/2/15.
 * TODO: Review later
 */
public class MultiTouchTest extends Activity implements View.OnTouchListener{
    StringBuilder builder = new StringBuilder();
    TextView textView;
    float[] x = new float[10];
    float[] y = new float[10];
    boolean[] touched = new boolean[10];
    int[] id = new int[10];

    private void updateTextView(){
        builder.setLength(0);
        for(int i = 0; i < 10; i++){
            builder.append(touched[i]);
            builder.append(", ");
            builder.append(id[i]);
            builder.append(", ");
            builder.append(x[i]);
            builder.append(", ");
            builder.append(y[i]);
            builder.append("\n");
        }
        textView.setText(builder.toString());
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        textView = new TextView(this);
        textView.setText("Touch and drag (multiple fingers supported)!");
        textView.setOnTouchListener(this);
        setContentView(textView);
        for(int i = 0; i < 10; i++){
            id[i] = -1;
        }
        updateTextView();
    }

    public boolean onTouch(View v, MotionEvent event){
        int action = event.getAction() & MotionEvent.ACTION_MASK;
        int pointerIndex = (event.getAction() & MotionEvent.ACTION_POINTER_ID_MASK) >> MotionEvent.ACTION_POINTER_ID_SHIFT;
        int pointerCount = event.getPointerCount();
        for(int i = 0; i < 10; i++){
            if (i >= pointerCount){
                touched[i] = false;
                id[i] = -1;
                continue;
            }
            if(event.getAction() != MotionEvent.ACTION_MOVE && i != pointerIndex){
                //if it's up/down/canvel/out event, mask id to see if we could process for touch input
                continue;
            }
            int pointerId = event.getPointerId(i);
            switch(action){
                case MotionEvent.ACTION_DOWN:
                case MotionEvent.ACTION_POINTER_DOWN:
                    touched[i] = true;
                    id[i] = pointerId;
                    x[i] = (int) event.getX(i);
                    y[i] = (int) event.getY(i);
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_POINTER_UP:
                case MotionEvent.ACTION_OUTSIDE:
                //case MotionEvent.ACTION_CANCEL:
                    touched[i] = false;
                    id[i] = -1;
                    x[i] = (int) event.getX(i);
                    y[i] = (int) event.getY(i);
                    break;

                case MotionEvent.ACTION_MOVE:
                    touched[i] = true;

            }
        }
        updateTextView();
        return true;
    }
}
