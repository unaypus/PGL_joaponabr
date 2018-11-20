/*
 * Copyright (c) 2018.  juaponabr 3º DAM Semipresencial
 */

package com.example.juaponabr.proyectopgljuaponabr3dam.secciones;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.juaponabr.proyectopgljuaponabr3dam.controlador.PHFContratos;
import com.example.juaponabr.proyectopgljuaponabr3dam.R;
import com.example.juaponabr.proyectopgljuaponabr3dam.controlador.ElListadoClientes;
import com.example.juaponabr.proyectopgljuaponabr3dam.dialogos.DialogoMensaje;

public class GestionDatos extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter ;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager ;

    private int quePestanya = 0 ;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {

        super.onCreate( savedInstanceState          ) ;
        setContentView( R.layout.activity_secciones ) ;

        Toolbar toolbar = findViewById(                     R.id.toolbar_sec            ) ;
        setSupportActionBar(                                toolbar                     ) ;
        getSupportActionBar().setHomeAsUpIndicator(         R.drawable.ic_action_home   ) ;
        getSupportActionBar().setDisplayHomeAsUpEnabled(    true                        ) ;


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter( getSupportFragmentManager() ) ;



        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(  R.id.container          ) ;
        mViewPager.setAdapter(      mSectionsPagerAdapter   ) ;

        // Barra con el título de cada pestaña
        TabLayout losTab = findViewById(    R.id.tabs   ) ;
        losTab.setupWithViewPager(          mViewPager  ) ;

        ////////////////////////////////////////////////////////////////////////////////////////////
        //                                                                                        //
        //                      A T E N C I Ó N  -  P R E G U N T A                               //
        //                                                                                        //
        //      clase GestionDatos                                                                   //
        //      boton flotante  y menú para todas las pestañas                                    //
        //                                                                                        //
        //      No puedo usar la variable quePestanya para saber en que pestaña estoy. Al         //
        //      parecer cuando  se carga en  SectionsPagerAdapter no  se recarga  en cada         //
        //      pasada del dedo                                                                   //
        //                                                                                        //
        //      ¿ Como puedo saber en que pestaña estoy ?                                         //
        //                                                                                        //
        //                                                                                        //
        ////////////////////////////////////////////////////////////////////////////////////////////
        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                switch ( quePestanya ) {

                    case 1 :
                        modEnConstruccion();
                        break;

                    case 2 :
                        Intent intento = new Intent( GestionDatos.this,EditaCliente.class);
                        intento.putExtra( "Nuevo", true );
                        startActivity(intento);
                        break;

                }

            }

        });
        */

    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.menu_secciones, menu ) ;
        return true ;

    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item ) {

        switch ( item.getItemId() ){

            case R.id.action_help       :
                verLaAyuda()            ;
                return true             ;

        }

        return super.onOptionsItemSelected( item ) ;

    }

    private void verLaAyuda() {

        android.app.FragmentManager manejador   = getFragmentManager() ;

        DialogoMensaje dMensaje    = new DialogoMensaje(   getString( R.string.txt_titulo_ayuda_registros   )                                   ,
                                                            getString( R.string.txt_texto_ayuda_registros)   ) ;

        dMensaje.show(manejador,"elDialogoAyudaRegistros");

    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter( FragmentManager fm ) { super( fm ) ; }

        @Override
        public int getCount() { return 2 ; }

        @Override
        public Fragment getItem( int position ) {

            /////////////////////////////////////////////////////
            //
            //  este es el lugar donde poner el switch ( quePestanya )
            //  y llamar a la actividad correspondiente
            //
            /////////////////////////////////////////////////////

            quePestanya = position + 1;

            switch ( quePestanya ){

                case 1: return PHFContratos.newInstance(  quePestanya ) ;
                case 2: return ElListadoClientes.newInstance() ;

            }

            return null;    //PHFContratos.newInstance(position + 1);

        }

        @Override
        public CharSequence getPageTitle( int position){

            switch ( position ) {

                case 0: return "Contratos"  ;
                case 1: return "Clientes"   ;

            }

            return null;

        }

    }

}
