package com.example.proyectofinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> implements View.OnClickListener {

    private ArrayList<productos> arrayProductos;
    private View.OnClickListener listener;
    private String id,producto,categoria, url;
    private boolean disponibilidad;
    private int precio;

    Context context;

    public Adapter(ArrayList<productos> array){
        this.arrayProductos = array;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.datos, null, false);
        ViewHolder viewHolder = new ViewHolder(v);
        v.setOnClickListener(this);
        context = parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        id = arrayProductos.get(position).getId();
        producto = arrayProductos.get(position).getProducto();
        categoria = arrayProductos.get(position).getCategoria();
        disponibilidad = arrayProductos.get(position).isDisponibilidad();
        precio = arrayProductos.get(position).getPrecio();
        url = arrayProductos.get(position).getUrl();

        holder.tv_productos.setText("Producto: "+producto);
        holder.tv_categoria.setText("Categoria: "+categoria);
        holder.tv_precio.setText("Precio: $"+(String.valueOf(precio)));

        Glide.with(context)
                .load(url)
                .into(holder.iv_imagen);
    }

    @Override
    public int getItemCount() {
        return arrayProductos.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_productos,tv_categoria,tv_precio;
        private ImageView iv_imagen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_productos = itemView.findViewById(R.id.tv_producto);
            tv_categoria = itemView.findViewById(R.id.tv_categoria);
            tv_precio = itemView.findViewById(R.id.tv_precio);
            iv_imagen = itemView.findViewById(R.id.iv_producto);

        }
    }
}
