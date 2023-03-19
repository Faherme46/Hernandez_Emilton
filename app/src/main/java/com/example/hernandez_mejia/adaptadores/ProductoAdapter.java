package com.example.hernandez_mejia.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hernandez_mejia.MainActivity;
import com.example.hernandez_mejia.R;
import com.example.hernandez_mejia.clases.Producto;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolder>{
    private ArrayList<Producto> listProductos;
    private OnItemClickListener onItemClickListener;

    public ProductoAdapter(ArrayList<Producto> listProductos) {
        this.listProductos = listProductos;
        this.onItemClickListener=null;
    }

    public void setListProductos(ArrayList<Producto> listProductos) {
        this.listProductos = listProductos;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ProductoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listview,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoAdapter.ViewHolder holder, int position) {
        Producto p=listProductos.get(position);
        holder.enlazar(p);
    }

    @Override
    public int getItemCount() {
        return listProductos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView nombre,precio;
        private Button btnEliminar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre= itemView.findViewById(R.id.txtname_item);
            precio=itemView.findViewById(R.id.txtprecio_item);
            img=itemView.findViewById(R.id.imgItem);
            btnEliminar=itemView.findViewById(R.id.btnEliminar);

        }
        public void enlazar(Producto p){
            nombre.setText(p.getNombre());
            precio.setText(p.getPrecio().toString());
            Picasso.get().load(p.getUrlImg())
                    .error(R.drawable.ic_launcher_background)
                    .into(img);

            if(onItemClickListener!=null){
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemClickListener.onItemClick(p,getAdapterPosition());
                    }
                });
                btnEliminar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemClickListener.onItemEliminarBtn(p,getAdapterPosition());
                    }
                });
            }

        }
    }

    public interface OnItemClickListener{
        void onItemClick(Producto p, int posicion);
        void onItemEliminarBtn(Producto p, int posicion);

    }
}
