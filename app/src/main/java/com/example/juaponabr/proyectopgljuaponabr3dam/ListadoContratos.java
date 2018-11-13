package com.example.juaponabr.proyectopgljuaponabr3dam;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ListadoContratos extends AppCompatActivity {

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
		
        super.onCreate( savedInstanceState                      ) ;
        setContentView( R.layout.activity_listado_contratos) ;

        Toolbar toolbar = findViewById( R.id.toolbar    ) ;
        setSupportActionBar(            toolbar         ) ;

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

        getSupportActionBar().setHomeAsUpIndicator( R.drawable.ic_action_home ) ;
        getSupportActionBar().setDisplayHomeAsUpEnabled( true ) ;

        activarEscuchadores() ;
		
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

        /**/
		// botón para ir al listado de clientes
        bClientes = findViewById(   R.id.buttonVerClientes  ) ;
        bClientes.setVisibility(    View.VISIBLE            ) ;

        bClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(ListadoContratos.this,ListadoClientes.class);
                startActivity(intento);
            }
        });
		/**/
		// botón para añadir una actuación
		bNuevaActuacion = findViewById(R.id.buttonNuevoContrato);

        bNuevaActuacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intento = new Intent(ListadoContratos.this,EditaContrato.class);
                startActivity(intento);
            }
        });

    }

    protected void modEnConstruccion() {

        //  Para los módulos en construcción
        FragmentManager manejador   = getFragmentManager();
        DialogoMensaje  dMensaje    = new DialogoMensaje(   getString( R.string.txt_titulo_mensaje      )    ,
                getString( R.string.txt_modulo_construccion )    ) ;

        dMensaje.show(manejador,"elDialogoEnConstruccion");

    }

}
