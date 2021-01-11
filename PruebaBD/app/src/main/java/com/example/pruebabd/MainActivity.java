package com.example.pruebabd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pruebabd.model.Cocktail;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private List <Cocktail> listCocktail = new ArrayList<Cocktail>();
    ArrayAdapter <Cocktail> arrayAdapterCocktail;

    EditText nombC,desC,preC;
    ListView lv_cocktails;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    Cocktail cocktailSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombC = findViewById(R.id.txt_nombre);
        desC = findViewById(R.id.txt_descripcion);
        preC = findViewById(R.id.txt_precio);

        lv_cocktails = findViewById(R.id.lv_cocktails);
        inicializarFirebase();
        listaDatos();

        lv_cocktails.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cocktailSelected = (Cocktail) parent.getItemAtPosition(position);
                nombC.setText(cocktailSelected.getNombre());
                desC.setText(cocktailSelected.getDescripcion());
                preC.setText(cocktailSelected.getPrecio());
            }
        });
    }

    private void listaDatos() {
        databaseReference.child("Cocktail").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listCocktail.clear();
                for (DataSnapshot objSnapshot: dataSnapshot.getChildren()){
                    Cocktail C = objSnapshot.getValue(Cocktail.class);
                    listCocktail.add(C);

                    arrayAdapterCocktail = new ArrayAdapter<Cocktail>(MainActivity.this, android.R.layout.simple_list_item_1, listCocktail);
                    lv_cocktails.setAdapter(arrayAdapterCocktail);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String nombre = nombC.getText().toString();
        String descripcion = desC.getText().toString();
        String precio = preC.getText().toString();
        
        switch (item.getItemId()){
            case R.id._icon_add:{
                if(nombre.equals("")||descripcion.equals("")||precio.equals("")){
                    validacion();
                    //break;
                } else {
                    Cocktail c = new Cocktail();
                    c.setUid(UUID.randomUUID().toString());
                    c.setNombre(nombre);
                    c.setDescripcion(descripcion);
                    c.setPrecio(Integer.parseInt(precio));
                    databaseReference.child("Cocktail").child(c.getUid()).setValue(c);
                    Toast.makeText(this, "Agregar", Toast.LENGTH_SHORT).show();
                    limpiarCajas();
                    break;
                }
            }
            case R.id._icon_save:{
                Cocktail c = new Cocktail();
                c.setUid(cocktailSelected.getUid());
                c.setNombre(nombC.getText().toString().trim());
                c.setDescripcion(desC.getText().toString().trim());
                //c.setPrecio(Integer.parseInt(preC.getText());
                databaseReference.child("Cocktail").child(c.getUid()).setValue(c);
                Toast.makeText(this,"Guardar",Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id._icon_delete:{
                Cocktail c = new Cocktail();
                c.setUid(cocktailSelected.getUid());
                databaseReference.child("Cocktail").child(c.getUid()).removeValue();
                Toast.makeText(this,"Borrar",Toast.LENGTH_SHORT).show();
                limpiarCajas();
                break;
            }
            default:break;


        }
        return true;
    }

    private void limpiarCajas() {
        nombC.setText("");
        desC.setText("");
        preC.setText("");
    }

    private void validacion() {
        String nombre = nombC.getText().toString();
        String descripcion = desC.getText().toString();
        String precio = preC.getText().toString();
        if(nombre.equals("")){
            nombC.setError("Required");
        }
        else if(descripcion.equals("")){
            desC.setError("Required");
        }
        else if(precio.equals("")){
            preC.setError("Required");
        }
    }
}