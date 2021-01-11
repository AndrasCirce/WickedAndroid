package com.example.proyectofinal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.ArrayList;

public class edit_producto extends AppCompatActivity {

    private EditText etnombreProducto,etCategoria,etIngredientes,etPrecio;
    private ImageView iv_imagen;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private Uri filepath;

    public String id,producto,ingredientes,categoria,url;
    public int precio;

    private final int PICK_PHOTO = 1;
    private StorageReference storage;

    productos p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_producto);

        etnombreProducto = findViewById(R.id.et_producto);
        etCategoria = findViewById(R.id.et_categoria);
        etIngredientes = findViewById(R.id.et_ingredientes);
        etPrecio = findViewById(R.id.et_precio);
        iv_imagen = findViewById(R.id.imageView);

        inicializarFirebase();

        Bundle datos = this.getIntent().getExtras();

        id = datos.getString("id");
        producto = datos.getString("producto");
        ingredientes = datos.getString("ingredientes");
        categoria = datos.getString("categoria");
        precio = datos.getInt("precio");
        url = datos.getString("url");
        mostrar();
    }

    public void mostrar(){
        etnombreProducto.setText(producto);
        etCategoria.setText(categoria);
        etPrecio.setText(String.valueOf(precio));
        etIngredientes.setText(ingredientes);
        Glide.with(this)
                .load(url)
                .into(iv_imagen);
    }

    public void AbrirFotoGaleria(View view){

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Selecione una imagen"),PICK_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_PHOTO && resultCode == RESULT_OK && data.getData()!=null ){

            filepath = data.getData();

            try {
                Bitmap bitmapImagen = MediaStore.Images.Media.getBitmap(getContentResolver(), filepath);
                iv_imagen.setImageBitmap(bitmapImagen);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void actualizar(View view){
        String ida = id;
        String SProducto = etnombreProducto.getText().toString();
        String SCategoria = etCategoria.getText().toString();
        String SPrecio = etPrecio.getText().toString();
        String SIngredientes = etIngredientes.getText().toString();

        subir(ida,SProducto,SCategoria,SPrecio,SIngredientes);

        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        Limpiarcajas();
    }

    public void subir(final String ida, final String producto, final String categoria, final String precio, final String ingredientes){
        if (filepath!=null) {
            final StorageReference fotoRef = storage.child("Fotos").child(id).child(filepath.getLastPathSegment());
            fotoRef.putFile(filepath).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                @Override
                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                    if (!task.isSuccessful()){
                        throw new Exception();
                    }
                    return fotoRef.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    if(task.isSuccessful()){
                        Uri downloandLink = task.getResult();
                        productos p = new productos();

                        p.setId(ida);
                        p.setProducto(producto);
                        p.setCategoria(categoria);
                        p.setPrecio(Integer.parseInt(precio));
                        p.setIngredientes(ingredientes);
                        p.setDisponibilidad(true);
                        p.setUrl(downloandLink.toString());
                        databaseReference.child("Productos").child(id).setValue(p);

                        Toast.makeText(edit_producto.this, "Se actualizo el producto correctamente", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    public void eliminar(View view){
        databaseReference.child("Productos").child(id).removeValue();
        Toast.makeText(this, "Eliminado", Toast.LENGTH_SHORT).show();
        Limpiarcajas();
    }

    public void inicializarFirebase(){
        FirebaseApp.initializeApp(this);

        firebaseDatabase = FirebaseDatabase.getInstance();
        storage = FirebaseStorage.getInstance().getReference();
        //firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();
    }

    public void Limpiarcajas(){
        etnombreProducto.setText("");
        etCategoria.setText("");
        etIngredientes.setText("");
        etPrecio.setText("");
    }
}
