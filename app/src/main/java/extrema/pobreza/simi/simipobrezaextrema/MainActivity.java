package extrema.pobreza.simi.simipobrezaextrema;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    private BottomNavigationView bottomNavigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.main_navigation_bottom);
        toolbar = findViewById(R.id.main_toolbar);
        setToolbar();
    }


    @Override
    protected void onStart() {
        super.onStart();
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.nav_menu_comunidad);
    }

    public void setToolbar(){
        if(toolbar!=null){
            setSupportActionBar(toolbar);
            ActionBar ab = getSupportActionBar();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.nav_menu_comunidad:
                changeFragment(new CommunityFragment());
                getSupportActionBar().setTitle("Donaciones");
                break;

            case R.id.nav_afiliado:
                changeFragment(new AffiliateFragment());
                getSupportActionBar().setTitle("Beneficiarios");
                break;

            case R.id.nav_sync_up:
                changeFragment(new syncUpFragment());
                getSupportActionBar().setTitle("Syncronizar");
                break;

            default:
                changeFragment(new CommunityFragment());

                break;
        }

        return false;
    }


    public void changeFragment(Fragment f){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_content,f)
                .commit();
    }
}
