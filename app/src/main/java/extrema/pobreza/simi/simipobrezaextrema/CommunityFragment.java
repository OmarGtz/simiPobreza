package extrema.pobreza.simi.simipobrezaextrema;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import extrema.pobreza.simi.simipobrezaextrema.adapter.CommunityAdapter;
import extrema.pobreza.simi.simipobrezaextrema.model.Community;


/**
 * A simple {@link Fragment} subclass.
 */
public class CommunityFragment extends Fragment {


    private RecyclerView communityRecicler;
    private CommunityAdapter communityAdapter;
    private RecyclerView.LayoutManager layoutManager;

    List<Community> communities;

    private Context context;

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


    public void initViews(View v){
        communityRecicler = v.findViewById(R.id.comunity_recycler);
    }

    public void setAdapter(){
        communityAdapter = new CommunityAdapter(communities, context, new CommunityAdapter.OnCommunityListener() {
            @Override
            public void onClickItem(int position) {
                startActivity(new Intent(context,CampaingActivity.class));
            }
        });
    }


    public void setListCommunities(){
        Community community1 = new Community("san anntonio","estado de mexico","ciudad de mexico");
        Community community2 = new Community("san pedro","estado de mexico","ciudad de mexico");
        Community community3 = new Community("san mariana","estado de mexico","ciudad de mexico");
        Community community4 = new Community("san pancho","estado de mexico","ciudad de mexico");
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



}
