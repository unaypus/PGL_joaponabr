/*
 * Copyright (c) 2019.  juaponabr 3º DAM Semipresencial
 */

package com.example.juaponabr.proyectopgljuaponabr3dam.controlador;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.example.juaponabr.proyectopgljuaponabr3dam.R;
import com.example.juaponabr.proyectopgljuaponabr3dam.pojos.Contrato;
import com.example.juaponabr.proyectopgljuaponabr3dam.proveedor.ContratoCLAB;
import com.example.juaponabr.proyectopgljuaponabr3dam.proveedor.Tablas;

public class ListadoActuaciones  extends ListFragment
        implements LoaderManager.LoaderCallbacks<Cursor> {

    ListadoActuaciones.TablaCursorAdapter mAdapter;
    LoaderManager.LoaderCallbacks<Cursor> mCallbacks;

    //ActionMode mActionMode;
    View viewSeleccionado       ;

    //Contrato unContrato = null    ;
    Intent intento              ;

    public static ListadoActuaciones newInstance() {

        ListadoActuaciones f = new ListadoActuaciones() ;
        return f ;

    }

    /**
     * When creating, retrieve this instance's number from its arguments.
     */
    @Override
    public void onCreate( Bundle savedInstanceState ) {

        super.onCreate( savedInstanceState ) ;

    }

    @Override
    public View onCreateView(   LayoutInflater inflater            ,
                                ViewGroup container           ,
                                Bundle          savedInstanceState  ) {

        //Log.i(LOGTAG, "onCreateView");

        View v      = inflater.inflate(         R.layout.el_listado_clientes    ,
                                                container                       ,
                                                false                           ) ;
        mAdapter    = new ListadoActuaciones.TablaCursorAdapter(   getActivity()                   ) ;

        setListAdapter( mAdapter ) ;

        return v ;
    }



    @Override
    public void onActivityCreated( Bundle savedInstanceState ) {

        super.onActivityCreated(savedInstanceState);

        //Log.i(LOGTAG, "onActivityCreated");

        mCallbacks = this;

        getLoaderManager().initLoader(0, null, mCallbacks);


        getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {


            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                int cl_Id = 0;

                view.setSelected(true);
                viewSeleccionado = view;

                cl_Id = (int) viewSeleccionado.getTag();

                //unContrato   =       ContratoCLAB.read(  getActivity().getContentResolver()  ,
                //      cl_Id                               ) ;
                intento = new Intent(getActivity(),
                        EditaContrato.class);
                /*
                intento.putExtra(   "Nuevo"     , false     ) ;
                intento.putExtra(   "elContrato" , unContrato ) ;
                intento.putExtra(   "elCliente" , unContrato ) ;
                */
                startActivity(intento);

                return true;

            }

        });

        FloatingActionButton fab = getView().findViewById(R.id.bfNuevoCliente);

        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                intento = new Intent(getActivity(), EditaContrato.class);

                //intento.putExtra(   "Nuevo", true   ) ;
                startActivity(intento);

            }

        });
    }
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        // This is called when a new Loader needs to be created.  This
        // sample only has one Loader, so we don't care about the ID.
        // First, pick the base URI to use depending on whether we are
        // currently filtering.
        String columns[] = new String[] {   Tablas.TActuaciones._ID,
                                            Tablas.TActuaciones.A_CLIENTE,
                                            Tablas.TActuaciones.A_FECHA         ,
                                            Tablas.TActuaciones.A_ESTADO        ,
                                            Tablas.TActuaciones.A_ID_CONTRATO } ;


        Uri baseUri = Tablas.TActuaciones.ACTUACIONES_URI;

        // Now create and return a CursorLoader that will take care of
        // creating a Cursor for the data being displayed.

        //String selection = Tablas.TActuaciones.A_ID_CONTRATO + " = " + Tablas.TContratos._ID + " and " +Tablas.TContratos.CT_N_CL + " = " + Tablas.TClientes._ID; //null;
        String selection = null;//Tablas.TActuaciones.A_ID_CONTRATO + " = " + Tablas.TContratos._ID;//null;


        return new CursorLoader(    getActivity()   ,
                                    baseUri         ,
                                    columns         ,
                                    selection       ,
                null, null      ) ;
    }

    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        // Swap the new cursor in.  (The framework will take care of closing the
        // old cursor once we return.)

        //Uri laUriBase = Uri.parse("content://"+ Tablas.AUTHORITY+"/" + Tablas.TABLA_CLIENTES);
        data.setNotificationUri(getActivity().getContentResolver(), Tablas.TActuaciones.ACTUACIONES_URI);

        mAdapter.swapCursor(data);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
        // This is called when the last Cursor provided to onLoadFinished()
        // above is about to be closed.  We need to make sure we are no
        // longer using it.
        mAdapter.swapCursor(null);
    }
    public class TablaCursorAdapter extends CursorAdapter {

        public TablaCursorAdapter( Context context) {
            super(context, null, false ) ;
        }


        @Override
        public void bindView( View view, Context context, Cursor cursor ) {

            int     nID         =   cursor.getInt(      cursor.getColumnIndex( Tablas.TActuaciones._ID            ) ) ;

            int     nDistancia  =  cursor.getInt( cursor.getColumnIndex( Tablas.TActuaciones.A_ESTADO ) );
            String  sFechaEstado =  "Fecha : " +
                                    cursor.getString( cursor.getColumnIndex( Tablas.TActuaciones.A_FECHA ) )    +
                                    "    Estado : "   +
                                    estadoAct( nDistancia ) ;


            String  sNombre     =   "Contrato : "   +   cursor.getInt(      cursor.getColumnIndex( Tablas.TActuaciones.A_ID_CONTRATO     ) )   +
                                    "  Cliente : " + cursor.getString(      cursor.getColumnIndex( Tablas.TActuaciones.A_CLIENTE     ) )+
            "    Actuación : " +nID;

            TextView textviewNombre     = view.findViewById( R.id.tvListCLnombre    ) ;
            TextView textviewDistancia  = view.findViewById( R.id.tvListDistancia   ) ;

            textviewNombre.setText(     sFechaEstado     ) ;
            textviewDistancia.setText(  sNombre     ) ;

            ColorGenerator generator = ColorGenerator.MATERIAL; // or use DEFAULT
            int color = generator.getColor( "." + nDistancia + "." ) ; //Genera un color según el nombre
            TextDrawable drawable = TextDrawable.builder()
                    .buildRound( "A" , color ) ;

            ImageView image = view.findViewById(R.id.image_view);
            image.setImageDrawable(drawable);

            view.setTag( nID ) ;

        }

        @Override
        public View newView( Context context, Cursor cursor, ViewGroup parent ) {

            LayoutInflater inflater    = LayoutInflater.from(  context                         ) ;
            View            v           = inflater.inflate(     R.layout.listado_cliente_item   ,
                    parent                          ,
                    false                           ) ;

            bindView( v, context, cursor ) ;

            return v ;

        }
    }

    private String estadoAct( int estado ) {

        switch ( estado ){

            case 0 : return "Programada"    ;
            case 1 : return "Anulada"       ;
            case 2 : return "Realizada"     ;
            case 3 : return "Cobrada"       ;

        }

        return "error" ;

    }
}
