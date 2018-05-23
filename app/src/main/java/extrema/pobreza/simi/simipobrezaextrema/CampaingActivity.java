package extrema.pobreza.simi.simipobrezaextrema;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import extrema.pobreza.simi.simipobrezaextrema.adapter.CampaingAdapter;
import extrema.pobreza.simi.simipobrezaextrema.adapter.CommunityAdapter;
import extrema.pobreza.simi.simipobrezaextrema.model.Campaing;
import extrema.pobreza.simi.simipobrezaextrema.model.Community;

public class CampaingActivity extends AppCompatActivity {
    private RecyclerView campaingRecycler;
    private RecyclerView.LayoutManager layoutManager;
    private CampaingAdapter campaingAdapter;
    private Toolbar toolbar;
    private List<Campaing> campaings;

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

    public void initViews(){
        campaingRecycler = findViewById(R.id.campaing_recycler);
        toolbar = findViewById(R.id.campaing_toolbar);
    }

    public void setToolbar(){
        if(toolbar!=null){
            setSupportActionBar(toolbar);
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("Campañas");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void setAdapter(){
        campaingAdapter = new CampaingAdapter(campaings, this, new CampaingAdapter.OnCampaingListener() {
            @Override
            public void onclickItem(int position) {

            }
        });
    }


    public void setListCampaings(){
        Campaing campaing1 = new Campaing("FEBRERO-MARZO");
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

    public void setLayoutManager(){
        layoutManager = new LinearLayoutManager(this);
    }

    public void setRecycler(){
        campaingRecycler.setAdapter(campaingAdapter);
        campaingRecycler.setLayoutManager(layoutManager);
    }


}
