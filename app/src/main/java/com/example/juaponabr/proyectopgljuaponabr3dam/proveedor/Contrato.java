package com.example.juaponabr.proyectopgljuaponabr3dam.proveedor;

import android.net.Uri;
import android.provider.BaseColumns;

public class Contrato {

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

    public static final String LA_AUTORIDAD     = "com.example.juaponabr.proyectopgljuaponabr3dam." ;
    public static final String EL_PROVEEDOR     = "proveedor.ProveedorDeContenido"                  ;

    public static final String AUTHORITY        = LA_AUTORIDAD + EL_PROVEEDOR                       ;
    //public static final String AUTHORITY        ="com.example.juaponabr.proyectopgljuaponabr3dam.proveedor.ProveedorDeContenido"  ;
    public static final String TABLA_CLIENTES   = "Cliente"                                         ;

    /**
     *
     * Creación de la conexión con una tabla y sus campos
     *
     */
    public static final class TClientes implements BaseColumns {

        // Tabla Clientes
        public static final Uri CONTENT_URI = Uri.parse(    "content://"    +
                                                            AUTHORITY       +
                                                            "/"             +
                                                            TABLA_CLIENTES  ) ;

        // Columnas de la tabla


        //public static final String _ID              = "ID"          ; // Clave principal
        public static final String CL_NOMBRE        = "Nombre"      ;
        public static final String CL_DNI           = "DNI"      ;

        public static final String DIR_VIA          = "Via"         ;
        public static final String DIR_NUM          = "Num"          ;
        public static final String DIR_CP           = "CP"          ;
        public static final String DIR_MUNICIPIO    = "Municipio"   ;
        public static final String DISTANCIA_KM     = "Km"         ;

        public static final String CL_TELEFONO      = "Tel"        ;
        public static final String CL_PER_CONTACTO  = "PerCont"  ;

    }



}
