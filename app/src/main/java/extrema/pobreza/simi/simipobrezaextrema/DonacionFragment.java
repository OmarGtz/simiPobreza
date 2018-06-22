package extrema.pobreza.simi.simipobrezaextrema;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import extrema.pobreza.simi.simipobrezaextrema.adapter.CampaingAdapter;
import extrema.pobreza.simi.simipobrezaextrema.model.Campaing;


public class DonacionFragment extends Fragment implements View.OnClickListener {

    private RecyclerView campaingRecycler;
    private RecyclerView.LayoutManager layoutManager;
    private CampaingAdapter campaingAdapter;
    private List<Campaing> campaings;
    private FloatingActionButton fbScanner;

    public DonacionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListCampaings();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_donacion, container, false);
        initView(v);
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        setLayoutManager();
        setAdatter();
        setRecyclerView();
        fbScanner.setOnClickListener(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void initView(View rootView){
        campaingRecycler = rootView.findViewById(R.id.donation_recycler);
        fbScanner = rootView.findViewById(R.id.donation_fb_scanner);
    }

    public void setAdatter(){
        campaingAdapter = new CampaingAdapter(campaings,getContext());
    }

    public void setLayoutManager(){
        layoutManager = new LinearLayoutManager(getContext());
    }

    public void setRecyclerView(){
        campaingRecycler.setLayoutManager(layoutManager);
        campaingRecycler.setAdapter(campaingAdapter);
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

    @Override
    public void onClick(View v) {
        startActivity(new Intent(getContext(),ScannerActivity.class));
    }
}