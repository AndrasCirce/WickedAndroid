package com.example.proyectofinal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

public class crear_producto extends AppCompatActivity {

    private EditText etproducto,etCategoria,etPrecio,etingredientes;
    private ImageView iv_perfil;

    //Variables de Firebase
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    private Uri filepath;
    private StorageReference storage;

    private ProgressDialog pd;

    private final int PICK_PHOTO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_producto);

        etproducto = findViewById(R.id.et_producto);
        etCategoria = findViewById(R.id.et_categoria);
        etingredientes = findViewById(R.id.et_ingredientes);
        etPrecio = findViewById(R.id.et_precio);
        iv_perfil = findViewById(R.id.iv_imagen);

        pd = new ProgressDialog(this);
        pd.setMessage("Subiendo...");

        inicializarFirebase();

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
                iv_perfil.setImageBitmap(bitmapImagen);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void crear(View view){
        String SProducto = etproducto.getText().toString();
        String SCategoria = etCategoria.getText().toString();
        String SPrecio = etPrecio.getText().toString();
        String SIngredientes = etingredientes.getText().toString();

        int r = (int) (Math.random()*100);
        validacion();

        subir("prod-"+r,SProducto,SCategoria,SPrecio,SIngredientes);

        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        Limpiarcajas();
    }

    public void subir(final String id, final String producto, final String categoria, final String precio, final String ingredientes){
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

                        p.setId(id);
                        p.setProducto(producto);
                        p.setCategoria(categoria);
                        p.setPrecio(Integer.parseInt(precio));
                        p.setIngredientes(ingredientes);
                        p.setDisponibilidad(true);
                        p.setUrl(downloandLink.toString());
                        databaseReference.child("Productos").child(p.getId()).setValue(p);

                        Toast.makeText(crear_producto.this, "Se cargo el producto correctamente", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    public void validacion(){
        String SProducto = etproducto.getText().toString();
        String SCategoria = etCategoria.getText().toString();
        String SPrecio = etPrecio.getText().toString();
        String SIngredientes = etingredientes.getText().toString();

        if (SProducto.equals("")){
            etproducto.setError("Requerid");
        } else if (SCategoria.equals("")){
            etCategoria.setError("Requerid");
        } else if (SIngredientes.equals("")){
            etingredientes.setError("Requerid");
        } else if (SPrecio.equals("")){
            etPrecio.setError("Requerid");
        }
    }

    public void Limpiarcajas(){
        etproducto.setText("");
        etCategoria.setText("");
        etingredientes.setText("");
        etPrecio.setText("");

    }

    public void inicializarFirebase(){
        FirebaseApp.initializeApp(this);

        firebaseDatabase = FirebaseDatabase.getInstance();
        storage = FirebaseStorage.getInstance().getReference();
        //firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();
    }
}
