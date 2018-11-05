package com.example.juaponabr.proyectopgljuaponabr3dam;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 *
 * /////////////////////////////////////////////////////////////////////////////////////////////////
 *
 *
 *
 * Proyecto     :   ProyectoPGLjuaponabr3DAM
 *
 * Finalidad    :   Acceder a la base de datos de las actuaciones de JPLM para consultarla y añadir
 *                  o editar actuaciones y/o clientes.
 *
 * Autor        :   Juan Pons Abraham
 *
 * Alumno       :   juaponaber
 *
 * Curso/grupo  :   2018/19 - 3º DAM Semipresencial
 *
 *
 *
 * /////////////////////////////////////////////////////////////////////////////////////////////////
 *
 *  Histórico
 *
 *  de lo mas nuevo a lo mas antiguo
 *
 * /////////////////////////////////////////////////////////////////////////////////////////////////
 *
 *      Lunes   05/11/2018 10:13
 *
 * /////////////////////////////
 *
 * commit 'La navegación por pestañas deslizantes está implementada y funciona'. El siguiente
 * paso será decidir exactamente cuales van a ser la cantidad y los contenidos de cada una de
 * las pestañas, para luego decir si se elima del todo o no la navegación por botones.
 *
 * /////////////////////////////////////////////////////////////////////////////////////////////////
 *
 *      Domingo 04/11/2018 11:06
 *
 * /////////////////////////////
 *
 * Aunque pareciese redundante se realizará otro "commit" y posteriormnte crearemos una subrama
 * dentro de -entrega2- para asegurar  que no rompemos nada y poder volver en  caso de desastre
 *
 * La nueva rama  en cuestión se  llamara 'navegaPestanyas' y  para el "commit"  pondremos  el
 * comentario ' Preparación para la navegación por pestañas deslizantes '
 *
 * /////////////////////////////////////////////////////////////////////////////////////////////////
 *
 *      Domingo 04/11/2018 10:43
 *
 * /////////////////////////////
 *
 * Vamos ha dar por finalizada la navegación por botones y se pasará a la navegación por pestañas
 * deslizantes.
 *
 * Con la finalidad de poder seguir mas adelante con la navegación por botones o en caso de fallo
 * general en el nuevo diseño de navegación por pestañas, realizaremos un "commit" de este estado
 * con el comentario ' Navegación por botones terminada y estable '
 *
 * /////////////////////////////////////////////////////////////////////////////////////////////////
 *
 *      Viernes 26/10/2018 11:05
 *
 * /////////////////////////////
 *
 * Iniciamos la rama (branch) entrega2 con la edición de este comentario
 * gracias al cual comprobaremos que:
 *
 * 1 - la rama entrega1 ha sido mezclada correctamente con master
 * 2 - la rama entrega2 está creada a partir de la unión de master y entrega1
 * 3 - se realizará un push para que el githup esté igual que el git local
 *
 * /////////////////////////////////////////////////////////////////////////////////////////////////
 *
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


