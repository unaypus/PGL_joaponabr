package com.example.juaponabr.proyectopgljuaponabr3dam.proveedor;

import android.net.Uri;
import android.provider.BaseColumns;

public class Tablas {

    //////////////////////////////////////////////////////////////////
    //
    //                  ATENCIÓN PREGUNTA.
    //
    //
    //      ¿   No deberían ser las variables private
    //          y de este modo solo poder acceder a
    //          ellas por medio de los getters y setters    ?
    //
    //
    ///////////////////////////////////////////////////////////////////

    // La autoridad del proveedor
    public static final String LA_AUTORIDAD     = "com.example.juaponabr.proyectopgljuaponabr3dam." ;
    public static final String EL_PROVEEDOR     = "proveedor.Gestor"                                ;
    public static final String AUTHORITY        = LA_AUTORIDAD + EL_PROVEEDOR                       ;

    // Tablas de la DB JPLM

    public static final String TABLA_CLIENTES   = "Clientes"                                         ;
    public static final String TABLA_CONTRATOS  = "Contratos"                                        ;


    // la base de datos
    private static final    String  DATABASE_NAME       = "JPLM.db"     ;
    private static final    int     DATABASE_VERSION    = 1             ;

    private static final    String  LAS_TABLAS[]        = { TABLA_CLIENTES  ,
                                                            TABLA_CONTRATOS } ;

    private static final String CAD_CAMPOS[] = {    TClientes._ID               + ","   +
                                                    TClientes.CL_NOMBRE         + ","   +
                                                    TClientes.CL_DNI            + ","   +
                                                    TClientes.DIR_VIA           + ","   +
                                                    TClientes.DIR_NUM           + ","   +
                                                    TClientes.DIR_CP            + ","   +
                                                    TClientes.DIR_MUNICIPIO     + ","   +
                                                    TClientes.DISTANCIA_KM      + ","   +
                                                    TClientes.CL_TELEFONO       + ","   +
                                                    TClientes.CL_PER_CONTACTO   + ","   +
                                                    TClientes.CL_BAJA           + ") "  ,

                                                    TContratos._ID              + ","   +
                                                    TContratos.ACT_PRECIO       + ","   +
                                                    TContratos.CT_FECHA_INI     + ","   +
                                                    TContratos.CT_DIA_SEMANA    + ","   +
                                                    TContratos.CT_PERIODICIDAD  + ","   +
                                                    TContratos.CT_CL_ID         + ") "  } ;



    private static final    String
    LOS_INSERTS[][] = { {   TABLA_CLIENTES                              ,

                            CAD_CAMPOS[ 0 ]                             +
                            "VALUES (1,'Cliente 1','11111111A',"        +
                            "'Calle cliente 1','1','01110','Ciudad C1'" +
                            ",'11','928111111','Pepe 1',0)"             }   ,

                        {   TABLA_CLIENTES                              ,

                            CAD_CAMPOS[ 0 ]                             +
                            "VALUES (2,'Cliente 2','22222222B',"        +
                            "'Calle cliente 2','2','02220','Ciudad C2'" +
                            ",'22','928222222','Pepe 2',0)"             }   ,

                        {   TABLA_CLIENTES                              ,

                            CAD_CAMPOS[ 0 ]                             +
                            "VALUES (3,'Cliente 3','22333322C',"        +
                            "'Calle cliente 2','2','00003','Ciudad C2'" +
                            ",'3','928000003','Pepe 3',1)"             }   ,


                        {   TABLA_CLIENTES                              ,

                            CAD_CAMPOS[ 0 ]                             +
                            "VALUES (4,'Cliente 4','24444444C',"        +
                            "'Calle cliente 2','4','00004','Ciudad C2'" +
                            ",'3','928000004','Pepe 3',0)"             }   ,

                        {   TABLA_CONTRATOS                             ,

                            CAD_CAMPOS[ 1 ]                             +
                            "VALUES (1,10,'01-12-2018','Viernes, "      +
                            "Domingo','1',2)"                           }   ,

                        {   TABLA_CONTRATOS                             ,

                            CAD_CAMPOS[ 1 ]                             +
                            "VALUES (2,25,'11-12-2018','Martes', "      +
                            "'0',1)"                                    }   } ;


