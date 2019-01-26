package com.example.android.acorazadov3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridLayout;

public class GridAdapter extends BaseAdapter {

    private Button botones[];
    private int botones1[];
    private Context context;
    private LayoutInflater inflater;


    public GridAdapter(Context context, Button[] botones){
        this.context = context;
        this.botones1 = botones1;
    }

    @Override
    public int getCount() {
        return botones1.length;
    }

    @Override
    public Object getItem(int position) {
        return botones1[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridView = convertView;
        if (convertView == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridView =  inflater.inflate(R.layout.definir_tabla, null);

        }

        Button b = (Button) gridView.findViewById(R.id.botoncito);

        return gridView;
    }
}
