/*
 * Copyright (c) 2018.  juaponabr 3º DAM Semipresencial
 */

package com.example.juaponabr.proyectopgljuaponabr3dam.controlador;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.juaponabr.proyectopgljuaponabr3dam.R;

public class PHFContratos extends Fragment {

    // variables de clase

    // botones
    Button bClientes        ;
    Button bNuevaActuacion  ;

    // intentos ( para lanzar activitys )
    Intent intento          ;

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number" ;

    public PHFContratos() {}

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PHFContratos newInstance(int sectionNumber ) {

        PHFContratos fragment    = new PHFContratos()  ;
        Bundle          args        = new Bundle()          ;

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


            int laSeccion = getArguments().getInt(  ARG_SECTION_NUMBER                      ) ;
            View rootView = inflater.inflate(       R.layout.content_listado_contratos,
                                                    container                               ,
                                                    false                                   ) ;

        return rootView ;
    }

    private void activarEscuchadores() {

        // botón para ir al listado de clientes
        bClientes = getView().findViewById( R.id.buttonVerClientes  ) ;
        bClientes.setVisibility(            View.INVISIBLE          ) ;

        // botón para añadir una actuación
        bNuevaActuacion = getView().findViewById( R.id.buttonNuevoContrato) ;

        bNuevaActuacion.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                intento = new Intent(   getActivity()           ,
                                        EditaContrato.class    ) ;
                startActivity(          intento                 ) ;

            }

        }) ;

    }
}
