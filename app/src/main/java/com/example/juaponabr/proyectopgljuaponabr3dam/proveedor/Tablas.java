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
    public static final String LA_AUTORIDAD = "com.example.juaponabr.proyectopgljuaponabr3dam." ;
    public static final String EL_PROVEEDOR = "proveedor.Gestor"                                ;
    public static final String AUTHORITY    = LA_AUTORIDAD + EL_PROVEEDOR                       ;

    // Tablas de la DB JPLM

    public static final String TABLA_CLIENTES       = "Clientes"    ;
    public static final String TABLA_CONTRATOS      = "Contratos"   ;
    public static final String TABLA_DIAS           = "Dias"        ;
    public static final String TABLA_ACTUACIONES    = "Actuaciones" ;

    public static final String DIAS_SEMANA[]    = { "Lunes"     ,   "Martes"    ,   "Miércoles" ,
                                                    "Jueves"    ,   "Viernes"   ,   "Sábado"    ,
                                                    "Domingo"                                   }  ;

    private static final String RELACIONES[][]  = {   {   "Contratos/Clientes"                ,
                                                          "Contratos.Clientes"                } ,

                                                      {   "Actuaciones/Contratos/Clientes"    ,
                                                          "Actuaciones.Contratos.Clientes"    }

                                                    } ;/**/

    // la base de datos
    private static final    String  DATABASE_NAME       = "JPLM.db"     ;
    private static final    int     DATABASE_VERSION    = 1             ;

    private static final    String  LAS_TABLAS[]        = { TABLA_CLIENTES      ,
                                                            TABLA_CONTRATOS     ,
                                                            TABLA_DIAS          ,
                                                            TABLA_ACTUACIONES   } ;

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
                                                    TContratos.CT_PRECIO + ","   +
                                                    TContratos.CT_FECHA_INI     + ","   +
                                                    TContratos.CT_DIA_SEMANA    + ","   +
                                                    TContratos.CT_PERIODICIDAD  + ","   +
                                                    TContratos.CT_CLIENTE       + ","   +
                                                    TContratos.CT_N_CL + ") "  ,

                                                    TDias._ID                   + ","   +
                                                    TDias.D_NOMBRE              + ","   +
                                                    TDias.D_ESTADO              + ","   +
                                                    TDias.D_FECHA_INI           + ","   +
                                                    TDias.D_COMENTARIO          + ") "  ,

                                                    TActuaciones._ID            + ","   +
                                                    TActuaciones.A_CLIENTE      + ","   +
                                                    TActuaciones.A_FECHA        + ","   +
                                                    TActuaciones.A_ESTADO       + ","   +
                                                    TActuaciones.A_ID_CONTRATO  + ") "  } ;



    private static final    String
    LOS_INSERTS[][] = { {   TABLA_CLIENTES                              ,

                            CAD_CAMPOS[ 0 ]                             +
                            "VALUES (1,'Cliente 1','11111111A',"        +
                            "'Calle cliente 1','1','01110','Ciudad C1'" +
                            ",'19','928111111','Pepe 1',0)"             }   ,

                        {   TABLA_CLIENTES                              ,

                            CAD_CAMPOS[ 0 ]                             +
                            "VALUES (2,'Cliente 2','22222222B',"        +
                            "'Calle cliente 2','2','02220','Ciudad C2'" +
                            ",'22','928222222','Pepe 2',0)"             }   ,

                        {   TABLA_CLIENTES                              ,

                            CAD_CAMPOS[ 0 ]                             +
                            "VALUES (3,'Cliente 3','22333322C',"        +
                            "'Calle cliente 2','2','00003','Ciudad C2'" +
                            ",'43','928000003','Pepe 3',1)"             }   ,


                        {   TABLA_CLIENTES                              ,

                            CAD_CAMPOS[ 0 ]                             +
                            "VALUES (4,'Cliente 4','24444444C',"        +
                            "'Calle cliente 2','4','00004','Ciudad C2'" +
                            ",'43','928000004','Pepe 3',0)"             }   ,



                        {   TABLA_CONTRATOS                             ,

                            CAD_CAMPOS[ 1 ]                             +
                            "VALUES (1,10,'01-12-2019','1000000',1,'Cliente 2',2)"   }   ,

                        {   TABLA_CONTRATOS                             ,

                            CAD_CAMPOS[ 1 ]                             +
                            "VALUES (2,15,'01-12-2019','0001000',2,'Cliente 4',4)"       }   ,

                        {   TABLA_CONTRATOS                             ,

                            CAD_CAMPOS[ 1 ]                             +
                            "VALUES (3,25,'11-12-2019','0100000',1,'Cliente 1',1)"    }   ,


                        {   TABLA_CONTRATOS                             ,

                            CAD_CAMPOS[ 1 ]                             +
                            "VALUES (4,25,'01-12-2019','0000001',1,'Cliente 1',1)"    } ,




                        {   TABLA_DIAS                                  ,

                            CAD_CAMPOS[ 2 ]                             +
                            "VALUES (1,'" + DIAS_SEMANA[ 0 ] + "',2,"   +
                            "'11-12-2019','Sin Comentarios')"           }   ,

                        {   TABLA_DIAS                                  ,

                            CAD_CAMPOS[ 2 ]                             +
                            "VALUES (2,'" + DIAS_SEMANA[ 1 ] + "',2,"   +
                            "'11-12-2019','Sin Comentarios')"           }   ,

                        {   TABLA_DIAS                                  ,

                            CAD_CAMPOS[ 2 ]                             +
                            "VALUES (3,'" + DIAS_SEMANA[ 2 ] + "',0,"   +
                            "'01-12-2019','Sin Comentarios')"           }   ,

                        {   TABLA_DIAS                                  ,

                            CAD_CAMPOS[ 2 ]                             +
                            "VALUES (4,'" + DIAS_SEMANA[ 3 ] + "',1,"   +
                            "'01-12-2019',"                             +
                            "'Se inicia el primero del mes, que es la " +
                            "segunda semana')"                          }   ,

                        {   TABLA_DIAS                                  ,

                            CAD_CAMPOS[ 2 ]                             +
                            "VALUES (5,'" + DIAS_SEMANA[ 4 ] + "',0,"   +
                            "'01-12-2019','Sin Comentarios')"           }   ,

                        {   TABLA_DIAS                                  ,

                            CAD_CAMPOS[ 2 ]                             +
                            "VALUES (6,'" + DIAS_SEMANA[ 5 ] + "',0,"   +
                            "'01-12-2019','Sin Comentarios')"           }   ,

                        {   TABLA_DIAS                                  ,

                            CAD_CAMPOS[ 2 ]                             +
                            "VALUES (7,'" + DIAS_SEMANA[ 6 ] + "',2,"   +
                            "'01-12-2019','Sin Comentarios')"           }   ,




                        {   TABLA_ACTUACIONES                           ,

                            CAD_CAMPOS[ 3 ]                             +
                            "VALUES (1,'Cliente 2','02-12-2019',0,1)"               }   ,

                        {   TABLA_ACTUACIONES                           ,

                            CAD_CAMPOS[ 3 ]                             +
                            "VALUES (2,'Cliente 2','09-12-2019',0,1)"               }   ,

                        {   TABLA_ACTUACIONES                           ,

                            CAD_CAMPOS[ 3 ]                             +
                            "VALUES (3,'Cliente 2','16-12-2019',0,1)"               }   ,

                        {   TABLA_ACTUACIONES                           ,

                            CAD_CAMPOS[ 3 ]                             +
                            "VALUES (4,'Cliente 2','23-12-2019',1,1)"               }   ,

                        {   TABLA_ACTUACIONES                           ,

                            CAD_CAMPOS[ 3 ]                             +
                            "VALUES (5,'Cliente 2','30-12-2019',0,1)"               }   } ;

    //  algunas constates



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
        public static final Uri CONTRATOS_URI = Uri.parse(   "content://"    +
                AUTHORITY       +
                "/"             +
                LAS_TABLAS[ 1 ]  ) ;


        public static final Uri CONTRATOS_URI_CLIENTES = Uri.parse( "content://"    +
                                                                    AUTHORITY       +
                                                                    "/"             +
                                                                    TABLA_CONTRATOS+"/"+TABLA_CLIENTES ) ;

        // Columnas de la tabla

        // esta columna se usa por defecto y no hace falta crearla
        // public static final String _ID              = "_ID"          ; // Clave principal

        public static final String CT_PRECIO = "ct_Precio"      ;
        public static final String CT_FECHA_INI     = "ct_Fecha_Ini"    ;

        public static final String CT_DIA_SEMANA    = "ct_Dia_Semana"   ;

        public static final String CT_PERIODICIDAD  = "ct_Periodicidad" ;

        public static final String CT_CLIENTE       = "ct_cliente" ;
        public static final String CT_N_CL = "ct_id_cliente"      ;

        /**/

    }/**/

    /**
     *
     * Modelo de la tabla Dias y sus campos
     *
     */
    public static final class TDias implements BaseColumns {

        // Tabla Clientes
        public static final Uri DIAS_URI = Uri.parse(   "content://"    +
                                                        AUTHORITY       +
                                                        "/"             +
                                                        TABLA_DIAS      ) ;

        // Columnas de la tabla

        // esta columna se usa por defecto y no hace falta crearla
        //public static final String _ID              = "_ID"          ; // Clave principal

        public static final String D_NOMBRE     = "d_nombre"      ;
        public static final String D_ESTADO     = "d_estado"      ;
        public static final String D_FECHA_INI  = "d_fecha"       ;
        public static final String D_COMENTARIO = "d_comentario"  ;

    }

    /**
     *
     * Modelo de la tabla Actuaciones y sus campos
     *
     */
    public static final class TActuaciones implements BaseColumns {

        // Tabla Clientes
        public static final Uri ACTUACIONES_URI = Uri.parse(    "content://"        +
                                                                AUTHORITY           +
                                                                "/"                 +
                                                                TABLA_ACTUACIONES   ) ;

        public static final Uri URI_ACT_CONT_CLI = Uri.parse(   "content://"        +
                                                                AUTHORITY           +   "/" +
                                                                TABLA_ACTUACIONES   +   "/" +
                                                                TABLA_CONTRATOS      ) ;

        // Columnas de la tabla

        // esta columna se usa por defecto y no hace falta crearla
        //public static final String _ID              = "_ID"          ; // Clave principal

        public static final String A_CLIENTE        = "a_cliente"       ;
        public static final String A_FECHA          = "a_fecha"         ;
        public static final String A_ESTADO         = "a_estado"        ;
        public static final String A_ID_CONTRATO    = "a_id_contrato"   ;

    }

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

                                TContratos.CT_PRECIO + " INTEGER , "         +
                                TContratos.CT_FECHA_INI     + " TEXT , "            +
                                TContratos.CT_DIA_SEMANA    + " TEXT , "            +
                                TContratos.CT_PERIODICIDAD  + " INTEGER ,"          +
                                TContratos.CT_CLIENTE       + " TEXT , "            +
                                TContratos.CT_N_CL          + " INTEGER ); "        ,

                                TDias.D_NOMBRE              + " TEXT , "            +
                                TDias.D_ESTADO              + " INTEGER , "         +
                                TDias.D_FECHA_INI           + " TEXT , "            +
                                TDias.D_COMENTARIO          + " TEXT ); "           ,

                                TActuaciones.A_CLIENTE      + " TEXT , "            +
                                TActuaciones.A_FECHA        + " TEXT , "            +
                                TActuaciones.A_ESTADO       + " INTEGER , "         +
                                TActuaciones.A_ID_CONTRATO  + " INTEGER ); "        };
                                        //TActuaciones.A_ID_CONTRATO  + " INTEGER ,"+"FOREIGN KEY("+TActuaciones.A_ID_CONTRATO+") REFERENCES "+TABLA_CONTRATOS+"("+TContratos._ID+")); "} ;



        //TContratos.CT_N_CL + " INTEGER ,"+"FOREIGN KEY("+TContratos.CT_N_CL +") REFERENCES "+TABLA_CLIENTES+"("+TClientes._ID+")); ",

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
    protected static   String[][]   getLasRelaciones()      { return RELACIONES         ; }
    protected static   String[][]   getLosInserts()         { return LOS_INSERTS        ; }

}
