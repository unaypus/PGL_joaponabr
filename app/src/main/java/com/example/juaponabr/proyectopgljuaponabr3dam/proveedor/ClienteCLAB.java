/*
 * Copyright (c) 2018.  juaponabr 3º DAM Semipresencial
 */

package com.example.juaponabr.proyectopgljuaponabr3dam.proveedor;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

import com.example.juaponabr.proyectopgljuaponabr3dam.pojos.Cliente;

/**
 *
 * CRUD de la tabla Ciente  CLAB: CrearLeerActualizarBorrar
 *
 */
public class ClienteCLAB {

    static private ContentValues losValores = new ContentValues() ;

    /**
     *
     * la C de CRUD Create ( insertar, añadir etc.. )
     *
     * @param resolvedor    para saber donde estamos
     * @param cliente       el objeto cliente con los datos
     *
     */
    static public void      insert( ContentResolver resolvedor  , Cliente   cliente ){

        Uri uri = Tablas.TClientes.CLIENTES_URI ;

        cargarValores( cliente ) ;

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
    static public Cliente   read(   ContentResolver resolvedor  , int cl_Id ) {

        Uri uri = Uri.parse( Tablas.TClientes.CLIENTES_URI + "/" + cl_Id ) ;

        String[] projection = { Tablas.TClientes._ID                ,
                                Tablas.TClientes.CL_NOMBRE          ,
                                Tablas.TClientes.CL_DNI             ,
                                Tablas.TClientes.DIR_VIA            ,
                                Tablas.TClientes.DIR_NUM            ,
                                Tablas.TClientes.DIR_MUNICIPIO      ,
                                Tablas.TClientes.DIR_CP             ,
                                Tablas.TClientes.DISTANCIA_KM       ,
                                Tablas.TClientes.CL_PER_CONTACTO    ,
                                Tablas.TClientes.CL_TELEFONO        ,
                                Tablas.TClientes.CL_BAJA            } ;

        Cursor cursor = resolvedor.query( uri, projection, null, null, null ) ;

        if ( cursor.moveToFirst() ){

            Cliente unCliente = new Cliente();

            unCliente.setCl_id(             cursor.getInt(      cursor.getColumnIndex( Tablas.TClientes._ID             ) ) ) ;
            unCliente.setCl_nombre(         cursor.getString(   cursor.getColumnIndex( Tablas.TClientes.CL_NOMBRE       ) ) ) ;
            unCliente.setCl_dni(            cursor.getString(   cursor.getColumnIndex( Tablas.TClientes.CL_DNI          ) ) ) ;
            unCliente.setDir_via(           cursor.getString(   cursor.getColumnIndex( Tablas.TClientes.DIR_VIA         ) ) ) ;
            unCliente.setDir_num(           cursor.getInt(      cursor.getColumnIndex( Tablas.TClientes.DIR_NUM         ) ) ) ;
            unCliente.setDir_localidad(     cursor.getString(   cursor.getColumnIndex( Tablas.TClientes.DIR_MUNICIPIO   ) ) ) ;
            unCliente.setDir_cp(            cursor.getString(   cursor.getColumnIndex( Tablas.TClientes.DIR_CP          ) ) ) ;
            unCliente.setDistanacia(        cursor.getInt(      cursor.getColumnIndex( Tablas.TClientes.DISTANCIA_KM    ) ) ) ;
            unCliente.setCl_per_contacto(   cursor.getString(   cursor.getColumnIndex( Tablas.TClientes.CL_PER_CONTACTO ) ) ) ;
            unCliente.setCl_telefono(       cursor.getString(   cursor.getColumnIndex( Tablas.TClientes.CL_TELEFONO     ) ) ) ;
            unCliente.setCl_baja(           cursor.getInt(      cursor.getColumnIndex( Tablas.TClientes.CL_BAJA         ) ) ) ;

            return unCliente;

        }

        return null;

    }

    /**
     *
     * la U de CRUD ( actualizar )
     *
     * @param resolvedor    para saber donde estamos
     * @param cliente       el objeto cliente con los datos
     *
     */
    static public void      update( ContentResolver resolvedor, Cliente cliente ){

        Uri uri = Uri.parse( Tablas.TClientes.CLIENTES_URI + "/" + cliente.getCl_id() ) ;

        cargarValores( cliente ) ;

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

        Uri uri = Uri.parse( Tablas.TClientes.CLIENTES_URI + "/" + cl_Id ) ;
        resolvedor.delete( uri, null, null ) ;

    }

    /**
     *
     * Carga la matriz de valores con los datos del objeto cliente
     *
     * @param cliente   el objeto cliente de donde se cargan los datos
     *
     */
    private static void cargarValores( Cliente   cliente ) {

        losValores.put( Tablas.TClientes.CL_NOMBRE          , cliente.getCl_nombre()        ) ;
        losValores.put( Tablas.TClientes.CL_DNI             , cliente.getCl_dni()           ) ;
        losValores.put( Tablas.TClientes.DIR_VIA            , cliente.getDir_via()          ) ;
        losValores.put( Tablas.TClientes.DIR_NUM            , cliente.getDir_num()          ) ;
        losValores.put( Tablas.TClientes.DIR_CP             , cliente.getDir_cp()           ) ;
        losValores.put( Tablas.TClientes.DIR_MUNICIPIO      , cliente.getDir_localidad()    ) ;
        losValores.put( Tablas.TClientes.DISTANCIA_KM       , cliente.getDistanacia()       ) ;
        losValores.put( Tablas.TClientes.CL_TELEFONO        , cliente.getCl_telefono()      ) ;
        losValores.put( Tablas.TClientes.CL_PER_CONTACTO    , cliente.getCl_per_contacto()  ) ;
        losValores.put( Tablas.TClientes.CL_BAJA            , cliente.getCl_baja()          ) ;

    }

}

