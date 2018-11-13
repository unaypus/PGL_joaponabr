package com.example.juaponabr.proyectopgljuaponabr3dam.controlador;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import com.example.juaponabr.proyectopgljuaponabr3dam.R;
import com.example.juaponabr.proyectopgljuaponabr3dam.pojos.Cliente;

public class EditaCliente extends EditaRegistro {

    // variables de clase
    Cliente unCliente = null ;

    // variables de la vista
    EditText edtMat[] ;
    //TextView textViewAux ;
    int idEditext[]     ;
    int idCabeceras[]   ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(         savedInstanceState              )   ;
        setContentView(         R.layout.activity_edita_cliente )   ;
        iniBarraHerramientas()                                      ;

        unCliente = new Cliente();

        activarEscuchadores(    EditaCliente.this               )   ;
        activarElementos()                                          ;


    }

    private void activarElementos() {

        idEditext   = new int[ 9 ] ;
        idCabeceras = new int[ 9 ] ;
        edtMat      = new EditText[ 9 ] ;

        //      identidad                  //
        idCabeceras[    0 ] = R.id.textViewNombre       ;
        idCabeceras[    1 ] = R.id.textViewDNI          ;

        idEditext[      0 ] = R.id.editTextNombre       ;
        edtMat[         0 ] = findViewById( idEditext[      0 ]);
        idEditext[      1 ] = R.id.editTextDNI          ;


        //      dirección                  //
        idCabeceras[    2 ] = R.id.textViewVia          ;
        idCabeceras[    3 ] = R.id.textViewNumero       ;
        idCabeceras[    4 ] = R.id.textViewMunicipio    ;
        idCabeceras[    5 ] = R.id.textViewCP           ;
        idCabeceras[    6 ] = R.id.textViewDistancia    ;
        idEditext[      2 ] = R.id.editTextVia          ;
        idEditext[      3 ] = R.id.editTextNumero       ;
        idEditext[      4 ] = R.id.editTextMunicipio    ;
        idEditext[      5 ] = R.id.editTextCP           ;
        idEditext[      6 ] = R.id.editTextDistancia    ;

        //      contacto                   //
        idCabeceras[    7 ] = R.id.textViewPersona      ;
        idCabeceras[    8 ] = R.id.textViewTelefono     ;
        idEditext[      7 ] = R.id.editTextPersona      ;
        idEditext[      8 ] = R.id.editTextTelefono     ;

    }

    private  void cargarCliente(){

        unCliente.setCl_nombre(                         edtMat[ 0 ].getText().toString()   ) ;
        unCliente.setCl_dni(                            edtMat[ 1 ].getText().toString()   ) ;
        unCliente.setDir_via(                           edtMat[ 2 ].getText().toString()   ) ;
        unCliente.setDir_num(       Integer.parseInt(   edtMat[ 3 ].getText().toString() ) ) ;
        unCliente.setDir_localidad(                     edtMat[ 4 ].getText().toString()   ) ;
        unCliente.setDir_cp(                            edtMat[ 5 ].getText().toString()   ) ;
        unCliente.setDistanacia(    Integer.parseInt(   edtMat[ 6 ].getText().toString() ) ) ;
        unCliente.setCl_per_contacto(                   edtMat[ 7 ].getText().toString()   ) ;
        unCliente.setCl_telefono(                       edtMat[ 8 ].getText().toString()   ) ;

    }

    @Override
    protected void guardarRegistro(){

        // Aqui nos conectamos al proveedor y le pasamos el objeto unCliente
        //
        /*
        ClienteProveedor.insert( getContentResolver(), unCliente ) ;
        finish();
         */

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
    protected boolean validarDatos() {

        // contador de errores
        int nError = 0 ;

        // mensajes
        String sError       = "\n" ; // de error
        String sValidado    = "\n" ; // la validación

        // auxiliares para el bucle
        EditText edtAuxiliar ;
        TextView textViewAux ;

        int         idString ;
        String sAuxiliar = "" ; // cadena para el contenido de los EdiText
        String sAuxiliar2 ;

        /////////////////////////////////////
        //
        //      VALIDACIÓN campos obligatorios
        //

        for( int cont = 0 ; cont < 9 ; cont++){

            edtAuxiliar = findViewById( idEditext[      cont ] ) ;
            textViewAux = findViewById( idCabeceras[    cont ] ) ;

            sAuxiliar   = edtAuxiliar.getText().toString() ;
            sAuxiliar2  = textViewAux.getText().toString() ;

            edtAuxiliar.setError( null ) ;

            if ( TextUtils.isEmpty( sAuxiliar ) ){

                sError = sError + getString( R.string.error_campo_vacio ) + sAuxiliar2 + "\n\n" ;

                edtAuxiliar.setError( getString( R.string.error_campo_obligatorio ) ) ;
                edtAuxiliar.requestFocus() ;

                nError++ ;

            } else {

                sValidado = sValidado + sAuxiliar2 + "\n" + sAuxiliar + "\n\n" ;

            }

        }

        /////////////////////////////////////
        //
        //     Formato DNI
        //

        edtAuxiliar = findViewById( idEditext[ 1 ] ) ;
        sAuxiliar   = edtAuxiliar.getText().toString() ;

        if(  sAuxiliar.length() < 9 ){

            sError = sError + getString( R.string.error_DNI )  + "\n\n" ;

            edtAuxiliar.setError( getString( R.string.error_DNI ) ) ;
            edtAuxiliar.requestFocus() ;

            nError++ ;

        }

        /////////////////////////////////////
        //
        //     Formato CP
        //

        edtAuxiliar = findViewById( idEditext[ 5 ] ) ;
        sAuxiliar   = edtAuxiliar.getText().toString() ;

        if( sAuxiliar.length() < 5 ){

            sError = sError + getString( R.string.error_CP )  + "\n\n" ;

            edtAuxiliar.setError( getString( R.string.error_CP ) ) ;
            edtAuxiliar.requestFocus() ;

            nError++ ;

        }

        /////////////////////////////////////
        //
        //     Formato Teléfono
        //

        edtAuxiliar = findViewById( idEditext[ 8 ] ) ;
        sAuxiliar   = edtAuxiliar.getText().toString() ;

        if( sAuxiliar.length() < 9 ){

            sError = sError + getString( R.string.error_telefono )  + "\n\n" ;

            edtAuxiliar.setError( getString( R.string.error_telefono ) ) ;
            edtAuxiliar.requestFocus() ;

            nError++ ;

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
            cargarCliente();

            return true;
        }

    }

}
