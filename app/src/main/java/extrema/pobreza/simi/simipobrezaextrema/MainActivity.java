package extrema.pobreza.simi.simipobrezaextrema;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, CommunityFragment.OnInteractionFragemnt {

    private BottomNavigationView bottomNavigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.main_navigation_bottom);
        toolbar = findViewById(R.id.main_toolbar);
        setToolbar();
        bottomNavigationView.setSelectedItemId(R.id.nav_menu_comunidad);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.nav_menu_comunidad);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu,menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        MenuItem.OnActionExpandListener onActionExpandListener = new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                return true;
            }
            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {

                return true;
            }
        };
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onStart() {
        super.onStart();
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
                getSupportActionBar().setTitle("Baja California Sur");
                break;

            case R.id.nav_afiliado:
                changeFragment(new AffiliateFragment());
                //getSupportActionBar().setTitle("Beneficiarios");
                //getSupportActionBar().setSubtitle("");

                break;

            case R.id.nav_sync_up:
                changeFragment(new syncUpFragment());
                //getSupportActionBar().setTitle("Syncronizar");
                //getSupportActionBar().setSubtitle("");
                break;

            default:
                changeFragment(new CommunityFragment());

                break;
        }

        return true;
    }


    public void changeFragment(Fragment f){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_content,f)
                .commit();
    }

    @Override
    public void onShowInteractionListener() {
        changeFragment(new DonacionFragment());
    }
}
