package com.example.juaponabr.proyectopgljuaponabr3dam.controlador;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import com.example.juaponabr.proyectopgljuaponabr3dam.R;
import com.example.juaponabr.proyectopgljuaponabr3dam.pojos.Cliente;
import com.example.juaponabr.proyectopgljuaponabr3dam.proveedor.ClienteProveedor;

public class EditaCliente extends EditaRegistro {

    // variables de clase
    Cliente unCliente = null ;

    // variables de la vista
    EditText edtMat[] ;
    int idCabeceras[]   ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        unCliente = new Cliente();

        super.onCreate(         savedInstanceState              )   ;
        setContentView(         R.layout.activity_edita_cliente )   ;
        iniBarraHerramientas()                                      ;

        activarElementos()                                          ;

        if( !this.getIntent().getExtras().getBoolean( "Nuevo" ) ){
            unCliente = this.getIntent().getExtras().getParcelable( "elCliente" ) ;
           this.leerCliente() ;
        }




        activarEscuchadores(    EditaCliente.this               )   ;



    }

    private void activarElementos() {

        idCabeceras = new int[      9 ] ;
        edtMat      = new EditText[ 9 ] ;

        //      identidad                  //
        idCabeceras[    0 ] = R.id.textViewNombre       ;
        idCabeceras[    1 ] = R.id.textViewDNI          ;

        edtMat[         0 ] = findViewById( R.id.editTextNombre ) ;
        edtMat[         1 ] = findViewById( R.id.editTextDNI    ) ;


        //      dirección                  //
        idCabeceras[    2 ] = R.id.textViewVia          ;
        idCabeceras[    3 ] = R.id.textViewNumero       ;
        idCabeceras[    4 ] = R.id.textViewMunicipio    ;
        idCabeceras[    5 ] = R.id.textViewCP           ;
        idCabeceras[    6 ] = R.id.textViewDistancia    ;


        edtMat[         2 ] = findViewById( R.id.editTextVia        ) ;
        edtMat[         3 ] = findViewById( R.id.editTextNumero     ) ;
        edtMat[         4 ] = findViewById( R.id.editTextMunicipio  ) ;
        edtMat[         5 ] = findViewById( R.id.editTextCP         ) ;
        edtMat[         6 ] = findViewById( R.id.editTextDistancia  ) ;

        //      contacto                   //
        idCabeceras[    7 ] = R.id.textViewPersona      ;
        idCabeceras[    8 ] = R.id.textViewTelefono     ;

        edtMat[         7 ] = findViewById( R.id.editTextPersona    ) ;
        edtMat[         8 ] = findViewById( R.id.editTextTelefono   ) ;

    }

    private void cargarCliente(){

        unCliente.setCl_id(                             -1                                 ) ;
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

    private void leerCliente(){

        edtMat[ 0 ].setText( unCliente.getCl_nombre()       ) ;
        edtMat[ 1 ].setText( unCliente.getCl_dni()          ) ;
        edtMat[ 2 ].setText( unCliente.getDir_via()         ) ;
        //edtMat[ 3 ].setText( unCliente.getDir_num()         ) ;
        edtMat[ 4 ].setText( unCliente.getDir_localidad()   ) ;
        edtMat[ 5 ].setText( unCliente.getDir_cp()          ) ;
        //edtMat[ 6 ].setText( unCliente.getDistanacia()      ) ;
        edtMat[ 7 ].setText( unCliente.getCl_per_contacto() ) ;
        edtMat[ 8 ].setText( unCliente.getCl_telefono()     ) ;

    }

    @Override
    protected void guardarRegistro(){

        cargarCliente();
        ClienteProveedor.insert( getContentResolver(), unCliente ) ;
        finish();

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
        TextView textViewAux ;

        int         idString ;
        String sAuxiliar = "" ; // cadena para el contenido de los EdiText
        String sAuxiliar2 ;

        /////////////////////////////////////
        //
        //      VALIDACIÓN campos obligatorios
        //

        for( int cont = 0 ; cont < 9 ; cont++){

            textViewAux = findViewById( idCabeceras[    cont ] ) ;

            sAuxiliar   = edtMat[ cont ].getText().toString() ;
            sAuxiliar2  = textViewAux.getText().toString() ;

            edtMat[ cont ].setError( null ) ;

            if ( TextUtils.isEmpty( sAuxiliar ) ){

                sError = sError + getString( R.string.error_campo_vacio ) + sAuxiliar2 + "\n\n" ;

                edtMat[ cont ].setError( getString( R.string.error_campo_obligatorio ) ) ;
                edtMat[ cont ].requestFocus() ;

                nError++ ;

            } else {

                sValidado = sValidado + sAuxiliar2 + "\n" + sAuxiliar + "\n\n" ;

            }

        }

        /////////////////////////////////////
        //
        //     Formato DNI
        //

        sAuxiliar   = edtMat[ 1 ].getText().toString() ;

        if(  sAuxiliar.length() < 9 ){

            sError = sError + getString( R.string.error_DNI )  + "\n\n" ;

            edtMat[ 1 ].setError( getString( R.string.error_DNI ) ) ;
            edtMat[ 1 ].requestFocus() ;

            nError++ ;

        }

        /////////////////////////////////////
        //
        //     Formato CP
        //

        sAuxiliar   = edtMat[ 5 ].getText().toString() ;

        if( sAuxiliar.length() < 5 ){

            sError = sError + getString( R.string.error_CP )  + "\n\n" ;

            edtMat[ 5 ].setError( getString( R.string.error_CP ) ) ;
            edtMat[ 5 ].requestFocus() ;

            nError++ ;

        }

        /////////////////////////////////////
        //
        //     Formato Teléfono
        //

        sAuxiliar   = edtMat[ 8 ].getText().toString() ;

        if( sAuxiliar.length() < 9 ){

            sError = sError + getString( R.string.error_telefono )  + "\n\n" ;

            edtMat[ 8 ].setError( getString( R.string.error_telefono ) ) ;
            edtMat[ 8 ].requestFocus() ;

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


            return true;
        }

    }

}
