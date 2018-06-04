package extrema.pobreza.simi.simipobrezaextrema.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import extrema.pobreza.simi.simipobrezaextrema.BeneficiarioSocioEconomico;
import extrema.pobreza.simi.simipobrezaextrema.R;

public class BeneficiarioAdapter extends RecyclerView.Adapter<BeneficiarioAdapter.ViewHolderBeneficiario>{

    List<String> beneficiarios;
    private OnclickItemListener onclickItemListener;

    public BeneficiarioAdapter(List<String> beneficiarios, OnclickItemListener onclickItemListener){
        this.beneficiarios = beneficiarios;
        this.onclickItemListener = onclickItemListener;
    }

    @NonNull
    @Override
    public ViewHolderBeneficiario onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.beneficiario_item,parent,false);
        return new ViewHolderBeneficiario(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderBeneficiario holder, int position) {
        holder.bind(beneficiarios.get(position),onclickItemListener);
    }

    @Override
    public int getItemCount() {
        return beneficiarios.size();
    }

    public static class ViewHolderBeneficiario extends RecyclerView.ViewHolder{

        private TextView tvName;

        public ViewHolderBeneficiario(View itemView) {
            super(itemView);
            initView(itemView);
        }

        public void initView(View itemView){

            tvName = itemView.findViewById(R.id.beneficiario_item_tv_name);

        }

        public void bind(String name, final OnclickItemListener onclickItemListener){

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onclickItemListener.onClickItem(getAdapterPosition());
                }
            });
            tvName.setText(name);
        }
    }

    public interface OnclickItemListener{
        void onClickItem(int Position);
    }
}
