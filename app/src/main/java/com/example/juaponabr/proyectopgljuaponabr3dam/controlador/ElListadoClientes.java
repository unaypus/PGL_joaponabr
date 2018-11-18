/*
 * Copyright (c) 2018.  juaponabr 3º DAM Semipresencial
 */

package com.example.juaponabr.proyectopgljuaponabr3dam.controlador;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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
import com.example.juaponabr.proyectopgljuaponabr3dam.pojos.Cliente;
import com.example.juaponabr.proyectopgljuaponabr3dam.proveedor.ClienteProveedor;
import com.example.juaponabr.proyectopgljuaponabr3dam.proveedor.Contrato;

public class ElListadoClientes  extends ListFragment
        implements LoaderManager.LoaderCallbacks<Cursor> {

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
    //private static final String LOGTAG = "Tiburcio - TablaListFragment";

    TablaCursorAdapter mAdapter;
    LoaderManager.LoaderCallbacks<Cursor> mCallbacks;

    //ActionMode mActionMode;
    View viewSeleccionado       ;

    Cliente unCliente = null    ;
    Intent intento              ;

    public static ElListadoClientes newInstance() {

        ElListadoClientes f = new ElListadoClientes() ;
        return f ;

    }

    /**
     * When creating, retrieve this instance's number from its arguments.
     */
    @Override
    public void onCreate( Bundle savedInstanceState ) {

        super.onCreate( savedInstanceState ) ;

    }


    /**
     * The Fragment's UI is just a simple text view showing its
     * instance number.
     */
    @Override
    public View onCreateView(   LayoutInflater  inflater            ,
                                ViewGroup       container           ,
                                Bundle          savedInstanceState  ) {

        //Log.i(LOGTAG, "onCreateView");

        View v      = inflater.inflate(         R.layout.el_listado_clientes    ,
                                                container                       ,
                                                false                           ) ;
        mAdapter    = new TablaCursorAdapter(   getActivity()                   ) ;

        setListAdapter( mAdapter ) ;

        return v ;
    }


    @Override
    public void onActivityCreated( Bundle savedInstanceState ) {

        super.onActivityCreated( savedInstanceState ) ;

        //Log.i(LOGTAG, "onActivityCreated");

        mCallbacks = this;

        getLoaderManager().initLoader( 0, null, mCallbacks ) ;


        getListView().setOnItemLongClickListener( new AdapterView.OnItemLongClickListener() {


            @Override
            public boolean onItemLongClick( AdapterView<?> parent, View view, int position, long id) {

                int cl_Id = 0 ;

                view.setSelected( true )    ;
                viewSeleccionado = view     ;

                cl_Id = ( int ) viewSeleccionado.getTag();

                unCliente   =       ClienteProveedor.read(  getActivity().getContentResolver()  ,
                                                            cl_Id                               ) ;
                intento     = new   Intent(                 getActivity()                       ,
                                                            EditaCliente.class                  ) ;

                intento.putExtra(   "Nuevo"     , false     ) ;
                intento.putExtra(   "elCliente" , unCliente ) ;
                startActivity(      intento                 ) ;

                return true;

            }

        });

        FloatingActionButton fab = getView().findViewById( R.id.bfNuevoCliente ) ;

        fab.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                intento = new Intent( getActivity(), EditaCliente.class ) ;

                intento.putExtra(   "Nuevo", true   ) ;
                startActivity(      intento         ) ;

            }

        });


    }


    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        // This is called when a new Loader needs to be created.  This
        // sample only has one Loader, so we don't care about the ID.
        // First, pick the base URI to use depending on whether we are
        // currently filtering.
        String columns[] = new String[] { Contrato.TClientes._ID,
                Contrato.TClientes.CL_NOMBRE,
                Contrato.TClientes.DISTANCIA_KM
        };

        Uri baseUri = Contrato.TClientes.CONTENT_URI;

        // Now create and return a CursorLoader that will take care of
        // creating a Cursor for the data being displayed.

        String selection = null;

        return new CursorLoader(getActivity(), baseUri,
                columns, selection, null, null);
    }

    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        // Swap the new cursor in.  (The framework will take care of closing the
        // old cursor once we return.)

        Uri laUriBase = Uri.parse("content://"+Contrato.AUTHORITY+"/" + Contrato.TABLA_CLIENTES);
        data.setNotificationUri(getActivity().getContentResolver(), laUriBase);

        mAdapter.swapCursor(data);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
        // This is called when the last Cursor provided to onLoadFinished()
        // above is about to be closed.  We need to make sure we are no
        // longer using it.
        mAdapter.swapCursor(null);
    }

    public class TablaCursorAdapter extends CursorAdapter {

        public TablaCursorAdapter(Context context) {
            super(context, null, false);
        }

        @Override
        public void bindView( View view, Context context, Cursor cursor ) {

            int     nID         = cursor.getInt(    cursor.getColumnIndex( Contrato.TClientes._ID       ) ) ;

            String  sNombre     = "Cliente : " +  cursor.getString( cursor.getColumnIndex( Contrato.TClientes.CL_NOMBRE ) ) ;
            int     laDistancia = cursor.getInt(    cursor.getColumnIndex( Contrato.TClientes.DISTANCIA_KM    ) ) ;
            String  sDistancia  = "Distancia : " + laDistancia + " Km.";

            TextView textviewNombre     = view.findViewById( R.id.tvListCLnombre    ) ;
            TextView textviewDistancia  = view.findViewById( R.id.tvListDistancia   ) ;

            textviewNombre.setText(     sNombre     ) ;
            textviewDistancia.setText(  sDistancia  ) ;

            ColorGenerator generator = ColorGenerator.MATERIAL; // or use DEFAULT
            int color = generator.getColor( "." + laDistancia + "." ) ; //Genera un color según el nombre
            TextDrawable drawable = TextDrawable.builder()
                    .buildRound( sDistancia.substring( 12, 14 ), color ) ;

            ImageView image = view.findViewById(R.id.image_view);
            image.setImageDrawable(drawable);

            view.setTag( nID ) ;

        }

        @Override
        public View newView( Context context, Cursor cursor, ViewGroup parent ) {

            LayoutInflater  inflater    = LayoutInflater.from(  context                         ) ;
            View            v           = inflater.inflate(     R.layout.listado_cliente_item   ,
                                                                parent                          ,
                                                                false                           ) ;

            bindView( v, context, cursor ) ;

            return v ;

        }
    }
}

