/*
 * Copyright (c) 2018.  juaponabr 3º DAM Semipresencial
 */

package com.example.juaponabr.proyectopgljuaponabr3dam.proveedor;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;

public class ProveedorDeContenido extends ContentProvider {

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

    //private static final String LOGTAG = "juaponabr - ProveedorDeContenido";

    //      tabla Cliente
    private static final    String          CLIENTE_TABLE_NAME      = "Cliente"     ;
    //com.example.juaponabr.proyectopgljuaponabr3dam.proveedor.ProveedorDeContenido/Cliente/#
    private static final    int             CLIENTE_ONE_REG         = 1             ;
    //com.example.juaponabr.proyectopgljuaponabr3dam.proveedor.ProveedorDeContenido/Cliente
    private static final    int             CLIENTE_ALL_REGS        = 2             ;

    //      tabla Contratos
    private static final    String          CONTRATOS_TABLE_NAME    = "Contratos"   ;
    //com.example.juaponabr.proyectopgljuaponabr3dam.proveedor.ProveedorDeContenido/Contratos/#
    private static final    int             CONTRATOS_ONE_REG       = 3             ;
    //com.example.juaponabr.proyectopgljuaponabr3dam.proveedor.ProveedorDeContenido/Contratos
    private static final    int             CONTRATOS_ALL_REGS      = 4             ;

    //      la base de datos
    private                 SQLiteDatabase  sqlDB                                   ;
    public                  DatabaseHelper  dbAsistente                             ;
    private static final    String          DATABASE_NAME           = "JPLM.db"     ;
    private static final    int             DATABASE_VERSION        = 1             ;

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

        sUriMatcher.addURI( Contrato.AUTHORITY              ,
                            CLIENTE_TABLE_NAME              ,
                            CLIENTE_ALL_REGS                ) ;
        
        sUriMatcher.addURI( Contrato.AUTHORITY              ,
                            CLIENTE_TABLE_NAME  +   "/#"    ,
                            CLIENTE_ONE_REG                 ) ;

        sUriMatcher.addURI( Contrato.AUTHORITY              ,
                CLIENTE_TABLE_NAME  + "/Contratos"    ,
                9                ) ;

        // Specifies a custom MIME type for the picture URL table

        sMimeTypes.put( CLIENTE_ALL_REGS                    ,
                        "vnd.android.cursor.dir/vnd."       +
                        Contrato.AUTHORITY                  +
                        "."                                 +
                        CLIENTE_TABLE_NAME                  )   ;
        
