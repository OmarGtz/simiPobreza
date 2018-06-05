package extrema.pobreza.simi.simipobrezaextrema;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import extrema.pobreza.simi.simipobrezaextrema.adapter.BeneficiarioPageAdapter;

public class BeneficarioActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {


    private ViewPager viewPager;
    private TabLayout tabLayout;
    private BeneficiarioPageAdapter pageAdapter;

    private Toolbar toolbar;
    public static final int FRAGMENT_DATOS_PERSONALES = 0;
    public static final int FRAGMENT_DIRECCION = 1;

    public static final int FRAGMENT_DATOS_SOCIOECONOMICOS = 2;
    public static final int FRAGMENT_SALUD = 3;
    public static final int FRAGMENT_COTITULAR = 4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beneficario);
        initViews();
        setToolbar();

    }

    public void initViews(){
        viewPager= findViewById(R.id.beneficiario_view_pager);
        tabLayout = findViewById(R.id.beneficiario_tablayout);

        //set tabs

        tabLayout.addTab(tabLayout.newTab().setText("Datos generales"));
        tabLayout.addTab(tabLayout.newTab().setText("Direccion"));
        tabLayout.addTab(tabLayout.newTab().setText("Datos socioeconomicos"));
        tabLayout.addTab(tabLayout.newTab().setText("Cotitular"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);


        pageAdapter = new BeneficiarioPageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(this);


    }

    void setToolbar(){
        toolbar = findViewById(R.id.beneficiario_toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle("Beneficiario");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.beneficiario_menu,menu);

        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}