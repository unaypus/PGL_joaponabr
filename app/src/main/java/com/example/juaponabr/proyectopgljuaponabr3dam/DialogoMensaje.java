package com.example.juaponabr.proyectopgljuaponabr3dam;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

public class DialogoMensaje extends DialogFragment {

    private String elTitulo;
    private String elMensaje ;

    public DialogoMensaje( String elTitulo, String elMensaje){
        this.elTitulo = elTitulo;
        this.elMensaje = elMensaje;
    }
    ///////////////////////////////////////////////////////////////////////////
    /**
     *
     * crear el cuadro de dialogo
     *
     */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

         return new AlertDialog.Builder(getActivity())
                 .setTitle( this.elTitulo )
                 .setMessage( this.elMensaje )
                 .setPositiveButton( R.string.bAceptar, null)
                 .create();

    }
    //
    ///////////////////////////////////////////////////////////////////////////////

}