    /**
     *
     * Modelo de la tabla Clientes y sus campos
     *
     */
    public static final class TClientes implements BaseColumns {

        // Tabla Clientes
        public static final Uri CLIENTES_URI = Uri.parse(   "content://"    +
                                                            AUTHORITY       +
                                                            "/"             +
                                                            LAS_TABLAS[ 0 ]  ) ;

        // Columnas de la tabla

        // esta columna se usa por defecto y no hace falta crearla
        //public static final String _ID              = "_ID"          ; // Clave principal
        public static final String CL_NOMBRE        = "Nombre"      ;
        public static final String CL_DNI           = "DNI"         ;

        public static final String DIR_VIA          = "Via"         ;
        public static final String DIR_NUM          = "Num"         ;
        public static final String DIR_CP           = "CP"          ;
        public static final String DIR_MUNICIPIO    = "Municipio"   ;
        public static final String DISTANCIA_KM     = "Km"          ;

        public static final String CL_TELEFONO      = "Tel"         ;
        public static final String CL_PER_CONTACTO  = "PerCont"     ;
        public static final String CL_BAJA          = "Baja"        ;

    }

    /**
     *
     * Modelo de la tabla Contratos y sus campos
     *
     */
    public static final class TContratos implements BaseColumns {

        // Tabla Contratos
        public static final Uri CONTRATOS_URI = Uri.parse(  "content://"    +
                                                            AUTHORITY       +
                                                            "/"             +
                                                            TABLA_CONTRATOS ) ;

        // Columnas de la tabla

        // esta columna se usa por defecto y no hace falta crearla
        // public static final String _ID              = "_ID"          ; // Clave principal

        public static final String ACT_PRECIO       = "act_Precio"      ;
        public static final String CT_FECHA_INI     = "ct_Fecha_Ini"    ;

        public static final String CT_DIA_SEMANA    = "ct_Dia_Semana"   ;

        public static final String CT_PERIODICIDAD  = "ct_Periodicidad" ;

        public static final String CT_CL_ID         = "ID_Cliente"      ;

        /**/

    }/**/

    protected static   String      getCreates( int laTabla ) {

        String laSalida[] = {   TClientes.CL_NOMBRE         + " TEXT , "            +
                                TClientes.CL_DNI            + " TEXT , "            +
                                TClientes.DIR_VIA           + " TEXT , "            +
                                TClientes.DIR_NUM           + " INTEGER , "         +
                                TClientes.DIR_CP            + " TEXT , "            +
                                TClientes.DIR_MUNICIPIO     + " TEXT , "            +
                                TClientes.DISTANCIA_KM      + " INTEGER , "         +
                                TClientes.CL_TELEFONO       + " TEXT , "            +
                                TClientes.CL_PER_CONTACTO   + " TEXT ,"             +
                                TClientes.CL_BAJA           + " INTEGER ); "        ,

                                TContratos.ACT_PRECIO       + " INTEGER , "         +
                                TContratos.CT_FECHA_INI     + " TEXT , "            +
                                TContratos.CT_DIA_SEMANA    + " TEXT , "            +
                                TContratos.CT_PERIODICIDAD  + " INTEGER ,"          +
                                TContratos.CT_CL_ID         + " INTEGER ,"          +
                                                              "FOREIGN KEY("        +
                                TContratos.CT_CL_ID         + ") REFERENCES "       +
                                TABLA_CLIENTES              + "("                   +
                                TClientes._ID               + "));"                 } ;

        return  laSalida[ laTabla ] ;

        /*
        CREATE TABLE track(
        trackid     INTEGER,
        trackname   TEXT,
        trackartist INTEGER,
        FOREIGN KEY(trackartist) REFERENCES artist(artistid)
        );
         */
    }

    protected static   String       getDatabaseName()       { return DATABASE_NAME      ; }
    protected static   int          getDatabaseVersion()    { return DATABASE_VERSION   ; }
    protected static   String[]     getLasTablas()          { return LAS_TABLAS         ; }
    protected static   String[][]   getLosInserts()         { return LOS_INSERTS        ; }

}
