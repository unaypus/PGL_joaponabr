/*
 * Copyright (c) 2018.  juaponabr 3º DAM Semipresencial
 */

package com.example.juaponabr.proyectopgljuaponabr3dam.controlador;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.juaponabr.proyectopgljuaponabr3dam.dialogos.DialogoMensaje;
import com.example.juaponabr.proyectopgljuaponabr3dam.R;

public class ListadoClientes extends AppCompatActivity {

    // variables de clase
	
	// botones
    Button bActuaciones;
    Button bNuevoCliente ;
    
	// intentos ( para lanzar activitys )
	Intent intento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate( savedInstanceState                  ) ;
        setContentView( R.layout.activity_listado_clientes  ) ;

        ElListadoClientes laTablaListFragment = new ElListadoClientes();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameLelListado, laTablaListFragment);
        transaction.commit();


        Toolbar toolbar = findViewById(                     R.id.toolbar                ) ;
        setSupportActionBar(                                toolbar                     ) ;
        getSupportActionBar().setHomeAsUpIndicator(         R.drawable.ic_action_home   ) ;
        getSupportActionBar().setDisplayHomeAsUpEnabled(    true                        ) ;

        //activarEscuchadores() ;

        /*
		
		Por el momento no usaremos este botón

		FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intento = new Intent(ListadoClientes.this,EditaCliente.class);
                intento.putExtra( "Nuevo", true );
                startActivity(intento);
            }
        });
		*/

    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {

        getMenuInflater().inflate( R.menu.main, menu ) ;
        return true ;

    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item ) {

        switch ( item.getItemId() ){
            case R.id.action_settings:
                modEnConstruccion() ;
                return true ;
            case R.id.action_help :
                modEnConstruccion( );
                return true ;
        }

        return super.onOptionsItemSelected( item ) ;

    }
	
	/**
	 *
	 * activamos los escuchadores de los botones
	 *
	 */
    private void activarEscuchadores() {

        /*
		// botón para ir al listado de actuaciones
        bActuaciones = findViewById(    R.id.buttonVerContratos) ;
        bActuaciones.setVisibility(     View.VISIBLE                ) ;

        bActuaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(ListadoClientes.this,ListadoContratos.class);
                startActivity(intento);
            }
        });


		// botón para añadir un cliente
        bNuevoCliente = findViewById(R.id.buttonNuevoCliente);

        bNuevoCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intento = new Intent(ListadoClientes.this,EditaCliente.class);
                intento.putExtra( "Nuevo", true );
                startActivity(intento);
            }
        });
        */

    }

    protected void modEnConstruccion() {

        //  Para los módulos en construcción
        FragmentManager manejador   = getFragmentManager();
        DialogoMensaje dMensaje    = new DialogoMensaje(   getString( R.string.txt_titulo_mensaje      )    ,
                getString( R.string.txt_modulo_construccion )    ) ;

        dMensaje.show(manejador,"elDialogoEnConstruccion");

    }

}