        sMimeTypes.put( CLIENTE_ONE_REG,
                        "vnd.android.cursor.item/vnd."      +
                        Contrato.AUTHORITY                  +
                        "."                                 +
                        CLIENTE_TABLE_NAME                  )   ;
    }

    public static class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onOpen(SQLiteDatabase db) {

            super.onOpen(db);

            //if (!db.isReadOnly()){
            //Habilitamos la integridad referencial
            db.execSQL("PRAGMA foreign_keys=ON;");
            //}

        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            // crear tabla Clientes

            db.execSQL( "Create table "                         + CLIENTE_TABLE_NAME        +
                        "( _id INTEGER PRIMARY KEY ON CONFLICT ROLLBACK AUTOINCREMENT, "    +
                        Contrato.TClientes.CL_NOMBRE            + " TEXT , "                +
                        Contrato.TClientes.CL_DNI               + " TEXT , "                +
                        Contrato.TClientes.DIR_VIA              + " TEXT , "                +
                        Contrato.TClientes.DIR_NUM              + " INTEGER , "             +
                        Contrato.TClientes.DIR_CP               + " TEXT , "                +
                        Contrato.TClientes.DIR_MUNICIPIO        + " TEXT , "                +
                        Contrato.TClientes.DISTANCIA_KM         + " INTEGER , "             +
                        Contrato.TClientes.CL_TELEFONO          + " TEXT , "                +
                        Contrato.TClientes.CL_PER_CONTACTO      + " TEXT ); "               ) ;

            inicializarDatos(db);

        }

        void inicializarDatos(SQLiteDatabase db){

            db.execSQL( "INSERT INTO " + CLIENTE_TABLE_NAME     + " ("  +
                            Contrato.TClientes._ID              + ","   +
                            Contrato.TClientes.CL_NOMBRE        + ","   +
                            Contrato.TClientes.CL_DNI           + ","   +
                            Contrato.TClientes.DIR_VIA          + ","   +
                            Contrato.TClientes.DIR_NUM          + ","   +
                            Contrato.TClientes.DIR_CP           + ","   +
                            Contrato.TClientes.DIR_MUNICIPIO    + ","   +
                            Contrato.TClientes.DISTANCIA_KM     + ","   +
                            Contrato.TClientes.CL_TELEFONO      + ","   +
                            Contrato.TClientes.CL_PER_CONTACTO  + ") "  +
                        "VALUES (1,'Cliente 1','11111111A','Calle cliente 1','1','01110','Ciudad C1','11','928111111','Pepe 1')");

            db.execSQL( "INSERT INTO " + CLIENTE_TABLE_NAME     + " ("  +
                            Contrato.TClientes._ID              + ","   +
                            Contrato.TClientes.CL_NOMBRE        + ","   +
                            Contrato.TClientes.CL_DNI           + ","   +
                            Contrato.TClientes.DIR_VIA          + ","   +
                            Contrato.TClientes.DIR_NUM          + ","   +
                            Contrato.TClientes.DIR_CP           + ","   +
                            Contrato.TClientes.DIR_MUNICIPIO    + ","   +
                            Contrato.TClientes.DISTANCIA_KM     + ","   +
                            Contrato.TClientes.CL_TELEFONO      + ","   +
                            Contrato.TClientes.CL_PER_CONTACTO  + ") "  +
                        "VALUES (2,'Cliente 2','22222222B','Calle cliente 2','2','02220','Ciudad C2','22','928222222','Pepe 2')");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

			db.execSQL("DROP TABLE IF EXISTS " + CLIENTE_TABLE_NAME);
            onCreate(db);

        }

    }

    public ProveedorDeContenido() {
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }


    @Override
    public boolean onCreate() {

        dbAsistente = new DatabaseHelper(getContext());
        return (dbAsistente == null) ? false : true;

    }

    public void resetDatabase() {

        dbAsistente.close();
        dbAsistente = new DatabaseHelper(getContext());

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

        String table = "" ;

        switch ( sUriMatcher.match( uri ) ) {

            case CLIENTE_ALL_REGS :

                table = CLIENTE_TABLE_NAME ;
                break ;

        }

        long rowId = sqlDB.insert( table, "", values ) ;

        if ( rowId > 0 ) {

            Uri rowUri = ContentUris.appendId( uri.buildUpon(), rowId ).build() ;
            getContext().getContentResolver().notifyChange( rowUri, null ) ;

            return rowUri ;

        }

        throw new SQLException( "Failed to insert row into " + uri ) ;
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
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        SQLiteDatabase db = dbAsistente.getReadableDatabase();

        String query = null;

        switch (sUriMatcher.match(uri)) {
            case CLIENTE_ONE_REG:
                if (null == selection) selection = "";
                selection += Contrato.TClientes._ID + " = "
                        + uri.getLastPathSegment();
                qb.setTables(CLIENTE_TABLE_NAME);
                break;
            case CLIENTE_ALL_REGS:
                if (TextUtils.isEmpty(sortOrder)) sortOrder =
                        Contrato.TClientes._ID + " ASC";
                qb.setTables(CLIENTE_TABLE_NAME);
                break;
        }

        Cursor c;
        c = qb.query(db, projection, selection, selectionArgs, null, null,
                        sortOrder);
        c.setNotificationUri(getContext().getContentResolver(), uri);

        return c;
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

        String table = "" ;

        switch ( sUriMatcher.match( uri ) ) {

            case CLIENTE_ONE_REG:

                if ( null == selection ) selection = "" ;

                selection   +=  Contrato.TClientes._ID + " = " + uri.getLastPathSegment()   ;
                table       =   CLIENTE_TABLE_NAME                                          ;

                break ;

            case CLIENTE_ALL_REGS:

                table = CLIENTE_TABLE_NAME ;

                break ;
        }

        int rows = sqlDB.update(table, values, selection, selectionArgs);
        if (rows > 0) {
            getContext().getContentResolver().notifyChange(uri, null);

            return rows;
        }
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
    public int delete(Uri uri, String selection, String[] selectionArgs) {

        sqlDB = dbAsistente.getWritableDatabase();
        // insert record in user table and get the row number of recently inserted record

        String table = "";

        switch (sUriMatcher.match(uri)) {

            case CLIENTE_ONE_REG:

                if (null == selection) selection = "";
                selection += Contrato.TClientes._ID + " = "
                        + uri.getLastPathSegment();
                table = CLIENTE_TABLE_NAME;
                break;

            case CLIENTE_ALL_REGS:

                table = CLIENTE_TABLE_NAME;

                break;

        }

        int rows = sqlDB.delete(table, selection, selectionArgs);

        if (rows > 0) {
            getContext().getContentResolver().notifyChange(uri, null);
            return rows;
        }
        throw new SQLException("Failed to delete row into " + uri);
    }

}
