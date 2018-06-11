package extrema.pobreza.simi.simipobrezaextrema.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import extrema.pobreza.simi.simipobrezaextrema.BeneficiarioSocioEconomico;
import extrema.pobreza.simi.simipobrezaextrema.R;
import extrema.pobreza.simi.simipobrezaextrema.model.Beneficiario;

public class BeneficiarioAdapter extends RecyclerView.Adapter<BeneficiarioAdapter.ViewHolderBeneficiario>{

    List<String> beneficiarios;

    List<Beneficiario> beneficiariosList;
    private OnclickItemListener onclickItemListener;

    public BeneficiarioAdapter(List<String> beneficiarios, OnclickItemListener onclickItemListener, List<Beneficiario> beneficiariosList){
        this.beneficiarios = beneficiarios;
        this.onclickItemListener = onclickItemListener;
        this.beneficiariosList = beneficiariosList;
    }

    @NonNull
    @Override
    public ViewHolderBeneficiario onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.beneficiario_item,parent,false);
        return new ViewHolderBeneficiario(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderBeneficiario holder, int position) {
        holder.bind(beneficiariosList.get(position),onclickItemListener);
    }

    @Override
    public int getItemCount() {
        return beneficiarios.size();
    }

    public static class ViewHolderBeneficiario extends RecyclerView.ViewHolder{

        private TextView tvName;
        private TextView tvFolio;
        private ImageView img;

        public ViewHolderBeneficiario(View itemView) {
            super(itemView);
            initView(itemView);
        }

        public void initView(View itemView){

            tvName = itemView.findViewById(R.id.beneficiario_item_tv_name);
            tvFolio = itemView.findViewById(R.id.beneficiario_tv_folio);
            img = itemView.findViewById(R.id.beneficiario_icon);

        }

        public void bind(Beneficiario beneficiario, final OnclickItemListener onclickItemListener){

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onclickItemListener.onClickItem(getAdapterPosition());
                }
            });
            tvName.setText(beneficiario.getName());
            tvFolio.setText(beneficiario.getFolio());
            if(beneficiario.isStatus()){
                img.setImageResource(R.drawable.ic_account_box_24px);
            }else {
                img.setImageResource(R.drawable.ic_account_box_baja);

            }
        }
    }

    public interface OnclickItemListener{
        void onClickItem(int Position);
    }
}
