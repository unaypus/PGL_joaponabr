/*
 * Copyright (c) 2018.  juaponabr 3º DAM Semipresencial
 */

package com.example.juaponabr.proyectopgljuaponabr3dam.proveedor;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;

/**
 * Historial versiones JPLM.db
 *
 * V. 1
 *
 *      Tabla   Cliente
 *
 *      Campos  _id           ; // Clave principal
 *              "Nombre"      ;
 *              "DNI"         ;
 *              "Via"         ;
 *              "Num"         ;
 *              "CP"          ;
 *              "Municipio"   ;
 *              "Km"          ;
 *              "Tel"         ;
 *              "PerCont"     ;
 *
 * v. 2 Añadida
 *
 *      Tabla   Contratos
 *
 *      Campos  "Nombre"      ;
 *              "DNI"         ;
 *              "Via"         ;
 *              "Num"         ;
 *
 *
 *
 */
public class Gestor extends ContentProvider {

    ////////////////////////////////////////////////////////////////////////////////////////////
    //                                                                                        //
    //                      A T E N C I Ó N  -  P R E G U N T A                               //
    //                                                                                        //
    //      OK - CORRECTO   ////////////////////////////////////////////////////////////////////
    //                                                                                        //
    //      ¿ Aquí se ponen tanatas CONSTANTES como tablas hay en nuestra base de datos ?     //
    //                                                                                        //
    //      Y si es así                                                                       //
    //                                                                                        //
    //      ¿ Son tres CONSTANTES, dos int para las consultas y una String para el nombre     //
    //        de la tabla ?                                                                   //
    //                                                                                        //
    //                                                                                        //
    ////////////////////////////////////////////////////////////////////////////////////////////

    //private static final String LOGTAG = "juaponabr - Gestor";

    private static final String LAS_TABLAS[]    = Tablas.getLasTablas().clone() ;

    //      tabla Cliente
    //private static final    String          CLIENTES_TABLE_NAME     = LAS_TABLAS[0]    ;

    //com.example.juaponabr.proyectopgljuaponabr3dam.proveedor.Gestor/Clientes/#
    private static final    int TABLA_ONE_REG = 1             ;
    //com.example.juaponabr.proyectopgljuaponabr3dam.proveedor.Gestor/Clientes
    private static final    int TABLA_ALL_REGS = 2             ;

    //      la base de datos
    private SQLiteDatabase  sqlDB       ;
    public  AsistenteDB     dbAsistente ;

    // Indicates an invalid content URI
    public static final int INVALID_URI = -1 ;

    // Defines a helper object that matches content URIs to table-specific parameters
    private static final UriMatcher sUriMatcher;

    // Stores the MIME types served by this provider
    private static final SparseArray<String> sMimeTypes;

    /*
     * Initializes meta-data used by the content provider:
     * - UriMatcher that maps content URIs to codes
     * - MimeType array that returns the custom MIME type of a table
     */
    static {

        int    nTablas         = LAS_TABLAS.length             ;

        // Creates an object that associates content URIs with numeric codes
        sUriMatcher = new UriMatcher(0);

        /*
         * Sets up an array that maps content URIs to MIME types, via a mapping between the
         * URIs and an integer code. These are custom MIME types that apply to tables and rows
         * in this particular provider.
         */
        sMimeTypes = new SparseArray<String>();

        // Adds a URI "match" entry that maps picture URL content URIs to a numeric code

        ////////////////////////////////////////////////////////////////////////////////////////////
        //                                                                                        //
        //                      A T E N C I Ó N  -  P R E G U N T A                               //
        //                                                                                        //
        //      OK - CORRECTO   ////////////////////////////////////////////////////////////////////
        //                                                                                        //
        //                                                                                        //
        //      ¿ Aquí se ponen tanatas URIs como tablas hay en nuestra base de datos ?           //
        //                                                                                        //
        //      Y si es así                                                                       //
        //                                                                                        //
        //      ¿ Luego se especifica de que tipo Mime es la tabla ?                              //
        //                                                                                        //
        //                                                                                        //
        ////////////////////////////////////////////////////////////////////////////////////////////

        for( int contTablas = 0 ; contTablas < nTablas ; contTablas++ ) {

            //  uris tablas

            sUriMatcher.addURI( Tablas.AUTHORITY            ,
                                LAS_TABLAS[ contTablas ]    ,
                                TABLA_ALL_REGS              ) ;

            sUriMatcher.addURI( Tablas.AUTHORITY                    ,
                                LAS_TABLAS[ contTablas ] +   "/#"   ,
                                TABLA_ONE_REG                       ) ;



            // Especificaciones MIME tablas

            sMimeTypes.put( TABLA_ALL_REGS                  ,
                            "vnd.android.cursor.dir/vnd."   +
                            Tablas.AUTHORITY                +
                            "."                             +
                            LAS_TABLAS[ contTablas ]        ) ;

            sMimeTypes.put( TABLA_ONE_REG                   ,
                            "vnd.android.cursor.item/vnd."  +
                            Tablas.AUTHORITY                +
                            "."                             +
                            LAS_TABLAS[ contTablas ]        ) ;

        }

    }

