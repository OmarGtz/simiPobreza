package extrema.pobreza.simi.simipobrezaextrema.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import extrema.pobreza.simi.simipobrezaextrema.R;
import extrema.pobreza.simi.simipobrezaextrema.model.Campaing;

public class CampaingAdapter extends RecyclerView.Adapter<CampaingAdapter.CampaignViewHolder> {

    private List<Campaing> campaings;
    private Context context;
    private OnCampaingListener campaingListener;

    public CampaingAdapter(List<Campaing> campaings, Context context){
        this.campaings = campaings;
        this.context = context;
    }

    @NonNull
    @Override
    public CampaignViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.donacion_item,parent,false);
        return new CampaignViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CampaignViewHolder holder, int position) {
        holder.bind(campaings.get(position));
    }

    @Override
    public int getItemCount() {
        return campaings.size();
    }

    public static class CampaignViewHolder extends RecyclerView.ViewHolder{

        private TextView tvName;


        public CampaignViewHolder(View itemView) {
            super(itemView);
            initViews(itemView);
        }

        public void initViews(View view){
            tvName = view.findViewById(R.id.donation_item_tv_name);
        }

        public void bind(Campaing campaing){
            tvName.setText(campaing.getName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //campaingListener.onclickItem(getAdapterPosition());
                }
            });
        }
    }

    public interface OnCampaingListener{
        void onclickItem(int position);
    }
}
