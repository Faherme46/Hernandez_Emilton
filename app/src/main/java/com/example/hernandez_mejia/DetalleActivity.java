package com.example.hernandez_mejia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hernandez_mejia.clases.Producto;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class DetalleActivity extends AppCompatActivity {

    private TextView txtTitulo, txtPrecio;
    private ImageView imgDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        setTitle(getString(R.string.detalleproducto));

        txtPrecio=findViewById(R.id.txtPrecio);
        txtTitulo=findViewById(R.id.txtTitulo);
        imgDetalle=findViewById(R.id.imgDetalle);

        Producto p= (Producto) getIntent().getSerializableExtra("producto");

        txtPrecio.setText(p.getPrecio().toString());
        txtTitulo.setText(p.getNombre());

        Picasso.get().load(p.getUrlImg())
                .error(R.drawable.ic_launcher_background)
                .into(imgDetalle);

    }
}