    public Gestor() {
    }

    @Override
    public String getType(Uri uri) {
        /*
        switch(uriMatcher.match(uri)){
		case TABLA_ALL_REGS: return "vnd.ua.cursor.dir/ciudadesprovidercontent";
		case TABLA_ONE_REG: return "vnd.ua.cursor.item/ciudadesprovidercontent";
		default: throw new IllegalArgumentException("URI no soportada: "+uri);
		}
         */
        return null;
    }


    @Override
    public boolean onCreate() {

        dbAsistente = new AsistenteDB(  getContext() ) ;

        return ( dbAsistente == null ) ? false : true ;

    }

    public void resetDatabase() {

        dbAsistente.close() ;
        dbAsistente = new AsistenteDB(  getContext() ) ;

    }

    //////////////////////////////////////////////
    //
    //  El CRUD genérico para todads las tablas
    //

    /**
     * C    insertar, crear registro
     *
     * @param uri
     * @param values
     * @return
     */
    @Override
    public Uri insert( Uri uri, ContentValues values ) {

        sqlDB = dbAsistente.getWritableDatabase() ;

        String table = uri.getPathSegments().get( 0 ) ;//uri.getLastPathSegment() ;

        /*
        // borrar al comprobar que no hace falta
        switch ( sUriMatcher.match( uri ) ) {

            case TABLA_ALL_REGS:

                table = uri.getLastPathSegment() ; //CLIENTES_TABLE_NAME;
                break ;

        }


        table = uri.getPathSegments().get( 0 ) ;;//uri.getLastPathSegment() ;
        */

        long rowId = sqlDB.insert( table, "", values ) ;

        if ( rowId > 0 ) {

            Uri rowUri = ContentUris.appendId( uri.buildUpon(), rowId ).build() ;
            getContext().getContentResolver().notifyChange( rowUri, null ) ;

            return rowUri ;

        }

        // Cambiar forma de capturar error
        throw new SQLException( "Failed to insert row into " + uri ) ;

    }


    private String nombreTabla( Uri uri, String selection ) {

        String table = uri.getPathSegments().get( 0 )  ; //CLIENTES_TABLE_NAME;

        switch ( sUriMatcher.match( uri ) ) {

            case TABLA_ONE_REG:

                if ( null == selection ) selection = "" ;
                //  ATENCIÓN AQUI   *************************************************
                //  Tablas.TClientes._ID + " = " + uri.getLastPathSegment()   ;
                selection += "_ID = " + uri.getLastPathSegment();
                //table = uri.getPathSegments().get( 0 )  ; //CLIENTES_TABLE_NAME;

                break;


            /* innecesario  ??????
            case TABLA_ALL_REGS:

                table = uri.getLastPathSegment();

                break;
                */

        }

        return table ;

    }


