package com.example.juaponabr.proyectopgljuaponabr3dam;

import android.content.Intent;
import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class ListadoClientes extends AppCompatActivity {

    // variables de clase
	
	// botones
    Button bActuaciones;
    Button bNuevoCliente ;
    
	// intentos ( para lanzar activitys )
	Intent intento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_clientes);
        Toolbar toolbar = findViewById(R.id.toolbar);
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
		
		// botón para ir al listado de actuaciones
        bActuaciones = findViewById(R.id.buttonVerActuaciones);

        bActuaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(ListadoClientes.this,ListadoActuaciones.class);
                startActivity(intento);
            }
        });
		
		// botón para añadir un cliente
        bNuevoCliente = findViewById(R.id.buttonNuevoCliente);

        bNuevoCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intento = new Intent(ListadoClientes.this,EditaCliente.class);
                startActivity(intento);
            }
        });

    }

}
