package extrema.pobreza.simi.simipobrezaextrema;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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

import extrema.pobreza.simi.simipobrezaextrema.adapter.BeneficiarioAdapter;
import extrema.pobreza.simi.simipobrezaextrema.adapter.CommunityAdapter;
import extrema.pobreza.simi.simipobrezaextrema.decoration.CommunityItemDecoration;
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

    private OnInteractionFragemnt listener;

    public CommunityFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListCommunities();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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
        if(context instanceof MainActivity){
            listener = (OnInteractionFragemnt) context;
        }
        this.context = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @SuppressLint("ResourceType")
    @Override
    public void onStart() {
        super.onStart();
        fbScanner.setOnClickListener(this);
        periodoGroup.setOnCheckedChangeListener(this);
    }

    public void initViews(View v){
        communityRecicler = v.findViewById(R.id.comunity_recycler);
        fbScanner = v.findViewById(R.id.comunity_fb_scanner);
        radioButton = v.findViewById(R.id.rbtn1);
        periodoGroup = v.findViewById(R.id.donaciones_group);
        radioButton.setChecked(true);
    }

    public void setAdapter(){
        communityAdapter = new CommunityAdapter(communities, context, new CommunityAdapter.OnCommunityListener() {
            @Override
            public void onClickItem(int position) {
                //listener.onShowInteractionListener();
                startActivity(new Intent(getContext(),CampaingActivity.class));

                            }
        });
    }

    public void setListCommunities(){

        Community community1 = new Community("Cañada Honda",200,150,1);
        Community community2 = new Community("Jesus Maria",230,200,1);
        Community community3 = new Community("Refugio De providencia",250,201,1);
        Community community4 = new Community("Santa Maria De Gallardo",200,180,1);
        Community community5 = new Community("Ex Ejido Ojocaliente",210,199,1);
        Community community6 = new Community("Jesus Maria",250,190,3);
        Community community7 = new Community("Norias de Paso Hondo",260,198,3);
        Community community8 = new Community("Cañada Honda",270,210,2);
        Community community9 = new Community("El Che Guevara",200,160,2);

        communities = new ArrayList<>();
        communities.add(community1);
        communities.add(community2);
        communities.add(community3);
        communities.add(community4);
        communities.add(community5);
        communities.add(community6);
        communities.add(community7);
        communities.add(community8);
        communities.add(community9);
    }

    public void setLayoutManager(){
        layoutManager = new LinearLayoutManager(context);
    }

    public void setRecycler(){
        communityRecicler.setAdapter(communityAdapter);
        communityRecicler.setLayoutManager(layoutManager);
        communityRecicler.setNestedScrollingEnabled(false);
        CommunityItemDecoration itemDecoration = new CommunityItemDecoration(getContext());
        communityRecicler.addItemDecoration(itemDecoration);
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
                //tvEstatus.setText("ABIERTO");
                //tvEstatus.setTextColor(getResources().getColor(R.color.greenColor));
                //tvEstatus.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_valid_1, 0, 0, 0);
                break;

            case R.id.rbtn2:
                //tvEstatus.setText("CERRADO");
                //tvEstatus.setTextColor(getResources().getColor(R.color.redColot));
                //tvEstatus.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_valid_2, 0, 0, 0);
                break;

            case R.id.rbtn3:
                //tvEstatus.setText("CERRADO");
                //tvEstatus.setTextColor(getResources().getColor(R.color.redColot));
                //tvEstatus.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_valid_2, 0, 0, 0);
                //Toast.makeText(context,"MAY",Toast.LENGTH_SHORT).show();
                break;
        }
    }


    public interface OnInteractionFragemnt{
        void onShowInteractionListener();
    }
}