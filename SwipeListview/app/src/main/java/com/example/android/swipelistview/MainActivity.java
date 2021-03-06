package com.example.android.swipelistview;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SwipeMenuListView listview = (SwipeMenuListView) findViewById(R.id.listView);

        ArrayList<String> DeathList = new ArrayList<>();
        DeathList.add("Circe");
        DeathList.add("andras");
        DeathList.add("Lvia");
        DeathList.add("Qaro");
        DeathList.add("Diane");
        DeathList.add("X");
        DeathList.add("DElva");
        DeathList.add("Xeren");
        DeathList.add("Hawwah");

        ArrayAdapter adaptador = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, DeathList);
        listview.setAdapter(adaptador);

        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                        0xCE)));
                // set item width
                openItem.setWidth(170);
                // set item title
                openItem.setTitle("Open");
                // set item title fontsize
                openItem.setTitleSize(18);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(170);
                // set a icon
                deleteItem.setIcon(R.drawable.ic_telefono);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };

        // set creator
        listview.setMenuCreator(creator);


        listview.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        Log.d(TAG, "onMenuItemClick: elemento seleccionado: "+ index);
                        break;
                    case 1:
                        Log.d(TAG, "onMenuItemClick: elemento seleccionado: "+ index);
                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }
        });
    }
}
