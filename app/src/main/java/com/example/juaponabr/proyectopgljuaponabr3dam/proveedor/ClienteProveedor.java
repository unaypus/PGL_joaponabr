package com.example.juaponabr.proyectopgljuaponabr3dam.proveedor;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

import com.example.juaponabr.proyectopgljuaponabr3dam.pojos.Cliente;

public class ClienteProveedor {

    static public void insert( ContentResolver resolvedor, Cliente cliente ){

        Uri uri = Contrato.TClientes.CONTENT_URI ;

        ContentValues values = new ContentValues() ;

        values.put( Contrato.TClientes.CL_NOMBRE        , cliente.getCl_nombre()        ) ;
        values.put( Contrato.TClientes.CL_DNI           , cliente.getCl_dni()           ) ;
        values.put( Contrato.TClientes.DIR_VIA          , cliente.getDir_via()          ) ;
        values.put( Contrato.TClientes.DIR_NUM          , cliente.getDir_num()          ) ;
        values.put( Contrato.TClientes.DIR_CP           , cliente.getDir_cp()           ) ;
        values.put( Contrato.TClientes.DIR_MUNICIPIO    , cliente.getDir_localidad()    ) ;
        values.put( Contrato.TClientes.DISTANCIA_KM     , cliente.getDistanacia()       ) ;
        values.put( Contrato.TClientes.CL_TELEFONO      , cliente.getCl_telefono()      ) ;
        values.put( Contrato.TClientes.CL_PER_CONTACTO  , cliente.getCl_per_contacto()  ) ;

        resolvedor.insert(uri, values);

    }

    static public Cliente read( ContentResolver resolver, int cl_Id ) {

        Uri uri = Uri.parse( Contrato.TClientes.CONTENT_URI + "/" + cl_Id ) ;

        String[] projection = { Contrato.TClientes._ID              ,
                                Contrato.TClientes.CL_NOMBRE        ,
                                Contrato.TClientes.CL_DNI           ,
                                Contrato.TClientes.DIR_VIA          ,
                                Contrato.TClientes.DIR_NUM          ,
                                Contrato.TClientes.DIR_MUNICIPIO    ,
                                Contrato.TClientes.DIR_CP           ,
                                Contrato.TClientes.DISTANCIA_KM     ,
                                Contrato.TClientes.CL_PER_CONTACTO  ,
                                Contrato.TClientes.CL_TELEFONO      } ;

        Cursor cursor = resolver.query( uri, projection, null, null, null ) ;

        if ( cursor.moveToFirst() ){

            Cliente unCliente = new Cliente();

            unCliente.setCl_id(             cursor.getInt(    cursor.getColumnIndex( Contrato.TClientes._ID             ) ) ) ;
            unCliente.setCl_nombre(         cursor.getString( cursor.getColumnIndex( Contrato.TClientes.CL_NOMBRE       ) ) ) ;
            unCliente.setCl_dni(            cursor.getString( cursor.getColumnIndex( Contrato.TClientes.CL_DNI          ) ) ) ;
            unCliente.setDir_via(           cursor.getString( cursor.getColumnIndex( Contrato.TClientes.DIR_VIA         ) ) ) ;
            unCliente.setDir_num(           cursor.getInt(    cursor.getColumnIndex( Contrato.TClientes.DIR_NUM         ) ) ) ;
            unCliente.setDir_localidad(     cursor.getString( cursor.getColumnIndex( Contrato.TClientes.DIR_MUNICIPIO   ) ) ) ;
            unCliente.setDir_cp(            cursor.getString( cursor.getColumnIndex( Contrato.TClientes.DIR_CP          ) ) ) ;
            unCliente.setDistanacia(        cursor.getInt(    cursor.getColumnIndex( Contrato.TClientes.DISTANCIA_KM    ) ) ) ;
            unCliente.setCl_per_contacto(   cursor.getString( cursor.getColumnIndex( Contrato.TClientes.CL_PER_CONTACTO ) ) ) ;
            unCliente.setCl_telefono(       cursor.getString( cursor.getColumnIndex( Contrato.TClientes.CL_TELEFONO     ) ) ) ;

            return unCliente;

        }

        return null;

    }


}

