package com.example.hernandez_mejia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hernandez_mejia.clases.Producto;
import com.google.firebase.firestore.FirebaseFirestore;

public class FormularioActivity extends AppCompatActivity {

    EditText txtNombre,txtPrecio,txtImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        txtImg=findViewById(R.id.txtImg);
        txtNombre=findViewById(R.id.txtNombre);
        txtPrecio=findViewById(R.id.txtPrecio);

    }
    public void guardar(View view){
        Producto p= new Producto();
        p.setNombre(txtNombre.getText().toString());
        p.setPrecio(Double.parseDouble(txtPrecio.getText().toString()));
        p.setUrlImg(txtImg.getText().toString());

        FirebaseFirestore firestore= FirebaseFirestore.getInstance();
        firestore.collection("productos").add(p);
        Toast.makeText(this, "Producto guardado", Toast.LENGTH_SHORT).show();
        finish();
    }
}