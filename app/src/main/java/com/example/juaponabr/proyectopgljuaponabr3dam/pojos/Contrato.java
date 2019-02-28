/*
 * Copyright (c) 2018.  juaponabr 3º DAM Semipresencial
 */

package com.example.juaponabr.proyectopgljuaponabr3dam.pojos;

import android.os.Parcel;
import android.os.Parcelable;

public class Contrato implements Parcelable {

    private int     ctr_id              ; // Clave principal
    private int     act_precio          ;
    private String  ctr_fecha_ini       ;
    private String  ctr_dia_semana      ;
    private int     ctr_periodicidad    ;
    private String ctr_cliente ;
    private int     ctr_cl_id           ; // Clave foranea relaciona con Cliente


    public Contrato(){

        this.ctr_id             = 0     ; // Clave principal
        this.act_precio         = 0     ;
        this.ctr_fecha_ini      = ""    ;
        this.ctr_dia_semana     = ""    ;
        this.ctr_periodicidad   = 0     ;
        this.ctr_cliente    = "";
        this.ctr_cl_id          = 0     ;

    }


    public Contrato(    int     ctr_id          ,   int  act_precio          ,   String  ctr_fecha_ini   ,
                        String  ctr_dia_semana  ,   int  ctr_periodicidad    , String ctr_cliente,   int     ctr_cl_id       ) {

        this.ctr_id             = ctr_id            ;
        this.act_precio         = act_precio        ;
        this.ctr_fecha_ini      = ctr_fecha_ini     ;
        this.ctr_dia_semana     = ctr_dia_semana    ;
        this.ctr_periodicidad   = ctr_periodicidad  ;
        this.ctr_cliente = ctr_cliente ;
        this.ctr_cl_id          = ctr_cl_id         ;

    }

    ////////////////////////////////
    //
    // parseable para pasar de una
    // actividad a otra
    //
    ////////////////////////////////
    protected Contrato( Parcel in ) {

        this.ctr_id             = in.readInt()            ;
        this.act_precio         = in.readInt()       ;
        this.ctr_fecha_ini      = in.readString()     ;
        this.ctr_dia_semana     = in.readString()   ;
        this.ctr_periodicidad   = in.readInt() ;
        this.ctr_cliente      = in.readString()     ;
        this.ctr_cl_id          = in.readInt()        ;

    }

    public static final Creator<Contrato> CREATOR = new Creator<Contrato>() {

        @Override
        public Contrato createFromParcel( Parcel in ) {

            return new Contrato( in ) ;

        }

        @Override
        public Contrato[] newArray( int size ) {

            return new Contrato[ size ] ;

        }

    };


    ///////////////////////
    //
    // geters y seters
    //
    ///////////////////////


    public int getCtr_id() {
        return ctr_id;
    }

    public void setCtr_id(int ctr_id) {
        this.ctr_id = ctr_id;
    }

    public int getAct_precio() {
        return act_precio;
    }

    public void setAct_precio(int act_precio) {
        this.act_precio = act_precio;
    }

    public String getCtr_fecha_ini() {
        return ctr_fecha_ini;
    }

    public void setCtr_fecha_ini(String ctr_fecha_ini) {
        this.ctr_fecha_ini = ctr_fecha_ini;
    }

    public String getCtr_mes(){
        return this.ctr_fecha_ini.substring( 3, 5) ;
    }

    public String getCtr_dia(){
        return this.ctr_fecha_ini.substring( 0, 2) ;
    }

    public String getCtr_dia_semana() {
        return ctr_dia_semana;
    }

    public void setCtr_dia_semana(String ctr_dia_semana) {
        this.ctr_dia_semana = ctr_dia_semana;
    }

    public int getCtr_periodicidad() {
        return ctr_periodicidad;
    }

    public void setCtr_periodicidad(int ctr_periodicidad) {
        this.ctr_periodicidad = ctr_periodicidad;
    }

    public int getCtr_cl_id() {
        return ctr_cl_id;
    }

    public void setCtr_cl_id(int ctr_cl_id) {
        this.ctr_cl_id = ctr_cl_id;
    }

    public String getCtr_cliente() {
        return ctr_cliente;
    }

    public void setCtr_cliente(String ctr_cliente) {
        this.ctr_cliente = ctr_cliente;
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
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt( this.ctr_id);
        dest.writeInt( this.act_precio);
        dest.writeString( this.ctr_fecha_ini);
        dest.writeString( this.ctr_dia_semana);
        dest.writeInt( this.ctr_periodicidad);
        dest.writeString( this.ctr_cliente);
        dest.writeInt( this.ctr_cl_id);

    }
}
