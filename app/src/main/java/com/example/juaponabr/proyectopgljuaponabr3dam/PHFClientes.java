package com.example.juaponabr.proyectopgljuaponabr3dam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.juaponabr.proyectopgljuaponabr3dam.controlador.EditaCliente;

public class PHFClientes extends Fragment{

    // variables de clase

    // botones
    Button bActuaciones     ;
    Button bNuevoCliente    ;

    // intentos ( para lanzar activitys )
    Intent intento;

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public PHFClientes() {}

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PHFClientes newInstance( int sectionNumber ) {

        PHFClientes fragment    = new PHFClientes() ;
        Bundle      args        = new Bundle()      ;

        args.putInt( ARG_SECTION_NUMBER, sectionNumber )    ;
        fragment.setArguments( args )                       ;

        return fragment ;

    }

    @Override
    public void onActivityCreated( Bundle state ) {

        super.onActivityCreated( state )    ;
        activarEscuchadores()               ;

    }

    @Override
    public View onCreateView(   LayoutInflater  inflater            ,
                                ViewGroup       container           ,
                                Bundle          savedInstanceState  ) {


        int laSeccion = getArguments().getInt(  ARG_SECTION_NUMBER                  ) ;
        View rootView = inflater.inflate(       R.layout.content_listado_clientes   ,
                                                container                           ,
                                                false                               ) ;



        return rootView ;
    }

    private void activarEscuchadores() {

        // botón para ir al listado de actuaciones
        bActuaciones = getView().findViewById(  R.id.buttonVerContratos) ;
        bActuaciones.setVisibility(             View.INVISIBLE              ) ;

        // botón para añadir un cliente
        bNuevoCliente = getView().findViewById( R.id.buttonNuevoCliente ) ;

        bNuevoCliente.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick( View v ) {

                intento = new Intent(   getActivity().getApplicationContext()   ,
                                        EditaCliente.class                      ) ;
                startActivity(          intento                                 ) ;

            }

        });

    }

}

