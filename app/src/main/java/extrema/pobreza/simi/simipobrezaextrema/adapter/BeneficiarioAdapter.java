package extrema.pobreza.simi.simipobrezaextrema.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import extrema.pobreza.simi.simipobrezaextrema.BeneficiarioSocioEconomico;
import extrema.pobreza.simi.simipobrezaextrema.R;
import extrema.pobreza.simi.simipobrezaextrema.model.Beneficiario;

public class BeneficiarioAdapter extends RecyclerView.Adapter<BeneficiarioAdapter.ViewHolderBeneficiario>{

    List<String> beneficiarios;

    List<Beneficiario> beneficiariosList;
    private OnclickItemListener onclickItemListener;
    private Context mContext;

    public BeneficiarioAdapter(List<String> beneficiarios, OnclickItemListener onclickItemListener, List<Beneficiario> beneficiariosList, Context mContext){
        this.beneficiarios = beneficiarios;
        this.onclickItemListener = onclickItemListener;
        this.beneficiariosList = beneficiariosList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolderBeneficiario onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.app_bar,parent,false);
        return new ViewHolderBeneficiario(v);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull ViewHolderBeneficiario holder, int position) {
        holder.bind(beneficiariosList.get(position),onclickItemListener,mContext);
    }

    @Override
    public int getItemCount() {
        return beneficiarios.size();
    }

    public static class ViewHolderBeneficiario extends RecyclerView.ViewHolder{

        private TextView tvName;
        private TextView tvFolio;
        private ImageView img;
        private  View view;
        private TextView tvType;

        public ViewHolderBeneficiario(View itemView) {
            super(itemView);
            initView(itemView);
        }

        public void initView(View itemView){
            tvName = itemView.findViewById(R.id.beneficiario_item_tv_name);
            tvFolio = itemView.findViewById(R.id.beneficiario_tv_folio);
            img = itemView.findViewById(R.id.beneficiario_icon);
            view = itemView.findViewById(R.id.beneficiario_line);
            tvType = itemView.findViewById(R.id.beneficiario_type);
        }

        @RequiresApi(api = Build.VERSION_CODES.M)
        public void bind(Beneficiario beneficiario, final OnclickItemListener onclickItemListener, Context mContext){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onclickItemListener.onClickItem(getAdapterPosition());
                }
            });
            tvName.setText(beneficiario.getName());
            tvFolio.setText(beneficiario.getFolio());
            if(beneficiario.isStatus()){
                img.setImageResource(R.drawable.ic_account_circle_24px);
                tvType.setBackground(mContext.getDrawable(R.drawable.beneficiario_tipo_background));
                tvType.setTextColor(mContext.getColor(R.color.colorTypeA));
                tvType.setText("A");
                view.setBackground(mContext.getDrawable(R.drawable.beneficiario_tipo_background_circle));
            }else {
                view.setBackground(mContext.getDrawable(R.drawable.beneficiario_tipo_a_background));
                tvType.setBackground(mContext.getDrawable(R.drawable.beneficiario_tipo_b_background));
                tvType.setTextColor(mContext.getColor(R.color.colorTypeB));
                tvType.setText("B");
            }
        }
    }

    public interface OnclickItemListener{
        void onClickItem(int Position);
    }
}
