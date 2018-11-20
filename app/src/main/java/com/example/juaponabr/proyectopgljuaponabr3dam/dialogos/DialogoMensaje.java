/*
 * Copyright (c) 2018.  juaponabr 3º DAM Semipresencial
 */

package com.example.juaponabr.proyectopgljuaponabr3dam.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

import com.example.juaponabr.proyectopgljuaponabr3dam.R;

public class DialogoMensaje extends DialogFragment {

    private String elTitulo;
    private String elMensaje ;

    public DialogoMensaje( String elTitulo, String elMensaje ){

        this.elTitulo   = elTitulo  ;
        this.elMensaje  = elMensaje ;

    }
    public DialogoMensaje(){}

    ///////////////////////////////////////////////////////////////////////////
    /**
     *
     * crear el cuadro de dialogo
     *
     */
    @Override
    public Dialog onCreateDialog( Bundle savedInstanceState ) {

         return new AlertDialog.Builder(    getActivity()           )
                    .setTitle(              this.elTitulo           )
                    .setMessage(            this.elMensaje          )
                    .setPositiveButton(     R.string.bAceptar, null )
                    .create()                                       ;

    }
    //
    ///////////////////////////////////////////////////////////////////////////////

    public void setElTitulo(    String elTitulo     ) { this.elTitulo   = elTitulo  ; }
    public void setElMensaje(   String elMensaje    ) { this.elMensaje  = elMensaje ; }

}
