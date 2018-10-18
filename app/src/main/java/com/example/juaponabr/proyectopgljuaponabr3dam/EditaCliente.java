package com.example.juaponabr.proyectopgljuaponabr3dam;

import android.content.Context;
import android.os.Bundle;

public class EditaCliente extends EditaRegistro {

    // variables de clase
    private Context elContexto ;
    // crear la sentencia : elContexto = la_activity.this;
    // antes de llamar a : activarEscuchadores();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edita_cliente);
        iniBarraHerramientas();
        elContexto = EditaCliente.this;
        activarEscuchadores( elContexto );
    }

}
