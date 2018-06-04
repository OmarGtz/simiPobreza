package extrema.pobreza.simi.simipobrezaextrema;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class detailScaner extends Fragment implements View.OnClickListener {
    private ImageButton btnClose;
    private OnDetailListener onDetailListener;
    private Button btnEntregar;
    private int number;
    private TextView tvResult;
    private ImageView imgResult;

    public detailScaner() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof ScannerActivity){
            onDetailListener = (OnDetailListener) context;
        }
    }

    public void setRamdomNumber(){
        Random r = new Random();
        number = r.nextInt(4);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detail_scaner, container, false);
        btnClose = v.findViewById(R.id.detail_btn_close);
        tvResult = v.findViewById(R.id.scan_info_text_valid);
        imgResult = v.findViewById(R.id.scan_info_icon_valid);
        btnEntregar = v.findViewById(R.id.scan_info_btn_entregar);
        btnEntregar.setOnClickListener(this);
        btnClose.setOnClickListener(this);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onStart() {
        super.onStart();
        setRamdomNumber();
        setResultScan(number);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.detail_btn_close:
                onDetailListener.onClose();
                break;

            case R.id.scan_info_btn_entregar:
                onDetailListener.onClose();
                break;
        }
    }

    public void setResultScan(int result){
     switch (result){

         case 1:
             tvResult.setText("Apoyo del periodo ya fue entregado.");
             imgResult.setImageResource(R.drawable.ic_no_valid);
             btnEntregar.setEnabled(false);
             break;

         case 2:
             tvResult.setText("Beneficiario activo.");
             imgResult.setImageResource(R.drawable.ic_valid);
             btnEntregar.setEnabled(true);
             break;

         case 3:
             tvResult.setText("Beneficiario en estado de baja.");
             imgResult.setImageResource(R.drawable.ic_no_valid);
             btnEntregar.setEnabled(false);
             break;

         case 4:
             tvResult.setText("Beneficiario con muchas inasistencias");
             imgResult.setImageResource(R.drawable.ic_no_valid);
             btnEntregar.setEnabled(false);
             break;
     }
    }


    public interface OnDetailListener{
        void onClose();
    }

}
