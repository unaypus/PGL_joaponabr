package com.example.juaponabr.proyectopgljuaponabr3dam;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class EditaRegistro extends AppCompatActivity {
        //implements View.OnClickListener{

    // variables de clase

    // botones
    private Button bActuaciones;
    private Button bClientes ;
    //
    private ImageButton bNuevo;
    private ImageButton bGuardar;
    private ImageButton bBorrar;
    //
    private ImageButton bPrimero;
    private ImageButton bAnterior;
    private ImageButton bSiguiente;
    private ImageButton bUltimo;

    // intentos ( para lanzar activitys )
    private Intent intento;
    // En las clase hijas
    // crear la variable : private Context elContexto ;
    // crear la sentencia : elContexto = la_activity.this;
    // antes de llamar a : activarEscuchadores( elContexto );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void iniBarraHerramientas(){

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    /**
     *
     * activamos los escuchadores de los botones
     *
     */
    protected void activarEscuchadores( final Context elContexto ) {


        ////////////////////////////////////////////////////////////////////////////////////////////
        //
        //  Botones Navegación entre Activitys      ////////////////////////////////////////////////
        //
        // botón para ir al listado de actuaciones
        bActuaciones = findViewById(R.id.buttonVerActuaciones);

        bActuaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(elContexto,ListadoActuaciones.class);
                startActivity(intento);
            }
        });

        // botón para ir al listado de clientes
        bClientes = findViewById(R.id.buttonVerClientes);

        bClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intento = new Intent(elContexto,ListadoClientes.class);
                startActivity(intento);
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////
        //
        //  Botones Edición Registro        ////////////////////////////////////////////////////////
        //
        //  Botón Nuevo
        bNuevo = findViewById(R.id.imgBtonNuevo);
        bNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { modEnConstruccion(); }
        });
        //  Botón Guardar
        bGuardar = findViewById(R.id.imgBtonGuardar);
        bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { modEnConstruccion(); }
        });
        //  Botón Borrar
        bBorrar = findViewById(R.id.imgBtonBorrar);
        bBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { modEnConstruccion(); }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////
        //
        //  Botones Navegación Tabla        ////////////////////////////////////////////////////////
        //
        //  Botón Primero
        bPrimero = findViewById(R.id.imgBtonPrimero);
        bPrimero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { modEnConstruccion(); }
        });
        //  Botón Anterior
        bAnterior = findViewById(R.id.imgBtonAnterior);
        bAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { modEnConstruccion(); }
        });
        //  Botón Siguiente
        bSiguiente = findViewById(R.id.imgBtonSiguiente);
        bSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { modEnConstruccion(); }
        });
        //  Botón Último
        bUltimo = findViewById(R.id.imgBtonUltimo);
        bUltimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { modEnConstruccion(); }
        });
    }

    public void modEnConstruccion() {

        //  Para los módulos en construcción
        FragmentManager manejador = getFragmentManager();
        DialogoMensaje dMensaje = new DialogoMensaje();
        dMensaje.show(manejador,"elDialogoEnConstruccion");

    }
}
