package extrema.pobreza.simi.simipobrezaextrema.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import extrema.pobreza.simi.simipobrezaextrema.BeneficiarioCotitular;
import extrema.pobreza.simi.simipobrezaextrema.BeneficiarioDireccion;
import extrema.pobreza.simi.simipobrezaextrema.BeneficiarioSalud;
import extrema.pobreza.simi.simipobrezaextrema.BeneficiarioSocioEconomico;
import extrema.pobreza.simi.simipobrezaextrema.beneficiarioInfo;

public class BeneficiarioPageAdapter extends FragmentPagerAdapter{

    private  int numOfTabs;
    public static final int FRAGMENT_DATOS_PERSONALES = 0;
    public static final int FRAGMENT_DIRECCION = 1;

    public static final int FRAGMENT_DATOS_SOCIOECONOMICOS = 2;
    //public static final int FRAGMENT_SALUD = 3;
    public static final int FRAGMENT_COTITULAR = 3;



    public BeneficiarioPageAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs= numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case FRAGMENT_DATOS_PERSONALES:
                return new beneficiarioInfo();

            case FRAGMENT_DIRECCION:
                return new BeneficiarioDireccion();

            case FRAGMENT_DATOS_SOCIOECONOMICOS:
                return new BeneficiarioSocioEconomico();

            case FRAGMENT_COTITULAR:
                return new BeneficiarioCotitular();

        }


        return null;
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
