package com.example.juaponabr.proyectopgljuaponabr3dam.controlador;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.juaponabr.proyectopgljuaponabr3dam.R;

import java.util.Calendar;

public class EditaContrato extends EditaRegistro {

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
        setContentView( R.layout.activity_edita_contrato)   ;
        iniBarraHerramientas()                              ;
        activarEscuchadores( EditaContrato.this )           ;
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


        //////////////////////////////////////////////////////////////
        //
        //  EdiText para el precio
        //

        edtPrecio = findViewById( R.id.editTextPrecio ) ;


        ///////////////////////////////////////////////////////
        //
        //      CUADROS DE SELECCIÓN
        //
        /////////////////////////////////////////////////////
        //
        // Cargar los checkbox de los días de la semana
        //

        chBoxDias   = new CheckBox[ 7 ]     ;

        //      ¿ se podrá meter esto en el bucle ?
        chBoxDias[ 0 ] = findViewById( R.id.checkBoxLunes       );
        chBoxDias[ 1 ] = findViewById( R.id.checkBoxMartes      );
        chBoxDias[ 2 ] = findViewById( R.id.checkBoxMiercoles   );
        chBoxDias[ 3 ] = findViewById( R.id.checkBoxJueves      );
        chBoxDias[ 4 ] = findViewById( R.id.checkBoxViernes     );
        chBoxDias[ 5 ] = findViewById( R.id.checkBoxSabado      );
        chBoxDias[ 6 ] = findViewById( R.id.checkBoxDomingo     );

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

                    ////////////////////////////////
                    //
                    //  actualiza la variables nDias
                    //  0 para ningún día escogido
                    //  7 como máximo
                    //

