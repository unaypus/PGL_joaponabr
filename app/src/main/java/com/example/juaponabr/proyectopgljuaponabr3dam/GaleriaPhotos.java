package com.example.juaponabr.proyectopgljuaponabr3dam;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class GaleriaPhotos extends AppCompatActivity {

    private int nPhotos = 8 ;

    private static int matImg[] ;


    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

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

        //  cargar las fotos desde los recursos
        matImg = new int[ nPhotos ] ;

        matImg[ 0 ] = R.mipmap.ic__f_f0 ;
        matImg[ 1 ] = R.mipmap.ic__f_f1 ;
        matImg[ 2 ] = R.mipmap.ic__f_f2 ;
        matImg[ 3 ] = R.mipmap.ic__f_f3 ;
        matImg[ 4 ] = R.mipmap.ic__f_f4 ;
        matImg[ 5 ] = R.mipmap.ic__f_f5 ;
        matImg[ 6 ] = R.mipmap.ic__f_f6 ;
        matImg[ 7 ] = R.mipmap.ic__f_f7 ;

    }



    /**
     * A placeholder fragment containing a simple view.
     *
     * Lo que quiere decir es que esta es la clase que
     * genera la vista de una Activity en la hoja deslizante
     * activa en ese momento.
     *
     * Lo suyo será crear una clase de esta por cada Activity
     *
     */
    public static class PlaceholderFragment extends Fragment {

        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {}

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance( int sectionNumber ) {

            PlaceholderFragment fragment    = new PlaceholderFragment() ;
            Bundle              args        = new Bundle()              ;

            args.putInt( ARG_SECTION_NUMBER, sectionNumber ) ;

            fragment.setArguments( args ) ;

            return fragment ;

        }

        @Override
        public View onCreateView(   LayoutInflater  inflater            ,
                                    ViewGroup       container           ,
                                    Bundle          savedInstanceState  ) {



            View rootView = inflater.inflate( R.layout.ver_photo, container, false ) ;

            ImageView laPhoto = rootView.findViewById( R.id.imgPhoto ) ;
            laPhoto.setImageResource( matImg[ getArguments().getInt( ARG_SECTION_NUMBER ) ] ) ;

            return rootView;

        }

    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter( FragmentManager fm ) { super( fm ) ; }

        @Override
        public Fragment getItem( int position ) {

            // si no usamos el 0 hay que sumar 1 a position
            return PlaceholderFragment.newInstance( position ) ;

        }

        @Override
        public int getCount() { return nPhotos ;  }

        @Override
        public CharSequence getPageTitle( int position){

            position++ ;
            return "F : " + position ;

        }

    }


}
