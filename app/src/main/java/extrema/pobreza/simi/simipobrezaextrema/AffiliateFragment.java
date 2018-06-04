package extrema.pobreza.simi.simipobrezaextrema;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import extrema.pobreza.simi.simipobrezaextrema.adapter.BeneficiarioAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class AffiliateFragment extends Fragment {


    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private BeneficiarioAdapter beneficiarioAdapter;

    private List<String> beneficiarios;

    public AffiliateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_affiliate, container, false);
        recyclerView = v.findViewById(R.id.beneficiario_recycler);
        setRecyclerView();
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBeneficiarios();
        setLayoutManager();
        setAdapter();
    }

    public void setLayoutManager(){

        layoutManager  = new LinearLayoutManager(getContext());

    }

    public void setBeneficiarios(){
        beneficiarios = new ArrayList<>();
        beneficiarios.add("omar Gutierrez santiago");
        beneficiarios.add("omar Gutierrez santiago");
        beneficiarios.add("omar Gutierrez santiago");
        beneficiarios.add("omar Gutierrez santiago");
        beneficiarios.add("omar Gutierrez santiago");
    }

    public void setAdapter(){
        beneficiarioAdapter = new BeneficiarioAdapter(beneficiarios, new BeneficiarioAdapter.OnclickItemListener() {
            @Override
            public void onClickItem(int Position) {
                startActivity(new Intent(getActivity(),BeneficarioActivity.class));
            }
        });
    }

    public void setRecyclerView(){
        recyclerView.setAdapter(beneficiarioAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }





}
