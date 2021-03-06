package extrema.pobreza.simi.simipobrezaextrema.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import extrema.pobreza.simi.simipobrezaextrema.R;
import extrema.pobreza.simi.simipobrezaextrema.model.Community;

public class CommunityAdapter extends RecyclerView.Adapter<CommunityAdapter.CommunityViewHolder>{

    private List<Community> communities;
    private Context context;
    private OnCommunityListener onCommunityListener;


    public CommunityAdapter(List<Community> communities, Context context, OnCommunityListener onCommunityListener){
        this.communities = communities;
        this.context = context;
        this.onCommunityListener = onCommunityListener;
    }


    @NonNull
    @Override
    public CommunityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.community_item,parent,false);
        return new CommunityViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CommunityViewHolder holder, int position) {
        holder.bind(communities.get(position),onCommunityListener);
    }

    @Override
    public int getItemCount() {
        return communities.size();
    }

    public static class CommunityViewHolder extends RecyclerView.ViewHolder{

        private TextView tvName;

        public CommunityViewHolder(View itemView) {
            super(itemView);
            initViews(itemView);
        }

        public void initViews(View itemView){
            tvName = itemView.findViewById(R.id.comunity_item_tv_name);

        }

        public void bind(Community community, final OnCommunityListener communityListener){
            tvName.setText(community.getName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    communityListener.onClickItem(getAdapterPosition());
                }
            });
        }
    }

    public interface OnCommunityListener{
        void onClickItem(int position);
    }
}
