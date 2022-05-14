package aligoldsmith.com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import aligoldsmith.com.R;
import aligoldsmith.com.model.TopPlaceData;

public class TopPlaceesAdapter extends RecyclerView.Adapter<TopPlaceesAdapter.TopPlacesViewHolder> {

    Context context;
    List<TopPlaceData> topPlaceDataList;

    public TopPlaceesAdapter(Context context, List<TopPlaceData> topPlaceDataList) {
        this.context = context;
        this.topPlaceDataList = topPlaceDataList;
    }

    @NonNull
    @Override
    public TopPlacesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.activity_recents_row_item2,parent,false);
        return new TopPlacesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopPlacesViewHolder holder, int position) {
        holder.ring_name.setText(topPlaceDataList.get(position).getRing());
        holder.desc_name.setText(topPlaceDataList.get(position).getDesc());
        holder.price_name.setText(topPlaceDataList.get(position).getPrice());
        holder.ring_image.setImageResource(topPlaceDataList.get(position).getImagrUrl());

    }

    @Override
    public int getItemCount() {
        return topPlaceDataList.size();
    }


    public static final class TopPlacesViewHolder extends RecyclerView.ViewHolder{

        ImageView ring_image;
        TextView ring_name,desc_name,price_name;
        public TopPlacesViewHolder(@NonNull View itemView) {
            super(itemView);
            ring_image=itemView.findViewById(R.id.ring_image);
            ring_name=itemView.findViewById(R.id.ring_name);
            desc_name=itemView.findViewById(R.id.desc_name);
            price_name=itemView.findViewById(R.id.price_name);


        }
    }
}