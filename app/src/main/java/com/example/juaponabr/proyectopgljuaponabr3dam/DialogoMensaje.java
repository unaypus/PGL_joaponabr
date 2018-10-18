package com.example.juaponabr.proyectopgljuaponabr3dam;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.view.View;

public class DialogoMensaje extends DialogFragment {


    ///////////////////////////////////////////////////////////////////////////
    /**
     *
     * crear el cuadro de dialogo
     *
     */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        //////////////////////////////////////////////////////////////
        //
        //  ¿¿¿¿¿¿¿¿¿¿¿ cómo leo un recurso string ??????????
        //
        String txt_aceptar = "Aceptar";//R.string.bAceptar;

        return new AlertDialog.Builder(getActivity())
                .setTitle(R.string.txt_modulo_construccion)
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }


    //
    ///////////////////////////////////////////////////////////////////////////////

}
