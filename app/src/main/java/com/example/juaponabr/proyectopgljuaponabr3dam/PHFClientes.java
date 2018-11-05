package com.example.juaponabr.proyectopgljuaponabr3dam;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PHFClientes extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public PHFClientes() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PHFClientes newInstance(int sectionNumber ) {

        PHFClientes fragment    = new PHFClientes() ;
        Bundle              args        = new Bundle()              ;

        args.putInt( ARG_SECTION_NUMBER, sectionNumber ) ;
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public View onCreateView(   LayoutInflater  inflater            ,
                                ViewGroup       container           ,
                                Bundle          savedInstanceState  ) {


        int laSeccion = getArguments().getInt(ARG_SECTION_NUMBER);
        View rootView = inflater.inflate(R.layout.content_listado_clientes, container, false);

            /*
            switch ( laSeccion ){
                case 1:
                    rootView = inflater.inflate(R.layout.content_edita_actuacion, container, false);
                    break;
                case 2:
                    rootView = inflater.inflate(R.layout.content_edita_cliente, container, false);
                    break;
            }*/

        /*
        View rootView = inflater.inflate(R.layout.fragment_secciones, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
        */

        return rootView;
    }
}

