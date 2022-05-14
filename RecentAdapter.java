package aligoldsmith.com.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import aligoldsmith.com.DetailsActivity;
import aligoldsmith.com.R;
import aligoldsmith.com.model.RecentsData;

public class RecentAdapter extends RecyclerView.Adapter<RecentAdapter.RecentsViewHolder> {

    Context context;
    List<RecentsData>recentsDataList;

    public RecentAdapter(Context context, List<RecentsData> recentsDataList) {
        this.context = context;
        this.recentsDataList = recentsDataList;
    }

    @NonNull
    @Override
    public RecentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.activity_recents_row_item,parent,false);
        return new RecentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentsViewHolder holder, int position) {
        holder.ring_name.setText(recentsDataList.get(position).getRing());
        holder.desc_name.setText(recentsDataList.get(position).getDesc());
        holder.price_name.setText(recentsDataList.get(position).getPrice());
        holder.ring_image.setImageResource(recentsDataList.get(position).getImagrUrl());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context, DetailsActivity.class);
                context.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return recentsDataList.size();
    }


    public static final class RecentsViewHolder extends RecyclerView.ViewHolder{

        ImageView ring_image;
        TextView ring_name,desc_name,price_name;
        public RecentsViewHolder(@NonNull View itemView) {
            super(itemView);
            ring_image=itemView.findViewById(R.id.ring_image);
            ring_name=itemView.findViewById(R.id.ring_name);
            desc_name=itemView.findViewById(R.id.desc_name);
            price_name=itemView.findViewById(R.id.price_name);


        }
    }
}