                    if ( chBoxDias[ finalQueDia ].isChecked() ) {
                        nDias++ ;
                    } else {
                        nDias-- ;
                    }

                }
            } )    ;

        }


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

        // contador de errores
        int         nError      = 0     ;

        // mensajes de error o la validación
        String      sError      = "\n"  ;
        String      sValidado   = "\n"  ;

        // cadena auxilar para el contenido de los EdiText
        String      sAuxiliar   = ""    ;

        // variables para el control de la fecha
        int         nMes        = 0     ;
        int         nDia        = 0     ;
        Calendar    dHoy        = Calendar.getInstance() ;


        /////////////////////////////////////
        //
        //      VALIDACIÓN cliente
        //

        sAuxiliar = edtCliente.getText().toString() ;
        edtCliente.setError( null ) ;

        if ( TextUtils.isEmpty( sAuxiliar ) ){

            sError = sError + getString( R.string.error_cliente ) + "\n\n" ;

            edtCliente.setError( getString( R.string.error_campo_obligatorio ) ) ;
            edtCliente.requestFocus() ;

            nError++ ;

        } else {

            sValidado = sValidado + getString( R.string.txt_cliente ) + "\n" + sAuxiliar + "\n\n" ;

        }


        /////////////////////////////////////
        //
        //      VALIDACIÓN precio
        //

        sAuxiliar = edtPrecio.getText().toString() ;
        edtPrecio.setError( null ) ;

        /*  // una prueba externalizar comprobación

        if ( campoObligatorio( edtPrecio.getId(), R.string.error_precio ) ){
            sValidado = sValidado                               +
                    getString( R.string.txt_precio )        +   "\n"    +
                    sAuxiliar                               +   " "     +
                    getString( R.string.txt_simbolo_euro )  +   "\n\n"  ;
        } else {
            nError++ ;
        }
        */

        if ( TextUtils.isEmpty( sAuxiliar ) ){

            sError =    sError + getString( R.string.error_precio ) + "\n\n"  ;

            edtPrecio.setError( getString( R.string.error_campo_obligatorio ) ) ;
            edtPrecio.requestFocus() ;

            nError++ ;

        } else {

            sValidado = sValidado                               +
                        getString( R.string.txt_precio )        +   "\n"    +
                        sAuxiliar                               +   " "     +
                        getString( R.string.txt_simbolo_euro )  +   "\n\n"  ;

        }




        /////////////////////////////////////
        //
        //      VALIDACIÓN fecha
        //

        //      Campo obligatorio mes
        sAuxiliar = edtMes.getText().toString() ;
        edtMes.setError( null ) ;

        if ( TextUtils.isEmpty( sAuxiliar ) ){

            sError = sError + getString( R.string.error_mes ) + "\n\n" ;

            edtMes.setError( getString( R.string.error_campo_obligatorio ) ) ;
            edtMes.requestFocus() ;

            nError++ ;

        } else {

            nMes = Integer.parseInt( sAuxiliar ) ;

        }

        //      Campo obligatorio día
        sAuxiliar = edtDia.getText().toString() ;
        edtDia.setError( null ) ;

        if ( TextUtils.isEmpty( sAuxiliar ) ){

            sError = sError + getString( R.string.error_dia ) + "\n\n" ;

            edtDia.setError( getString( R.string.error_campo_obligatorio ) ) ;
            edtDia.requestFocus() ;

            nError++ ;

        } else {

            nDia = Integer.parseInt( sAuxiliar ) ;

        }

        //      fecha correcta
        int mesAux = dHoy.get( Calendar.MONTH           ) ;
        int diaAux = dHoy.get( Calendar.DAY_OF_MONTH    ) ;

        if ( ( nMes > mesAux ) && ( nMes < 13 ) ){

            int maxDia = tieneTrentaUno( nMes ) ;

            if ( nDia < 1 || nDia > maxDia || ( ( nMes - 1 ) == mesAux ) && nDia < diaAux ) {

                sError = sError + getString( R.string.error_fecha ) + "\n\n" ;

                edtDia.setError( getString( R.string.error_dia_incorrecto ) ) ;
                edtDia.requestFocus() ;

                nError++ ;

            } else {

                sValidado = sValidado                           +
                            getString(  R.string.txt_fecha  )   +   "\n"    +
                            getString(  R.string.txt_dia    )   +   " "     +
                            nDia                                +   " "     +
                            getString(  R.string.txt_del    )   +   " "     +
                            nMes                                +   " "     +
                            getString(  R.string.txt_del    )   +   " "     +
                            dHoy.get(   Calendar.YEAR       )   +   "\n\n"  ;

            }

        } else {

            sError = sError + getString( R.string.error_fecha ) + "\n\n" ;

            edtMes.setError( getString( R.string.error_mes_incorrecto ) ) ;
            edtMes.requestFocus( );

            nError++ ;

        }



        /////////////////////////////////////
        //
        //      VALIDACIÓN días de la semana
        //

        if(nDias > 0 ) {

            sValidado = sValidado + crearCadenaDias() ;

        }else{

            sError = sError + getString( R.string.error_dias ) + "\n\n" ;
            nError++ ;

        }



        /////////////////////////////////////
        //
        //      VALIDACIÓN periodicidad
        //

        if ( sPeriodicidad.equals( "" ) ){

            sError = sError + getString( R.string.error_periodicidad ) + "\n\n" ;
            nError++ ;

        } else {

            sValidado = sValidado + getString( R.string.txt_periodicida ) + "\n" + sPeriodicidad + "\n\n" ;

        }





        /////////////////////////////////////
        //
        //      FIN VALIDACIÓN devolvemos validado o no
        //

        if ( nError > 0 ) {

            this.setsErrorValidacion( sError ) ;

            return false;

        } else {

            this.setsDatosValidados( sValidado ) ;

            return true;
        }

    }




    /////////////////////////////////////
    //
    //      MÉTODOS AUXILIARES
    //

    private int tieneTrentaUno( int nMesAux ) {

        switch ( nMesAux ){

            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
                return 31;

            case 2:
                // añadir función busca BISIESTO
                return 28 ;

        }

        return 30 ;

    }

    private String crearCadenaDias() {

        int insertados = 0 ;
        String losDias = "Día o días seleccionados:\n" ;

        for ( int queDia = 0; queDia < 7; queDia++ ) {

            final int finalQueDia = queDia;

            if (chBoxDias[queDia].isChecked()) {

                losDias = losDias + chBoxDias[queDia].getText().toString() ;
                insertados++ ;

                if ( insertados == (nDias -1)){

                    losDias = losDias + " y " ;

                } else {

                    losDias = losDias + ", " ;

                }

            }

        }

        losDias = losDias.substring( 0, losDias.length() - 2 ) + "\n\n" ;

        return losDias ;

    }

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

}
