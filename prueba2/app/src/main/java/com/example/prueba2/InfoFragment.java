package com.example.prueba2;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.prueba2.model.Cocktail;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class InfoFragment extends Fragment {
    EditText nombC,desC,preC;
    Button guardar, editar, borrar;

    public InfoFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //guardar = (Button)  getView().findViewById(R.id.btn_guardar);
        Toast.makeText(getActivity(),"Hola",Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

}


