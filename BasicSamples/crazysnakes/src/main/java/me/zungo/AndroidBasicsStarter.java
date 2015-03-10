package me.zungo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by stephen on 3/2/15.
 */
public class AndroidBasicsStarter extends ListActivity {
    String tests[] = {"SnakesVsMice", "LifeCycleTest", "SingleTouchTest", "MultiTouchTest",
        "KeyTest", "AccelerometerTest", "AssetsTest",
        "ExternalStorageTest", "RenderViewTest", "ShapeTest",
        "FullScreenTest", "RenderViewTest", "ShapeTest", "BitMapTest",
        "FontTest", "SurfaceViewTest"
    };

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tests));
    }

    @Override
    protected void onListItemClick(ListView list, View view, int position, long id){
        super.onListItemClick(list, view, position, id);
        String testName = tests[position];
        try{
            Log.d("ClassName", testName);
            Class clazz = Class.forName("me.zungo." + testName);
            Intent intent = new Intent(this, clazz);
            startActivity(intent);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
