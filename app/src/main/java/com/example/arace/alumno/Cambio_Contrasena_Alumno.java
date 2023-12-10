package com.example.arace.alumno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.arace.R;
import com.example.arace.bbdd.DB_Conexion;

public class Cambio_Contrasena_Alumno extends AppCompatActivity {
    private EditText TXT_PAS, TXT_REP_CON;
        private Button btnInSesion3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambio_contrasena_alumno);
        btnInSesion3=(Button) findViewById(R.id.btnInSesion3);
        TXT_PAS=(EditText) findViewById(R.id.txtContraseñaNueva);
        TXT_REP_CON=(EditText) findViewById(R.id.txtRepCon2);
        DB_Conexion dbC=new DB_Conexion(this);
        SQLiteDatabase db= dbC.getWritableDatabase();
        btnInSesion3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String V_PAS = TXT_PAS.getText().toString();
                String V_REP_CON = TXT_REP_CON.getText().toString();
                String u=getIntent().getStringExtra("Usuario");

                if (!V_PAS.isEmpty() && !V_REP_CON.isEmpty()) {

                    if (V_PAS.equals(V_REP_CON)) {
                        String sql = "UPDATE Usuarios SET Contraseña = ? WHERE CodigoSecreto = ?";
                        String[] bindArgs = {V_PAS, u};
                        db.execSQL(sql, bindArgs);
                        Intent i = new Intent(Cambio_Contrasena_Alumno.this, Inicio_Sesion_Alumno.class);
                        startActivity(i);
                        Toast.makeText(getApplicationContext(), " La contraseña se ha modificado", Toast.LENGTH_LONG).show();

                    } else if (!V_REP_CON.equals(V_PAS)) {
                        Toast.makeText(getApplicationContext(), " La contraseña no coincide", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Campos vacios", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    public void onClick(View view) {

        Intent e=new Intent(Cambio_Contrasena_Alumno.this, Cod_Secreto_Alumno.class);
        startActivity(e);
    }
}