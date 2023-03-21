package com.example.hernandez_mejia;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.TimeAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hernandez_mejia.adaptadores.ProductoAdapter;
import com.example.hernandez_mejia.clases.Producto;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ArrayList<Producto> listaProducto1;
    private RecyclerView recycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.listadoproducto));

        recycler=findViewById(R.id.rvlistado);

        cargarDatos();
        ProductoAdapter adapter=new ProductoAdapter(listaProducto1);
        adapter.setOnItemClickListener(new ProductoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Producto p, int posicion) {
                Intent i= new Intent(MainActivity.this,DetalleActivity.class);
                i.putExtra("producto", p);
                startActivity(i);
            }

            @Override
            public void onItemEliminarBtn(Producto p, int posicion) {
                Toast.makeText(MainActivity.this, "Eliminando "+p.getNombre(), Toast.LENGTH_SHORT).show();
                listaProducto1.remove(posicion);
                adapter.setListProductos(listaProducto1);
            }
        });


        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));
    }

    public void cargarDatos(){
        Producto p1=new Producto("Computador","https://static.vecteezy.com/system/resources/thumbnails/001/203/930/small/computer.png",3000000.0);

        Producto p3=new Producto("Mouse","https://static.vecteezy.com/system/resources/previews/001/203/999/non_2x/mouse-computer-png.png",300000.0);

        Producto p2=new Producto("Teclado","https://static.vecteezy.com/system/resources/previews/009/383/884/original/laptop-device-clipart-design-illustration-free-png.png",30000.0);

        listaProducto1=new ArrayList<>();
        listaProducto1.add(p1);
        listaProducto1.add(p2);
        listaProducto1.add(p3);
        listaProducto1.add(p1);
        listaProducto1.add(p2);
        listaProducto1.add(p3);
        listaProducto1.add(p1);
        listaProducto1.add(p2);
        listaProducto1.add(p3);


    }
}