//DialogoCerrar.EscuchadorDialogoCerrar,
    // variables de clase
	
	// botones
    Button  bActuaciones    ;
    Button  bNuevaActuacion ;
    Button  bClientes       ;
    Button  bNuevoCliente   ;
    Button  bSalir          ;
	
	// intentos ( para lanzar activitys )
    Intent  intento         ;

	/**
	 *
	 * Crear e iniciar la activity
	 *
	 */
    @Override
    protected void onCreate( Bundle savedInstanceState ) {

        super.onCreate( savedInstanceState      )   ;
        setContentView( R.layout.activity_main  )   ;

        // Crear la barra de herramientas
        Toolbar toolbar = findViewById( R.id.toolbar ) ;
        setSupportActionBar( toolbar ) ;

        // Ahora no me acuerdo de que es esto
        // ¿ sera el menú emergente ?
        DrawerLayout drawer = findViewById( R.id.drawer_layout ) ;

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(   this                                ,
                drawer                              ,
                toolbar                             ,
                R.string.navigation_drawer_open     ,
                R.string.navigation_drawer_close    ) ;

        drawer.addDrawerListener( toggle )  ;
        toggle.syncState()                  ;

        // La vista de navegación por las pestañas
        NavigationView navigationView = findViewById( R.id.nav_view ) ;
        navigationView.setNavigationItemSelectedListener( this ) ;



        activarEscuchadores()                       ;

    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = findViewById( R.id.drawer_layout ) ;

        if ( drawer.isDrawerOpen( GravityCompat.START ) ) {
            drawer.closeDrawer( GravityCompat.START ) ;
        } else {
            super.onBackPressed() ;
        }

    }


    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.main, menu ) ;
        return true ;

    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item ) {

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId() ;

        //noinspection SimplifiableIfStatement
        if ( id == R.id.action_settings ) {
            return true ;
        }

        return super.onOptionsItemSelected( item ) ;
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected( MenuItem item ) {

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } else if (id == R.id.nav_secciones) {
            Intent intento = new Intent( getApplicationContext(), SeccionesActivity.class ) ;
            startActivity( intento ) ;
        }

        DrawerLayout drawer = findViewById (R.id.drawer_layout ) ;
        drawer.closeDrawer( GravityCompat.START ) ;
        return true ;
    }







	/**
	 *
	 * activamos los escuchadores de los botones
	 *
	 */
    private void activarEscuchadores() {

        ////////////////////////////////////////////////////////////////////////////////////////////
        //
        //  Botones Navegación entre Activitys      ////////////////////////////////////////////////
        //
        ////////////////////////////////////////////
        //
		//	botones actuaciones
		//
        ////////////////////////////////////////////
        //
        // botón para ir al listado de actuaciones
		//

        bActuaciones = findViewById( R.id.buttonActuaciones ) ;

        bActuaciones.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick( View v ) {

                intento = new Intent( MainActivity.this, ListadoActuaciones.class ) ;
                startActivity( intento ) ;

            }

        }) ;

        ////////////////////////////////////////////
        //
        // botón para crear una nueva
        //

		bNuevaActuacion = findViewById( R.id.buttonNueva ) ;

        bNuevaActuacion.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick( View v ) {

                intento = new Intent( MainActivity.this, EditaActuacion.class ) ;
                startActivity( intento ) ;

            }

        }) ;

        ////////////////////////////////////////////
        //
		//	botones cliente
		//
        ////////////////////////////////////////////
        //
        // botón para ir al listado de clientes
		//

        bClientes = findViewById( R.id.buttonClientes ) ;

        bClientes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick( View v ) {

                intento = new Intent( MainActivity.this, ListadoClientes.class ) ;
                startActivity( intento ) ;

            }

        }) ;

        ////////////////////////////////////////////
        //
        // botón para crear uno nuevo
        //

        bNuevoCliente = findViewById( R.id.buttonNuevo ) ;

        bNuevoCliente.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick( View v ) {

                intento = new Intent( MainActivity.this, EditaCliente.class ) ;
                startActivity( intento ) ;

            }

        }) ;

        ////////////////////////////////////////////
        //
        // botón de salida
		//
		// que lanza un cuadro de dialogo para preguntar
		// al usuario si desea cerrar la aplicación
		//

		bSalir = findViewById( R.id.buttonSalir ) ;

        bSalir.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick( View v ) {

                FragmentManager manejador   = getFragmentManager()  ;
                DialogoCerrar   dCerrar     = new DialogoCerrar()   ;

                dCerrar.show( manejador, "elDialogoCerrar" )        ;

            }

        }) ;

    }

	/**
	 *
	 * método del interface EscuchadorDialogoCerrar
	 * que cierra la aplicación y libera la memoria
	 *
	 */
    /*@Override
    public void DialogoCerrarClickPositivo( DialogFragment dialog ) {
		
		///////////////////////////////////////////////////////
		//
        // Hay dos dos acciones que cierran la aplicación
		//
		// Esta solo cierra las ventanas y sigue estando
		// en memoria
		//
        //		MainActivity.super.finish();
		//
		// Esta otra cierra la aplicación y libera la memoria
		//
        //		MainActivity.super.finishAndRemoveTask();
		//
        // usamos la segunda forma porque queromas cerrar la 
		// aplicación del todo
		//
		
        MainActivity.super.finishAndRemoveTask() ;

    }*/
	
	/**
	 *
	 * método del interface EscuchadorDialogoCerrar
	 * que no hace nada y permite seguir con la aplicación
	 *
	 */
    /*@Override
    public void DialogoCerrarClickNegativo( DialogFragment dialog ) {

        // no hacer nada y volver al MainActivity

    }*/
	
}
