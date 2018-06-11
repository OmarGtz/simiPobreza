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
import extrema.pobreza.simi.simipobrezaextrema.model.Beneficiario;


/**
 * A simple {@link Fragment} subclass.
 */
public class AffiliateFragment extends Fragment {


    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private BeneficiarioAdapter beneficiarioAdapter;

    private List<String> beneficiarios;

    private List<Beneficiario> beneficiarioList;

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
        setList();
        setLayoutManager();
        setAdapter();
    }

    public void setLayoutManager(){
        layoutManager  = new LinearLayoutManager(getContext());
    }

    public void setBeneficiarios(){
        beneficiarios = new ArrayList<>();
        beneficiarios.add("omar Gutierrez santiago");
        beneficiarios.add("Angel Sanchez Sanchez");
        beneficiarios.add("John cena en la cocina");
        beneficiarios.add("Anzina sina sina");
        beneficiarios.add("Filemon de sagrado corazon");
        beneficiarios.add("Elvis teck garcia");
        beneficiarios.add("monica galindo gracia");
        beneficiarios.add("Benito juarez juarez");
    }


    public void setList(){
        beneficiarioList = new ArrayList<>();
        Beneficiario beneficiario = new Beneficiario("Ma de jesus Rangel Martinez",true,"620000127008");
        Beneficiario beneficiario1 = new Beneficiario("Gloria campos macias",true,"620000127008");
        Beneficiario beneficiario2 = new Beneficiario("Beatriz eugenia Velazquez",true,"620000127008");
        Beneficiario beneficiario3 = new Beneficiario("Graciela Lozan Milan",true,"620000127008");
        Beneficiario beneficiario4 = new Beneficiario("Maria patricia davila Lara",false,"620000127008");
        Beneficiario beneficiario5 = new Beneficiario("Anronio Gonzalez franco",true,"620000127008");
        Beneficiario beneficiario6 = new Beneficiario("Ester Solis Martinez",true,"620000127008");
        Beneficiario beneficiario7= new Beneficiario("Ramona Gonzales campos",false,"620000127008");
        Beneficiario beneficiario8 = new Beneficiario("Silvia Matinez nieto",true,"620000127008");

        beneficiarioList.add(beneficiario1);

        beneficiarioList.add(beneficiario2);
        beneficiarioList.add(beneficiario3);
        beneficiarioList.add(beneficiario4);
        beneficiarioList.add(beneficiario);
        beneficiarioList.add(beneficiario5);
        beneficiarioList.add(beneficiario6);
        beneficiarioList.add(beneficiario7);
        beneficiarioList.add(beneficiario8);
        beneficiarioList.add(beneficiario);
        beneficiarioList.add(beneficiario2);


    }

    public void setAdapter(){
        beneficiarioAdapter = new BeneficiarioAdapter(beneficiarios, new BeneficiarioAdapter.OnclickItemListener() {
            @Override
            public void onClickItem(int Position) {
                startActivity(new Intent(getActivity(),BeneficarioActivity.class));
            }
        },beneficiarioList);
    }

    public void setRecyclerView(){
        recyclerView.setAdapter(beneficiarioAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }





}
