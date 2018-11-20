package com.example.juaponabr.proyectopgljuaponabr3dam.pojos;

import android.os.Parcel;
import android.os.Parcelable;

public class Cliente implements Parcelable {

    private int     cl_id           ; // Clave principal
    private String  cl_nombre       ;
    private String  cl_dni          ;

    private String  dir_via         ;
    private int     dir_num         ;
    private String  dir_cp          ;
    private String  dir_localidad   ;
    private int     distanacia      ;

    private String  cl_telefono     ;
    private String  cl_per_contacto ; // persona de contacto del cliente

    /**
     * Constructor del objeto con valores por defecto
     */
    public Cliente(){

        this.cl_id              = 0     ;
        this.cl_nombre          = ""    ;
        this.cl_dni             = ""    ;
        this.dir_via            = ""    ;
        this.dir_num            = 0     ;
        this.dir_cp             = ""    ;
        this.dir_localidad      = ""    ;
        this.distanacia         = 0     ;
        this.cl_telefono        = ""    ;
        this.cl_per_contacto    = ""    ;

    }

    /**
     * Constructor del objeto recibiendo los datos
     * de edición o procedentesde la lectura de la tabla
     *
     * @param cl_id
     * @param cl_nombre
     * @param cl_dni
     * @param dir_via
     * @param dir_num
     * @param dir_cp
     * @param dir_localidad
     * @param distanacia
     * @param cl_telefono
     * @param cl_per_contacto
     */
    public Cliente( int     cl_id            , String   cl_nombre       , String cl_dni ,
                    String  dir_via          , int      dir_num         , String dir_cp ,
                    String  dir_localidad    , int      distanacia      ,
                    String  cl_telefono      , String   cl_per_contacto ) {

        this.cl_id              = cl_id             ;
        this.cl_nombre          = cl_nombre         ;
        this.cl_dni             = cl_dni            ;
        this.dir_via            = dir_via           ;
        this.dir_num            = dir_num           ;
        this.dir_cp             = dir_cp            ;
        this.dir_localidad      = dir_localidad     ;
        this.distanacia         = distanacia        ;
        this.cl_telefono        = cl_telefono       ;
        this.cl_per_contacto    = cl_per_contacto   ;

    }

    ////////////////////////////////
    //
    // parseable para pasar de una
    // actividad a otra
    //
    ////////////////////////////////

    /**
     * Constructor parseable
     * @param in
     */
    protected Cliente( Parcel in ) {

        cl_id           = in.readInt()      ;
        cl_nombre       = in.readString()   ;
        cl_dni          = in.readString()   ;
        dir_via         = in.readString()   ;
        dir_num         = in.readInt()      ;
        dir_cp          = in.readString()   ;
        dir_localidad   = in.readString()   ;
        distanacia      = in.readInt()      ;
        cl_telefono     = in.readString()   ;
        cl_per_contacto = in.readString()   ;

    }

    public static final Creator<Cliente> CREATOR = new Creator<Cliente>() {

        @Override
        public Cliente createFromParcel( Parcel in ) {

            return new Cliente( in ) ;

        }

        @Override
        public Cliente[] newArray( int size ) {

            return new Cliente[ size ] ;

        }

    };

    ///////////////////////
    //
    // geters y seters
    //
    ///////////////////////
    public int getCl_id() {
        return cl_id;
    }

    public void setCl_id(int cl_id) {
        this.cl_id = cl_id;
    }

    public String getCl_nombre() {
        return cl_nombre;
    }

    public void setCl_nombre(String cl_nombre) {
        this.cl_nombre = cl_nombre;
    }

    public String getCl_dni() {
        return cl_dni;
    }

    public void setCl_dni(String cl_dni) {
        this.cl_dni = cl_dni;
    }

    public String getDir_via() {
        return dir_via;
    }

    public void setDir_via(String dir_via) {
        this.dir_via = dir_via;
    }

    public int getDir_num() {
        return dir_num;
    }

    public void setDir_num(int dir_num) {
        this.dir_num = dir_num;
    }

    public String getDir_cp() {
        return dir_cp;
    }

    public void setDir_cp(String dir_cp) {
        this.dir_cp = dir_cp;
    }

    public String getDir_localidad() {
        return dir_localidad;
    }

    public void setDir_localidad(String dir_localidad) {
        this.dir_localidad = dir_localidad;
    }

    public int getDistanacia() {
        return distanacia;
    }

    public void setDistanacia(int distanacia) {
        this.distanacia = distanacia;
    }

    public String getCl_telefono() {
        return cl_telefono;
    }

    public void setCl_telefono(String cl_telefono) {
        this.cl_telefono = cl_telefono;
    }

    public String getCl_per_contacto() {
        return cl_per_contacto;
    }

    public void setCl_per_contacto(String cl_per_contacto) {
        this.cl_per_contacto = cl_per_contacto;
    }


    //////////////////////////////////////////
    //
    // auxiliares de parseable
    // para pasrlos de una actividad a otra
    //
    //////////////////////////////////////////
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel( Parcel dest, int flags ) {

        dest.writeInt(      this.cl_id              ) ;
        dest.writeString(   this.cl_nombre          ) ;
        dest.writeString(   this.cl_dni             ) ;

        dest.writeString(   this.dir_via            ) ;
        dest.writeInt(      this.dir_num            ) ;
        dest.writeString(   this.dir_cp             ) ;
        dest.writeString(   this.dir_localidad      ) ;

        dest.writeInt(      this.distanacia         ) ;

        dest.writeString(   this.cl_telefono        ) ;
        dest.writeString(   this.cl_per_contacto    ) ;


    }

}
