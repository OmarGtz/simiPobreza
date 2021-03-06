package extrema.pobreza.simi.simipobrezaextrema;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import extrema.pobreza.simi.simipobrezaextrema.adapter.CommunityAdapter;
import extrema.pobreza.simi.simipobrezaextrema.model.Community;


public class CommunityFragment extends Fragment implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private RecyclerView communityRecicler;
    private CommunityAdapter communityAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton fbScanner;
    private RadioButton radioButton;
    List<Community> communities;
    private Context context;
    private RadioGroup periodoGroup;
    private TextView tvEstatus;

    public CommunityFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListCommunities();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_comunity, container, false);
        initViews(view);
        setLayoutManager();
        setAdapter();
        setRecycler();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @SuppressLint("ResourceType")
    @Override
    public void onStart() {
        super.onStart();
        fbScanner.setOnClickListener(this);
        periodoGroup.setOnCheckedChangeListener(this);
      //  chipGroup.setOnCheckedChangeListener(this);
      //  chip.setCheckable(true);
      //  chip1.setCheckable(true);
      //  chip2.setCheckable(true);
      //  chip3.setCheckable(true);
      //  chip4.setCheckable(true);

      //  chip1.setChecked(true);
      //  chip2.setChecked(true);
      //  chip1.setCheckedIconEnabled(false);
    }

    public void initViews(View v){
        communityRecicler = v.findViewById(R.id.comunity_recycler);
        fbScanner = v.findViewById(R.id.comunity_fb_scanner);
        tvEstatus = v.findViewById(R.id.comunity_estatus);
        radioButton = v.findViewById(R.id.rbtn1);
        periodoGroup = v.findViewById(R.id.donaciones_group);

        radioButton.setChecked(true);

      //  chipGroup = v.findViewById(R.id.comunity_chip_group);
      //  chip = v.findViewById(R.id.chip_feb);
      //  chip1 = v.findViewById(R.id.chip_may);
      //  chip2 = v.findViewById(R.id.JUL_AGO);
      //  chip3 = v.findViewById(R.id.sep);
      //  chip4 = v.findViewById(R.id.nov);
    }

    public void setAdapter(){
        communityAdapter = new CommunityAdapter(communities, context, new CommunityAdapter.OnCommunityListener() {
            @Override
            public void onClickItem(int position) {
                //startActivity(new Intent(context,CampaingActivity.class));
            }
        });
    }

    public void setListCommunities(){
        Community community1 = new Community("LAURA NO ESTA","estado de mexico","ciudad de mexico");
        Community community2 = new Community("FILOMENO MENDEZ MENDOZA","estado de mexico","ciudad de mexico");
        Community community3 = new Community("ANZINA ALIBABA BABA","estado de mexico","ciudad de mexico");
        Community community4 = new Community("ANITA LA HUERFANITA","estado de mexico","ciudad de mexico");
        communities = new ArrayList<>();
        communities.add(community1);
        communities.add(community2);
        communities.add(community3);
        communities.add(community4);
        communities.add(community1);
        communities.add(community2);
        communities.add(community3);
        communities.add(community4);
        communities.add(community1);
        communities.add(community2);
        communities.add(community3);
        communities.add(community4);
    }

    public void setLayoutManager(){
        layoutManager = new LinearLayoutManager(context);
    }

    public void setRecycler(){
        communityRecicler.setAdapter(communityAdapter);
        communityRecicler.setLayoutManager(layoutManager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.comunity_fb_scanner:
                startActivity(new Intent(getActivity(),ScannerActivity.class));
                break;

        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rbtn1:

                tvEstatus.setText("ABIERTO");
                //Toast.makeText(context,"Ene",Toast.LENGTH_SHORT).show();
                break;

            case R.id.rbtn2:

                tvEstatus.setText("CERRADO");
                //Toast.makeText(context,"MAR",Toast.LENGTH_SHORT).show();
                break;

            case R.id.rbtn3:
                tvEstatus.setText("CERRADO");
                //Toast.makeText(context,"MAY",Toast.LENGTH_SHORT).show();
                break;

            case R.id.rbtn4:

                tvEstatus.setText("CERRADO");
                //Toast.makeText(context,"JUL",Toast.LENGTH_SHORT).show();
                break;

            case R.id.rbtn5:

                tvEstatus.setText("CERRADO");
                //Toast.makeText(context,"SEP",Toast.LENGTH_SHORT).show();
                break;

            case R.id.rbtn6:
                tvEstatus.setText("CERRADO");
                //Toast.makeText(context,"NOV",Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
