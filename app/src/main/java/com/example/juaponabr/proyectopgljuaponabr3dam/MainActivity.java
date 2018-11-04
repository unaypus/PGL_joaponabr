package com.example.juaponabr.proyectopgljuaponabr3dam;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 *
 * /////////////////////////////////////////////////////////////////////////////////////////////////
 *
 *  Histórico
 *
 *  de lo mas nuevo a lo mas antiguo
 *
 * /////////////////////////////////////////////////////////////////////////////////////////////////
 *
 *      Domingo 04/11/2018 11:06
 *
 * /////////////////////////////
 *
 * Aunque pareciese redundante se realizará otro "commit" y posteriormnte crearemos una subrama
 * dentro de -entrega2- para asegurar  que no rompemos nada y poder volver en  caso de desastre
 *
 * La nueva rama  en cuestión se  llamara 'navegaPestanyas' y  para el "commit"  pondremos  el
 * comentario ' Preparación para la navegación por pestañas deslizantes '
 *
 * /////////////////////////////////////////////////////////////////////////////////////////////////
 *
 *      Domingo 04/11/2018 10:43
 *
 * /////////////////////////////
 *
 * Vamos ha dar por finalizada la navegación por botones y se pasará a la navegación por pestañas
 * deslizantes.
 *
 * Con la finalidad de poder seguir mas adelante con la navegación por botones o en caso de fallo
 * general en el nuevo diseño de navegación por pestañas, realizaremos un "commit" de este estado
 * con el comentario ' Navegación por botones terminada y estable '
 *
 * /////////////////////////////////////////////////////////////////////////////////////////////////
 *
 *      Viernes 26/10/2018 11:05
 *
 * /////////////////////////////
 *
 * Iniciamos la rama (branch) entrega2 con la edición de este comentario
 * gracias al cual comprobaremos que:
 *
 * 1 - la rama entrega1 ha sido mezclada correctamente con master
 * 2 - la rama entrega2 está creada a partir de la unión de master y entrega1
 * 3 - se realizará un push para que el githup esté igual que el git local
 *
 * /////////////////////////////////////////////////////////////////////////////////////////////////
 *
 */
public class MainActivity extends AppCompatActivity implements DialogoCerrar.EscuchadorDialogoCerrar {

    // variables de clase
	
	// botones
    Button  bActuaciones    ;
    Button  bNuevaActuacion ;
    Button  bClientes       ;
    Button  bNuevoCliente   ;
    Button  bSalir          ;
	
	// intentos ( para lanzar activitys )
    Intent  intento         ;
	
	/**
	 *
	 * Crear e iniciar la activity
	 *
	 */
    @Override
    protected void onCreate( Bundle savedInstanceState ) {

        super.onCreate( savedInstanceState      )   ;
        setContentView( R.layout.activity_main  )   ;
        activarEscuchadores()                       ;

    }
	
	/**
	 *
	 * activamos los escuchadores de los botones
	 *
	 */
    private void activarEscuchadores() {

        ////////////////////////////////////////////////////////////////////////////////////////////
        //
        //  Botones Navegación entre Activitys      ////////////////////////////////////////////////
        //
        ////////////////////////////////////////////
        //
		//	botones actuaciones
		//
        ////////////////////////////////////////////
        //
        // botón para ir al listado de actuaciones
		//

        bActuaciones = findViewById( R.id.buttonActuaciones ) ;

        bActuaciones.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick( View v ) {

                intento = new Intent( MainActivity.this, ListadoActuaciones.class ) ;
                startActivity( intento ) ;

            }

        }) ;

        ////////////////////////////////////////////
        //
        // botón para crear una nueva
        //

		bNuevaActuacion = findViewById( R.id.buttonNueva ) ;

        bNuevaActuacion.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick( View v ) {

                intento = new Intent( MainActivity.this, EditaActuacion.class ) ;
                startActivity( intento ) ;

            }

        }) ;

        ////////////////////////////////////////////
        //
		//	botones cliente
		//
        ////////////////////////////////////////////
        //
        // botón para ir al listado de clientes
		//

        bClientes = findViewById( R.id.buttonClientes ) ;

        bClientes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick( View v ) {

                intento = new Intent( MainActivity.this, ListadoClientes.class ) ;
                startActivity( intento ) ;

            }

        }) ;

        ////////////////////////////////////////////
        //
        // botón para crear uno nuevo
        //

        bNuevoCliente = findViewById( R.id.buttonNuevo ) ;

        bNuevoCliente.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick( View v ) {

                intento = new Intent( MainActivity.this, EditaCliente.class ) ;
                startActivity( intento ) ;

            }

        }) ;

        ////////////////////////////////////////////
        //
        // botón de salida
		//
		// que lanza un cuadro de dialogo para preguntar
		// al usuario si desea cerrar la aplicación
		//

		bSalir = findViewById( R.id.buttonSalir ) ;

        bSalir.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick( View v ) {

                FragmentManager manejador   = getFragmentManager()  ;
                DialogoCerrar   dCerrar     = new DialogoCerrar()   ;

                dCerrar.show( manejador, "elDialogoCerrar" )        ;

            }

        }) ;

    }

	/**
	 *
	 * método del interface EscuchadorDialogoCerrar
	 * que cierra la aplicación y libera la memoria
	 *
	 */
    @Override
    public void DialogoCerrarClickPositivo( DialogFragment dialog ) {
		
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
		
        MainActivity.super.finishAndRemoveTask() ;

    }
	
	/**
	 *
	 * método del interface EscuchadorDialogoCerrar
	 * que no hace nada y permite seguir con la aplicación
	 *
	 */
    @Override
    public void DialogoCerrarClickNegativo( DialogFragment dialog ) {

        // no hacer nada y volver al MainActivity

    }
	
}
