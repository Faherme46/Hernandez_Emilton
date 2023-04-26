package com.example.hernandez_mejia;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.TimeAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hernandez_mejia.adaptadores.ProductoAdapter;
import com.example.hernandez_mejia.clases.Producto;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.Normalizer;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ArrayList<Producto> listaProducto1;
    private RecyclerView recycler;
    private Button btnAgregar;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.listadoproducto));

        recycler=findViewById(R.id.rvlistado);
        btnAgregar=findViewById(R.id.btnAgregar);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, FormularioActivity.class);
                startActivity(i);
            }
        });

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
                FirebaseFirestore firestore= FirebaseFirestore.getInstance();
                firestore.collection("procuctos").document(p.getId()).delete();
                Toast.makeText(MainActivity.this, "Eliminando "+p.getNombre(), Toast.LENGTH_SHORT).show();
                listaProducto1.remove(posicion);
                adapter.setListProductos(listaProducto1);




            }
        });


        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));
    }

    public void cargarDatos(){
        FirebaseFirestore firestore= FirebaseFirestore.getInstance();
        firestore.collection("productos").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for (DocumentSnapshot doc:task.getResult()) {
                        Producto p1= doc.toObject(Producto.class);
                        p1.setId(doc.getId());
                        listaProducto1.add(p1);
                    }
                }else{
                    Toast.makeText(MainActivity.this, "No se pudo conectar al servidor", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }

    public void cerrarSesion(View view){
        SharedPreferences preferences=getSharedPreferences("tienda_app",MODE_PRIVATE);
        SharedPreferences.Editor e=preferences.edit();
        e.putBoolean("logged",false);
        e.apply();

        finish();
    }

    public void agregarProducto(View view){
        startActivity(new Intent(MainActivity.this,FormularioActivity.class));
    }
}

                  