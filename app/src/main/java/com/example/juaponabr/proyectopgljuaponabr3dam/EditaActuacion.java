package com.example.juaponabr.proyectopgljuaponabr3dam;

import android.content.Context;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class EditaActuacion extends EditaRegistro {

    // variables de clase
    //private Context elContexto              ;
    private int     nDias           = 0     ;
    private String  sPeriodicidad   = ""    ;

    // variables de la vista
    private ImageButton bBuscarCliente  ;
    private CheckBox    chBoxDias []    ;
    private RadioGroup  rGpPeriodicidad ;
    private RadioButton rBnPeriodicidad ;
    private EditText    edtDia          ;
    private EditText    edtMes          ;
    private EditText    edtCliente      ;
    private EditText    edtPrecio       ;


    @Override
    protected void onCreate( Bundle savedInstanceState ) {

        super.onCreate( savedInstanceState )                ;
        setContentView( R.layout.activity_edita_actuacion ) ;
        iniBarraHerramientas()                              ;
        activarEscuchadores( EditaActuacion.this )          ;
        activarElementos()                                  ;

    }

    private void activarElementos() {

        //////////////////////////////////////////////////////////////
        //
        //  EdiText para el cliente
        //

        edtCliente = findViewById( R.id.editTextCliente );

        //////////////////////////////////////////////////////////////
        //
        //  Botón para buscar y seleccionar un cliente
        //

        bBuscarCliente = findViewById(R.id.iButtonBuscaCliente);
        bBuscarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { modEnConstruccion(); }
        });

        //////////////////////////////////////////////////////////////
        //
        //  EdiText para la fecha
        //

        edtDia = findViewById( R.id.editTextDia );
        edtMes = findViewById( R.id.editTextMes );

        /*

        //      van por ahí los tiros


        //TextWatcher textWatcher;
        TextWatcher textWatcher = ;
        edtDia.addTextChangedListener(textWatcher);

        */

        //////////////////////////////////////////////////////////////
        //
        //  EdiText para el precio
        //

        edtPrecio = findViewById( R.id.editTextPrecio);

        /////////////////////////////////////////////////////
        //
        // Cargar los checkbox de los días de la semana
        //

        chBoxDias   = new CheckBox[ 7 ]     ;

        chBoxDias[ 0 ] = findViewById( R.id.checkBoxLunes       );
        chBoxDias[ 1 ] = findViewById( R.id.checkBoxMartes      );
        chBoxDias[ 2 ] = findViewById( R.id.checkBoxMiercoles   );
        chBoxDias[ 3 ] = findViewById( R.id.checkBoxJueves      );
        chBoxDias[ 4 ] = findViewById( R.id.checkBoxViernes     );
        chBoxDias[ 5 ] = findViewById( R.id.checkBoxSabado      );
        chBoxDias[ 6 ] = findViewById( R.id.checkBoxDomingo     );

        ///////////////////////////////////////////////////////
        //
        //  CONSEJO PARA LA OBTENCIÓN DEL FOCUS
        //
        ///////////////////////////////////////////////////////
        //
        //      ¿¿¿¿ como optener el foco automaticamente ????
        //
        //      //////////////////////////////////////////////
        //
        //      Poner el foco por defecto en xml
        //
        // android:focusableInTouchMode="true"><requestFocus/></CheckBox>
        //
        //      Activarlo en tiempo de ejecución con java
        //
        // chBoxDias[queDia].setFocusableInTouchMode(true);
        // chBoxDias[queDia].requestFocus();
        //
        ///////////////////////////////////////////////////////

        ///////////////////////////////////////////////////////
        //
        //      CUADROS DE SELECCIÓN
        //
        ///////////////////////////////////////////////////////
        //
        // activar los escuchadores
        // actualizar cuantos días han sido seleccionados
        //

        for ( int queDia = 0 ; queDia < 7 ; queDia++ ) {

            final int finalQueDia = queDia  ;

            chBoxDias[ queDia ].setOnClickListener( new View.OnClickListener() {

                @Override
                public void onClick( View v ) {

                    /*

                    actualiza la variables nDias
                    0 para ningún día escogido
                    7 como máximo

                     */

                    if ( chBoxDias[ finalQueDia ].isChecked() ) {
                        nDias++ ;
                    } else {
                        nDias-- ;
                    }

                }
            } )    ;

        }
        //////////////////////////////////////////////////////////

        //////////////////////////////////////////////////////////////
        //
        //      BOTONES DE SELECCIÓN EXCLUYENTES
        //
        ////////////////////////////////////////////////////////////
        //
        //  RadioGroup y radioButtons para la periodicidad
        //

        rGpPeriodicidad = findViewById(R.id.rButGroupPeriodo);

        rGpPeriodicidad.setOnCheckedChangeListener( new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged( RadioGroup group, int checkedId ) {

                rBnPeriodicidad = findViewById( checkedId )             ;
                sPeriodicidad   = rBnPeriodicidad.getText().toString()  ;

            }

        } ) ;


     
    }

    /**
     * <pre>
     *
     * Sobre escribimos el método validarDatos
     *
     *
     * @return boolean  Verdadero si pasa la validación
     *                  y falso si se fracasa
     *
     * </pre>
     *
     */
    @Override
    protected boolean validarDatos(){

        int nError = 0;
        String sError =  "\n";
        String sValidado = "\n" ;

        /////////////////////////////////////
        // validar cliente


        /////////////////////////////////////
        // validar precio


        /////////////////////////////////////
        // validar fecha

        if ( sPeriodicidad.equals( getString( R.string.txt_unica )) ){
            //
        } else {
            //
        }

        /////////////////////////////////////
        // validar días de la semana

        if(nDias > 0 ) {
            sValidado = sValidado + crearCadenaDias();
        }else{
            sError = sError + getString( R.string.error_dias ) + "\n\n" ;
            nError++;
        }

        /////////////////////////////////////
        // validar periodicidad

        if ( sPeriodicidad.equals( "" ) ){
            sError = sError + getString( R.string.error_periodicidad ) + "\n\n" ;
            nError++;
        } else {
            sValidado = sValidado + getString( R.string.txt_periodicida ) + "\n" + sPeriodicidad + "\n\n";
        }





        /////////////////////////////////////
        // devolvemos validado o no
        if (nError > 0 ) {
            this.setsErrorValidacion( sError );
            return false;
        }else{
            this.setsDatosValidados( sValidado );
            return true;
        }
    }

    private String crearCadenaDias() {

        int insertados = 0;
        String losDias = "Día o días seleccionados:\n";

        for ( int queDia = 0; queDia < 7; queDia++ ) {

            final int finalQueDia = queDia;
            if (chBoxDias[queDia].isChecked()) {
                losDias = losDias + chBoxDias[queDia].getText().toString();
                insertados++;
                if ( insertados == (nDias -1)){
                    losDias = losDias + " y ";
                } else {
                    losDias = losDias +", ";
                }
            }

        }

        losDias = losDias.substring( 0, losDias.length()-2)+"\n\n";

        return losDias ;

    }

}