    /**
     * U    actualizar  1 / varios registros
     *
     * @param uri
     * @param projection
     * @param selection
     * @param selectionArgs
     * @param sortOrder
     * @return
     */
    @Override
    public Cursor query(    Uri         uri             ,
                            String[]    projection      ,
                            String      selection       ,
                            String[]    selectionArgs   ,
                            String      sortOrder       ) {

        SQLiteQueryBuilder  qb      = new SQLiteQueryBuilder()              ;
        SQLiteDatabase      db      = dbAsistente.getReadableDatabase()     ;
        //String              query   = null                                  ;

        switch ( sUriMatcher.match( uri ) ) {

            case TABLA_ONE_REG:

                if ( null == selection ) selection = "" ;

                //  ATENCIÓN AQUI   *************************************************
                //  Tablas.TClientes._ID + " = " + uri.getLastPathSegment() ;

                selection += "_ID = " + uri.getLastPathSegment() ;

                //  *****************************************************************
                //qb.setTables( uri.getPathSegments().get( 0 ) ) ; //CLIENTES_TABLE_NAME );

                break ;

            case TABLA_ALL_REGS:

                //  ATENCIÓN AQUI   *************************************************
                //  Tablas.TClientes._ID + " ASC";

                if ( TextUtils.isEmpty( sortOrder ) ) sortOrder = "_ID ASC" ;

                //qb.setTables( uri.getLastPathSegment() ); //qb.setTables(CLIENTES_TABLE_NAME);

                break ;

        }

        qb.setTables( uri.getPathSegments().get( 0 ) ) ; //CLIENTES_TABLE_NAME );

        Cursor c ;
        c = qb.query( db, projection, selection, selectionArgs, null, null, sortOrder ) ;
        c.setNotificationUri( getContext().getContentResolver(), uri ) ;

        return c ;
    }

    /**
     * R    consultar, leer 1 / varios registros
     *
     * @param uri
     * @param values
     * @param selection
     * @param selectionArgs
     * @return
     */
    @Override
    public int update(  Uri             uri             ,
                        ContentValues   values          ,
                        String          selection       ,
                        String[]        selectionArgs   ) {

        sqlDB = dbAsistente.getWritableDatabase();
        // insert record in user table and get the row number of recently inserted record

        String table = uri.getPathSegments().get( 0 ) ; //CLIENTES_TABLE_NAME;

        switch ( sUriMatcher.match( uri ) ) {

            case TABLA_ONE_REG:

                if ( null == selection ) selection = "" ;

                //  ATENCIÓN AQUI   *************************************************
                //  Tablas.TClientes._ID + " = " + uri.getLastPathSegment()   ;

                selection   +=  "_ID = " + uri.getLastPathSegment()   ;
                //table       = uri.getPathSegments().get( 0 ) ; //CLIENTES_TABLE_NAME;

                break ;

            /*
            case TABLA_ALL_REGS:


                table = uri.getLastPathSegment();

                break ;
                */
        }

        int rows = sqlDB.update( table, values, selection, selectionArgs ) ;

        if (rows > 0) {

            getContext().getContentResolver().notifyChange( uri, null ) ;

            return rows ;

        }

        // CAMBIAR
        throw new SQLException("Failed to update row into " + uri);

    }

    /**
     * D    borrar 1 / varios registros
     *
     * @param uri
     * @param selection
     * @param selectionArgs
     * @return
     */
    @Override
    public int delete( Uri uri, String selection, String[] selectionArgs ) {

        sqlDB = dbAsistente.getWritableDatabase();
        // insert record in user table and get the row number of recently inserted record

        String table = uri.getPathSegments().get( 0 )  ; //CLIENTES_TABLE_NAME;

        switch ( sUriMatcher.match( uri ) ) {

            case TABLA_ONE_REG:

                if ( null == selection ) selection = "" ;

                //  ATENCIÓN AQUI   *************************************************
                //  Tablas.TClientes._ID + " = " + uri.getLastPathSegment()   ;

                selection += "_ID = " + uri.getLastPathSegment() ;

                //table = uri.getPathSegments().get( 0 )  ; //CLIENTES_TABLE_NAME;

                break;

            /*
            case TABLA_ALL_REGS:

                table = uri.getLastPathSegment();

                break;
            */
        }

        int rows = sqlDB.delete( table, selection, selectionArgs ) ;

        if (rows > 0) {

            getContext().getContentResolver().notifyChange( uri, null ) ;
            return rows ;

        }

        // CAMBIAR
        throw new SQLException( "Failed to delete row into " + uri ) ;

    }

}
