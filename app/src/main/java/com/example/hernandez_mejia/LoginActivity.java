package com.example.hernandez_mejia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.PrivilegedAction;

public class LoginActivity extends AppCompatActivity {
    private Button login;
    private EditText usuario, pass;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        referencias();
        preferences=getSharedPreferences("tienda_app",MODE_PRIVATE);
        if(preferences.getBoolean("logged",false)){
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
            finish();
        }


    }

    private void referencias(){
        usuario=findViewById(R.id.txtCorreo);
        pass=findViewById(R.id.txtPwd);
        login=findViewById(R.id.btnLogin);
    }
    public  void clickIniciar( View view){
        String PASS="12345";
        String USER= "Fabian";

        String passUser=pass.getText().toString();
        String loginUser=usuario.getText().toString();

        if (PASS.equals(passUser)&&USER.equals(loginUser)){
            SharedPreferences.Editor editor= preferences.edit();
            editor.putBoolean("logged",true);
            editor.apply();
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            finish();




        }else {
        Toast.makeText(this, "Ole mano, credenciales incorrectas", Toast.LENGTH_SHORT).show();
        }
    }
}