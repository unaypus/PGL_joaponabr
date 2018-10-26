package com.example.juaponabr.proyectopgljuaponabr3dam;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Iniciamos la rama (branch) entrega2 con la edición de este comentario
 * gracias al cual comprobaremos que:
 *
 * 1 - la rama entrega1 ha sido mezclada correctamente con master
 * 2 - la rama entrega2 está creada a partir de la unión de master y entrega1
 * 3 - se realizará un push para que el githup esté igual que el git local
 *
 */
public class MainActivity extends AppCompatActivity implements DialogoCerrar.EscuchadorDialogoCerrar {

    // variables de clase
	
	// botones
    Button bActuaciones;
    Button bNuevaActuacion ;
    Button bClientes;
    Button bNuevoCliente ;
    Button bSalir ;
	
	// intentos ( para lanzar activitys )
    Intent intento;
	
	/**
	 *
	 * Crear e iniciar la activity
	 *
	 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activarEscuchadores();

    }
	
	/**
	 *
	 * activamos los escuchadores de los botones
	 *
	 */
    private void activarEscuchadores() {
		
		//
		//	botones actuaciones
		//
		// para ver el listado o crear una nueva
		//
        bActuaciones = findViewById(R.id.buttonActuaciones);

        bActuaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intento = new Intent(MainActivity.this,ListadoActuaciones.class);
                startActivity(intento);
            }
        });
		
		bNuevaActuacion = findViewById(R.id.buttonNueva);

        bNuevaActuacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intento = new Intent(MainActivity.this,EditaActuacion.class);
                startActivity(intento);
            }
        });
		
		
		
	
		//
		//	botones cliente
		//
		// para ver el listado o crear uno nuevo
		//
        bClientes = findViewById(R.id.buttonClientes);

        bClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intento = new Intent(MainActivity.this,ListadoClientes.class);
                startActivity(intento);
            }
        });

        bNuevoCliente = findViewById(R.id.buttonNuevo);

        bNuevoCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intento = new Intent(MainActivity.this,EditaCliente.class);
                startActivity(intento);
            }
        });
		
		
		
		
		//
		//	boton de salida 
		//
		// que lanza un cuadro de dialogo para preguntar
		// al usuario si desea cerrar la aplicación
		// 
		bSalir = findViewById(R.id.buttonSalir);

        bSalir.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                FragmentManager manejador = getFragmentManager();
                DialogoCerrar dCerrar = new DialogoCerrar();
                dCerrar.show(manejador,"elDialogoCerrar");

            }
        });

    }
	
	/**
	 *
	 * método del interface EscuchadorDialogoCerrar
	 * que cierra la aplicación y libera la memoria
	 *
	 */
    @Override
    public void DialogoCerrarClickPositivo(DialogFragment dialog) {
		
		///////////////////////////////////////////////////////
		//
        // Hay dos dos acciones que cierran la aplicación
		//
		// Esta solo cierra las ventanas y sigue estando
		// en memoria
		//
        //		MainActivity.super.finish();
		//
		// Esta otra cierra la aplicación y libera la memoria
		//
        //		MainActivity.super.finishAndRemoveTask();
		//
        // usamos la segunda forma porque queromas cerrar la 
		// aplicación del todo
		//
		
        MainActivity.super.finishAndRemoveTask();
    }
	
	/**
	 *
	 * método del interface EscuchadorDialogoCerrar
	 * que no hace nada y permite seguir con la aplicación
	 *
	 */
    @Override
    public void DialogoCerrarClickNegativo(DialogFragment dialog) {
        // no hacer nada y volver al MainActivity
    }
	
}
