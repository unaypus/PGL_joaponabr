package com.example.juaponabr.proyectopgljuaponabr3dam;

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

public class Secciones extends AppCompatActivity {

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

        /*

        //  por ahora no usaremos este botón

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

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

            case R.id.action_settings   :
                modEnConstruccion()     ;
                return true             ;

            case R.id.action_help       :
                modEnConstruccion()     ;
                return true             ;

        }

        return super.onOptionsItemSelected( item ) ;

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

            int quePestanya = position + 1;

            switch ( quePestanya ){

                case 1: return PHFContratos.newInstance(  quePestanya ) ;
                case 2: return PHFClientes.newInstance(     quePestanya ) ;

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

    protected void modEnConstruccion() {

        //  Para los módulos en construcción
        android.app.FragmentManager manejador   = getFragmentManager() ;

        DialogoMensaje  dMensaje    = new DialogoMensaje(   getString( R.string.txt_titulo_mensaje      )                                   ,
                                                            getString( R.string.txt_modulo_construccion )   ) ;

        dMensaje.show(manejador,"elDialogoEnConstruccion");

    }

}
