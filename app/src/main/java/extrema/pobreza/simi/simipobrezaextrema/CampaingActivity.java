package extrema.pobreza.simi.simipobrezaextrema;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import extrema.pobreza.simi.simipobrezaextrema.adapter.CampaingAdapter;
import extrema.pobreza.simi.simipobrezaextrema.adapter.CommunityAdapter;
import extrema.pobreza.simi.simipobrezaextrema.model.Campaing;
import extrema.pobreza.simi.simipobrezaextrema.model.Community;

public class CampaingActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView campaingRecycler;
    private RecyclerView.LayoutManager layoutManager;
    private CampaingAdapter campaingAdapter;
    private Toolbar toolbar;
    private List<Campaing> campaings;
    private FloatingActionButton fbScanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campaing);
        setListCampaings();
        initViews();
        setLayoutManager();
        setAdapter();
        setRecycler();
        setToolbar();
    }

    @Override
    protected void onStart() {
        super.onStart();
        fbScanner.setOnClickListener(this);
    }

    public void initViews(){
        campaingRecycler = findViewById(R.id.campaing_recycler);
        toolbar = findViewById(R.id.campaing_toolbar);
        fbScanner = findViewById(R.id.donation_fb_scanner);
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

    public void setToolbar(){
        if(toolbar!=null){
            setSupportActionBar(toolbar);
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("Donaciones");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void setAdapter(){
        campaingAdapter = new CampaingAdapter(campaings,this);
    }

    public void setListCampaings(){
        Campaing campaing1 = new Campaing("Omar Gutierrez Santiago");
        campaings = new ArrayList<>();
        campaings.add(campaing1);
        campaings.add(campaing1);
        campaings.add(campaing1);
        campaings.add(campaing1);
        campaings.add(campaing1);
        campaings.add(campaing1);
        campaings.add(campaing1);
        campaings.add(campaing1);
        campaings.add(campaing1);
        campaings.add(campaing1);
        campaings.add(campaing1);
        campaings.add(campaing1);
        campaings.add(campaing1);
    }

    public void setLayoutManager() {
        layoutManager = new LinearLayoutManager(this);
    }

    public void setRecycler(){
        campaingRecycler.setAdapter(campaingAdapter);
        campaingRecycler.setLayoutManager(layoutManager);
        campaingRecycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.donation_fb_scanner:
                startActivity(new Intent(this, ScannerActivity.class));
                break;
        }
    }
}