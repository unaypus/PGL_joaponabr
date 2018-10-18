package com.example.juaponabr.proyectopgljuaponabr3dam;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class EditaActuacion extends EditaRegistro {

    // variables de clase
    private Context elContexto ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edita_actuacion);
        iniBarraHerramientas();
        findViewById(R.id.editTextDia).setFocusable(false);
        elContexto = EditaActuacion.this;
        activarEscuchadores( elContexto );
        activarElementos();
    }

    private void activarElementos() {
        ImageButton bBuscarCliente = findViewById(R.id.iButtonBuscaCliente);
        bBuscarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { modEnConstruccion(); }
        });
        EditText elDia = findViewById(R.id.editTextDia);
        elDia.setFocusable(false);
        elDia.setOnClickListener(new View.OnClickListener());
    }

}
