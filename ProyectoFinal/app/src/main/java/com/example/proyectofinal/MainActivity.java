package com.example.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//verificar lineas de importacion para el recicler view
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;


public class MainActivity extends AppCompatActivity {

    //Variables RecyclerView
    private RecyclerView recyclerView;
    private RecyclerView.Adapter myadapter;
    private RecyclerView.LayoutManager layoutManager;

    //Variables de Firebase
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    //Array de productos
    private ArrayList<productos> arrayListProductos =  new ArrayList<productos>();
    private productos product = new productos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.Recycler);

        inicializarFirebase();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listarDatos();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menunavegacion,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        if (item.getItemId() == R.id.icon_add){
            Intent i = new Intent(this,crear_producto.class);
            startActivity(i);
        }

        return true;
    }

    public void listarDatos() {
        databaseReference.child("Productos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arrayListProductos.clear();
                for (DataSnapshot obj : dataSnapshot.getChildren()){
                    product = obj.getValue(productos.class);
                    arrayListProductos.add(product);

                    myadapter = new Adapter(arrayListProductos);
                    recyclerView.setAdapter(myadapter);
                    ((Adapter) myadapter).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String id = arrayListProductos.get(recyclerView.getChildAdapterPosition(v)).getId();
                            String producto = arrayListProductos.get(recyclerView.getChildAdapterPosition(v)).getProducto();
                            String categoria = arrayListProductos.get(recyclerView.getChildAdapterPosition(v)).getCategoria();
                            String ingredientes = arrayListProductos.get(recyclerView.getChildAdapterPosition(v)).getIngredientes();
                            int precio = arrayListProductos.get(recyclerView.getChildAdapterPosition(v)).getPrecio();
                            String url = arrayListProductos.get(recyclerView.getChildAdapterPosition(v)).getUrl();
                            Toast.makeText(MainActivity.this, "id: "+ id, Toast.LENGTH_SHORT).show();
                            enviarDatos(id,producto,categoria,ingredientes,precio,url);
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void enviarDatos(String id, String producto, String categoria, String ingredientes, int precio, String url){
        Intent i = new Intent(this,edit_producto.class);
        i.putExtra("id",id);
        i.putExtra("producto",producto);
        i.putExtra("categoria",categoria);
        i.putExtra("ingredientes",ingredientes);
        i.putExtra("precio",precio);
        i.putExtra("url",url);
        startActivity(i);
    }

    public void inicializarFirebase(){
        FirebaseApp.initializeApp(this);

        firebaseDatabase = FirebaseDatabase.getInstance();
        //firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();
    }

}
