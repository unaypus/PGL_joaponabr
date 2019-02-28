/*
 * Copyright (c) 2018.  juaponabr 3º DAM Semipresencial
 */

package com.example.juaponabr.proyectopgljuaponabr3dam.proveedor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class AsistenteDB extends SQLiteOpenHelper {


    public AsistenteDB( Context context ) {

        super( context, Tablas.getDatabaseName(), null, Tablas.getDatabaseVersion() ) ;

    }

    @Override
    public void onOpen( SQLiteDatabase db ) {

        super.onOpen( db ) ;

        //if (!db.isReadOnly()){
        //Habilitamos la integridad referencial
        db.execSQL( "PRAGMA foreign_keys=ON;" ) ;
        //}

    }

    @Override
    public void onCreate( SQLiteDatabase db ) {

        String  lasTablas[]     ;
        String  losInserts[][]  ;
        int     nTablas         ;
        int     nInserts        ;

        lasTablas   = Tablas.getLasTablas().clone()     ;
        nTablas     = lasTablas.length                  ;
        losInserts  = Tablas.getLosInserts().clone()    ;
        nInserts    = losInserts.length                 ;

        // crear tablas
        for( int contTablas = 0 ; contTablas < nTablas ; contTablas++ ) {

            // crear tablas
            db.execSQL( "Create table "                                                     +
                        lasTablas[ contTablas ]                                        +
                        "( _id INTEGER PRIMARY KEY ON CONFLICT ROLLBACK AUTOINCREMENT, "    +
                        Tablas.getCreates( contTablas )                                     ) ;

        }


        for( int contInserts = 0 ; contInserts < nInserts  ; contInserts++ ){

            db.execSQL( "INSERT INTO "                      +
                        losInserts[ contInserts ][ 0 ]      +
                        " ("                                +
                        losInserts[ contInserts ][ 1 ]      ) ;

        }

    }

    @Override
    public void onUpgrade( SQLiteDatabase db, int oldVersion, int newVersion ) {

        String  lasTablas[] ;
        int     nTablas     ;

        lasTablas  = Tablas.getLasTablas().clone()  ;
        nTablas    = lasTablas.length               ;

        ////////////////////////////////////////////
        //
        //      Este bucle destruye las tablas
        //      por lo que al reconstruirlas se
        //      perderán los datos sustituyendose
        //      por los datos de muestra.
        //
        for( int contTablas = 0 ; contTablas < nTablas ; contTablas++ ) {

            db.execSQL( "DROP TABLE IF EXISTS " + lasTablas[ contTablas ] ) ;

        }

        onCreate( db ) ;

    }

}
