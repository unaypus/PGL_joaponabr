package com.example.juaponabr.proyectopgljuaponabr3dam;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;


public class DialogoCerrar extends DialogFragment {


    /**
     * Creamos el interface que usará la MainActivity
     * al pulsar los botones del cuadro de dialogo
     */
    public interface EscuchadorDialogoCerrar {
        public void DialogoCerrarClickPositivo(DialogFragment dialog);
        public void DialogoCerrarClickNegativo(DialogFragment dialog);
    }
	
	//////////////////////////////////////////////////////////////////////
	//
	//	crear objeto del interface EscuchadorDialogoCerrar
	//
    EscuchadorDialogoCerrar elEscuchador;

    @Override
    public void onAttach(Activity activity) {

        super.onAttach(activity);

        // Verificación de que la host activity implementa el callback interface
        try {

            // Instanciamos el EscuchadorDialogoCerrar para que envie eventos al host
            elEscuchador = (EscuchadorDialogoCerrar) activity;

        } catch (ClassCastException e) {

            // Si no se ha implementado el interface, throw exception
			//
            // refinar un poco esto
			//
            throw new ClassCastException(activity.toString()
                    + " hay que implementar EscuchadorDialogoCerrar");
        }
    }
	//
	///////////////////////////////////////////////////////////////////////////
	
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
        //  así se lee un recurso string
        //
        String txt_cancelar = getString(R.string.bCancelar);
        String txt_aceptar = getString(R.string.bAceptar);
        //

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View una = inflater.inflate(R.layout.dialogo_salir, null);
        // aqui si lo lee
        //una.findViewById()

        builder.setView(una)

                .setPositiveButton(txt_aceptar, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        elEscuchador.DialogoCerrarClickPositivo(DialogoCerrar.this);
                        //dialog.cancel();
                    }
                })

                .setNegativeButton(txt_cancelar, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        elEscuchador.DialogoCerrarClickNegativo(DialogoCerrar.this);
                        //dialog.cancel();
                    }
                });

        return builder.create();
    }
	//
	///////////////////////////////////////////////////////////////////////////////

}
