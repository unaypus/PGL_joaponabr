/*
 * Copyright (c) 2018.  juaponabr 3º DAM Semipresencial
 */

package com.example.juaponabr.proyectopgljuaponabr3dam.proveedor;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

import com.example.juaponabr.proyectopgljuaponabr3dam.pojos.Contrato;

public class ContratoCLAB {

    static private ContentValues losValores = new ContentValues() ;


    static public void      insert( ContentResolver resolvedor  , Contrato  contrato ){

        Uri uri = Tablas.TContratos.CONTRATOS_URI ;

        cargarValores( contrato ) ;

        resolvedor.insert( uri, losValores) ;

    }

    /**
     *
     * la R de CRUD ( leer )
     *
     * @param resolvedor    para saber donde estamos
     * @param cl_Id         el ID del cliente a buscar
     *
     * @return              un objeto cliente
     *
     */
    static public Contrato read(ContentResolver resolvedor  , int cl_Id ) {

        Uri uri = Uri.parse( Tablas.TContratos.CONTRATOS_URI + "/" + cl_Id ) ;

        String[] projection = { Tablas.TContratos._ID               ,
                                Tablas.TContratos.CT_PRECIO,
                                Tablas.TContratos.CT_FECHA_INI      ,
                                Tablas.TContratos.CT_DIA_SEMANA     ,
                                Tablas.TContratos.CT_PERIODICIDAD   ,
                                Tablas.TContratos.CT_CLIENTE,
                                Tablas.TContratos.CT_N_CL} ;

        Cursor cursor = resolvedor.query( uri, projection, null, null, null ) ;

        if ( cursor.moveToFirst() ){

            Contrato unContrato = new Contrato();

            unContrato.setCtr_id(           cursor.getInt(      cursor.getColumnIndex( Tablas.TContratos._ID                ) ) ); ;
            unContrato.setAct_precio(       cursor.getInt(      cursor.getColumnIndex( Tablas.TContratos.CT_PRECIO) ) ); ;
            unContrato.setCtr_fecha_ini(    cursor.getString(   cursor.getColumnIndex( Tablas.TContratos.CT_FECHA_INI       ) ) ); ;
            unContrato.setCtr_dia_semana(   cursor.getString(   cursor.getColumnIndex( Tablas.TContratos.CT_DIA_SEMANA      ) ) ); ;
            unContrato.setCtr_periodicidad( cursor.getInt(      cursor.getColumnIndex( Tablas.TContratos.CT_PERIODICIDAD    ) ) ); ;
            unContrato.setCtr_cliente(      cursor.getString(   cursor.getColumnIndex( Tablas.TContratos.CT_CLIENTE)));
            unContrato.setCtr_cl_id(        cursor.getInt(      cursor.getColumnIndex( Tablas.TContratos.CT_N_CL) ) ); ;

            return unContrato;

        }

        return null;

    }


    static public void      update( ContentResolver resolvedor, Contrato contrato ){

        Uri uri = Uri.parse( Tablas.TContratos.CONTRATOS_URI + "/" + contrato.getCtr_id() ) ;

        cargarValores( contrato ) ;

        resolvedor.update( uri, losValores, null, null ) ;

    }

    /**
     *
     * y por último la D de CRUD ( borrar, eliminar )
     *
     * @param resolvedor    para saber donde estamos
     * @param cl_Id         el ID del cliente a borrar
     *
     */
    static public void      delete( ContentResolver resolvedor  , int cl_Id ){

        Uri uri = Uri.parse( Tablas.TContratos.CONTRATOS_URI + "/" + cl_Id ) ;
        resolvedor.delete( uri, null, null ) ;

    }

    /**
     *
     * Carga la matriz de valores con los datos del objeto cliente
     *
     * @param contrato   el objeto cliente de donde se cargan los datos
     *
     */
    private static void cargarValores( Contrato   contrato ) {

        losValores.put( Tablas.TContratos.CT_PRECIO         , contrato.getAct_precio()        ) ;
        losValores.put( Tablas.TContratos.CT_FECHA_INI      , contrato.getCtr_fecha_ini()       ) ;
        losValores.put( Tablas.TContratos.CT_DIA_SEMANA     , contrato.getCtr_dia_semana()    ) ;
        losValores.put( Tablas.TContratos.CT_PERIODICIDAD   , contrato.getCtr_periodicidad()  ) ;
        losValores.put( Tablas.TContratos.CT_CLIENTE        , contrato.getCtr_cliente());
        losValores.put( Tablas.TContratos.CT_N_CL           , contrato.getCtr_cl_id() ) ;

    }

}

