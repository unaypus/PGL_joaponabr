/*
 * Copyright (c) 2018.  juaponabr 3º DAM Semipresencial
 */

package com.example.juaponabr.proyectopgljuaponabr3dam.controlador;

import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.juaponabr.proyectopgljuaponabr3dam.dialogos.DialogoMensaje;
import com.example.juaponabr.proyectopgljuaponabr3dam.R;

public class EditaRegistro extends AppCompatActivity {
        //implements View.OnClickListener{

    // variables de clase

    // botones actividades
    //private Button bActuaciones;
    //private Button bClientes ;

    // botones edición de registro
    private ImageButton bNuevo;
    private ImageButton bGuardar;
    private ImageButton bBorrar;

    // botones navegación registros
    private ImageButton bPrimero;
    private ImageButton bAnterior;
    private ImageButton bSiguiente;
    private ImageButton bUltimo;

    // textos validadción
    private String sErrorValidacion;
    private String sDatosValidados ;

    private boolean nuevoRegistro   = true  ;

    // intentos ( para lanzar activitys )
    //private Intent intento;
    // En las clase hijas
    // crear la variable : private Context elContexto ;
    // crear la sentencia : elContexto = la_activity.this;
    // antes de llamar a : activarEscuchadores( elContexto );

    @Override
    protected void onCreate(Bundle savedInstanceState) { super.onCreate( savedInstanceState ) ; }

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

    protected void iniBarraHerramientas(){

        Toolbar toolbar = findViewById(                     R.id.toolbar                ) ;
        setSupportActionBar(                                toolbar                     ) ;
        getSupportActionBar().setHomeAsUpIndicator(         R.drawable.ic_action_home   ) ;
        getSupportActionBar().setDisplayHomeAsUpEnabled(    true                        ) ;

    }

    /**
     *
     * activamos los escuchadores de los botones
     *
     */
    protected void activarEscuchadores( final Context elContexto ) {

        /*
        ////////////////////////////////////////////////////////////////////////////////////////////
        //
        //  Botones Navegación entre Activitys      ////////////////////////////////////////////////
        //
        ////////////////////////////////////////////
        //
        // botón para ir al listado de actuaciones
        //

        bActuaciones = findViewById(R.id.buttonVerContratos);

        bActuaciones.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intento = new Intent(elContexto,ListadoContratos.class);
                startActivity(intento);
            }

        });

        ////////////////////////////////////////////
        //
        // botón para ir al listado de clientes
        //

        bClientes = findViewById(R.id.buttonVerClientes);

        bClientes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                intento = new Intent(elContexto,ListadoClientes.class);
                startActivity(intento);

            }

        });
        */

        ////////////////////////////////////////////////////////////////////////////////////////////
        //
        //  Botones Edición Registro        ////////////////////////////////////////////////////////
        //
        /////////////////////////////////////
        //
        //  Botón Nuevo
        //

        bNuevo = findViewById(R.id.imgBtonNuevo);

        bNuevo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { modEnConstruccion(); }

        });

        /////////////////////////////////////
        //
        //  Botón Guardar
        //

        bGuardar = findViewById(R.id.imgBtonGuardar);

        bGuardar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if( validarDatos()) {
                    guardarRegistro();
                }else{
                    mensajeNoValidado();
                }

            }

        });

        /////////////////////////////////////
        //
        //  Botón Borrar
        //

        bBorrar = findViewById(R.id.imgBtonBorrar);

        bBorrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { borrarRegistro(); }

        });


        ////////////////////////////////////////////////////////////////////////////////////////////
        //
        //  Botones Navegación Tabla        ////////////////////////////////////////////////////////
        //
        /////////////////////////////////////
        //
        //  Botón Primero
        //

        bPrimero = findViewById(R.id.imgBtonPrimero);

        bPrimero.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { modEnConstruccion(); }

        });

        /////////////////////////////////////
        //
        //  Botón Anterior
        //
        bAnterior = findViewById(R.id.imgBtonAnterior);
        bAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { modEnConstruccion(); }
        });

        /////////////////////////////////////
        //
        //  Botón Siguiente
        //

        bSiguiente = findViewById(R.id.imgBtonSiguiente);

        bSiguiente.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { modEnConstruccion(); }

        });

        /////////////////////////////////////
        //
        //  Botón Último
        //

        bUltimo = findViewById(R.id.imgBtonUltimo);

        bUltimo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { modEnConstruccion(); }

        });

    }



    ////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //  Métodos
    //

    protected void mensajeNoValidado() {

        FragmentManager manejador   = getFragmentManager() ;
        DialogoMensaje dMensaje    = new DialogoMensaje(   getString( R.string.atencion )  ,
                                                            getsErrorValidacion()           ) ;

        dMensaje.show(manejador,"elDialogoNoValidado");

    }

    protected boolean validarDatos() { return true; }

    protected void guardarRegistro() {

        if( getbNuevoRegistro() ){
            insertarRegistro() ;
        } else {
            actualizarRegistro() ;
        }

    }

    protected void actualizarRegistro() {

        FragmentManager manejador   = getFragmentManager() ;
        DialogoMensaje  dMensaje    = new DialogoMensaje(   getString( R.string.titulo_guardando )  ,
                getsDatosValidados()                    ) ;

        dMensaje.show(manejador,"elDialogoGuardar");
        //Toast.makeText(EditaRegistro.this,R.string.bot_guardar,Toast.LENGTH_LONG).show();

    }

    protected void insertarRegistro() {

        FragmentManager manejador   = getFragmentManager() ;
        DialogoMensaje  dMensaje    = new DialogoMensaje(   getString( R.string.titulo_guardando )  ,
                getsDatosValidados()                    ) ;

        dMensaje.show(manejador,"elDialogoGuardar");
        //Toast.makeText(EditaRegistro.this,R.string.bot_guardar,Toast.LENGTH_LONG).show();

    }

    protected void borrarRegistro() {

        FragmentManager manejador   = getFragmentManager() ;
        DialogoMensaje  dMensaje    = new DialogoMensaje(   getString( R.string.titulo_guardando )  ,
                                                            getsDatosValidados()                    ) ;

        dMensaje.show(manejador,"elDialogoBorrar");

    }

    protected void modEnConstruccion() {

        //  Para los módulos en construcción
        FragmentManager manejador   = getFragmentManager();
        DialogoMensaje  dMensaje    = new DialogoMensaje(   getString( R.string.txt_titulo_mensaje      )    ,
                                                            getString( R.string.txt_modulo_construccion )    ) ;

        dMensaje.show(manejador,"elDialogoEnConstruccion");

    }


    protected   String  getsErrorValidacion()   { return this.sErrorValidacion  ; }
    protected   String  getsDatosValidados()    { return this.sDatosValidados   ; }
    protected   boolean getbNuevoRegistro()     { return this.nuevoRegistro     ; }

    protected void setsErrorValidacion( String  sErrorValidacion    ){ this.sErrorValidacion    = sErrorValidacion  ; }
    protected void setsDatosValidados(  String  sDatosValidados     ){ this.sDatosValidados     = sDatosValidados   ; }
    protected void setNuevoRegistro(    boolean nuevoRegistro       ){ this.nuevoRegistro       = nuevoRegistro     ; }
}
