/*
 * Copyright (c) 2018.  juaponabr 3º DAM Semipresencial
 */

package com.example.juaponabr.proyectopgljuaponabr3dam;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.juaponabr.proyectopgljuaponabr3dam.dialogos.DialogoCerrar;
import com.example.juaponabr.proyectopgljuaponabr3dam.dialogos.DialogoMensaje;
import com.example.juaponabr.proyectopgljuaponabr3dam.secciones.GaleriaPhotos;
import com.example.juaponabr.proyectopgljuaponabr3dam.secciones.GestionDatos;

////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                        //
//                               DUDAS A RESOLVER                                         //
//                                                                                        //
////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                        //
//                      A T E N C I Ó N  -  P R E G U N T A                               //
//                                                                                        //
//      clase GestionDatos                                                                   //
//      boton flotante  y menú para todas las pestañas                                    //
//                                                                                        //
//      No puedo usar la variable quePestanya para saber en que pestaña estoy. Al         //
//      parecer cuando  se carga en  SectionsPagerAdapter no  se recarga  en cada         //
//      pasada del dedo                                                                   //
//                                                                                        //
//      ¿ Como puedo saber en que pestaña estoy ?                                         //
//                                                                                        //
//                                                                                        //
////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                        //
//                      A T E N C I Ó N  -  P R E G U N T A                               //
//                                                                                        //
//      clase ElListadoClientes                                                           //
//      String LOGTAG                                                                     //
//                                                                                        //
//                                                                                        //
//      ¿ A que se refiere esta variable ?                                                //
//                                                                                        //
//                                                                                        //
////////////////////////////////////////////////////////////////////////////////////////////


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
 *      Domingo   18/11/2018 15:10
 *
 * /////////////////////////////
 *
 *  Terminada la rama entrega3 lista para corregir, pero por el momento no se unirá a master
 *  hasta que no esté realizada toda la reestructuración de clases y limpieza de código
 *
 * commit 'Terminada rama entrega3 pero no está lista para el merge con master'
 *
 * /////////////////////////////////////////////////////////////////////////////////////////////////
 *
 *      Domingo   18/11/2018 13:03
 *
 * /////////////////////////////
 *
 *  Terminado el CRUD de Clientes procederemos a la limpieza y reorganización de las clases
 *
 * commit 'Terminado CRUD Clientes reordenar clases'
 *
 * /////////////////////////////////////////////////////////////////////////////////////////////////
 *
 *      Domingo   18/11/2018 10:20
 *
 * /////////////////////////////
 *
 *  Aseguramos la nueva rama
 *
 * commit 'Empezamos con la navegación solo de pestañas'
 *
 * /////////////////////////////////////////////////////////////////////////////////////////////////
 *
 *      Domingo   18/11/2018 10:12
 *
 * /////////////////////////////
 *
 *  Se ha cometido un errror durante el commit se va ha repetir.
 *
 * commit 'Se creara la rama 'navPestanyasDefinitiva' y abandonamos los botones'
 *
 * /////////////////////////////////////////////////////////////////////////////////////////////////
 *
 *      Domingo   18/11/2018 10:10
 *
 * /////////////////////////////
 *
 *  Vamos ha dar por finalizada definitivamente la navegación por botones y se pasará solo a
 *  la navegación por pestañas deslizantes.
 *
 * commit 'Se creara la rama 'navPestanyasDefinitiva' y abandonamos los botones'
 *
 * /////////////////////////////////////////////////////////////////////////////////////////////////
 *
 *      Sábado   17/11/2018 23:10
 *
 * /////////////////////////////
 *
 * Iniciado el CRUD de Clientes
 *
 * revisar leerCliente al cargar una int en un ediTextView
 *
 * commit 'Iniciado CRUD Cliente Revisar error int to ediText"
 *
 * /////////////////////////////////////////////////////////////////////////////////////////////////
 *
 *      Jueves   15/11/2018 14:58
 *
 * /////////////////////////////
 *
 * Casi listo para probar la primera tabla que será la de Cliente. Vamos a crear un Listfragment
 * como en el ejemplo del profe  para posteriormente integrarlo  en PHFClientes o llamarlo desde
 * ese fragment.
 *
 * commit 'Crear Listfragment para la tabla Cliente"
 *
 * /////////////////////////////////////////////////////////////////////////////////////////////////
 *
 *      Martes   13/11/2018 21:25
 *
 * /////////////////////////////
 *
 * Empezar a crear el ProveedorDeContenidos
 *
 * commit 'Preparado objeto Cliente para crear el Proveedor de Contenido"
 *
 * /////////////////////////////////////////////////////////////////////////////////////////////////
 *
 *      Martes   13/11/2018 07:14
 *
 * /////////////////////////////
 *
 * Se añade la entidad Contrato y se cambian los nombres y referencias de las actividades y los
 * leyouts que llevan la palabra actuacion y similares
 *
 * commit 'Reestructurado Actuaciones por Contratos'
 *
 * /////////////////////////////////////////////////////////////////////////////////////////////////
 *
 *      Sábado   10/11/2018 20:02
 *
 * /////////////////////////////
 *
 * Después del commit 'Ya estamos en entrega3', realizaremos el push para que el githup esté igual
 * que el git local
 *
 * /////////////////////////////////////////////////////////////////////////////////////////////////
 *
 *      Jueves   08/11/2018 22:08
 *
 * /////////////////////////////
 *
 * commit 'Ya estamos en entrega3'
 *
 * /////////////////////////////////////////////////////////////////////////////////////////////////
 *
 *      Jueves   08/11/2018 22:04
 *
 * /////////////////////////////
 *
 * commit 'creamos la rama entrega3'
 *
 * /////////////////////////////////////////////////////////////////////////////////////////////////
 *
 *      Jueves   08/11/2018 22:02
 *
 * /////////////////////////////
 *
 * commit 'ahora si a master'
 *
 * /////////////////////////////////////////////////////////////////////////////////////////////////
 *
 *      Jueves   08/11/2018 21:48
 *
 * /////////////////////////////
 *
 * commit 'navegaPestanyas lista para merge con entrega2'
 *
 *      ATENCIÓN        En realidad antes del merge con master hay que replegar entrega2
 *
 * Este es el commit de seguridad una vez duplicado el final de navegaPestanyas
 *
 * /////////////////////////////////////////////////////////////////////////////////////////////////
 *
 *      Jueves   08/11/2018 21:46
 *
 * /////////////////////////////
 *
 * commit 'entrega2 lista para merge con master'
 * Este es el commit de seguridad una vez duplicado el final de entrega2
 *
 * /////////////////////////////////////////////////////////////////////////////////////////////////
 *
 *      Jueves   08/11/2018 21:36
 *
 * /////////////////////////////
 *
 * commit 'Lista la segunda entrega'
 * Al dar porterminada la entrega2 podremos hacer el merge con master y crear la nueva rama
 * entrega3
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
public class MainActivity   extends     AppCompatActivity
                            implements  NavigationView.OnNavigationItemSelectedListener ,
                                        DialogoCerrar.EscuchadorDialogoCerrar {

    // variables de clase
	
	// botones
    /*Button  bActuaciones    ;
    Button  bNuevaActuacion ;
    Button  bClientes       ;
    Button  bNuevoCliente   ;*/
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
        Toolbar toolbar = findViewById( R.id.toolbar )  ;
        setSupportActionBar( toolbar )                  ;

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

        // Esto es cargar el escuchador del menú emergente?????????
        NavigationView navigationView = findViewById( R.id.nav_view )   ;
        navigationView.setNavigationItemSelectedListener( this )        ;

        // para la navegación por botones
        activarEscuchadores() ;

    }

    //////////////////////////////////////////////////////////////////////
    //
    //  Métodos del menú emergente
    //
    ///////////////////////////////

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

        // esta función nos devuelve el id de un item de menú
        // y según este número sabremos que opción se a pulsado
        switch ( item.getItemId() ){

            case R.id.action_settings   :
                verSetings()            ;
                return true             ;


            case R.id.action_help :

                verLaAyuda()            ;
                return true             ;

        }

        return super.onOptionsItemSelected( item ) ;

    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected( MenuItem item ) {

        switch ( item.getItemId() ){

            case R.id.nav_gallery :

                intento = new Intent( MainActivity.this, GaleriaPhotos.class ) ;
                startActivity( intento ) ;

                break ;

            case R.id.nav_secciones :

                intento = new Intent( MainActivity.this, GestionDatos.class ) ;
                startActivity( intento ) ;

                break ;

            case R.id.nav_cerrar :

                cerrarSalir() ;
                break ;

        }

        DrawerLayout drawer = findViewById ( R.id.drawer_layout )   ;
        drawer.closeDrawer( GravityCompat.START )                   ;

        return true ;

    }

    //////////////////////////////////////////////////////////////////////
    //
    //  Navegación por botones
    //
    //////////////////////////
    //
    //      Cerrando la navegación por botones
    //      de momento se comentan las acciones
    //      cuando se haga la comprobación se
    //      borrará definitivamente esa parte
    //      del código.
    //
    ///////////////////////////////////////////////////////////////////////

	/**
	 *
	 * activamos los escuchadores de los botones
	 *
	 */
    private void activarEscuchadores() {

        FloatingActionButton fab = findViewById( R.id.bfSalir ) ;

        fab.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick( View v ) { cerrarSalir() ; }

        });


        /*
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

        bActuaciones = findViewById( R.id.buttonContratos) ;

        bActuaciones.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick( View v ) {

                intento = new Intent( MainActivity.this, ListadoContratos.class ) ;
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

                intento = new Intent( MainActivity.this, EditaContrato.class ) ;
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
                intento.putExtra( "Nuevo", true );
                startActivity( intento ) ;

            }

        }) ;


        ////////////////////////////////////////////
        //
        // botón de salida  ( se mantendrá en la navegación por pestañas )
		//
		// que lanza un cuadro de dialogo para preguntar
		// al usuario si desea cerrar la aplicación
		//

		bSalir = findViewById( R.id.buttonSalir ) ;

        bSalir.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick( View v ) { cerrarSalir() ; }

        }) ;
        */

    }

	/**
	 *
	 * método del interface EscuchadorDialogoCerrar
	 * que cierra la aplicación y libera la memoria
	 *
	 */
    @Override
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
        // usamos la segunda forma porque queremas cerrar la
		// aplicación del todo
		//
		
        MainActivity.super.finishAndRemoveTask() ;

    }
	
	/**
	 *
	 * método del interface EscuchadorDialogoCerrar
	 * que no hace nada y permite seguir con la aplicación
	 *
	 */
    @Override
    public void DialogoCerrarClickNegativo( DialogFragment dialog ) {

        // no hacer nada y volver al MainActivity

    }

    protected void modEnConstruccion() {

        //  Para los módulos en construcción
        FragmentManager manejador   = getFragmentManager()                                                    ;
        DialogoMensaje dMensaje    = new DialogoMensaje(   getString( R.string.txt_titulo_mensaje      )   ,
                                                            getString( R.string.txt_modulo_construccion )   ) ;
        dMensaje.show(                                      manejador, "elDialogoEnConstruccion"            ) ;

    }

    private void verSetings() {
        android.app.FragmentManager manejador   = getFragmentManager() ;

        DialogoMensaje  dMensaje    = new DialogoMensaje(   getString( R.string.txt_titulo_setings   )                                   ,
                getString( R.string.txt_texto_setings)   ) ;

        dMensaje.show(manejador,"elDialogoSetings");
    }

    private void verLaAyuda() {

        android.app.FragmentManager manejador   = getFragmentManager() ;

        DialogoMensaje dMensaje    = new DialogoMensaje(    getString( R.string.txt_titulo_ayuda_app    )                                   ,
                                                            getString( R.string.txt_texto_ayuda_app     )   ) ;

        dMensaje.show(manejador,"elDialogoAyudaRegistros");

    }

    private void cerrarSalir(){

        FragmentManager manejador   = getFragmentManager()  ;
        DialogoCerrar   dCerrar     = new DialogoCerrar()   ;

        dCerrar.show( manejador, "elDialogoCerrar" )        ;

    }

}
