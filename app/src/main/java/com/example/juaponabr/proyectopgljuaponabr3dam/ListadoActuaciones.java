package com.example.juaponabr.proyectopgljuaponabr3dam;

import android.content.Intent;
import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class ListadoActuaciones extends AppCompatActivity {

    // variables de clase
	
	// botones
    Button bClientes;
	Button bNuevaActuacion ;
	
	// intentos ( para lanzar activitys )
    Intent intento;
	
	/**
	 *
	 * Crear e iniciar la activity
	 *
	 */	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
		
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_actuaciones);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        /*
		
		Por el momento no usaremos este botón
		
		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
		*/

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activarEscuchadores();
		
    }
	
	/**
	 *
	 * activamos los escuchadores de los botones
	 *
	 */
    private void activarEscuchadores() {

        /*
		// botón para ir al listado de clientes
        bClientes = findViewById(R.id.buttonVerClientes);

        bClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(ListadoActuaciones.this,ListadoClientes.class);
                startActivity(intento);
            }
        });
		*/
		// botón para añadir una actuación
		bNuevaActuacion = findViewById(R.id.buttonNuevaActuacion);

        bNuevaActuacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intento = new Intent(ListadoActuaciones.this,EditaActuacion.class);
                startActivity(intento);
            }
        });

    }

}
